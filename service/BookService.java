package LibraryManagementSystem.service;

import LibraryManagementSystem.dao.BookDAO;
import LibraryManagementSystem.dto.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

//DAO (Data Access Object) and DTO (Data Transfer Object) patterns are used in Object Relational Mapping.


public class BookService {
    Scanner sc = new Scanner(System.in);

    public void searchBySrNo(Connection conn) throws SQLException {
        System.out.println("Enter Serial No of Book: ");
        int srNo = sc.nextInt();

        BookDAO dao = new BookDAO();
        Book book = dao.getBooksBySno(conn , srNo);

        if(book != null){
            System.out.println("=== Book Details ===");
            System.out.println("Sr No: " + book.getSrNo()
                    + " Book Name: " + book.getBookName()
                    + " Author Name: " + book.getAuthorName());
        }else{
            System.out.println("No Book for Serial No " + srNo + " Found");
        }

    }

    public void searchByAuthorName(Connection conn) throws SQLException {
        System.out.println("Enter Author Name of Book: ");
        sc.nextLine();     //gives error --clear leftover newline

        String authorName = sc.nextLine();

        BookDAO dao = new BookDAO();
        Book book = dao.getBooksByAuthorName(conn , authorName);

        if(book != null){
            System.out.println("=== Book Details ===");
            System.out.println("Sr No: " + book.getSrNo()
                    + " Book Name: " + book.getBookName()
                    + " Author Name: " + book.getAuthorName());
        }else{
            System.out.println("No Book Found for " + authorName);
        }

    }


    public void addBook(Connection conn) throws SQLException {
        System.out.println("Enter Serial No of Book To Add:");
        int srNo = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Book Name To Add:");
        String bookName = sc.nextLine();

        System.out.println("Enter Author Name To Add:");
        String authorName = sc.nextLine();

        System.out.println("Enter Quantity of Books To Add:");
        int qty = sc.nextInt();

        BookDAO dao = new BookDAO();
        Book book = dao.getBooksBySnoOrBookName(conn, bookName, srNo);

        if (book != null) {
            System.out.println("Book Serial Number Or Book Name is Exist Try Another Serial Number or Book Name.");
            return;
        }

        Book input = new Book();
        input.setAuthorName(authorName);
        input.setBookName(bookName);
        input.setBookQty(qty);
        input.setSrNo(srNo);

        dao.saveBook(conn, input);
    }

    public void updateBookBySrNo(Connection conn) throws SQLException {
        System.out.println("Enter Id of Book: ");
        int id = sc.nextInt();

        BookDAO dao = new BookDAO();
        Book book = dao.getBooksById(conn , id);

        if (book != null) {
            System.out.println("=== Book Details ===");
            System.out.println(
                    "Sr No: " + book.getSrNo() +
                            " | Book Name: " + book.getBookName() +
                            " | Author: " + book.getAuthorName() +
                            " | Current Qty: " + book.getBookQty()
            );


            System.out.print("Enter new Book Serial Number: ");
            int newBookSerialNumber = sc.nextInt();

            book.setSrNo(newBookSerialNumber);

            dao.updateBookSrNo(conn, book);


        } else {
            System.out.println("No Book for Id " + id + " Found");
        }

    }

    public void updateBookByName(Connection conn) throws SQLException {
        System.out.println("Enter Id of Book: ");
        int id = sc.nextInt();
        sc.nextLine();

        BookDAO dao = new BookDAO();
        Book book = dao.getBooksById(conn , id);

        if (book != null) {
            System.out.println("=== Book Details ===");
            System.out.println(
                    "Sr No: " + book.getSrNo() +
                            " | Book Name: " + book.getBookName() +
                            " | Author: " + book.getAuthorName() +
                            " | Current Qty: " + book.getBookQty()
            );


            System.out.print("Enter new Book Name: ");
            String newBookName = sc.nextLine();

            book.setBookName(newBookName);

            dao.updateBookName(conn, book);

        } else {
            System.out.println("No Book for Id " + id + " Found");
        }

    }

    public void updateBookByAuthorName(Connection conn) throws SQLException {
        System.out.println("Enter Id of Book: ");
        int id = sc.nextInt();
        sc.nextLine();
        BookDAO dao = new BookDAO();
        Book book = dao.getBooksById(conn , id);

        if (book != null) {
            System.out.println("=== Book Details ===");
            System.out.println(
                    "Sr No: " + book.getSrNo() +
                            " | Book Name: " + book.getBookName() +
                            " | Author: " + book.getAuthorName() +
                            " | Current Qty: " + book.getBookQty()
            );


            System.out.print("Enter new Author Name: ");
            String newAuthorName = sc.nextLine();

            book.setAuthorName(newAuthorName);

            dao.updateBookAuthorName(conn, book);

        } else {
            System.out.println("No Book for Id " + id + " Found");
        }

    }

    public void updateBookByQty(Connection conn) throws SQLException {
        System.out.println("Enter Id of Book: ");
        int id = sc.nextInt();

        BookDAO dao = new BookDAO();
        Book book = dao.getBooksById(conn , id);

        if (book != null) {
            System.out.println("=== Book Details ===");
            System.out.println(
                    "Sr No: " + book.getSrNo() +
                            " | Book Name: " + book.getBookName() +
                            " | Author: " + book.getAuthorName() +
                            " | Current Qty: " + book.getBookQty()
            );


            System.out.print("Enter new quantity: ");
            int newQty = sc.nextInt();

            book.setBookQty(newQty);

            dao.updateBookQty(conn, book);

        } else {
            System.out.println("No Book for Id " + id + " Found");
        }

    }


    public void getAllBooks(Connection conn) throws SQLException {
        BookDAO dao = new BookDAO();
        List<Book> books = dao.getAllBooks(conn);

        System.out.println("+------------+--------------------+------------------+------------+");
        System.out.println("| Book Sr No | Name               | Auth Name        | Quantity   |");
        System.out.println("+------------+--------------------+------------------+------------+");

        for (Book book : books) {
            System.out.printf("| %-10s | %-18s | %-16s | %-10s | \n", book.getSrNo(), book.getBookName(),
                    book.getAuthorName(), book.getBookQty());
            System.out.println("+------------+--------------------+------------------+------------+");
        }
    }



}
