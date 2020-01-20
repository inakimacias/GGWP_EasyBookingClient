package gui.booking;

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
import dto.DTOVuelo;
import gui.pay.PayWindow;

import javax.swing.JTextField;



public class DataWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	public Controller controlador;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public void closeWin() {
		this.dispose();
	}
	
	public DataWindow(Controller controller, DTOVuelo vuelo) {
		
		this.controlador=controller;
		setTitle("EasyBooking");
		setResizable(false);
		setSize(680,450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton buttonAtras = new JButton("Atr\u00E1s");
		buttonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fly fly = new Fly(controlador);
				fly.setVisible(true);
				closeWin();
			}
		});
		buttonAtras.setForeground(SystemColor.activeCaption);
		buttonAtras.setForeground(new Color(0, 102, 153));
		buttonAtras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonAtras.setBounds(15, 366, 140, 30);
		contentPane.add(buttonAtras);
		
		JLabel lblSeleccionaCmoQuieres = new JLabel("Introduzca los datos de los pasajeros:");
		lblSeleccionaCmoQuieres.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblSeleccionaCmoQuieres.setBounds(43, 43, 475, 47);
		contentPane.add(lblSeleccionaCmoQuieres);
		
		JLabel lblDniPasajero = new JLabel("Dni pasajero 1:");
		lblDniPasajero.setBounds(15, 106, 122, 20);
		contentPane.add(lblDniPasajero);
		
		textField = new JTextField();
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setBounds(138, 103, 282, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDniPasajero_1 = new JLabel("Dni pasajero 2:");
		lblDniPasajero_1.setBounds(15, 145, 122, 20);
		contentPane.add(lblDniPasajero_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setColumns(10);
		textField_1.setBounds(138, 142, 282, 26);
		contentPane.add(textField_1);
		
		JLabel lblDniPasajero_2 = new JLabel("Dni pasajero 3:");
		lblDniPasajero_2.setBounds(15, 184, 122, 20);
		contentPane.add(lblDniPasajero_2);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.LIGHT_GRAY);
		textField_2.setColumns(10);
		textField_2.setBounds(138, 181, 282, 26);
		contentPane.add(textField_2);
		
		JLabel lblDniPasajero_3 = new JLabel("Dni pasajero 4:");
		lblDniPasajero_3.setBounds(15, 223, 122, 20);
		contentPane.add(lblDniPasajero_3);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.LIGHT_GRAY);
		textField_3.setColumns(10);
		textField_3.setBounds(138, 220, 282, 26);
		contentPane.add(textField_3);
		
		JLabel lblDniPasajero_4 = new JLabel("Dni pasajero 5:");
		lblDniPasajero_4.setBounds(15, 262, 122, 20);
		contentPane.add(lblDniPasajero_4);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.LIGHT_GRAY);
		textField_4.setColumns(10);
		textField_4.setBounds(138, 259, 282, 26);
		contentPane.add(textField_4);
		
		JButton buttonContinuar = new JButton("Continuar");
		buttonContinuar.setForeground(SystemColor.activeCaption);
		buttonContinuar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonContinuar.setBounds(519, 366, 140, 30);
		buttonContinuar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String nombres = "";
				if(!textField.getText().equals(null)) {
					nombres = textField.getText();
					if(!textField_1.getText().equals(null)) {
						nombres = nombres + ";" + textField_1.getText();
						if(!textField_2.getText().equals(null)) {
							nombres = nombres + ";" + textField_2.getText();
							if(!textField_3.getText().equals(null)) {
								nombres = nombres + ";" + textField_3.getText();
								if(!textField_4.getText().equals(null)) {
									nombres = nombres + ";" + textField_4.getText();
								}
							}
						}
					}
					PayWindow pay = new PayWindow(controlador,vuelo,nombres);
					pay.setVisible(true);
					closeWin();
				}
			}
		});
		contentPane.add(buttonContinuar);
	}
}
