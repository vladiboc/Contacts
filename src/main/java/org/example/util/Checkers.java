package org.example.util;

import org.example.exception.NewContactStringException;

public class Checkers {

  public static String[] checkInputFields(String input) throws NewContactStringException {
    String[] inputFields = input.split("; ");
    if (inputFields.length != 3) {
      throw new NewContactStringException(ErrorStrings.THREE_FIELDS_NEEDED);
    }
    return inputFields;
  }

  public static String checkFio(String fio) throws NewContactStringException {
    String[] fioFields = fio.split(" ");
    if (fioFields.length != 3) {
      throw new NewContactStringException(ErrorStrings.FIO_NOT_THREE_WORDS);
    }
    for (String s : fioFields) {
      if (!s.matches("^[А-ЯЁ][а-яё]+$")) {
        throw new NewContactStringException(ErrorStrings.NANE_TO_BE_CORRECT);
      }
    }
    return fio;
  }

  public static String checkPhoneNumber(String phoneNumber) throws NewContactStringException {
    if (!phoneNumber.matches("^[+]7[0-9]{10}$")) {
      throw new NewContactStringException(ErrorStrings.PHONE_NUMBER_TO_BE_CORRECT);
    }
    return phoneNumber;
  }

  public static String checkEmailAddress(String emailAddress) throws NewContactStringException {
    if (!emailAddress.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
      throw new NewContactStringException(ErrorStrings.EMAIL_ADDRESS_TO_BE_CORRECT);
    }
    return emailAddress;
  }

  private Checkers() {}

}