import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.sql.SQLException;

// Class
class basicInfo {
    String url = "jdbc:mysql://localhost:3306/SchoolDB";
    String username = "root";
    String password = "@Radhakrishna297";
}

// New Class
class DatabaseCreated {
    Connection conn = null;
    Statement state = null;

    public void DBcreate() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/";
            String database = "Management";
            String username = "root";
            String password = "@Radhakrishna297";
            conn = DriverManager.getConnection(url, username, password);
            state = conn.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS " + database;
            state.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Your Database Created", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Driver Not Found", e.getMessage(), JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error:", e.getMessage(), JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (state != null) {
                    state.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

// New Class
class Inserting extends basicInfo {
    public void insertValue() {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// Driver Location

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Driver not Found", e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        // Built Connection
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stat = conn.createStatement();
            System.out.println("Enter the Roll Number of the Student\nand Press STOP for stop Entering Data");
            while (true) {
                String str = sc.nextLine();
                if (str.equalsIgnoreCase("STOP")) {
                    break;
                }

                int roll = Integer.parseInt(str);
                sc.nextLine();

            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR:", e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

    }
}

public class CURD {
    public static void main(String[] args) throws Exception {
        DatabaseCreated ob = new DatabaseCreated();
        ob.DBcreate();
    }
}
