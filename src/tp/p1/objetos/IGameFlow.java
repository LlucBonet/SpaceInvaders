package tp.p1.objetos;

import tp.p1.controlador.CommandExecuteException;

public interface IGameFlow {
	default public GameObject addBomb() {return null;}
	default boolean moveUCMShip(int numCells) throws CommandExecuteException {return false;}
	default public boolean enableWeapon(boolean superMissile) throws CommandExecuteException {return false;}
	default public boolean haveLanded() {return false;}
	//default public boolean isSw() throws CommandExecuteException {return false;}
	default public boolean limite() {return false;}
	default public boolean remove() {return false;}
	default public void buySuperMissile() {}
}
