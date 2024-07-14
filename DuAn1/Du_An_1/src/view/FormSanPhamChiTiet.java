/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Model.NhaXuatBan;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.NhaCungCap;
import Model.NhaXuatBan;
import Model.SanPhamChiTiet;
import Model.SanPhamChiTietViewModel;
import Model.TacGia;
import Model.TheLoai;
import Model.TruyenDuLieu;
import QLNhaCungCap.QLNhaCungCap;
import QLNhaXuatBan.NhaXuatBanService;
import QLSPCT.SPCTService;
import QLTacGia.QLTacGia;
import ServiceTheLoai.theLoaiService;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.DefaultListModel;

/**
 *
 * @author Admin
 */
public class FormSanPhamChiTiet extends javax.swing.JPanel {

    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("Vi", "VN"));
    QLNhaCungCap NCCService = new QLNhaCungCap();
    DefaultTableModel molSPCT = new DefaultTableModel();
    SPCTService SPCTService = new SPCTService();
    QLTacGia tacGiaService = new QLTacGia();
    NhaXuatBanService nhaXuatBanService = new NhaXuatBanService();
    theLoaiService tlService = new theLoaiService();
    int index = -1;
    TruyenDuLieu tdl = new TruyenDuLieu();
    DefaultComboBoxModel<NhaCungCap> molNcc = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<NhaXuatBan> molNxb = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<TacGia> molTacGia = new DefaultComboBoxModel<>();
    DefaultListModel<TheLoai> molTL = new DefaultListModel<>();

    public FormSanPhamChiTiet() {
        initComponents();
        setNCC();
        setTG();
        setNXB();
        txt_maSp.setText(tdl.getMa());
        txt_tenSp.setText(tdl.getTen());
        fillTable();
        setTheLoai();
    }

    private void setForm(JComponent component) {
        main.removeAll();
        main.add(component);
        main.repaint();
        main.revalidate();
    }

    public void setTheLoai() {
        list_TL.setModel((DefaultListModel) molTL);
        molTL.removeAllElements();
        for (TheLoai x : tlService.getAll()) {
            molTL.addElement(x);
        }
    }

    public void setNCC() {

        cbo_NCC.setModel((DefaultComboBoxModel) molNcc);
        molNcc.removeAllElements();
        for (NhaCungCap x : NCCService.getAllByTT()) {
            molNcc.addElement(x);
        }
    }

    public void setTG() {

        cbo_tacGia.setModel((DefaultComboBoxModel) molTacGia);
        molTacGia.removeAllElements();
        for (TacGia x : tacGiaService.getAllByTT()) {
            molTacGia.addElement(x);
        }
    }

    public void setNXB() {

        cbo_NXB.setModel((DefaultComboBoxModel) molNxb);
        molNxb.removeAllElements();
        for (NhaXuatBan x : nhaXuatBanService.getAllByTT()) {
            molNxb.addElement(x);
        }
    }

    public void fillTable() {
//      molSPCT = (DefaultTableModel) tbl_SPCT.getModel();
        DefaultTableModel model = (DefaultTableModel) tbl_SPCT.getModel();
        model.setRowCount(0);
        for (SanPhamChiTietViewModel x : SPCTService.findAll()) {
            model.addRow(x.toDataRow());
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

    public void showFormFind(int index) {
        NhaCungCap ncc = (NhaCungCap) molNcc.getSelectedItem();
        NhaXuatBan nxb = (NhaXuatBan) molNxb.getSelectedItem();
        TacGia tg = (TacGia) molTacGia.getSelectedItem();
        SanPhamChiTietViewModel sp = SPCTService.findByName(txt_timKiem.getText()).get(index);
        txt_maSPCT.setText(String.valueOf(sp.getId_SanPhamChiTiet()));
        txt_maSp.setText(String.valueOf(sp.getId_SanPham()));
        txt_tenSp.setText(sp.getTen_SanPham());
        cbo_NXB.setSelectedItem(sp.getTen_NXB());
        cbo_NCC.setSelectedItem(sp.getTen_NhaCungCap());
        cbo_tacGia.setSelectedItem(sp.getTen_TacGia());
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

    private SanPhamChiTiet readFormAdd() {
        NhaCungCap ncc = (NhaCungCap) molNcc.getSelectedItem();
        NhaXuatBan nxb = (NhaXuatBan) molNxb.getSelectedItem();
        TacGia tg = (TacGia) molTacGia.getSelectedItem();
        SanPhamChiTiet spct = new SanPhamChiTiet();
        spct.setId_SanPham(Integer.parseInt(txt_maSp.getText()));
        spct.setId_TacGia(tg.getMa());
        spct.setId_NhaCungCap(ncc.getMa());
        spct.setId_NXB(nxb.getManxb());
        spct.setSoLuong(Integer.parseInt(txt_soLuong.getText()));
        spct.setGiaBan(Float.parseFloat(txt_giaBan.getText()));
        spct.setTheLoai(txt_theLoai.getText());
        if (rdo_sanHang.isSelected()) {
            spct.setTrangThai(true);
        } else {
            spct.setTrangThai(false);
        }
        return spct;
    }

    private SanPhamChiTiet readFormUpdate() {
        NhaCungCap ncc = (NhaCungCap) molNcc.getSelectedItem();
        NhaXuatBan nxb = (NhaXuatBan) molNxb.getSelectedItem();
        TacGia tg = (TacGia) molTacGia.getSelectedItem();
        SanPhamChiTiet spct = new SanPhamChiTiet();
        spct.setId_SanPhamChiTiet(Integer.parseInt(txt_maSPCT.getText()));
        spct.setId_SanPham(Integer.parseInt(txt_maSp.getText()));
        spct.setId_TacGia(tg.getMa());
        spct.setId_NhaCungCap(ncc.getMa());
        spct.setId_NXB(nxb.getManxb());
        spct.setSoLuong(Integer.parseInt(txt_soLuong.getText()));
        spct.setGiaBan(Float.parseFloat(txt_giaBan.getText()));
        spct.setTheLoai(txt_theLoai.getText());
        if (rdo_sanHang.isSelected()) {
            spct.setTrangThai(true);
        } else {
            spct.setTrangThai(false);
        }
        return spct;
    }

    private void clear() {

    }

    private boolean validatee() {
        String maSpText = txt_maSp.getText();
        String soLuongText = txt_soLuong.getText();
        String giaBanText = txt_giaBan.getText();
        String theLoai = txt_theLoai.getText();
        if (!rdo_hetHang.isSelected() && !rdo_sanHang.isSelected()) {
            showErrorMessage("Trạng thái không được để trống");
            return false;
        }
        if (theLoai.isEmpty()) {
            showErrorMessage("Thể loại không được để trống");
            return false;
        }
        // Kiểm tra mã sản phẩm
        if (maSpText.isEmpty()) {
            showErrorMessage("Mã sản phẩm không được để trống");
            return false;
        }
        try {
            int maSp = Integer.parseInt(maSpText);
        } catch (NumberFormatException e) {
            showErrorMessage("Mã sản phẩm phải là một số nguyên");
            return false;
        }

        // Kiểm tra số lượng
        if (soLuongText.isEmpty()) {
            showErrorMessage("Số lượng không được để trống");
            return false;
        }
        try {
            int soLuong = Integer.parseInt(soLuongText);
            if (soLuong < 0) {
                showErrorMessage("Số lượng phải là một số lớn hơn không");
                return false;
            }
        } catch (NumberFormatException e) {
            showErrorMessage("Số lượng phải là một số nguyên");
            return false;
        }

        // Kiểm tra giá bán
        if (giaBanText.isEmpty()) {
            showErrorMessage("Giá bán không được để trống");
            return false;
        }
        try {
            float giaBan = Float.parseFloat(giaBanText);
            if (giaBan < 0) {
                showErrorMessage("Giá bán phải là một số lớn hơn không");
                return false;
            }
        } catch (NumberFormatException e) {
            showErrorMessage("Giá bán phải là một số thực");
            return false;
        }

        // Kiểm tra các lựa chọn
        if (molNcc.getSelectedItem() == null) {
            showErrorMessage("Vui lòng chọn nhà cung cấp");
            return false;
        }
        if (molNxb.getSelectedItem() == null) {
            showErrorMessage("Vui lòng chọn nhà xuất bản");
            return false;
        }
        if (molTacGia.getSelectedItem() == null) {
            showErrorMessage("Vui lòng chọn tác giả");
            return false;
        }

        return true;
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Lỗi", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        mainPanel1 = new javax.swing.JPanel();
        main = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_maSPCT = new javax.swing.JTextField();
        txt_maSp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_tenSp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbo_NXB = new javax.swing.JComboBox<>();
        cbo_tacGia = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbo_NCC = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_ngayThem = new javax.swing.JTextField();
        txt_ngaySua = new javax.swing.JTextField();
        txt_soLuong = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_giaBan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rdo_sanHang = new javax.swing.JRadioButton();
        rdo_hetHang = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_SPCT = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        btn_sua2 = new javax.swing.JButton();
        txt_timKiem = new javax.swing.JTextField();
        txt_theLoai = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_TL = new javax.swing.JList<>();
        jButton5 = new javax.swing.JButton();

        mainPanel1.setBackground(new java.awt.Color(255, 204, 204));

        main.setBackground(new java.awt.Color(255, 204, 204));

        jLabel2.setText("Ma SPCT");

        jLabel3.setText("MA SP");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setText("SAN PHAM CHI TIET");

        txt_maSPCT.setEditable(false);

        txt_maSp.setEditable(false);

        jLabel4.setText("Ten SP");

        txt_tenSp.setEditable(false);

        jLabel5.setText("NHA XUAT BAN");

        cbo_NXB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_NXB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_NXBMouseClicked(evt);
            }
        });
        cbo_NXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_NXBActionPerformed(evt);
            }
        });

        cbo_tacGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_tacGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_tacGiaMouseClicked(evt);
            }
        });
        cbo_tacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_tacGiaActionPerformed(evt);
            }
        });

        jLabel6.setText("TAC GIA");

        jLabel7.setText("NHA CUNG CAP");

        cbo_NCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_NCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_NCCMouseClicked(evt);
            }
        });

        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btn_them.setBackground(new java.awt.Color(255, 204, 204));
        btn_them.setText("THEM");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setBackground(new java.awt.Color(255, 204, 204));
        btn_sua.setText("SUA");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        jLabel13.setText("NGAY THEM");

        jLabel12.setText("NGAY SUA");

        jLabel11.setText("SO LUONG");

        jLabel8.setText("GIA BAN");

        jLabel9.setText("THE LOAI");

        jLabel10.setText("TRANG THAI");

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

        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btn_sua2.setBackground(new java.awt.Color(255, 204, 204));
        btn_sua2.setText("CLEAR");
        btn_sua2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sua2ActionPerformed(evt);
            }
        });

        txt_timKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_timKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timKiemKeyReleased(evt);
            }
        });

        list_TL.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list_TL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_TLMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                list_TLMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(list_TL);

        jButton5.setText("+");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_NCC, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainLayout.createSequentialGroup()
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(8, 8, 8)
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_tenSp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(mainLayout.createSequentialGroup()
                                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_maSp, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                            .addComponent(txt_maSPCT))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdo_sanHang)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdo_hetHang))
                                    .addComponent(jLabel8)
                                    .addGroup(mainLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_ngaySua, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_ngayThem, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(mainLayout.createSequentialGroup()
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainLayout.createSequentialGroup()
                                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(18, 18, 18)
                                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbo_tacGia, 0, 190, Short.MAX_VALUE)
                                            .addComponent(cbo_NXB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(mainLayout.createSequentialGroup()
                                                .addComponent(jButton2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9))
                                            .addComponent(jButton4))
                                        .addGap(18, 18, 18)
                                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(mainLayout.createSequentialGroup()
                                                .addGap(0, 1, Short.MAX_VALUE)
                                                .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txt_theLoai)))
                                    .addGroup(mainLayout.createSequentialGroup()
                                        .addGap(285, 285, 285)
                                        .addComponent(jLabel1)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(8, 8, 8))))
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(btn_them)
                        .addGap(18, 18, 18)
                        .addComponent(btn_sua)
                        .addGap(18, 18, 18)
                        .addComponent(btn_sua2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_maSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txt_ngayThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_maSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txt_ngaySua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_tenSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbo_NXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_tacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jButton2)
                            .addComponent(jLabel9)
                            .addComponent(txt_theLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_NCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3)
                        .addComponent(jLabel10)
                        .addComponent(rdo_sanHang)
                        .addComponent(rdo_hetHang)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_sua2)
                    .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanel1Layout = new javax.swing.GroupLayout(mainPanel1);
        mainPanel1.setLayout(mainPanel1Layout);
        mainPanel1Layout.setHorizontalGroup(
            mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanel1Layout.createSequentialGroup()
                .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanel1Layout.setVerticalGroup(
            mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new JFrameTheLoai().setVisible(true);
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void list_TLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_TLMouseClicked
        // TODO add your handling code here:
        int rowListTL = list_TL.getSelectedIndex();
        TheLoai tl = molTL.getElementAt(rowListTL);
        String theLoai = txt_theLoai.getText(); // Lấy giá trị hiện tại của txt_theLoai
        String selectedValue = tl.getTenTheLoai(); // Lấy giá trị được chọn trong listTL

        if (!theLoai.contains(selectedValue)) {
            if (theLoai.isEmpty()) {
                theLoai = selectedValue; // Nếu chuỗi rỗng, gán giá trị được chọn đầu tiên vào chuỗi
            } else {
                theLoai = theLoai + ", " + selectedValue; // Nếu chuỗi không rỗng, thêm giá trị được chọn vào chuỗi cùng dấu phẩy và khoảng trắng
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn Đã Chọn Thể Loại Này Rồi");
        }

        txt_theLoai.setText(theLoai); // Hiển thị chuỗi thể loại đã được cập nhật trong txt_theLoai
    }//GEN-LAST:event_list_TLMouseClicked

    private void txt_timKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiemKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_timKiemKeyPressed

    private void btn_sua2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sua2ActionPerformed
        // TODO add your handling code here:
        txt_maSPCT.setText("");
        txt_maSp.setText("");
        txt_tenSp.setText("");
        txt_ngayThem.setText("");
        txt_ngaySua.setText("");
        txt_soLuong.setText("");
        txt_giaBan.setText("");
        txt_theLoai.setText("");
        rdo_sanHang.setSelected(true);
        cbo_NCC.setSelectedIndex(0);
        cbo_tacGia.setSelectedIndex(0);
        cbo_NXB.setSelectedIndex(0);
    }//GEN-LAST:event_btn_sua2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        new JFrameNXB().setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbl_SPCTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_SPCTKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_SPCTKeyPressed

    private void tbl_SPCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SPCTMouseClicked
        // TODO add your handling code here:
        index = tbl_SPCT.getSelectedRow();
        if (txt_timKiem.getText().isEmpty()) {
            this.showForm(index);
        } else {
            this.showFormFind(index);
        }
    }//GEN-LAST:event_tbl_SPCTMouseClicked

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        try {
            if (validatee()) {
                SanPhamChiTiet sp = readFormUpdate();
                if (SPCTService.update(sp) != null) {
                    JOptionPane.showMessageDialog(this, "Sua thành công");
                    btn_sua2ActionPerformed(evt);
                    this.fillTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Sua thất bại");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        try {
            if (validatee()) {
                SanPhamChiTiet sp = readFormAdd();
                if (SPCTService.add(sp) != null) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    btn_sua2ActionPerformed(evt);
                    this.fillTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        new JFrameNCC().setVisible(true);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        new JFrameTacGia().setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbo_tacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_tacGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_tacGiaActionPerformed

    private void cbo_NXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_NXBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_NXBActionPerformed

    private void txt_timKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiemKeyReleased
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbl_SPCT.getModel();
        model.setRowCount(0);
        for (SanPhamChiTietViewModel x : SPCTService.findByName(txt_timKiem.getText().trim())) {
            model.addRow(x.toDataRow());
        }
    }//GEN-LAST:event_txt_timKiemKeyReleased

    private void cbo_NCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_NCCMouseClicked
        // TODO add your handling code here:
        setNCC();
    }//GEN-LAST:event_cbo_NCCMouseClicked

    private void cbo_tacGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_tacGiaMouseClicked
        // TODO add your handling code here:
        setTG();
    }//GEN-LAST:event_cbo_tacGiaMouseClicked

    private void cbo_NXBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_NXBMouseClicked
        // TODO add your handling code here:
        setNXB();
    }//GEN-LAST:event_cbo_NXBMouseClicked

    private void list_TLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_TLMouseEntered
        // TODO add your handling code here:
        setTheLoai();
    }//GEN-LAST:event_list_TLMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_sua2;
    private javax.swing.JButton btn_them;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbo_NCC;
    private javax.swing.JComboBox<String> cbo_NXB;
    private javax.swing.JComboBox<String> cbo_tacGia;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JList<String> list_TL;
    private javax.swing.JPanel main;
    private javax.swing.JPanel mainPanel1;
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
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables
}
