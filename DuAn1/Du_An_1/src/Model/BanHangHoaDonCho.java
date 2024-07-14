/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author ADmin
 */
public class BanHangHoaDonCho {
    private int id;
    private String tenNhanVien, tenKhachHang, tenKhuyenMai;
    private Date ngayBan;
    private boolean trangThai;

    public BanHangHoaDonCho() {
    }

    public BanHangHoaDonCho(int id, String tenNhanVien, Date ngayBan) {
        this.id = id;
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
        this.tenKhuyenMai = tenKhuyenMai;
        this.ngayBan = ngayBan;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public Date getNgayTao() {
        return ngayBan;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayBan = ngayTao;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

   
    
    


   
    
}
