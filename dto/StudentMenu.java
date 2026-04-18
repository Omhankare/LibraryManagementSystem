package LibraryManagementSystem.dto;

import LibraryManagementSystem.service.BookService;
import LibraryManagementSystem.service.StudentService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentMenu {

    public static void displayStudentMenu(Connection conn) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int choice;
        BookService bookService = new BookService();
        StudentService studentService = new StudentService();

        do {
            System.out.println("========================================");
            System.out.println(" 1. Search a Book.");
            System.out.println(" 2. Check out Book.");
            System.out.println(" 3. Check in Book.");
            System.out.println(" 4. Exit From Application.");
            System.out.println("========================================");

            System.out.println("Please Enter your choice.");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    searchBook(conn);
                    break;
                case 2:
                    bookService.checkOutBook(conn);
                    break;
                case 3:
                    bookService.checkInBook(conn);
                    break;
                case 4:
                    System.out.println("Thank You for using Library Managemnet System.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select valid option.");
            }

        } while (choice != 4);
    }

    private static void searchBook(Connection conn) throws SQLException {
        Scanner sc = new Scanner(System.in);
        BookService bookService = new BookService();
        System.out.println(" 1. Search with Book Serial No.");
        System.out.println(" 2. Search with Book's Author Name.");

        System.out.println("Please Enter your choice.");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                bookService.searchBySrNo(conn);
                break;
            case 2:
                bookService.searchByAuthorName(conn);
        }
    }
}