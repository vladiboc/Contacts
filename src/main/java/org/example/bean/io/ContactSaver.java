package org.example.bean.io;

import org.example.data.Contact;
import org.example.util.ErrorStrings;
import org.example.util.InfoStrings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ContactSaver {

  @Value("${contacts.file.save}")
  private String savePath;

  public void save(Map<String, Contact> contacts) {
    List<String> contactsList = new ArrayList<>();
    for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
      contactsList.add(entry.getValue().toFileString());
    }
    try {
      Files.write(Path.of(this.savePath), contactsList);
      System.out.println(InfoStrings.CONTACTS_SAVED_TO + this.savePath);
    } catch (IOException e) {
      System.out.println(ErrorStrings.SAVE_FILE_ERROR + e);
    }
  }

}