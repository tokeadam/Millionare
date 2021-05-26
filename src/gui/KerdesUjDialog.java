package gui;

import model.Kerdes;

/**
 *
 * @author ADAM-PC
 */
public class KerdesUjDialog extends javax.swing.JDialog {

    private Kerdes kerdes;
    private boolean mentes;
    
    public KerdesUjDialog(java.awt.Frame parent, boolean modal, Kerdes kerdes) {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(parent);       
        
        this.mentes = false;
        this.kerdes = kerdes;
        if (kerdes != null) { //szerkesztes
            tfKerdes.setText(kerdes.getKerdes());
            tfKerdes.setText(kerdes.getValasz0());

            setTitle("Kérdés szerkesztése");
        } else {
            setTitle("Új kérdés felvétele");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSpinHelyesValasz = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        tfKerdes = new javax.swing.JTextField();
        tfValasz0 = new javax.swing.JTextField();
        tfValasz1 = new javax.swing.JTextField();
        tfValasz2 = new javax.swing.JTextField();
        tfValasz3 = new javax.swing.JTextField();
        btMent = new javax.swing.JButton();
        btMegsem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Kérdés:");

        jLabel2.setText("Válasz lehetőség 0:");

        jLabel3.setText("Válasz lehetőség 1:");

        jLabel4.setText("Válasz lehetőség 2:");

        jLabel5.setText("Válasz lehetőség 3:");

        jSpinHelyesValasz.setModel(new javax.swing.SpinnerNumberModel(0, 0, 3, 1));

        jLabel6.setText("A helyes válasz:");

        btMent.setText("Mentés");
        btMent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMentActionPerformed(evt);
            }
        });

        btMegsem.setText("Mégsem");
        btMegsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMegsemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfKerdes, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(tfValasz3, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfValasz0, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfValasz1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfValasz2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinHelyesValasz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btMent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btMegsem)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfKerdes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfValasz0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfValasz1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfValasz2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfValasz3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinHelyesValasz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btMent)
                    .addComponent(btMegsem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btMegsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMegsemActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btMegsemActionPerformed

    private void btMentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMentActionPerformed
        if (!tfKerdes.getText().isEmpty() && !tfValasz0.getText().isEmpty() && !tfValasz1.getText().isEmpty() && !tfValasz2.getText().isEmpty() && !tfValasz3.getText().isEmpty()) {

            if (kerdes == null) {
                kerdes = new Kerdes();
            }
            kerdes.setKerdes(tfKerdes.getText());
            kerdes.setValasz0(tfValasz0.getText());
            kerdes.setValasz1(tfValasz1.getText());
            kerdes.setValasz2(tfValasz2.getText());
            kerdes.setValasz3(tfValasz3.getText());
            kerdes.setHelyesValasz(Integer.parseInt(jSpinHelyesValasz.getValue().toString()));

            mentes = true;
            setVisible(false);
        } else {
            Foablak.hibaAblak("Mind a négy mező kitöltése kötelező");
        }
    }//GEN-LAST:event_btMentActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMegsem;
    private javax.swing.JButton btMent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner jSpinHelyesValasz;
    private javax.swing.JTextField tfKerdes;
    private javax.swing.JTextField tfValasz0;
    private javax.swing.JTextField tfValasz1;
    private javax.swing.JTextField tfValasz2;
    private javax.swing.JTextField tfValasz3;
    // End of variables declaration//GEN-END:variables

    public Kerdes getKerdes() {
        return kerdes;
    }   

    public boolean isMentes() {
        return mentes;
    }

}
