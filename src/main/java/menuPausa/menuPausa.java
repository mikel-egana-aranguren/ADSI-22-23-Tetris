/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menuPausa;
import menuPrincipal.menuPrincipal;
import com.zetcode.*;

/**
 *
 * @author unai
 */
public class menuPausa extends javax.swing.JFrame {

    /**
     * Creates new form menuPausa
     */
    public menuPausa() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        reanudarWord = new javax.swing.JLabel();
        guardarWord = new javax.swing.JLabel();
        personalizarWord = new javax.swing.JLabel();
        reanudarButton = new javax.swing.JPanel();
        iconoReanudar = new javax.swing.JLabel();
        guardarButton = new javax.swing.JPanel();
        iconoGuardar = new javax.swing.JLabel();
        personalizarButton = new javax.swing.JPanel();
        iconoLapiz = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(204, 204, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reanudarWord.setFont(new java.awt.Font("Liberation Sans", 3, 24)); // NOI18N
        reanudarWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reanudarWord.setText("REANUDAR");
        background.add(reanudarWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 180, 40));

        guardarWord.setFont(new java.awt.Font("Liberation Sans", 3, 24)); // NOI18N
        guardarWord.setText("GUARDAR");
        background.add(guardarWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 140, 40));

        personalizarWord.setFont(new java.awt.Font("Liberation Sans", 3, 24)); // NOI18N
        personalizarWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        personalizarWord.setText("PERSONALIZAR");
        background.add(personalizarWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 240, 40));

        reanudarButton.setBackground(new java.awt.Color(204, 204, 255));
        reanudarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reanudarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reanudarButtonMouseClicked(evt);
            }
        });
        reanudarButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconoReanudar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jugar.png"))); // NOI18N
        reanudarButton.add(iconoReanudar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -140, 290, 400));

        background.add(reanudarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 150, 120));

        guardarButton.setBackground(new java.awt.Color(204, 204, 255));
        guardarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarButtonMouseClicked(evt);
            }
        });
        guardarButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconoGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar-el-archivo.png"))); // NOI18N
        guardarButton.add(iconoGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-54, -194, 360, 500));

        background.add(guardarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 150, 110));

        personalizarButton.setBackground(new java.awt.Color(204, 204, 255));
        personalizarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        personalizarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personalizarButtonMouseClicked(evt);
            }
        });
        personalizarButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconoLapiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lapiz(1).png"))); // NOI18N
        personalizarButton.add(iconoLapiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(-54, -204, 360, 510));

        background.add(personalizarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 150, 110));

        titulo.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        titulo.setText("MENÚ DE PAUSA");
        background.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarButtonMouseClicked
        javax.swing.JOptionPane.showMessageDialog(this, "Tras cerrarse el menú pulse la tecla 'G'");
        this.dispose();
    }//GEN-LAST:event_guardarButtonMouseClicked

    private void personalizarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personalizarButtonMouseClicked
        javax.swing.JOptionPane.showMessageDialog(this, "Redirección a la IU de personalización");
    }//GEN-LAST:event_personalizarButtonMouseClicked

    private void reanudarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reanudarButtonMouseClicked
        javax.swing.JOptionPane.showMessageDialog(this, "Cuando se cierre el menú pulse la tecla 'P'");
        this.dispose();
    }//GEN-LAST:event_reanudarButtonMouseClicked

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
            java.util.logging.Logger.getLogger(menuPausa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuPausa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuPausa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuPausa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuPausa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel guardarButton;
    private javax.swing.JLabel guardarWord;
    private javax.swing.JLabel iconoGuardar;
    private javax.swing.JLabel iconoLapiz;
    private javax.swing.JLabel iconoReanudar;
    private javax.swing.JPanel personalizarButton;
    private javax.swing.JLabel personalizarWord;
    private javax.swing.JPanel reanudarButton;
    private javax.swing.JLabel reanudarWord;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
