package Model;

public class NhaCungCap {

    private int ma;
    private String tenNCC;
    private String ngayTao;
    private String ngaySua;
    private Boolean trangThai;

    public NhaCungCap() {
    }

    public NhaCungCap(int ma, String tenNCC, String ngayTao, String ngaySua, Boolean trangThai) {
        this.ma = ma;
        this.tenNCC = tenNCC;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public NhaCungCap(String tenNCC, String ngayTao, String ngaySua, Boolean trangThai) {
        this.tenNCC = tenNCC;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
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

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return tenNCC;
    }

}
