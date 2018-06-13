package spring.modelo.relacional.services;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String errorMessage) {
		super(errorMessage);
	}
	
	public ObjectNotFoundException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
}
