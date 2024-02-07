package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String USERNAME = "root" ;
	
	private static final String PASSWORD = "zubat43666@" ;
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda" ;
	
	/*
	* conexao com banco de dados
	* */
	
	public static Connection conectar() throws Exception {
		//classe carregada pela jvm
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
		
	}
	
	public static void main(String[] args) throws Exception {
		
		//recupera a conexao 
		Connection con = conectar();
		if(con != null) {
			System.out.println("Conexao obtida com sucesso");
			con.close();
		}
	}
	
	
	
	
}
