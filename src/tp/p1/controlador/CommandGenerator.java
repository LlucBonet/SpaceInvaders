package tp.p1.controlador;

public class CommandGenerator {

	private static Command[] availableCommands = {
			new MoveCommand(),
			new ShootCommand(),
			new ShockwaveCommand(),
			new SuperMissileCommand(),
			new ListCommand(),
			new ListPrintersCommand(),
			new StringifyCommand(),
			new ResetCommand(),
			new HelpCommand(),
			new ExitCommand(),
			new NoneCommand(),
			new SaveCommand()
	}; //Atributo
	
	public static Command parseCommand(String[] commandWords) throws CommandParseException {
		Command encontrado = null;
		for(int i = 0; i < availableCommands.length && encontrado == null; i++) {
			encontrado = availableCommands[i].parse(commandWords);
		}
		if(encontrado == null) {
			throw new CommandParseException("com");
		}
		return encontrado;
	}
	
	public static String commandHelp() {
		String helpCommand = availableCommands[0].helpText();
		for(int i = 1; i < availableCommands.length; i++) {
			helpCommand = helpCommand + availableCommands[i].helpText();
		}
		return helpCommand;
	}
}
