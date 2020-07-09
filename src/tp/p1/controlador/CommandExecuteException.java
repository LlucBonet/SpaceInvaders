package tp.p1.controlador;

public class CommandExecuteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

	public CommandExecuteException(String msg) {
	    super();
	    this.msg = msg;
	}
	
	public String getMessage(){
        
        String mensaje="";
         
        switch(msg){
            case "move":
                mensaje="Not enough space to move UCMShip or too many cells selected. Try again.";
                break;
            case "sw":
                mensaje="ShockWave not available. Destroy an ovni.";
                break;
            case "s":
                mensaje="Missile not available. There is currently a missile on the board.";
                break;
            case "sm":
            	mensaje="Supermissile not available. There is currently a supermissile on the board.";
            	break;
            case"noSm":
            	mensaje = "Supermissile not available. Buy a supermissil.";
            	break;
            case "nopoints":
            	mensaje = "Not enough points to buy super missile.";
            	break;
        }
        return mensaje;
    }
}
