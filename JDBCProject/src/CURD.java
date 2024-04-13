import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLException;

class DatabaseCreated {
    Connection conn = null;
    Statement state = null;

    public  void DBcreate() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/";
            String database="Management";
            String username="root";
            String password="@Radhakrishna297";
            conn=DriverManager.getConnection(url, username, password);
            state=conn.createStatement();
            String sql="CREATE DATABASE IF NOT EXISTS "+database;
            state.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Your Database Created", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Driver Not Found",e.getMessage(), JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error:",e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try{
                if(state!=null){
                    state.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

}

public class CURD {
    public static void main(String[] args) throws Exception {
        DatabaseCreated ob = new DatabaseCreated();
        ob.DBcreate();
    }
}
