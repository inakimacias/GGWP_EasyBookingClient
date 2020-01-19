package gui.booking;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import dto.DTOUsuario;
import dto.DTOVuelo;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
	private JTextField textDestino;
	private JTextField textOrigen;
	public Controller controlador;
	private DefaultTableModel modelo = new DefaultTableModel();
	
	

	/**
	 * Launch the application.
	 */
	public void closeWin() {
		this.dispose();
	}

	/**
	 * Create the frame.
	 */
	public Fly(DTOUsuario usuario,String tipo) {
		
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
		
        table = new JTable();
        table.setModel(new DefaultTableModel(
        		new Object[][] {
        			
        		}, new String[] {
        				"IDVuelo", "Origen", "Destino", "F. Salida", "F. Llegada", "Precio", "A. Vacantes", "Aerolinea"
        		}
        		));
        
        table.setBackground(Color.LIGHT_GRAY);
        table.setBounds(15, 193, 761, 200);
//		scrollPane.add(table);
		
		
		scrollPane.setViewportView(table);
		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDestino.setBounds(408, 91, 88, 32);
		contentPane.add(lblDestino);
		
		textDestino = new JTextField();
		textDestino.setBounds(500, 96, 146, 26);
		contentPane.add(textDestino);
		textDestino.setColumns(10);
		
		JLabel labelOri = new JLabel("Origen:");
		labelOri.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelOri.setBounds(36, 91, 88, 32);
		contentPane.add(labelOri);
		
		textOrigen = new JTextField();
		textOrigen.setColumns(10);
		textOrigen.setBounds(112, 96, 146, 26);
		contentPane.add(textOrigen);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(531, 148, 115, 29);
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				borrarTabla();
				List<DTOVuelo> vuelos = new ArrayList<>();
				
//				vuelos = controlador.buscarVuelo(textOrigen.getText(), textDestino.getText());
//				DTOVuelo vueloPrueba1 = new DTOVuelo();
//				vueloPrueba1.setIdVuelo("123");
//				vueloPrueba1.setAeropuertoDestino("Madrid");
//				vueloPrueba1.setAeropuertoOrigen("Bilbao");
//				vueloPrueba1.setSalidaFecha("16/01/2020");
//				vueloPrueba1.setLlegadaFecha("20/01/2020");
//				vueloPrueba1.setPrecio(90);
//				vueloPrueba1.setAsientosVacantes(50);
//				vueloPrueba1.setAerolinea("Iberia");
//				
//				DTOVuelo vueloPrueba2 = new DTOVuelo();
//				vueloPrueba2.setIdVuelo("152");
//				vueloPrueba2.setAeropuertoDestino("Bilbao");
//				vueloPrueba2.setAeropuertoOrigen("Barcelona");
//				vueloPrueba2.setSalidaFecha("06/01/2020");
//				vueloPrueba2.setLlegadaFecha("10/01/2020");
//				vueloPrueba2.setPrecio(90);
//				vueloPrueba2.setAsientosVacantes(50);
//				vueloPrueba2.setAerolinea("Iberia");
//
//
//				vuelos.add(vueloPrueba1);
//				vuelos.add(vueloPrueba2);
				
				vuelos = (List<DTOVuelo>)controlador.buscarVuelo(textOrigen.getText(), textDestino.getText());
				
				for (DTOVuelo vuelo : vuelos) {
					if(vuelos.size()!=0 && vuelo.getAeropuertoOrigen().equals(textOrigen.getText()) && vuelo.getAeropuertoDestino().equals(textDestino.getText()) ){
						for(int i = 0; i<vuelos.size();i++){
							cargarVueloEnTabla(vuelos.get(i));
						}
					}
					else{
						JOptionPane.showMessageDialog(new Frame(), "No hay vuelos disponibles. ");
					}
				}

			}
		});
		contentPane.add(btnBuscar);
		
		JButton btnReserva = new JButton("Reserva y pago");
		btnReserva.setBounds(295, 395, 160, 29);
		btnReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DTOVuelo vuelo = new DTOVuelo();
				
				vuelo.setIdVuelo((String)table.getValueAt(table.getSelectedRow(), 0));
				vuelo.setAeropuertoOrigen((String)table.getValueAt(table.getSelectedRow(), 1));
				vuelo.setAeropuertoDestino((String)table.getValueAt(table.getSelectedRow(), 2));
				vuelo.setSalidaFecha((String)table.getValueAt(table.getSelectedRow(), 3));
				vuelo.setLlegadaFecha((String)table.getValueAt(table.getSelectedRow(), 4));
				vuelo.setPrecio((Integer)table.getValueAt(table.getSelectedRow(), 5));
				vuelo.setAsientosVacantes((Integer)table.getValueAt(table.getSelectedRow(), 6));
				vuelo.setAerolinea((String)table.getValueAt(table.getSelectedRow(), 7));
				
				DataWindow dataW = new DataWindow(usuario,vuelo,tipo);
				dataW.setVisible(true);
				closeWin();
				
			}	
		});
		contentPane.add(btnReserva);
		
	}
	
	private void cargarVueloEnTabla(DTOVuelo a){ // Carga los datos en la tabla
        modelo = (DefaultTableModel)table.getModel();
        String c = a.getIdVuelo();
        String o = a.getAeropuertoOrigen();
        String d = a.getAeropuertoDestino();
        String lf = a.getLlegadaFecha();
        String sh = a.getSalidaFecha();
        int p = a.getPrecio();
        int pa = a.getAsientosVacantes();
        String ar = a.getAerolinea();
        

        Object[] fila = {c,o,d,lf,sh,p,pa,ar};
        modelo.addRow(fila);                    
	}
	
	private void borrarTabla(){
		for (int i = 0; i < table.getRowCount(); i++) {
	    	modelo.removeRow(i);
	        i-=1;
	       
		}
	}
	
}
