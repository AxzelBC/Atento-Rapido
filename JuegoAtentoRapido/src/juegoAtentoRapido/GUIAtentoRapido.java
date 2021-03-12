package juegoAtentoRapido;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;


public class GUIAtentoRapido extends JFrame{

	//Atributos
	private JPanel ventanaInicio, ventanaJuego, ventanaResultados;
	private JLabel cuadro1,cuadro2,cuadro3,cuadro4,cuadro5,cuadro6,cuadro7,cuadro8,cuadro9,cuadro10;
	private JLabel vidas, aciertos, errores, puntuación, level, finJuego;
	private JTextField valorVidas;
	private JButton jugar, abandonar, reiniciar, pulsor;
	private ImageIcon imagen;
	private JTextArea mensajes;
	private Escucha escucha;
	private ControlAtentoRapido control;
	private JFrame GUIAtentoRapido;
	private Timer tempo, borde;
	private int tiempo;
	
	//Metodos
	public GUIAtentoRapido() {
		
		this.tiempo = 6000;
		GUIAtentoRapido=this;
		control = new ControlAtentoRapido();
		escucha = new Escucha();
		
		init();
		//juego();
		
		//Titulo de la ventana
		this.setTitle("Atento Rápido");
		//Tamaño de ventana
		//this.pack();
		this.setSize(1350,763);
		//Parte de la pantalla donde se ejecuta
		this.setLocationRelativeTo(null);
		//Cambio de tamaño por el usuario
		this.setResizable(false);
		//Boton de cerrar
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Visibilidad de la ventana
		this.setVisible(true);
	}
	
	public void init(){
		//Set up container - layout
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		
		//ventanaInicio
		ventanaInicio = new JPanel();
		ventanaInicio.setLayout(new GridLayout(1,1));
			//elementos gráficos
		jugar = new JButton("Jugar");
		jugar.addActionListener(escucha);
			//agregar
		ventanaInicio.add(jugar);
			//configuracion
		ventanaInicio.setBackground(Color.CYAN);
		ventanaInicio.setPreferredSize(new Dimension(1260,720));
		constraints.gridx=0;
		constraints.gridy=0;
		//constraints.gridwidth=1;
		//constraints.gridheight=1;
		//constraints.fill=GridBagConstraints.NONE;
		//constraints.anchor=GridBagConstraints.CENTER;
		add(ventanaInicio,constraints);

	}
	
	public void juego() {
		//Set up container - layout
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		
		tempo = new Timer(tiempo,escucha);
		borde = new Timer((tiempo / 2),escucha);

		this.setBackground(Color.CYAN);
		
		imagen = new ImageIcon("src/imagenes/"+control.getCuadros(0)+".png");
		cuadro1 = new JLabel(imagen);
		cuadro1.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		constraints.gridx=4;
		constraints.gridy=5;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		add(cuadro1,constraints);
		
		imagen = new ImageIcon("src/imagenes/"+control.getCuadros(1)+".png");
		cuadro2 = new JLabel(imagen);
		constraints.gridx=3;
		constraints.gridy=4;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		add(cuadro2,constraints);
		
		imagen = new ImageIcon("src/imagenes/"+control.getCuadros(2)+".png");
		cuadro3 = new JLabel(imagen);
		constraints.gridx=5;
		constraints.gridy=4;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		add(cuadro3,constraints);
		
		imagen = new ImageIcon("src/imagenes/"+control.getCuadros(3)+".png");
		cuadro4 = new JLabel(imagen);
		constraints.gridx=4;
		constraints.gridy=3;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		add(cuadro4,constraints);
		
		imagen = new ImageIcon("src/imagenes/"+control.getCuadros(4)+".png");
		cuadro5 = new JLabel(imagen);
		constraints.gridx=2;
		constraints.gridy=3;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		add(cuadro5,constraints);
		
		imagen = new ImageIcon("src/imagenes/"+control.getCuadros(5)+".png");
		cuadro6 = new JLabel(imagen);
		constraints.gridx=6;
		constraints.gridy=5;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		add(cuadro6,constraints);
		
		imagen = new ImageIcon("src/imagenes/"+control.getCuadros(6)+".png");
		cuadro7 = new JLabel(imagen);
		constraints.gridx=2;
		constraints.gridy=5;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		add(cuadro7,constraints);
		
		imagen = new ImageIcon("src/imagenes/"+control.getCuadros(7)+".png");
		cuadro8 = new JLabel(imagen);
		constraints.gridx=6;
		constraints.gridy=3;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		add(cuadro8,constraints);
		
		imagen = new ImageIcon("src/imagenes/"+control.getCuadros(8)+".png");
		cuadro9 = new JLabel(imagen);
		constraints.gridx=7;
		constraints.gridy=4;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		add(cuadro9,constraints);
		
		imagen = new ImageIcon("src/imagenes/"+control.getCuadros(9)+".png");
		cuadro10 = new JLabel(imagen);
		constraints.gridx=1;
		constraints.gridy=4;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		add(cuadro10,constraints);
		
		pulsor = new JButton("STOP");
		pulsor.addActionListener(escucha);
		constraints.gridx=8;
		constraints.gridy=8;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		add(pulsor,constraints);
		
		GUIAtentoRapido.setVisible(false);
		GUIAtentoRapido.setVisible(true);
		
		tempo.start();
	}
	
