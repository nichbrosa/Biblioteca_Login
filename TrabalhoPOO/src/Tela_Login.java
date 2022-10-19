import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Tela_Login extends JFrame {

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
					Tela_Login frame = new Tela_Login();
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
	public Tela_Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 6, 369, 86);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Seja Bem-Vindo(a)!");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(29, 25, 302, 41);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(-4, 43, 50, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(-4, -18, 428, 170);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(Tela_Login.class.getResource("/Imagens/ground.jpg")));
		
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
			@Override
			public void keyPressed(KeyEvent e) {
				if(checklogin(txtlogin.getText(), txtsenha.getText())) {
					TelaProdutos Produto = new TelaProdutos();
					Produto.setVisible(true);
					dispose();
					JOptionPane.showMessageDialog(null, "Bem vindo ao sistema!", "Parabens!", JOptionPane.INFORMATION_MESSAGE);
				}else {
					btnlogin.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Dados invalidos", "Tente novamente", JOptionPane.WARNING_MESSAGE);
					btnlogin.setBackground(getBackground());

	;
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
			public void actionPerformed(ActionEvent e) {
			
				if(checklogin(txtlogin.getText(), txtsenha.getText())) {
				TelaProdutos Produto = new TelaProdutos();
				Produto.setVisible(true);
				dispose();
				JOptionPane.showMessageDialog(null, "Bem vindo ao sistema!", "Parabens!", JOptionPane.INFORMATION_MESSAGE);
			}else {
				btnlogin.setBackground(Color.RED);
				JOptionPane.showMessageDialog(null, "Dados invalidos", "Tente novamente", JOptionPane.WARNING_MESSAGE);
				btnlogin.setBackground(getBackground());

;
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
		lblNewLabel_5.setIcon(new ImageIcon(Tela_Login.class.getResource("/Imagens/login3.png")));
		lblNewLabel_5.setBounds(15, 65, 50, 61);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setBounds(70, 63, 62, 25);
		panel_1.add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Tela_Login.class.getResource("/Imagens/senha4.png")));
		lblNewLabel.setBounds(15, 145, 62, 65);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Tela_Login.class.getResource("/Imagens/1234.png")));
		lblNewLabel_2.setBounds(0, 0, 484, 434);
		panel_1.add(lblNewLabel_2);
	}
	public boolean checklogin(String nome, String senha) {
		return nome.equals("Nicholas") && senha.equals("123") || nome.equals("Admin") && senha.equals("");
	}
}
