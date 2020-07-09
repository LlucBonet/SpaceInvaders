package tp.p1.objetos;

import tp.p1.controlador.CommandExecuteException;
import tp.p1.game.Game;

public class UCMShip extends Ship {
	private UCMMissile missile;
	
	public UCMShip(Game game, int fila, int col, int live, int STRENGTH, int DAMAGE, int POINTS) {
		super(game, fila, col, live, STRENGTH, DAMAGE, POINTS);
		missile = new UCMMissile(game, getFila(), getCol(), 1, false);
		game.addObject(missile);
		
	}

	public int getPOINTS() {
		return this.POINTS;
	}

	public int setPoints(int points) {
		return this.POINTS = points;
	}
	
	//OVERRIDES GAMEOBJECT
	@Override
	public void computerAction() {}

	@Override
	public boolean onDelete() {
		return true;
	}

	@Override
	public void move() {
		if(!this.missile.enableWeapon) {
			this.missile.fila = this.fila;
			this.missile.col = this.col;
		}
	}

	@Override
	public String toString() {
		if(this.isAlive()) {
			return "^__^";
		}
		else {
			return "!xx!?";
		}
	}
	
	@Override
	public String stringifierToString() {
		String misil = "";
		if(this.missile.enableWeapon) misil = ";misil en tablero";
		return "P;" + this.col + "," +  this.fila + ";" + this.live + ";" + this.POINTS + misil + "\n"; 
	}
	
	//IMPLEMENTS IGAMEFLOW
	@Override
	public boolean moveUCMShip(int numCells) throws CommandExecuteException {
		if((numCells == 1 && this.getCol() < Game.DIM_X - 1) || numCells == 2 && this.getCol() < Game.DIM_X -2 ) {
			this.col += numCells;
			return true;
		}
		else if ((numCells == -1 && this.getCol() > 0) || numCells == -2 && this.getCol() > 0) {
			this.col += numCells;
			return true;
		}
		else {
			throw new CommandExecuteException("move");
		}
	}
	
	
	//OVERRIDES IATTACK
	public boolean receiveBombAttack(int damage) {
		this.live -= damage;
		return true;
	}
	
}
