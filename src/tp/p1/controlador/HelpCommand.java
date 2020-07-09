package tp.p1.controlador;

import tp.p1.game.Game;


public class HelpCommand extends Command {

	public HelpCommand() {
		super("help", "h", "[H]elp", "Prints this help message.");
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(CommandGenerator.commandHelp());
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(commandWords[0].equals(this.shortcut) || commandWords[0].equals(this.name)) {
			if(commandWords.length == 1) {
				HelpCommand help = new HelpCommand();
				return help; 		
			}
			else throw new CommandParseException("arg");
		}
		else {
			return null;
		}
	}

}
