package View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

import br.com.login.dao.Conexao;

public class UsuarioDAO {
	
	private final Connection connection;

	public UsuarioDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public Usuario insert(Usuario usuario) throws SQLException {
		
			String sql = "insert into login(usuario, senha) values(?, ?); ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getUsuario());
			statement.setString(2, usuario.getSenha());
			statement.execute();
			return usuario;
			
				
	}

	public void update(Usuario usuario) throws SQLException {
		String sql = "update login set usuario =?, senha=? where id=?  ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, usuario.getUsuario());
		statement.setString(2, usuario.getSenha());
		statement.setInt(3, usuario.getId());
		statement.execute();
	}
	
	public void insertOrUpdate(Usuario usuario) throws SQLException {
		if(usuario.getId()>0) {
			update(usuario);
		}else {
			insert(usuario);
		}
	}
	
	public void delete(Usuario usuario) throws SQLException{
		String sql = "delete from login where id=?  ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, usuario.getId());
		statement.execute();
	}
	//criar uma lista
	public ArrayList<Usuario> selectAll() throws SQLException{
		String sql = "select*from login";
		PreparedStatement statement = connection.prepareStatement(sql);
		return pesquisa(statement);	
	}	
		//cria lista, executa, coloca o resultado no result set e faz linha por linha
		
	private	ArrayList<Usuario> pesquisa(PreparedStatement statement) throws SQLException{
		ArrayList<Usuario> usuarios = new 	ArrayList<Usuario>();
		statement.execute();
		ResultSet rs = statement.getResultSet();
	    while(rs.next()) {
	    	int id = rs.getInt("id");
	    	String usuario = rs.getString("usuario");
	    	String senha = rs.getString("senha");
	    	
	    	Usuario usuarioComDadosDoBanco = new Usuario(id, usuario, senha);
	    	usuarios.add(usuarioComDadosDoBanco);
	    }
	    return usuarios;
	}
		
	    

	
	public Usuario selectPorId(Usuario usuario) throws SQLException {
		String sql = "select*from login where id=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, usuario.getId());
		
		return pesquisa(statement).get(0);
		
	}
	
	public boolean existenoBancoPorUsuarioeSenha(Usuario usuario) throws SQLException {
		String sql = "select*from login where usuario=? and senha=? ;";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, usuario.getUsuario());
		statement.setString(2, usuario.getSenha());
	    statement.execute();  
	    ResultSet rs = statement.getResultSet();
	    
	    return rs.next();	}
	
	
}
