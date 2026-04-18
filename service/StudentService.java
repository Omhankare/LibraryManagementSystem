package LibraryManagementSystem.service;

import LibraryManagementSystem.dao.BookDAO;
import LibraryManagementSystem.dao.StudentDAO;
import LibraryManagementSystem.dto.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class StudentService {
    Scanner sc = new Scanner(System.in);

    public void searchBySrNo(Connection conn) throws SQLException {
        System.out.println("Enter Serial No of Book:");
        int srNo = sc.nextInt();

        BookDAO dao = new BookDAO();
        Book book = dao.getBooksBySno(conn, srNo);

        if (book != null) {
            System.out.println("=== Book Details ===");
            System.out.println("Sr No : " + book.getSrNo() + " Book Name: " + book.getBookName() + " Author Name: "
                    + book.getAuthorName());
        } else {
            System.out.println("No Book for Serial No " + srNo + " Found.");
        }
    }

    public static void addStudent(Connection conn) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Studnet Name:");
        String studentName = sc.nextLine();

        System.out.println("Enter Registration No:");
        String regNo = sc.nextLine();

        StudentDAO dao = new StudentDAO();
        boolean isStdExist = dao.getStudentByRegNo(conn, regNo);

        if (isStdExist) {
            System.out.println("Students details exist into our system.");
            return;
        }

        dao.saveStudent(conn, studentName, regNo);
    }

    public static void getAllStudents(Connection conn) throws SQLException {
        StudentDAO dao = new StudentDAO();
        dao.getAllStudents(conn);
    }


}
