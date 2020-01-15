package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class PaypalWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldMail;
	private JPasswordField passwordField;






	public void closeWin() {
		this.dispose();
		
	}


	public PaypalWindow() {

		setBackground(new Color(0, 0, 255));
		setResizable(false);
		setSize(350,450);
		setLocationRelativeTo(null);
		setTitle("Paypal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Pago Entidad Bancaria");
		lblTitulo.setBounds(5, 14, 418, 29);
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblTitulo);

		JLabel labelRegister = new JLabel("Datos de pago:");
		labelRegister.setForeground(Color.BLACK);
		labelRegister.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		labelRegister.setBounds(15, 59, 174, 29);
		contentPane.add(labelRegister);

		JLabel labelMail = new JLabel("E-mail:");
		labelMail.setForeground(new Color(0, 102, 153));
		labelMail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelMail.setBounds(52, 106, 179, 18);
		contentPane.add(labelMail);

		textFieldMail = new JTextField();
		textFieldMail.setForeground(Color.GRAY);
		textFieldMail.setFont(new Font("Tahoma", Font.ITALIC, 19));
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(52, 140, 179, 25);
		contentPane.add(textFieldMail);

		JLabel labelContrasena = new JLabel("Contrase\u00F1a:");
		labelContrasena.setForeground(new Color(0, 102, 153));
		labelContrasena.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelContrasena.setBounds(52, 182, 179, 25);
		contentPane.add(labelContrasena);

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.GRAY);
		passwordField.setBounds(52, 223, 179, 29);
		contentPane.add(passwordField);

		JButton btnPagar = new JButton("Pagar");

		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				

			}
		});
		btnPagar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnPagar.setForeground(new Color(0, 102, 153));
		btnPagar.setBounds(52, 306, 128, 29);
		contentPane.add(btnPagar);

		JButton buttonAtras = new JButton("Atras");
		buttonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			PayWindow pay = new PayWindow();
			pay.setVisible(true);
				closeWin();
			}
		});
		buttonAtras.setForeground(new Color(0, 102, 153));
		buttonAtras.setFont(new Font("Tahoma", Font.PLAIN, 19));
		buttonAtras.setBounds(200, 306, 115, 29);
		contentPane.add(buttonAtras);
	}
}
