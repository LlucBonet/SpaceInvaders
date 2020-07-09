package tp.p1.controlador;


import tp.p1.game.Game;
import tp.p1.game.PrinterTypes;

public class StringifyCommand extends Command {
	public StringifyCommand() {
		super("stringify", "st", "[st]ringify", "prints the game as plain text");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game){
		String printer = PrinterTypes.STRINGIFIER.getObject(game).setGame(game);
		System.out.println(printer);
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(commandWords[0].equals(this.shortcut) || commandWords[0].equals(this.name)) {
			StringifyCommand st = new StringifyCommand();
			if(commandWords.length == 1)
				return st; 
			else throw new CommandParseException("arg");
		}
		else {
			return null;
		}
	}

	


}
