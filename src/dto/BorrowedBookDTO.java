package dto;

import java.util.Date;

public class BorrowedBookDTO {
    private int studentId;
    private int bookId;
    private Date borrow_date;

    public BorrowedBookDTO() {
    }

    public BorrowedBookDTO(int studentId, int bookId, Date borrow_date) {
        this.studentId = studentId;
        this.bookId = bookId;
        this.borrow_date = borrow_date;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }
}
