package tp.p1.controlador;

import tp.p1.game.Game;

public class ShootCommand extends Command {
	private boolean superMissile;
	
	public ShootCommand() {
		super("shoot", "s", "[S]hoot: <[m]issile|supermissile([sm])>", "UCM-Ship launches a missile or supermissile.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		return game.shootMissile(superMissile);
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if((commandWords[0].equals(this.shortcut) || commandWords[0].equals(this.name)) && commandWords.length == 2) {
			ShootCommand shoot = new ShootCommand();
			if(commandWords[1].equals("supermissile") || commandWords[1].equals("sm")) {
				shoot.superMissile = true;
				return shoot; 
			}
			else if(commandWords[1].equals("missile") || commandWords[1].equals("m")){
				shoot.superMissile = false;
				return shoot;
			}
			else throw new CommandParseException("arg");
		}
		else if((commandWords[0].equals(this.shortcut) || commandWords[0].equals(this.name)) && commandWords.length != 2) {
			throw new CommandParseException("arg");
		}
		else return null;
	}

}
