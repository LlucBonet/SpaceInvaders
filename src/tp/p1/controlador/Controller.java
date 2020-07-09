package tp.p1.controlador;

import java.util.Scanner;

import tp.p1.game.Game;
import tp.p1.game.PrinterTypes;

public class Controller {
	private static final String PROMPT = "Command > ";
	private static Scanner in = new Scanner(System.in);
	private static String printer;  
	
	public Controller(Game game) {
	}
	
	public static void run(Game game) {
		printer = PrinterTypes.BOARDPRINTER.getObject(game).setGame(game);
		System.out.println(printer);
		
		while(!game.isFinished()) {
			System.out.println(PROMPT);
			String[] words = in.nextLine().toLowerCase().trim().split("\\s+");
			try {
				Command command = CommandGenerator.parseCommand(words);
					if(command.execute(game)) {
						game.update();
						printer = PrinterTypes.BOARDPRINTER.getObject(game).setGame(game);
						System.out.println(printer);	
						
					}
					if(game.isFinished()) {
						System.out.println(game.getWinnerMessage());
					}
			}catch(CommandParseException | CommandExecuteException ex) {
				System.err.format(ex.getMessage() + "%n%n");
			}
		}
	}
}