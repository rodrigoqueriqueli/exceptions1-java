package model.exceptions;

public class DomainException extends RuntimeException { //o exception � serializable

	private static final long serialVersionUID = 1L; 

	public DomainException(String msg) {
		super(msg); //repassando a msg para o construtor da super classe
	}
}
