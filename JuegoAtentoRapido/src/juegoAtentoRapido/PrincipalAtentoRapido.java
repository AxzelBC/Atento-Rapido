package juegoAtentoRapido;

import java.awt.EventQueue;

public class PrincipalAtentoRapido {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				GUIAtentoRapido ventanaJuego = new GUIAtentoRapido();
			}
		});
	}

}
