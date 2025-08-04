
package com.example.student_management_system;

public interface StudentDaoInterface {
    boolean insertStudent(Student s);
    boolean delete(int roll);
    boolean update(int roll, String update, int choice, Student s);
    void showAllStudents();
    boolean showStudentById(int roll);
}

