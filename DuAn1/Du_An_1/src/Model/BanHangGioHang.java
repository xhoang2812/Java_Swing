/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class BanHangGioHang {
    
    private int id;
    private int id_sanPham;
    private int id_hoaDon;
    private String tenSanPham;
    private float giaBan;
    private int soLuong;
    private String ghiChu;
    private Float thanhTien;

    public BanHangGioHang() {
    }

    public BanHangGioHang( int id_hoaDon, String tenSanPham, float giaBan, int soLuong, Float thanhTien) {
        this.id = id;
        this.id_sanPham = id_sanPham;
        this.id_hoaDon = id_hoaDon;
        this.tenSanPham = tenSanPham;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
        this.thanhTien = thanhTien;
    }

    public BanHangGioHang(int aInt, int aInt0, int aInt1, double aDouble, Date date, boolean aBoolean) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Float thanhTien) {
        this.thanhTien = thanhTien;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public int getId_sanPham() {
        return id_sanPham;
    }

    public void setId_sanPham(int id_sanPham) {
        this.id_sanPham = id_sanPham;
    }

    public int getId_hoaDon() {
        return id_hoaDon;
    }

    public void setId_hoaDon(int id_hoaDon) {
        this.id_hoaDon = id_hoaDon;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
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

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    public Object[] toDataRow(){
        return new Object[]{
            this.id_sanPham, this.tenSanPham, this.soLuong, this.giaBan, this.soLuong * this.giaBan
        };
    }
 public int ThanhTien(int giaban, int sL) {
        return giaban * sL;
    }
}
