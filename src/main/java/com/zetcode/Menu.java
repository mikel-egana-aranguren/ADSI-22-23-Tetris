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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;

public class Menu extends JFrame {

	private JPanel contentPane;
	private static Menu miMenu = null;
	JLabel mensaje = null;

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					miMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	private Menu() {
		panelMenu();
	}
	
	public void panelMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		cargarPartida.setAlignmentX(CENTER_ALIGNMENT);
		cargarPartida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Menu.getMenu().panelSeleccionarPartida();
				
			}
		});
		contentPane.add(cargarPartida);
		contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		JButton personalizarMapa = new JButton("Personalizar Mapa");
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
		Usuario usuario = GestorUsuario.getGestorUsuario().obtenerUsuarioActual();
		String nombreUsuario = GestorUsuario.getGestorUsuario().getNombreUsuario(usuario);
		ArrayList<Integer> listaIds = new ArrayList<Integer>();
		try {
			ResultSet resultado = SGBD.execResultSQL("SELECT * FROM PARTIDA WHERE nombreUsuario ="+nombreUsuario);
			boolean hayPartida = resultado.next();
			while (hayPartida) {
				int id = resultado.getInt("idPartida");
				int puntos = resultado.getInt("puntos");
				listaIds.add(id);
				contentPane.add(new JLabel("id: "+ id + ", puntos: " + puntos));
				hayPartida = resultado.next();
			}
			contentPane.add(new JLabel("Selecciona el id de la partida que desear cargar: "));
			JTextField textField = new JTextField(20);
			contentPane.add(textField);
			JButton aceptar = new JButton("Aceptar");
			aceptar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int idSeleccionado = Integer.parseInt(textField.getText().trim());
						if (!listaIds.contains(idSeleccionado)) {
							ponerMensaje("EL id de partida no existe");
						} else {
							Gestor.getGestor().cargarPartida(idSeleccionado);
							Menu.getMenu().close();
							Tetris.getTetris().start();
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
