package tp.p1.controlador;

import tp.p1.game.Game;
//import tp.p1.objetos.DestroyerShip;
//import tp.p1.objetos.Ovni;
//import tp.p1.objetos.RegularShip;
//import tp.p1.objetos.UCMShip;

public class ListCommand extends Command {
	public ListCommand() {
		super("list", "l", "[L]ist", "Prints the list of available ships.");
	}

	@Override
	public boolean execute(Game game) {
		System.out.println("[R]egular ship: Points: 5 - Harm: 0 - Shield: 2" + "\n"+
						   "[D]estroyer ship: Points: 10 - Harm: 1 - Shield: 1" + "\n" +
						   "[O]vni: Points: 25 - Harm: 0 - Shield: 1" + "\n" + 
						   "^__^: Harm: 1 - Shield: 3" + "\n");
		return false;
	}
	
	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(commandWords[0].equals(this.shortcut) || commandWords[0].equals(this.name)) {
			if(commandWords.length == 1) {
				ListCommand list = new ListCommand();
				return list; 
			}
			else throw new CommandParseException("arg");
		}
		else {
			return null;
		}
	}

}
