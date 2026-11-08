package library.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import library.book.Book;
import library.util.DBConnection;

public class LibraryDAO {

    // ADD BOOK
    public boolean addBook(Book book) {

        String sql =
                "INSERT INTO books (book_id, title, author, available) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, book.getBookId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setBoolean(4, true);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            System.out.println("Error while adding book.");

            if (e.getErrorCode() == 1062) {
                System.out.println("Book ID already exists.");
            } else {
                e.printStackTrace();
            }

            return false;
        }
    }

    // DISPLAY ALL BOOKS
    public List<Book> getAllBooks() {

        List<Book> books = new ArrayList<>();

        String sql =
                "SELECT book_id, title, author, available "
                + "FROM books";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Book book = new Book(
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getBoolean("available")
                );

                books.add(book);
            }

        } catch (SQLException e) {

            System.out.println("Error while retrieving books.");
            e.printStackTrace();
        }

        return books;
    }

    // SEARCH BOOK
    public Book findBookById(int bookId) {

        String sql =
                "SELECT book_id, title, author, available "
                + "FROM books WHERE book_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, bookId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Book(
                            rs.getInt("book_id"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getBoolean("available")
                    );
                }
            }

        } catch (SQLException e) {

            System.out.println("Error while searching book.");
            e.printStackTrace();
        }

        return null;
    }

    // ISSUE BOOK
    public boolean issueBook(int bookId) {

        String sql =
                "UPDATE books SET available = false "
                + "WHERE book_id = ? AND available = true";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, bookId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            System.out.println("Error while issuing book.");
            e.printStackTrace();

            return false;
        }
    }

    // RETURN BOOK
    public boolean returnBook(int bookId) {

        String sql =
                "UPDATE books SET available = true "
                + "WHERE book_id = ? AND available = false";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, bookId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            System.out.println("Error while returning book.");
            e.printStackTrace();

            return false;
        }
    }

    // DELETE BOOK
    public boolean deleteBook(int bookId) {

        String sql =
                "DELETE FROM books "
                + "WHERE book_id = ? AND available = true";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, bookId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            System.out.println("Error while deleting book.");
            e.printStackTrace();

            return false;
        }
    }
}