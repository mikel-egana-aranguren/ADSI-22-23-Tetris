package com.zetcode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import org.json.JSONObject;

import javax.swing.BorderFactory;

public class Menu extends JFrame {

	private JPanel contentPane;
	private static Menu miMenu = null;
	JLabel mensaje = null;
	private JButton nuevaPartida;
	private JButton personalizarMapa;

	/**
	 * Launch the application.
	 */
	public void start() {
		try {
			miMenu.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		miMenu.dispose();
	}
	
	public static Menu getMenu() {
		if (miMenu == null) {
			miMenu = new Menu();
		}
		return miMenu;
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		panelMenu();
	}
	
	public void panelMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		nuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuDificultad abrirDificultad = new MenuDificultad();
				Menu.this.dispose();
			}
		});
		nuevaPartida.setAlignmentX(CENTER_ALIGNMENT);
		contentPane.add(nuevaPartida);
		contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		JButton cargarPartida = new JButton("Cargar Partida");
		cargarPartida.setAlignmentX(CENTER_ALIGNMENT);
		cargarPartida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Menu.getMenu().panelSeleccionarPartida();
				
			}
		});
		contentPane.add(cargarPartida);
		contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		JButton personalizarMapa = new JButton("Personalizacion");
		personalizarMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personalizar abrirPersonalizacion = Personalizar.getPersonalizar();
				abrirPersonalizacion.setVisible(true);
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
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	public void panelSeleccionarPartida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setContentPane(contentPane);
		ArrayList<Integer> listaIds = new ArrayList<Integer>();
		try {
			JSONObject[] partidasUsuario = (JSONObject[])Gestor.obtenerPartidasUsuarioActual().get("listaPartidas");
			for (JSONObject partida : partidasUsuario) {
				int id = partida.getInt("id");
				int puntos = partida.getInt("puntos");
				contentPane.add(new JLabel("id: "+ id + ", puntos: " + puntos));
				listaIds.add(id);
			}
			contentPane.add(new JLabel("Selecciona el id de la partida que desear cargar: "));
			JTextField textField = new JTextField(20);
			contentPane.add(textField);
			JButton aceptar = new JButton("Aceptar");
			aceptar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Integer idSeleccionado = Integer.parseInt(textField.getText().trim());
						boolean esta = false;
						int pos = 0;
						while (!esta && pos < listaIds.size()) {
							esta = listaIds.get(pos) == idSeleccionado;
							pos += 1;
							
						}
						if (!esta) {
							ponerMensaje("EL id de partida no existe");
						} else {
							Menu.getMenu().close();
							Gestor.cargarPartida(idSeleccionado);
						}
					} catch (Exception ex) {
						ponerMensaje("El id debe ser un numero");
					}
				}
			});
			contentPane.add(aceptar);
			
		} catch (Exception e) {
			System.err.println(e);
		}
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	public void ponerMensaje(String pMensaje) {
		if (mensaje != null) {
			contentPane.remove(mensaje);
		}
		mensaje = new JLabel(pMensaje);
		mensaje.setForeground(Color.red);
		contentPane.add(mensaje);
		contentPane.revalidate();
		contentPane.repaint();
	}
}
