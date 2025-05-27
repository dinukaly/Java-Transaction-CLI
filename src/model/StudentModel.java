package model;

import db.DBConnection;
import dto.StudentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentModel {
    StudentDTO studentDTO = new StudentDTO();
    public Boolean saveStudent(StudentDTO studentDTO) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO students(name) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,studentDTO.getName());

            int i = preparedStatement.executeUpdate();
            return i>0;

        }catch (Exception e){
            e.printStackTrace();
        }
     return false;
    }

    public Boolean deleteStudent(int studentId) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM students WHERE id = ?");
            preparedStatement.setInt(1, studentId);

            int i = preparedStatement.executeUpdate();
            return i > 0;

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public StudentDTO searchStudent(int studentId) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students WHERE id = ?");
            preparedStatement.setInt(1, studentId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new StudentDTO(
                        resultSet.getString(2)
                );
            } else {
                return null;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateStudent(int studentId, String updatedName) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE students SET name = ? WHERE id = ?"
            );
            preparedStatement.setString(1, updatedName);
            preparedStatement.setInt(2, studentId);

            int i = preparedStatement.executeUpdate();
            return i > 0;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
