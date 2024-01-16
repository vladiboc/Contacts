package org.example.util;

public class ErrorStrings {
  public static final String THREE_FIELDS_NEEDED = "В строке контакта должно быть ровно 3 подстроки, разделённых '; '!";
  public static final String FIO_NOT_THREE_WORDS = "Фио должно состоять из трёх слов - Фамилия Имя Отчество, разделённых пробелом!";
  public static final String NANE_TO_BE_CORRECT = "Фамилия, Имя, Отчество - русскими буквами, с большой, дальше маленькие!";
  public static final String PHONE_NUMBER_TO_BE_CORRECT = "Номер телефона должен начинаться на +7 и содержать ровно 11 цифр!";
  public static final String EMAIL_ADDRESS_TO_BE_CORRECT = "Адрес email задан некорректно!";

  private ErrorStrings() {}
}
