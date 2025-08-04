package com.example.student_management_system;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        StudentDaoInterface dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Student Management System");

        while (true) {
            System.out.println("\n1. Add Student" +
                    "\n2. Show all Students" +
                    "\n3. Get student by Roll Number" +
                    "\n4. Update Student" +
                    "\n5. Delete Student" +
                    "\n6. Exit");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter student name:");
                    String name = sc.next();
                    System.out.println("Enter student collage name:");
                    String collageName = sc.next();
                    System.out.println("Enter city:");
                    String city = sc.next();
                    System.out.println("Enter percentage:");
                    double percentage = sc.nextDouble();
                    Student st = new Student(name, collageName, city, percentage);
                    boolean inserted = dao.insertStudent(st);
                    System.out.println(inserted ? "Student added successfully." : "Failed to add student.");
                }
                case 2 -> dao.showAllStudents();

                case 3 -> {
                    System.out.println("Enter roll number:");
                    int roll = sc.nextInt();
                    boolean found = dao.showStudentById(roll);
                    if (!found) System.out.println("Student not found.");
                }

                case 4 -> {
                    System.out.println("Enter roll number to update:");
                    int rollNum = sc.nextInt();
                    System.out.println("1. Name\n2. Collage Name\n3. City\n4. Percentage");
                    int fieldOption = sc.nextInt();
                    System.out.println("Enter new value:");
                    String value = sc.next();
                    boolean updated = dao.update(rollNum, value, fieldOption, null);
                    System.out.println(updated ? "Update successful." : "Update failed.");
                }

                case 5 -> {
                    System.out.println("Enter roll number to delete:");
                    int rollToDelete = sc.nextInt();
                    boolean deleted = dao.delete(rollToDelete);
                    System.out.println(deleted ? "Student deleted." : "Delete failed.");
                }

                case 6 -> {
                    System.out.println("Exiting system. Goodbye!");
                    System.exit(0);
                }

                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }
}
