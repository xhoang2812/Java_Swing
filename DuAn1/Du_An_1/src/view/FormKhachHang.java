/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Model.KhachHang;
import ServiceKhachHang.QLKhachHang;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author ADmin
 */
public class FormKhachHang extends javax.swing.JPanel {

    ArrayList<KhachHang> dskh = new ArrayList<>();
    QLKhachHang qlkh = new QLKhachHang();
    DefaultTableModel tblModel;
    int index = -1;

    public FormKhachHang() {
        initComponents();
        dskh = qlkh.getAllDao();
        fillTable();
        LocalDate ngayHienTai = LocalDate.now();
        txtNgayThem.setText(ngayHienTai + "");
        txtsua.setText(ngayHienTai + "");

    }

    public void fillTable() {
        tblModel = (DefaultTableModel) tblKH.getModel();
        tblModel.setRowCount(0);
        int index = 0;
        for (KhachHang kh : qlkh.getAllDao()) {
            tblModel.addRow(new Object[]{kh.getMa(), kh.getTen(), kh.getGioiTinh() == 1 ? "Nam" : "Nu", kh.getSdt(), kh.getThem(), kh.getSua(), kh.getTrangThai() == 1 ? "KHACH LE" : "KHACH DAI LY"});
        }
    }

    public void fillTableTim() {
        tblModel = (DefaultTableModel) tblKH.getModel();
        tblModel.setRowCount(0);
        int index = 0;
        for (KhachHang kh : qlkh.getAllDaoTimKiem(txtTimKiem.getText())) {
            tblModel.addRow(new Object[]{kh.getMa(), kh.getTen(), kh.getGioiTinh() == 1 ? "Nam" : "Nu", kh.getSdt(), kh.getThem(), kh.getSua(), kh.getTrangThai() == 1 ? "KHACH LE" : "KHACH DAI LY"});
        }
    }

    public void setModel(KhachHang kh) {
        txtMa.setText(String.valueOf(kh.getMa()));
        txtTen.setText(kh.getTen());
        txtSdt.setText(kh.getSdt() + "");
        if (kh.getGioiTinh() == 1) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        if (kh.getTrangThai() == 0) {
            rdo_kdl.setSelected(true);
        } else {
            rdo_kl.setSelected(true);
        }
        txtNgayThem.setText(kh.getThem());
        txtsua.setText(kh.getSua());
    }

    public KhachHang addModel() {
        KhachHang kh = new KhachHang();
        kh.setTen(txtTen.getText());
        kh.setSdt(txtSdt.getText());
        kh.setGioiTinh(rdoNam.isSelected() ? 1 : 0);
        kh.setThem(txtNgayThem.getText());
        if (rdo_kl.isSelected()) {
            kh.setTrangThai(1);
        } else {
            kh.setTrangThai(0);
        }

        return kh;
    }

    public KhachHang updateModel() {
        KhachHang kh = new KhachHang();
        kh.setMa(Integer.parseInt(txtMa.getText()));
        kh.setTen(txtTen.getText());
        kh.setSdt(txtSdt.getText());
        kh.setGioiTinh(rdoNam.isSelected() ? 1 : 0);
        kh.setSua(txtsua.getText());
        if (rdo_kl.isSelected()) {
            kh.setTrangThai(1);
        } else {
            kh.setTrangThai(0);
        }

        return kh;
    }

