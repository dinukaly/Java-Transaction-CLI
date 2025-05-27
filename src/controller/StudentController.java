package controller;

import dto.StudentDTO;
import model.StudentModel;

public class StudentController {
    StudentModel studentModel = new StudentModel();

    public Boolean addNewStudent(StudentDTO studentDTO) {
       return studentModel.saveStudent(studentDTO);
    }

    public Boolean deleteStudent(int studentId) {
        return studentModel.deleteStudent(studentId);
    }

    public StudentDTO searchStudent(int studentId) {
        return studentModel.searchStudent(studentId);
    }

    public boolean updateStudent(int studentId, String updatedName) {
        return studentModel.updateStudent(studentId, updatedName);
    }
}
