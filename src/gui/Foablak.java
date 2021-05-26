package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import model.DBModel;
import model.IModel;
import model.Kerdes;

public class Foablak extends javax.swing.JFrame {
    
    private IModel model; 
    private List<Kerdes> kerdesekEsValaszok;
    // 1 kérdés csak 1x jelenhet meg:
    private Map<Integer,String> kerdes = new HashMap<>();
    private int kerdesIdSzamlalo = 1;
    private int helyesValasz = 1;
    private int listaMeret;
    
    public static void hibaAblak(String uzenet){
        JOptionPane.showMessageDialog(null, uzenet, "Hiba történt!", JOptionPane.ERROR_MESSAGE);
    }
    
    public Foablak() {
        initComponents();        
      
        UIManager.put("OptionPane.yesButtonText", "Igen");
        UIManager.put("OptionPane.noButtonText", "Nem");        
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                sajatClose();
            }            
        });     
        
        setLocationRelativeTo(null);
        setTitle("Legyen Ön is milliomos! v.0.1");        
        
        String connURL = "jdbc:mysql://localhost:3306/loim";
        String dBuser = "root";
        String dBPass = "1234";
        
        try {
            Connection conn = DriverManager.getConnection(connURL, dBuser, dBPass);     
            model = new DBModel(conn);     
        } catch (SQLException ex) {
            hibaAblak(ex.toString());
            System.exit(-1);
        }
        getAll();
        kerdesEsValaszGeneral();
        listaMeret = lstOsszegek.getModel().getSize()-1;
        lstOsszegek.setSelectedIndex(listaMeret);
    }

    public void sajatClose(){
        //BEZÁRJUK ITT AZ ADATBÁZIS KAPCSOLATOT:
        try {
            model.close();
        } catch (SQLException ex) {
            hibaAblak(ex.toString());            
        }
        System.exit(0);
    }
    
    public void getAll(){
        try {
            //kérdések és válaszok feltöltése egy listába:
            kerdesekEsValaszok = model.getAllKerdesek();
            // kérdések és id-map.be:
            for (Kerdes k : kerdesekEsValaszok) {
           kerdes.put(k.getId(), k.getKerdes());  
        }
        } catch (SQLException ex) {
            Foablak.hibaAblak(ex.toString());
        }
    }
    
    public void kerdesEsValaszGeneral(){        
        lbKerdes.setText(kerdes.get(kerdesIdSzamlalo)+"");       
        
        btValasz1.setText(kerdesekEsValaszok.get(kerdesIdSzamlalo-1).getValasz0()+"");
        btValasz2.setText(kerdesekEsValaszok.get(kerdesIdSzamlalo-1).getValasz1()+"");
        btValasz3.setText(kerdesekEsValaszok.get(kerdesIdSzamlalo-1).getValasz2()+"");
        btValasz4.setText(kerdesekEsValaszok.get(kerdesIdSzamlalo-1).getValasz3()+"");
        
        helyesValasz = kerdesekEsValaszok.get(kerdesIdSzamlalo-1).getHelyesValasz();
    }    
    
    public void valalszVizsgal(int lenyomottGombIndexe){
        if (lenyomottGombIndexe == helyesValasz) {
            {
            JOptionPane.showMessageDialog(null, "Helyes válasz! Jöhet a következő kérdés!", "Gratulálunk!!!", JOptionPane.INFORMATION_MESSAGE);
            if (lstOsszegek.getSelectedValue().contains("Garantált")) {
                JOptionPane.showMessageDialog(null, "Megvan a garantált nyeremény! :)\n az összegek alatt találod!", "Gratulálunk!!!", JOptionPane.INFORMATION_MESSAGE);
               lbGarantalt.setText(lstOsszegek.getSelectedValue() + "nyeremény megvan!");
            }
            //Játék vége:
            if (kerdesIdSzamlalo == 15) {
                    JOptionPane.showMessageDialog(null, "Tiéd a főnyeremény! :)", "Gratulálunk!!!", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
            }else{
            listaMeret--;
            lstOsszegek.setSelectedIndex(listaMeret);
            kerdesIdSzamlalo++;
            kerdesEsValaszGeneral();  
            }
         }
        }else{      
          JOptionPane.showMessageDialog(null, "Sajnáljuk de nem jó válasz!", "Rossz válasz!", JOptionPane.ERROR_MESSAGE);
          int valasz = JOptionPane.showConfirmDialog(this, "Szeretnél új játékot kezdeni?","Új játék?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (valasz == JOptionPane.YES_OPTION) {
                // ÚJ JÁTÉK
                kerdesIdSzamlalo = 1;
                helyesValasz = 1;
                kerdesEsValaszGeneral();
                listaMeret = lstOsszegek.getModel().getSize()-1;
                lstOsszegek.setSelectedIndex(listaMeret);
                lbGarantalt.setText("");
            }else if(valasz == JOptionPane.NO_OPTION){
                sajatClose();
            }
        }       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnValaszok = new javax.swing.JPanel();
        btValasz1 = new javax.swing.JButton();
        btValasz2 = new javax.swing.JButton();
        btValasz3 = new javax.swing.JButton();
        btValasz4 = new javax.swing.JButton();
        pnKerdes = new javax.swing.JPanel();
        lbKerdes = new javax.swing.JLabel();
        pnJatek = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstOsszegek = new javax.swing.JList<>();
        lbGarantalt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbgar = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miKerdesSzerkeszt = new javax.swing.JMenuItem();
        miBezar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 255));

        pnValaszok.setBackground(new java.awt.Color(51, 153, 255));

        btValasz1.setBackground(new java.awt.Color(153, 204, 255));
        btValasz1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btValasz1.setText("jButton1");
        btValasz1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValasz1ActionPerformed(evt);
            }
        });

        btValasz2.setBackground(new java.awt.Color(153, 204, 255));
        btValasz2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btValasz2.setText("jButton2");
        btValasz2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValasz2ActionPerformed(evt);
            }
        });

        btValasz3.setBackground(new java.awt.Color(153, 204, 255));
        btValasz3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btValasz3.setText("jButton3");
        btValasz3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValasz3ActionPerformed(evt);
            }
        });

        btValasz4.setBackground(new java.awt.Color(153, 204, 255));
        btValasz4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btValasz4.setText("jButton4");
        btValasz4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValasz4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnValaszokLayout = new javax.swing.GroupLayout(pnValaszok);
        pnValaszok.setLayout(pnValaszokLayout);
        pnValaszokLayout.setHorizontalGroup(
            pnValaszokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnValaszokLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnValaszokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btValasz1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btValasz3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51)
                .addGroup(pnValaszokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btValasz2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btValasz4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        pnValaszokLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btValasz1, btValasz2, btValasz3});

        pnValaszokLayout.setVerticalGroup(
            pnValaszokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnValaszokLayout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(pnValaszokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btValasz1)
                    .addComponent(btValasz2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnValaszokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btValasz3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btValasz4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnValaszokLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btValasz1, btValasz2, btValasz3, btValasz4});

        pnKerdes.setBackground(new java.awt.Color(51, 153, 255));

        lbKerdes.setBackground(new java.awt.Color(0, 153, 255));
        lbKerdes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbKerdes.setForeground(new java.awt.Color(255, 255, 255));
        lbKerdes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbKerdes.setText("jLabel1");

        javax.swing.GroupLayout pnKerdesLayout = new javax.swing.GroupLayout(pnKerdes);
        pnKerdes.setLayout(pnKerdesLayout);
        pnKerdesLayout.setHorizontalGroup(
            pnKerdesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKerdesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbKerdes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnKerdesLayout.setVerticalGroup(
            pnKerdesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbKerdes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        pnJatek.setBackground(new java.awt.Color(0, 153, 255));

        lstOsszegek.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lstOsszegek.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "<html><font color=green><strong>40 000 000 - Garantált</strong></font></html>", "20 000 000", "10 000 000", "5 000 000", "3 000 000", "<html><font color=green><strong>1 500 000 - Garantált</strong></font></html>", "800 000", "500 000", "300 000", "200 000", "<html><font color=green><strong>100 000 - Garantált</strong></font></html>", "25 000", "50 000", "10 000", "5 000" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstOsszegek.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstOsszegek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstOsszegekMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstOsszegek);

        lbGarantalt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbGarantalt.setForeground(new java.awt.Color(255, 255, 255));
        lbGarantalt.setText("0 Ft.-");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kep.jpg"))); // NOI18N

        lbgar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbgar.setForeground(new java.awt.Color(255, 255, 255));
        lbgar.setText("Garantált nyeremény:");

        javax.swing.GroupLayout pnJatekLayout = new javax.swing.GroupLayout(pnJatek);
        pnJatek.setLayout(pnJatekLayout);
        pnJatekLayout.setHorizontalGroup(
            pnJatekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnJatekLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnJatekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnJatekLayout.createSequentialGroup()
                        .addComponent(lbgar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbGarantalt, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnJatekLayout.setVerticalGroup(
            pnJatekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnJatekLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnJatekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbgar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbGarantalt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );

        jMenu1.setText("File");

        miKerdesSzerkeszt.setText("Kérdések szerkesztése");
        miKerdesSzerkeszt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKerdesSzerkesztActionPerformed(evt);
            }
        });
        jMenu1.add(miKerdesSzerkeszt);

        miBezar.setText("Bezár");
        miBezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBezarActionPerformed(evt);
            }
        });
        jMenu1.add(miBezar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnKerdes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnValaszok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnJatek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnJatek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnKerdes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnValaszok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btValasz3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValasz3ActionPerformed
        valalszVizsgal(2);        
    }//GEN-LAST:event_btValasz3ActionPerformed

    private void miBezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBezarActionPerformed
        sajatClose();
    }//GEN-LAST:event_miBezarActionPerformed

    private void btValasz1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValasz1ActionPerformed
        valalszVizsgal(0);      
    }//GEN-LAST:event_btValasz1ActionPerformed

    private void btValasz2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValasz2ActionPerformed
        valalszVizsgal(1);     
    }//GEN-LAST:event_btValasz2ActionPerformed

    private void btValasz4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValasz4ActionPerformed
        valalszVizsgal(3);      
    }//GEN-LAST:event_btValasz4ActionPerformed

    private void miKerdesSzerkesztActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKerdesSzerkesztActionPerformed
         //admin <---------a jelszó!     
         String  m = JOptionPane.showInputDialog("Kérem a jelszót!","admin-t kell beírni.. :)");
        if (m.equals("admin")) {
           KerdesekDialog kd = new KerdesekDialog(this, true, model);
           kd.setVisible(true); 
        }else{
            JOptionPane.showMessageDialog(this, "Nem jó jelszó próbáld újra!");
        }
    }//GEN-LAST:event_miKerdesSzerkesztActionPerformed

    private void lstOsszegekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstOsszegekMouseClicked
       //ne legyen választható az összeg:
        lstOsszegek.setSelectedIndex(listaMeret);
    }//GEN-LAST:event_lstOsszegekMouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Foablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Foablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Foablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Foablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Foablak().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btValasz1;
    private javax.swing.JButton btValasz2;
    private javax.swing.JButton btValasz3;
    private javax.swing.JButton btValasz4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbGarantalt;
    private javax.swing.JLabel lbKerdes;
    private javax.swing.JLabel lbgar;
    private javax.swing.JList<String> lstOsszegek;
    private javax.swing.JMenuItem miBezar;
    private javax.swing.JMenuItem miKerdesSzerkeszt;
    private javax.swing.JPanel pnJatek;
    private javax.swing.JPanel pnKerdes;
    private javax.swing.JPanel pnValaszok;
    // End of variables declaration//GEN-END:variables
}
