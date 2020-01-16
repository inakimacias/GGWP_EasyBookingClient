package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;

public class Fly extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		setResizable(false);
		setSize(805,500);
		setLocationRelativeTo(null);
		

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 193, 761, 200);
		contentPane.add(scrollPane);
		
		String header[] = {"IDVuelo", "Origen", "Destino", "F. Salida", "F. Llegada", "Precio", "A. Vacantes", "Aerolinea"};
		 String data[][] = { { "1", "Bilbao", "Madrid", "16/01/2020", "17/01/2020", "100", "50", "AirFrance" },
		             };
		table = new JTable(data,header);
		table.setBackground(Color.LIGHT_GRAY);
		table.setBounds(15, 193, 761, 200);
		
//		scrollPane.add(table);
		
		
		  
		for(int i=0;i<table.getColumnCount();i++)
		{
		TableColumn column1 = table.getTableHeader().getColumnModel().getColumn(i);
		  
		column1.setHeaderValue(header[i]);
		} 
		
		scrollPane.setViewportView(table);
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
		
		JButton btnReserva = new JButton("Reserva y pago");
		btnReserva.setBounds(295, 395, 160, 29);
		btnReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int columns = table.getColumnCount();
		        String s = "";
		        for(int col = 0; col < columns; col++)
		        {
		            Object o = table.getValueAt(table.getSelectedRow(), col);
		            s += o.toString();
		            if(col < columns - 1)
		                s += ", ";
		        }
		        System.out.println(s);
				
				
			}

			
		});
		contentPane.add(btnReserva);
		
	}
}
