package tp.p1.game;

import tp.p1.controlador.CommandExecuteException;
import tp.p1.objetos.GameObject;

public class GameObjectBoard {
	
	private GameObject[] objects;
	private int currentObjects;
	public static boolean direccion;
	public static boolean bajar;

	public GameObjectBoard(int width, int height) {
		direccion = false;
		bajar = false;
		this.currentObjects = 0;
		objects = new GameObject[width*height]; 
	}
	
	private int getCurrentObjects () {
		return this.currentObjects;
	}
	
	public void add (GameObject object) {
		objects[getCurrentObjects()] = object;
		this.currentObjects++;
	}
	
	private GameObject getObjectInPosition (int fila, int col) {
		GameObject encontrado = null;
		for(int i = 0; i < this.getCurrentObjects(); i++) {
			if(objects[i].getFila()==fila && objects[i].getCol()==col) {
				encontrado = objects[i];
			}
		}
		return encontrado;
	}
	
	private int getIndex(int fila, int col) {
		int num = -1;
		for(int i = 0; i < this.getCurrentObjects(); i++) {
			if(objects[i].getFila()==fila && objects[i].getCol()==col) {
				num = i;
			}
		}
		return num;
	}
	
	/* si vuestra solución requiere que sea public, se puede cambiar*/
	private void remove (GameObject object) {
		int pos = getIndex(object.getFila(), object.getCol());
		object = null;
//		if(objects[pos].remove()) { //Comprueba si hay un objeto con bomba no enable. Si la hay también la elimina
//			objects[pos] = null;
//			objects[pos - 1] = null;
//			for(int i = pos - 1; i < this.currentObjects; i++) {
//				objects[i] = objects[i+2];
//			}
//			this.currentObjects -= 2;
//		}
//		else {				
			objects[pos] = null;
			for(int i = pos; i < this.currentObjects; i++) {
				objects[i] = objects[i+1];
			}
			this.currentObjects--;
//		}
	}
	
	private boolean limit() {
		for(int i = 0; i < this.currentObjects; i++) {
			if(objects[i].limite() == true) {
				bajar = true;
				return true;
			}
		}
		return false;
	}
	public void update() {
		//if(!bajar) { 
			if(limit()) { //Comprueba si los aliens tocan final tablero y aun no han bajado
				//bajar = false;
				if(direccion) direccion = false;
				else direccion = true;
			}
		//}
//		else {
//			bajar = false;
//			if(direccion) direccion = false;
//			else direccion = true;
//		}
		for(int i = 0; i < this.currentObjects; i++) {
			objects[i].move();
			checkAttacks(objects[i]); //comprueba ataques que realiza/ recibe objects[i]
		}
		bajar = false;
		removeDead();
	}
	
	private void checkAttacks(GameObject object) {
		for(int i = 0; i < this.currentObjects; i++) {
			object.performAttack(objects[i]);
		}
	}
	
	public void computerAction() {
		for(int i = 0; i < this.currentObjects; i++) {
			objects[i].computerAction();
		}
	}
	
	public boolean landed() {
		for(int i = 0; i < this.currentObjects; i++) {
			if(objects[i].haveLanded()) {
				return true;
			}
		}
		return false;
	}
	
	private void removeDead() {
		for(int i = 0; i < this.getCurrentObjects(); i++) { //Recorre hasta penúltimo obj, no llega a player, 
															  //no queremos q se elimine en ningún caso
			if(!objects[i].isAlive()) {
				remove(objects[i]);
			}
		}
	}
	
	public String stringifierToString() {
		String string = "";
		for(int i = 0; i < this.currentObjects; i++) {
			string = string + objects[i].stringifierToString();
		}
		return string;
	}
	public String toString(int fila, int col) {
		if(getObjectInPosition(fila, col) == null) {
			return " ";
		}
		else return getObjectInPosition(fila, col).toString();
	}
	
	public boolean moveUCMShip(int numCells) throws CommandExecuteException {
		boolean move = false;
		for(int i = 0; i < this.currentObjects && !move; i++) {
			move = this.objects[i].moveUCMShip(numCells);
		}
		return move;
	}
	
	public void ShockWave(){
		
		for(int i = 0; i < this.currentObjects; i++) {
			//objects[i].receiveMissileAttack(1); //hace daño a los mismos objetos q el misil y de la misma forma											//Si en algún momento esto cambia, habría que crear un método específico para el sw
			objects[i].receiveShockWaveAttack(1);
		}
		
	}
	
	public boolean shoot(boolean superMissile) throws CommandExecuteException {
		boolean shoot = false;
		for(int i = 0; i < this.currentObjects && !shoot; i++) {
			shoot = this.objects[i].enableWeapon(superMissile);
		}
		return shoot;
	}
	
	public void explosive(int fila, int col) {
		for(int i = 0; i < this.currentObjects; i++) {
			if((fila == objects[i].getFila()) && (col == objects[i].getCol() + 1||col == objects[i].getCol()- 1)){
				if(objects[i].isAlive()) {
					objects[i].setLive(objects[i].getLive() - 1);
					if(!objects[i].isAlive()) {
						objects[i].onDelete();	
					}
				}
			}
			else if((fila == objects[i].getFila() + 1|| fila == objects[i].getFila() - 1) && (col == objects[i].getCol() + 1||col == objects[i].getCol() - 1 || col == objects[i].getCol())){
				if(objects[i].isAlive()) {
					objects[i].setLive(objects[i].getLive() - 1);
					if(!objects[i].isAlive()) {
						objects[i].onDelete();	
					}
				}
			} 
		}
	}
	public void buySuperMissile() {
		for (int i = 0; i < this.getCurrentObjects(); i++) {
			objects[i].buySuperMissile();
		}
	}

	public int getLive(int pos) {
		return objects[pos].getLive();
	}

	public int getX(int pos) {
		return objects[pos].getCol();
	}
	public int getY(int pos) {
		return objects[pos].getFila();
	}
}
