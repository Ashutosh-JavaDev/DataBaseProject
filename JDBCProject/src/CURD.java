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
            while (true) {
                System.out.println("Enter the Roll Number of the Student\nand Press STOP for stop Entering Data");
                String str = sc.nextLine();
                if (str.equalsIgnoreCase("STOP")) {
                    break;
                }

                int roll = Integer.parseInt(str);
                // sc.nextLine();
                System.out.print("Student First Name:");
                String Fname = sc.nextLine();

                try {
                    if (Fname.equals(" ")) {
                        System.out.print("Enter Valid Name");
                        Fname = sc.nextLine();
                    } else {
                        System.out.print("First Name: " + Fname);
                        System.out.println();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.print("Student Last Name:");
                String Lname = sc.nextLine();

                try {
                    if (Lname.equals(" ")) {
                        System.out.print("Enter Valid Name");
                        Lname = sc.nextLine();
                    } else {
                        System.out.print("Last Name: " + Lname);
                        System.out.println();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.print("Class: ");
                String classes = sc.nextLine();
                System.out.print("Section: ");
                String section = sc.nextLine();
                System.out.print("Gender: ");
                String Gender = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Phone Number :");
                String number = sc.nextLine();
                System.out.print("Session Completing Year: ");
                String batch = sc.nextLine();
                System.out.print("Eng: ");
                float eng = sc.nextFloat();
                System.out.print("Math: ");
                float math = sc.nextFloat();
                System.out.print("Phy: ");
                float phy = sc.nextFloat();
                System.out.print("Che: ");
                float che = sc.nextFloat();
                System.out.print("Computer:");
                float comp = sc.nextFloat();
                System.out.print("Statics: ");
                float statics = sc.nextFloat();
                System.out.println("Press Enter to add new Data");
                float Total = eng + math + phy + che + comp + statics;
                // sc.nextLine();
                float Avg = (Float) Total / 6;
                sc.nextLine();
                String values = String.format(
                        "Insert into  Student (Roll,Fname,Lname,gender,email,number,class,section,batch,Eng,Math,Phy,Che,Computer,Stat,Total,Ave)"
                                + "VALUES(%d,'%s','%s','%s','%s','%s','%s','%s','%s',%f,%f,%f,%f,%f,%f,%f,%f)",
                        roll, Fname, Lname, Gender, email, number, classes, section, batch, eng, math, phy, che, comp,
                        statics, Total, Avg);
                // Excute Query
                int result = stat.executeUpdate(values);
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Data Inserted Sucessfully", "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Data Not Inserted Sucessfully", "Error!",
                            JOptionPane.INFORMATION_MESSAGE);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR:", e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

    }
}
class updating extends Inserting{
    
}

public class CURD {
    public static void main(String[] args) throws Exception {
        Inserting ob = new Inserting();
        ob.insertValue();
    }
}
