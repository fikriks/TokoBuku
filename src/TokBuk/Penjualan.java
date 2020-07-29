/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TokBuk;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.Date;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.*;
import net.sf.jasperreports.view.*;
/**
 *
 * @author Fikri Khairul Shaleh
 */
public class Penjualan extends javax.swing.JInternalFrame {

    /**
     * Creates new form Penjualan
     */
    private koneksi kon = new koneksi();
    private String sql;
    private Connection con;
    private Statement stat;
    private ResultSet rs;
    private DefaultTableModel model,model2;
    private int id,rowindex;
    private UserSession session = new UserSession();
    private JasperReport jasper;
    private JasperPrint print;
    
    public Penjualan() {
        initComponents();
        con = kon.con;
        stat = kon.stat;
        databuku();
       nota();
        tgl();
         ((DefaultTableCellRenderer) jTable2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
         jLabel14.setText(session.getNama());
         mati();
         jButton3.setEnabled(false);
         jComboBox1.setEnabled(false);
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
    
    private void tema(){
        try{
            jPanel1.setBackground(Color.BLACK);
            jPanel2.setBackground(Color.BLACK);
            jPanel3.setBackground(Color.BLACK);
            jPanel2.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
            jPanel3.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
            jLabel16.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
            this.setBackground(Color.BLACK);
            this.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
            jLabel1.setForeground(Color.WHITE);
            jLabel2.setForeground(Color.WHITE);
            jLabel3.setForeground(Color.WHITE);
            jLabel4.setForeground(Color.WHITE);
            jLabel5.setForeground(Color.WHITE);
            jLabel6.setForeground(Color.WHITE);
            jLabel7.setForeground(Color.WHITE);
            jLabel8.setForeground(Color.WHITE);
            jLabel9.setForeground(Color.WHITE);
            jLabel10.setForeground(Color.WHITE);
            jLabel11.setForeground(Color.WHITE);
            jLabel12.setForeground(Color.WHITE);
            jLabel13.setForeground(Color.WHITE);
            jLabel14.setForeground(Color.WHITE);
            jLabel15.setForeground(Color.WHITE);
            jLabel19.setForeground(Color.WHITE);
            jLabel20.setForeground(Color.WHITE);
            jLabel20.setForeground(Color.WHITE);
            jTable1.setBackground(Color.BLACK);
            jTable1.setForeground(Color.WHITE);
            jTable1.getTableHeader().setForeground(Color.BLACK);
            jTable2.setBackground(Color.BLACK);
            jTable2.setForeground(Color.WHITE);
            jTable2.getTableHeader().setForeground(Color.BLACK);
            jButton1.setForeground(Color.WHITE);
            jButton2.setForeground(Color.WHITE);
            jButton3.setForeground(Color.WHITE);
            ImageIcon icon = new ImageIcon("src/img/icons8_MacOS_Close_30px_1.png");
            jButton4.setIcon(icon);
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
                jLabel12.setFont(sizeFont);
                jLabel1.setFont(sizeFont1);
                jLabel2.setFont(sizeFont1);
                jLabel3.setFont(sizeFont1);
                jLabel4.setFont(sizeFont1);
                jLabel5.setFont(sizeFont1);
                jLabel6.setFont(sizeFont1);
                jLabel7.setFont(sizeFont1);
                jLabel8.setFont(sizeFont1);
                jLabel9.setFont(sizeFont1);
                jLabel10.setFont(sizeFont1);
                jLabel11.setFont(sizeFont1);
                jLabel13.setFont(sizeFont1);
                jLabel14.setFont(sizeFont1);
                jLabel15.setFont(sizeFont1);
                //jLabel16.setFont(sizeFont1);
                //jLabel17.setFont(sizeFont1);
                //jLabel18.setFont(sizeFont1);
                jLabel19.setFont(sizeFont1);
                jLabel20.setFont(sizeFont1);
                jLabel21.setFont(sizeFont1);
                jTextField1.setFont(sizeFont1);
                jTextField2.setFont(sizeFont1);
                jTextField3.setFont(sizeFont1);
                jTextField4.setFont(sizeFont1);
                jTextField5.setFont(sizeFont1);
                jTextField6.setFont(sizeFont1);
                jTextField7.setFont(sizeFont1);
                jTextField8.setFont(sizeFont1);
                jTable1.setFont(sizeFont1);
                jTable1.getTableHeader().setFont(sizeFont1);
                jTable2.setFont(sizeFont1);
                jTable2.getTableHeader().setFont(sizeFont1);
                jButton1.setFont(sizeFont1);
                jButton2.setFont(sizeFont1);
                jButton3.setFont(sizeFont1);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void databuku(){
        int no = 1;
        String[] judul = {"No","Judul","Penulis","Harga"};
        model = new DefaultTableModel(null,judul){
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        try{
        sql = "SELECT * FROM buku";
        rs = stat.executeQuery(sql);
        while(rs.next()){
            String[] data = {Integer.toString(no++),rs.getString("judul"),rs.getString("penulis"),rs.getString("harga_jual")};
            model.addRow(data);
        }
        jTable1.setModel(model);
        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(render);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(render);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(render);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(render);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    private void dataqty(){
        jComboBox1.removeAllItems();
        try{
            sql = "SELECT stok FROM buku WHERE id='"+id+"'";
            rs = stat.executeQuery(sql);
            while(rs.next()){
               for(int stok=1;stok<=rs.getInt("stok");stok++){
                   jComboBox1.addItem(stok);
               }
            }
        }catch(Exception e){
            
        }
    }
    
    private void hitung(){
        int jumlah,total = 0;
        for(int i= 0;i<jTable2.getRowCount();i++){
         jumlah =  Integer.valueOf(jTable2.getValueAt(i, 4).toString());
         total += jumlah ;
        }
        jTextField6.setText(Integer.toString(total));
    }
    
    private void nota(){
       jTextField9.setEnabled(false);
       try{
           sql = "SELECT MAX(RIGHT(nota,4)) as nota FROM penjualan ORDER BY nota DESC";
           rs = stat.executeQuery(sql);
           if(rs.next()){
               String nota = rs.getString("nota").substring(1);
               String nonota = ""+(Integer.parseInt(nota)+1);
               String nol = "";
               if(nonota.length()==1){
                   nol = "000";
               }else if(nonota.length()==2){
                   nol = "00";
               }else if(nonota.length()==3){
                   nol = "0";
               }else if(nonota.length()==4){
                   nol = "";
               }
               jTextField9.setText("TB"+nol+nonota);
           }else{
              jTextField9.setText("TB0001");
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }
    
    private void tgl(){
       ActionListener al = new ActionListener(){
           public void actionPerformed(ActionEvent a){
               int hari;
               String namahari=null;
               DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
               Date date = new Date();
               hari = date.getDay();
               switch(hari){
                   case 0:
                       namahari = "Minggu";
                       break;
                   case 1:
                       namahari = "Senin";
                       break;
                   case 2:
                       namahari = "Selasa";
                       break;
                   case 3:
                       namahari = "Rabu";
                       break;
                   case 4:
                       namahari = "Kamis";
                       break;
                   case 5:
                       namahari = "Jumat";
                       break;
                   case 6:
                       namahari = "Sabtu";
                       break;
               }
               jLabel11.setText(namahari+","+df.format(date));
           }
       };
       Timer timer = new Timer(1000,al);
       timer.start();
    }
    
    private void mati(){
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
        jTextField6.setEnabled(false);
        jTextField8.setEnabled(false);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel10.setText("No Nota");

        jTextField9.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Tanggal");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel13.setText("Nama Kasir");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel14.setText("jLabel14");

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        jLabel12.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_shopping_cart_64px.png"))); // NOI18N
        jLabel12.setText("Toko Buku : Penjualan");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_shopping_cart_32px.png"))); // NOI18N
        jLabel15.setText("Penjualan");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_MacOS_Close_30px.png"))); // NOI18N
        jButton4.setContentAreaFilled(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_MacOS_Close_30px_1.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setText("Judul");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("No ISBN");

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText("Penulis");

        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setText("Penerbit");

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setText("Harga");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setText("Qty");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_shopping_cart_32px.png"))); // NOI18N
        jButton1.setText("Tambah");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField4)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTable2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Judul", "Harga", "Qty", "Harga Total"
            }
        ));
        jTable2.setShowHorizontalLines(false);
        jTable2.setShowVerticalLines(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jTextField6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setText("Total Harga");

        jTextField7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel8.setText("Tunai");

        jTextField8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel9.setText("Kembalian");

        jButton2.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_checkout_32px.png"))); // NOI18N
        jButton2.setText("Submit");
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

        jLabel19.setText("Rp.");

        jLabel20.setText("Rp.");

        jLabel21.setText("Rp.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jTextField6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20)
                                .addComponent(jLabel8)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel21)
                            .addComponent(jButton3))
                        .addGap(50, 50, 50)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)))
                        .addGap(0, 717, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        jComboBox1.setEnabled(true);
        try{
            sql = "SELECT * FROM buku WHERE judul='"+jTable1.getValueAt(jTable1.getSelectedRow(), 1)+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
              id = rs.getInt("id");
              String nama = rs.getString("gambar");
              ImageIcon icon = new ImageIcon("src/img/"+nama);
              Rectangle rect = jLabel16.getBounds();
              Image scale = icon.getImage().getScaledInstance(rect.width,rect.height,Image.SCALE_SMOOTH);
              icon = new ImageIcon(scale);
              jLabel16.setIcon(icon);
              jTextField1.setText(rs.getString("judul"));
              jTextField2.setText(rs.getString("noisbn"));
              jTextField3.setText(rs.getString("penulis"));
              jTextField4.setText(rs.getString("penerbit"));
              jTextField5.setText(rs.getString("harga_jual"));
              dataqty();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:   
        /*for(int barisatas=0;barisatas<=jTable2.getRowCount()-1;barisatas++){
            for(int barisbawah=barisatas;barisbawah+1<=jTable2.getRowCount()-1;barisbawah++){
             if(jTable2.getValueAt(barisbawah, 1).equals(jTable2.getValueAt(barisatas,1))){
                 jTable2.setValueAt((Integer.parseInt(jTable2.getValueAt(barisatas,3).toString())+1), barisatas, 3);
                 hargatotal = Integer.parseInt(jTextField5.getText()) * Integer.parseInt(jComboBox1.getSelectedItem().toString());
                 String[] data = {"",jTextField1.getText(),jTextField5.getText(),jComboBox1.getSelectedItem().toString(),Integer.toString(hargatotal)};
                  dataModel.addRow(data);
             }
            }
        }*/
        
        
       jComboBox1.setEnabled(false);
        jButton3.setEnabled(false);
        if(jTextField1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Silahkan pilih buku yang akan ditambah");
        }else{
            
             DefaultTableModel dataModel = (DefaultTableModel) jTable2.getModel();
             jTable2.setAutoCreateColumnsFromModel(true);
        int hargatotal;
        int no = 0;
        hargatotal = Integer.parseInt(jTextField5.getText()) * Integer.parseInt(jComboBox1.getSelectedItem().toString());
        Object[] data = {"",jTextField1.getText(),jTextField5.getText(),jComboBox1.getSelectedItem().toString(),Integer.toString(hargatotal)};
        dataModel.addRow(data);
             for(int barisatas=0;barisatas<jTable2.getRowCount();barisatas++){
                 for(int barisbawah=barisatas+1;barisbawah<jTable2.getRowCount();barisbawah++){
                      if(jTable2.getValueAt(barisbawah,1).equals(jTable2.getValueAt(barisatas,1))){
                          int qty = Integer.parseInt(jTable2.getValueAt(barisatas, 3).toString());
                          jTable2.setValueAt(qty+1, barisatas, 3);
                          jTable2.setValueAt(String.valueOf(Integer.parseInt(jTextField5.getText()) * Integer.parseInt(jTable2.getValueAt(barisatas,3).toString())), barisatas, 4);
                       
                          dataModel.removeRow(barisbawah);
                }
                 }
        }
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(JLabel.CENTER);
        jTable2.getColumnModel().getColumn(0).setCellRenderer(render);
        jTable2.getColumnModel().getColumn(1).setCellRenderer(render);
        jTable2.getColumnModel().getColumn(2).setCellRenderer(render);
        jTable2.getColumnModel().getColumn(3).setCellRenderer(render);
        jTable2.getColumnModel().getColumn(4).setCellRenderer(render);
        for(int i = 0;i<jTable2.getRowCount();i++){
                String nomer = String.valueOf(i+1);
                dataModel.setValueAt(nomer,i, 0);
            }
            hitung();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        jButton3.setEnabled(true);
        rowindex = jTable2.convertRowIndexToView(rowindex);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        // TODO add your handling code here:
        if(jTextField7.getText().length()==0){
            jTextField8.setText("");
        }else{
        int jumlah;
        jumlah = Integer.parseInt(jTextField7.getText()) - Integer.parseInt(jTextField6.getText());
        jTextField8.setText(Integer.toString(jumlah));
        }
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jTextField7.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ada data yang kosong");
        }else if(jTextField8.getText().substring(0,1).equals("-")){
            JOptionPane.showMessageDialog(null,"Uang tunai kurang");
        }else{
            try{
             sql = "INSERT INTO penjualan(nota,id_kasir,tanggal) VALUE('"+jTextField9.getText()+"','"+session.getId()+"',CURDATE())";
             stat.execute(sql);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
          for(int i=0;i<jTable2.getRowCount();i++){
              int stok,hasil,tot;
              try{
              sql = "SELECT stok FROM buku WHERE judul='"+jTable2.getValueAt(i, 1)+"'";
              rs = stat.executeQuery(sql);
              if(rs.next()){
               stok = rs.getInt("stok");
               hasil = stok - Integer.parseInt(jTable2.getValueAt(i, 3).toString());
               sql ="UPDATE buku set stok='"+hasil+"'WHERE judul='"+jTable2.getValueAt(i, 1)+"'";
               stat.execute(sql);
              }
              }catch(Exception e){
              JOptionPane.showMessageDialog(null, e.getMessage());
          }
              try{
              sql = "INSERT INTO penjualan_detail(id_penjualan,id_buku,qty) VALUE ((SELECT MAX(id) FROM penjualan),(SELECT id FROM buku WHERE judul='"+jTable2.getValueAt(i, 1)+"'),'"+jTable2.getValueAt(i, 3)+"')";
              stat.execute(sql);
          }catch (Exception e){
              JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
          try{
                if(JOptionPane.showConfirmDialog(null, "Transaksi Berhasil\nIngin cetak struk?","Pesan",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                  String namafile = "src/TokBuk/cetak.jasper";
                  File file = new File(namafile);
                  HashMap hm = new HashMap();
                  hm.put("nota", jTextField9.getText());
                  hm.put("tunai", Integer.parseInt(jTextField7.getText()));
                  hm.put("totalharga", Integer.parseInt(jTextField6.getText()));
                  jasper = (JasperReport) JRLoader.loadObject(file);
                  print = JasperFillManager.fillReport(jasper, hm,con);
                  JasperViewer.viewReport(print,false);
                  JasperViewer.setDefaultLookAndFeelDecorated(true);
              }
          }catch(Exception e){
              JOptionPane.showMessageDialog(null, e.getMessage());
          }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ((DefaultTableModel) jTable2.getModel()).removeRow(jTable2.getSelectedRow());
      for(int i=0;i<jTable2.getRowCount();i++){
          String nomer = String.valueOf(i+1);
          jTable2.setValueAt(nomer, i, 0);
      }
        hitung();
        jButton3.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            JOptionPane.showMessageDialog(null, "Hanya karakter angka yang diperbolehkan");
            evt.consume();
        }
    }//GEN-LAST:event_jTextField7KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
