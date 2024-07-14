/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Model.NhaCungCap;
import Model.NhaXuatBan;
import Model.SanPhamChiTiet;
import Model.SanPhamChiTietViewModel;
import Model.TacGia;
import Model.TruyenDuLieu;
import QLNhaCungCap.QLNhaCungCap;
import QLNhaXuatBan.NhaXuatBanService;
import QLSPCT.SPCTService;
import QLTacGia.QLTacGia;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADmin
 */
public class FormXemChiTiet extends javax.swing.JPanel {

    QLNhaCungCap NCCService = new QLNhaCungCap();
    DefaultTableModel molSPCT = new DefaultTableModel();
    SPCTService SPCTService = new SPCTService();
    QLTacGia tacGiaService = new QLTacGia();
    NhaXuatBanService nhaXuatBanService = new NhaXuatBanService();
    int index = -1;
    TruyenDuLieu tdl = new TruyenDuLieu();
    DefaultComboBoxModel<NhaCungCap> molNcc = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<NhaXuatBan> molNxb = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<TacGia> molTacGia = new DefaultComboBoxModel<>();

    public FormXemChiTiet() {
        initComponents();

        txt_maSp.setText(tdl.getMa());
        txt_tenSp.setText(tdl.getTen());
        fillTable();
        setNCC();
        setTG();
        setNXB();
    }

