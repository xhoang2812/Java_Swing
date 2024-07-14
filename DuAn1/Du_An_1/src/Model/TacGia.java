package Model;

public class TacGia {

    private int ma;
    private String tenTG;
    private String ngayTao;
    private String ngaySua;
    private Boolean trangThai;

    public TacGia() {
    }

    public TacGia(int ma, String tenTG, String ngayTao, String ngaySua, Boolean trangThai) {
        this.ma = ma;
        this.tenTG = tenTG;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public TacGia(String tenTG, String ngayTao, String ngaySua, Boolean trangThai) {
        this.tenTG = tenTG;
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

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
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
        return tenTG;
    }
    

}
