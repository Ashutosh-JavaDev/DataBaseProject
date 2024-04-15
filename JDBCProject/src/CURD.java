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
    Scanner sc = new Scanner(System.in);

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

class updating extends Inserting {
    public void update() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Driver Not Found", JOptionPane.ERROR_MESSAGE);
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            System.out.println(
                    "Press 1: To Update Roll NO.\nPress 2: To Update FName\nPress 3: To Update LName\nPress 4: To Update Gender\nPress 5: To Update Email\nPress 6: To Update Phone Number\n Press 7: To Update Class\nPress 8: To Update Section\nPress 9: To Update Batch\nPress 10: To Update English Marks\nPress 11: To Update Math Marks\nPress 12: To Update Phy Marks\nPress 13: To Update Che Marks\nPress 14: To Update Computer Marks\nPress 15: To Update Statics Marks\nPress 16: To Update Total Marks\nPress 17: To Update Average");
            int press = sc.nextInt();
            switch (press) {
                case 1:
                System.out.println("Enter Old Roll Number");
                int oldRoll=sc.nextInt();
                System.out.println("Enter New Roll Number");
                int newRoll=sc.nextInt();
                String value=String.format("Update Student set Roll=%d where Roll=%d",newRoll,oldRoll);
                int result=statement.executeUpdate(value);
                if(result>0){
                    JOptionPane.showMessageDialog(null, "Success!", "Data Updated", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    System.out.println("Data Not Updated");
                }
                break;
                case 2:
                System.out.println("Enter Roll Number Whose First Name want to Update");
                int oldFname=sc.nextInt();
                System.out.println("Enter the new Name want to Update.");
                String newName=sc.nextLine();
                String values=String.format("Update Student set FName='%s' where Roll=%d",newName,oldFname);
                int re=statement.executeUpdate(values);
                if(re>0){
                    JOptionPane.showMessageDialog(null, "Success!", "Data Updated", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    System.out.println("Data Not Updated");
                }
                break;
                case 3:
                System.out.println("Enter Roll Number Whose Last Name want to Update");
                int oldLname=sc.nextInt();
                System.out.println("Enter the new Name want to Update.");
                String newLname=sc.nextLine();
                String valus=String.format("Update Student set LName='%s' where Roll=%d",newLname,oldLname);
                int res=statement.executeUpdate(valus);
                if(res>0){
                    JOptionPane.showMessageDialog(null, "Success!", "Data Updated", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    System.out.println("Data Not Updated");
                }
                break;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Data Didn't Updated", JOptionPane.ERROR_MESSAGE);
        }
    }
}

public class CURD {
    public static void main(String[] args) throws Exception {
        updating ob = new updating();
        ob.update();
    }
}
