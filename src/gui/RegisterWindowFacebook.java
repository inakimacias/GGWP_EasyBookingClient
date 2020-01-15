package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.border.LineBorder;

public class RegisterWindowFacebook extends JFrame {

	private JPanel contentPane;
	private JTextField textFielUsuario;
	private JPasswordField passwordField;






	public void closeWin() {
		this.dispose();
		
	}


	public RegisterWindowFacebook() {


//		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
		setBackground(new Color(0, 0, 255));
		this.setUndecorated(true); // Ventana sin marcos de java predefinidos
		setTitle("RegistroFacebook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 347);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Registro Facebook");
		lblTitulo.setBounds(5, 14, 418, 29);
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblTitulo);

		JLabel labelRegister = new JLabel("Register:");
		labelRegister.setForeground(Color.BLACK);
		labelRegister.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		labelRegister.setBounds(15, 59, 174, 29);
		contentPane.add(labelRegister);

		JLabel labelUsuario = new JLabel("Usuario:");
		labelUsuario.setForeground(new Color(0, 102, 153));
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelUsuario.setBounds(52, 106, 128, 18);
		contentPane.add(labelUsuario);

		textFielUsuario = new JTextField();
		textFielUsuario.setForeground(Color.GRAY);
		textFielUsuario.setFont(new Font("Tahoma", Font.ITALIC, 19));
		textFielUsuario.setColumns(10);
		textFielUsuario.setBounds(52, 140, 179, 25);
		contentPane.add(textFielUsuario);

		JLabel labelContrasena = new JLabel("Contrase\u00F1a:");
		labelContrasena.setForeground(new Color(0, 102, 153));
		labelContrasena.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelContrasena.setBounds(52, 182, 179, 25);
		contentPane.add(labelContrasena);

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.GRAY);
		passwordField.setBounds(52, 223, 179, 29);
		contentPane.add(passwordField);

		JButton btnRegister = new JButton("Registrarse");
//		btnEntrar.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				
//			}
//		});
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				

			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnRegister.setForeground(new Color(0, 102, 153));
		btnRegister.setBounds(52, 306, 128, 29);
		contentPane.add(btnRegister);

		JButton buttonAtras = new JButton("Atras");
		buttonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			RegisterWindow reg = new RegisterWindow();
			reg.setVisible(true);
				closeWin();
			}
		});
		buttonAtras.setForeground(new Color(0, 102, 153));
		buttonAtras.setFont(new Font("Tahoma", Font.PLAIN, 19));
		buttonAtras.setBounds(200, 306, 115, 29);
		contentPane.add(buttonAtras);
	}
}
