package model;


import db.DBConnection;
import dto.BookDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookModel {
    public Boolean saveBook(BookDTO bookDTO) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO books(title, available_quentity) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookDTO.getTitle());
            preparedStatement.setInt(2, bookDTO.getAvailableQty());

            int i = preparedStatement.executeUpdate();
            return i > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean deleteBook(int bookId) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "DELETE FROM books WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookId);

            int i = preparedStatement.executeUpdate();
            return i > 0;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public BookDTO searchBook(int bookId) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE id = ?");
            preparedStatement.setInt(1, bookId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new BookDTO(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3)
                );
            } else {
                return null;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateBook(BookDTO bookDTO) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE books SET title = ?, available_quentity = ? WHERE id = ?"
            );
            preparedStatement.setString(1, bookDTO.getTitle());
            preparedStatement.setInt(2, bookDTO.getAvailableQty());
            preparedStatement.setInt(3, bookDTO.getBookId());

            int i = preparedStatement.executeUpdate();
            return i > 0;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
