package juegoAtentoRapido;

import java.util.Random;

public class ControlAtentoRapido {
	
	//Atributos
	private int vidas, aciertos, errores, puntuacion, level, estado,prox;
	private static int nCuadros;
	private boolean movimientos, iguales, usuario;
	private String[] cuadros;
	private Cuadro cuadro;
	
	//Metodos
	
	public ControlAtentoRapido() {
		cuadro = new Cuadro();
		
		movimientos = true;
		level = 1;
		nCuadros = 10;
		vidas = 3;
		
		cuadros = new String[10];
		sacarCuadros();
	}
	
	
	/*
*	public void sacarCuadros() {
*		for (int i = 0; i<nCuadros; i++) {
*			if (repetido(cuadros, cuadro.getColorCuadro()) == false) {
*				cuadros[i] = cuadro.getColorCuadro();
*	        }
*		}
*		
*	}
*	public static boolean repetido(String[] array, String valor) {
*		boolean repetido = false;
*		for (int i = 0; i<nCuadros && !repetido; i++) {
*		    if (array[i] == valor) {// si el valor generado aleatoriamente esta
*		                            // dentro del array le marcamos como true y
*		                            // por lo tanto no lo metera en el array
*		                            // al poner en la condicion del bucle que 
*		                            // repetido sea false, cuando lo ponemos a true
*		                            // salimos y evitamos iteraciones inecesarias
*		        repetido = true;
*		    }
*		}
*		   return repetido;
*		}
	*/

	
	public void sacarCuadros() {
		for (int i = 0; i<nCuadros; i++) {
			cuadros[i] = cuadro.getColorCuadro();
		}
		
		for (int i = 0; i<nCuadros; i++) {
			for (int j = 0; j<nCuadros; j++) {
				if(cuadros[i]==cuadros[j]) {
					cuadros[j] = cuadro.getColorCuadro();
				}
			}
		}
	}
	
	
	public void escogerCuadro() {
		Random cualquier = new Random();
		prox = cualquier.nextInt(nCuadros)+1;
	}
	
	
	public void cambiarCuadro(int index) {
		cuadros[index] = cuadro.getColorCuadro();
	}
	
	
	public void estadoJuego(boolean quien) {
		usuario = quien;
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
	
	
	public void compararCuadros() {
		for (int i = 0; i == nCuadros; i++) {
			for (int j = 0; j == (level+2); j++) {
				if ((i!=j) && (cuadros[i]==cuadros[j])) {
					iguales = true;
				}
				else {
					iguales = false;
				}
			}
		}
		movimientos = false;
	}
	
	
	public void logroDar() {
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
			}
			else if((iguales==false) && (usuario==false)) {
				estado = 3;
				movimientos = true;
			}
			else {
				vidas--;
				errores++;
			}
		}
	}
	
	
	public void setUsuario(boolean arg) {
		this.usuario = arg;
	}
	
	
	public void setAbandonar() {
		estado=2;
		movimientos=false;
	}
	
	
	public void setReinicio() {
		//ControlAtentoRapido();
	}
///////////////////////////////////////////////////////////////////////////////
	public int getVidas() {
		return vidas;
	}

	public int getAciertos() {
		return aciertos;
	}

	public int getErrores() {
		return errores;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public int getLevel() {
		return level;
	}

	public int getEstado() {
		return estado;
	}

	public boolean isMovimientos() {
		return movimientos;
	}

	public boolean isIguales() {
		return iguales;
	}

	public boolean isUsuario() {
		return usuario;
	}

	public String getCuadros(int index) {
		return cuadros[index];
	}

	public Cuadro getCuadro() {
		return cuadro;
	}
	
	public int getProx() {
		return prox;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public void setAciertos(int aciertos) {
		this.aciertos = aciertos;
	}

	public void setErrores(int errores) {
		this.errores = errores;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public void setMovimientos(boolean movimientos) {
		this.movimientos = movimientos;
	}

	public void setIguales(boolean iguales) {
		this.iguales = iguales;
	}

	public void setCuadros(String[] cuadros) {
		this.cuadros = cuadros;
	}

	public void setCuadro(Cuadro cuadro) {
		this.cuadro = cuadro;
	}
}
