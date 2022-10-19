import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField txtproduto;
	private JButton btnvoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProdutos frame = new TelaProdutos();
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
	public TelaProdutos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Produto:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(41, 96, 89, 25);
		contentPane.add(lblNewLabel);
		
		txtproduto = new JTextField();
		txtproduto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtproduto.setBounds(121, 96, 147, 26);
		contentPane.add(txtproduto);
		txtproduto.setColumns(10);
		
		JButton btnpedir = new JButton("Pedir");
		btnpedir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnpedir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnpedir.setBounds(124, 152, 123, 46);
		contentPane.add(btnpedir);
		
		btnvoltar = new JButton("Voltar");
		btnvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Login login = new Tela_Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnvoltar.setBounds(0, 228, 97, 25);
		contentPane.add(btnvoltar);
	}

}
