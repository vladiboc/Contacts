package org.example.util;

public class InfoStrings {
  public static final String MAIN_MENU = System.lineSeparator() +
      "Меню приложения контакты:" + System.lineSeparator() +
      "1 - Вывести весь список контактов" + System.lineSeparator() +
      "2 - Добавить контакт в список" + System.lineSeparator() +
      "3 - Удалить контакт по email" + System.lineSeparator() +
      "4 - Сохранить список контактов в файл" + System.lineSeparator() +
      "Пустая строка и Enter - выйти из приложения";
  public static final String MAIN_MENU_INCORRECT_INPUT =
      " - неправильный ввод. Введите цифру из меню и Enter.";
  public static final String BYE = "До свидания!";
  public static final String LIST_OF_CONTACTS = "Список контактов: ";
  public static final String ADD_CONTACT =
      "Введите новый контакт в заданном формате, например:" + System.lineSeparator() +
          "Иванов Иван Иванович; +79991234567; ivanov@mail.ru";
  public static final String CONTACT_ADDED = "Добавлен контакт: " + System.lineSeparator();
  public static final String CONTACT_INPUT_ERROR = "Ошибка ввода контакта: ";
  public static final String EMPTY_CONTACTS = "Список контактов пуст!";
  public static final String ENTER_EMAIL = "Введите email удаляемого контакта: ";
  public static final String CONTACT_REMOVED = "Удалён контакт: " + System.lineSeparator();
  public static final String LOAD_CONTACTS_FROM = "Загружаем список контактов из файла: ";
  public static final String CONTACTS_LOADED = "Список контактов успешно загружен!";
  public static final String CONTACTS_SAVED_TO = "Список контактов успешно сохранён в файл: ";

  private InfoStrings() {
  }

}