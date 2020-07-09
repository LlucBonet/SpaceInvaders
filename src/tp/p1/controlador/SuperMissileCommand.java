package tp.p1.controlador;

import tp.p1.game.Game;

public class SuperMissileCommand extends Command {
	public SuperMissileCommand() {
		super("supermisil", "sm", "SuperMissile([sm])", "Buys a super missile.");
		
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		return game.buySuperMissile();
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(commandWords[0].equals(this.shortcut) || commandWords[0].equals(this.name)) {
			SuperMissileCommand sm = new SuperMissileCommand();
			if(commandWords.length == 1)
				return sm; 
			else throw new CommandParseException("arg");
		}
		else {
			return null;
		}
	}

}
