package main.java.exceptions;

public class RegistrationCodeFormatException extends IllegalArgumentException {
	public RegistrationCodeFormatException(String message) {
		super(message);
	}
}
