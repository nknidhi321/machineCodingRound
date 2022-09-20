package exception;

public class InvalidMoveException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public String message() {
		return "Invalid Move";
	}
	
}
