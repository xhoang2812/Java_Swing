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
public class TheLoai {
    private int id_theLoai;
    private String tenTheLoai;
    private Date ngayTao;
    private Date ngaySua;
    

    public TheLoai() {
    }

    public TheLoai(int id_theLoai, String tenTheLoai, Date ngayTao, Date ngaySua, boolean trangThai) {
        this.id_theLoai = id_theLoai;
        this.tenTheLoai = tenTheLoai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        
    }

    public int getId_theLoai() {
        return id_theLoai;
    }

    public void setId_theLoai(int id_theLoai) {
        this.id_theLoai = id_theLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
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

    @Override
    public String toString() {
        return  tenTheLoai;
    }
    
    
}
