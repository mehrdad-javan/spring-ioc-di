package se.lexicon.service;

import se.lexicon.model.Student;

public interface StudentManagement {

  Student create();

  Student save(Student student);

  Student find(int id);

  Student remove(int id);

  Student edit(Student student);

}
