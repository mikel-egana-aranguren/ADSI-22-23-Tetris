package com.zetcode;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONObject;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class PremioDescripcion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PremioDescripcion frame = new PremioDescripcion("Placeholder");
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
	public PremioDescripcion(String nombrePremio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSONObject json2 = Gestor.obtenerDescripcionPremio(nombrePremio);
		String descripcion = json2.getString("descripcion");
		Integer progreso = json2.getInt("progreso");
		Integer progresoMax = json2.getInt("progresoMax");

		ByteBuffer buffer = StandardCharsets.ISO_8859_1.encode(descripcion); 
		String descripcionUTF8 = StandardCharsets.UTF_8.decode(buffer).toString();

		JLabel btnNewButton = new JLabel("");
		btnNewButton.setIcon(new ImageIcon("a.jpg"));
		btnNewButton.setBounds(12, 42, 195, 176);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel(nombrePremio);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setBounds(289, 60, 500, 77);
		contentPane.add(lblNewLabel);
		
		JLabel txtpnAa = new JLabel();
		txtpnAa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnAa.setText(descripcionUTF8);
		txtpnAa.setBounds(243, 129, 298, 106);
		contentPane.add(txtpnAa);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(465, 276, 97, 25);
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPremios premios = new MenuPremios();
				premios.setLocationRelativeTo(null);;
				premios.setVisible(true);
				dispose();
			}
		});
		contentPane.add(botonVolver);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(75);
		progressBar.setBounds(22, 231, 146, 14);
		contentPane.add(progressBar);
	}
}
