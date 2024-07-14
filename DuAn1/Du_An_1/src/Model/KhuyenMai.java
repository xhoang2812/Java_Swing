/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class KhuyenMai {

    private int id_CTKM_HoaDon;
    private String tenCTKM;
    private int giaTriGiam;
    private int soLuong;
    private Date  ngayBatDau, ngayKetThuc;
    private Boolean trangThai;
    private Float hoaDonToiThieu;

    public KhuyenMai() {
    }

    public KhuyenMai(int id_CTKM_HoaDon, String tenCTKM, int giaTriGiam, int soLuong, Date ngayBatDau, Date ngayKetThuc, Boolean trangThai, Float hoaDonToiThieu) {
        this.id_CTKM_HoaDon = id_CTKM_HoaDon;
        this.tenCTKM = tenCTKM;
        this.giaTriGiam = giaTriGiam;
        this.soLuong = soLuong;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
        this.hoaDonToiThieu = hoaDonToiThieu;
    }

   

    public Float getHoaDonToiThieu() {
        return hoaDonToiThieu;
    }

    public void setHoaDonToiThieu(Float hoaDonToiThieu) {
        this.hoaDonToiThieu = hoaDonToiThieu;
    }

    
    public int getId_CTKM_HoaDon() {
        return id_CTKM_HoaDon;
    }

    public void setId_CTKM_HoaDon(int id_CTKM_HoaDon) {
        this.id_CTKM_HoaDon = id_CTKM_HoaDon;
    }

    public String getTenCTKM() {
        return tenCTKM;
    }

    public void setTenCTKM(String tenCTKM) {
        this.tenCTKM = tenCTKM;
    }

    public int getGiaTriGiam() {
        return giaTriGiam;
    }

    public void setGiaTriGiam(int giaTriGiam) {
        this.giaTriGiam = giaTriGiam;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
    

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }


    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return  tenCTKM ;
    }
    

   
}

//    @Override
//    public String toString() {
//        return "KhuyenMai{" + "id_CTKM_HoaDon=" + id_CTKM_HoaDon + ", tenCTKM=" + tenCTKM + ", giaTriGiam=" + giaTriGiam + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", trangThai=" + trangThai + '}';
//    }
