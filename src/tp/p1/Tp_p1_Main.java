package tp.p1;

import tp.p1.controlador.CommandParseException;
import tp.p1.controlador.Controller;
import tp.p1.game.*;

import java.util.Random;

public class Tp_p1_Main {
	private static Random rand;
	
	public static void main(String[] Args) {
		try {
			if(Args.length == 1){
				Level level = Level.parse(Args[0]);
				
				rand = new Random();
				Game game = new Game(level, rand);	
				Controller.run(game);
			}
			else if(Args.length == 2){
				Level level = Level.parse(Args[0]);
				
				int seed = Integer.parseInt(Args[1]);
				rand = new Random(seed);
				
				Game game = new Game(level, rand);
				Controller.run(game);
			} 
			else {
				throw new CommandParseException("arg");
			}
		}catch(CommandParseException | RuntimeException ex) {
			System.err.format(ex.getMessage() + " %n %n");
		}
	}
}
