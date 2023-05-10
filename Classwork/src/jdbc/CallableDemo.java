package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableDemo {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eltp_jan_23","root","Star@123");
            CallableStatement call =  connection.prepareCall("call InsertRecord(?,?,?)");//yeh abstraction data hide karne m help
            call.setInt(1,8);
            call.setString(2,"SRK");
            call.setInt(3,90);

            boolean flag = call.execute();//yeh true dega only when u insert the fdirst data id =1 wala
            System.out.println("Records have been affected or not ?"+flag);





        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
//result set is an array
//result set se bhi add delete update karr sakte hai
//system.in.read()
//rs.RefreshRow()
//sensitive hai to update ho jaeyga
//updateRow()

//Statement st = resultset.type scroll sensitive concur updatable