    public boolean check() {

        if (txtTen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên đầy đủ");
            return false;
        }
        if (!txtTen.getText().matches("^[\\p{L}\\s'-]+$")) {
                txtTen.requestFocus();
                JOptionPane.showMessageDialog(this, "Tên không chứa kí tự đặc biệt");
                return false;
            }

        if (txtSdt.getText().isEmpty()) {
            String chksdt = "\\d{10}";
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại đầy đủ");
            return false;
        }
        if (!rdoNam.isSelected() && !rdoNu.isSelected()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính");
            return false;
        }
        if (!rdo_kl.isSelected() && !rdo_kdl.isSelected()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn trạng thái");
            return false;
        }
        String chksdt = "\\d{10}";
        if (!txtSdt.getText().matches(chksdt)) {
            txtSdt.requestFocus();
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng SDT");
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKH = new javax.swing.JTable();
        txtMa = new javax.swing.JTextField();
        btnxoa1 = new javax.swing.JButton();
        txtNgayThem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtsua = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rdo_kdl = new javax.swing.JRadioButton();
        rdo_kl = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("QUAN LY KHACH HANG");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("MA  KH");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("TEN KH");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("SDT");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("TRANG THAi");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("GIOI TINH");

        buttonGroup2.add(rdoNam);
        rdoNam.setText("NAM");

        buttonGroup2.add(rdoNu);
        rdoNu.setText("NU");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("TIM KIEM THEO TEN");

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        btnthem.setText("THEM");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setText("SUA");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        tblKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "MA KH", "TEN KH", "GIOI TINH", "SDT", "NGAY THEM", "NGAY SUA", "TRANG THAI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKH);

        txtMa.setEditable(false);
        txtMa.setEnabled(false);
        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        btnxoa1.setText("CLEAR");
        btnxoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoa1ActionPerformed(evt);
            }
        });

        txtNgayThem.setEditable(false);
        txtNgayThem.setEnabled(false);
        txtNgayThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayThemActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("NGAY TAO");

        txtsua.setEditable(false);
        txtsua.setEnabled(false);
        txtsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsuaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("NGAY SUA");

        buttonGroup1.add(rdo_kdl);
        rdo_kdl.setText("KHACH DAI LY");

        buttonGroup1.add(rdo_kl);
        rdo_kl.setText("KHACH LE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayThem, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(rdoNam)
                        .addGap(44, 44, 44)
                        .addComponent(rdoNu))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(60, 60, 60)
                        .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdo_kl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(rdo_kdl))
                            .addComponent(txtsua))
                        .addGap(3, 3, 3)))
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnthem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnxoa1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(257, 257, 257))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnxoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgayThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtsua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(rdo_kdl)
                            .addComponent(rdo_kl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(339, 339, 339))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        dskh = qlkh.getAllDaoTimKiem(txtTimKiem.getText());
        fillTableTim();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        index = tblKH.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
            return;
        }
        LocalDate ngayHienTai1 = LocalDate.now();
        txtsua.setText(ngayHienTai1 + "");
        if (check()) {
            try {
                qlkh.update(updateModel());
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(this, "Số điện thoại trùng, vui lòng nhập lại");
            }
            JOptionPane.showMessageDialog(this, "Sửa khách hàng thành công");
            dskh = qlkh.getAllDao();
            fillTable();
            btnxoa1ActionPerformed(evt);
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed

        for (KhachHang khachHang : qlkh.getAllDao()) {
            if (khachHang.getSdt().equals(txtSdt.getText().trim())) {
                JOptionPane.showMessageDialog(this, "SDT đã tồn tại, vui lòng nhập SDT khác");
                return;
            }
        }
        LocalDate ngayHienTai = LocalDate.now();
        txtNgayThem.setText(ngayHienTai + "");
        if (check()) {
            qlkh.add(addModel());
            JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
            dskh = qlkh.getAllDao();
            fillTable();
            btnxoa1ActionPerformed(evt);
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void tblKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKHMouseClicked

        int chon = tblKH.getSelectedRow();
        setModel(dskh.get(chon));
    }//GEN-LAST:event_tblKHMouseClicked

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void btnxoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoa1ActionPerformed
        txtMa.setText("");
        txtTen.setText("");
        txtSdt.setText("");
        txtsua.setText("");
        txtNgayThem.setText("");
    }//GEN-LAST:event_btnxoa1ActionPerformed

    private void txtNgayThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayThemActionPerformed

    }//GEN-LAST:event_txtNgayThemActionPerformed

    private void txtsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsuaActionPerformed

    }//GEN-LAST:event_txtsuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdo_kdl;
    private javax.swing.JRadioButton rdo_kl;
    private javax.swing.JTable tblKH;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgayThem;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtsua;
    // End of variables declaration//GEN-END:variables

}
