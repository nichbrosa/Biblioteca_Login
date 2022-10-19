package br.com.login.dao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtusuario;
	private JTextField txtsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(29, 41, 34, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(29, 82, 75, 31);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSenha.setBounds(29, 123, 75, 31);
		contentPane.add(lblSenha);
		
		txtid = new JTextField();
		txtid.setEditable(false);
		txtid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtid.setBounds(107, 41, 192, 29);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtusuario = new JTextField();
		txtusuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtusuario.setColumns(10);
		txtusuario.setBounds(107, 82, 192, 29);
		contentPane.add(txtusuario);
		
		txtsenha = new JTextField();
		txtsenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtsenha.setColumns(10);
		txtsenha.setBounds(107, 123, 192, 29);
		contentPane.add(txtsenha);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 175, 436, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnsalvar = new JButton("Salvar");
		btnsalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnsalvar.setBackground(new Color(235,235,235));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnsalvar.setBackground(getBackground());
			}
		});
		btnsalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//se algum txt não tiver nada ele mostra uma mensagem de erro
				if(txtusuario.getText().equals("") || txtsenha.getText().equals("")) {
					btnsalvar.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Não é possível cadastrar dados nulos!", "Tente novamente!", JOptionPane.INFORMATION_MESSAGE);
					btnsalvar.setBackground(getBackground());
				}else {
				try {
					Connection con = Conexao.faz_conexao();
					//insire como string no my sql
					String sql = "insert into login(usuario, senha) values (?, ?)";
					//prepara pra uso
					PreparedStatement stmt = con.prepareStatement(sql);
					
					//pega as string de dentro do txt e envia pro mysql
					stmt.setString(1, txtusuario.getText());
					stmt.setString(2, txtsenha.getText());
					//executar as funções
					stmt.execute();
					//fechar as conexões
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Dados cadastrados!", "Bem-vindo ao nossa rede!", JOptionPane.INFORMATION_MESSAGE);
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					}
				}
			}
		});
		btnsalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnsalvar.setBounds(10, 23, 97, 33);
		panel.add(btnsalvar);
		
		JButton btnvoltar = new JButton("Voltar");
		btnvoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnvoltar.setBackground(new Color(235,235,235));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnvoltar.setBackground(getBackground());
			}
		});
		btnvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAcessoTeste acesso = new TelaAcessoTeste();
				acesso.setVisible(true);
				setVisible(false);
			}
		});
		btnvoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnvoltar.setBounds(329, 23, 97, 33);
		panel.add(btnvoltar);
	}
}
