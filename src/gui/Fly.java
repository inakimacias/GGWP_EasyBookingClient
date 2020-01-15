package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Fly extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fly frame = new Fly();
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
	public Fly() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 495);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		table.setBounds(15, 193, 761, 200);
		contentPane.add(table);
		
		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDestino.setBounds(408, 91, 88, 32);
		contentPane.add(lblDestino);
		
		textField = new JTextField();
		textField.setBounds(500, 96, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel labelOri = new JLabel("Origen:");
		labelOri.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelOri.setBounds(36, 91, 88, 32);
		contentPane.add(labelOri);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(112, 96, 146, 26);
		contentPane.add(textField_1);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(531, 148, 115, 29);
		contentPane.add(btnBuscar);
		
		JButton btnReserva = new JButton("Reserva");
		btnReserva.setBounds(320, 394, 115, 29);
		contentPane.add(btnReserva);
	}
}
