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
/*
		Aluno aluno =new Aluno();		
		aluno.setDataNasc(Date.valueOf("1991-04-17"));
		aluno.setMedAluno(10);
		aluno.setNomAluno("Douglas");
		aluno.setNomMae("juraci");
		aluno.setNomPai("no father");
		aluno.setSitAluno("S");
		aluno.setCodAluno(2);
		aluno.excluirAluno(); */
		
		/*
		Disciplina disciplina = new Disciplina();
		 disciplina.setNomDisciplina("Matematica");
		 disciplina.setNomProfessor("Fernando");
		 disciplina.setQtdAvaliacoes(10);
		 disciplina.incluirDisciplina();*/
		 
		/* 
		Aluno aluno = new Aluno();
		aluno.setCodAluno(1);
	
		aluno.excluirAluno();*/
/*
	   Aluno aluno = new Aluno();
	   aluno.setNomAluno("Douglas");
	   aluno.setNomMae("Juraci");
	   aluno.setNomPai("Douglas");
	   aluno.setDataNasc(Date.valueOf("1991-04-17"));
	   aluno.setMedAluno(6);
	   aluno.setSitAluno("A");
	   aluno.incluirAluno();*/
		
		
		Matricula matricula = new Matricula();
		
		matricula.setCodAluno(2);
		matricula.setCodDisciplina(1);
		matricula.setDtMatricula(Date.valueOf("2021-02-16"));
		matricula.setStatusMatricula('s');
		
		matricula.incluirMatricula();
		
		
		
	}
	
}
