package tp.p1.objetos;

import tp.p1.game.*;

public abstract class GameObject implements IAttack, IGameFlow {
	protected int fila;
	protected int col;
	protected int live;
	protected Game game;
	
	public GameObject(Game game, int fila, int col, int live)  {
		//almacenar coordinadas iniciales
		this.game = game;
		this.live = live;
		this.fila = fila;
		this.col = col;
	}

	//metodos que devuelven el valor de las coordenadas
	public int getFila() {
		return this.fila;
	}
	
	public int getCol() {
		return this.col;
	}
	
	public boolean isAlive() {
		return this.live > 0;
	}
	
	public int getLive() {
		return this.live;
	}

	public int setLive(int live) {
		return this.live = live;
	}
	
	public boolean isOnPosition(int f, int c) {
		return this.fila == f && this.col == c;
	}
	
	public void getDamage(int damage) {
		this.live = damage >= this.live ? 0 : this.live - damage;
	}
	
	public boolean isOut() {
		return !game.isOnBoard(this.fila, this.col);
	}
	
	//ABSTRACT METHODS
	public abstract void computerAction();
	public abstract boolean onDelete();
	public abstract void move();
	public abstract String toString();
	public abstract String stringifierToString();
}
