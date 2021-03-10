package juegoAtentoRapido;

import java.util.Random;

public class Cuadro {

	//Atributos
	private String colorCuadro;
	
	//Metodos
	public String getColorCuadro() {
		Random cualquier = new Random();
		switch (cualquier.nextInt(10) + 1) {
		case 1:
			colorCuadro = "rojo";
			break;
		case 2:
			colorCuadro = "azul";
			break;
		case 3:
			colorCuadro = "amarillo";
			break;
		case 4:
			colorCuadro = "verde";
			break;
		case 5:
			colorCuadro = "blanco";
			break;
		case 6:
			colorCuadro = "negro";
			break;
		case 7:
			colorCuadro = "naranja";
			break;
		case 8:
			colorCuadro = "morado";
			break;
		case 9:
			colorCuadro = "marron";
			break;
		case 10:
			colorCuadro = "gris";
			break;
		}
		return colorCuadro;
	}
}