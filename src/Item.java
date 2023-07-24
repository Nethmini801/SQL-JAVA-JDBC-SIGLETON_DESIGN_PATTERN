import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Item {

    public void getItem() throws ClassNotFoundException, SQLException{
        // Class.forName("com.mysql.cj.jdbc.Driver");


        // Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade", "root", "1998415Nethu#");


        //1st way of getting the connection using DBConnection class
        Connection conn=DBConnection.getInstance().getConnection();

           
        /*  //2nd way of getting the connection using DBConnection class
         DBConnection db=DBConnection.getInstance();
         Connection conn=db.getConnection();

         */

       PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Item LIMIT 5");


       ResultSet rs = pstmt.executeQuery();


        //Loop the result set and print them
        while(rs.next()){
            System.out.println(rs.getString(1) + " " + rs.getString(3) + " " + rs.getDouble(5));
        }
    }
    
}
