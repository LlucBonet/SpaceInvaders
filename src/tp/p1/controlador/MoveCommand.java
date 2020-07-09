package tp.p1.controlador;

import tp.p1.game.Game;

public class MoveCommand extends Command {

	int numCells = 0;
	public MoveCommand() {
		super("move", "m", "[M]ove: <[l]eft|[r]ight><1|2>", "Moves UCM-Ship to the indicated direction.");
	}

	private void setNumCells(int numCells) {
		 this.numCells = numCells;
	}
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		game.move(this.numCells);
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if((commandWords[0].equals(this.shortcut) || commandWords[0].equals(this.name)) && commandWords.length == 3) {
			MoveCommand move = new MoveCommand();
			if((commandWords[1].equals("left")||commandWords[1].equals("l")) && commandWords[2].equals("1")) {
				move.setNumCells(-1);
				return move;
			}
			else if((commandWords[1].equals("left") ||commandWords[1].equals("l")) && commandWords[2].equals("2")) {
				move.setNumCells(-2);
				return move;
			}
			else if((commandWords[1].equals("right")||commandWords[1].equals("r")) && commandWords[2].equals("1")) {
				move.setNumCells(1);
				return move;
			}
			else if((commandWords[1].equals("right")||commandWords[1].equals("r")) && commandWords[2].equals("2")) {
				move.setNumCells(2);
				return move;
			}
			else throw new CommandParseException("arg");
		}
		else if((commandWords[0].equals(this.shortcut) || commandWords[0].equals(this.name)) && commandWords.length != 3) {
			throw new CommandParseException("arg");
		}
		else return null;
	}
}
