package View;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.login.dao.Conexao;

public class FormCadastroController {
	
	private CadastroView view;
	
	public FormCadastroController(CadastroView view) {
		this.view = view;
		
	}
	public void salvaUsuario() {
		
	
		
		String usuario1 = view.getTxtusuario().getText();
		String senha = view.getTxtsenha().getText();
		Usuario usuario = new Usuario(usuario1, senha);
		if(usuario1.isEmpty() || senha.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Valores nulos não são aceitos!", "ERROR!", JOptionPane.ERROR_MESSAGE);
		}else {
		try {
		
	 Connection Conexao = new Conexao().getConnection();
	 UsuarioDAO usuariodao = new UsuarioDAO(Conexao);
		usuariodao.insert(usuario); 
		JOptionPane.showMessageDialog(null, "Usuario Cadastrado!", "Parabens!", JOptionPane.CLOSED_OPTION);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
			}	
		}
		
	}
}
