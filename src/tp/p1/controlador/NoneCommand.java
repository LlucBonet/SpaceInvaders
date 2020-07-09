package tp.p1.controlador;

import tp.p1.game.Game;

public class NoneCommand extends Command{

	public NoneCommand() {
		super("none", "n", "[none]", "Skips one cycle.");
		
	}
	
	public boolean execute(Game game) {
		return true;
	}

	public Command parse(String[] commandWords) throws CommandParseException {
		if(commandWords[0].equals(this.shortcut) || commandWords[0].equals(this.name) || commandWords[0].equals("")) {
			NoneCommand none = new NoneCommand();
			if(commandWords.length > 1)
				throw new CommandParseException("arg");
			else return none;
		}
		else {
			return null;
		}
	}

}
