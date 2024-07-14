/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceBanHang;

import Model.BanHangGioHang;
import Model.BanHangSanPham;
import Model.KhachHang;
import Repository.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Model.BanHangHoaDonCho;
import Model.HoaDon;
import Model.KhuyenMai;
import Model.NhanVien;
import Model.Sach;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class QLBanHang {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<BanHangSanPham> getAllSanPham() {
        ArrayList<BanHangSanPham> dskh = new ArrayList<>();
        String sql = "select SanPhamChiTiet.id_SanPhamChiTiet, sanPham.tenSanPham, giaBan, soLuong \n"
                + "from SanPhamChiTiet join sanPham on sanPham.id_SanPham = SanPhamChiTiet.id_SanPham "
                + "where SanPhamChiTiet.soLuong > 0 and SanPhamChiTiet.trangThai like 1";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dskh.add(new BanHangSanPham(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4)));
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("get all san pham");
        }
        return dskh;
    }

    public BanHangSanPham getAllSanPhamByid(int id_spct) {

        String sql = "select SanPhamChiTiet.id_SanPhamChiTiet, sanPham.tenSanPham, giaBan, soLuong \n"
                + "from SanPhamChiTiet join sanPham on sanPham.id_SanPham = SanPhamChiTiet.id_SanPham "
                + "where SanPhamChiTiet.id_SanPhamChiTiet like ? and SanPhamChiTiet.soLuong > 0 and SanPhamChiTiet.trangThai like 1";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id_spct);
            rs = ps.executeQuery();
            while (rs.next()) {
                BanHangSanPham sp = new BanHangSanPham(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4));
                return sp;
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("get all san pham");
        }
        return null;
    }

    public List<NhanVien> getAllNV() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            String getAll = "select * from nhanVien";
            Connection cn = Connect.getConnectDAO();
            PreparedStatement ps = cn.prepareStatement(getAll);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setId(rs.getInt("id_nhanVien"));
                nv.setUserName(rs.getString("userName"));
                nv.setPassWord(rs.getString("password"));
                nv.setTenNhanVien(rs.getString("tenNhanVien"));
                nv.setGioiTinh(rs.getBoolean("gioiTinh"));
                nv.setEmail(rs.getString("email"));
                nv.setSdt(rs.getString("sdt"));
                nv.setNgayTao(rs.getDate("ngayTao"));
                nv.setNgaySua(rs.getDate("ngaySua"));
                nv.setTrangThai(rs.getBoolean("trangThai"));
                nv.setVaiTro(rs.getBoolean("vaiTro"));
                list.add(nv);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi get all nhan vien");
        }
        return list;
    }

    public ArrayList<KhuyenMai> getAllKM() {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        String sql = "select * from CTKM_HoaDon where trangThai like 1 and soLuong > 0";
        Connection conn = Connect.getConnectDAO();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setId_CTKM_HoaDon(rs.getInt("id_CTKM_HoaDon"));
                km.setTenCTKM(rs.getString("tenCTKM"));
                km.setGiaTriGiam(rs.getInt("giaTriGiam"));
                km.setNgayBatDau(rs.getDate("ngayBatDau"));
                km.setNgayKetThuc(rs.getDate("ngayKetThuc"));
                km.setSoLuong(rs.getInt("soLuong"));
                km.setTrangThai(rs.getBoolean("trangThai"));
                km.setHoaDonToiThieu(rs.getFloat("hoaDonToiThieu"));
                list.add(km);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Loi get all khuyen mai");
        }
        return list;
    }

    public KhachHang timKiemsdt(String SDT) {
        String sql = "select * from khachHang where sdt like ?";

        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setString(1, SDT);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMa(rs.getInt(1));
                kh.setTen(rs.getString(2));
                kh.setGioiTinh(rs.getInt(3));
                kh.setSdt(rs.getString(4));
                kh.setThem(rs.getString(5));
                kh.setSua(rs.getString(6));
                kh.setTrangThai(rs.getInt(7));
                return kh;
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi tim kiem khach hang");
        }
        return null;
    }

    public ArrayList<BanHangSanPham> getAllTimKiemSanPham(String ten) {
        ArrayList<BanHangSanPham> dssp = new ArrayList<>();
        String sql = "select SanPhamChiTiet.id_SanPhamChiTiet, sanPham.tenSanPham, giaBan, soLuong \n"
                + "from SanPhamChiTiet join sanPham on sanPham.id_SanPham = SanPhamChiTiet.id_SanPham \n"
                + "where tenSanPham like ?  and trangThai like 1 ";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                dssp.add(new BanHangSanPham(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4)));
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("loi tim kiem sp");
        }
        return dssp;
    }

    public Integer updateSLSanPham(int soLuong, int idSanPhamChiTiet) {
        Integer row = null;
        try {
            String sql = "update SanPhamChiTiet\n"
                    + "set soLuong = soLuong - ? \n"
                    + "where id_SanPhamChiTiet like ?";
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, soLuong);
            ps.setInt(2, idSanPhamChiTiet);
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi update so luong di san pham");
        }
        return row;
    }

    public Integer updateSLSanPhamVe(int soLuong, int idSanPhamChiTiet) {
        Integer row = null;
        try {
            String sql = "update SanPhamChiTiet\n"
                    + "set soLuong = soLuong + ? \n"
                    + "where id_SanPhamChiTiet like ?";
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, soLuong);
            ps.setInt(2, idSanPhamChiTiet);
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);

            System.out.println("Loi update so luong ve sp");
        }
        return row;
    }

