package org.example.bean.io;

import org.example.data.Contact;
import org.example.exception.WrongContactStringException;
import org.example.util.Checkers;
import org.springframework.stereotype.Component;

@Component
public class ContactParser {

  public Contact parseContactFromInput(String input) throws WrongContactStringException {
    return this.parseContactString(input, Contact.FIELD_SEPARATOR_FOR_INPUT);
  }

  public Contact parseContactFromFile(String fileString) throws WrongContactStringException {
    return this.parseContactString(fileString, Contact.FIELD_SEPARATOR_FOR_FILE);
  }

  private Contact parseContactString(String contactString, String fieldSeparator) throws WrongContactStringException {
    final String[] inputFields = Checkers.checkInputFields(contactString, fieldSeparator);

    final String fio = Checkers.checkFio(inputFields[0]);
    final String phoneNumber = Checkers.checkPhoneNumber(inputFields[1]);
    final String emailAddress = Checkers.checkEmailAddress(inputFields[2]);

    return new Contact(fio, phoneNumber, emailAddress);
  }

}
