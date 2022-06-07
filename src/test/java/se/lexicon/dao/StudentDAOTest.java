package se.lexicon.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.lexicon.config.AppConfig;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Student;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class StudentDAOTest {

  @Autowired
  private StudentDAO testObject;

  @BeforeEach
  public void setup() {
    testObject.save(new Student("Erik Svensson"));
  }

  @Test
  @DisplayName("Given Student student successfully create and successfully equal")
  void save() {
    Student expectedData = new Student(2, "Mehrdad Javan");
    Student actualData = testObject.save(new Student("Mehrdad Javan"));
    assertEquals(expectedData, actualData);
  }

  @Test
  @DisplayName("Given id of 1 findById return expected object")
  void findById() {
    try {
      Student expectedData = new Student(1, "Erik Svensson");
      Student actualData = testObject.find(1);
      assertEquals(expectedData, actualData);
    } catch (DataNotFoundException e) {
      System.out.println(e.getObjectName());
      System.out.println(e.getMessage());
    }

  }

  @Test
  void findById_throws_DataNotFoundException(){
    assertThrows(DataNotFoundException.class, () -> testObject.find(10));
  }


}
