package juegoAtentoRapido;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class GUIAtentoRapido extends JFrame{

	//Atributos
	private JPanel ventanaInicio, ventanaJuego, ventanaResultados;
	private JLabel cuadro1,cuadro2,cuadro3,cuadro4,cuadro5,cuadro6,cuadro7,cuadro8,cuadro9,cuadro10;
	private JLabel vidas, aciertos, errores, puntuación, level, finJuego;
	private JButton jugar, abandonar, reiniciar, pulsor;
	private JLabel objeto;
	private ImageIcon imagen;
	private JTextArea mensajes;
	private Escucha escucha;
	private ControlAtentoRapido control;
	private JFrame GUIAtentoRapido;
	
	//Metodos
	public GUIAtentoRapido() {
		init();
		
		//Titulo de la ventana
		this.setTitle("Atento Rápido");
		//Tamaño de ventana
		this.setSize(1280, 720);
		//Parte de la pantalla donde se ejecuta
		this.setLocationRelativeTo(null);
		//Cambio de tamaño por el usuario
		this.setResizable(false);
		//Boton de cerrar
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Visibilidad de la ventana
		this.setVisible(true);
	}
	
	public void init(){
		//Set up container - layout
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		//Create objets Escucha, control, and others.
		escucha = new Escucha();
		control = new ControlAtentoRapido();
		GUIAtentoRapido=this;
		
		//ventanaInicio
		ventanaInicio = new JPanel();
			//elementos gráficos
		jugar = new JButton("Jugar");
		imagen = new ImageIcon("src/imagenes/fondo.png");
		objeto = new JLabel(imagen);
			//escuchas
		jugar.addActionListener(escucha);
		//agregar
		ventanaInicio.add(objeto);
		ventanaInicio.add(jugar);
			//configuracion
		ventanaInicio.setBackground(Color.black);
		ventanaInicio.setPreferredSize(new Dimension(1260,720));
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		constraints.fill=GridBagConstraints.HORIZONTAL;
		constraints.anchor=GridBagConstraints.EAST;
		add(ventanaInicio,constraints);
	}
	
	public void juego() {
		//Set up container - layout
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
	}
	
	public void end() {
		
	}
	
	private class Escucha implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent eventAction) {
			
			
		}
		
	}
	
}
