package com.codingdojo.fileupload.exceptions;

public class StorageExceptions extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public StorageExceptions(String message) {
		super(message);
	}

	public StorageExceptions(String message, Throwable cause) {
		super(message, cause);
	}
}
