package tp.p1.controlador;

import tp.p1.game.Game;

public class ResetCommand extends Command {

	public ResetCommand() {
		super("reset", "r", "[R]eset", "Starts a new game.");
	}

	@Override
	public boolean execute(Game game) {
		game.reset();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(commandWords[0].equals(this.shortcut) || commandWords[0].equals(this.name)) {
			ResetCommand reset = new ResetCommand();
			if(commandWords.length == 1)
				return reset;
			else throw new CommandParseException("arg");
		}
		else {
			return null;
		}
	}
}
