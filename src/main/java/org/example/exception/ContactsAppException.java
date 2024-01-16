package org.example.exception;

public class ContactsAppException extends Exception {
  public ContactsAppException() {
  }

  public ContactsAppException(String message) {
    super(message);
  }

  public ContactsAppException(String message, Throwable cause) {
    super(message, cause);
  }

  public ContactsAppException(Throwable cause) {
    super(cause);
  }

  public ContactsAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
