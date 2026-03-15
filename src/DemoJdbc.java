import java.sql.*;
public class DemoJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
        1.import packages
        import java.sql.*;
        ----------------------------
        2. load and register
        Class.forName("org.postgresql.Driver");
        ----------------------------
        3. create connection
         Connection con=DriverManager.getConnection("","","");
         Connection con=DriverManager.getConnection(url,uname,pass);
         String url="jdbc:postgresql://localhost:5432/demo";
        String uname="postgres";
        String pass="priya";
         ----------------------------
        4. create statement
        Statement st=con.createStatement();
        String sql="select sname from student where sid=1";
        ----------------------------
        5. execute statement
        ResultSet rs= st.executeQuery(sql);
        ----------------------------
        6. process result
        System.out.println(rs.next());
        ----------------------------
        7. close
        con.close();
        */

        String url="jdbc:postgresql://localhost:5432/demo";
        String uname="postgres";
        String pass="priya";
        String sql="select * from student";
        //Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection established");

        Statement st=con.createStatement();
        ResultSet rs= st.executeQuery(sql);
        //System.out.println(rs.next()); //to check any data is there

        while(rs.next()){
            System.out.print(rs.getInt(1)+" - ");
            System.out.print(rs.getString(2)+ " - ");
            System.out.println(rs.getInt(3));
        }

        con.close();
        System.out.println("Connection closed");

    }
}
