package com.zetcode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Personalizacion extends JFrame {

	private JPanel contentPane;
	private PropertyChangeSupport support;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personalizacion frame = new Personalizacion();
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
	public Personalizacion() {
		setBackground(new Color(221, 160, 221));
		initialize();
		support = new PropertyChangeSupport(this);
	}
	
	public void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 271);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 153));
		contentPane.setForeground(new Color(153, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel titulo = new JPanel();
		contentPane.add(titulo, BorderLayout.NORTH);
		titulo.setBackground(new Color(153, 153, 153));
		
		JLabel lblPersonalizacin = new JLabel("PERSONALIZACIÓN");
		lblPersonalizacin.setForeground(new Color(153, 0, 153));
		lblPersonalizacin.setFont(new Font("Dialog", Font.BOLD, 30));
		titulo.add(lblPersonalizacin);
		
		JPanel Contenido = new JPanel();
		contentPane.add(Contenido, BorderLayout.CENTER);
		Contenido.setBackground(new Color(153, 153, 153));
		
		JLabel lblColorFondo = new JLabel("Color de fondo");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"red", "blue", "green", "yellow", "white", "black"}));
		
		JLabel lblColorLadrillo = new JLabel("Color de ladrillo");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"red", "blue", "green", "yellow", "white", "black"}));
		
		JLabel lblSonido = new JLabel("Sonido");
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"On\t", "Off"}));
		GroupLayout gl_Contenido = new GroupLayout(Contenido);
		gl_Contenido.setHorizontalGroup(
			gl_Contenido.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Contenido.createSequentialGroup()
					.addContainerGap(84, Short.MAX_VALUE)
					.addGroup(gl_Contenido.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Contenido.createSequentialGroup()
							.addComponent(lblColorFondo)
							.addGap(57)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Contenido.createSequentialGroup()
							.addGroup(gl_Contenido.createParallelGroup(Alignment.LEADING)
								.addComponent(lblColorLadrillo, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Contenido.createSequentialGroup()
									.addGap(34)
									.addComponent(lblSonido, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
							.addGap(37)
							.addGroup(gl_Contenido.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_1_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))))
					.addGap(121))
		);
		gl_Contenido.setVerticalGroup(
			gl_Contenido.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Contenido.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_Contenido.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblColorFondo)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Contenido.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblColorLadrillo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Contenido.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSonido)
						.addComponent(comboBox_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		Contenido.setLayout(gl_Contenido);
		
		JPanel Volver = new JPanel();
		contentPane.add(Volver, BorderLayout.SOUTH);
		Volver.setBackground(new Color(153, 153, 153));
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu volverMenu = new Menu();
				volverMenu.setVisible(true);
				Personalizacion.this.dispose();
			}
		});
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu guardarPersonalizacion = new Menu();
				guardarPersonalizacion.setVisible(true);
				Personalizacion.this.dispose();
			}
		});
		btnGuardar.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_Volver = new GroupLayout(Volver);
		gl_Volver.setHorizontalGroup(
			gl_Volver.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_Volver.createSequentialGroup()
					.addContainerGap(110, Short.MAX_VALUE)
					.addComponent(btnVolver)
					.addGap(66)
					.addComponent(btnGuardar)
					.addGap(94))
		);
		gl_Volver.setVerticalGroup(
			gl_Volver.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_Volver.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_Volver.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuardar)
						.addComponent(btnVolver)))
		);
		Volver.setLayout(gl_Volver);
	}
	
	public void addObserver(PropertyChangeListener pList) {
		support.addPropertyChangeListener(pList);
	}
}
