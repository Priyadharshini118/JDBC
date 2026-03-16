import java.sql.*;
import java.util.Scanner;

public class PreparedStatementCRUD {
    static String url="jdbc:postgresql://localhost:5432/demo";
    static String uname="postgres";
    static String pass="priya";
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection(url, uname, pass);
        Scanner sc=new Scanner(System.in);

        while(true){
            System.out.println("-------------------------------");
            System.out.println("1.Insert");
            System.out.println("2.View");
            System.out.println("3.Update");
            System.out.println("4.Delete");
            System.out.println("5. Exit");
            System.out.println("Enter option :");
            int choice =sc.nextInt();
            switch(choice){
                case 1:
                    insertStudent(con,sc);
                    break;
                case 2:
                    getStudent(con);
                    break;
                case 3:
                    updateStudent(con,sc);
                    break;
                case 4:
                    deleteStudent(con,sc);
                    break;
                case 5:
                    con.close();
                    System.out.println("Connection closed");
                    System.exit(0);
            }
        }

    }

    // INSERT METHOD
    public static void insertStudent(Connection con,Scanner sc) throws SQLException {
        System.out.println("Enter ID:");
        int sid=sc.nextInt();
        System.out.println("Enter Name:");
        String sname=sc.next();
        System.out.println("Enter mark:");
        int marks=sc.nextInt();

        String sql="insert into student1 values (?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,sid);
        ps.setString(2,sname);
        ps.setInt(3,marks);
        ps.executeUpdate();
        System.out.println("Inserted successfully");
    }
    //View Method
    public static void getStudent(Connection con) throws SQLException {
        String sql="select * from student1";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()){
            System.out.println(
                    rs.getInt("sid")+" - "+
                            rs.getString("sname")+" - "+
                            rs.getInt("marks")

            );
        }
    }
    //Update Method
    public static void updateStudent(Connection con, Scanner sc) throws SQLException {
        System.out.println("Enter ID to update :");
        int sid=sc.nextInt();
        System.out.println("Enter new marks :");
        int marks = sc.nextInt();

        String sql="update student1 set marks=? where sid=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,marks);
        ps.setInt(2,sid);

        int rows=ps.executeUpdate();
        if(rows>0){
            System.out.println("Updated successfully");
        }else{
            System.out.println("ID does not found");
        }

    }
    //delete method
    public static void deleteStudent(Connection con, Scanner sc) throws SQLException {
        System.out.println("Enter ID to be deleted:");
        int sid=sc.nextInt();

        String sql="delete from student1 where sid=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,sid);

        int rows=ps.executeUpdate();
        if(rows>0){
            System.out.println("Deleted successfully");
        }else{
            System.out.println("ID not found");
        }

    }

}
