package controller;

import dto.BookDTO;
import model.BookModel;

public class BookController {
    BookModel bookModel = new BookModel();

    public Boolean addNewBook(BookDTO bookDTO) {
        return bookModel.saveBook(bookDTO);
    }

    public Boolean deleteBook(int bookId) {
        return bookModel.deleteBook(bookId);
    }

    public BookDTO searchBook(int bookId) {
        return bookModel.searchBook(bookId);
    }

    public boolean updateBook(BookDTO bookDTO) {
        return bookModel.updateBook(bookDTO);
    }
}
