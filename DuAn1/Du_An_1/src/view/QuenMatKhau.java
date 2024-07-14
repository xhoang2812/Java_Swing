/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import Model.NhanVien;
import ServiceNhanVien.nhanVienService;
import utils.Auth;
import utils.JavaMail;

/**
 *
 * @author Admin
 */
public class QuenMatKhau extends javax.swing.JFrame {

    nhanVienService service = new nhanVienService();

    public QuenMatKhau() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_mail = new javax.swing.JTextField();
        btn_sendOTP = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_otp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_ThayDoi = new javax.swing.JButton();
        btn_huyBo = new javax.swing.JButton();
        txt_mk1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        txt_mk2 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        btn_sendOTP.setText("SEND OTP");
        btn_sendOTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendOTPActionPerformed(evt);
            }
        });

        jLabel3.setText("OTP");

        jLabel4.setText("MAT KHAU MOI");

        jLabel5.setText("XAC NHAN  MAT KHAU MOI");

        btn_ThayDoi.setText("THAY DOI");
        btn_ThayDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThayDoiActionPerformed(evt);
            }
        });

        btn_huyBo.setText("HUY BO");
        btn_huyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyBoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setText("QUEN MAT KHAU");

        jLabel2.setText("YOUR EMAIL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_ThayDoi)
                                .addGap(18, 18, 18)
                                .addComponent(btn_huyBo))
                            .addComponent(txt_mk2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_otp)
                                .addComponent(txt_mail)
                                .addComponent(txt_mk1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_sendOTP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sendOTP))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_otp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_mk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_mk2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ThayDoi)
                    .addComponent(btn_huyBo))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_sendOTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendOTPActionPerformed
        // TODO add your handling code here:
        if (Checkvalidate()) {
            if (service.findByEmail(txt_mail.getText().trim()) != null) {
                Auth.RandomOtp();
                JavaMail.sendmail(txt_mail.getText(), "Ma OTP La: " + Auth.getotp(), "Lay Lai Mat Khau");
                JOptionPane.showMessageDialog(this, "Gui Ma Thanh Cong");
            } else if (service.findByEmail(txt_mail.getText()) == null) {
                JOptionPane.showMessageDialog(this, "Email nhân viên không tồn tại trên hệ thống", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_sendOTPActionPerformed

    private void btn_ThayDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThayDoiActionPerformed
        // TODO add your handling code here:
        
        if (validatee()) {
            if (Auth.getotp() != null && Auth.getotp().equalsIgnoreCase(txt_otp.getText())) {
            doimatkhau();
            Auth.clearOtp();
        } else {
            JOptionPane.showMessageDialog(this, "Mã Xác Nhận Không Chính Xác", "Thông Báo", JOptionPane.WARNING_MESSAGE);
        }
        }
    }//GEN-LAST:event_btn_ThayDoiActionPerformed

    private void btn_huyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyBoActionPerformed

        Auth.clearOtp();
        huyBo();
    }//GEN-LAST:event_btn_huyBoActionPerformed

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
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuenMatKhau().setVisible(true);
            }
        });
    }

    public void doimatkhau() {
        String email = txt_mail.getText();
        String matkhau1 = new String(txt_mk1.getPassword());
        String matkhau2 = new String(txt_mk2.getPassword());
        if (!matkhau1.equals(matkhau2)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu xác nhận không chính xác", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                NhanVien nv = service.findByEmail(email);
                nv.setPassWord(matkhau1);
                service.update(nv);
                JOptionPane.showMessageDialog(this, "Đã cập nhật mật khẩu thành công", "Thông báo", JOptionPane.WARNING_MESSAGE);
                huyBo();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void huyBo() {
        this.dispose();
    }

    public boolean Checkvalidate() {
        try {

            String chkemail = "\\w+@\\w{3,8}+\\.+\\w{2,4}";
            if (txt_mail.getText().trim().equals("")) {
                txt_mail.requestFocus();
                JOptionPane.showMessageDialog(this, "Vui lòng nhập Email", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (!txt_mail.getText().matches(chkemail)) {
                txt_mail.requestFocus();
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng email", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (HeadlessException headlessException) {
            System.out.println("Lỗi validate QuenMk");
        }
        return true;
    }
    
    public boolean validatee(){
        String otp = txt_otp.getText().trim();
        String mk1 = new String(txt_mk1.getPassword());
        String mk2 = new String(txt_mk2.getPassword());
        if (otp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập OTP", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (mk1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (mk2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập xác nhận mật khẩu", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ThayDoi;
    private javax.swing.JButton btn_huyBo;
    private javax.swing.JButton btn_sendOTP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JPasswordField txt_mk1;
    private javax.swing.JPasswordField txt_mk2;
    private javax.swing.JTextField txt_otp;
    // End of variables declaration//GEN-END:variables
}
