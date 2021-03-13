/*
 * @Autor Alejandro Cardona Mosquera
 * 
 * @Código 2022499-2711
 * 
 * @Feche 12 de marzo de 2021
 * 
 * @Descripción clase encargada de la implementación de la GUI del juego Atento Rápido.
 */


package juegoAtentoRapido;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;


import java.awt.Color;
import java.awt.Container;
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
import javax.swing.JTextField;
import javax.swing.Timer;


/**
 * The Class GUIAtentoRapido.
 */
public class GUIAtentoRapido extends JFrame{

	//Atributos
	private JPanel ventanaInicio, ventanaJuego;
	
	private JLabel cuadro1,cuadro2,cuadro3,cuadro4,cuadro5,cuadro6,cuadro7,cuadro8,cuadro9,cuadro10;
	
	private JLabel vidas, aciertos, errores, puntuacion, level;
	
	private JTextField valorVidas, valorPuntuacion, valorAciertos, valorErrores, valorLevel;
	
	private JButton jugar, abandonar, reiniciar, pulsor;
	
	private ImageIcon imagen;
	
	private Escucha escucha;
	
	private ControlAtentoRapido control;
	
	private JFrame GUIAtentoRapido;
	
	private Timer tempo, borde;
	
	private int tiempo;
	
	
	//Metodos
	/**
	 * Instantiates a new GUI atento rapido.
	 * 
	 * Constructor de la clase:
	 * Inicializa el timer, escucha, control, etc. Lo básico para el funcionamiento.
	 */
	public GUIAtentoRapido() {
		
		this.tiempo = 3000;
		GUIAtentoRapido=this;
		control = new ControlAtentoRapido();
		escucha = new Escucha();
		
		tempo = new Timer(tiempo,escucha);
		borde = new Timer((tiempo / 2),escucha);
		
		init();
		
		//Titulo de la ventana
		this.setTitle("Atento Rápido");
		//Tamaño de ventana
		this.setSize(1350,763);
		//Parte de la pantalla donde se ejecuta
		this.setLocationRelativeTo(null);
		//Cambio de tamaño por el usuario
		this.setResizable(false);
		//Boton de cerrar
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Visibilidad de la ventana
		this.setVisible(true);
	}
	
