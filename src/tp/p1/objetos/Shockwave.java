package tp.p1.objetos;

//import tp.p1.controlador.CommandExecuteException;
import tp.p1.game.Game;

public class Shockwave extends Weapon {

	public Shockwave(Game game, int fila, int col, int live) {
		super(game, fila, col, live);
	}
	
//	public void setSw(boolean Sw) {
//		this.enableWeapon = Sw;
//	}
	
	//IMPLEMENTS GAMEOBJECT
	@Override
	public void move() {}
	
	@Override
	public boolean onDelete() {
		//this.enableWeapon = false;
		return true;		
	}

	@Override
	public String toString() {
		return " ";
	}
	
	@Override
	public String stringifierToString() {
		return "";
	}
	
	//OVERRIDES IGAMEFLOW
//	@Override
//	public boolean isSw() throws CommandExecuteException {
//		if(this.enableWeapon) {
//			return true;
//		}
//		else throw new CommandExecuteException("sw");
//	}
	
	
	//OVERRIDES IATTACK
//	public void performAttack(GameObject other) {
//		if(this.enableWeapon) {
//			if(other.receiveMissileAttack(1)) {
//				this.enableWeapon = false;
//					return true;
//			}
//			else return false;
//		}
//		else
//		return false;	
//	}

}
