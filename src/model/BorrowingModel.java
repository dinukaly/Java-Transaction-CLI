package model;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowingModel {

    public static boolean borrowBook(int bookId, int studentId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        // check book have
        PreparedStatement ps1 = connection.prepareStatement(
                "SELECT available_quentity FROM books WHERE id = ?");
        ps1.setInt(1, bookId);
        ResultSet rs = ps1.executeQuery();

        if (rs.next() && rs.getInt(1) > 0) {
            // insert into borrow book
            PreparedStatement ps2 = connection.prepareStatement(
                    "INSERT INTO borrowed_books (book_id, student_id) VALUES (?, ?)");
            ps2.setInt(1, bookId);
            ps2.setInt(2, studentId);

            int borrowSaved = ps2.executeUpdate();
            if (borrowSaved > 0) {
                // update book quntity
                PreparedStatement ps3 = connection.prepareStatement(
                        "UPDATE books SET available_quentity = available_quentity - 1 WHERE id = ?");
                ps3.setInt(1, bookId);

                int qtyUpdated = ps3.executeUpdate();
                if (qtyUpdated > 0) {
                    connection.commit();
                    connection.setAutoCommit(true);
                    return true;
                }
            }
        }
        connection.rollback();
        connection.setAutoCommit(true);
        return false;
    }

    public static boolean returnBook(int bookId, int studentId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        // delete from borrow book
        PreparedStatement ps1 = connection.prepareStatement(
                "DELETE FROM borrowed_books WHERE book_id = ? AND student_id = ?");
        ps1.setInt(1, bookId);
        ps1.setInt(2, studentId);

        int rowsDeleted = ps1.executeUpdate();
        if (rowsDeleted > 0) {
            // update book quantity
            PreparedStatement ps2 = connection.prepareStatement(
                    "UPDATE books SET available_quentity = available_quentity + 1 WHERE id = ?");
            ps2.setInt(1, bookId);

            int qtyUpdated = ps2.executeUpdate();
            if (qtyUpdated > 0) {
                connection.commit();
                connection.setAutoCommit(true);
                return true;
            }
        }
        connection.rollback();
        connection.setAutoCommit(true);
        return false;
    }
}
