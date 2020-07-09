package tp.p1.game;

import tp.p1.controlador.CommandExecuteException;
import tp.p1.objetos.AlienShip;
import tp.p1.objetos.GameObject;
import tp.p1.objetos.UCMMissile;
import tp.p1.objetos.UCMShip;
import java.util.Random;


public class Game implements IPlayerController {
	public final static int DIM_X = 9;
	public final static int DIM_Y = 8;
	
	private int currentCycle;
	private Random rand;
	private Level level;
	
	GameObjectBoard board; 
	GamePrinter gp;
	private UCMShip player;
	
	private boolean sw = false;
	private boolean doExit;
	private BoardInitializer initializer;
	
	public Game (Level level, Random random) {
		this.rand = random;
		this.level = level;
		initializer = new BoardInitializer();
		initGame();
	}
	
	public void initGame() {
		currentCycle = 0;
		board = initializer.initializeBoard(this, level);
		player = new UCMShip (this, DIM_Y - 1, DIM_X / 2, 3, 3, 1, 0);
		initializer.initialize();
		board.add(player);
	}
	
	public Random getRandom() {
		return rand;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public int getLive(int pos){
		return this.board.getLive(pos);
	}
	
	public int getX(int pos){
		return this.board.getX(pos);
	}
	
	public int getY(int pos){
		return this.board.getY(pos);
	}
	
	public int getCurrentCycle() {
		return this.currentCycle;
	}
	
	public String stringifierInfo() {
		return " -SpaceInvaders v2.0- \n\n" + "G;" + this.currentCycle + "\n" +
				this.getLevel() + "\n" +  this.board.stringifierToString();
	}
	
	public void reset() {
		initGame();
	}
	
	public void addObject(GameObject object) {
		board.add(object);
	}

	public String positionToString(int fila, int col) {
		return board.toString(fila, col);
	}
	
	public boolean isFinished() {
		return playerWin()|| aliensWin() || doExit;
	}
	
	public boolean aliensWin() {
		return !player.isAlive() || board.landed();
	}
	
	private boolean playerWin() {
		return AlienShip.allDead();
	}
	
	public void update() {
	 board.computerAction();
	 board.update();
	 currentCycle++;
	}
	
	public boolean isOnBoard(int fila, int col) { //para bombas/ misiles/ovni
		return (fila >= 0 && fila < DIM_X && col >= 0 ); //&& col < DIM_Y
	}
	
	public void exit() {
		doExit = true;
	}
	
	public String infoToString() {
		String string;
		String s = null;
		if(sw) {
			s = "SI";
		}
		else s = "NO";
		
		string = "Life: " + player.getLive() + "\n" + 
				 "Number of cycles: " + currentCycle + "\n" +
				 "Points: " + this.player.getPOINTS() + "\n" +
				 "Remaing aliens: " + AlienShip.getNumAliens() + "\n" +
				 "ShockWave: " +  s + "\n" +
				 "SuperMissile: " + UCMMissile.getNumSuperMissile() + "\n" ;
		return string;	
	}
	
	public String getWinnerMessage() {
		if(playerWin()) return "Player wins!";
		else if (aliensWin()) return "Aliens win!";
		else if (doExit) return "Player exits the game"; 
		else return "This should not happen";
	}
	
	public void explosiveAction(int fila, int col) {
		board.explosive(fila, col);
	}
	
	public boolean isSw() {
		return this.sw;
	}
	
	public void setSw(boolean sw) {
		this.sw = sw;
	}
	
	//IMPLEMENTS IPLAYERCONTROLLER
	@Override
	public boolean move(int numCells) throws CommandExecuteException { //Hay hueco para moverse?
		 return this.board.moveUCMShip(numCells);
	 }

	@Override
	public boolean shootMissile(boolean superMissile) throws CommandExecuteException {
		return this.board.shoot(superMissile);
	}

	@Override
	public void shockWave() {
		this.board.ShockWave();
	}
	
	@Override
	public boolean buySuperMissile() throws CommandExecuteException {
		if(this.player.getPOINTS() >= 20) {
			this.player.setPoints(this.player.getPOINTS() - 20);
			board.buySuperMissile();
			return true;
		}
		else throw new CommandExecuteException("nopoints"); 
	}
	
	@Override
	public void receivePoints(int points) {
		this.player.setPoints(this.player.getPOINTS() + points);
	}

	@Override
	public void enableShockWave() throws CommandExecuteException {
		if(this.sw) {
			this.shockWave();
			sw = false;
		}
		else throw new CommandExecuteException("sw");
	}
	
	@Override
	public void enableMissile() {}
}
