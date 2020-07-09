package tp.p1.game;

import tp.p1.controlador.CommandExecuteException;

public interface IPlayerController {
	//Player Actions
	public boolean move(int numCells) throws CommandExecuteException;
	public boolean shootMissile(boolean superMissile) throws CommandExecuteException;
	public void shockWave();
	public boolean buySuperMissile() throws CommandExecuteException;
	
	//Callbacks
	public void receivePoints(int points);
	public void enableShockWave() throws CommandExecuteException;
	public void enableMissile();
}
