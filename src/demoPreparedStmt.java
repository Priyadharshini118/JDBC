import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class demoPreparedStmt {
    public static void main(String[] args) throws SQLException {

        int sid=103;
        String sname="Raja";
        int marks=99;

        String url="jdbc:postgresql://localhost:5432/demo";
        String uname="postgres";
        String pass="priya";
        String sql="insert into student values (?,?,?)";
        Connection con= DriverManager.getConnection(url,uname,pass);

        //Statement st=con.createStatement();
        PreparedStatement st =con.prepareStatement(sql);
        st.setInt(1,sid);
        st.setString(2,sname);
        st.setInt(3,marks);
        st.execute();
        con.close();

    }
}
