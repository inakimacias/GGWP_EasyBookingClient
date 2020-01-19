package gui.register;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import controller.Controller;
import gui.InitialWindow;

public class RegisterWindowGoogle extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	private Controller controlador;

	public void closeWin() {
		this.dispose();
	}


	public RegisterWindowGoogle() {

		setBackground(new Color(0, 0, 255));
		setSize(350,450);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("RegistroGoogle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Registro Google");
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

		textFieldUsuario = new JTextField();
		textFieldUsuario.setForeground(Color.GRAY);
		textFieldUsuario.setFont(new Font("Tahoma", Font.ITALIC, 19));
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(52, 140, 179, 25);
		contentPane.add(textFieldUsuario);

		JLabel labelContrasena = new JLabel("Contrasena:");
		labelContrasena.setForeground(new Color(0, 102, 153));
		labelContrasena.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelContrasena.setBounds(52, 182, 179, 25);
		contentPane.add(labelContrasena);

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.GRAY);
		passwordField.setBounds(52, 223, 179, 29);
		contentPane.add(passwordField);

		JButton btnRegister = new JButton("Registrarse");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = new StringBuilder().append(passwordField.getPassword()).toString();
				
				if(controlador.registarse(textFieldUsuario.getText(), password, "google")) {
					JOptionPane.showMessageDialog(new Frame(), "Registrado con exito");
					InitialWindow main = new InitialWindow(controlador);
					main.setVisible(true);
					closeWin();
				} else {
					JOptionPane.showMessageDialog(new Frame(), "Registrado fallido");
				}

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
