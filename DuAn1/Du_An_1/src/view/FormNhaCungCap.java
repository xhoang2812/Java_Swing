package view;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.NhaCungCap;
import QLNhaCungCap.QLNhaCungCap;
import javax.swing.JComponent;

public class FormNhaCungCap extends javax.swing.JPanel {

    private final QLNhaCungCap data = new QLNhaCungCap();

    public FormNhaCungCap() {
        initComponents();
        LocalDate ngayHT = LocalDate.now();
      
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        rdoHopTac = new javax.swing.JRadioButton();
        rdoNgungHopTac = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        txtNgaySua = new javax.swing.JTextField();
        btnThem1 = new javax.swing.JButton();
        btnSua1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQLNCC = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        lblMa = new javax.swing.JLabel();
        btnQL = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        mainPanel.setBackground(new java.awt.Color(255, 204, 204));
        mainPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setText("Quản Lý Nhà Cung Cấp");

        jLabel7.setText("MA");

        jLabel8.setText("TEN");

        jLabel9.setText("TRANG THAI");

        buttonGroup1.add(rdoHopTac);
        rdoHopTac.setSelected(true);
        rdoHopTac.setText("HOP TAC");

        buttonGroup1.add(rdoNgungHopTac);
        rdoNgungHopTac.setText("NGUNG HOP TAC");

        jLabel10.setText("NGAY TAO");

        jLabel11.setText("NGAY SUA");

        txtNgayTao.setBackground(new java.awt.Color(204, 204, 204));

        txtNgaySua.setBackground(new java.awt.Color(204, 204, 204));
        txtNgaySua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySuaActionPerformed(evt);
            }
        });

        btnThem1.setBackground(new java.awt.Color(204, 0, 204));
        btnThem1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem1.setForeground(new java.awt.Color(255, 255, 255));
        btnThem1.setText("THEM");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnSua1.setBackground(new java.awt.Color(204, 0, 204));
        btnSua1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua1.setForeground(new java.awt.Color(255, 255, 255));
        btnSua1.setText("SUA");
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        tblQLNCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MA", "TEN", "TRANG THAI", "NGAY TAO", "NGAY SUA"
            }
        ));
        tblQLNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLNCCMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQLNCC);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("TIM KIEM"));

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblMa.setText("...");

        btnQL.setBackground(new java.awt.Color(204, 0, 204));
        btnQL.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnQL.setForeground(new java.awt.Color(255, 255, 255));
        btnQL.setText("QUAY LAI");
        btnQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(311, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdoHopTac)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNgungHopTac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(96, 96, 96))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnThem1)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSua1)
                                        .addGap(39, 39, 39)
                                        .addComponent(btnQL))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                            .addComponent(lblMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                            .addComponent(txtNgaySua))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMa))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtNgaySua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rdoHopTac)
                    .addComponent(rdoNgungHopTac))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem1)
                    .addComponent(btnSua1)
                    .addComponent(btnQL))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNgaySuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySuaActionPerformed

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        // TODO add your handling code here:
         NhaCungCap ncc = check();
        if (ncc == null) {
            return;
        }
        data.add(ncc);
        fillTable();
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        // TODO add your handling code here:
        int row = tblQLNCC.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chon dong can sua");
            return;
        }
        NhaCungCap ncc = checkUpdate();
        if (ncc == null) {
            return;
        }
        data.update(row, ncc);
        fillTable();
    }//GEN-LAST:event_btnSua1ActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
         ArrayList<NhaCungCap> ds = data.search(txtTimKiem.getText());
        DefaultTableModel dtm = (DefaultTableModel) this.tblQLNCC.getModel();
        dtm.setRowCount(0);
        for (NhaCungCap ncc : ds) {
            Object[] rowData = {
                ncc.getMa(),
                ncc.getTenNCC(),
                ncc.getTrangThai() == false ? "NGUNG HOP TAC" : "HOP TAC",
                ncc.getNgayTao(),
                ncc.getNgaySua()
            };
            dtm.addRow(rowData);
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void tblQLNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLNCCMouseClicked
        // TODO add your handling code here:
        int row = tblQLNCC.getSelectedRow();
        lblMa.setText(tblQLNCC.getValueAt(row, 0).toString());
        txtTen.setText(tblQLNCC.getValueAt(row, 1).toString());
        if (tblQLNCC.getValueAt(row, 2).equals("HOP TAC")) {
            rdoHopTac.setSelected(true);
        } else {
            rdoNgungHopTac.setSelected(true);
        }
        txtNgayTao.setText(tblQLNCC.getValueAt(row, 3).toString());
        txtNgaySua.setText(tblQLNCC.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tblQLNCCMouseClicked

    private void btnQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLActionPerformed
        setForm(new FormSanPhamChiTiet());    }//GEN-LAST:event_btnQLActionPerformed

    void fillTable() {
        DefaultTableModel dtm = (DefaultTableModel) this.tblQLNCC.getModel();
        dtm.setRowCount(0);
        for (NhaCungCap ncc : data.getAll()) {
            Object[] rowData = {
                ncc.getMa(),
                ncc.getTenNCC(),
                ncc.getTrangThai() == false ? "NGUNG HOP TAC" : "HOP TAC",
                ncc.getNgayTao(),
                ncc.getNgaySua()
            };
            dtm.addRow(rowData);
        }
    }

    private NhaCungCap check() {
        String tenNCC = txtTen.getText();
        String ngayT = txtNgayTao.getText();
        String ngayS = txtNgaySua.getText();

        if (tenNCC.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Khong de trong ten");
            return null;
        }
        NhaCungCap ncc = new NhaCungCap();
        ncc.setTenNCC(tenNCC);
        if (rdoHopTac.isSelected()) {
            ncc.setTrangThai(true);
        } else {
            ncc.setTrangThai(false);
        }
        ncc.setNgayTao(ngayT);
        ncc.setNgaySua(ngayS);
        return ncc;
    }

    private NhaCungCap checkUpdate() {
        int ma = Integer.parseInt(lblMa.getText());
        String tenNCC = txtTen.getText();
        String ngayT = txtNgayTao.getText();
        LocalDate ngaySua = LocalDate.now();
        txtNgaySua.setText(ngaySua + "");
        String ngayS = txtNgaySua.getText();

        if (tenNCC.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Khong de trong ten");
            return null;
        }
        NhaCungCap ncc = new NhaCungCap();
        ncc.setMa(ma);
        ncc.setTenNCC(tenNCC);
        if (rdoHopTac.isSelected()) {
            ncc.setTrangThai(true);
        } else {
            ncc.setTrangThai(false);
        }
        ncc.setNgayTao(ngayT);
        ncc.setNgaySua(ngayS);
        return ncc;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQL;
    private javax.swing.JButton btnSua1;
    private javax.swing.JButton btnThem1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMa;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton rdoHopTac;
    private javax.swing.JRadioButton rdoNgungHopTac;
    private javax.swing.JTable tblQLNCC;
    private javax.swing.JTextField txtNgaySua;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
