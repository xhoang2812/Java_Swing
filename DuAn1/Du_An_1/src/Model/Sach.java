package Model;

public class Sach {

    private int ma;
    private String tenSach;
    private String ngayTao;
    private String ngaySua;

    public Sach() {
    }

    public Sach(int ma, String tenSach, String ngayTao, String ngaySua) {
        this.ma = ma;
        this.tenSach = tenSach;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public Sach(String tenSach, String ngayTao) {
        this.tenSach = tenSach;
        this.ngayTao = ngayTao;
       
    }

    public Sach(int ma, String tenSach, String ngaySua) {
        this.ma = ma;
        this.tenSach = tenSach;
        this.ngaySua = ngaySua;
    }
    

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(String ngaySua) {
        this.ngaySua = ngaySua;
    }

}
