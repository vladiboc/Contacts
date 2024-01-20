package org.example.data;

public record Contact(String fio, String phoneNumber, String emailAddress) {

  public static String FIELD_SEPARATOR_FOR_DISPLAY = " | ";
  public static String FIELD_SEPARATOR_FOR_FILE = ";";
  public static String FIELD_SEPARATOR_FOR_INPUT = "; ";

  @Override
  public String toString() {
    return this.makeString(FIELD_SEPARATOR_FOR_DISPLAY);
  }

  public String toFileString() {
    return this.makeString(FIELD_SEPARATOR_FOR_FILE);
  }

  private String makeString(String fieldSeparator) {
    return fio + fieldSeparator + phoneNumber + fieldSeparator + emailAddress;
  }

}