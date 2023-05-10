package jdbc;
import java.sql.*;
public class PreparedStatementDemo {

    public static void main(String[] args) throws SQLException {

        //1 Loading the driver //class not fpound exception
        //2 Establish connection
        //3 Write query using statement
        //4 ResultSet


        Connection connection=null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eltp_jan_23","root","Star@123");
            connection.setAutoCommit(false); //yeh insensitive hai without commit
           PreparedStatement pst = connection.prepareStatement("insert into student values(?,?,?)");
           pst.setInt(1,15);
           pst.setString(2,"Tanmay");
           pst.setInt(3,90);
           int numberOfRecord = pst.executeUpdate();
           System.out.println("No of record added "+numberOfRecord);

           connection.commit();


//           Statement st = connection.createStatement();
//           st.addBatch("insert into student values(6,'Krati',78)");
//           st.addBatch("insert into student values(7,'Mrunmai',78)");
//           st.addBatch("insert into student values(8,'Harini',78)");

    //        st.addBatch("update student set spercentage = 99 where sid =1");
       //     st.addBatch("delete from student where sid = 8");


//
//           int n[] = st.executeBatch();
//           System.out.println("Done");

//three ways to make object helpful to get gc
//anonymous object
            //pass object value to null



            //How to add 10 records at same time


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
        connection.close();


    }


}
//transaction managemne jdbc savepoint
//rollback tabh hi aeyga jabh exception hoga
//how to comitt and rollback explicitly