	/**
	 * Inits the.
	 * 
	 * Primer pantalla a mostrar, da la opción de jugar.
	 */
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
		add(ventanaInicio,constraints);
	}
	
	
	
	/**
	 * Juego.
	 * 
	 * GUI del juego, aquí se muestran todos los elementos de este.
	 */
	public void juego() {
		//Set up container - layout
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		

		this.setBackground(Color.CYAN);
		
		imagen = new ImageIcon("src/imagenes/"+control.getCuadros(0)+".png");
		cuadro1 = new JLabel(imagen);
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
		
		
		
		ventanaJuego = new JPanel();
		ventanaJuego.setLayout(new GridLayout(6,1));
		
		vidas = new JLabel("VIDAS");
		valorVidas = new JTextField(2);
		valorVidas.setEditable(false);
		valorVidas.setText(String.valueOf(control.getVidas()));
		
		level = new JLabel("NIVEL");
		valorLevel = new JTextField(2);
		valorLevel.setEditable(false);
		valorLevel.setText(String.valueOf(control.getLevel()));
		
		puntuacion = new JLabel("PUNTUACIÓN");
		valorPuntuacion = new JTextField(2);
		valorPuntuacion.setEditable(false);
		valorPuntuacion.setText(String.valueOf(control.getPuntuacion()));
		
		ventanaJuego.add(vidas);
		ventanaJuego.add(valorVidas);
		ventanaJuego.add(puntuacion);
		ventanaJuego.add(valorPuntuacion);
		ventanaJuego.add(level);
		ventanaJuego.add(valorLevel);
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridwidth=3;
		add(ventanaJuego,constraints);
		
		
		
		abandonar = new JButton("Abandonar");
		abandonar.addActionListener(escucha);
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		add(abandonar,constraints);
		
		reiniciar = new JButton("reiniciar");
		reiniciar.addActionListener(escucha);
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		add(reiniciar,constraints);
		
		pulsor = new JButton("STOP");
		pulsor.addActionListener(escucha);
		constraints.gridx=8;
		constraints.gridy=8;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		add(pulsor,constraints);
		
		GUIAtentoRapido.setVisible(false);
		GUIAtentoRapido.setVisible(true);
		
		borde.start();
		tempo.start();
	}
	
	
	
	/**
	 * End.
	 * 
	 * Última pantalla, se muestra al terminar el juego, ya sea por ganar o perder.
	 */
	public void end() {
		Container contenedor= this.getContentPane();
		contenedor.setLayout(new GridLayout(3,3));
		
		puntuacion = new JLabel("PUNTUACIÓN");
		aciertos = new JLabel("ACIERTOS");
		errores = new JLabel("ERRORES");
		valorPuntuacion = new JTextField(2);
		valorPuntuacion.setEditable(false);
		valorAciertos = new JTextField(2);
		valorAciertos.setEditable(false);
		valorErrores = new JTextField(2);
		valorErrores.setEditable(false);
		contenedor.setBackground(Color.WHITE);
		contenedor.add(puntuacion);
		contenedor.add(valorPuntuacion);
		contenedor.add(aciertos);
		contenedor.add(valorAciertos);
		contenedor.add(errores);
		contenedor.add(valorErrores);
		
		valorPuntuacion.setText(String.valueOf(control.getPuntuacion()));
		valorAciertos.setText(String.valueOf(control.getAciertos()));
		valorErrores.setText(String.valueOf(control.getErrores()));
		
		GUIAtentoRapido.setVisible(false);
		GUIAtentoRapido.setVisible(true);
	}
	
	
	
	/**
	 * Borrar juego.
	 * 
	 * Se encarga de borrar todos los componentes gráficos de Juego() al terminarlo,
	 * para limpiar la pantalla.
	 */
	public void borrarJuego() {
		this.tempo.stop();
		this.borde.stop();
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
		GUIAtentoRapido.remove(ventanaJuego);
		GUIAtentoRapido.remove(abandonar);
		GUIAtentoRapido.remove(reiniciar);
		GUIAtentoRapido.remove(pulsor);
	}
	
	
	
	/**
	 * Opcion.
	 * A partir del estado de juego se activa un componente gráfico, segun sea este.
	 */
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
			valorVidas.setText(String.valueOf(control.getVidas()));
			valorLevel.setText(String.valueOf(control.getLevel()));
			valorPuntuacion.setText(String.valueOf(control.getPuntuacion()));
				break;
		}
	}
	
	
	
	/**
	 * The Class Escucha.
	 * 
	 * Implementación de escuchas de los componentes gráficos.
	 */
	private class Escucha implements ActionListener{

		/**
		 * Action performed.
		 *
		 * @param eventAction the event action
		 * 
		 * A partir de las una acción generada ya sea por el usuario o el timer,
		 * se identificará y se hará una acción en especifíco para esa acción generada.
		 * 
		 * Inicio: se da en el boton jugar y abre paso a la pantalla de juego.
		 * 
		 * Juego, se divide en 5 partes:
		 * 	1. cambio de los bordes de un cuadro.
		 * 	2. cambio de cuadro y verificación de acción al cambiarlo, esto en el timer de cambio.
		 * 	3. pulsor, actualización de componentes gráficos, revisión de la decisión del usuario,
		 * 	4. escucha de abandonar juego.
		 * 	5. escucha de reiniciar juego. 
		 */
		@Override
		public void actionPerformed(ActionEvent eventAction) {
			
			//Inicio
			if(eventAction.getSource() == jugar) {
				GUIAtentoRapido.remove(ventanaInicio);
				juego();
			}
			
			
			//Juego
			else if(eventAction.getSource() == borde) {
				borde.stop();
				control.escogerCuadro();
				
				switch(control.getProx()+1) {
				case 1:
					cuadro1.setBorder(BorderFactory.createLineBorder(Color.CYAN));
					break;
				case 2:
					cuadro2.setBorder(BorderFactory.createLineBorder(Color.CYAN));
					break;
				case 3:
					cuadro3.setBorder(BorderFactory.createLineBorder(Color.CYAN));
					break;
				case 4:
					cuadro4.setBorder(BorderFactory.createLineBorder(Color.CYAN));
					break;
				case 5:
					cuadro5.setBorder(BorderFactory.createLineBorder(Color.CYAN));
					break;
				case 6:
					cuadro6.setBorder(BorderFactory.createLineBorder(Color.CYAN));
					break;
				case 7:
					cuadro7.setBorder(BorderFactory.createLineBorder(Color.CYAN));
					break;
				case 8:
					cuadro8.setBorder(BorderFactory.createLineBorder(Color.CYAN));
					break;
				case 9:
					cuadro9.setBorder(BorderFactory.createLineBorder(Color.CYAN));
					break;
				case 10:
					cuadro10.setBorder(BorderFactory.createLineBorder(Color.CYAN));
					break;
				}
			}
			else if(eventAction.getSource() == tempo) {
				tempo.stop();
				control.cambiarCuadro(control.getProx());
				
				control.logroDar(false);
				
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(0)+".png");
				cuadro1.setIcon(imagen);
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(1)+".png");
				cuadro2.setIcon(imagen);
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(2)+".png");
				cuadro3.setIcon(imagen);
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(3)+".png");
				cuadro4.setIcon(imagen);
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(4)+".png");
				cuadro5.setIcon(imagen);
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(5)+".png");
				cuadro6.setIcon(imagen);
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(6)+".png");
				cuadro7.setIcon(imagen);
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(7)+".png");
				cuadro8.setIcon(imagen);
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(8)+".png");
				cuadro9.setIcon(imagen);
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(9)+".png");
				cuadro10.setIcon(imagen);
				
				control.estadoJuego();
				opcion();
				
				cuadro1.setBorder(BorderFactory.createEmptyBorder());
				cuadro2.setBorder(BorderFactory.createEmptyBorder());
				cuadro3.setBorder(BorderFactory.createEmptyBorder());
				cuadro4.setBorder(BorderFactory.createEmptyBorder());
				cuadro5.setBorder(BorderFactory.createEmptyBorder());
				cuadro6.setBorder(BorderFactory.createEmptyBorder());
				cuadro7.setBorder(BorderFactory.createEmptyBorder());
				cuadro8.setBorder(BorderFactory.createEmptyBorder());
				cuadro9.setBorder(BorderFactory.createEmptyBorder());
				cuadro10.setBorder(BorderFactory.createEmptyBorder());
				
				borde.restart();
				tempo.restart();
				
				switch(control.getProx()+1) {
					case 1:
						
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx())+".png");
						
						cuadro1.setIcon(imagen);
						break;
					case 2:
						
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx())+".png");
						
						cuadro2.setIcon(imagen);
						break;
					case 3:
						
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx())+".png");
						
						cuadro3.setIcon(imagen);
						break;
					case 4:
						
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx())+".png");
						
						cuadro4.setIcon(imagen);
						break;
					case 5:
						
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx())+".png");
						
						cuadro5.setIcon(imagen);
						break;
					case 6:
						
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx())+".png");
						
						cuadro6.setIcon(imagen);
						break;
					case 7:
						
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx())+".png");
						
						cuadro7.setIcon(imagen);
						break;
					case 8:
						
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx())+".png");
						
						cuadro8.setIcon(imagen);
						break;
					case 9:
						
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx())+".png");
						
						cuadro9.setIcon(imagen);
						break;
					case 10:
						
						imagen = new ImageIcon
						("src/imagenes/"+control.getCuadros(control.getProx())+".png");
						
						cuadro10.setIcon(imagen);
						break;
				}
			}			
			else if(eventAction.getSource() == pulsor) {
				tempo.stop();
				
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(0)+".png");
				cuadro1.setIcon(imagen);
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(1)+".png");
				cuadro2.setIcon(imagen);
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(2)+".png");
				cuadro3.setIcon(imagen);
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(3)+".png");
				cuadro4.setIcon(imagen);
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(4)+".png");
				cuadro5.setIcon(imagen);
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(5)+".png");
				cuadro6.setIcon(imagen);
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(6)+".png");
				cuadro7.setIcon(imagen);
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(7)+".png");
				cuadro8.setIcon(imagen);
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(8)+".png");
				cuadro9.setIcon(imagen);
				imagen = new ImageIcon("src/imagenes/"+control.getCuadros(9)+".png");
				cuadro10.setIcon(imagen);
				
				control.logroDar(true);
				control.estadoJuego();
				opcion();
				
				borde.restart();
				tempo.restart();
			}
			else if(eventAction.getSource() == abandonar) {
				control.setAbandonar();
				opcion();
			}
			else if(eventAction.getSource() == reiniciar) {
				control.setReinicio();
			}
		}
	}
}

