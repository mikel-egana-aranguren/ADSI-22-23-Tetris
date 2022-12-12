package com.zetcode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.Rectangle;
import java.awt.Cursor;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class IU_CambiarContraseña extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pwd;
	private JPasswordField pwdRepeat;
	private JPasswordField pwdOld;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_CambiarContraseña frame = new IU_CambiarContraseña();
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
	public IU_CambiarContraseña() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 430, 290);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//Panel SUPERIOR
		
		JPanel panelSuperior = new JPanel();
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 4));
		
		JLabel lblTitulo = new JLabel("CAMBIAR CONTRASEÑA");
		panelSuperior.add(lblTitulo);
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTitulo.setForeground(new Color(153, 0, 153));
		
		// Panel CENTRAL
		
		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentral = new GridBagLayout();
		gbl_panelCentral.columnWidths = new int[] {209, 20, 215, 30, 0};
		gbl_panelCentral.rowHeights = new int[] {11, 35, 35, 35, 35, 5};
		gbl_panelCentral.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelCentral.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCentral.setLayout(gbl_panelCentral);
		
		JLabel lblUsuario = new JLabel("Usuario");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 1;
		panelCentral.add(lblUsuario, gbc_lblUsuario);
		
		txtUsuario = new JTextField();
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.gridx = 2;
		gbc_txtUsuario.gridy = 1;
		panelCentral.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(5);
		
		JLabel lblEmail = new JLabel("Contraseña Actual");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 2;
		panelCentral.add(lblEmail, gbc_lblEmail);
		
		pwdOld = new JPasswordField();
		GridBagConstraints gbc_pwdOld = new GridBagConstraints();
		gbc_pwdOld.insets = new Insets(0, 0, 5, 5);
		gbc_pwdOld.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdOld.gridx = 2;
		gbc_pwdOld.gridy = 2;
		panelCentral.add(pwdOld, gbc_pwdOld);
		
		JLabel lblContrasea = new JLabel("Nueva contraseña");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 0;
		gbc_lblContrasea.gridy = 3;
		panelCentral.add(lblContrasea, gbc_lblContrasea);
		
		pwd = new JPasswordField();
		GridBagConstraints gbc_pwd = new GridBagConstraints();
		gbc_pwd.insets = new Insets(0, 0, 5, 5);
		gbc_pwd.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwd.gridx = 2;
		gbc_pwd.gridy = 3;
		panelCentral.add(pwd, gbc_pwd);
		
		JLabel lblRepetirContrasea = new JLabel("Repetir nueva contraseña");
		GridBagConstraints gbc_lblRepetirContrasea = new GridBagConstraints();
		gbc_lblRepetirContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblRepetirContrasea.insets = new Insets(0, 0, 0, 5);
		gbc_lblRepetirContrasea.gridx = 0;
		gbc_lblRepetirContrasea.gridy = 4;
		panelCentral.add(lblRepetirContrasea, gbc_lblRepetirContrasea);
		
		pwdRepeat = new JPasswordField();
		GridBagConstraints gbc_pwdRepeat = new GridBagConstraints();
		gbc_pwdRepeat.insets = new Insets(0, 0, 0, 5);
		gbc_pwdRepeat.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdRepeat.gridx = 2;
		gbc_pwdRepeat.gridy = 4;
		panelCentral.add(pwdRepeat, gbc_pwdRepeat);
		
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
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarContraseña();
			}
		});
		btnCambiar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				cambiarContraseña();
			}
		});
		btnCambiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));
		panelInferior.add(btnVolver);
		panelInferior.add(btnCambiar);
	}
	
	public void ocultar() {
		this.setVisible(false);
	}
	
	public void volver() {
		IU_Identificacion iuIdentificacion = new IU_Identificacion();
		iuIdentificacion.setVisible(true);
		ocultar();
	}
	
	public void cambiarContraseña() {
		Gestor GPrincipal = new Gestor();
		GPrincipal.comprobarDatosCambiarContraseña(txtUsuario.getText(), String.valueOf(pwd.getPassword()),String.valueOf(pwdRepeat.getPassword()));
	}
}
