package tp.p1.controlador;

import tp.p1.game.Game;

public class ShockwaveCommand extends Command {

	public ShockwaveCommand() {
		super("shockwave", "w", "Shock[W]ave", "UCM-Ship releases a shock wave.");
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		game.enableShockWave();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(commandWords[0].equals(this.shortcut) || commandWords[0].equals(this.name)) {
			ShockwaveCommand sw = new ShockwaveCommand();
			if(commandWords.length == 1) 
				return sw; 
			else throw new CommandParseException("arg");
		}
		else {
			return null;
		}
	}
}
