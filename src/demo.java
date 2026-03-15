import java.sql.*;
import java.util.Scanner;
public class demo {
    static String url = "jdbc:postgresql://localhost:5432/demo";
    static String uname = "postgres";
    static String pass = "priya";

    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(url, uname, pass);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Insert");
            System.out.println("2. View");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1: // INSERT
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    String insertSql = "insert into student values (?, ?, ?)";
                    PreparedStatement ps1 = con.prepareStatement(insertSql);
                    ps1.setInt(1, id);
                    ps1.setString(2, name);
                    ps1.setInt(3, marks);

                    ps1.executeUpdate();
                    System.out.println("Inserted Successfully");
                    break;

                case 2: // VIEW
                    String selectSql = "select * from student";
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(selectSql);

                    while (rs.next()) {
                        System.out.println(
                                rs.getInt("sid") + " - " +
                                        rs.getString("sname") + " - " +
                                        rs.getInt("mark")
                        );
                    }
                    break;

                case 3: // UPDATE
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();

                    System.out.print("Enter new marks: ");
                    int newMarks = sc.nextInt();

                    String updateSql = "update student set marks=? where sid=?";
                    PreparedStatement ps2 = con.prepareStatement(updateSql);
                    ps2.setInt(1, newMarks);
                    ps2.setInt(2, uid);

                    int rows = ps2.executeUpdate();
                    if (rows > 0)
                        System.out.println("Updated Successfully");
                    else
                        System.out.println("ID not found");
                    break;

                case 4: // DELETE
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();

                    String deleteSql = "delete from student where sid=?";
                    PreparedStatement ps3 = con.prepareStatement(deleteSql);
                    ps3.setInt(1, did);

                    int deleted = ps3.executeUpdate();
                    if (deleted > 0)
                        System.out.println("Deleted Successfully");
                    else
                        System.out.println("ID not found");
                    break;

                case 5:
                    con.close();
                    System.out.println("Connection Closed");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
