import java.sql.*;

public class Crud {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url="jdbc:postgresql://localhost:5432/demo";
        String uname="postgres";
        String pass="priya";
        //Insert
        //String sql="insert into student values(5,'John',48)";
        //update
        //String sql="update student set sname='Max' where sid=5";
        //delete
        String sql="delete from student where sid=5";

        Connection con= DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection established");

        Statement st=con.createStatement();
        boolean status=st.execute(sql);
        //execute -> returns false(boolean) if any insert / update / delete
        //execute -> returns count - for select
        System.out.println(status);
        con.close();
        System.out.println("Connection closed");

    }
}
