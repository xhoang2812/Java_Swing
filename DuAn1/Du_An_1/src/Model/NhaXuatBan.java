/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author NgocKhai
 */
public class NhaXuatBan {
    private int manxb;
    private  String tennxb;
    private Date ngayTao;
    private Date ngaySua;
    private boolean trangThai;

    public NhaXuatBan() {
    }

    public NhaXuatBan(int manxb, String tennxb, boolean trangThai) {
        this.manxb = manxb;
        this.tennxb = tennxb;
        this.trangThai = trangThai;
    }

    public NhaXuatBan(String tennxb, boolean trangThai) {
        this.tennxb = tennxb;
        this.trangThai = trangThai;
    }

    
    public NhaXuatBan(int manxb, String tennxb, Date ngayTao, Date ngaySua, boolean trangThai) {
        this.manxb = manxb;
        this.tennxb = tennxb;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
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
    

    
    public NhaXuatBan( String tennxb) {
       
        this.tennxb = tennxb;
    }

    public int getManxb() {
        return manxb;
    }

    public void setManxb(int manxb) {
        this.manxb = manxb;
    }

    public String getTennxb() {
        return tennxb;
    }

    public void setTennxb(String tennxb) {
        this.tennxb = tennxb;
    }

    @Override
    public String toString(){
        return tennxb;
    }
}
