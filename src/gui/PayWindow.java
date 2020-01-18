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

import dto.DTOUsuario;



public class PayWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	


	public void closeWin() {
		this.dispose();
		
		
	}
	
	/**
	 * Create the frame.
	 */
	public PayWindow(DTOUsuario usuario) {
		
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
		

		
		JButton buttonPaypal = new JButton("Paypal");
		buttonPaypal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				PaypalWindow pal = new PaypalWindow(usuario);
				pal.setVisible(true);
				closeWin();
				
				
			}

			
		});
		buttonPaypal.setForeground(SystemColor.activeCaption);
		buttonPaypal.setForeground(new Color(0, 102, 153));
		buttonPaypal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonPaypal.setBounds(86, 132, 219, 136);
		contentPane.add(buttonPaypal);
		
		JButton buttonAtras = new JButton("Atr\u00E1s");
		buttonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataWindow dat = new DataWindow(usuario);
				dat.setVisible(true);
				closeWin();
			}
		});
		buttonAtras.setForeground(SystemColor.activeCaption);
		buttonAtras.setForeground(new Color(0, 102, 153));
		buttonAtras.setFont(new Font("Tahoma", Font.PLAIN, 19));
		buttonAtras.setBounds(15, 366, 139, 29);
		contentPane.add(buttonAtras);
		
		JButton buttonEB = new JButton("Entidad Bancaria");
		buttonEB.setForeground(SystemColor.activeCaption);
		buttonEB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonEB.setBounds(360, 132, 219, 136);
		buttonEB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				EBWindow eb = new EBWindow(usuario);
				eb.setVisible(true);
				closeWin();
				
				
			}

			
		});
		contentPane.add(buttonEB);
		
		JLabel lblSeleccionaCmoQuieres = new JLabel("Seleccione el m\u00E9todo de pago deseado:");
		lblSeleccionaCmoQuieres.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblSeleccionaCmoQuieres.setBounds(43, 43, 475, 47);
		contentPane.add(lblSeleccionaCmoQuieres);
		
	
	}
}
