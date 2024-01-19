package org.example.exception;

public class ContactInputOutputException extends ContactsAppException {
  public ContactInputOutputException() {
  }

  public ContactInputOutputException(String message) {
    super(message);
  }

  public ContactInputOutputException(String message, Throwable cause) {
    super(message, cause);
  }

  public ContactInputOutputException(Throwable cause) {
    super(cause);
  }

  public ContactInputOutputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
