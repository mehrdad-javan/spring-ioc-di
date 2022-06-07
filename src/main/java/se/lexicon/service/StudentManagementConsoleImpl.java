package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dao.StudentDAO;
import se.lexicon.model.Student;
import se.lexicon.util.UserInputService;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {

  UserInputService userInputService;
  StudentDAO studentDAO;

  @Autowired
  public StudentManagementConsoleImpl(UserInputService userInputService, StudentDAO studentDAO) {
    this.userInputService = userInputService;
    this.studentDAO = studentDAO;
  }

  @Override
  public Student create() {
    System.out.println("enter a name:");
    String name = userInputService.getString();
    Student student = new Student(name);
    Student savedData = studentDAO.save(student);
    return savedData;
  }

  @Override
  public Student save(Student student) {
    if (student == null ) throw new IllegalArgumentException("Student is null");
    return studentDAO.save(student);
  }

  @Override
  public Student find(int id) {
    // todo: implement find
    return null;
  }

  @Override
  public Student remove(int id) {
    // todo: implement remove
    return null;
  }

  @Override
  public Student edit(Student student) {
    // todo: implement edit
    return null;
  }
}
