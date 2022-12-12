/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package recuperarPass;

import java.awt.*;
import Login.Login;

/**
 *
 * @author unai
 */
public class recuperarPass extends javax.swing.JFrame {

    /**
     * Creates new form recuperarPass
     */
    public recuperarPass() {
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
        panelCandado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        frase1 = new javax.swing.JLabel();
        frase2 = new javax.swing.JLabel();
        frase3 = new javax.swing.JLabel();
        frase4 = new javax.swing.JLabel();
        usuarioMail = new javax.swing.JTextField();
        enviarButton = new javax.swing.JPanel();
        EnviarWord = new javax.swing.JLabel();
        volverIncioSesionButton = new javax.swing.JPanel();
        inicioSesionWord = new javax.swing.JLabel();
        crearCuentaButton = new javax.swing.JPanel();
        cerarCuentaWord = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new Color(204, 204, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCandado.setBackground(new Color(204, 204, 255));
        panelCandado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/candado.png"))); // NOI18N
        panelCandado.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, -20, -1, -1));

        background.add(panelCandado, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 90, 270, 210));

        frase1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        frase1.setText("¿Problemas para iniciar sesión?");
        background.add(frase1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        frase2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        frase2.setText("tu cuenta");
        background.add(frase2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 280, 30));

        frase3.setText("Introduce tu e-mail o nombre de usuario, ");
        background.add(frase3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 280, 30));

        frase4.setText("te enviaremos un enlace para recuperar ");
        background.add(frase4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 280, 30));

        usuarioMail.setForeground(new Color(204, 204, 204));
        usuarioMail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usuarioMail.setText("Introduce tu nombre de usuario o e-mail");
        usuarioMail.setBorder(null);
        usuarioMail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usuarioMailMousePressed(evt);
            }
        });
        background.add(usuarioMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 330, 40));

        enviarButton.setBackground(new Color(255, 51, 153));
        enviarButton.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
        enviarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        enviarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enviarButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                enviarButtonMousePressed(evt);
            }
        });
        enviarButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EnviarWord.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        EnviarWord.setForeground(new Color(255, 255, 255));
        EnviarWord.setText("ENVIAR ENLACE");
        enviarButton.add(EnviarWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        background.add(enviarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 200, 40));

        volverIncioSesionButton.setBackground(new Color(204, 204, 255));
        volverIncioSesionButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        volverIncioSesionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volverIncioSesionButtonMouseClicked(evt);
            }
        });
        volverIncioSesionButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inicioSesionWord.setText("Volver a inicio de sesión");
        volverIncioSesionButton.add(inicioSesionWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        background.add(volverIncioSesionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 600, 160, 30));

        crearCuentaButton.setBackground(new Color(204, 204, 255));
        crearCuentaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearCuentaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crearCuentaButtonMouseClicked(evt);
            }
        });
        crearCuentaButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cerarCuentaWord.setText("Crear una nueva cuenta");
        crearCuentaButton.add(cerarCuentaWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        background.add(crearCuentaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, 200, 30));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioMailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioMailMousePressed
        if (usuarioMail.getText().equals("Introduce tu nombre de usuario o e-mail")){
            usuarioMail.setText("");
            usuarioMail.setForeground(Color.black);
        }
    }//GEN-LAST:event_usuarioMailMousePressed

    private void enviarButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enviarButtonMousePressed
    }//GEN-LAST:event_enviarButtonMousePressed

    private void crearCuentaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearCuentaButtonMouseClicked
        javax.swing.JOptionPane.showMessageDialog(this, "Redirección a crear cuenta.");
    }//GEN-LAST:event_crearCuentaButtonMouseClicked

    private void enviarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enviarButtonMouseClicked
        javax.swing.JOptionPane.showMessageDialog(this, "Enviar enlace para recuperar la cuenta.");
    }//GEN-LAST:event_enviarButtonMouseClicked

    private void volverIncioSesionButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverIncioSesionButtonMouseClicked
        this.dispose();
        Login inicioSesion = new Login();
        inicioSesion.setVisible(true);

    }//GEN-LAST:event_volverIncioSesionButtonMouseClicked

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
            java.util.logging.Logger.getLogger(recuperarPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(recuperarPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(recuperarPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(recuperarPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new recuperarPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EnviarWord;
    private javax.swing.JPanel background;
    private javax.swing.JLabel cerarCuentaWord;
    private javax.swing.JPanel crearCuentaButton;
    private javax.swing.JPanel enviarButton;
    private javax.swing.JLabel frase1;
    private javax.swing.JLabel frase2;
    private javax.swing.JLabel frase3;
    private javax.swing.JLabel frase4;
    private javax.swing.JLabel inicioSesionWord;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelCandado;
    private javax.swing.JTextField usuarioMail;
    private javax.swing.JPanel volverIncioSesionButton;
    // End of variables declaration//GEN-END:variables
}