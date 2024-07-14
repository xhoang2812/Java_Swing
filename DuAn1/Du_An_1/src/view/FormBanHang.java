/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Model.BanHangGioHang;
import Model.BanHangSanPham;
import Model.KhachHang;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import Model.Sach;
import ServiceBanHang.QLBanHang;
import javax.swing.JOptionPane;
import Model.BanHangHoaDonCho;
import Model.HoaDon;
import Model.KhuyenMai;
import Model.NhanVien;
import Model.SanPhamBanHang;
import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;
import Model.XuatFile;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import utils.Auth;

public class FormBanHang extends javax.swing.JPanel {

    DefaultTableModel molTableGioHang = new DefaultTableModel();
    DefaultTableModel molTableSp = new DefaultTableModel();
    DefaultTableModel molHoaDon = new DefaultTableModel();

    DefaultComboBoxModel<NhanVien> molNv = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<KhuyenMai> molKm = new DefaultComboBoxModel<>();

    QLBanHang service = new QLBanHang();
    BanHangGioHang bhgh = new BanHangGioHang();
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("Vi", "VN"));

    private int rowHd = -1;
    private int rowGioHang = -1;
    private int rowSanPham = -1;

    DefaultTableModel tblModel = new DefaultTableModel();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public FormBanHang() {

        initComponents();
        cbo_thanhToan.removeAllItems();
        cbo_thanhToan.addItem("Tien Mat");
        cbo_thanhToan.addItem("Chuyen Khoan");
        lbl_tenNhanVien.setText("ID: " + Auth.user.getId() + ". " + Auth.user.getTenNhanVien());
        setComBoKM();
        fillTableSanPham();
        fillTableHoaDon();

    }

    public BanHangGioHang addModel() {
        BanHangGioHang hd = new BanHangGioHang();

        return hd;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_tenKH = new javax.swing.JTextField();
        txt_sdtKH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbo_km = new javax.swing.JComboBox<>();
        cbo_thanhToan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_tiemGiam = new javax.swing.JLabel();
        lbl_tongTien = new javax.swing.JLabel();
        txt_tienKhachDua = new javax.swing.JTextField();
        lbl_tienThua = new javax.swing.JLabel();
        btn_thanhToan = new javax.swing.JButton();
        btn_taoHoaDon = new javax.swing.JButton();
        btn_huy = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_hoaDon = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btn_suaGioHang = new javax.swing.JButton();
        btn_xoaGiaHang = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_gioHang = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txt_maHoaDon = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_thanhTien = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_tenNhanVien = new javax.swing.JLabel();
        btn_suaGioHang1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        mainPanel.setBackground(new java.awt.Color(255, 204, 204));
        mainPanel.setForeground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setText("BAN HANG");

        jLabel2.setText("SDT KH");

        jLabel3.setText("TEN KH");

        txt_tenKH.setEditable(false);

        txt_sdtKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sdtKHActionPerformed(evt);
            }
        });
        txt_sdtKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_sdtKHKeyPressed(evt);
            }
        });

        jLabel4.setText("MA NV");

        jLabel5.setText("MA KM");

        jLabel6.setText("THANH TOAN");

        cbo_km.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbo_km.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_kmMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbo_kmMouseEntered(evt);
            }
        });
        cbo_km.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_kmActionPerformed(evt);
            }
        });

        cbo_thanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_thanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_thanhToanActionPerformed(evt);
            }
        });

        jLabel7.setText("TONG TIEN");

        jLabel8.setText("TIEN GIAM");

        jLabel9.setText("TIEN KHACH DUA");

        jLabel10.setText("TIEN THUA");

        lbl_tiemGiam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_tiemGiam.setForeground(new java.awt.Color(102, 102, 255));
        lbl_tiemGiam.setText("0");

        lbl_tongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_tongTien.setForeground(new java.awt.Color(51, 51, 255));
        lbl_tongTien.setText("0");

        txt_tienKhachDua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_tienKhachDua.setForeground(new java.awt.Color(51, 51, 255));
        txt_tienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tienKhachDuaActionPerformed(evt);
            }
        });
        txt_tienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tienKhachDuaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tienKhachDuaKeyReleased(evt);
            }
        });

        lbl_tienThua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_tienThua.setForeground(new java.awt.Color(102, 102, 255));
        lbl_tienThua.setText("0");

        btn_thanhToan.setText("THANH TOAN");
        btn_thanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhToanActionPerformed(evt);
            }
        });

        btn_taoHoaDon.setText("TAO HOA DON");
        btn_taoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoHoaDonActionPerformed(evt);
            }
        });

        btn_huy.setText("HUY");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        jLabel14.setText("TIM KIEM");

        txt_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timKiemActionPerformed(evt);
            }
        });

        tbl_hoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MA HD", "NHAN VIEN", "KHACH HANG", "NGAY TAO", "TRANG THAI"
            }
        ));
        tbl_hoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_hoaDon);

        jLabel15.setText("GIO HANG");

        jLabel16.setText(" HOA DON");

        jLabel17.setText("SAN PHAM");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MA", "TEN ", "GIA ", "SO LUONG"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        btn_suaGioHang.setText("SUA");
        btn_suaGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaGioHangActionPerformed(evt);
            }
        });

        btn_xoaGiaHang.setText("XOA");
        btn_xoaGiaHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaGiaHangActionPerformed(evt);
            }
        });

        tbl_gioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MA SP", "TEN SP", "SO LUONG", "GIA", "THANH TIEN"
            }
        ));
        jScrollPane2.setViewportView(tbl_gioHang);

        jLabel11.setText("MAHD");

        txt_maHoaDon.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 204));
        jLabel12.setText("VND");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 255));
        jLabel13.setText("VND");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 51, 204));
        jLabel18.setText("VND");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 51, 204));
        jLabel19.setText("VND");

        jLabel20.setText("THANH TIEN");

        lbl_thanhTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_thanhTien.setForeground(new java.awt.Color(51, 51, 255));
        lbl_thanhTien.setText("0");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 204));
        jLabel21.setText("VND");

        lbl_tenNhanVien.setText(".");

        btn_suaGioHang1.setText("+");
        btn_suaGioHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaGioHang1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_thanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbl_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19))
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13)))
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_tiemGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel18)
                                    .addGap(12, 12, 12))
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(18, 18, 18)
                                            .addComponent(lbl_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel12)
                                            .addGap(2, 2, 2))
                                        .addComponent(jLabel1)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel20)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbl_thanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(9, 9, 9)
                                            .addComponent(jLabel21)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbo_thanhToan, 0, 146, Short.MAX_VALUE))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbo_km, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addGap(66, 66, 66)
                                            .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(69, 69, 69)
                                            .addComponent(jLabel14))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addGap(46, 46, 46)
                                            .addComponent(btn_suaGioHang)
                                            .addGap(41, 41, 41)
                                            .addComponent(btn_xoaGiaHang))
                                        .addComponent(jLabel16))
                                    .addGap(20, 20, 20))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel11))
                                    .addGap(18, 18, 18)
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_maHoaDon)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                            .addComponent(txt_sdtKH)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btn_suaGioHang1))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addGap(18, 18, 18)
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_tenNhanVien)
                                        .addComponent(txt_tenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(btn_taoHoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel17)
                    .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(9, 9, 9)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(btn_suaGioHang)
                            .addComponent(btn_xoaGiaHang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_maHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_sdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_suaGioHang1))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lbl_tenNhanVien))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbo_km, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbo_thanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lbl_tiemGiam)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lbl_tongTien)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(lbl_thanhTien)
                            .addComponent(jLabel21))
                        .addGap(9, 9, 9)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(lbl_tienThua)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_thanhToan)
                        .addGap(18, 18, 18)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_huy)
                    .addComponent(btn_taoHoaDon))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_hoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hoaDonMouseClicked
        rowHd = tbl_hoaDon.getSelectedRow();
        this.showIdHoaDon(rowHd);
        this.fillTableGiohang();
    }//GEN-LAST:event_tbl_hoaDonMouseClicked

    private void txt_sdtKHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sdtKHKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_sdtKHKeyPressed

    private void txt_sdtKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sdtKHActionPerformed
        // TODO add your handling code here:
        String sdt = txt_sdtKH.getText().trim();
        if (sdt.isEmpty()) {
            txt_tenKH.setText("");

        }
        KhachHang kh = service.timKiemsdt(sdt);

        if (kh != null) {
            txt_tenKH.setText(kh.getTen());
        } else {
            JOptionPane.showMessageDialog(this, "Khong Tim Thay Khach Hang");
            txt_sdtKH.setText("");
        }
    }//GEN-LAST:event_txt_sdtKHActionPerformed

    private void txt_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timKiemActionPerformed
        // TODO add your handling code here:
        fillTableSanPhamTimKiem();
    }//GEN-LAST:event_txt_timKiemActionPerformed

    private void btn_taoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoHoaDonActionPerformed
        // TODO add your handling code here:
        HoaDon hd = readFormAddHoaDon();
        try {
            if (txt_sdtKH.getText().trim().isEmpty()) {
                if (service.addHd1(hd) != null) {
                    JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công");
                    fillTableHoaDon();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm hóa đơn thất bại");
                }
            } else {
                if (service.addHd(hd) != null) {
                    JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công");
                    fillTableHoaDon();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm hóa đơn thất bại");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }//GEN-LAST:event_btn_taoHoaDonActionPerformed

    private void cbo_thanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_thanhToanActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbo_thanhToanActionPerformed

    private void cbo_kmMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_kmMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_cbo_kmMouseEntered

    private void cbo_kmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_kmMouseClicked
        // TODO add your handling code here:
        rowHd = tbl_hoaDon.getSelectedRow();
        if (rowHd < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn trước");
            return;
        }

    }//GEN-LAST:event_cbo_kmMouseClicked

    private void cbo_kmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_kmActionPerformed
        // TODO add your handling code here:
        try {
            KhuyenMai km = (KhuyenMai) molKm.getSelectedItem();
            if (cbo_km.getSelectedIndex() == 0) {
                lbl_tiemGiam.setText(currencyFormat.format(km.getGiaTriGiam()));
                lbl_thanhTien.setText(lbl_tongTien.getText());
                return;
            }
            float tongTien = currencyFormat.parse(lbl_tongTien.getText()).floatValue();
            float giamGia = 0;
            if (tongTien >= km.getHoaDonToiThieu()) {
                giamGia = km.getGiaTriGiam();
            } else {
                JOptionPane.showMessageDialog(this, "Bạn không thể áp dụng được mã này ");
                cbo_km.setSelectedIndex(0);
            }

            lbl_tiemGiam.setText(currencyFormat.format(giamGia));
            lbl_thanhTien.setText(currencyFormat.format(tongTien - giamGia));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbo_kmActionPerformed

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
        // TODO add your handling code here:
        rowHd = tbl_hoaDon.getSelectedRow();
        if (rowHd < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn để hủy", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int chon = JOptionPane.showConfirmDialog(this, "Bạn Chắc Muốn Hủy Hóa Đơn Này Chứ", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (chon == JOptionPane.YES_OPTION) {
            int idHoaDon = Integer.parseInt(txt_maHoaDon.getText());
            //Lặp dữ liệu giỏ hàng để trả về sl về 
            for (BanHangGioHang x : service.getAllGioHang(idHoaDon)) {
                int soLuongTra = x.getSoLuong();
                int idSPCT = x.getId_sanPham();
                service.updateSLSanPhamVe(soLuongTra, idSPCT);
            }
            //Xóa giỏ hàng theo idhoaDOn rồi đến hóa đơn
            if (service.huyHd(idHoaDon) != null) {
                JOptionPane.showMessageDialog(this, "Hủy thành công");
                this.fillTableHoaDon();
                this.fillTableGiohang();
                this.fillTableSanPham();
                clear();
            } else {
                JOptionPane.showMessageDialog(this, "Hủy thất bại");
            }
        }

    }//GEN-LAST:event_btn_huyActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        rowGioHang = tbl_gioHang.getSelectedRow();
        rowSanPham = tblSanPham.getSelectedRow();
        rowHd = tbl_hoaDon.getSelectedRow();
        if (rowHd < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn để thêm sản phẩm", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String nhapSoLuong = JOptionPane.showInputDialog("Nhập số lượng");
        if (nhapSoLuong.contains("-") || nhapSoLuong.equals("0")) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Số Lớn Hơn 0", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!nhapSoLuong.isEmpty()) {
            try {
                int soLuong = Integer.parseInt(nhapSoLuong);
                BanHangSanPham sanPham = service.getAllSanPham().get(rowSanPham);
                int maSPCT = sanPham.getMa();
                int soLuongThuc = sanPham.getSoluong();
                if (soLuong > soLuongThuc) {
                    JOptionPane.showMessageDialog(this, "Số lượng mua lớn hơn số lượng còn lại của sản phẩm", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                service.updateSLSanPham(soLuong, maSPCT);
                BanHangHoaDonCho hd = service.getAllHoaDonCho().get(rowHd);
                int dem = 0;
                for (BanHangGioHang gh : service.getAllGioHang(hd.getId())) {
                    if (gh.getId_sanPham() == maSPCT) {
                        dem++;
                    }
                }
                if (dem == 0) {
                    service.addGiohang(hd.getId(), maSPCT, soLuong);
                } else {
                    service.UpdateGiohang_SoLuong(hd.getId(), maSPCT, soLuong);
                }
                fillTableGiohang();
                fillTableSanPham();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Số lượng phải là số", "Thông báo", JOptionPane.WARNING_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btn_xoaGiaHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaGiaHangActionPerformed
        // TODO add your handling code here:
        rowGioHang = tbl_gioHang.getSelectedRow();
        if (rowGioHang < 0) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn sản phẩm muốn xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int choice = JOptionPane.showConfirmDialog(this, "Bạn xác nhận xóa sản phẩm này chứ", "Xác nhận yêu cầu", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            BanHangGioHang giohang = service.getAllGioHang(Integer.parseInt(txt_maHoaDon.getText())).get(rowGioHang);
            int idHoaDonCT = giohang.getId();
            int soLuongGioHang = giohang.getSoLuong();
            int idSanPhamChiTiet = giohang.getId_sanPham();
            int idHoaDon = Integer.valueOf(txt_maHoaDon.getText());
            service.DeteLeGiohang(idHoaDon, idSanPhamChiTiet);
            service.updateSLSanPhamVe(soLuongGioHang, idSanPhamChiTiet);
            fillTableGiohang();
            fillTableSanPham();
        }
    }//GEN-LAST:event_btn_xoaGiaHangActionPerformed

    private void btn_suaGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaGioHangActionPerformed
        // TODO add your handling code here:
        rowGioHang = tbl_gioHang.getSelectedRow();
        if (rowGioHang < 0) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn sản phẩm muốn Sửa", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String nhapSoLuong = JOptionPane.showInputDialog("Nhập số lượng muốn sửa");
        if (nhapSoLuong.contains("-") || nhapSoLuong.equals("0")) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Số Lớn Hơn 0", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!nhapSoLuong.isEmpty()) {
            try {
                int soLuongSua = Integer.parseInt(nhapSoLuong);
                BanHangGioHang giohang = service.getAllGioHang(Integer.parseInt(txt_maHoaDon.getText())).get(rowGioHang);
                int idHoaDonCT = giohang.getId();
                int soLuongGioHang = giohang.getSoLuong();
                int idSanPhamChiTiet = giohang.getId_sanPham();
                int idHoaDon = Integer.parseInt(txt_maHoaDon.getText());
                BanHangSanPham sanpham = service.getAllSanPhamByid(idSanPhamChiTiet);
                int soLuongSanPham = sanpham.getSoluong();
                if (soLuongSua > soLuongSanPham) {
                    JOptionPane.showMessageDialog(this, "Số lượng mua lớn hơn số lượng còn lại của sản phẩm", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (soLuongSua > soLuongGioHang) {
                    int soLuongTang = soLuongSua - soLuongGioHang;
                    service.UpdateGiohang_SoLuong(idHoaDon, idSanPhamChiTiet, soLuongTang);
                    service.updateSLSanPham(soLuongTang, idSanPhamChiTiet);
                } else {
                    int soLuongGiam = soLuongGioHang - soLuongSua;
                    service.UpdateGiohang_SoLuongGiam(idHoaDon, idSanPhamChiTiet, soLuongGiam);
                    service.updateSLSanPhamVe(soLuongGiam, idSanPhamChiTiet);
                }
                this.fillTableGiohang();
                this.fillTableSanPham();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Số lượng phải là số", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }


    }//GEN-LAST:event_btn_suaGioHangActionPerformed

    private void txt_tienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaKeyReleased

//        int tienKhachDua = Integer.valueOf(txt_tienKhachDua.getText());
//        int tongTien = Integer.valueOf(lbl_tongTien.getText());
//        int tienGiam = Integer.valueOf(lbl_tiemGiam.getText());
//        int thanhTien = tongTien - tienGiam;
//        lbl_thanhTien.setText(currencyFormat.format(thanhTien));
//        float tienThua = tienKhachDua - thanhTien;
//        lbl_tienThua.setText(currencyFormat.format(tienThua));
//        fillTableHoaDon();
    }//GEN-LAST:event_txt_tienKhachDuaKeyReleased

    private void btn_thanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhToanActionPerformed
        try {
            if (check()) {
//                if (Integer.parseInt(txt_tienKhachDua.getText()) < Integer.parseInt(lbl_tienThua.getText())) {
//                    JOptionPane.showMessageDialog(this, "Khong du tien de thanh toan");
//                    return;
//                }
                int chon = JOptionPane.showConfirmDialog(null, "Bạn chắc muốn thanh toán chứ ?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (chon == JOptionPane.YES_OPTION) {
                    KhachHang kh = service.timKiemsdt(txt_sdtKH.getText());
                    KhuyenMai km = (KhuyenMai) molKm.getSelectedItem();
                    float tienGiam = currencyFormat.parse(lbl_tiemGiam.getText()).floatValue();
                    float tongTien = currencyFormat.parse(lbl_tongTien.getText()).floatValue();
                    float thanhTien = tongTien - tienGiam;
                    Integer idKh;
                    if (txt_sdtKH.getText().isEmpty()) {
                        idKh = 1;
                    } else {
                        idKh = kh.getMa();
                    }
                    Integer idKm = km.getId_CTKM_HoaDon();
                   
                    int vtHTTT = cbo_thanhToan.getSelectedIndex();

                    Boolean hinhThucThanhToan;
                    if (vtHTTT == 0) {
                        hinhThucThanhToan = false;
                    } else if (vtHTTT == 1) {
                        hinhThucThanhToan = true;
                    } else {
                        JOptionPane.showMessageDialog(this, "Bạn phải chọn hình thức thanh toán", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (thanhTien <= 0) {
                        JOptionPane.showMessageDialog(this, "Hóa Đơn Phải Có Giá Trị Lơn Hơn 1", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    inHoaDon();
                    int idHoaDon = Integer.parseInt(txt_maHoaDon.getText());
                    // ko dùng km ko có khách hàng
                    if (cbo_km.getSelectedIndex() == 0 && !txt_sdtKH.getText().trim().isEmpty()) {
                        if (service.updateHoaDonCoKhKoKm(hinhThucThanhToan, tongTien, tienGiam, thanhTien, idHoaDon, idKh) != null) {
                            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                            fillTableSanPham();
                            fillTableHoaDon();
                            fillTableGiohang();
                            clear();
                        } else {
                            JOptionPane.showConfirmDialog(this, "Thanh toán thất bại");
                        }
                    // có dùng km và ko có khách hàng
                    } else if (cbo_km.getSelectedIndex() > 0 && !txt_sdtKH.getText().trim().isEmpty()) {
                        if (service.updateHoaDonCoKhCoKM(idKm, hinhThucThanhToan, tongTien, tienGiam, thanhTien, idHoaDon, idKh) != null) {
                            service.updateKmSoLuong(idKm);
                            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                            fillTableSanPham();
                            fillTableHoaDon();
                            fillTableGiohang();
                            clear();
                        } else {
                            JOptionPane.showConfirmDialog(this, "Thanh toán thất bại");
                        }
                    // ko dùng km và có khách hàng
                    } else if (cbo_km.getSelectedIndex() == 0 && txt_sdtKH.getText().trim().isEmpty()) {
                        if (service.updateHoaDonKoKhKoKm(hinhThucThanhToan, tongTien, tienGiam, thanhTien, idHoaDon) != null) {

                            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                            fillTableSanPham();
                            fillTableHoaDon();
                            fillTableGiohang();
                            clear();
                        } else {
                            JOptionPane.showConfirmDialog(this, "Thanh toán thất bại");
                        }
                    // có dùng km và có khách hàng
                    } else if (cbo_km.getSelectedIndex() > 0 && txt_sdtKH.getText().trim().isEmpty()) {
                        if (service.updateHoaDonKoKhCoKM(idKm, hinhThucThanhToan, tongTien, tienGiam, thanhTien, idHoaDon) != null) {
                            service.updateKmSoLuong(idKm);
                            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                            fillTableSanPham();
                            fillTableHoaDon();
                            fillTableGiohang();
                            clear();
                        } else {
                            JOptionPane.showConfirmDialog(this, "Thanh toán thất bại");
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }//GEN-LAST:event_btn_thanhToanActionPerformed

    private void inHoaDon() {
        rowHd = tbl_hoaDon.getSelectedRow();
        Date currentDate = new Date();
        String maHoaDon = txt_maHoaDon.getText();
        BanHangHoaDonCho hoaDon = service.getAllHoaDonCho().get(rowHd);
        String ngayTao = dateFormat.format(hoaDon.getNgayTao());
        String ngayThanhToan = dateFormat.format(currentDate);
        ArrayList<BanHangGioHang> list = service.getAllGioHang(Integer.parseInt(maHoaDon));
        String dsSP[] = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            BanHangGioHang hdct = list.get(i);
            dsSP[i] = hdct.getTenSanPham() + "        SL: " + hdct.getSoLuong() + "      TT: " + currencyFormat.format(hdct.getThanhTien());
        }
        String tongTien = lbl_tongTien.getText();
        String giamGia = lbl_tiemGiam.getText();
        String thanhTien = lbl_thanhTien.getText();
        String sdtKhachHang;
        String khachHang;
        if (txt_tenKH.getText().isEmpty()) {
            khachHang = "Khách Vãng Lai";
        } else {
            khachHang = txt_tenKH.getText();
        }
        if (txt_sdtKH.getText().isEmpty()) {
            sdtKhachHang = "TRONG";
        } else {
            sdtKhachHang = txt_sdtKH.getText();
        }
        String httt = cbo_thanhToan.getSelectedItem().toString();

        // Tạo hóa đơn PDF
        String pdfFileName = "HoaDon_" + maHoaDon + ".pdf";
        taoHoaDonPDF(pdfFileName, maHoaDon, ngayTao, ngayThanhToan,
                dsSP, tongTien, giamGia, thanhTien, khachHang, sdtKhachHang, httt);

        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + pdfFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void taoHoaDonPDF(String fileName, String maHoaDon, String ngayTao, String ngayThanhToan,
            String dsSP[], String tongTien, String giamGia, String thanhTien, String khachHang,
            String sdtKhachHang, String httt) {
        Document document = new Document();
        document.addLanguage(document.toString());
        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName));

            document.open();
            Paragraph title = new Paragraph("====================HOA DON THANH TOAN====================");
            Paragraph light = new Paragraph("--------------------------------------------------------------------------------------------------");
            Paragraph Ngaytao = new Paragraph("NGAY TAO:              " + ngayTao);
            Paragraph NgayThanhToan = new Paragraph("NGAY THANH TOAN: " + ngayThanhToan);
            Paragraph light1 = new Paragraph("-------------------------------------------------------------------------------------------------");
            Paragraph MaHoaDon = new Paragraph("MA HOA DON:           " + maHoaDon);
            Paragraph Khachhang = new Paragraph("KHACH HANG:          " + khachHang);
            Paragraph SDTKhachHang = new Paragraph("SDT KHACH HANG:   " + sdtKhachHang);
            Paragraph HTTT = new Paragraph("HINH THUC THANH TOAN:   " + httt);
            Paragraph light3 = new Paragraph("-------------------------------------------------------------------------------------------------");
            Paragraph TitleSanPham = new Paragraph("SAN PHAM DA MUA");
            String TenSanPham = "";
            for (int i = 0; i < dsSP.length; i++) {
                TenSanPham = TenSanPham + dsSP[i] + "\n";
            }
            Paragraph SanPham = new Paragraph("SAN PHAM BAO GOM: \n" + TenSanPham);
            Paragraph tongTien3 = new Paragraph("TONG TIEN:   " + tongTien + "VND");
            Paragraph giamgia = new Paragraph("GIAM GIA:      " + giamGia + "VND");
            Paragraph ThanhTien = new Paragraph("THANH TOAN:  " + thanhTien + "VND");
            document.add(title);
            document.add(light);
            document.add(Ngaytao);
            document.add(NgayThanhToan);
            document.add(light1);
            document.add(MaHoaDon);
            document.add(Khachhang);
            document.add(SDTKhachHang);
            document.add(HTTT);
            document.add(light1);
            document.add(TitleSanPham);
            document.add(SanPham);
            document.add(light3);
            document.add(tongTien3);
            document.add(giamgia);
            document.add(ThanhTien);
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void txt_tienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaActionPerformed
        // TODO add your handling code here:
        String tienKhachDuaStr = txt_tienKhachDua.getText();
        float thanhTien;
        float tienKhachDua;
        try {
            tienKhachDua = Float.parseFloat(tienKhachDuaStr);
            thanhTien = currencyFormat.parse(lbl_thanhTien.getText()).floatValue();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tiền Khách Đưa Phải Là Số", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tienKhachDua < thanhTien) {
            JOptionPane.showMessageDialog(this, "Tiền Khách Đưa Phải Lớn Hơn Thành Tiền", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        lbl_tienThua.setText(currencyFormat.format(tienKhachDua - thanhTien));
    }//GEN-LAST:event_txt_tienKhachDuaActionPerformed

    private void txt_tienKhachDuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tienKhachDuaKeyPressed

    private void btn_suaGioHang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaGioHang1ActionPerformed
        // TODO add your handling code here:
        new FormThemSDTKH().setVisible(true);
    }//GEN-LAST:event_btn_suaGioHang1ActionPerformed

//    public void setComBoNV() {
//        cbo_NV.setModel((DefaultComboBoxModel) molNv);
//        for (NhanVien x : service.getAllNV()) {
//            molNv.addElement(x);
//        }
//    }
    public void setComBoKM() {
        KhuyenMai km1 = new KhuyenMai();
        km1.setTenCTKM("Không dùng");
        cbo_km.setModel((DefaultComboBoxModel) molKm);
        molKm.addElement(km1);
        for (KhuyenMai x : service.getAllKM()) {
            molKm.addElement(x);
        }
    }

    public void fillTableSanPham() {
        molTableSp = (DefaultTableModel) tblSanPham.getModel();
        molTableSp.setRowCount(0);
        for (BanHangSanPham kh : service.getAllSanPham()) {
            String gia = currencyFormat.format(kh.getGia());
            molTableSp.addRow(new Object[]{kh.getMa(), kh.getTen(), gia, kh.getSoluong()});
        }
    }

    public void fillTableSanPhamTimKiem() {
        molTableSp = (DefaultTableModel) tblSanPham.getModel();
        molTableSp.setRowCount(0);
        for (BanHangSanPham kh : service.getAllTimKiemSanPham(txt_timKiem.getText())) {
            molTableSp.addRow(new Object[]{kh.getMa(), kh.getTen(), kh.getGia(), kh.getSoluong()});
        }
    }

    public void fillTableHoaDon() {
        molHoaDon = (DefaultTableModel) tbl_hoaDon.getModel();
        molHoaDon.setRowCount(0);
        for (BanHangHoaDonCho kh : service.getAllHoaDonCho()) {
            molHoaDon.addRow(new Object[]{kh.getId(), kh.getTenNhanVien(), kh.getTenKhachHang() == null ? "Khách vãng lai" : kh.getTenKhachHang(), kh.getNgayTao(), kh.isTrangThai() == true ? "Da Thanh Toan" : "Cho Thanh Toan"});
        }
    }

    public HoaDon readFormAddHoaDon() {
        HoaDon hd = new HoaDon();
        KhachHang kh = service.timKiemsdt(txt_sdtKH.getText());
        NhanVien nv = Auth.user;
        hd.setId_NhanVien(nv.getId());
        if (!txt_sdtKH.getText().isEmpty()) {
            hd.setId_KhachHang(kh.getMa());
        }
        return hd;
    }

    private void showIdHoaDon(int index) {
        BanHangHoaDonCho hd = service.getAllHoaDonCho().get(index);
        txt_maHoaDon.setText(String.valueOf(hd.getId()));
    }

    private void fillTableGiohang() {
        molTableGioHang = (DefaultTableModel) tbl_gioHang.getModel();
        molTableGioHang.setRowCount(0);
        int i = 1;
        float tongTien = 0;
        ArrayList<BanHangGioHang> list = service.getAllGioHang(Integer.parseInt(txt_maHoaDon.getText()));
        for (BanHangGioHang x : list) {
            String giaBan = currencyFormat.format(x.getGiaBan());
            String thanhTien = currencyFormat.format(x.getGiaBan() * x.getSoLuong());
            molTableGioHang.addRow(new Object[]{x.getId_sanPham(), x.getTenSanPham(), x.getSoLuong(), giaBan, thanhTien});
            tongTien = tongTien + x.getThanhTien();
        }

        lbl_tongTien.setText((currencyFormat.format(tongTien)));
        lbl_tiemGiam.setText("0");
        float tienGiam = 0;
        float thanhTien = tongTien - tienGiam;
        lbl_thanhTien.setText(currencyFormat.format(thanhTien));
    }

    public boolean check() {
        if (txt_maHoaDon.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần thanh toán ");
            return false;
        }

        if (txt_tienKhachDua.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tiền khách đưa để thanh toán", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    public void clear() {
        txt_maHoaDon.setText("");
        txt_sdtKH.setText("");
        txt_tenKH.setText("");
        txt_tienKhachDua.setText("");
        lbl_tiemGiam.setText("0");
        lbl_tienThua.setText("0");
        lbl_tongTien.setText("0");
        lbl_thanhTien.setText("0");

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_suaGioHang;
    private javax.swing.JButton btn_suaGioHang1;
    private javax.swing.JButton btn_taoHoaDon;
    private javax.swing.JButton btn_thanhToan;
    private javax.swing.JButton btn_xoaGiaHang;
    private javax.swing.JComboBox<String> cbo_km;
    private javax.swing.JComboBox<String> cbo_thanhToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_tenNhanVien;
    private javax.swing.JLabel lbl_thanhTien;
    private javax.swing.JLabel lbl_tiemGiam;
    private javax.swing.JLabel lbl_tienThua;
    private javax.swing.JLabel lbl_tongTien;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tbl_gioHang;
    private javax.swing.JTable tbl_hoaDon;
    private javax.swing.JTextField txt_maHoaDon;
    private javax.swing.JTextField txt_sdtKH;
    private javax.swing.JTextField txt_tenKH;
    private javax.swing.JTextField txt_tienKhachDua;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables
}