	public void end() {
		
	}
	
	public void borrarJuego() {
		GUIAtentoRapido.remove(cuadro1);
		GUIAtentoRapido.remove(cuadro2);
		GUIAtentoRapido.remove(cuadro3);
		GUIAtentoRapido.remove(cuadro4);
		GUIAtentoRapido.remove(cuadro5);
		GUIAtentoRapido.remove(cuadro6);
		GUIAtentoRapido.remove(cuadro7);
		GUIAtentoRapido.remove(cuadro8);
		GUIAtentoRapido.remove(cuadro9);
		GUIAtentoRapido.remove(cuadro10);
		GUIAtentoRapido.remove(pulsor);
		GUIAtentoRapido.setVisible(false);
		GUIAtentoRapido.setVisible(true);
	}
	
	public void opcion() {
		switch(control.getEstado()) {
		case 1:
			borrarJuego();
			end();
				break;
		case 2:
			borrarJuego();
			end();
				break;
		case 3:
			
				break;
		}
	}
	
	
	
	private class Escucha implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent eventAction) {
			
			//Inicio
			if(eventAction.getSource() == jugar) {
				GUIAtentoRapido.remove(ventanaInicio);
				juego();
			}
			
			
			//Juego
			else if(eventAction.getSource() == tempo) {
				//tempo.stop();
				control.estadoJuego(false);
				control.cambiarCuadro(control.getProx());
				
				switch(control.getProx()) {
					case 1:
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx()-1)+".png");
						
						cuadro1.setIcon(imagen);
						break;
					case 2:
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx()-1)+".png");
						
						cuadro2.setIcon(imagen);
						break;
					case 3:
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx()-1)+".png");
						
						cuadro3.setIcon(imagen);
						break;
					case 4:
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx()-1)+".png");
						
						cuadro4.setIcon(imagen);
						break;
					case 5:
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx()-1)+".png");
						
						cuadro5.setIcon(imagen);
						break;
					case 6:
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx()-1)+".png");
						
						cuadro6.setIcon(imagen);
						break;
					case 7:
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx()-1)+".png");
						
						cuadro7.setIcon(imagen);
						break;
					case 8:
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx()-1)+".png");
						
						cuadro8.setIcon(imagen);
						break;
					case 9:
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx()-1)+".png");
						
						cuadro9.setIcon(imagen);
						break;
					case 10:
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx()-1)+".png");
						
						cuadro10.setIcon(imagen);
						break;
				}
				GUIAtentoRapido.repaint();
				//tempo.restart();
			}
			else if(eventAction.getSource() == borde) {
				control.escogerCuadro();
			}
			
			else if(eventAction.getSource() == pulsor) {
				tempo.stop();
			}
		}
	}
}

