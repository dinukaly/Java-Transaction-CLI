package controller;

import model.BorrowingModel;

import java.sql.SQLException;

public class BorrowingController {

    public boolean borrowBook(int bookId, int studentId) throws SQLException, ClassNotFoundException {
        return BorrowingModel.borrowBook(bookId, studentId);
    }

    public boolean returnBook(int bookId, int studentId) throws SQLException, ClassNotFoundException {
        return BorrowingModel.returnBook(bookId, studentId);
    }
}
