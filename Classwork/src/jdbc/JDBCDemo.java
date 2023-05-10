package jdbc;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {

        try {
            //1 Loading the driver
            //2 Establish connection
            //3 Write query using statement
            //4 ResultSet



            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eltp_jan_23","root","Star@123");

            Statement statement = connection.createStatement();

           ResultSet rs = statement.executeQuery("select * from student");


            while(rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
            }
            //statement.executeQuery("insert into student values(4,'PQR',78)");


            System.out.println("Done Successfully");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    }
