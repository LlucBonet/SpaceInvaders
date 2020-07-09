package tp.p1.game;

import tp.p1.controlador.CommandParseException;

public enum Level {
	EASY(4, 2, 0.1, 3, 0.5), // 4, 2 , 0.3, 0.5, 1
	HARD(8, 2, 0.3, 2, 0.2), //8, 4, 0.3, 2, 0.2, 2
	INSANE(8, 4, 0.5, 1, 0.1); //12, 4, 0.5, 1, 0.1, 3
	
	private int numRegularShip;
	private int numDestroyerShip;
	private double frecDisparo;
	private int velocidad;
	private double frecOvni;
	
	
	private Level(int numRegular, int numDestroyer, double frecuenDisp, int vel, double frecOv) { //constructor Level
		this.numRegularShip = numRegular;
		this.numDestroyerShip = numDestroyer;
		this.frecDisparo = frecuenDisp;
		this.velocidad = vel;
		this.frecOvni = frecOv;	
	}
	
	public int getNumRegularShip() {
		return numRegularShip;
	}

	public int getNumDestroyerShip() {
		return numDestroyerShip;
	}

	public double getFrecDisparo() {
		return frecDisparo;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public double getFrecOvni() {
		return frecOvni;
	}
	
	public static Level parse(String cadenaEntrada) throws CommandParseException {
		for (Level level : Level.values()) {
			if (level.name().equalsIgnoreCase(cadenaEntrada)) {
				return level;
			}
//			else {
//				throw new CommandParseException("lev");
//			}
		}
		throw new CommandParseException("lev");
		//return EASY;
	}
}
