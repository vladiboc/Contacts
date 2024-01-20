package org.example.util;

import org.example.data.Contact;
import org.example.exception.WrongContactStringException;

public class Checkers {

  public static String[] checkInputFields(String contactString, String fieldSeparator) throws WrongContactStringException {
    String[] inputFields = contactString.split(fieldSeparator);
    if (inputFields.length != 3) {
      throw new WrongContactStringException(ErrorStrings.THREE_FIELDS_NEEDED);
    }
    return inputFields;
  }

  public static String checkFio(String fio) throws WrongContactStringException {
    String[] fioFields = fio.split(" ");
    if (fioFields.length != 3) {
      throw new WrongContactStringException(ErrorStrings.FIO_NOT_THREE_WORDS);
    }
    for (String s : fioFields) {
      if (!s.matches("^[А-ЯЁ][а-яё]+$")) {
        throw new WrongContactStringException(ErrorStrings.NANE_TO_BE_CORRECT);
      }
    }
    return fio;
  }

  public static String checkPhoneNumber(String phoneNumber) throws WrongContactStringException {
    if (!phoneNumber.matches("^[+]7[0-9]{10}$")) {
      throw new WrongContactStringException(ErrorStrings.PHONE_NUMBER_TO_BE_CORRECT);
    }
    return phoneNumber;
  }

  public static String checkEmailAddress(String emailAddress) throws WrongContactStringException {
    if (!emailAddress.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
      throw new WrongContactStringException(ErrorStrings.EMAIL_ADDRESS_TO_BE_CORRECT);
    }
    return emailAddress;
  }

  private Checkers() {}

}