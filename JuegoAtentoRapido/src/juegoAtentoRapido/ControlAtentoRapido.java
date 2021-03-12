/*
 * @Autor Alejandro Cardona Mosquera
 * 
 * @Código 2022499-2711
 * 
 * @Feche 12 de marzo de 2021
 * 
 * @Descripción: esta clase se encarga de toda la lógica del juego Atento Rápido 
 */


package juegoAtentoRapido;

import java.util.Random;


/**
 * The Class ControlAtentoRapido.
 */
public class ControlAtentoRapido {
	
	//Atributos
	private int vidas, aciertos, errores, puntuacion, level, estado,prox;
	
	private static int nCuadros;
	
	private boolean movimientos, iguales, usuario;
	
	private String[] cuadros;
	
	private Cuadro cuadro;
	
	//Metodos
	
	/**
	 * Instantiates a new control atento rapido.
	 */
	public ControlAtentoRapido() {
		cuadro = new Cuadro();
		
		movimientos = true;
		level = 1;
		nCuadros = 3;
		vidas = 3;
		puntuacion = 0;
		aciertos = 0;
		errores = 0;
		
		cuadros = new String[10];
		sacarCuadros();
	}
	
	
	/**
	 * Sacar cuadros.
	 */
	public void sacarCuadros() {
		for (int i = 0; i<nCuadros; i++) {
			cuadros[i] = cuadro.getColorCuadro();
		}
		
		int i=0;
		while(i<nCuadros) {
			for(int j = 0; j < nCuadros; j++) {
				if((i!=j)&&(cuadros[i]==cuadros[j])) {
					cuadros[j] = cuadro.getColorCuadro();
					i=0;
					j=0;
				}
			}
			i++;
		}
	}
	
	
	/**
	 * Escoger cuadro.
	 */
	public void escogerCuadro() {
		Random cualquier = new Random();
		prox = cualquier.nextInt(nCuadros);
	}
	
	
	/**
	 * Cambiar cuadro.
	 *
	 * @param index the index
	 */
	public void cambiarCuadro(int index) {
		cuadros[index] = cuadro.getColorCuadro();
	}
	
	
	/**
	 * Estado juego.
	 */
	public void estadoJuego() {
		if(movimientos==false) {
			if((aciertos==12) && (vidas>0)) {
				estado = 1; //Win
			}
			else if ((errores==3) && (vidas==0)) {
				estado = 2; //Game Over
			}
			else {
				estado = 3;
				movimientos = true;
				compararCuadros();
			}
		}
		else {
			compararCuadros();
		}
	}
	
	
	/**
	 * Comparar cuadros.
	 */
	public void compararCuadros() {
		iguales = false;
		for (int i = 0; i < nCuadros; i++) {
			for (int j = 0; j < nCuadros; j++) {
				if ((i!=j) && (cuadros[i]==cuadros[j])) {
					iguales = true;
				}
			}
		}
		movimientos = false;
	}
	
	
	/**
	 * Logro dar.
	 *
	 * @param quien the quien
	 */
	public void logroDar(boolean quien) {
		this.usuario = quien;
		if(movimientos==false) {
			if((iguales==true) && (usuario==true)) {
				aciertos++;
				puntuacion+=5*level;
				if(aciertos == 2) {
					level = 2;
					nCuadros = 4;
				}
				else if(aciertos == 4) {
					level = 3;
					nCuadros = 5;
				}
				else if(aciertos == 6) {
					level = 4;
					nCuadros = 6;
				}
				else if(aciertos == 8) {
					level = 5;
					nCuadros = 7;
				}
				else if(aciertos == 10) {
					level = 6;
					nCuadros = 8;
				}
				else if(aciertos == 12) {
					level = 7;
					nCuadros = 9;
				}
				else if(aciertos == 14) {
					level = 8;
					nCuadros = 10;
				}
				sacarCuadros();
			}
			else if((iguales==false) && (usuario==false)) {
				estado = 3;
				movimientos = true;
			}
			else {
				vidas--;
				errores++;
				movimientos = false;
				sacarCuadros();
			}
		}
	}
	
	
	/**
	 * Sets the usuario.
	 *
	 * @param arg the new usuario
	 */
	public void setUsuario(boolean arg) {
		this.usuario = arg;
	}
	
	
	/**
	 * Sets the abandonar.
	 */
	public void setAbandonar() {
		estado=2;
		movimientos=false;
	}
	
	
	/**
	 * Sets the reinicio.
	 */
	public void setReinicio() {
		cuadro = new Cuadro();
		
		movimientos = true;
		level = 1;
		nCuadros = 3;
		vidas = 3;
		puntuacion = 0;
		aciertos = 0;
		errores = 0;
		
		cuadros = new String[10];
		sacarCuadros();
	}

///////////////////////////////////////////////////////////////////////////////
	
/**
 * Gets the vidas.
 *
 * @return the vidas
 */
	public int getVidas() {
		return vidas;
	}

	/**
	 * Gets the aciertos.
	 *
	 * @return the aciertos
	 */
	public int getAciertos() {
		return aciertos;
	}

	/**
	 * Gets the errores.
	 *
	 * @return the errores
	 */
	public int getErrores() {
		return errores;
	}

	/**
	 * Gets the puntuacion.
	 *
	 * @return the puntuacion
	 */
	public int getPuntuacion() {
		return puntuacion;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * Checks if is usuario.
	 *
	 * @return true, if is usuario
	 */
	public boolean isUsuario() {
		return usuario;
	}

	/**
	 * Gets the cuadros.
	 *
	 * @param index the index
	 * @return the cuadros
	 */
	public String getCuadros(int index) {
		return cuadros[index];
	}
	
	/**
	 * Gets the prox.
	 *
	 * @return the prox
	 */
	public int getProx() {
		return prox;
	}
}