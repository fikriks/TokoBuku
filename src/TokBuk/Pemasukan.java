/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TokBuk;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Fikri Khairul Shaleh
 */
public class Pemasukan extends javax.swing.JInternalFrame {

    /**
     * Creates new form Pemasukan
     */
    private koneksi kon = new koneksi();
    private Connection con;
    private Statement stat;
    private ResultSet rs;
    private String sql;
    private DefaultTableModel model,model1;
    private JasperReport jasper;
    private JasperPrint print;
    
    public Pemasukan() {
        initComponents();
        con = kon.con;
        stat = kon.stat;
        jComboBox1.removeAllItems();
        String[] bulan = {"Pilih Bulan","Januari","Februari","Maret","April","Mei","Juni","Juli","Agustus","September","Oktober","November","Desember"};
        for(String a: bulan){
          jComboBox1.addItem(a);
        }
       harian();
       font();
       ((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
       this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
       try{
           FileReader fr = new FileReader("src/tema.txt");
           BufferedReader br = new BufferedReader(fr);
           if(br.readLine().equals("Light")){
               
           }else{
               tema();
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }
    
    private void font(){
        try{
            File file = new File("src/font");
            if(file.canRead()){
                String[] namafile = file.list();
                FileInputStream fis = new FileInputStream("src/font/"+namafile[0]);
                FileInputStream fis1 = new FileInputStream("src/font/"+namafile[4]);
                Font font = Font.createFont(Font.TRUETYPE_FONT, fis);
                Font font1 = Font.createFont(Font.TRUETYPE_FONT, fis1);
                Font sizeFont = font.deriveFont(24f);
                Font sizeFont1 = font1.deriveFont(14f);
                jLabel1.setFont(sizeFont);
                jTabbedPane1.setFont(sizeFont1);
                jLabel1.setFont(sizeFont1);
                jLabel2.setFont(sizeFont1);
                jLabel3.setFont(sizeFont1);
                jLabel4.setFont(sizeFont1);
                jLabel5.setFont(sizeFont1);
                jLabel6.setFont(sizeFont1);
                jLabel7.setFont(sizeFont1);
                jButton1.setFont(sizeFont1);
                jButton2.setFont(sizeFont1);
                jButton3.setFont(sizeFont1);
                jTable1.setFont(sizeFont1);
                jTable2.setFont(sizeFont1);
                jTable1.getTableHeader().setFont(sizeFont1);
                jTable2.getTableHeader().setFont(sizeFont1);
                jComboBox1.setFont(sizeFont1);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void tema(){
        this.setBackground(Color.BLACK);
        jPanel1.setBackground(Color.BLACK);
        jPanel2.setBackground(Color.BLACK);
        jPanel3.setBackground(Color.BLACK);
        jLabel1.setForeground(Color.WHITE);
        jLabel2.setForeground(Color.WHITE);
        jLabel3.setForeground(Color.WHITE);
        jLabel4.setForeground(Color.WHITE);
        jLabel5.setForeground(Color.WHITE);
        jLabel6.setForeground(Color.WHITE);
        jLabel7.setForeground(Color.WHITE);
        jTabbedPane1.setForeground(Color.BLACK);
        jButton1.setForeground(Color.WHITE);
        jButton2.setForeground(Color.WHITE);
        jButton3.setForeground(Color.WHITE);
        jTable1.setBackground(Color.BLACK);
        jTable1.setForeground(Color.WHITE);
        jTable1.getTableHeader().setForeground(Color.BLACK);
        jTable2.setBackground(Color.BLACK);
        jTable2.setForeground(Color.WHITE);
        jTable2.getTableHeader().setForeground(Color.BLACK);
        ImageIcon icon = new ImageIcon("src/img/icons8_MacOS_Close_30px_1.png");
        jButton4.setIcon(icon);
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
    }
    
    private void harian(){
        try{
        String[] judul = {"No","Nota","Judul","Harga","Qty","Harga Total","Tanggal"};
        model = new DefaultTableModel(null,judul){
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        sql = "SELECT judul,harga_jual,qty,tanggal,nota FROM penjualan_detail,penjualan,buku WHERE tanggal=CURDATE() AND buku.id=id_buku AND penjualan.id=penjualan_detail.id_penjualan";
        rs = stat.executeQuery(sql);
        while(rs.next()){
            String[] data = {"",rs.getString("nota"),rs.getString("judul"),rs.getString("harga_jual"),rs.getString("qty"),"",rs.getString("tanggal")};
            model.addRow(data);
        }
        jTable2.setModel(model);
         for(int i=0;i<jTable2.getRowCount();i++){
                String nomer = String.valueOf(i+1);
                int total = (Integer.parseInt(jTable2.getValueAt(i, 3).toString())*Integer.parseInt(jTable2.getValueAt(i, 4).toString()));
                jTable2.setValueAt(nomer, i, 0);
                jTable2.setValueAt(total, i, 5);
            }
         ((DefaultTableCellRenderer)jTable2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
         DefaultTableCellRenderer render = new DefaultTableCellRenderer();
         render.setHorizontalAlignment(JLabel.CENTER);
         jTable2.getColumnModel().getColumn(0).setCellRenderer(render);
         jTable2.getColumnModel().getColumn(1).setCellRenderer(render);
         jTable2.getColumnModel().getColumn(2).setCellRenderer(render);
         jTable2.getColumnModel().getColumn(3).setCellRenderer(render);
         jTable2.getColumnModel().getColumn(4).setCellRenderer(render);
         jTable2.getColumnModel().getColumn(5).setCellRenderer(render);
         jTable2.getColumnModel().getColumn(6).setCellRenderer(render);
         try{
             sql = "SELECT SUM(harga_jual * qty) AS tot FROM penjualan,penjualan_detail,buku WHERE penjualan.tanggal=CURDATE() AND penjualan.id=id_penjualan AND buku.id=id_buku";
             rs = stat.executeQuery(sql);
             if(rs.next()){
                 jLabel6.setText(rs.getString("tot"));
             }
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, e.getMessage());
         }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void aturTable(){
       String[] judul = {"No","Nota","Judul","Harga","Qty","Harga Total","Tanggal"};
        model1 = new DefaultTableModel(null,judul){
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        try{
        sql = "SELECT nota,judul,harga_jual,qty,harga_jual*qty as tot,tanggal FROM penjualan_detail,penjualan,buku WHERE MONTH(tanggal)='"+jComboBox1.getSelectedIndex()+"' AND buku.id=id_buku AND penjualan.id=penjualan_detail.id_penjualan";
        rs = stat.executeQuery(sql);
        while(rs.next()){
            String[] data = {"",rs.getString("nota"),rs.getString("judul"),rs.getString("harga_jual"),rs.getString("qty"),rs.getString("tot"),rs.getString("tanggal")};
            model1.addRow(data);
        }
        jTable1.setModel(model1);
        for(int i=0;i<jTable1.getRowCount();i++){
                String nomer = String.valueOf(i+1);
                jTable1.setValueAt(nomer, i, 0);
            }
        try{
            sql = "SELECT SUM(harga_jual * qty) AS tot FROM penjualan,penjualan_detail,buku WHERE MONTH(tanggal)='"+jComboBox1.getSelectedIndex()+"' AND buku.id=id_buku AND penjualan.id=penjualan_detail.id_penjualan";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                jLabel3.setText(rs.getString("tot"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer render1 = new DefaultTableCellRenderer();
        render1.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(render1);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(render1);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(render1);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(render1);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(render1);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(render1);
        jTable1.getColumnModel().getColumn(6).setCellRenderer(render1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_print_32px.png"))); // NOI18N
        jButton3.setText("Cetak");
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Total");

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        jTabbedPane1.addTab("Harian", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("Bulan");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_ok_32px.png"))); // NOI18N
        jButton1.setText("OK");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setText("Total");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_print_32px.png"))); // NOI18N
        jButton2.setText("Cetak");
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(51, 415, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jLabel4))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bulanan", jPanel2);

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_stack_of_money_64px.png"))); // NOI18N
        jLabel1.setText("Toko Buku : Pemasukan");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_stack_of_money_32px_1.png"))); // NOI18N
        jLabel7.setText("Pemasukan");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_MacOS_Close_30px.png"))); // NOI18N
        jButton4.setContentAreaFilled(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_MacOS_Close_30px_1.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       if(jComboBox1.getSelectedIndex()==0){
           JOptionPane.showMessageDialog(null, "Siahkan pilih bulan");
       }else{
        aturTable();
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
             File file = new File("src/TokBuk/harian.jasper");
            HashMap hm = new HashMap();
            jasper = (JasperReport) JRLoader.loadObject(file);
            print = JasperFillManager.fillReport(jasper, hm, con);
            JasperViewer.viewReport(print,false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            File  file = new File("src/TokBuk/bulanan.jasper");
            HashMap hm = new HashMap();
            hm.put("index", jComboBox1.getSelectedIndex());
            jasper = (JasperReport) JRLoader.loadObject(file);
            print = JasperFillManager.fillReport(jasper, hm,con);
            JasperViewer.viewReport(print,false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
