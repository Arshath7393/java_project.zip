package library.service;

import java.util.List;

import library.book.Book;
import library.dao.LibraryDAO;

public class LibraryService {

    private LibraryDAO dao = new LibraryDAO();

    public String addBook(int id, String title, String author) {

        if (dao.findBookById(id) != null) {
            return "Book ID already exists.";
        }

        Book book = new Book(id, title, author);

        if (dao.addBook(book)) {
            return "Book added successfully.";
        }

        return "Failed to add book.";
    }

    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }

    public Book searchBook(int id) {
        return dao.findBookById(id);
    }

    public String issueBook(int id) {

        Book book = dao.findBookById(id);

        if (book == null) {
            return "Book not found.";
        }

        if (!book.isAvailable()) {
            return "Book is already issued.";
        }

        if (dao.issueBook(id)) {
            return "Book issued successfully.";
        }

        return "Failed to issue book.";
    }

    public String returnBook(int id) {

        Book book = dao.findBookById(id);

        if (book == null) {
            return "Book not found.";
        }

        if (book.isAvailable()) {
            return "Book is already available.";
        }

        if (dao.returnBook(id)) {
            return "Book returned successfully.";
        }

        return "Failed to return book.";
    }

    public String deleteBook(int id) {

        Book book = dao.findBookById(id);

        if (book == null) {
            return "Book not found.";
        }

        if (!book.isAvailable()) {
            return "Cannot delete an issued book.";
        }

        if (dao.deleteBook(id)) {
            return "Book deleted successfully.";
        }

        return "Failed to delete book.";
    }
}