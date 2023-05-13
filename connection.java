package Konfigurasi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jajang Nurjaman
 */

public class Koneksi {

    public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/uts";
        String user = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return conn;
    }

    public static void main(String[] args) {
        try {
            Connection c = Koneksi.getConnection();
            System.out.println(String.format("Connected to database %s " + "successfully.", c.getCatalog()));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void koneksi() {
    try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost/java_transaksi"; //url database
            String user="root"; //user database
            String pass=""; //password database
            con = DriverManager.getConnection(url,user,pass);
            statBrg = con.createStatement(rs.TYPE_SCROLL_SENSITIVE,rs.CONCUR_UPDATABLE);
            rs = statBrg.executeQuery("select * from barang");
            
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                System.exit(0);
            }
    }

}