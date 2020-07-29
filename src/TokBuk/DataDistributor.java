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
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.sql.*;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Fikri Khairul Shaleh
 */
public class DataDistributor extends javax.swing.JInternalFrame {

    /**
     * Creates new form DataDistributor
     */
    private DefaultTableModel model;
    private Connection con;
    private koneksi kon = new koneksi();
    private ResultSet rs;
    private Statement stat;
    private String sql,klik;
    private int id=0;
    
    public DataDistributor() {
        initComponents();
        con = kon.con;
        stat = kon.stat;
        setTitle("Data Distributor");
        aturTable();
        sembunyi();
        sembunyiOB();
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
                Font sizeFont1 = font.deriveFont(14f);
                jLabel1.setFont(sizeFont);
                jLabel2.setFont(sizeFont1);
                jLabel3.setFont(sizeFont1);
                jLabel4.setFont(sizeFont1);
                jLabel5.setFont(sizeFont1);
                jLabel6.setFont(sizeFont1);
                jTextField1.setFont(sizeFont1);
                jTextField2.setFont(sizeFont1);
                jTextField3.setFont(sizeFont1);
                jTextField4.setFont(sizeFont1);
                jButton1.setFont(sizeFont1);
                jButton2.setFont(sizeFont1);
                jButton3.setFont(sizeFont1);
                jButton4.setFont(sizeFont1);
                jButton5.setFont(sizeFont1);
                jButton6.setFont(sizeFont1);
                jTable1.setFont(sizeFont1);
                jTable1.getTableHeader().setFont(sizeFont1);
            }
        }catch (Exception e){
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
        jButton1.setForeground(Color.WHITE);
        jButton2.setForeground(Color.WHITE);
        jButton3.setForeground(Color.WHITE);
        jButton4.setForeground(Color.WHITE);
        jButton5.setForeground(Color.WHITE);
        jButton6.setForeground(Color.WHITE);
        jTable1.setBackground(Color.BLACK);
        jTable1.setForeground(Color.WHITE);
        jTable1.getTableHeader().setForeground(Color.BLACK);
        ImageIcon icon = new ImageIcon("src/img/icons8_MacOS_Close_30px_1.png");
        jButton7.setIcon(icon);
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
    }
    
    private void reset(){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
    }
    
    private void sembunyi(){
            jTextField1.setEnabled(false);
            jTextField2.setEnabled(false);
            jTextField3.setEnabled(false);
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
            jTextField1.setEnabled(true);
            jTextField2.setEnabled(true);
            jTextField3.setEnabled(true);
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
    
    private void aturTable(){
        int no=1;
        String[] judul = {"No","Nama Distributor","Alamat","Telepon"};
        model = new DefaultTableModel(null,judul){
          @Override
          public boolean isCellEditable(int row,int column){
              return false;
          }
        };
        try{
            sql = "SELECT * FROM distributor";
            rs = stat.executeQuery(sql);
            while (rs.next()){
                String[] data = {Integer.toString(no++),rs.getString("nama_distributor"),rs.getString("alamat"),rs.getString("telepon")};
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
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("Nama Distributor");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText("Alamat");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setText("Telepon");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
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

        jButton3.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
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
        jButton5.setText("Batal");
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_32px.png"))); // NOI18N
        jLabel5.setText("Cari");

        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_print_32px.png"))); // NOI18N
        jButton6.setText("Cetak");
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_MacOS_Close_30px.png"))); // NOI18N
        jButton7.setToolTipText("");
        jButton7.setContentAreaFilled(false);
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_MacOS_Close_30px_1.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_supplier_30px_1.png"))); // NOI18N
        jLabel6.setText("Data Distributor");

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_supplier_60px.png"))); // NOI18N
        jLabel1.setText("Toko Buku : Data Distributor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 119, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jButton4)
                                .addGap(32, 32, 32)
                                .addComponent(jButton5)))
                        .addContainerGap(60, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(45, 45, 45))))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
     
           reset();
           klik = "tambah";
           tampilOB();
           sembunyiCRUD();
           tampil();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(Integer.toString(id).equals("0")){
            JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan diubah");
        }else{
            klik="edit";
            tampilOB();
            sembunyiCRUD();
            tampil();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(Integer.toString(id).equals("0")){
            JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan diubah");
        }else{
            if(JOptionPane.showConfirmDialog(null, "Apakah yakin ingin menghapus data ini?","Peringatan",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                try{
            sql = "DELETE FROM distributor WHERE id='"+id+"'";
            stat.execute(sql);
            JOptionPane.showMessageDialog(null, "Data telah terhapus");
            reset();
            model.fireTableDataChanged();
            model.getDataVector().removeAllElements();
            aturTable();    
            reset();
            sembunyi();
            tampilCRUD();
            sembunyiOB();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            }else{
             reset();
            sembunyi();
            tampilCRUD();
            sembunyiOB();   
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        reset();
        sembunyi();
        tampilCRUD();
        sembunyiOB();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(klik=="tambah"){
              if(jTextField1.getText().isEmpty()&&jTextField2.getText().isEmpty()&&jTextField3.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Ada data yang belum di isi");
       }else{
            try{
            sql = "INSERT INTO distributor(nama_distributor,alamat,telepon)VALUE('"+jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextField3.getText()+"')";
            stat.execute(sql);
            JOptionPane.showMessageDialog(null, "Sukses tambah data");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            model.fireTableDataChanged();
            model.getDataVector().removeAllElements();
            aturTable();
            reset();
            sembunyiOB();
            tampilCRUD();
            sembunyi(); 
        }
        }else if(klik=="edit"){
            try{
                sql = "UPDATE distributor set nama_distributor='"+jTextField1.getText()+"',alamat='"+jTextField2.getText()+"',telepon='"+jTextField3.getText()+"'WHERE id='"+id+"'";
                stat.execute(sql);
                JOptionPane.showMessageDialog(null, "Data telah di ubah");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            model.fireTableDataChanged();
            model.getDataVector().removeAllElements();
            aturTable();
            reset();
            sembunyiOB();
            tampilCRUD();
            sembunyi(); 
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try{
            sql = "SELECT * FROM distributor where nama_distributor='"+jTable1.getValueAt(jTable1.getSelectedRow(), 1)+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                reset();
                sembunyi();
                tampilCRUD();
                sembunyiOB();
                id = rs.getInt("id");
                jTextField1.setText(rs.getString("nama_distributor"));
                jTextField2.setText(rs.getString("alamat"));
                jTextField3.setText(rs.getString("telepon"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Hanya karakter angka yang diperbolehkan");
        }else if(jTextField3.getText().length() >=13){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Maksimal input 13 digit");
        }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
        if(jTextField4.getText().length()>=0){
        model.fireTableDataChanged();
        model.getDataVector().removeAllElements();
        int no=1;
        String[] judul = {"No","Nama Distributor","Alamat","Telepon"};
        model = new DefaultTableModel(null,judul){
          @Override
          public boolean isCellEditable(int row,int column){
              return false;
          }
        };
        try{
            sql = "SELECT * FROM distributor WHERE nama_distributor LIKE '%"+jTextField4.getText()+"%' OR alamat LIKE '%"+jTextField4.getText()+"%' OR telepon LIKE '%"+jTextField4.getText()+"%'";
            rs = stat.executeQuery(sql);
            while (rs.next()){
                String[] data = {Integer.toString(no++),rs.getString("nama_distributor"),rs.getString("alamat"),rs.getString("telepon")};
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
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }else{
             model.fireTableDataChanged();
            model.getDataVector().removeAllElements();
            aturTable();
        }
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try{
        String a = "src/TokBuk/distributor.jasper";
        File y = new File(a);
        JasperReport jasper = (JasperReport)JRLoader.loadObject(y);
        JasperPrint print = JasperFillManager.fillReport(jasper, null, con);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
