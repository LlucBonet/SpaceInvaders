package tp.p1.controlador;

import tp.p1.game.Game;

public class ListPrintersCommand extends Command {

	public ListPrintersCommand() {
		super("listprinter", "lp", "listprinter([lp])", "prints list of available printer types.");
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		System.out.println("boardprinter : prints the game formatted as a board of dimension: 9x8 \n" +
							"stringifier : prints the game as plain text \n");
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(commandWords[0].equals(this.shortcut) || commandWords[0].equals(this.name)) {
			if(commandWords.length == 1) {
				ListPrintersCommand lp = new ListPrintersCommand();
				return lp; 
			}
			else throw new CommandParseException("arg");
		}
		else {
			return null;
		}
	}

}
