package org.example.data;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Lazy
public record Contact(String fio, String phoneNumber, String emailAddress) {

  @Override
  public String toString() {
    return fio + " | " + phoneNumber + " | " + emailAddress;
  }

}