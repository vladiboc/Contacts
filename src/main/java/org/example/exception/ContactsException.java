package org.example.exception;

public class ContactsException extends Exception {
  public ContactsException() {
  }

  public ContactsException(String message) {
    super(message);
  }

  public ContactsException(String message, Throwable cause) {
    super(message, cause);
  }

  public ContactsException(Throwable cause) {
    super(cause);
  }

  public ContactsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
