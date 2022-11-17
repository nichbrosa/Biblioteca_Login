package br.com.login.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class Conexao {

	
	public Connection getConnection() throws SQLException{
		
		
		//obter conexao a partir do gerenciador de driver (entre aspas o caminho do arquivo)
		
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/aplicacao", "root", "");
		return conexao;	
		
		
	}

}
