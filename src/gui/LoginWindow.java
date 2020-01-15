package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class LoginWindow extends JFrame {

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
	public LoginWindow() {
//		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		setTitle("Seleccion de acceso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 465);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JButton buttonGoogle = new JButton("GOOGLE");
		buttonGoogle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				LoginWindowGoogle go = new LoginWindowGoogle();
				go.setVisible(true);
				closeWin();
				
				
			}

			
		});
		buttonGoogle.setForeground(SystemColor.activeCaption);
		buttonGoogle.setForeground(new Color(0, 102, 153));
		buttonGoogle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		buttonGoogle.setBounds(86, 132, 219, 136);
		contentPane.add(buttonGoogle);
		
		JButton buttonAtras = new JButton("Atr\u00E1s");
		buttonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InitialWindow ini = new InitialWindow();
				ini.setVisible(true);
				closeWin();
			}
		});
		buttonAtras.setForeground(SystemColor.activeCaption);
		buttonAtras.setForeground(new Color(0, 102, 153));
		buttonAtras.setFont(new Font("Tahoma", Font.PLAIN, 19));
		buttonAtras.setBounds(15, 366, 139, 29);
		contentPane.add(buttonAtras);
		
		JButton buttonFacebook = new JButton("FACEBOOK");
		buttonFacebook.setForeground(SystemColor.activeCaption);
		buttonFacebook.setFont(new Font("Tahoma", Font.PLAIN, 30));
		buttonFacebook.setBounds(360, 132, 219, 136);
		buttonFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				LoginWindowFacebook fa = new LoginWindowFacebook();
				fa.setVisible(true);
				closeWin();
				
				
			}

			
		});
		contentPane.add(buttonFacebook);
		
		JLabel lblSeleccionaCmoQuieres = new JLabel("Selecciona c\u00F3mo quieres acceder:");
		lblSeleccionaCmoQuieres.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblSeleccionaCmoQuieres.setBounds(43, 43, 475, 47);
		contentPane.add(lblSeleccionaCmoQuieres);
		
	
	}
}
