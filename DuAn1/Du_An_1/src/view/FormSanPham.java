package view;

import Model.Sach;
import Model.TruyenDuLieu;
import ServiceSach.QLSach;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.FormSanPham;

public class FormSanPham extends javax.swing.JPanel {

    private final QLSach data = new QLSach();

    public FormSanPham() {
        initComponents();
//       
        LocalDate ngayHT = LocalDate.now();
        txtNgayTao.setText(ngayHT + "");
        txtNgayTao.setEditable(false);
        txtNgaySua.setEditable(false);
        btnChiTietSanPham.setVisible(false);
        fillTable();
    }

    void fillTable() {
        DefaultTableModel dtm = (DefaultTableModel) this.tblQLSP.getModel();
        dtm.setRowCount(0);
        for (Sach sp : data.getAll()) {
            Object[] rowData = {
                sp.getMa(),
                sp.getTenSach(),
                sp.getNgayTao(),
                sp.getNgaySua()
            };
            dtm.addRow(rowData);
        }
    }

    private Sach check() {
        LocalDate ngayTao = LocalDate.now();
        String tenS = txtTen2.getText();
        txtNgayTao.setText(ngayTao.toString());
        String ngayT = txtNgayTao.getText();

        if (tenS.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Khong de trong ten");
            return null;
        }
        Sach sp = new Sach(tenS, ngayT);
        return sp;
    }

    private Sach checkUpdate() {
        int ma = Integer.parseInt(txtMa2.getText());
        String tenS = txtTen2.getText();
        LocalDate ngaySua = LocalDate.now();
        txtNgaySua.setText(ngaySua.toString());
        String ngayS = txtNgaySua.getText();
        if (tenS.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Khong de trong ten");
            return null;
        }
        Sach sp = new Sach(ma, tenS, ngayS);
        return sp;
    }

    private void setForm(JComponent component) {
        mainPanel.removeAll();
        mainPanel.add(component);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQLSP = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMa2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTen2 = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXemChiTiet = new javax.swing.JButton();
        btnChiTietSanPham = new javax.swing.JButton();
        txtNgaySua = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnSua1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        mainPanel.setBackground(new java.awt.Color(255, 204, 204));
        mainPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        tblQLSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MA", "TEN", "NGAY TAO", "NGAY SUA"
            }
        ));
        tblQLSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQLSP);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("TIM KIEM"));

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("Quản Lý Sản Phẩm");

        jLabel2.setText("MA");

        txtMa2.setBackground(new java.awt.Color(102, 255, 255));
        txtMa2.setText("....");

        jLabel3.setText("TEN");

        btnThem.setBackground(new java.awt.Color(204, 0, 204));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("THEM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(204, 0, 204));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("SUA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXemChiTiet.setBackground(new java.awt.Color(204, 0, 204));
        btnXemChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXemChiTiet.setForeground(new java.awt.Color(255, 255, 255));
        btnXemChiTiet.setText("XEM CHI TIET SAN PHAM");
        btnXemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemChiTietActionPerformed(evt);
            }
        });

        btnChiTietSanPham.setBackground(new java.awt.Color(204, 0, 204));
        btnChiTietSanPham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChiTietSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnChiTietSanPham.setText("THEM SAN PHAM CHI TIET");
        btnChiTietSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietSanPhamActionPerformed(evt);
            }
        });

        jLabel8.setText("NGAY SUA");

        jLabel7.setText("NGAY TAO");

        btnSua1.setBackground(new java.awt.Color(204, 0, 204));
        btnSua1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua1.setForeground(new java.awt.Color(255, 255, 255));
        btnSua1.setText("CLEAR");
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTen2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(txtNgaySua)
                                .addGap(38, 38, 38))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMa2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185)
                        .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                        .addGap(38, 38, 38))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua1)
                        .addGap(18, 18, 18)
                        .addComponent(btnXemChiTiet)
                        .addGap(18, 18, 18)
                        .addComponent(btnChiTietSanPham)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 427, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMa2)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNgaySua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXemChiTiet)
                    .addComponent(btnChiTietSanPham)
                    .addComponent(btnSua1))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(752, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        Sach sp = check();
        if (sp == null) {
            return;
        }
        data.add(sp);
        fillTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tblQLSP.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chon dong can sua");
            return;
        }
        Sach sp = checkUpdate();
        if (sp == null) {
            return;
        }
        data.update(row, sp);
        fillTable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiTietActionPerformed
        setForm(new FormXemChiTiet());
    }//GEN-LAST:event_btnXemChiTietActionPerformed

    private void btnChiTietSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietSanPhamActionPerformed
        TruyenDuLieu tdl = new TruyenDuLieu();
        tdl.setMa(txtMa2.getText());
        tdl.setTen(txtTen2.getText());
        setForm(new FormSanPhamChiTiet());

    }//GEN-LAST:event_btnChiTietSanPhamActionPerformed

    private void tblQLSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLSPMouseClicked
        int row = tblQLSP.getSelectedRow();
        txtMa2.setText(tblQLSP.getValueAt(row, 0).toString());
        txtTen2.setText(tblQLSP.getValueAt(row, 1).toString());
        txtNgayTao.setText(tblQLSP.getValueAt(row, 2).toString());
        if (!txtNgaySua.getText().isEmpty()) {
            // Lấy giá trị từ cột thứ 3 của hàng được chọn trong bảng tblQLSP
            Object value = tblQLSP.getValueAt(row, 3);
            if (value != null) {
                String newValue = value.toString();
                txtNgaySua.setText(newValue);
            }
        }
        btnChiTietSanPham.setVisible(true);
    }//GEN-LAST:event_tblQLSPMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        ArrayList<Sach> ds = data.search(txtTimKiem.getText());
        DefaultTableModel dtm = (DefaultTableModel) this.tblQLSP.getModel();
        dtm.setRowCount(0);
        for (Sach sp : ds) {
            Object[] rowData = {
                sp.getMa(),
                sp.getTenSach(),
                sp.getNgayTao(),
                sp.getNgaySua()
            };
            dtm.addRow(rowData);
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        txtMa2.setText("");
        txtTen2.setText("");
        txtNgaySua.setText("");
        txtNgayTao.setText("");
    }//GEN-LAST:event_btnSua1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTietSanPham;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSua1;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable tblQLSP;
    private javax.swing.JLabel txtMa2;
    private javax.swing.JTextField txtNgaySua;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtTen2;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
