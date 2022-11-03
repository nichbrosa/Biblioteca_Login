package View;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.login.dao.Conexao;

public class LoginController {
	private LoginView view;

	public LoginController(LoginView view) {
		super();
		this.view = view;
	}

	public void autenticar() {

		
	//buscar um usuario da vew
	String usuario = view.getTxtusuario().getText();
	String senha = view.getTxtsenha().getText();
	Usuario usuarioautenticar = new Usuario(usuario, senha);
	//verificar no banco de dados
	try {
		 Connection Conexao = new Conexao().getConnection();
		 UsuarioDAO usuariodao = new UsuarioDAO(Conexao);
		boolean existe = usuariodao.existenoBancoPorUsuarioeSenha(usuarioautenticar);
		if(existe) {
			JOptionPane.showMessageDialog(null, "Seja Bem-vindo(a) "+usuario+"!", "Aproveite!", JOptionPane.CLOSED_OPTION);
			MenuView telamenu = new MenuView();
			telamenu.setVisible(true);
			view.setVisible(false);
		}else {
			JOptionPane.showMessageDialog(null, "Usuario e senha errado ou inexistente!", "Tente Novamente!", JOptionPane.WARNING_MESSAGE);
		}
	} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}	
	//se existir direciona pra menu
			
		
		
	}
	
	
}
