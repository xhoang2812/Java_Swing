/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Admin
 */
public class SanPhamChiTietViewModel {
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("Vi", "VN"));
    private int id_SanPhamChiTiet ;
    private String ten_NXB ;
    private String ten_TacGia ;
    private String ten_NhaCungCap ;
    private int  id_SanPham ;
    private String ten_SanPham ;
    private String theLoai;
    private float giaBan ;
    private int  soLuong ;
    private Date ngayTao ;
    private Date ngaySua;
    private boolean trangThai ;

    public SanPhamChiTietViewModel() {
    }

    public SanPhamChiTietViewModel(int id_SanPhamChiTiet, String ten_NXB, String ten_TacGia, String ten_NhaCungCap, int id_SanPham, String ten_SanPham, float giaBan, int soLuong, Date ngayTao, Date ngaySua, boolean trangThai) {
        this.id_SanPhamChiTiet = id_SanPhamChiTiet;
        this.ten_NXB = ten_NXB;
        this.ten_TacGia = ten_TacGia;
        this.ten_NhaCungCap = ten_NhaCungCap;
        this.id_SanPham = id_SanPham;
        this.ten_SanPham = ten_SanPham;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    
    public int getId_SanPhamChiTiet() {
        return id_SanPhamChiTiet;
    }

    public void setId_SanPhamChiTiet(int id_SanPhamChiTiet) {
        this.id_SanPhamChiTiet = id_SanPhamChiTiet;
    }

    public String getTen_NXB() {
        return ten_NXB;
    }

    public void setTen_NXB(String ten_NXB) {
        this.ten_NXB = ten_NXB;
    }

    public String getTen_TacGia() {
        return ten_TacGia;
    }

    public void setTen_TacGia(String ten_TacGia) {
        this.ten_TacGia = ten_TacGia;
    }

    public String getTen_NhaCungCap() {
        return ten_NhaCungCap;
    }

    public void setTen_NhaCungCap(String ten_NhaCungCap) {
        this.ten_NhaCungCap = ten_NhaCungCap;
    }

    public int getId_SanPham() {
        return id_SanPham;
    }

    public void setId_SanPham(int id_SanPham) {
        this.id_SanPham = id_SanPham;
    }

    public String getTen_SanPham() {
        return ten_SanPham;
    }

    public void setTen_SanPham(String ten_SanPham) {
        this.ten_SanPham = ten_SanPham;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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
     public Object[] toDataRow(){
        return new Object[]
        {
            this.id_SanPhamChiTiet ,this.ten_SanPham ,this.ten_NXB,
            this.ten_NhaCungCap,this.ten_TacGia,this.theLoai,
            currencyFormat.format(giaBan), 
            this.soLuong,this.ngayTao,this.ngaySua,
            this.trangThai == true ? "DANG BAN" : "NGUNG BAN"
        };
    }
    
    
}
