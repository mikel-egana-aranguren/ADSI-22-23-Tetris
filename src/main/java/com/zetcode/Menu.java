package com.zetcode;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import com.zetcode.*;

import javax.swing.BorderFactory;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JButton personalizarMapa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setContentPane(contentPane);
		
		JLabel titulo = new JLabel("Tetrix");
		titulo.setAlignmentX(CENTER_ALIGNMENT);
		contentPane.add(titulo);
		contentPane.add(Box.createRigidArea(new Dimension(0, 20)));
		JButton nuevaPartida = new JButton("Nueva Partida");
		nuevaPartida.setAlignmentX(CENTER_ALIGNMENT);
		contentPane.add(nuevaPartida);
		contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		JButton cargarPartida = new JButton("Cargar Partida");
		cargarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tetris abrirPartida = new Tetris();
				abrirPartida.setVisible(true);
				Menu.this.dispose();
			}
		});
		cargarPartida.setAlignmentX(CENTER_ALIGNMENT);
		contentPane.add(cargarPartida);
		contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		JButton personalizarMapa = new JButton("Personalizacion");
		personalizarMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personalizar abrirPersonalizacion = Personalizar.getPersonalizar();
				//abrirPersonalizacion.setVisible(true);
				Menu.this.dispose();
			}
		});
		personalizarMapa.setAlignmentX(CENTER_ALIGNMENT);
		contentPane.add(personalizarMapa);
		contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		JButton verRanking = new JButton("Ver Ranking");
		verRanking.setAlignmentX(CENTER_ALIGNMENT);
		contentPane.add(verRanking);
		contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		JButton verPremios = new JButton("Ver Premios");
		verPremios.setAlignmentX(CENTER_ALIGNMENT);
		contentPane.add(verPremios);
		contentPane.add(Box.createRigidArea(new Dimension(5, 0)));
		
	}
	

}
