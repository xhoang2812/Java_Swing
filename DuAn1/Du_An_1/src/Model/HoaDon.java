/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDon {

    private int id_hoaDon;
    private int id_KhachHang;
    private int id_NhanVien;
    private int id_CTKM_HoaDon;
    private boolean phuongThucThanhToan;
    private float tienHang;
    private float chietKhau;
    private float tongTien;
    private Date ngayTao;
    private Date ngaySua;
    private boolean trangThai;

    public HoaDon() {
    }

    public HoaDon(int id_hoaDon, int id_KhachHang, int id_NhanVien, int id_CTKM_HoaDon, boolean phuongThucThanhToan, float tienHang, float chietKhau, float tongTien, Date ngayTao, Date ngaySua, boolean trangThai) {
        this.id_hoaDon = id_hoaDon;
        this.id_KhachHang = id_KhachHang;
        this.id_NhanVien = id_NhanVien;
        this.id_CTKM_HoaDon = id_CTKM_HoaDon;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.tienHang = tienHang;
        this.chietKhau = chietKhau;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public int getId_hoaDon() {
        return id_hoaDon;
    }

    public void setId_hoaDon(int id_hoaDon) {
        this.id_hoaDon = id_hoaDon;
    }

    public int getId_KhachHang() {
        return id_KhachHang;
    }

    public void setId_KhachHang(int id_KhachHang) {
        this.id_KhachHang = id_KhachHang;
    }

    public int getId_NhanVien() {
        return id_NhanVien;
    }

    public void setId_NhanVien(int id_NhanVien) {
        this.id_NhanVien = id_NhanVien;
    }

    public int getId_CTKM_HoaDon() {
        return id_CTKM_HoaDon;
    }

    public void setId_CTKM_HoaDon(int id_CTKM_HoaDon) {
        this.id_CTKM_HoaDon = id_CTKM_HoaDon;
    }

    public boolean isPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(boolean phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public float getTienHang() {
        return tienHang;
    }

    public void setTienHang(float tienHang) {
        this.tienHang = tienHang;
    }

    public float getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(float chietKhau) {
        this.chietKhau = chietKhau;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
