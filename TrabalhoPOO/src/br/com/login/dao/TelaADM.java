package br.com.login.dao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaADM extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtusuario;
	private JTextField txtsenha;
	private JTextField textField;
	private JTable tbdados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaADM frame = new TelaADM();
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
	public TelaADM() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(29, 41, 34, 31);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(29, 82, 75, 31);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(29, 123, 75, 31);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblSenha);
		
		txtid = new JTextField();
		txtid.setBounds(107, 41, 192, 29);
		txtid.setEditable(false);
		txtid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(107, 83, 192, 29);
		txtusuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtusuario.setColumns(10);
		contentPane.add(txtusuario);
		
		txtsenha = new JTextField();
		txtsenha.setBounds(107, 123, 192, 29);
		txtsenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtsenha.setColumns(10);
		contentPane.add(txtsenha);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 370, 343, 80);
		panel.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
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
				if(txtusuario.getText().equals("") || txtsenha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "N??o ?? poss??vel cadastrar dados nulos!", "Tente novamente!", JOptionPane.INFORMATION_MESSAGE);
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
					//executar as fun????es
					stmt.execute();
					//fechar as conex??es
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
		btnvoltar.setBounds(231, 23, 102, 33);
		panel.add(btnvoltar);
		
		JButton btndelete = new JButton("Delete");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Valor nulo!", "Tente Novamente!", JOptionPane.INFORMATION_MESSAGE);
				}else {
					
				
				try {
					Connection con = Conexao.faz_conexao();
					
					String sql = "delete from login where id_usuario=?";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, txtid.getText());
					
					stmt.execute();
					stmt.close();
					stmt.close();
					JOptionPane.showMessageDialog(null, "Dados deletados", "Parabens!", JOptionPane.PLAIN_MESSAGE);
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				}
			}
		});
		btndelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btndelete.setBounds(117, 23, 97, 33);
		panel.add(btndelete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 453, 436, 94);
		panel_1.setBorder(new TitledBorder(null, "Abrir dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.GREEN);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(130, 30, 119, 37);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnabrir = new JButton("Abrir");
		btnabrir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnabrir.setBackground(new Color(235,235,235));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnabrir.setBackground(getBackground());
			}
		});
		btnabrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Valor nulo!", "Tente Novamente!", JOptionPane.INFORMATION_MESSAGE);
				}else {
					
				
				try {
					Connection con = Conexao.faz_conexao();
					
					String sql = "select *from login where id_usuario=?";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, textField.getText());
					
					ResultSet rs = stmt.executeQuery();
					
					while (rs.next()) {
						
						txtid.setText(rs.getString("id_usuario"));
						txtusuario.setText(rs.getString("usuario"));
						txtsenha.setText(rs.getString("senha"));
						
						
						}
					
					rs.close();
					stmt.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				}
			}
		});
		btnabrir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnabrir.setBounds(10, 28, 110, 41);
		panel_1.add(btnabrir);
		
		JButton btndados = new JButton("Listar dados");
		btndados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = Conexao.faz_conexao();
					//seleciona todos os dados
					String sql = "select *from login";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					ResultSet rs = stmt.executeQuery();
					//para passar a tabela pro programa
					DefaultTableModel modelo = (DefaultTableModel) tbdados.getModel();
					//inicia com nada
					modelo.setNumRows(0);
					
					while(rs.next()) {
						//vai passar pra tabela em ordem os valores
						modelo.addRow(new Object[] {rs.getString("id_usuario"), rs.getString("Usuario"), rs.getString("Senha")});
						
						
					}
					
					rs.close();
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btndados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btndados.setBounds(269, 30, 157, 41);
		panel_1.add(btndados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(347, 10, 436, 433);
		contentPane.add(scrollPane);
		
		tbdados = new JTable();
		tbdados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tbdados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "Usuario", "Senha"
			}
		));
		scrollPane.setViewportView(tbdados);
		
		JButton btnatualizar = new JButton("Atualizar");
		btnatualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Valor nulo!", "Tente Novamente!", JOptionPane.INFORMATION_MESSAGE);
				}else {
					
				
				try {
					Connection con = Conexao.faz_conexao();
					
					String sql = "update login set usuario=?, senha=? where id_usuario=?";	
				
					PreparedStatement stmt = con.prepareStatement(sql);
					
			
					
					stmt.setString(1, txtusuario.getText());
					stmt.setString(2, txtsenha.getText());
					stmt.setString(3, txtid.getText());
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Valor atualizado!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				}
			}
		});
		btnatualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnatualizar.setBounds(641, 483, 142, 64);
		contentPane.add(btnatualizar);
	}
}
