package br.com.login.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class Conexao {

	/**outra opcao de caminho para conexao
	 * private String caminho ="jdbc:mysql://localhost/aplicacao";
	 * private String usuario ="root";
	 * private String senha="#Endhome10";
	 */
	public static Connection faz_conexao() throws SQLException{
		
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
		//obter conexao a partir do gerenciador de driver (entre aspas o caminho do arquivo)
		
		return DriverManager.getConnection("jdbc:mysql://localhost/aplicacao", "root", "Endhome10");
			
		} catch (ClassNotFoundException e) {
			
			throw new SQLException(e.getException());
		}
		
	}

}
