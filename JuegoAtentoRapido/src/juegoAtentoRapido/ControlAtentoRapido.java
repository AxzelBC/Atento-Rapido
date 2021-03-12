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
		nCuadros = 3;
		vidas = 3;
		puntuacion = 0;
		aciertos = 0;
		errores = 0;
		
		cuadros = new String[10];
		sacarCuadros();
	}
	
	
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
	
	
	public void escogerCuadro() {
		Random cualquier = new Random();
		prox = cualquier.nextInt(nCuadros);
	}
	
	
	public void cambiarCuadro(int index) {
		cuadros[index] = cuadro.getColorCuadro();
	}
	
	
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
	
	
	public void setUsuario(boolean arg) {
		this.usuario = arg;
	}
	
	
	public void setAbandonar() {
		estado=2;
		movimientos=false;
	}
	
	
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

	public boolean isUsuario() {
		return usuario;
	}

	public String getCuadros(int index) {
		return cuadros[index];
	}
	
	public int getProx() {
		return prox;
	}
}