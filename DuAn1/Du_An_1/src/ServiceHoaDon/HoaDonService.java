/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceHoaDon;

import Model.HoaDonModel;
import Model.QuanLyHoaDonChiTiet;
import Repository.Connect;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author NgocKhai
 */
public class HoaDonService {

    List<HoaDonModel> list;
    List<QuanLyHoaDonChiTiet> lists;

    public List<HoaDonModel> getAllHoaDon() throws SQLException {
        {
            list = new ArrayList<>();
            Connection conn = Connect.getConnectDAO();
            String sql = "select hd.id_hoaDon,kh.tenKhachHang,nv.tenNhanVien,hd.tienHang,hd.chietKhau,hd.tongTien,hd.ngayTao,hd.ngaySua,hd.trangThai from hoaDon hd\n"
                    + "join nhanVien nv on nv.id_NhanVien = hd.id_NhanVien\n"
                    + "full outer join khachHang kh on kh.id_KhachHang = hd.id_KhachHang\n"
                    + "full outer join CTKM_HoaDon ctkm on ctkm.id_CTKM_HoaDon = hd.id_CTKM_HoaDon\n"
                    + "\n"
                    + "where hd.trangThai like 1 ";
            try {
                PreparedStatement ptsm = conn.prepareStatement(sql);
                ResultSet rs = ptsm.executeQuery();
                while (rs.next()) {
                    HoaDonModel hdm = new HoaDonModel(rs.getInt("id_hoaDon"),
                            rs.getString("tenKhachHang"),
                            rs.getString("tenNhanVien"),
                            rs.getDouble("tienHang"),
                            rs.getDouble("chietKhau"),
                            rs.getDouble("tongTien"),
                            rs.getDate("ngayTao"),
                            rs.getDate("ngaySua"),
                            rs.getBoolean("trangThai"));
                    list.add(hdm);
                }
                return list;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }
    }

    public List<QuanLyHoaDonChiTiet> getAllHoaDonChiTiet(int ma) throws SQLException {
        {
            lists = new ArrayList<>();
            Connection conn = Connect.getConnectDAO();
            String sql = "select hdct.id_HoaDonChiTiet,hdct.id_HoaDon,sp.tenSanPham,hdct.giaBan,hdct.soLuong  from hoaDonChiTiet hdct \n"
                    + "join SanPhamChiTiet spct on spct.id_SanPhamChiTiet = hdct.id_SanPhamChiTiet  \n"
                    + "join sanPham sp on sp.id_SanPham = spct.id_SanPham where hdct.id_HoaDon like ?";
            try {
                PreparedStatement ptsm = conn.prepareStatement(sql);
                ptsm.setInt(1, ma);
                ResultSet rs = ptsm.executeQuery();
                while (rs.next()) {
                    QuanLyHoaDonChiTiet qlhdct = new QuanLyHoaDonChiTiet(rs.getInt("id_HoaDonChiTiet"),
                            rs.getInt("id_HoaDon"),
                            rs.getString("tenSanPham"),
                            rs.getDouble("giaBan"),
                            rs.getInt("soLuong")
                           );
                    lists.add(qlhdct);
                }
                return lists;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }
    }

    public List<HoaDonModel> timKiemHoaDon(String ma) throws SQLException {
        {
            list = new ArrayList<>();
            Connection conn = Connect.getConnectDAO();
            String sql = "select hd.id_hoaDon,kh.tenKhachHang,nv.tenNhanVien,hd.tienHang,hd.chietKhau,hd.tongTien,hd.ngayTao,hd.ngaySua,hd.trangThai from hoaDon hd\n"
                    + "join nhanVien nv on nv.id_NhanVien = hd.id_NhanVien\n"
                    + "full outer join khachHang kh on kh.id_KhachHang = hd.id_KhachHang\n"
                    + "full outer join CTKM_HoaDon ctkm on ctkm.id_CTKM_HoaDon = hd.id_CTKM_HoaDon\n"
                    + "\n"                    
                    + "where id_hoaDon like ?";
            try {
                PreparedStatement ptsm = conn.prepareStatement(sql);
                ptsm.setString(1, "%" + ma + "%");
                ResultSet rs = ptsm.executeQuery();
                while (rs.next()) {
                    HoaDonModel hdm = new HoaDonModel(rs.getInt("id_hoaDon"),
                            rs.getString("tenKhachHang"),
                            rs.getString("tenNhanVien"),
                            rs.getDouble("tienHang"),
                            rs.getDouble("chietKhau"),
                            rs.getDouble("tongTien"),
                            rs.getDate("ngayTao"),
                            rs.getDate("ngaySua"),
                            rs.getBoolean("trangThai"));
                    list.add(hdm);
                }
                return list;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }
    }

}
