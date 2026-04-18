package LibraryManagementSystem;

import LibraryManagementSystem.login.LoginService;
import LibraryManagementSystem.login.RegisterService;

import java.sql.SQLException;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) throws ClassNotFoundException , SQLException {

        System.out.println("********* Welcome to the College Library! *********");

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        LoginService loginService = new LoginService();
        RegisterService registerService = new RegisterService();

        switch (choice) {
            case 1:
                registerService.doRegister();
                break;
            case 2:
                loginService.doLogin();
                break;
            default:
                System.out.println("Invalid choice!");
        }


    }
}
