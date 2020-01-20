package gui.login;
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
import gui.booking.Fly;

public class LoginWindowGoogle extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDNI;
	private JPasswordField passwordField;
	public Controller controlador;

	public void closeWin() {
		this.dispose();	
	}

	public LoginWindowGoogle(Controller controller) {

		this.controlador=controller;
		setBackground(new Color(0, 0, 255));
		setResizable(false);
		setSize(350,450);
		setLocationRelativeTo(null);
		setTitle("EasyBooking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEasyBooking = new JLabel("Acceso Google");
		lblEasyBooking.setBounds(5, 14, 418, 29);
		lblEasyBooking.setForeground(Color.BLACK);
		lblEasyBooking.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblEasyBooking);

		JLabel labelIniciaSesion = new JLabel("Login:");
		labelIniciaSesion.setForeground(Color.BLACK);
		labelIniciaSesion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		labelIniciaSesion.setBounds(15, 59, 174, 29);
		contentPane.add(labelIniciaSesion);

		JLabel labelDNI = new JLabel("Usuario:");
		labelDNI.setForeground(new Color(0, 102, 153));
		labelDNI.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelDNI.setBounds(52, 106, 128, 18);
		contentPane.add(labelDNI);

		textFieldDNI = new JTextField();
		textFieldDNI.setForeground(Color.GRAY);
		textFieldDNI.setFont(new Font("Tahoma", Font.ITALIC, 19));
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(52, 140, 179, 25);
		contentPane.add(textFieldDNI);

		JLabel labelContraseña = new JLabel("Contrase\u00F1a:");
		labelContraseña.setForeground(new Color(0, 102, 153));
		labelContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelContraseña.setBounds(52, 182, 179, 25);
		contentPane.add(labelContraseña);

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.GRAY);
		passwordField.setBounds(52, 223, 179, 29);
		contentPane.add(passwordField);

		JButton btnEntrar = new JButton("Entrar");

		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = new StringBuilder().append(passwordField.getPassword()).toString();
				controlador.setUsuario(controlador.login(textFieldDNI.getText(), password, "google"));

				if(controlador.getUsuario() != null) {
					Fly main = new Fly(controlador);
					main.setVisible(true);
					closeWin();
				}else{
					JOptionPane.showMessageDialog(new Frame(), "Usuario no valido");
				}
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnEntrar.setForeground(new Color(0, 102, 153));
		btnEntrar.setBounds(52, 306, 115, 29);
		contentPane.add(btnEntrar);

		JButton buttonAtras = new JButton("Atras");
		buttonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginWindow log = new LoginWindow(controlador);
				log.setVisible(true);
				closeWin();
			}
		});
		buttonAtras.setForeground(new Color(0, 102, 153));
		buttonAtras.setFont(new Font("Tahoma", Font.PLAIN, 19));
		buttonAtras.setBounds(200, 306, 115, 29);
		contentPane.add(buttonAtras);
	}
}
