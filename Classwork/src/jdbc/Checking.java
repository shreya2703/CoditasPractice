package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Checking {
    public static void main(String[] args) {
        Connection con = ConnectionToJdbc.createConnection();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from student");

            while(rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }


}
