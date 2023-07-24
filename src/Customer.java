import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {

   
        
        public void getCustomer() throws ClassNotFoundException,SQLException{

            // Class.forName("com.mysql.cj.jdbc.Driver");


            // Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade", "root", "1998415Nethu#");


            //1st way of getting the connection using DBConnection class
            Connection conn=DBConnection.getInstance().getConnection();

           
           /*  //2nd way of getting the connection using DBConnection class
            DBConnection db=DBConnection.getInstance();      //cannot create an object using new DBConnection
                                                            -->if we are using new keyword here that means we can create objects
                                                                as much as we want..new object means a new connection
                                                                here we are focussing on singleton..

            Connection conn=db.getConnection();

            */

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Customer LIMIT 5");


            ResultSet rs = pstmt.executeQuery();


             //Loop the result set and print them
            while(rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getString(3) + " " + rs.getDouble(5));
            }

            

   

    }
    
}
