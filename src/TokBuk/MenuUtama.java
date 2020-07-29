/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TokBuk;

import TokBuk.Login;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import net.sf.jasperreports.engine.JasperReport;
/**
 *
 * @author Fikri Khairul Shaleh
 */
public class MenuUtama extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    
    public MenuUtama() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("Main Menu");
        font();
        try{
           FileReader fr = new FileReader("src/tema.txt"); 
           BufferedReader br  = new BufferedReader(fr);
               if(br.readLine().equals("Light")){
                  
               }else{
                    this.setBackground(Color.BLACK);
                   desktopPane.setBackground(Color.BLACK);
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void font(){
        try{
          File file = new File("src/font");
        if(file.canRead()){
            String[] namafont = file.list();
            FileInputStream fis = new FileInputStream("src/font/"+namafont[5]);
            Font font = Font.createFont(Font.TRUETYPE_FONT, fis);
            Font sizeFont = font.deriveFont(14f);
            menuBar.setFont(sizeFont);
            fileMenu.setFont(sizeFont);
            jMenu2.setFont(sizeFont);
            jMenu3.setFont(sizeFont);
            jMenu4.setFont(sizeFont);
            jMenu5.setFont(sizeFont);
            jMenuItem1.setFont(sizeFont);
            jMenuItem2.setFont(sizeFont);
            jMenuItem3.setFont(sizeFont);
            jMenuItem4.setFont(sizeFont);
            jMenuItem5.setFont(sizeFont);
            jMenuItem6.setFont(sizeFont);
            jMenuItem7.setFont(sizeFont);
            jMenuItem8.setFont(sizeFont);
            jMenuItem9.setFont(sizeFont);
            jMenuItem11.setFont(sizeFont);
        }   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    /*public void setJam(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                DateFormat df = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date();
                jLabel4.setText(df.format(date));
            }
        };
        Timer timer =new Timer(1000,al);
        timer.start();
    }
    
    public void greeting(){
        Date date = new Date();
        int jam = date.getHours();
        if(jam>=0 && jam<8){
            jLabel2.setText("Selamat Pagi");
        }else if(jam>=8 && jam<15){
            jLabel2.setText("Selamat Siang");
        }else if(jam>=15 && jam<19){
            jLabel2.setText("Selamat Sore");
        }else if(jam>=19 && jam<0){
            jLabel2.setText("Selamat Malam");
        }
    }
   
    public void nama(String nama){
        jLabel1.setText(nama);
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem10.setText("jMenuItem10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBackground(new java.awt.Color(255, 255, 255));
        desktopPane.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 751, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );

        menuBar.setBorder(null);

        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_file_32px.png"))); // NOI18N
        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_password_32px_1.png"))); // NOI18N
        jMenuItem1.setText("Ubah Password");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_logout_rounded_left_32px.png"))); // NOI18N
        jMenuItem2.setText("Logout");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_exit_32px.png"))); // NOI18N
        jMenuItem3.setText("Keluar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem3);

        menuBar.add(fileMenu);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_hdd_32px.png"))); // NOI18N
        jMenu2.setText("Data");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_book_32px_1.png"))); // NOI18N
        jMenuItem4.setText("Data Buku");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_supplier_30px_1.png"))); // NOI18N
        jMenuItem6.setText("Data Distributor");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_truck_32px.png"))); // NOI18N
        jMenuItem7.setText("Data Pasok");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        menuBar.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_shopping_cart_32px.png"))); // NOI18N
        jMenu3.setText("Transaksi");

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_shopping_cart_32px.png"))); // NOI18N
        jMenuItem8.setText("Penjualan");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        menuBar.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_graph_report_32px.png"))); // NOI18N
        jMenu4.setText("Laporan");

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_stack_of_money_32px_1.png"))); // NOI18N
        jMenuItem9.setText("Pemasukan");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        menuBar.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_settings_32px.png"))); // NOI18N
        jMenu5.setText("Pengaturan");

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_ios_themes_32px.png"))); // NOI18N
        jMenuItem11.setText("Tema");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        menuBar.add(jMenu5);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
     desktopPane.removeAll();
     this.repaint();
     UbahPassword up = new UbahPassword();
     desktopPane.add(up);
     Dimension induk = desktopPane.getSize();
     Dimension anak = up.getSize();
     up.setLocation((induk.width - anak.width)/2,(induk.height - anak.height)/2);
     up.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
      new Login().show();
      this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        System.exit(0); 
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        desktopPane.removeAll();
        this.repaint();
        DataBuku DB = new DataBuku();
        desktopPane.add(DB);
        Dimension induk = desktopPane.getSize();
        Dimension anak = DB.getSize();
        DB.setLocation((induk.width - anak.width)/2,(induk.height - anak.height)/2);
        DB.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        desktopPane.removeAll();
        this.repaint();
        DataDistributor DB = new DataDistributor();
        desktopPane.add(DB);
        Dimension induk = desktopPane.getSize();
        Dimension anak = DB.getSize();
        DB.setLocation((induk.width-anak.width)/2,(induk.height-anak.height)/2);
        DB.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        desktopPane.removeAll();
        this.repaint();
        DataPasok DP = new DataPasok();
        desktopPane.add(DP);
        Dimension induk = desktopPane.getSize();
        Dimension anak = DP.getSize();
        DP.setLocation((induk.width-anak.width)/2, (induk.height-anak.height)/2);
        DP.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        desktopPane.removeAll();
        this.repaint();
        Penjualan p = new Penjualan();
        desktopPane.add(p);
        Dimension induk = desktopPane.getSize();
        Dimension anak = p.getSize();
        p.setLocation((induk.width-anak.width)/2,(induk.height-anak.height)/2);
        p.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        desktopPane.removeAll();
        this.repaint();
        Pemasukan p = new Pemasukan();
        desktopPane.add(p);
        Dimension induk = desktopPane.getSize();
        Dimension anak = p.getSize();
        p.setLocation((induk.width-anak.width)/2,(induk.height-anak.height)/2);
        p.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        desktopPane.removeAll();
        this.repaint();
        Tema t = new Tema();
        desktopPane.add(t);
        Dimension induk = desktopPane.getSize();
        Dimension anak = t.getSize();
        t.setLocation((induk.width-anak.width)/2,(induk.height-anak.height)/2);
        t.akses("Kasir");
        t.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
