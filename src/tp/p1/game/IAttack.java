package tp.p1.game;

import tp.p1.objetos.GameObject;

public interface IAttack {
	default void performAttack(GameObject other) {}
	
	default boolean receiveMissileAttack(int damage) {return false;};
	default boolean receiveBombAttack(int damage) {return false;};
	default boolean receiveShockWaveAttack(int damage) {return false;};

}
