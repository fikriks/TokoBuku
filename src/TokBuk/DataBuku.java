/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TokBuk;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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
public class DataBuku extends javax.swing.JInternalFrame {

    /**
     * Creates new form DataBuku
     */
    
    private Connection con;
    private ResultSet rs;
    private Statement stat;
    private String sql,klik,source,destination,namagambar;
    private koneksi kon = new koneksi();
    private JFileChooser jf = new JFileChooser();
    private DefaultTableModel model;
    private int id=0;
    private LineBorder b;
    
    public DataBuku() {
       initComponents();
       con = kon.con;
       stat = kon.stat;
       setTitle("Data Buku");
       aturTable();
       sembunyi();
       sembunyiOB();
       ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
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
    
    private void tema(){
        this.setBackground(Color.BLACK);
        jPanel1.setBackground(Color.BLACK);
        jPanel2.setBackground(Color.BLACK);
        jLabel1.setForeground(Color.WHITE);
        jLabel2.setBackground(Color.WHITE);
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
        jLabel16.setForeground(Color.WHITE);
        jLabel17.setForeground(Color.WHITE);
        jButton1.setForeground(Color.WHITE);
        jButton2.setForeground(Color.WHITE);
        jButton3.setForeground(Color.WHITE);
        jButton4.setForeground(Color.WHITE);
        jButton5.setForeground(Color.WHITE);
        jButton6.setForeground(Color.WHITE);
        jButton7.setForeground(Color.WHITE);
        ImageIcon image = new ImageIcon("src/img/icons8_MacOS_Close_30px_1.png");
        jButton8.setIcon(image);
        jTable1.setBackground(Color.BLACK);
        jTable1.setForeground(Color.WHITE);
        jTable1.getTableHeader().setBackground(Color.BLACK);
        jTable1.getTableHeader().setForeground(Color.BLACK);
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE,2,true));
    }
    
    private void font(){
         File y = new File("src/font");
           if(y.canRead()){
               try{
               String[] namafont = y.list();
               FileInputStream z = new FileInputStream("src/font/"+namafont[0]);
               FileInputStream z1 = new FileInputStream("src/font/"+namafont[4]);
               Font font = Font.createFont(Font.TRUETYPE_FONT, z);
               Font font1 = Font.createFont(Font.TRUETYPE_FONT, z1);
               Font sizeFont = font.deriveFont(24f);
               Font sizeFont1 = font1.deriveFont(14f);
               jLabel1.setFont(sizeFont);
               jLabel3.setFont(sizeFont1);
               jLabel4.setFont(sizeFont1);
               jLabel5.setFont(sizeFont1);
               jLabel6.setFont(sizeFont1);
               jLabel7.setFont(sizeFont1);
               jLabel8.setFont(sizeFont1);
               jLabel9.setFont(sizeFont1);
               jLabel10.setFont(sizeFont1);
               jLabel11.setFont(sizeFont1);
               jLabel12.setFont(sizeFont1);
               jLabel13.setFont(sizeFont1);
               jLabel14.setFont(sizeFont1);
               jLabel15.setFont(sizeFont1);
               jLabel16.setFont(sizeFont1);
               jLabel17.setFont(sizeFont1);
               jTextField1.setFont(sizeFont1);
               jTextField2.setFont(sizeFont1);
               jTextField3.setFont(sizeFont1);
               jTextField4.setFont(sizeFont1);
               jTextField5.setFont(sizeFont1);
               jTextField6.setFont(sizeFont1);
               jTextField7.setFont(sizeFont1);
               jTextField8.setFont(sizeFont1);
               jTextField9.setFont(sizeFont1);
               jTextField10.setFont(sizeFont1);
               jTextField11.setFont(sizeFont1);
               jButton1.setFont(sizeFont1);
               jButton2.setFont(sizeFont1);
               jButton3.setFont(sizeFont1);
               jButton4.setFont(sizeFont1);
               jButton5.setFont(sizeFont1);
               jButton6.setFont(sizeFont1);
               jButton7.setFont(sizeFont1);
               jTable1.setFont(sizeFont1);
               jTable1.getTableHeader().setFont(sizeFont1);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null, e.getMessage());
               }
           }
    }
    
    private void reset(){
        jTextField1.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jLabel2.setIcon(null);
    }
    
    private void sembunyi(){
        jTextField1.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
        jTextField6.setEnabled(false);
        jTextField7.setEnabled(false);
        jTextField8.setEnabled(false);
        jTextField9.setEnabled(false);
        jTextField10.setEnabled(false);
        jTextField11.setEnabled(false);
        jButton1.setEnabled(false);
    }
    
    private void sembunyiOB(){
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
    }
    
    private void sembunyiCRUD(){
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
    }
    
    private void tampil(){
        jTextField1.setEnabled(false);
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(true);
        jTextField5.setEnabled(true);
        jTextField6.setEnabled(true);
        jTextField7.setEnabled(true);
        jTextField8.setEnabled(true);
        jTextField9.setEnabled(true);
        jTextField10.setEnabled(true);
        jTextField11.setEnabled(true);
        jButton1.setEnabled(true);
    }
    
    private void tampilOB(){
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
    }
    
    private void tampilCRUD(){
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
    }
    
    private void aturTable(){
       int no=1;
       String[] judul = {"No","Gambar","Judul","No ISBN","Penulis","Penerbit","Tahun","Stok","Harga Pokok","Harga Jual","PPN","Diskon"};
       model = new DefaultTableModel(null,judul){
           @Override
           public Class getColumnClass(int column){
               if(column==1){
                   return ImageIcon.class;
               }
               return Object.class;
           }
           
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
       };
        try{
            sql = "SELECT * FROM buku";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                String source = ("../TokoBuku/src/img/"+rs.getString("gambar"));
                ImageIcon icon = new ImageIcon(source);
                Image scale = icon.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
                icon = new ImageIcon(scale);
                Object[] isi = {Integer.toString(no++),icon,rs.getString("judul"),rs.getString("noisbn"),rs.getString("penulis"),rs.getString("penerbit"),rs.getInt("tahun"),rs.getString("stok"),rs.getString("harga_pokok"),rs.getString("harga_jual"),rs.getString("ppn"),rs.getString("diskon")};
                model.addRow(isi);
            }
          ((DefaultTableCellRenderer)jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
           jTable1.setModel(model);
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(JLabel.CENTER);
            jTable1.getColumnModel().getColumn(0).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(2).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(3).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(4).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(5).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(6).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(7).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(8).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(9).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(10).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(11).setCellRenderer(render);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"gagal"+e.getMessage());
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
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setRowHeight(100);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.setSurrendersFocusOnKeystroke(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setToolTipText("Gambar");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText("Pilih Gambar");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setText("Judul");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setText("No ISBN");

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel8.setText("Penulis");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel9.setText("Penerbit");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel10.setText("Tahun");

        jLabel11.setText("Stok");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel12.setText("Harga Pokok");

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jTextField6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jTextField7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel13.setText("PPN");

        jTextField8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });

        jTextField9.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });

        jTextField10.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField10KeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel14.setText("Diskon");

        jTextField11.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField11KeyTyped(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_32px.png"))); // NOI18N
        jButton2.setText("Tambah");
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_edit_32px.png"))); // NOI18N
        jButton3.setText("Edit");
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_trash_32px_1.png"))); // NOI18N
        jButton4.setText("Hapus");
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_ok_32px.png"))); // NOI18N
        jButton5.setText("OK");
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_cancel_32px.png"))); // NOI18N
        jButton6.setText("Batal");
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setText("%");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel15.setText("%");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_32px.png"))); // NOI18N
        jLabel16.setText("Cari");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_print_32px.png"))); // NOI18N
        jButton7.setText("Cetak");
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_book_64px.png"))); // NOI18N
        jLabel1.setText("Toko Buku: Data Buku");

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_MacOS_Close_30px.png"))); // NOI18N
        jButton8.setContentAreaFilled(false);
        jButton8.setFocusable(false);
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_MacOS_Close_30px_1.png"))); // NOI18N
        jButton8.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_MacOS_Close_30px_1.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_book_32px_1.png"))); // NOI18N
        jLabel17.setText("Data Buku");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addGap(249, 249, 249))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3)
                                        .addGap(21, 21, 21)
                                        .addComponent(jButton4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton5)
                                        .addGap(27, 27, 27)
                                        .addComponent(jButton6)
                                        .addGap(57, 57, 57))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel11)
                                        .addGap(45, 45, 45))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jSeparator1))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2)
                                    .addComponent(jButton3)
                                    .addComponent(jButton4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6)
                                    .addComponent(jButton5)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel12)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        reset();
        klik = "tambah";
        tampilOB();
        sembunyiCRUD();
        tampil();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(Integer.toString(id).equals("0")){
            JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan diubah");
        }else{
        klik = "edit";
        tampilOB();
        sembunyiCRUD();
        tampil();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            // TODO add your handling code here:
        if(klik=="tambah"){
            if(jTextField1.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ada data yang belum di isi");
            }else{
               File sumber = new File(source);
               destination = "../TokoBuku/src/img/"+sumber.getName();
                try{
                 FileInputStream fis = new FileInputStream(sumber);
                 FileOutputStream fos = new FileOutputStream(destination);
                 byte[] buffer = new byte[1024];
                 int length;
                 while((length = fis.read(buffer))>0){
                     fos.write(buffer,0, length);
                 }
             }catch (Exception e){
                 JOptionPane.showMessageDialog(null, e.getMessage());
             }
                try{
                    int hargajual;
                    if(jTextField11.getText().equals("0")){
                        hargajual = Integer.parseInt(jTextField9.getText()) * Integer.parseInt(jTextField10.getText()) / 100 + Integer.parseInt(jTextField9.getText());
                        sql = "INSERT INTO buku(gambar,judul,noisbn,penulis,penerbit,tahun,stok,harga_pokok,harga_jual,ppn,diskon) VALUE('"+sumber.getName()+"','"+jTextField3.getText()+"','"+jTextField4.getText()+"','"+jTextField5.getText()+"','"+jTextField6.getText()+"','"+jTextField7.getText()+"','"+jTextField8.getText()+"','"+jTextField9.getText()+"','"+hargajual+"','"+jTextField10.getText()+"','"+jTextField11.getText()+"')";
                        stat.execute(sql);
                        JOptionPane.showMessageDialog(null, "Sukses tambah data");
                    }else{
                        int ppn,diskon;
                        ppn = Integer.parseInt(jTextField9.getText()) * Integer.parseInt(jTextField10.getText()) / 100 + Integer.parseInt(jTextField9.getText());
                        diskon = ppn * Integer.parseInt(jTextField11.getText()) / 100;
                        hargajual = ppn - diskon;
                        sql = "INSERT INTO buku(gambar,judul,noisbn,penulis,penerbit,tahun,stok,harga_pokok,harga_jual,ppn,diskon) VALUE('"+sumber.getName()+"','"+jTextField3.getText()+"','"+jTextField4.getText()+"','"+jTextField5.getText()+"','"+jTextField6.getText()+"','"+jTextField7.getText()+"','"+jTextField8.getText()+"','"+jTextField9.getText()+"','"+hargajual+"','"+jTextField10.getText()+"','"+jTextField11.getText()+"')";
                        stat.execute(sql);
                        JOptionPane.showMessageDialog(null, "Sukses tambah data");
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            model.fireTableDataChanged();
            model.getDataVector().removeAllElements();
            aturTable();
            reset();
            sembunyiOB();
            tampilCRUD();
            sembunyi();
        }else if(klik=="edit"){
            if(jTextField1.getText().equals(namagambar)){
                 try{
                int hargajual;
                File sumber = new File(source);
                if(jTextField11.getText().equals("0")){
                    hargajual = Integer.parseInt(jTextField9.getText()) * Integer.parseInt(jTextField10.getText()) / 100 + Integer.parseInt(jTextField9.getText());
                    sql = "UPDATE buku set gambar='"+sumber.getName()+"',judul='"+jTextField3.getText()+"',noisbn='"+jTextField4.getText()+"',penulis='"+jTextField5.getText()+"',penerbit='"+jTextField6.getText()+"',tahun='"+jTextField7.getText()+"',stok='"+jTextField8.getText()+"',harga_pokok='"+jTextField9.getText()+"',harga_jual='"+hargajual+"',ppn='"+jTextField10.getText()+"',diskon='"+jTextField11.getText()+"'WHERE id='"+id+"'";
                    stat.execute(sql);
                    JOptionPane.showMessageDialog(null, "Data telah diubah");
                }else{
                    int ppn,diskon;
                    ppn = Integer.parseInt(jTextField9.getText()) * Integer.parseInt(jTextField10.getText()) /100 + Integer.parseInt(jTextField9.getText());
                    diskon = ppn * Integer.parseInt(jTextField11.getText()) /100;
                    hargajual = ppn-diskon;
                    sql = "UPDATE buku set gambar='"+sumber.getName()+"',judul='"+jTextField3.getText()+"',noisbn='"+jTextField4.getText()+"',penulis='"+jTextField5.getText()+"',penerbit='"+jTextField6.getText()+"',tahun='"+jTextField7.getText()+"',stok='"+jTextField8.getText()+"',harga_pokok='"+jTextField9.getText()+"',harga_jual='"+hargajual+"',ppn='"+jTextField10.getText()+"',diskon='"+jTextField11.getText()+"'WHERE id='"+id+"'";
                    stat.execute(sql);
                    JOptionPane.showMessageDialog(null, "Data telah diubah");
                }
            }catch (Exception e){
                 JOptionPane.showMessageDialog(null, e.getMessage());
            }
            }else{
            try{
                 try{
                File sumber = new File(source);
                 destination = "../TokoBuku/src/img/"+sumber.getName();
                 FileInputStream fis = new FileInputStream(sumber);
                 FileOutputStream fos = new FileOutputStream(destination);
                 byte[] buffer = new byte[1024];
                 int length;
                 while((length = fis.read(buffer))>0){
                     fos.write(buffer,0,length);
                 }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
                int hargajual;
                File sumber = new File(source);
                if(jTextField11.getText().equals("0")){
                    hargajual = Integer.parseInt(jTextField9.getText()) * Integer.parseInt(jTextField10.getText()) / 100 + Integer.parseInt(jTextField9.getText());
                    sql = "UPDATE buku set gambar='"+sumber.getName()+"',judul='"+jTextField3.getText()+"',noisbn='"+jTextField4.getText()+"',penulis='"+jTextField5.getText()+"',penerbit='"+jTextField6.getText()+"',tahun='"+jTextField7.getText()+"',stok='"+jTextField8.getText()+"',harga_pokok='"+jTextField9.getText()+"',harga_jual='"+hargajual+"',ppn='"+jTextField10.getText()+"',diskon='"+jTextField11.getText()+"'WHERE id='"+id+"'";
                    stat.execute(sql);
                    JOptionPane.showMessageDialog(null, "Data telah diubah");
                }else{
                    int ppn,diskon;
                    ppn = Integer.parseInt(jTextField9.getText()) * Integer.parseInt(jTextField10.getText()) /100 + Integer.parseInt(jTextField9.getText());
                    diskon = ppn * Integer.parseInt(jTextField11.getText()) /100;
                    hargajual = ppn-diskon;
                     sql = "UPDATE buku set gambar='"+sumber.getName()+"',judul='"+jTextField3.getText()+"',noisbn='"+jTextField4.getText()+"',penulis='"+jTextField5.getText()+"',penerbit='"+jTextField6.getText()+"',tahun='"+jTextField7.getText()+"',stok='"+jTextField8.getText()+"',harga_pokok='"+jTextField9.getText()+"',harga_jual='"+hargajual+"',ppn='"+jTextField10.getText()+"',diskon='"+jTextField11.getText()+"'WHERE id='"+id+"'";
                    stat.execute(sql);
                    JOptionPane.showMessageDialog(null, "Data telah diubah");
                }
            }catch (Exception e){
                 JOptionPane.showMessageDialog(null, e.getMessage());
            }
            }
            model.fireTableDataChanged();
            model.getDataVector().removeAllElements();
            aturTable();
            reset();
            sembunyiOB();
            tampilCRUD();
            sembunyi();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         if(Integer.toString(id).equals("0")){
            JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan dihapus");
        }else{
      if(JOptionPane.showConfirmDialog(null,"Apakah yakin ingin menghapus data ini?","Peringatan", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION){
        try{
          sql = "DELETE FROM buku WHERE id='"+id+"'";
          stat.execute(sql);
          JOptionPane.showMessageDialog(null, "Data telah terhapus");
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
        sembunyi();
        tampilCRUD();
        sembunyiOB();
      }
      }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        reset();
        sembunyi();
        tampilCRUD();
        sembunyiOB();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int a = jf.showOpenDialog(this);
            if ( a == JFileChooser.APPROVE_OPTION){
                Rectangle rect = jLabel2.getBounds();
                source = jf.getSelectedFile().getPath();
                namagambar = jf.getSelectedFile().getName();    
                ImageIcon icon = new ImageIcon(source);
                Image scale = icon.getImage().getScaledInstance(rect.width, rect.height, Image.SCALE_DEFAULT);
                icon = new ImageIcon(scale);
                jLabel2.setIcon(icon);
                jTextField1.setText(namagambar);
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try{
            sql = "SELECT * FROM buku WHERE judul='"+jTable1.getValueAt(jTable1.getSelectedRow(),2)+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                Rectangle rect = jLabel2.getBounds();
                source = "../TokoBuku/src/img/"+rs.getString("gambar");
                ImageIcon icon = new ImageIcon(source);
                Image scale = icon.getImage().getScaledInstance(rect.width, rect.height,Image.SCALE_DEFAULT);
                icon = new ImageIcon(scale);
                jLabel2.setIcon(icon);
                tampilCRUD();
                sembunyiOB();
                sembunyi();
                namagambar = rs.getString("gambar");
                jTextField1.setText(rs.getString("gambar"));
                id = rs.getInt("id");
                jTextField3.setText(rs.getString("judul"));
                jTextField4.setText(rs.getString("noisbn"));
                jTextField5.setText(rs.getString("penulis"));
                jTextField6.setText(rs.getString("penerbit"));
                jTextField7.setText(Integer.toString(rs.getInt("tahun")));
                jTextField8.setText(rs.getString("stok"));
                jTextField9.setText(rs.getString("harga_pokok"));
                jTextField10.setText(rs.getString("ppn"));
                jTextField11.setText(rs.getString("diskon"));
            }   
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Hanya karakter angka yang diperbolehkan");
        }
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        // TODO add your handling code here:
         if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Hanya karakter angka yang diperbolehkan");
        }
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jTextField10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyTyped
        // TODO add your handling code here:
         if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Hanya karakter angka yang diperbolehkan");
        }
    }//GEN-LAST:event_jTextField10KeyTyped

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
        // TODO add your handling code here:
         if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Hanya karakter angka yang diperbolehkan");
        }
    }//GEN-LAST:event_jTextField11KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
         if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Hanya karakter angka yang diperbolehkan");
        }
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
       if(jTextField2.getText().length()>=0){
       model.fireTableDataChanged();
        model.getDataVector().removeAllElements();
       int no=1;
       String[] judul = {"No","Gambar","Judul","No ISBN","Penulis","Penerbit","Tahun","Stok","Harga Pokok","Harga Jual","PPN","Diskon"};
       model = new DefaultTableModel(null,judul){
           @Override
           public Class getColumnClass(int column){
               if(column==1){
                   return ImageIcon.class;
               }
               return Object.class;
           }
           
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
       };
        try{
            sql = "SELECT * FROM buku WHERE judul LIKE '%"+jTextField2.getText()+"%'";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                String source = ("../TokoBuku/src/img/"+rs.getString("gambar"));
                ImageIcon icon = new ImageIcon(source);
                Image scale = icon.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
                icon = new ImageIcon(scale);
                Object[] isi = {Integer.toString(no++),icon,rs.getString("judul"),rs.getString("noisbn"),rs.getString("penulis"),rs.getString("penerbit"),rs.getInt("tahun"),rs.getString("stok"),rs.getString("harga_pokok"),rs.getString("harga_jual"),rs.getString("ppn"),rs.getString("diskon")};
                model.addRow(isi);
            }
          ((DefaultTableCellRenderer)jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
           jTable1.setModel(model);
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(JLabel.CENTER);
            jTable1.getColumnModel().getColumn(0).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(2).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(3).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(4).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(5).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(6).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(7).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(8).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(9).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(10).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(11).setCellRenderer(render);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"gagal"+e.getMessage());
        }
       }else{
            model.fireTableDataChanged();
            model.getDataVector().removeAllElements();
           aturTable();
       }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        try{
        String a = "src/TokBuk/buku.jasper";
        File y = new File(a);
        JasperReport report = (JasperReport) JRLoader.loadObject(y);
        JasperPrint print = JasperFillManager.fillReport(report,null, con);
        JasperViewer.viewReport(print);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        //bold();
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
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
