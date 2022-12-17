package com.zetcode;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompartirResultados extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompartirResultados frame = new CompartirResultados();
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
	public CompartirResultados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("FIN DE LA PARTIDA");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 50, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, contentPane);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_6, 0, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_6, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_6, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_6, 0, SpringLayout.EAST, contentPane);
		contentPane.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		SpringLayout sl_panel_7 = new SpringLayout();
		panel_7.setLayout(sl_panel_7);
		
		JPanel panel_1 = new JPanel();
		sl_panel_7.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel_7);
		sl_panel_7.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel_7);
		panel_7.add(panel_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, contentPane);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut, BorderLayout.WEST);
		
		Box verticalBox = Box.createVerticalBox();
		panel_2.add(verticalBox, BorderLayout.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("Premio #3");
		verticalBox.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Premio #5");
		verticalBox.add(lblNewLabel_4);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Puntuaci\u00F3n: 80000");
		panel_5.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Premios obtenidos:");
		panel_5.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_3, 0, SpringLayout.SOUTH, panel_1);
		sl_panel_7.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.NORTH, panel_3);
		sl_panel_7.putConstraint(SpringLayout.NORTH, panel_3, -50, SpringLayout.SOUTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, panel_7);
		sl_panel_7.putConstraint(SpringLayout.SOUTH, panel_3, 0, SpringLayout.SOUTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, panel_7);
		panel_7.add(panel_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_3, -50, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, contentPane);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("Compartir resultados");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_5, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_2 = new JButton("Twitter");
		panel_4.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Facebook");
		panel_4.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Instagram");
		panel_4.add(btnNewButton_4);
		
		JPanel panel = new JPanel();
		panel_6.add(panel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, -50, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, contentPane);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Volver a jugar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Salir del juego");
		panel.add(btnNewButton);
	}
}
