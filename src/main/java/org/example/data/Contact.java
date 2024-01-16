package org.example.data;

import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope("prototype")
@Lazy
public class Contact {
  private String fio;
  private String phoneNumber;
  private String emailAddress;

  @Override
  public String toString() {
    return fio + " | " + phoneNumber + " | " + emailAddress;
  }

}