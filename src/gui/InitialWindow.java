package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import gui.login.LoginWindow;
import gui.register.RegisterWindow;

public class InitialWindow extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controlador = null;

	public void closeWin() {
		this.dispose();		
	}
	
	public InitialWindow(Controller controller) {
		this.controlador = controller;
		initComponents();	
		this.setVisible(true);
	}
	
	public void initComponents() {

		setTitle("EasyBooking");
		setResizable(false);
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEasyBooking = new JLabel("Bienvenido a EasyBooking");
		lblEasyBooking.setBounds(5, 14, 418, 29);
		lblEasyBooking.setForeground(Color.BLACK);
		lblEasyBooking.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblEasyBooking);

		JButton buttonEntrar = new JButton("Entrar");
		buttonEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginWindow log = new LoginWindow(controlador);
				log.setVisible(true);
				closeWin();
			}

		});
		buttonEntrar.setForeground(SystemColor.activeCaption);
		buttonEntrar.setForeground(new Color(0, 102, 153));
		buttonEntrar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		buttonEntrar.setBounds(71, 230, 200, 40);
		contentPane.add(buttonEntrar);


		JButton buttonRegistrarse = new JButton("Registarse");
		buttonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterWindow reg = new RegisterWindow(controlador);
				reg.setVisible(true);
				closeWin();
			}
		});
		buttonRegistrarse.setForeground(SystemColor.activeCaption);
		buttonRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 30));
		buttonRegistrarse.setBounds(306, 230, 200, 40);
		contentPane.add(buttonRegistrarse);

		JLabel lblSeleccionaCmoQuieres = new JLabel("Seleccione la acci\u00F3n que desee realizar:");
		lblSeleccionaCmoQuieres.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblSeleccionaCmoQuieres.setBounds(40, 134, 500, 47);
		contentPane.add(lblSeleccionaCmoQuieres);

	}
	
}
