package view;

import controller.StudentController;
import dto.StudentDTO;

import java.util.Scanner;

public class StudentView {
    StudentController studentController = new StudentController();
    Scanner scanner = new Scanner(System.in);

    public void addStudent(){
        System.out.println("Enter Name: ");
        String name = scanner.next();

        StudentDTO studentDTO = new StudentDTO(
                name
        );

        Boolean resp = studentController.addNewStudent(studentDTO);
        if (resp){
            System.out.println("Student Added");
        }
    }

    public void searchStudent(){
        System.out.print("Enter student ID to search: ");
        int studentId = scanner.nextInt();

        StudentDTO studentDTO = studentController.searchStudent(studentId);
        if (studentDTO != null) {
            System.out.println("Student Details:");
            System.out.println("Name: " + studentDTO.getName());
        } else {
            System.out.println("Student not found");
        }
    }

    public void updateStudent(){
        System.out.print("Enter student ID to update: ");
        int studentId = scanner.nextInt();

        StudentDTO studentDTO = studentController.searchStudent(studentId);
        if (studentDTO != null) {
            System.out.print("Enter new Student Name: ");
            String updatedName = scanner.next();

            boolean resp = studentController.updateStudent(studentId, updatedName);
            if (resp) {
                System.out.println("Student updated successfully");
            } else {
                System.out.println("Failed to update student");
            }
        } else {
            System.out.println("Student not found");
        }
    }

    public void deleteStudent(){
        System.out.print("Enter student ID");
        int studentId = scanner.nextInt();

       Boolean resp = studentController.deleteStudent(studentId);
    }
}
