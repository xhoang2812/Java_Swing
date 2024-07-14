/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class BanHangSanPham {
    private int ma;
    public String ten ; 
    public Float gia ; 
    public int soluong ;

    public BanHangSanPham() {
    }

    public BanHangSanPham(int ma, String ten, Float gia, int soluong) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.soluong = soluong;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Float getGia() {
        return gia;
    }

    public void setGia(Float gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
}
