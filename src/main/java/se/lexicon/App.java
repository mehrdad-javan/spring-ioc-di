package se.lexicon;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.service.StudentManagement;

public class App {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    StudentManagement studentManagement = context.getBean(StudentManagement.class);

  }

}
