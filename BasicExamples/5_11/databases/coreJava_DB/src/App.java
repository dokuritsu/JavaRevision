import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            // 1. Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish a connection
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "Haikyuu17*";
            Connection con = DriverManager.getConnection(url, user, password);

            // 3. Creating a statement
            Statement st = con.createStatement();

            // 4. Execute query: Create, Read, Update, Delete (CRUD)

            // Create a table
            // st.executeUpdate("CREATE TABLE employee(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(30))");

            // Read table
            ResultSet rs = st.executeQuery("SELECT * from employee");
            while(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
            }

            // Update 
            // st.executeUpdate("INSERT into employee (id, name) VALUES ('101', 'Laura')");
            st.executeUpdate("INSERT into employee (id, name) VALUES ('102', 'John')");
            st.executeUpdate("UPDATE employee SET id='100' WHERE id='101'");
            rs = st.executeQuery("SELECT * from employee");
            while(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
            }

            // Delete
            st.executeUpdate("DELETE FROM employee WHERE id='100'");
            rs = st.executeQuery("SELECT * from employee");
            while(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
            }

            // 5. Close connection
            
        } catch (ClassNotFoundException ce){
            System.out.println("Driver loading problems");
            System.out.println(ce.getMessage());
            ce.printStackTrace();
        } catch (SQLException se){
            System.out.println(se.getMessage());
        }

    }
}