//    ------------------------------------------------------------------------ Hoa Don------------------------------------------
    public ArrayList<BanHangHoaDonCho> getAllHoaDonCho() {
        ArrayList<BanHangHoaDonCho> list = new ArrayList<>();
        String sql = "select id_hoaDon, nhanVien.tenNhanVien, khachHang.tenKhachHang,hoaDon.ngayTao, hoaDon.trangThai\n"
                + "from nhanVien join hoaDon on nhanVien.id_NhanVien = hoaDon.id_NhanVien\n"
                + "full outer join khachHang on khachHang.id_KhachHang = hoaDon.id_KhachHang\n"
                + "where hoaDon.trangThai like 0";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                BanHangHoaDonCho b = new BanHangHoaDonCho();
                b.setId(rs.getInt(1));
                b.setTenNhanVien(rs.getString(2));
                b.setTenKhachHang(rs.getString(3));
                b.setNgayTao(rs.getDate(4));
                b.setTrangThai(rs.getBoolean(5));
                list.add(b);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi getall hoa don");
        }
        return list;
    }

    public Integer addHd(HoaDon hd) {
        Integer row = null;
        String sql = "insert into hoaDon(id_NhanVien, id_KhachHang, ngayTao, trangThai)\n"
                + "				values(?,?,?,?)"; // Sử dụng DEFAULT VALUES để thêm dữ liệu tự động
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, hd.getId_NhanVien());
            ps.setInt(2, hd.getId_KhachHang());
            ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            ps.setBoolean(4, false);
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi add  hoa don");
        }
        return row;
    }
    public Integer addHd1(HoaDon hd) {
        Integer row = null;
        String sql = "insert into hoaDon(id_NhanVien, ngayTao, trangThai)\n"
                + "				values(?,?,?)"; // Sử dụng DEFAULT VALUES để thêm dữ liệu tự động
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, hd.getId_NhanVien());
            ps.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
            ps.setBoolean(3, false);
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi add  hoa don1");
        }
        return row;
    }

    public Integer huyHd(int id) {
        Integer row = null;
        String sql = "delete hoaDonChiTiet\n"
                + "where id_HoaDon like ?\n"
                + "delete hoaDon\n"
                + "where id_hoaDon like ?";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi huy  hoa don");
        }
        return row;
    }

    public ArrayList<BanHangHoaDonCho> getAllDaoHoaDon() {
        ArrayList<BanHangHoaDonCho> dshd = new ArrayList<>();
        String sql = "select id_HoaDon, tenNhanVien, ngayBan from HoaDon join NhanVien on HoaDon.maNhanVien = NhanVien.maNhanVien where trangThai = 'Cho thanh toan'";

        try {
            Connection conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dshd.add(new BanHangHoaDonCho(rs.getInt(1), rs.getString(2), rs.getDate(3)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return dshd;
    }

    public Integer updateHoaDonCoKhCoKM(int idKM, boolean phuongThucTT, float tienHang, float giamGia, float tongTien, int idHoaDon, int idKhachHang) {
        Integer row = null;
        String sql = "update hoaDon\n"
                + "set phuongThucThanhToan = ?,tienHang=?, chietKhau = ?, tongTien = ?, ngaySua = GETDATE(),id_CTKM_HoaDon = ?,id_khachHang = ?, trangThai =1\n"
                + "where id_hoaDon like ?";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, phuongThucTT);
            ps.setFloat(2, tienHang);
            ps.setFloat(3, giamGia);
            ps.setFloat(4, tongTien);
            ps.setInt(7, idHoaDon);
            ps.setInt(5, idKM);
            ps.setInt(6, idKhachHang);
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi update  hoa don");
        }
        return row;
    }
    
    
    public Integer updateHoaDonCoKhKoKm( boolean phuongThucTT, float tienHang, float giamGia, float tongTien, int idHoaDon, int idKhachHang) {
        Integer row = null;
        String sql = "update hoaDon\n"
                + "set phuongThucThanhToan = ?,tienHang=?, chietKhau = ?, tongTien = ?, ngaySua = GETDATE(),id_khachHang = ?, trangThai =1\n"
                + "where id_hoaDon like ?";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, phuongThucTT);
            ps.setFloat(2, tienHang);
            ps.setFloat(3, giamGia);
            ps.setFloat(4, tongTien);
            ps.setInt(6, idHoaDon);
            ps.setInt(5, idKhachHang);
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi update  hoa don");
        }
        return row;
    }
    
     public Integer updateHoaDonKoKhKoKm( boolean phuongThucTT, float tienHang, float giamGia, float tongTien, int idHoaDon) {
        Integer row = null;
        String sql = "update hoaDon\n"
                + "set phuongThucThanhToan = ?,tienHang=?, chietKhau = ?, tongTien = ?, ngaySua = GETDATE(), trangThai =1\n"
                + "where id_hoaDon like ?";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, phuongThucTT);
            ps.setFloat(2, tienHang);
            ps.setFloat(3, giamGia);
            ps.setFloat(4, tongTien);
            ps.setInt(5, idHoaDon);
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi update  hoa don");
        }
        return row;
    }
     
     public Integer updateHoaDonKoKhCoKM(int idKM, boolean phuongThucTT, float tienHang, float giamGia, float tongTien, int idHoaDon) {
        Integer row = null;
        String sql = "update hoaDon\n"
                + "set phuongThucThanhToan = ?,tienHang=?, chietKhau = ?, tongTien = ?, ngaySua = GETDATE(),id_CTKM_HoaDon = ?, trangThai =1\n"
                + "where id_hoaDon like ?";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, phuongThucTT);
            ps.setFloat(2, tienHang);
            ps.setFloat(3, giamGia);
            ps.setFloat(4, tongTien);
            ps.setInt(6, idHoaDon);
            ps.setInt(5, idKM);
           
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi update  hoa don");
        }
        return row;
    }

    public void updateHoaDon1(BanHangGioHang hd) { // thanh toan
        String sql = "update hoadon set trangthai = ?, id_khachhang = ? where id_hoadon = ?";
        try {
            Connection conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(3, hd.getId());
            ps.setString(1, "Da thanh toan");
            ps.setInt(2, hd.getId_hoaDon());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Integer updateTrangThai(boolean trangThai, int idHoaDon) {
        Integer row = null;
        String sql = "update hoaDon\n"
                + "set trangThai = ?"
                + "where id_hoaDon like ?";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, trangThai);
            ps.setInt(2, idHoaDon);
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi update trang thai hoa don");
        }
        return row;
    }

    public Integer updateThanhToan(HoaDon hd) {
        Integer row = null;
        String sql = "update hoaDon\n"
                + "set trangThai = ?"
                + "where id_hoaDon like ?";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);

            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi update thanh toan hoa don");
        }
        return row;
    }

    public Integer updateKmSoLuong(int id) {
        Integer row = null;
        String sql = "update CTKM_HoaDon\n"
                + "set soLuong = soLuong - 1\n"
                + "where id_CTKM_HoaDon like  ?";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi update so luong khuyen mai");
        }
        return row;
    }

    //----------------------------------------------------------------------HOA DON CHI TIET----------------------------------------------
    public ArrayList<BanHangGioHang> getAllGioHang(int maHoaDon) {
        ArrayList<BanHangGioHang> list = new ArrayList<>();
        String sql = "select hoaDonChiTiet.id_SanPhamChiTiet, sanPham.tenSanPham, hoaDonChiTiet.soLuong, hoaDonChiTiet.giaBan, hoaDonChiTiet.soLuong * hoaDonChiTiet.giaBan \n"
                + "from sanPham join SanPhamChiTiet on sanPham.id_SanPham = SanPhamChiTiet.id_sanPham\n"
                + "join hoaDonChiTiet on hoaDonChiTiet.id_SanPhamChiTiet = SanPhamChiTiet.id_SanPhamChiTiet\n"
                + "where hoaDonChiTiet.id_HoaDon = ?";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, maHoaDon);
            rs = ps.executeQuery();
            while (rs.next()) {
                BanHangGioHang b = new BanHangGioHang();
                b.setId_sanPham(rs.getInt(1));
                b.setTenSanPham(rs.getString(2));
                b.setSoLuong(rs.getInt(3));
                b.setGiaBan(rs.getFloat(4));
                b.setThanhTien(rs.getFloat(5));
                list.add(b);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi get all gio Hang");
        }
        return list;
    }

    public Integer addGiohang(int idHoaDon, int idSpCt, int soLuong) {
        Integer row = null;
        try {
            String sql = "insert into hoaDonChiTiet(id_HoaDon, id_SanPhamChiTiet, soLuong, giaBan)\n"
                    + "			values(?,?,?,(select giaBan from SanPhamChiTiet where id_SanPhamChiTiet like ? ))";
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idHoaDon);
            ps.setInt(2, idSpCt);
            ps.setInt(3, soLuong);
            ps.setInt(4, idSpCt);
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi Add gio Hang");
        }
        return row;
    }

    public Integer UpdateGiohang_SoLuong(int idHoaDon, int idSpCt, int soLuong) {
        Integer row = null;
        try {
            String sql = "update hoaDonChiTiet\n"
                    + "set soLuong = soLuong + ?\n"
                    + "where hoaDonChiTiet.id_HoaDon like ? and hoaDonChiTiet.id_SanPhamChiTiet like ?";
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(2, idHoaDon);
            ps.setInt(3, idSpCt);
            ps.setInt(1, soLuong);
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi update so luong gio hang");
        }
        return row;
    }

    public Integer UpdateGiohang_SoLuongGiam(int idHoaDon, int idSpCt, int soLuong) {
        Integer row = null;
        try {
            String sql = "update hoaDonChiTiet\n"
                    + "set soLuong = soLuong - ?\n"
                    + "where hoaDonChiTiet.id_HoaDon like ? and hoaDonChiTiet.id_SanPhamChiTiet like ?";
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(2, idHoaDon);
            ps.setInt(3, idSpCt);
            ps.setInt(1, soLuong);
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi update so luong gio hang");
        }
        return row;
    }

    public Integer DeteLeGiohang(int idHoaDon, int idSpCt) {
        Integer row = null;
        try {
            String sql = "delete hoaDonChiTiet\n"
                    + "where hoaDonChiTiet.id_HoaDon like ? and hoaDonChiTiet.id_SanPhamChiTiet like ?";
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idHoaDon);
            ps.setInt(2, idSpCt);
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi xoa gio hang");
        }
        return row;
    }

    public Integer DeteLeAllGiohang(int idHoaDon) {
        Integer row = null;
        try {
            String sql = "delete hoaDonChiTiet\n"
                    + "where hoaDonChiTiet.id_HoaDon like ? ";
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idHoaDon);
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi xoa toan bo gio Hang");
        }
        return row;
    }

    public ArrayList<BanHangGioHang> getAllDaoHoaDonChiTiet(String ma) {
        ArrayList<BanHangGioHang> hdct = new ArrayList<>();
        String sql = "select SanPhamChiTiet.tenSanPham, hoadonchitiet.soLuong, SanPhamChiTiet.giaBan, SanPhamChiTiet.size, \n"
                + "SanPhamChiTiet.chatLieu, SanPhamChiTiet.hang, HoaDonChiTiet.tongtien from HoaDonChiTiet \n"
                + "join HoaDon on HoaDonChiTiet.maHoaDon = HoaDon.maHoaDon \n"
                + "join SanPhamChiTiet on HoaDonChiTiet.maSanPham = SanPhamChiTiet.maSanPham\n"
                + "where HoaDon.maHoaDon = ?";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                hdct.add(new BanHangGioHang(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), Float.NaN));

            }
        } catch (Exception e) {
        }
        return hdct;
    }

}
