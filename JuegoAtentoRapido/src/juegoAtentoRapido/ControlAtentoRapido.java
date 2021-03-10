package juegoAtentoRapido;

import java.util.Random;

public class ControlAtentoRapido {
	
	//Atributos
	private int vidas, aciertos, errores, puntuacion, level, estado;
	private boolean movimientos, iguales, usuario;
	private String[] cuadros;
	private Cuadro cuadro;
	
	//Metodos
	
	public ControlAtentoRapido() {
		cuadro = new Cuadro();
		
		movimientos = false;
		level = 1;
		
		cuadros = new String[10];
		sacarCuadros();
	}
	
	private void sacarCuadros() {
		for (int i = 0; i==9; i++) {
			cuadros[i] = cuadro.getColorCuadro();
		}
		
		for (int i = 0; i==9; i++) {
			for (int j = 0; j==9; j++) {
				if(cuadros[i]==cuadros[j]) {
					cuadros[j] = cuadro.getColorCuadro();
				}
			}
		}
	}
	
	public int escogerCuadro() {
		Random cualquier = new Random();
		return cualquier.nextInt(10);
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
			}
		}
		else {
			compararCuadros();
		}
	}
	
	public void compararCuadros() {
		for (int i = 0; i == (level+2); i++) {
			for (int j = 0; j == (level+2); j++) {
				if ((i!=j) && (cuadros[i]==cuadros[j])) {
					iguales = true;
				}
				else {
					iguales = false;
				}
			}
		}
	}
	
	public void logroDar() {
		if(movimientos==false) {
			if(iguales==true) {
				if(usuario==true) {
					aciertos++;
					puntuacion+=5*level;
					if(aciertos == 2) {
						level = 2;
					}
					else if(aciertos == 4) {
						level = 3;
					}
					else if(aciertos == 6) {
						level = 4;
					}
					else if(aciertos == 8) {
						level = 5;
					}
					else if(aciertos == 10) {
						level = 6;
					}
					else if(aciertos == 12) {
						level = 7;
					}
					else if(aciertos == 14) {
						level = 8;
					}
				}
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

	public String[] getCuadros() {
		return cuadros;
	}

	public Cuadro getCuadro() {
		return cuadro;
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
