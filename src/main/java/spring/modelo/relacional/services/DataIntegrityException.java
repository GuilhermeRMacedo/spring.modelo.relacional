package spring.modelo.relacional.services;

public class DataIntegrityException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException(String errorMessage) {
		super(errorMessage);
	}
	
	public DataIntegrityException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
}
