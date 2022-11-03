package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField txtsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		
		LoginController controller = new LoginController(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/Imagens/farmcacia 1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 314, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(82, 47, 79, 18);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		txtusuario = new JTextField();
		txtusuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtusuario.setBounds(82, 82, 144, 31);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(82, 127, 79, 18);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblSenha);
		
		txtsenha = new JPasswordField();
		txtsenha.setBounds(82, 155, 144, 32);
		txtsenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(txtsenha);
		
		JButton btnentrar = new JButton("Entrar");
		btnentrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.autenticar();
				
			}
		});
		btnentrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnentrar.setBounds(82, 197, 144, 31);
		contentPane.add(btnentrar);
		
		JButton btncadastrar = new JButton("Cadastrar");
		btncadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroView telacadastro = new CadastroView();
				telacadastro.setVisible(true);
				setVisible(false);
			}
		});
		btncadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btncadastrar.setBounds(82, 237, 144, 31);
		contentPane.add(btncadastrar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginView.class.getResource("/Imagens/verde ciano.jpeg")));
		lblNewLabel_1.setBounds(-12, -11, 328, 322);
		contentPane.add(lblNewLabel_1);
	}

	public JTextField getTxtusuario() {
		return txtusuario;
	}

	public void setTxtusuario(JTextField txtusuario) {
		this.txtusuario = txtusuario;
	}

	public JPasswordField getTxtsenha() {
		return txtsenha;
	}

	public void setTxtsenha(JPasswordField txtsenha) {
		this.txtsenha = txtsenha;
	}
}
