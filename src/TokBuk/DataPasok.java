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
import javax.swing.table.*;
import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Fikri Khairul Shaleh
 */
public class DataPasok extends javax.swing.JInternalFrame {

    /**
     * Creates new form DataPasok
     */
    private Connection con;
    private Statement stat;
    private ResultSet rs;
    private koneksi kon = new koneksi();
    private String sql,klik,judul;
    private int id=0;
    private DefaultTableModel model;
    
    public DataPasok() {
        initComponents();
        setTitle("Data Pasok");
        con = kon.con;
        stat = kon.stat;
        dataCB();
        dataCB1();
        sembunyiOB();
        sembunyi();
        aturTable();
        ((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
       font();
       try{
           FileReader fr = new FileReader("src/tema.txt"); 
           BufferedReader br  = new BufferedReader(fr);
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
                jLabel2.setFont(sizeFont1);
                jLabel3.setFont(sizeFont1);
                jLabel4.setFont(sizeFont1);
                jLabel5.setFont(sizeFont1);
                jLabel6.setFont(sizeFont1);
                jLabel7.setFont(sizeFont1);
                jComboBox1.setFont(sizeFont1);
                jComboBox2.setFont(sizeFont1);
                jCalendarCombo1.setFont(sizeFont1);
                jTextField1.setFont(sizeFont1);
                jTextField2.setFont(sizeFont1);
                jButton1.setFont(sizeFont1);
                jButton2.setFont(sizeFont1);
                jButton3.setFont(sizeFont1);
                jButton4.setFont(sizeFont1);
                jButton5.setFont(sizeFont1);
                jButton6.setFont(sizeFont1);
                jTable1.setFont(sizeFont1);
                jTable1.getTableHeader().setFont(sizeFont1);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void tema(){
        this.setBackground(Color.BLACK);
        jPanel1.setBackground(Color.BLACK);
        jLabel1.setForeground(Color.WHITE);
        jLabel2.setForeground(Color.WHITE);
        jLabel3.setForeground(Color.WHITE);
        jLabel4.setForeground(Color.WHITE);
        jLabel5.setForeground(Color.WHITE);
        jLabel6.setForeground(Color.WHITE);
        jLabel7.setForeground(Color.WHITE);
        jButton1.setForeground(Color.WHITE);
        jButton2.setForeground(Color.WHITE);
        jButton3.setForeground(Color.WHITE);
        jButton4.setForeground(Color.WHITE);
        jButton5.setForeground(Color.WHITE);
        jButton6.setForeground(Color.WHITE);
        ImageIcon icon = new ImageIcon("src/img/icons8_MacOS_Close_30px_1.png");
        jButton7.setIcon(icon);
        jTable1.setBackground(Color.BLACK);
        jTable1.setForeground(Color.WHITE);
        jTable1.getTableHeader().setForeground(Color.BLACK);
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
    }
    
    private void dataCB(){
        jComboBox1.removeAllItems();
        try{
            sql="SELECT nama_distributor FROM distributor";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                jComboBox1.addItem(rs.getString("nama_distributor"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void dataCB1(){
        jComboBox2.removeAllItems();
        try{
            sql="SELECT judul FROM buku";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                jComboBox2.addItem(rs.getString("judul"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void aturTable(){
        int no=1;
        String[] judul = {"No","Nama Distributor","Judul Buku","Jumlah","Tanggal"};
        model = new DefaultTableModel(null,judul){
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        try{
            sql = "SELECT nama_distributor,judul,jumlah,tanggal FROM distributor,buku,pasok WHERE distributor.id=id_distributor AND buku.id=id_buku";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                String[] data = {Integer.toString(no++),rs.getString("nama_distributor"),rs.getString("judul"),rs.getString("jumlah"),rs.getString("tanggal")};
                model.addRow(data);
            }
            jTable1.setModel(model);
            ((DefaultTableCellRenderer)jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(JLabel.CENTER);
            jTable1.getColumnModel().getColumn(0).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(1).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(2).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(3).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(4).setCellRenderer(render);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void reset(){
        jTextField1.setText("");
        jComboBox1.setSelectedItem("");
        jComboBox2.setSelectedItem("");
    }
    
    private void sembunyi(){
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
        jTextField1.setEnabled(false);
        jCalendarCombo1.setEnabled(false);
    }
    
    private void sembunyiCRUD(){
      jButton1.setEnabled(false);
      jButton2.setEnabled(false);
      jButton3.setEnabled(false);
    }
    
    private void sembunyiOB(){
      jButton4.setEnabled(false);
      jButton5.setEnabled(false);
    }
    
    private void tampil(){
        jComboBox1.setEnabled(true);
        jComboBox2.setEnabled(true);
        jTextField1.setEnabled(true);
        jCalendarCombo1.setEnabled(true);
    }
    
    private void tampilCRUD(){
      jButton1.setEnabled(true);
      jButton2.setEnabled(true);
      jButton3.setEnabled(true);
    }
    
    private void tampilOB(){
      jButton4.setEnabled(true);
      jButton5.setEnabled(true);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton7 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jCalendarCombo1 = new org.freixas.jcalendar.JCalendarCombo();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("Nama Distributor");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText("Judul Buku");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setText("Jumlah");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_32px.png"))); // NOI18N
        jButton1.setText("Tambah");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_edit_32px.png"))); // NOI18N
        jButton2.setText("Edit");
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_trash_32px_1.png"))); // NOI18N
        jButton3.setText("Hapus");
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_ok_32px.png"))); // NOI18N
        jButton4.setText("OK");
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_cancel_32px.png"))); // NOI18N
        jButton5.setText("Cancel");
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
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
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setText("Tanggal");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_32px.png"))); // NOI18N
        jLabel6.setText("Cari");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_print_32px.png"))); // NOI18N
        jButton6.setText("Cetak");
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_truck_64px.png"))); // NOI18N
        jLabel1.setText("Toko Buku : Data Pasok");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_truck_32px.png"))); // NOI18N
        jLabel7.setText("Data Pasok");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_MacOS_Close_30px.png"))); // NOI18N
        jButton7.setContentAreaFilled(false);
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_MacOS_Close_30px_1.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox2, 0, 98, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCalendarCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 72, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(79, 79, 79))))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jCalendarCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        klik = "tambah";
        reset();
        sembunyiCRUD();
        tampilOB();
        tampil();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(Integer.toString(id).equals("0")){
            JOptionPane.showMessageDialog(null, "Silahkan pilih data yang ingin di ubah");
        }else{
        klik = "edit";
        sembunyiCRUD();
        tampilOB();
        tampil();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(Integer.toString(id).equals("0")){
            JOptionPane.showMessageDialog(null, "Silahkan pilih data yang ingin di hapus");
        }else{
            if(JOptionPane.showConfirmDialog(null, "Apakah yakin ingin menghapus data ini?","Peringatan",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
               try{
                String sql1,sql2;
                int stokawal,stokakhir;
                sql = "SELECT stok FROM buku WHERE judul='"+jComboBox2.getSelectedItem()+"'";
                rs = stat.executeQuery(sql);
                if(rs.next()){
                        stokakhir = rs.getInt("stok") - Integer.parseInt(jTextField1.getText());
                        sql1 = "UPDATE buku set stok='"+stokakhir+"'WHERE judul='"+jComboBox2.getSelectedItem()+"'";
                        stat.execute(sql1);
                        sql2 = "DELETE FROM pasok WHERE id='"+id+"'";
                        stat.execute(sql2);
                        JOptionPane.showMessageDialog(null, "Data telah di hapus");
                }
                reset();
                model.fireTableDataChanged();
                model.getDataVector().removeAllElements();
                aturTable();    
                reset();
                sembunyi();
                tampilCRUD();
                sembunyiOB();
                }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
            }else{
                reset();
                reset();
                sembunyi();
                tampilCRUD();
                sembunyiOB();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(klik=="tambah"){
            if(jTextField1.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ada data yang belum di isi");
            }else{
                try{
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String sql1,sql2;
                int stokawal,stokakhir;
                sql = "SELECT stok FROM buku where judul='"+jComboBox2.getSelectedItem().toString()+"'";
                rs = stat.executeQuery(sql);
                if(rs.next()){
                     stokawal = rs.getInt("stok");
                     stokakhir = stokawal + Integer.parseInt(jTextField1.getText());
                     sql1 = "INSERT INTO pasok(id_distributor,id_buku,jumlah,tanggal)VALUE((SELECT id FROM distributor WHERE nama_distributor='"+jComboBox1.getSelectedItem()+"'),(SELECT id FROM buku WHERE judul='"+jComboBox2.getSelectedItem()+"'),'"+jTextField1.getText()+"','"+df.format(jCalendarCombo1.getDate())+"')";
                     stat.execute(sql1);
                     sql2="UPDATE buku set stok='"+stokakhir+"'WHERE id=(SELECT id FROM buku WHERE judul='"+jComboBox2.getSelectedItem()+"')";
                     stat.execute(sql2);
                     JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
                     model.fireTableDataChanged();
                     model.getDataVector().removeAllElements();
                     aturTable();
                     reset();
                     sembunyi();
                     sembunyiOB();
                     tampilCRUD();
                }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }else if(klik=="edit"){
           try{
            if(jComboBox2.getSelectedItem().toString().equals(judul)){
                 sql = "UPDATE pasok set id_distributor=(SELECT id FROM distributor WHERE nama_distributor='"+jComboBox1.getSelectedItem()+"'),id_buku=(SELECT id from buku WHERE judul='"+jComboBox2.getSelectedItem()+"'),jumlah='"+jTextField1.getText()+"'WHERE id='"+id+"'";
                 stat.execute(sql);
                 JOptionPane.showMessageDialog(null,"Sukses ubah data judul sama");
                }else{
                    sql = "SELECT stok FROM buku WHERE judul='"+judul+"'";
                    rs = stat.executeQuery(sql);
                    if(rs.next()){
                        int stokawal,stokakhir,stokakhir1;
                        stokawal = rs.getInt("stok");
                        sql = "SELECT jumlah FROM pasok WHERE id_buku=(SELECT id FROM buku WHERE judul='"+judul+"')";
                        rs = stat.executeQuery(sql);
                        if(rs.next()){
                            stokakhir = stokawal - rs.getInt("jumlah");
                            sql = "UPDATE buku set stok='"+stokakhir+"' WHERE judul='"+judul+"'";
                            stat.execute(sql);
                            sql = "UPDATE pasok set id_distributor=(SELECT id FROM distributor WHERE nama_distributor='"+jComboBox1.getSelectedItem()+"'),id_buku=(SELECT id from buku WHERE judul='"+jComboBox2.getSelectedItem()+"'),jumlah='"+jTextField1.getText()+"'WHERE id='"+id+"'";
                            stat.execute(sql);
                            sql = "SELECT stok FROM buku WHERE judul='"+jComboBox2.getSelectedItem()+"'";
                            rs = stat.executeQuery(sql);
                            if(rs.next()){
                            stokakhir1 = rs.getInt("stok") + Integer.parseInt(jTextField1.getText());
                            sql = "UPDATE buku set stok='"+stokakhir1+"'WHERE judul='"+jComboBox2.getSelectedItem()+"'";
                            stat.execute(sql);
                            }
                        }
                    }
            }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
       /* try{
            sql = "SELECT jumlah FROM pasok WHERE id='"+id+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(jTextField1.getText().equals(rs.getString("jumlah"))){
                    sql = "UPDATE pasok set id_distributor=(SELECT id FROM distributor WHERE nama_distributor='"+jComboBox1.getSelectedItem()+"'),id_buku=(SELECT id from buku WHERE judul='"+jComboBox2.getSelectedItem()+"'),jumlah='"+jTextField1.getText()+"'WHERE id='"+id+"'";
                    stat.execute(sql);
                    JOptionPane.showMessageDialog(null,"Sukses ubah data");
                }else{
                    sql = "SELECT stok FROM buku WHERE judul='"+jComboBox2.getSelectedItem()+"'";
                    rs = stat.executeQuery(sql);
                    if(rs.next()){
                        int stokawal,stokakhir,stokakhir1;
                        stokawal = rs.getInt("stok");
                        sql = "SELECT jumlah FROM pasok WHERE id='"+id+"'";
                        rs = stat.executeQuery(sql);
                        if(rs.next()){
                            stokakhir = stokawal - rs.getInt("jumlah");
                            sql = "UPDATE buku set stok='"+stokakhir+"' WHERE judul='"+jComboBox2.getSelectedItem()+"'";
                            stat.execute(sql);
                            sql = "UPDATE pasok set id_distributor=(SELECT id FROM distributor WHERE nama_distributor='"+jComboBox1.getSelectedItem()+"'),id_buku=(SELECT id from buku WHERE judul='"+jComboBox2.getSelectedItem()+"'),jumlah='"+jTextField1.getText()+"'WHERE id='"+id+"'";
                            stat.execute(sql);
                            sql = "SELECT stok FROM buku WHERE judul='"+jComboBox2.getSelectedItem()+"'";
                            rs = stat.executeQuery(sql);
                            if(rs.next()){
                            stokakhir1 = rs.getInt("stok") + Integer.parseInt(jTextField1.getText());
                            sql = "UPDATE buku set stok='"+stokakhir1+"'WHERE judul='"+jComboBox2.getSelectedItem()+"'";
                            stat.execute(sql);
                            }
                        }
                    }
                }
            }
                     model.fireTableDataChanged();
                     model.getDataVector().removeAllElements();
                     aturTable();
                     reset();
                     sembunyi();
                     sembunyiOB();
                     tampilCRUD();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }*/
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try{
              sql = "SELECT pasok.id,nama_distributor,judul,jumlah,tanggal FROM distributor,buku,pasok WHERE distributor.id=(SELECT id FROM distributor WHERE nama_distributor='"+jTable1.getValueAt(jTable1.getSelectedRow(), 1)+"') AND buku.id=(SELECT id FROM buku WHERE judul='"+jTable1.getValueAt(jTable1.getSelectedRow(), 2)+"') AND distributor.id=id_distributor AND buku.id=id_buku";
              rs = stat.executeQuery(sql);
              if(rs.next()){
                  reset();
                  tampilCRUD();
                  sembunyiOB();
                  sembunyi();
                  id = rs.getInt("id");
                  judul = rs.getString("judul");
                  jComboBox1.setSelectedItem(rs.getString("nama_distributor"));
                  jComboBox2.setSelectedItem(rs.getString("judul"));
                  jTextField1.setText(rs.getString("jumlah"));
                  //jCalendarCombo1.setDate(rs.getDate("tanggal"));
                  //((JTextField)jDateChooser)
                  Date date = (Date) new SimpleDateFormat("yyyy-MM-dd").parse((String) jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
                  jCalendarCombo1.setDate(date);
              }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Hanya karakter angka yang diperbolehkan");    
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        reset();
        sembunyi();
        sembunyiOB();
        tampilCRUD();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        if(jTextField2.getText().isEmpty()){
            model.fireTableDataChanged();
            model.getDataVector().removeAllElements();
            aturTable();
        }else{
             model.fireTableDataChanged();
            model.getDataVector().removeAllElements();
            int no=1;
             String[] judul = {"No","Nama Distributor","Judul Buku","Jumlah","Tanggal"};
            model = new DefaultTableModel(null,judul){
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        try{
            sql = "SELECT nama_distributor,judul,jumlah,tanggal FROM distributor,buku,pasok WHERE (nama_distributor LIKE '%"+jTextField2.getText()+"%' OR judul LIKE '%"+jTextField2.getText()+"%') AND distributor.id=id_distributor AND buku.id=id_buku";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                String[] data = {Integer.toString(no++),rs.getString("nama_distributor"),rs.getString("judul"),rs.getString("jumlah"),rs.getString("tanggal")};
                model.addRow(data);
            }
            jTable1.setModel(model);
            ((DefaultTableCellRenderer)jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(JLabel.CENTER);
            jTable1.getColumnModel().getColumn(0).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(1).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(2).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(3).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(4).setCellRenderer(render);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try{
            String a = "scr/TokBuk/pasok.jasper";
            File y = new File(a);
            JasperReport report = (JasperReport) JRLoader.loadObject(y);
            JasperPrint print = JasperFillManager.fillReport(report, null, con);
            JasperViewer.viewReport(print);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private org.freixas.jcalendar.JCalendarCombo jCalendarCombo1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
