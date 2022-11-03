package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.login.dao.Conexao;

import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CadastroView extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JTextField txtid;
	private JPasswordField txtsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroView frame = new CadastroView();
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
	public CadastroView() {
		
		FormCadastroController Controller = new FormCadastroController(this);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroView.class.getResource("/Imagens/farmcacia 1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 181, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtusuario = new JTextField();
		txtusuario.setColumns(10);
		txtusuario.setBounds(10, 124, 138, 26);
		contentPane.add(txtusuario);
		
		txtid = new JTextField();
		txtid.setEditable(false);
		txtid.setColumns(10);
		txtid.setBounds(10, 54, 52, 26);
		contentPane.add(txtid);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 20, 29, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(10, 90, 66, 24);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSenha.setBounds(10, 160, 66, 24);
		contentPane.add(lblSenha);
		
		JButton btnsalvar = new JButton("Salvar");
		btnsalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Controller.salvaUsuario();
				
			}
		});
		btnsalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnsalvar.setBounds(10, 230, 138, 33);
		contentPane.add(btnsalvar);
		
		txtsenha = new JPasswordField();
		txtsenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtsenha.setBounds(10, 194, 138, 26);
		contentPane.add(txtsenha);
	}

	public JTextField getTxtusuario() {
		return txtusuario;
	}

	public void setTxtusuario(JTextField txtusuario) {
		this.txtusuario = txtusuario;
	}

	public JTextField getTxtid() {
		return txtid;
	}

	public void setTxtid(JTextField txtid) {
		this.txtid = txtid;
	}

	public JPasswordField getTxtsenha() {
		return txtsenha;
	}

	public void setTxtsenha(JPasswordField txtsenha) {
		this.txtsenha = txtsenha;
	}
}
