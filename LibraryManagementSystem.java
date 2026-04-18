package LibraryManagementSystem;

import LibraryManagementSystem.login.LoginService;
import LibraryManagementSystem.login.RegisterService;

import java.sql.SQLException;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) throws ClassNotFoundException , SQLException {

        Scanner sc = new Scanner(System.in);
        LoginService loginService = new LoginService();
        RegisterService registerService = new RegisterService();

        while (true) {
            System.out.println("\n********* Welcome to the College Library! *********");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    registerService.doRegister();
                    break;

                case 2:
                    loginService.doLogin();
                    return;

                case 3:
                    System.out.println("Thank you! Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }

    }
}
