/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.time.DateTimeException;
import java.time.LocalDateTime;

/**
 *
 * @author Admin
 */
public class NhanVien {

    private int id;
    private String userName;
    private String passWord;
    private String tenNhanVien;
    private boolean gioiTinh;
    private String email;
    private String sdt;
    private Date ngayTao;
    private Date ngaySua;
    private boolean trangThai;
    private boolean vaiTro;

    public NhanVien() {
    }

    public NhanVien(int id, String userName, String passWord, String tenNhanVien, boolean gioiTinh, String email, String sdt, Date ngayTao, Date ngaySua, boolean trangThai, boolean vaiTro) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.tenNhanVien = tenNhanVien;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.sdt = sdt;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
        this.vaiTro = vaiTro;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    public Object[] toDataRow() {
        return new Object[]{this.getId(), this.getTenNhanVien(),
            this.isGioiTinh() == true ? "Nam" : "Nu", this.getEmail(),
            this.getSdt(), this.getNgayTao(), this.getNgaySua(), this.getUserName(),
            this.getPassWord(), this.isTrangThai() == true ? "Dang lam" : "Da nghi",
            this.isVaiTro() == true ? "Quan Ly" : "Nhan Vien"};
    }

    @Override
    public String toString() {
        return  tenNhanVien ;
    }
    
}
