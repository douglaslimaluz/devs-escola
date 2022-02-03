package classes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Util.Conexao;

/**
 * @author +DEVS2BLU
 */
public class Aluno {
    private int codAluno;
    private String nomAluno;
    private String nomMae;
    private String nomPai;
    private Date dataNasc;
    private double medAluno;
    private String sitAluno;
    
    
    
    
    

    public int getCodAluno() {
		return codAluno;
	}

	public void setCodAluno(int codAluno) {
		this.codAluno = codAluno;
	}

	public String getNomAluno() {
		return nomAluno;
	}

	public void setNomAluno(String nomAluno) {
		this.nomAluno = nomAluno;
	}

	public String getNomMae() {
		return nomMae;
	}

	public void setNomMae(String nomMae) {
		this.nomMae = nomMae;
	}

	public String getNomPai() {
		return nomPai;
	}

	public void setNomPai(String nomPai) {
		this.nomPai = nomPai;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public double getMedAluno() {
		return medAluno;
	}

	public void setMedAluno(double medAluno) {
		this.medAluno = medAluno;
	}

	public String getSitAluno() {
		return sitAluno;
	}

	public void setSitAluno(String sitAluno) {
		this.sitAluno = sitAluno;
	}

	/**
     * 
     */
    public boolean incluirAluno() {
    	
		Connection con = Conexao.conectar();		
		String sql = "insert into aluno(nomAluno, nomMae,"
				+ " nomPai, dataNasc, medAluno, sitAluno) values(?,?,?,?,?,?)";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, this.nomAluno);
			stm.setString(2, this.nomMae);
			stm.setString(3, this.nomPai);
			stm.setDate(4, this.dataNasc);
			stm.setDouble(5, this.medAluno);	
			stm.setString(6, this.sitAluno);					
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}        	
    	
  
    	
        
        
        return true;
    }

    /**
     * 
     */
    public void alterarAluno() {

        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;
        
        try {
            String sql = "UPDATE aluno SET "
                    + "nomaluno=?, "
                    + "nommae=?, "
                    + "nompai=?, "                    
                    + "datanasc=?, "
                    + "medaluno=?, "
                    + "sitaluno=? "
                    + "WHERE codaluno=?";
            pstm = connection.prepareStatement(sql);
            
            pstm.setString(1, this.nomAluno);
            pstm.setString(2, this.nomMae);
            pstm.setString(3, this.nomPai);
            pstm.setDate(4, this.dataNasc);           
            pstm.setDouble(5, this.medAluno);  
            pstm.setString(6, this.sitAluno);              
            pstm.setInt(7, this.codAluno);
            
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso",
                    "Informação Sistema",JOptionPane.INFORMATION_MESSAGE);            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados de conta"
                    + " no banco","Erro",
                    JOptionPane.ERROR_MESSAGE);   
        }    	
    	
    	
    	
    }

    /**
     * 
     */
    public void excluirAluno() {

        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;
        
        try {
            String sql = "DELETE FROM aluno WHERE codaluno=?";
            pstm = connection.prepareStatement(sql);
            
            pstm.setInt(1, this.codAluno);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Removido com Sucesso",
                    "Informação Sistema",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException erro) {            
            JOptionPane.showMessageDialog(null,"Erro ao Deleta conta no banco",
                    "Erro",JOptionPane.ERROR_MESSAGE); 
        }    	
    	
    	
    }

    /**
     * 
     */
    public List<Aluno> consultarAluno(Integer codAluno) {
      
    	
    	 List<Aluno> alunos = new ArrayList<>();
         Connection  connection = Conexao.conectar();
         PreparedStatement  pstm =null;
         ResultSet resultSet = null;
         
         try {
             String sql = "SELECT *FROM despesa WHERE codaluno=?;";
             pstm = connection.prepareStatement(sql);
             pstm.setInt(1, this.codAluno);
             resultSet = pstm.executeQuery();
             
             while (resultSet.next()) { 
                 
                Aluno objAluno = new Aluno();
                 objAluno.setCodAluno(resultSet.getInt("codAluno"));
                 objAluno.setDataNasc(resultSet.getDate("datanasc"));
                 objAluno.setMedAluno(resultSet.getDouble("medAluno"));                                
                 objAluno.setNomAluno(resultSet.getNString("nomAluno"));
                 objAluno.setNomMae(resultSet.getString("nomMae"));   
                 objAluno.setNomPai(resultSet.getNString("sitAluno")); 
                               
                 alunos.add(objAluno);         
             }
         } catch (SQLException erro) {            
             JOptionPane.showMessageDialog(null,"Erro de Leitura do Banco",
                     "Erro",JOptionPane.ERROR_MESSAGE); 
         }  
        
         
         return alunos;
    	
    	
    }

    /**
     * 
     */
    public List<Aluno>listarAlunos() {

        List<Aluno> aluno = new ArrayList<>();
        Connection  connection = Conexao.conectar();
        PreparedStatement  pstm =null;
        ResultSet resultSet = null;
        
        try {
            String sql = "SELECT *FROM aluno;";
            pstm = connection.prepareStatement(sql);    
            resultSet = pstm.executeQuery();
            
            while (resultSet.next()) { 
                
                Aluno objAluno = new Aluno();
                objAluno.setNomAluno(resultSet.getString("nomaluno"));             
                
                
                aluno.add(objAluno);         
            }
        } catch (SQLException erro) {            
            JOptionPane.showMessageDialog(null,"Erro de Leitura do Banco",
                    "Erro",JOptionPane.ERROR_MESSAGE); 
        }  	
		System.out.println(aluno);
        return aluno;
        
		
    	
    }

	@Override
	public String toString() {
		
		
		return nomAluno;
		//return "Aluno [codAluno=" + codAluno + ", nomAluno=" + nomAluno + ", nomMae=" + nomMae + ", nomPai=" + nomPai
		//		+ ", dataNasc=" + dataNasc + ", medAluno=" + medAluno + ", sitAluno=" + sitAluno + "]";
	}
    
    
    
    
    

}