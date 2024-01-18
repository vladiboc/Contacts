package org.example.exception;

public class WrongContactStringException extends ContactsAppException {
  public WrongContactStringException() {
  }

  public WrongContactStringException(String message) {
    super(message);
  }

  public WrongContactStringException(String message, Throwable cause) {
    super(message, cause);
  }

  public WrongContactStringException(Throwable cause) {
    super(cause);
  }

  public WrongContactStringException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
