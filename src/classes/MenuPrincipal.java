package classes;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import Util.Conexao;

public class MenuPrincipal {

	public static void main(String[] args) {
		
		Connection con;
		if(Conexao.conectar()!= null) {
			System.out.println("MysQL conectado com sucesso!");
			

		}

		/*Aluno aluno =new Aluno();		
		aluno.setDataNasc(Date.valueOf("1991-04-17"));
		aluno.setMedAluno(10);
		aluno.setNomAluno("Douglas");
		aluno.setNomMae("juraci");
		aluno.setNomPai("no father");
		aluno.setSitAluno("S");
		aluno.setCodAluno(2);
		aluno.excluirAluno();*/
		
		
		

		
	}

}
