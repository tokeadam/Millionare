package gui;

import java.awt.Frame;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import model.IModel;
import model.Kerdes;

/**
 *
 * @author ADAM-PC
 */
public class KerdesekDialog extends javax.swing.JDialog  implements TableModelListener{

   private IModel model;
   private List<Kerdes> kerdesek;
   private DefaultTableModel dtm;
   private Frame parent;
   private Map<Integer, Kerdes> kerdesekMap;
   
   public KerdesekDialog(java.awt.Frame parent, boolean modal, IModel model) {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(parent);
        setTitle("Kérdések adminisztrálása");
        this.model = model;
        this.parent = parent;
        
        dtm = (DefaultTableModel) tblKerdesek.getModel();
        //feliratkozunk a tableListenerre: ennek az osztálynak a table change metódusa meghívódik, ha változik valamilyen érték:
        dtm.addTableModelListener(this);
        try {
            kerdesek = model.getAllKerdesek();
            kerdesekMap = model.getKerdesMap();

        } catch (SQLException ex) {
            Foablak.hibaAblak(ex.toString());
        }

         tablaFrissit();
       
    }

   public void tablaFrissit() {
        dtm.getDataVector().clear();
        dtm.fireTableDataChanged();

        for (Kerdes kerd : kerdesek) {
            Vector sor = new Vector();
            Kerdes kerdes = kerdesekMap.get(kerd.getId());
            sor.add(kerdes.getKerdes());
            sor.add(kerd.getValasz0());
            sor.add(kerd.getValasz1());
            sor.add(kerd.getValasz2());
            sor.add(kerd.getValasz3());
            sor.add(kerd.getHelyesValasz());
            
            dtm.addRow(sor);
        }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblKerdesek = new javax.swing.JTable();
        btUj = new javax.swing.JButton();
        btTorol = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblKerdesek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "kerdes", "valasz0", "valasz1", "valasz2", "valasz3", "helyesvalasz"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblKerdesek.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblKerdesek);

        btUj.setText("Új kérdés");
        btUj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUjActionPerformed(evt);
            }
        });

        btTorol.setText("Törlés");
        btTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTorolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btUj, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btTorol, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btTorol, btUj});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btTorol)
                    .addComponent(btUj, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btTorol, btUj});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btUjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUjActionPerformed
       //Új kérdés ablak nyit:
        KerdesUjDialog kerdUj = new KerdesUjDialog(parent, true, null);
        kerdUj.setVisible(true);

        if (kerdUj.isMentes()) {
            try {
                //adatbázisba beszúrás
                Kerdes k = kerdUj.getKerdes();
                model.addKerdes(k);
                 // A listánkat frissítjük az újból lekérdezett adatokkal:
            kerdesek = model.getAllKerdesek();
            kerdesekMap = model.getKerdesMap();
                tablaFrissit();
            } catch (SQLException ex) {
                Foablak.hibaAblak(ex.toString());
            }
        }
    }//GEN-LAST:event_btUjActionPerformed

    private void btTorolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTorolActionPerformed
        int sor = tblKerdesek.getSelectedRow();
        if (sor >= 0) { //van kiválasztott megrendelés, nagyobb mint -1
            int valasz = JOptionPane.showConfirmDialog(parent, "Biztos, hogy törölni akarod?",
                    "Törlési megerőssítés", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (valasz == JOptionPane.YES_OPTION) {
                Kerdes kivalasztott = kerdesek.get(sor);
                try {
                    model.removeKerdes(kivalasztott);
                    kerdesek.remove(kivalasztott);
                    tablaFrissit();
                } catch (SQLException ex) {
                    Foablak.hibaAblak(ex.toString());
                }

            }

        } else {
            Foablak.hibaAblak("Válassz ki egy sort a törléshez!");
        }
    }//GEN-LAST:event_btTorolActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btTorol;
    private javax.swing.JButton btUj;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKerdesek;
    // End of variables declaration//GEN-END:variables

    @Override
    public void tableChanged(TableModelEvent e) {

        int sor = e.getFirstRow();
        int oszlop = e.getColumn();
        
        if (e.getType() == TableModelEvent.UPDATE && sor >= 0 && oszlop >= 0) {
            Kerdes kivalasztott = kerdesek.get(sor);
            Object ujAdat = dtm.getValueAt(sor, oszlop);
           // System.err.println(dtm.getValueAt(sor, oszlop));
            //System.err.println(oszlop);
            
            switch (oszlop) {
                case 0:
                    kivalasztott.setKerdes((String) ujAdat);                  
                    break;
                case 1:
                    kivalasztott.setValasz0((String) ujAdat);
                    break;
                case 2:
                     kivalasztott.setValasz1((String) ujAdat);
                    break;
                case 3:
                     kivalasztott.setValasz2((String) ujAdat);
                    break;
                case 4:
                     kivalasztott.setValasz3((String) ujAdat);
                    break;
                case 5:
                     kivalasztott.setHelyesValasz((int) ujAdat);
                    break;
            }
            try {
                model.updateKerdes(kivalasztott);
                System.out.println("Sikeres feltöltés: " + kivalasztott.getKerdes());
            } catch (SQLException ex) {
                Foablak.hibaAblak(ex.toString());
            }
        }
    
    }
}
