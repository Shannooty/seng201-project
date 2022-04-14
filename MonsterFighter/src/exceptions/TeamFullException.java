package exceptions;

public class TeamFullException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5315714111120614979L;
	
	public TeamFullException() {};
	
	public TeamFullException(String message) {
		super(message);
	}

}
