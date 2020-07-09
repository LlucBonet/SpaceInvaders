package tp.p1.controlador;

public class CommandParseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String msg;
	
	public CommandParseException(String msg) {
        super();
        this.msg = msg;
    }

	public String getMessage(){
	        
	        String mensaje="";
	         
	        switch(msg){
	            case "com":
	                mensaje="Unknown Command. Try again";
	                break;
	            case "arg":
	                mensaje= "Wrong entry argument(s)";
	                break;
	            case "lev":
	            	mensaje="Wrong level selection";
	            	break;
	        }
	        return mensaje;
	    }
}
