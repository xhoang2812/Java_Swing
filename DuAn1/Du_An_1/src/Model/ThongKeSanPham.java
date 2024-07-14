package Model;

public class ThongKeSanPham {

    private String tenSP;
    private int soLuong;
    private float tongTien;
    private int tongDon;

    public ThongKeSanPham() {
    }

    public ThongKeSanPham(String tenSP, int soLuong, float tongTien, int tongDon) {
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.tongDon = tongDon;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public int getTongDon() {
        return tongDon;
    }

    public void setTongDon(int tongDon) {
        this.tongDon = tongDon;
    }

}
