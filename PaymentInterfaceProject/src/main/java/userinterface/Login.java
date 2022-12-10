/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package userinterface;

import business.Admin;
import business.AdminDirectory;
import business.User;
import business.UserDirectory;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author nbabu
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        roleCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        signUpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 900));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 1000));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/payment.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 310, 431));

        jPanel2.setBackground(new java.awt.Color(116, 185, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 179, 36));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/role.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 50, -1));

        roleCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "System Admin", "Banking Admin", "Bus Admin", "Train Admin", "Recharge Admin", "Utilities Admin", "Events Admin", "Movie Admin" }));
        jPanel2.add(roleCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 160, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 50, 40));

        userNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameFieldActionPerformed(evt);
            }
        });
        jPanel2.add(userNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 160, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/padlock-unlock.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 50, 40));
        jPanel2.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 160, -1));

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel2.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 240, -1));

        signUpButton.setText("Signup");
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });
        jPanel2.add(signUpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameFieldActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        // TODO add your handling code here:
        Registration r = new Registration();
        r.show();
        dispose();
    }//GEN-LAST:event_signUpButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        String userName = userNameField.getText();
        String password = new String(passField.getPassword());
        AdminDirectory ad = new AdminDirectory();
        boolean found = false;
        switch(roleCombo.getSelectedItem().toString())
        {
         case "User":
            UserDirectory ud = new UserDirectory();
            ArrayList<User> userDirectory = ud.getUserList();
            for(User user: userDirectory)
            {
              if(user.getUserName().equals(userName) && user.getPassword().equals(password))
              {
                found = true;
                UserHomePage uhp = new UserHomePage(userName);
                uhp.setVisible(true);
                dispose();
                break;
              }
            }
            if(!found)
                    JOptionPane.showMessageDialog(this, "Username/Password is incorrect.\nPlease enter valid credentials.", "Alert", JOptionPane.WARNING_MESSAGE);
            break;
         case "System Admin":            
            for(Admin admin: ad.getAdminList())
            {
              if(admin.getRole().equals("System Admin") && admin.getUserName().equals(userName) && admin.getPassword().equals(password))
              {
                found = true;
                AdminFrame af = new AdminFrame(roleCombo.getSelectedItem().toString());
                af.setVisible(true);
                dispose();
                break;
              }
            }
            if(!found)
                    JOptionPane.showMessageDialog(this, "Username/Password is incorrect.\nPlease enter valid credentials.", "Alert", JOptionPane.WARNING_MESSAGE);
            break;
         case "Banking Admin":                        
            for(Admin admin: ad.getAdminList())
            {
              if(admin.getRole().equals("Banking Admin") && admin.getUserName().equals(userName) && admin.getPassword().equals(password))
              {
                found = true;
                AdminFrame af = new AdminFrame(roleCombo.getSelectedItem().toString());
                af.setVisible(true);
                dispose();
                break;
              }
            }
            if(!found)
                    JOptionPane.showMessageDialog(this, "Username/Password is incorrect.\nPlease enter valid credentials.", "Alert", JOptionPane.WARNING_MESSAGE);
             break;
         case "Bus Admin":
             for(Admin admin: ad.getAdminList())
             {
              if(admin.getRole().equals("Bus Admin") && admin.getUserName().equals(userName) && admin.getPassword().equals(password))
              {
                found = true;
                AdminFrame af = new AdminFrame(roleCombo.getSelectedItem().toString());
                af.setVisible(true);
                dispose();
                break;
              }
             }
             if(!found)
                    JOptionPane.showMessageDialog(this, "Username/Password is incorrect.\nPlease enter valid credentials.", "Alert", JOptionPane.WARNING_MESSAGE);
             break;
         case "Train Admin":             
             for(Admin admin: ad.getAdminList())
             {
              if(admin.getRole().equals("Train Admin") && admin.getUserName().equals(userName) && admin.getPassword().equals(password))
              {
                found = true;
                AdminFrame af = new AdminFrame(roleCombo.getSelectedItem().toString());
                af.setVisible(true);
                dispose();
                break;
              }
             }
             if(!found)
                    JOptionPane.showMessageDialog(this, "Username/Password is incorrect.\nPlease enter valid credentials.", "Alert", JOptionPane.WARNING_MESSAGE);
             break;
         case "Recharge Admin":
             for(Admin admin: ad.getAdminList())
             {
              if(admin.getRole().equals("Recharge Admin") && admin.getUserName().equals(userName) && admin.getPassword().equals(password))
              {
                found = true;
                AdminFrame af = new AdminFrame(roleCombo.getSelectedItem().toString());
                af.setVisible(true);
                dispose();
                break;
              }
             }
             if(!found)
                    JOptionPane.showMessageDialog(this, "Username/Password is incorrect.\nPlease enter valid credentials.", "Alert", JOptionPane.WARNING_MESSAGE);
             break;
         case "Utilities Admin":
             for(Admin admin: ad.getAdminList())
             {
              if(admin.getRole().equals("Utilities Admin") && admin.getUserName().equals(userName) && admin.getPassword().equals(password))
              {
                found = true;
                AdminFrame af = new AdminFrame(roleCombo.getSelectedItem().toString());
                af.setVisible(true);
                dispose();
                break;
              }
             }
             if(!found)
                    JOptionPane.showMessageDialog(this, "Username/Password is incorrect.\nPlease enter valid credentials.", "Alert", JOptionPane.WARNING_MESSAGE);
             break;
         case "Movie Admin":
             for(Admin admin: ad.getAdminList())
             {
              if(admin.getRole().equals("Movie Admin") && admin.getUserName().equals(userName) && admin.getPassword().equals(password))
              {
                found = true;
                AdminFrame af = new AdminFrame(roleCombo.getSelectedItem().toString());
                af.setVisible(true);
                dispose();
                break;
              }
             }
             if(!found)
                    JOptionPane.showMessageDialog(this, "Username/Password is incorrect.\nPlease enter valid credentials.", "Alert", JOptionPane.WARNING_MESSAGE);
             break;
         case "Events Admin":
             for(Admin admin: ad.getAdminList())
             {
              if(admin.getRole().equals("Events Admin") && admin.getUserName().equals(userName) && admin.getPassword().equals(password))
              {
                found = true;
                AdminFrame af = new AdminFrame(roleCombo.getSelectedItem().toString());
                af.setVisible(true);
                dispose();
                break;
              }
             }
             if(!found)
                    JOptionPane.showMessageDialog(this, "Username/Password is incorrect.\nPlease enter valid credentials.", "Alert", JOptionPane.WARNING_MESSAGE);
             break;             
        }       
    }//GEN-LAST:event_loginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passField;
    private javax.swing.JComboBox<String> roleCombo;
    private javax.swing.JButton signUpButton;
    private javax.swing.JTextField userNameField;
    // End of variables declaration//GEN-END:variables
}
