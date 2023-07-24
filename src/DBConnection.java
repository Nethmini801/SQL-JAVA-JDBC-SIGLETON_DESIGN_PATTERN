import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//standard way of using singleton design pattern to jdbc connection

public class DBConnection {


    private Connection connection;
    private static DBConnection dbConnection;


    //after making this constructor as private,we cannot make outside objects by using new keyword,
    //only you can use the name of "DBconnection(class name of this)"
    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade", "root", "1998415Nethu#");
    }


    public Connection getConnection() {
        return connection;
    }


    public static DBConnection getInstance() throws ClassNotFoundException, SQLException {
        //1st way to write this content
        // return (dbConnection == null) ? (dbConnection = new DBConnection()) : dbConnection;

        //2nd way
        if(dbConnection== null){
            dbConnection=new DBConnection();
            return dbConnection;
        }else{
            return dbConnection;
        }
    }

    
}
