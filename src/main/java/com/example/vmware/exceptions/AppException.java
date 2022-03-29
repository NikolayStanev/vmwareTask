package com.example.vmware.exceptions;

public class AppException extends Exception {
	public static int ERROR_RESPONSE_CODE = 499;

	public static int REQUEST_API_ERROR_RESPONSE_CODE = 498;

	public AppException() {
	}

	public AppException(String message) {
		super(message);
	}

	public AppException(Throwable cause) {
		super(cause);
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
