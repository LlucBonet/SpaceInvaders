package tp.p1.objetos;

import tp.p1.game.Game;
import tp.p1.game.GameObjectBoard;

public abstract class AlienShip extends EnemyShip {
	
	protected static int numAliens;
	protected static boolean direccion = false; //izquierda falso, derecha verdadero
	protected static boolean esquina = false;

	public AlienShip(Game game, int fila, int col, int live, int STRENGTH, int DAMAGE, int points) {
		super(game, fila, col, live, STRENGTH, DAMAGE, points);
		AlienShip.numAliens = game.getLevel().getNumRegularShip() + game.getLevel().getNumDestroyerShip();
	}
	
	public static int getNumAliens() {
		return AlienShip.numAliens;
	}
	
	public static void setNumAliens(int numAliens) {
		AlienShip.numAliens = numAliens;
	}
	
//	public static int getNumCyclesToMove() {
//		return game.getCurrentCycle() % game.getLevel().getVelocidad();
//	}
	
	

	public static boolean allDead() {
		if(numAliens == 0) return true;
		else return false;
	}
	
	//OVERRIDES GAMEOBJECT
	@Override
	public void move() {
			if(GameObjectBoard.bajar) {
				fila ++;
//				if(game.isFinished()) {
//					game.getWinnerMessage();
//				}
				if(GameObjectBoard.direccion) this.col++;
				else this.col--;
			}
			else{
				if(game.getCurrentCycle() % game.getLevel().getVelocidad() == 0) {

					if(GameObjectBoard.direccion) this.col++;
					else this.col--;
				}
			}
		
		//this.moveBomb();
	}
	
	@Override
	public boolean haveLanded() {
		if(this.fila == Game.DIM_Y-1) {
			return true;
		}
		else return false;
	}
	
	//ABSTRACT METHODS
	//public abstract void moveBomb();
}
