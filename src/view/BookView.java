package view;

import controller.BookController;
import controller.BorrowingController;
import dto.BookDTO;

import java.sql.SQLException;
import java.util.Scanner;

public class BookView {
    BookController bookController = new BookController();
    BorrowingController borrowingController = new BorrowingController();
    Scanner scanner = new Scanner(System.in);

    public void addBook() {
        System.out.print("Enter Title: ");
        String title = scanner.next();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        BookDTO bookDTO = new BookDTO(
                0,
                title,
                quantity
        );

        Boolean resp = bookController.addNewBook(bookDTO);
        if (resp) {
            System.out.println("Book added successfully");
        } else {
            System.out.println("Failed to add book");
        }
    }

    public void searchBook() {
        System.out.print("Enter book ID to search: ");
        int bookId = scanner.nextInt();

        BookDTO bookDTO = bookController.searchBook(bookId);
        if (bookDTO != null) {
            System.out.println("Book Details:");
            System.out.println("Title: " + bookDTO.getTitle());
            System.out.println("Quantity: " + bookDTO.getAvailableQty());
        } else {
            System.out.println("Book not found");
        }
    }

    public void updateBook() {
        System.out.print("Enter book ID to update: ");
        int bookId = scanner.nextInt();

        BookDTO bookDTO = bookController.searchBook(bookId);
        if (bookDTO != null) {
            System.out.print("Enter new Title: ");
            String title = scanner.next();
            
            System.out.print("Enter new quantity: ");
            int quantity = scanner.nextInt();

            bookDTO.setTitle(title);
            bookDTO.setAvailableQty(quantity);
            
            boolean resp = bookController.updateBook(bookDTO);
            if (resp) {
                System.out.println("Book updated successfully");
            } else {
                System.out.println("Failed to update book");
            }
        } else {
            System.out.println("Book not found");
        }
    }

    public void deleteBook() {
        System.out.print("Enter book ID to delete: ");
        int bookId = scanner.nextInt();

        Boolean resp = bookController.deleteBook(bookId);
        if (resp) {
            System.out.println("Book deleted successfully");
        } else {
            System.out.println("Failed to delete book");
        }
    }

    public void borrowBook() throws SQLException, ClassNotFoundException {
        System.out.print("Enter book ID to borrow: ");
        int bookId = scanner.nextInt();

        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        boolean success = borrowingController.borrowBook(bookId, studentId);
        if (success) {
            System.out.println("Book borrowed successfully");
        } else {
            System.out.println("Book borrowing fail");
        }
    }

    public void returnBook() throws SQLException, ClassNotFoundException {
        System.out.print("Enter book ID to return: ");
        int bookId = scanner.nextInt();

        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        boolean success = borrowingController.returnBook(bookId, studentId);
        if (success) {
            System.out.println("Book returned successfully");
        } else {
            System.out.println("Book retuning fail");
        }
    }
}
