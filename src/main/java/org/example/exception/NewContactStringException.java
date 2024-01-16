package org.example.exception;

public class NewContactStringException extends ContactsAppException {
  public NewContactStringException() {
  }

  public NewContactStringException(String message) {
    super(message);
  }

  public NewContactStringException(String message, Throwable cause) {
    super(message, cause);
  }

  public NewContactStringException(Throwable cause) {
    super(cause);
  }

  public NewContactStringException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
