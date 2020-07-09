package tp.p1.controlador;

import java.io.FileWriter;
import java.io.IOException;

import tp.p1.game.Game;

public class SaveCommand extends Command {
	
	private String NombreFichero;

	public SaveCommand() {
		super("save", "sv", "Save([sv])", "Saves game in file. Write a name for the file");
		// TODO Auto-generated constructor stub
		
	}
	@Override
	public boolean execute(Game game) {
		
		try {
			this.saveinfo(game);
		}catch (IOException ex) {
			System.err.format(ex.getMessage() + "%n %n");
		}
		
		return false;
	}


	@SuppressWarnings("finally")
	@Override
	public Command parse(String[] commandWords) {
		if(commandWords[0].equals(this.shortcut) || commandWords[0].equals(this.name)) {
			try {
				NombreFichero = commandWords[1];
				System.out.println("Game successfully saved in file " + NombreFichero + ".dat. Use the load command to reload it.");
			}catch(RuntimeException ex) {
				System.err.format(ex.getMessage() + " %n %n");
			}finally {
				return this;
			}
		}
		else {
			return null;
		}
	}

	private boolean saveinfo(Game game) throws IOException {
		FileWriter r = null;
		
		r = new FileWriter(NombreFichero + ".txt");
		r.write(game.stringifierInfo());			
		r.close();
			
		
		return false;
	}
	
}