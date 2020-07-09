package tp.p1.controlador;

import tp.p1.game.Game;

public class ExitCommand extends Command {

	public ExitCommand() {
		super("exit", "e",  "[E]xit", "Terminates the program.");
	}

	@Override
	public boolean execute(Game game) {
		game.exit();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(commandWords[0].equals(this.shortcut) || commandWords[0].equals(this.name)) {
			if(commandWords.length == 1) {
				ExitCommand exit = new ExitCommand();
				return exit;
			}
			else throw new CommandParseException("arg");
		}
		else {
			return null;
		}
	}
}
