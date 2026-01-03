package LibraryManagementSystem.dto;

import LibraryManagementSystem.service.BookService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminMenu {

    public static void displayAdminMenu(Connection conn) throws SQLException {
        Scanner sc = new Scanner(System.in);

        BookService bookService = new BookService();

        int choice;

        do {
            System.out.println("=========================================");
            System.out.println("1. Search a book.");
            System.out.println("2. Add new book.");
            System.out.println("3. Update book.");
            System.out.println("4. Show All Books.");
            System.out.println("5. Register Student.");
            System.out.println("6. Show All Registered Students.");
            System.out.println("7. Exit From Application.");
            System.out.println("=========================================");

            System.out.println("Please Enter your choice: ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    searchBook(conn);
                    break;
                case 2:
                    addNewBook(conn);
                    break;
                case 3:
                    updateBook(conn);
                    break;
                case 4:
                    bookService.getAllBooks(conn);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Thank You for Using Library Management System.");
                    break;
                default:
                    System.out.println("Please select valid options.");

            }

        }while (choice != 7);


    }
    private static void searchBook(Connection conn) throws SQLException {
        Scanner sc = new Scanner(System.in);
        BookService bookService = new BookService();
        System.out.println("1. Search with Book Serial No.");
        System.out.println("2. Search with Book's Author Name.");

        System.out.println("Please Enter your choice For Search By.");

        int choice = sc.nextInt();

        switch (choice){
            case 1:
                bookService.searchBySrNo(conn);
                break;
            case 2:
                bookService.searchByAuthorName(conn);
                break;
        }
    }

    private static void addNewBook(Connection conn) throws SQLException{
        Scanner sc = new Scanner(System.in);
        BookService bookService = new BookService();
        bookService.addBook(conn);
    }


    private static void updateBook(Connection conn) throws SQLException {
        Scanner sc = new Scanner(System.in);
        BookService bookService = new BookService();
        System.out.println("1. Update Book Serial Number By Id.");
        System.out.println("2. Update Book Name By Id.");
        System.out.println("3. Update Book Author Name By Id.");
        System.out.println("4. Update Book Quantity By Id.");

        System.out.println("Please Enter your choice For Update Book By.");

        int choice = sc.nextInt();

        switch (choice){
            case 1:
                bookService.updateBookBySrNo(conn);
                break;
            case 2:
                bookService.updateBookByName(conn);
                break;
            case 3:
                bookService.updateBookByAuthorName(conn);
                break;
            case 4:
                bookService.updateBookByQty(conn);
                break;
        }
    }


}
