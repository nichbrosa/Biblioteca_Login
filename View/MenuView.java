package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import br.com.login.dao.Conexao;

import java.awt.Toolkit;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;

public class MenuView extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField txtsenha;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuView frame = new MenuView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuView.class.getResource("/Imagens/farmcacia 1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		contentPane.add(menuBar);
		
		JMenu File = new JMenu("FIle");
		menuBar.add(File);
		
		txtusuario = new JTextField();
		txtusuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtusuario.setBounds(116, 82, 177, 33);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		txtsenha = new JPasswordField();
		txtsenha.setBounds(116, 148, 177, 33);
		contentPane.add(txtsenha);
		

		txtid = new JTextField();
		txtid.setText("ID");
		txtid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtid.setBounds(10, 220, 121, 33);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JButton btntestedao = new JButton("Testar Usuario DAO");
		btntestedao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				Connection conexao = new Conexao().getConnection();
				UsuarioDAO usuariodao = new UsuarioDAO(conexao);
				String usuario1 = txtusuario.getText();
				String senha1 =  new String(txtsenha.getPassword());
				
				//teste insert
				Usuario usuarioinsert = new Usuario(usuario1, senha1);
				
				
				//delete
				usuariodao.delete(usuarioselecionado);
				//teste select all
				 ArrayList<Usuario> usuarios = usuariodao.selectAll();
					
				 for(Usuario usuario : usuarios) {
					 System.out.println(usuario.getUsuario());
				 }
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			}
		});
		File.add(btntestedao);
		
		JButton btnid = new JButton("Id");
		btnid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
				Connection conexao = new Conexao().getConnection();	
			/**	UsuarioDAO usuariodao = new UsuarioDAO(conexao);
				int id1 = Integer.parseInt(txtid.getText());
				Usuario  usuario = new Usuario(id1);
				//teste select id
				Usuario usuarioselecionado = usuariodao.selectPorId(usuario);
				
				
				while (id1>0) {
					
					
					txtusuario.setText(usuario.getUsuario("usuario"));
					txtsenha.setText(usuario.getSenha("senha"));
					
					
					}
				conexao.close();**/
					String sql = "select *from login where id=?";
					
					PreparedStatement stmt = conexao.prepareStatement(sql);
					
					stmt.setString(1, txtid.getText());
					
					ResultSet rs = stmt.executeQuery();
					
					while (rs.next()) {
						
						
						txtusuario.setText(rs.getString("usuario"));
						txtsenha.setText(rs.getString("senha"));
						
						
						}
					
					rs.close();
					stmt.close();
				}catch(SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		File.add(btnid);
		
		JMenu mnNewMenu = new JMenu("Edit");
		menuBar.add(mnNewMenu);
		
		
		
	}
}
