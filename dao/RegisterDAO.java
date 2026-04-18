package LibraryManagementSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterDAO {
    public boolean doRegister(Connection conn, String userName , String password){

        String query = "INSERT INTO login(user_name, password, user_type) VALUES (?, ?, ?)";

        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setString(3, "user");

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}