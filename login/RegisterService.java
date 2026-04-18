package LibraryManagementSystem.login;

import LibraryManagementSystem.dao.DatabaseServiceDAO;
import LibraryManagementSystem.dao.RegisterDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class RegisterService {
    Scanner sc = new Scanner(System.in);
    public void doRegister(){

        System.out.println("Please provide username: ");
        String userName = sc.nextLine();

        System.out.println("Please provide password: ");
        String password = sc.nextLine();

        try(Connection conn = DatabaseServiceDAO.getConnection()){
            RegisterDAO registerDAO = new RegisterDAO();

            boolean isRegistered = registerDAO.doRegister(conn,userName,password);

            if(!isRegistered){
                System.out.println("Registration Failed!");
                return;
            }

            System.out.println("Registration Successful!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
