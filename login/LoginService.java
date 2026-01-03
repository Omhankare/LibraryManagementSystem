package LibraryManagementSystem.login;

import LibraryManagementSystem.dto.AdminMenu;
import LibraryManagementSystem.dao.LibraryDAO;
import LibraryManagementSystem.dao.LoginDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginService {
    Scanner sc = new Scanner(System.in);
    public void doLogin(){
        System.out.println("Please provide username: ");
        String userName = sc.nextLine();

        System.out.println("Please provide password: ");
        String password = sc.nextLine();

        try(Connection conn = LibraryDAO.getConnection()){
            LoginDAO loginDAO = new LoginDAO();
            String userType = loginDAO.doLogin(conn,userName,password);

            if(userType == null){
                System.out.println("Invalid User!");
                return;
            }

            System.out.println("Login Success. You logged in as a " + userType + " please select from below options.");

            if(userType.equals("admin")){
                //display admin menu
                AdminMenu.displayAdminMenu(conn);
            }else{
                //display student menu
            }

        } catch (SQLException e) {
           e.printStackTrace();
        }

    }
}
