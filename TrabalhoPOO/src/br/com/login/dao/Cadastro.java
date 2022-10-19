package br.com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Cadastro {
	public void cadastro() throws SQLException{
		try {
			Connection con = Conexao.faz_conexao();
			//insire como string no my sql
			String sql = "insert into login(usuario, senha) values (?, ?)";
			//prepara pra uso
			PreparedStatement stmt = con.prepareStatement(sql);
			//executar as funções
			stmt.execute();
			//fechar as conexões
			stmt.close();
			con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	public boolean checklogin(String nome, String senha) {
		return nome.equals("") || senha.equals("");
		
	}
}
