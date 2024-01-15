package org.example.data;

public record Contact(String fio, String phoneNumber, String emailAddress) {

  @Override
  public String toString() {
    return fio + " | " + phoneNumber + " | " + emailAddress;
  }

}