import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PreparedStatementCRUD {
    String url="jdbc:postgresql://localhost:5432/demo";
    String uname="postgres";
    String pass="priya";
    Connection con;
    {
        try {
            con = DriverManager.getConnection(url,uname,pass);
            System.out.println("Connection established");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws SQLException {


    }
}
