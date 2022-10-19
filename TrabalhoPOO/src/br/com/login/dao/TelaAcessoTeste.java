package br.com.login.dao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class TelaAcessoTeste extends JFrame {

	private JPanel contentPane;
	private JTextField txtlogin;
	private JPanel panel;
	private JPasswordField txtsenha;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAcessoTeste frame = new TelaAcessoTeste();
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
	public TelaAcessoTeste() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 383, 92);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Seja Bem-Vindo(a)!");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(29, 25, 302, 41);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(-4, -39, 428, 191);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(TelaAcessoTeste.class.getResource("/Imagens/ground.jpg")));
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaADM adm = new TelaADM();
				adm.setVisible(true);
				setVisible(false);
			}
		});
		lblNewLabel_6.setBounds(1, 0, 45, 13);
		panel.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 90, 511, 433);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtsenha = new JPasswordField();
		txtsenha.setFont(new Font("SansSerif", Font.PLAIN, 30));
		txtsenha.setBounds(70, 173, 272, 28);
		panel_1.add(txtsenha);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setForeground(Color.BLACK);
		lblSenha.setBounds(70, 136, 62, 25);
		panel_1.add(lblSenha);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnlogin = new JButton("Entrar");
		btnlogin.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyPressed(KeyEvent e) {
				if(txtlogin.getText().equals("Admin") && txtsenha.getText().equals("")) {
					TelaADM adm = new TelaADM();
					adm.setVisible(true);
					setVisible(false);
					//se um dos txt no programa for nulo o mesmo nao vai progredir 
				}else if(txtlogin.getText().equals("") || txtsenha.getText().equals("")) {
					btnlogin.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Dados invalidos", "Tente novamente", JOptionPane.WARNING_MESSAGE);
					btnlogin.setBackground(getBackground());
				}else {
				try {
					Connection con = Conexao.faz_conexao();
					//PUXA DADOS DO MYSQL
					String sql = "select *from login where usuario=? and senha=?";
					//envia dados ao mysql, preparação de declaração 
					PreparedStatement stmt = con.prepareStatement(sql);
					//pega os dados dos txt e manda pro mySql
					stmt.setString(1, txtlogin.getText());
					//pode usar get text normal, mas assim fica mais bonito
					stmt.setString(2, new String(txtsenha.getPassword()));
					/*conjunto de resultados se existe no banco de dados ou nao(executequery consulta a exiostencia do valor se existe)
					resultado fica gravado no rs*/
					ResultSet rs = stmt.executeQuery();
					
			
					JOptionPane.showMessageDialog(null, "Bem vindo ao sistema!", "Parabens!", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					//fechar conexao com o banco (por medidas de segurança
					stmt.close();
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}	
				}
			}
		});
		btnlogin.setBounds(38, 227, 284, 45);
		panel_1.add(btnlogin);
		btnlogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnlogin.setBackground(new Color(235,235,235));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnlogin.setBackground(getBackground());
			}
		});
		btnlogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if(txtlogin.getText().equals("Admin") && txtsenha.getText().equals("")) {
					TelaADM adm = new TelaADM();
					adm.setVisible(true);
					setVisible(false);
					//se um dos txt no programa for nulo o mesmo nao vai progredir 
				}else if(txtlogin.getText().equals("") || txtsenha.getText().equals("")) {
					btnlogin.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Dados invalidos", "Tente novamente", JOptionPane.WARNING_MESSAGE);
					btnlogin.setBackground(getBackground());
				}else {
				try {
					Connection con = Conexao.faz_conexao();
					//PUXA DADOS DO MYSQL
					String sql = "select *from login where usuario=? and senha=?";
					//envia dados ao mysql, preparação de declaração 
					PreparedStatement stmt = con.prepareStatement(sql);
					//pega os dados dos txt e manda pro mySql
					stmt.setString(1, txtlogin.getText());
					//pode usar get text normal, mas assim fica mais bonito
					stmt.setString(2, new String(txtsenha.getPassword()));
					/*conjunto de resultados se existe no banco de dados ou nao(executequery consulta a exiostencia do valor se existe)
					resultado fica gravado no rs*/
					ResultSet rs = stmt.executeQuery();
					
						JOptionPane.showMessageDialog(null, "Bem vindo ao sistema!", "Parabens!", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					//fechar conexao com o banco (por medidas de segurança
					stmt.close();
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}	
				}
			}
		});
		btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		txtlogin = new JTextField();
		txtlogin.setBounds(70, 93, 262, 31);
		panel_1.add(txtlogin);
		txtlogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtlogin.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(TelaAcessoTeste.class.getResource("/Imagens/login3.png")));
		lblNewLabel_5.setBounds(15, 65, 50, 61);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setBounds(70, 63, 62, 25);
		panel_1.add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaAcessoTeste.class.getResource("/Imagens/senha4.png")));
		lblNewLabel.setBounds(15, 145, 62, 65);
		panel_1.add(lblNewLabel);
		
		JButton btncadastro = new JButton("Cadastrar");
		btncadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btncadastro.setBackground(new Color(235,235,235));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btncadastro.setBackground(getBackground());
			}
		});
		btncadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro cadastro = new TelaCadastro();
				cadastro.setVisible(true);
				setVisible(false);
			}
		});
		btncadastro.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btncadastro.setBounds(38, 282, 284, 45);
		panel_1.add(btncadastro);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaAcessoTeste.class.getResource("/Imagens/1234.png")));
		lblNewLabel_2.setBounds(0, 0, 484, 434);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(48, 308, 85, 21);
		panel_1.add(btnNewButton);
	}
}