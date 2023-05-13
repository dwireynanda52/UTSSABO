import java.sql.*;
import javax.swing.*;
import javax.xml.crypto.Data;
import net.proteanit.sql.DbUtils;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormBarang extends javax.swing.JFrame {  // class utama dari JFrame FormBarang, script ini cuma
	//contoh untuk menandakan pengisian script dibawah class ini

// Script variable statment
    Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	Statement statBrg;
	Boolean ada = false;

private void display(){
        try{
            String sql="select * from barang";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
 }

 private void Clear(){
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
  }

public FormBarang() {
        initComponents();
        koneksi();   //memanggil fungsi koneksi
        display(); // menggil fungsi dislay untuk menampilkan data ke table
    }

private void TSimpanActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        try{
            koneksi();
            statBrg = con.createStatement();
            String SQL = "insert into barang values('"+jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextField3.getText()+"')";
            statBrg.executeUpdate(SQL);
            display();
            statBrg.close();
            con.close();
            Clear();
            JOptionPane.showMessageDialog(null, "berhasil simpan");
            
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }

    } 

private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        // TODO add your handling code here:
        try {
            koneksi();
            int row =jTable1.getSelectedRow();
            String tabel_klik=(jTable1.getModel().getValueAt(row, 0).toString());
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("select * from barang where kode_barang='"+tabel_klik+"'");
            if(sql.next()){
                String id = sql.getString("kode_barang");
                jTextField1.setText(id);
                String nama = sql.getString("nama_barang");
                jTextField2.setText(nama);
                String harga = sql.getString("harga");
                jTextField3.setText(harga);
            }
        } catch (Exception e) {}
    }        

private void TEditActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        try{
            koneksi();
            statBrg = con.createStatement();
            String SQL = "update barang SET kode_barang = '"+jTextField1.getText()+"', nama_barang = '"+jTextField2.getText()+"', harga = '"+jTextField3.getText()+"' WHERE kode_barang = '"+jTextField1.getText()+"'";
            statBrg.executeUpdate(SQL);
            display();
            statBrg.close();
            con.close();
            Clear();
            JOptionPane.showMessageDialog(null, "berhasil edit");
           
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }        

private void THapusActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        try{
            koneksi();
            statBrg = con.createStatement();
            String SQL = "DELETE FROM barang WHERE kode_barang = '"+jTextField1.getText()+"'";
            statBrg.executeUpdate(SQL);
            display();
            statBrg.close();
            con.close();
            JOptionPane.showMessageDialog(null, "berhasil hapus");
           
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
        
    } 

private void TClearActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        Clear();
} 

private void TKeluarActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
         System.exit(0); // keluar
}  