
package restaurante;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class RestauranteUI extends javax.swing.JFrame {

 
    public RestauranteUI() {
        initComponents();
        setLocationRelativeTo(null);
	setResizable(false);
	setTitle("Restaurante");     
        //cambia el icono de la ventana
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
	((JPanel)getContentPane()).setOpaque(false); 
        //cambia el fondo de la ventana
	ImageIcon uno = new ImageIcon(this.getClass().getResource("/imagenes/restaurante.jpg"));
	JLabel fondo = new JLabel();
	fondo.setIcon(uno);
	getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
	fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        acercaDeBtn = new javax.swing.JButton();
        valorBtn = new javax.swing.JButton();
        expertosBtn = new javax.swing.JButton();
        salirBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Restaurante");

        acercaDeBtn.setText("Acerca de");
        acercaDeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acercaDeBtnActionPerformed(evt);
            }
        });

        valorBtn.setText("Valor calorico");
        valorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorBtnActionPerformed(evt);
            }
        });

        expertosBtn.setText("Nuestro expertos");
        expertosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expertosBtnActionPerformed(evt);
            }
        });

        salirBtn.setText("Salir");
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(acercaDeBtn)
                .addGap(34, 34, 34)
                .addComponent(valorBtn)
                .addGap(27, 27, 27)
                .addComponent(expertosBtn)
                .addGap(27, 27, 27)
                .addComponent(salirBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(295, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acercaDeBtn)
                    .addComponent(valorBtn)
                    .addComponent(expertosBtn)
                    .addComponent(salirBtn))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acercaDeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acercaDeBtnActionPerformed
        AcercaDeUI aForm = new AcercaDeUI();
        aForm.setVisible(true);
        dispose();
    }//GEN-LAST:event_acercaDeBtnActionPerformed

    private void valorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorBtnActionPerformed
        OpcionesUI oForm = new OpcionesUI();
        oForm.setVisible(true);
        dispose();
    }//GEN-LAST:event_valorBtnActionPerformed

    private void expertosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expertosBtnActionPerformed
         ExpertosUI eForm = new ExpertosUI();
        eForm.setVisible(true);
        dispose();
    }//GEN-LAST:event_expertosBtnActionPerformed

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        dispose();
    }//GEN-LAST:event_salirBtnActionPerformed

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
            java.util.logging.Logger.getLogger(RestauranteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestauranteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestauranteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestauranteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestauranteUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acercaDeBtn;
    private javax.swing.JButton expertosBtn;
    private javax.swing.JButton salirBtn;
    private javax.swing.JButton valorBtn;
    // End of variables declaration//GEN-END:variables
}
