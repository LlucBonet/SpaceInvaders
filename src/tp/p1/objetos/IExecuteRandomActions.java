package tp.p1.objetos;

import tp.p1.game.Game;

public interface IExecuteRandomActions {
	static boolean canGenerateRandomOvni(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getFrecOvni();
	}
	static boolean canGenerateRandomBomb(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getFrecDisparo();
	}
	static boolean canGenerateExplosiveAlien(Game game) {
		return game.getRandom().nextDouble() < 0.05;
	}
}
