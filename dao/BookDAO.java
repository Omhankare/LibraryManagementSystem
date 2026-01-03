package LibraryManagementSystem.dao;

import LibraryManagementSystem.dto.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private Book extractBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setSrNo(rs.getInt("sr_no"));
        book.setBookName(rs.getString("name"));
        book.setAuthorName(rs.getString("author_name"));
        book.setBookQty(rs.getInt("qty"));
        return book;
    }

    public Book getBooksById(Connection conn, int id) throws SQLException {
        String query = "select * from books where id=?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                   return extractBook(rs);
                }
            }
        }
        return null;
    }

    public Book getBooksBySno(Connection conn, int srNo) throws SQLException {
        String query = "select * from books where sr_no=?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, srNo);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return extractBook(rs);
                }
            }
        }
        return null;
    }

    public Book getBooksByAuthorName(Connection conn, String authorName) throws SQLException {
        String query = "select * from books where author_name=?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, authorName);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return extractBook(rs);
                }
            }
        }
        return null;
    }

    public Book getBooksBySnoOrBookName(Connection conn, String name, int srNo) throws SQLException {
        String query = "select * from books where name=? or sr_no=?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setInt(2, srNo);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return extractBook(rs);
                }
            }
        }
        return null;
    }


    public Book saveBook(Connection conn, Book book) throws SQLException {
        String query = "insert into books (sr_no , name , author_name  , qty  ) values (?,?,?,?)";

        try (PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, book.getSrNo());
            ps.setString(2, book.getBookName());
            ps.setString(3, book.getAuthorName());
            ps.setInt(4, book.getBookQty());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Book Added Successfully");
            } else {
                System.out.println("Failed to add Book");
            }


        }
        return book;
    }


    public List<Book> getAllBooks(Connection conn) throws SQLException {
        String query = "select * from books";

        List<Book> books = new ArrayList<>();


        try (PreparedStatement ps = conn.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Book book = new Book();
                    book.setAuthorName(rs.getString("author_name"));
                    book.setBookName(rs.getString("name"));
                    book.setBookQty(rs.getInt("qty"));
                    book.setId(rs.getInt("id"));
                    book.setSrNo(rs.getInt("sr_no"));

                    books.add(book);
                }
            }
        }

        return books;
    }

    public void updateBookSrNo(Connection conn, Book book) throws SQLException {
        String query = "update books set sr_no = ? where id = ?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, book.getSrNo());
            ps.setInt(2, book.getId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Book Name updated successfully.");
            } else {
                System.out.println("Failed to update Book Name.");
            }
        }


    }

    public void updateBookName(Connection conn, Book book) throws SQLException {
        String query = "update books set name = ? where id = ?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1,book.getBookName() );
            ps.setInt(2, book.getId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Book Name updated successfully.");
            } else {
                System.out.println("Failed to update Book Name.");
            }
        }

    }

    public void updateBookAuthorName(Connection conn, Book book) throws SQLException {
        String query = "update books set author_name = ? where id = ?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, book.getAuthorName());
            ps.setInt(2, book.getId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Book Author Name updated successfully.");
            } else {
                System.out.println("Failed to update book Author Name.");
            }
        }

    }


    public void updateBookQty(Connection conn, Book book) throws SQLException {
        String query = "update books set qty = ? where id = ?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, book.getBookQty());
            ps.setInt(2, book.getId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Book QTY updated successfully.");
            } else {
                System.out.println("Failed to update book QTY.");
            }
        }

    }
}