    private void setForm(JComponent component) {
        mainPanel.removeAll();
        mainPanel.add(component);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    public void fillTable() {
//        molSPCT = (DefaultTableModel) tbl_SPCT.getModel();
        DefaultTableModel model = (DefaultTableModel) tbl_SPCT.getModel();
        model.setRowCount(0);
        for (SanPhamChiTietViewModel x : SPCTService.findAll()) {
            model.addRow(x.toDataRow());
        }
    }

    public void setNCC() {
        cbo_NCC.setModel((DefaultComboBoxModel) molNcc);
        for (NhaCungCap x : NCCService.getAll()) {
            molNcc.addElement(x);
        }
    }

    public void setTG() {
        cbo_tacGia.setModel((DefaultComboBoxModel) molTacGia);
        for (TacGia x : tacGiaService.getAll()) {
            molTacGia.addElement(x);
        }
    }

    public void setNXB() {
        cbo_NXB.setModel((DefaultComboBoxModel) molNxb);
        for (NhaXuatBan x : nhaXuatBanService.getAll()) {
            molNxb.addElement(x);
        }
    }

    public void showForm(int index) {
        SanPhamChiTiet spct = SPCTService.findAllID().get(index);
        int selectedNCCIndex = -1;
        //Chạy for tìm id phù họp để set theo index của cbo
        for (int i = 0; i < molNcc.getSize(); i++) {
            NhaCungCap ncc = (NhaCungCap) molNcc.getElementAt(i);
            if (ncc.getMa() == spct.getId_NhaCungCap()) {
                selectedNCCIndex = i;
                break;
            }
        }
        int selectedTGIndex = -1;
        for (int i = 0; i < molTacGia.getSize(); i++) {
            TacGia tg = (TacGia) molTacGia.getElementAt(i);
            if (tg.getMa() == spct.getId_TacGia()) {
                selectedTGIndex = i;
                break;
            }
        }
        int selectedNXBIndex = -1;
        for (int i = 0; i < molNxb.getSize(); i++) {
            NhaXuatBan nxb = (NhaXuatBan) molNxb.getElementAt(i);
            if (nxb.getManxb() == spct.getId_NXB()) {
                selectedNXBIndex = i;
                break;
            }
        }
        cbo_NXB.setSelectedIndex(selectedNXBIndex);
        cbo_tacGia.setSelectedIndex(selectedTGIndex);
        cbo_NCC.setSelectedIndex(selectedNCCIndex);

        SanPhamChiTietViewModel sp = SPCTService.findAll().get(index);
        txt_maSPCT.setText(String.valueOf(sp.getId_SanPhamChiTiet()));
        txt_maSp.setText(String.valueOf(sp.getId_SanPham()));
        txt_tenSp.setText(sp.getTen_SanPham());
        txt_ngayThem.setText(String.valueOf(sp.getNgayTao()));
        txt_ngaySua.setText(String.valueOf(sp.getNgaySua()));
        txt_soLuong.setText(String.valueOf(sp.getSoLuong()));
        txt_giaBan.setText(String.valueOf(sp.getGiaBan()));
        txt_theLoai.setText(sp.getTheLoai());
        if (sp.isTrangThai() == true) {
            rdo_sanHang.setSelected(true);
        } else {
            rdo_hetHang.setSelected(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txt_maSPCT = new javax.swing.JTextField();
        txt_maSp = new javax.swing.JTextField();
        txt_tenSp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbo_NCC = new javax.swing.JComboBox<>();
        cbo_tacGia = new javax.swing.JComboBox<>();
        cbo_NXB = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_ngayThem = new javax.swing.JTextField();
        txt_ngaySua = new javax.swing.JTextField();
        txt_soLuong = new javax.swing.JTextField();
        txt_giaBan = new javax.swing.JTextField();
        rdo_sanHang = new javax.swing.JRadioButton();
        rdo_hetHang = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_SPCT = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_theLoai = new javax.swing.JTextField();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        mainPanel.setBackground(new java.awt.Color(255, 204, 204));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        txt_maSPCT.setEditable(false);
        txt_maSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maSPCTActionPerformed(evt);
            }
        });

        txt_maSp.setEditable(false);

        txt_tenSp.setEditable(false);

        jLabel4.setText("Ten SP");

        jLabel3.setText("MA SP");

        jLabel2.setText("Ma SPCT");

        jLabel5.setText("NHA XUAT BAN");

        jLabel6.setText("TAC GIA");

        jLabel7.setText("NHA CUNG CAP");

        cbo_NCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbo_tacGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbo_NXB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_NXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_NXBActionPerformed(evt);
            }
        });

        jLabel10.setText("TRANG THAI");

        jLabel9.setText("THE LOAI");

        jLabel8.setText("GIA BAN");

        jLabel11.setText("SO LUONG");

        jLabel12.setText("NGAY SUA");

        jLabel13.setText("NGAY THEM");

        txt_ngayThem.setEditable(false);

        txt_ngaySua.setEditable(false);

        txt_soLuong.setEditable(false);

        txt_giaBan.setEditable(false);
        txt_giaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_giaBanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdo_sanHang);
        rdo_sanHang.setText("DANG BAN");

        buttonGroup1.add(rdo_hetHang);
        rdo_hetHang.setText("NGUNG BAN");

        tbl_SPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_SPCT", "TEN SP", "NXB", "NCC", "TAC GIA", "The Loai", "GIA BAN", "SO LUONG", "NGAY TAO", "NGAY SUA", "TRANG THAI"
            }
        ));
        tbl_SPCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SPCTMouseClicked(evt);
            }
        });
        tbl_SPCT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_SPCTKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_SPCT);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setText("SAN PHAM CHI TIET CO TAI QUAY");

        txt_theLoai.setEditable(false);
        txt_theLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_theLoaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt_theLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(7, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(12, 12, 12)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_maSp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                .addComponent(txt_maSPCT, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_tenSp))
                            .addGap(30, 30, 30)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel12))
                                        .addGap(48, 48, 48)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_ngaySua, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_ngayThem, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(rdo_sanHang)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdo_hetHang))
                                            .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbo_tacGia, 0, 190, Short.MAX_VALUE)
                                .addComponent(cbo_NXB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(cbo_NCC, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(54, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(txt_theLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txt_maSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(txt_ngayThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txt_maSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(txt_ngaySua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txt_tenSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cbo_NXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_tacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel9))
                    .addGap(7, 7, 7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_NCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(rdo_sanHang)
                            .addComponent(rdo_hetHang)))
                    .addContainerGap(294, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_SPCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SPCTMouseClicked
        index = tbl_SPCT.getSelectedRow();
        this.showForm(index);
    }//GEN-LAST:event_tbl_SPCTMouseClicked

    private void tbl_SPCTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_SPCTKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_SPCTKeyPressed

    private void txt_maSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maSPCTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maSPCTActionPerformed

    private void cbo_NXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_NXBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_NXBActionPerformed

    private void txt_giaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_giaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_giaBanActionPerformed

    private void txt_theLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_theLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_theLoaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbo_NCC;
    private javax.swing.JComboBox<String> cbo_NXB;
    private javax.swing.JComboBox<String> cbo_tacGia;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton rdo_hetHang;
    private javax.swing.JRadioButton rdo_sanHang;
    private javax.swing.JTable tbl_SPCT;
    private javax.swing.JTextField txt_giaBan;
    private javax.swing.JTextField txt_maSPCT;
    private javax.swing.JTextField txt_maSp;
    private javax.swing.JTextField txt_ngaySua;
    private javax.swing.JTextField txt_ngayThem;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_tenSp;
    private javax.swing.JTextField txt_theLoai;
    // End of variables declaration//GEN-END:variables
}
