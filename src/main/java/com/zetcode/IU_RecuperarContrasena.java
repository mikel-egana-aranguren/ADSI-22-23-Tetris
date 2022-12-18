package com.zetcode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class IU_RecuperarContrasena extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_RecuperarContrasena frame = new IU_RecuperarContrasena();
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
	public IU_RecuperarContrasena() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 430, 224);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//Panel SUPERIOR
		
		JPanel panelSuperior = new JPanel();
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 4));
		
		JLabel lblTitulo = new JLabel("RECUPERAR CONTRASENA");
		panelSuperior.add(lblTitulo);
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTitulo.setForeground(new Color(153, 0, 153));
		
		// Panel CENTRAL
		
		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentral = new GridBagLayout();
		gbl_panelCentral.columnWidths = new int[] {50, 334, 50, 0};
		gbl_panelCentral.rowHeights = new int[] {11, 35, 35, 5};
		gbl_panelCentral.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelCentral.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCentral.setLayout(gbl_panelCentral);
		
		JLabel lblIntroducirEtc = new JLabel("<html>Introduzca el email para recuperar su contrasena<html>");
		GridBagConstraints gbc_lblIntroducirEtc = new GridBagConstraints();
		gbc_lblIntroducirEtc.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIntroducirEtc.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntroducirEtc.gridx = 1;
		gbc_lblIntroducirEtc.gridy = 1;
		panelCentral.add(lblIntroducirEtc, gbc_lblIntroducirEtc);
		
		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					recuperarContrasena();
				}
			}
		});
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		panelCentral.add(txtEmail, gbc_textField);
		txtEmail.setColumns(10);
		
		//Panel INFERIOR
		
		JPanel panelInferior = new JPanel();
		contentPane.add(panelInferior, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				volver();
			}
		});
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton btnRegistrarse = new JButton("Recuperar");
		btnRegistrarse.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				recuperarContrasena();
			}
		});
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recuperarContrasena();
			}
		});
		btnRegistrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));
		panelInferior.add(btnVolver);
		panelInferior.add(btnRegistrarse);
	}

	public void ocultar() {
		this.setVisible(false);
	}
	
	public void volver() {
		IU_Identificacion iuIdentificacion = new IU_Identificacion();
		ocultar();
		iuIdentificacion.setVisible(true);
	}
	
	public void recuperarContrasena() {
		Gestor GPrincipal = new Gestor();
		if (GPrincipal.enviarEmail(txtEmail.getText()) == 1) {
			IU_Identificacion iuId = new IU_Identificacion();
			ocultar();
			iuId.setVisible(true);
		}
	}
}
