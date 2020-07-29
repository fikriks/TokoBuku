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
import javax.swing.*;
import java.sql.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.*;
/**
 *
 * @author Fikri Khairul Shaleh
 */
public class DataKaryawan extends javax.swing.JInternalFrame {

    /**
     * Creates new form DataKaryawan
     */
    private Connection con;
    private Statement stat;
    private ResultSet rs;
    private DefaultTableModel model;
    private String sql,klik;
    private int id=0;
    private koneksi kon = new koneksi();
    
    public DataKaryawan() {
        initComponents();
        setTitle("Data Pekerja");
        con = kon.con;
        stat = kon.stat;
        aturTable();
        dataCB();
        sembunyiOB();
        sembunyi();
        font();
        ((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        try{
            FileReader fr = new FileReader("src/tema.txt");
            BufferedReader br = new BufferedReader(fr);
            if(br.readLine().equals("Light")){
                
            }else{
                tema();
            }        
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    
    private void font(){
        try{
            File file = new File("src/font");
            if(file.canRead()){
                String[] namafile = file.list();
                FileInputStream fis = new FileInputStream("src/font/"+namafile[0]);
                FileInputStream fis1 = new FileInputStream("src/font/"+namafile[4]);
                Font font = Font.createFont(Font.TRUETYPE_FONT,fis);
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
                jLabel8.setFont(sizeFont1);
                jTextField1.setFont(sizeFont1);
                jPasswordField1.setFont(sizeFont1);
                jTextField3.setFont(sizeFont1);
                jTextField4.setFont(sizeFont1);
                jTextField5.setFont(sizeFont1);
                jComboBox1.setFont(sizeFont1);
                jTable1.setFont(sizeFont1);
                jTable1.getTableHeader().setFont(sizeFont1);
                jButton1.setFont(sizeFont1);
                jButton2.setFont(sizeFont1);
                jButton3.setFont(sizeFont1);
                jButton4.setFont(sizeFont1);
                jButton5.setFont(sizeFont1);
                jButton7.setFont(sizeFont1);
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
        jLabel8.setForeground(Color.WHITE);
        jButton1.setForeground(Color.WHITE);
        jButton2.setForeground(Color.WHITE);
        jButton3.setForeground(Color.WHITE);
        jButton4.setForeground(Color.WHITE);
        jButton5.setForeground(Color.WHITE);
        jButton7.setForeground(Color.WHITE);
        jTable1.setBackground(Color.BLACK);
        jTable1.setForeground(Color.WHITE);
        jTable1.getTableHeader().setForeground(Color.BLACK);
        ImageIcon icon = new ImageIcon("src/img/icons8_MacOS_Close_30px_1.png");
        jButton6.setIcon(icon);
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
    }
    
    private void dataCB(){
        jComboBox1.removeAllItems();
        String[] data = {"Admin","Kasir"};
        for(String a : data){
           jComboBox1.addItem(a); 
        }
    }
    
    private void reset(){
        jTextField1.setText("");
        jPasswordField1.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
    }
    
    private void sembunyi(){
        jTextField1.setEnabled(false);
        jPasswordField1.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jComboBox1.setEnabled(false);
        jCheckBox1.setEnabled(false);
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
        jPasswordField1.setEnabled(true);
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(true);
        jComboBox1.setEnabled(true);
        jCheckBox1.setEnabled(true);
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
        String[] judul = {"No","Username","Password","Nama","Alamat","Hak Akses"};
        model = new DefaultTableModel(null,judul){
                @Override
                public boolean isCellEditable(int row,int column){
                    return false;
                }
           };
        try{
            sql = "SELECT * FROM kasir";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                String[] data = {String.valueOf(no++),rs.getString("username"),rs.getString("password"),rs.getString("nama"),rs.getString("alamat"),rs.getString("hakakses")};
                model.addRow(data);  
            }
            jTable1.setModel(model);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ((DefaultTableCellRenderer)jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(render);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(render);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(render);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(render);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(render);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(render);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_employee_card_64px.png"))); // NOI18N
        jLabel1.setText("Data Karyawan");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_employee_card_32px.png"))); // NOI18N
        jLabel7.setText("Data Karyawan");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_MacOS_Close_30px.png"))); // NOI18N
        jButton6.setContentAreaFilled(false);
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_MacOS_Close_30px_1.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
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
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jLabel4.setText("Nama");

        jLabel5.setText("Alamat");

        jLabel6.setText("Hak Akses");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_32px.png"))); // NOI18N
        jButton1.setText("Tambah");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_edit_32px.png"))); // NOI18N
        jButton2.setText("Edit");
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_trash_32px_1.png"))); // NOI18N
        jButton3.setText("Hapus");
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_ok_32px.png"))); // NOI18N
        jButton4.setText("OK");
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_cancel_32px.png"))); // NOI18N
        jButton5.setText("Batal");
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_32px.png"))); // NOI18N
        jLabel8.setText("Cari");

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_print_32px.png"))); // NOI18N
        jButton7.setText("Cetak");
        jButton7.setContentAreaFilled(false);

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyTyped(evt);
            }
        });

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPasswordField1)))
                                        .addGap(2, 2, 2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox1)
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(27, 27, 27)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(jButton4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3)))
                                .addGap(0, 57, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addComponent(jSeparator2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(21, 21, 21)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan diubah");
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
            JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan diubah");
        }else{
            if(JOptionPane.showConfirmDialog(null, "Apakah yakin ingin menghapus data ini?", "Peringatan", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
             try{
             sql = "DELETE FROM kasir WHERE id='"+id+"'";
             stat.execute(sql);
             JOptionPane.showMessageDialog(null, "Sukses hapus data");
             model.fireTableDataChanged();
             model.getDataVector().removeAllElements();
             aturTable();
             reset();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
      }
            
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        id=0;
        sembunyi();
        reset();
        sembunyiOB();
        tampilCRUD();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(klik=="tambah"){
            try{
                sql = "SELECT username FROM kasir WHERE username='"+jTextField1.getText()+"'";
                rs = stat.executeQuery(sql);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Username sudah ada");
                }else{
                    sql = "INSERT INTO kasir(username,password,nama,alamat,hakakses) VALUES ('"+jTextField1.getText()+"','"+jPasswordField1.getText()+"','"+jTextField3.getText()+"','"+jTextField4.getText()+"','"+jComboBox1.getSelectedItem().toString()+"')";
                    stat.execute(sql);
                    JOptionPane.showMessageDialog(null, "Sukses tambah data");
                    model.fireTableDataChanged();
                    model.getDataVector().removeAllElements();
                    aturTable();
                    sembunyiOB();
                    reset();
                    sembunyi();
                    tampilCRUD();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }else if(klik=="edit"){
            try{
                    sql = "UPDATE kasir SET username='"+jTextField1.getText()+"',password='"+jPasswordField1.getText()+"',nama='"+jTextField3.getText()+"',alamat='"+jTextField4.getText()+"',hakakses='"+jComboBox1.getSelectedItem().toString()+"'WHERE id='"+id+"'";
                    stat.execute(sql);
                    JOptionPane.showMessageDialog(null, "Sukses edit data");
                    model.fireTableDataChanged();
                    model.getDataVector().removeAllElements();
                    aturTable();
                    sembunyiOB();
                    reset();
                    sembunyi();
                    tampilCRUD();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try{
            sql = "SELECT * FROM kasir WHERE username='"+jTable1.getValueAt(jTable1.getSelectedRow(), 1)+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                id = rs.getInt("id");
                jTextField1.setText(rs.getString("username"));
                jPasswordField1.setText(rs.getString("password"));
                jPasswordField1.setEchoChar('*');
                jTextField3.setText(rs.getString("nama"));
                jTextField4.setText(rs.getString("alamat"));
                jComboBox1.setSelectedItem(rs.getString("hakakses"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        // TODO add your handling code here:
        if(jTextField5.getText().length()==0){
            aturTable();
        }else{
            try{
                int no=1;
        String[] judul = {"No","Username","Password","Nama","Alamat","Hak Akses"};
        model = new DefaultTableModel(null,judul){
                @Override
                public boolean isCellEditable(int row,int column){
                    return false;
                }
           };
        try{
            sql = "SELECT * FROM kasir WHERE username LIKE '%"+jTextField5.getText()+"%' OR nama LIKE '%"+jTextField5.getText()+"%'";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                String[] data = {String.valueOf(no++),rs.getString("username"),rs.getString("password"),rs.getString("nama"),rs.getString("alamat"),rs.getString("hakakses")};
                model.addRow(data);  
            }
            jTable1.setModel(model);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ((DefaultTableCellRenderer)jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(render);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(render);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(render);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(render);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(render);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(render);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jPasswordField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyTyped
        // TODO add your handling code here:
        jPasswordField1.setEchoChar('*');
    }//GEN-LAST:event_jPasswordField1KeyTyped

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox1.isSelected()){
            jPasswordField1.setEchoChar((char)0);
        }else{
         jPasswordField1.setEchoChar('*');   
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
