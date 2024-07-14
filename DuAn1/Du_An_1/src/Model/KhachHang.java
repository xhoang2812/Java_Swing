/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author tranh
 */
public class KhachHang {

    private int ma; 
    private String ten;
    private int gioiTinh;
    private String sdt;
    private String them, sua;
    private int trangThai;

    public KhachHang() {
    }

    public KhachHang(int ma, String ten, int gioiTinh, String sdt, String them, String sua, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.them = them;
        this.sua = sua;
        this.trangThai = trangThai;
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

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

  

    public String getThem() {
        return them;
    }

    public void setThem(String them) {
        this.them = them;
    }

    public String getSua() {
        return sua;
    }

    public void setSua(String sua) {
        this.sua = sua;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "ma=" + ma + ", ten=" + ten + ", gioiTinh=" + gioiTinh + ", sdt=" + sdt +", them=" + them + ", sua=" + sua + ", trangThai=" + trangThai + '}';
    }

   

}
