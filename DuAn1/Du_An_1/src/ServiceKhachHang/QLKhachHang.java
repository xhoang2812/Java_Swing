/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceKhachHang;

import Model.KhachHang;
import Repository.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADmin
 */
public class QLKhachHang {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<KhachHang> getAllDao() {
        ArrayList<KhachHang> dskh = new ArrayList<>();
        String sql = "select * from khachHang";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dskh.add(new KhachHang(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return dskh;
    }

    public void add(KhachHang kh) {
        String sql = "insert into khachHang(tenKhachHang,gioiTinh,sdt,ngayThem,trangThai)\n"
                + "			values(?,?,?,?,?)";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getTen());
            ps.setInt(2, kh.getGioiTinh());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getThem());
            ps.setInt(5, kh.getTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update(KhachHang kh) {
        String sql = "update khachHang \n"
                + "set tenKhachHang = ?, gioiTinh=?, sdt=?, ngaySua = ?, trangThai =?\n"
                + "where id_KhachHang like ?";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getTen());
            ps.setInt(2, kh.getGioiTinh());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getSua());
            ps.setInt(5, kh.getTrangThai());
            ps.setInt(6, kh.getMa());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void delete(String ma) {
        String sql = "delete from khachhang where id_khachHang = ?";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<KhachHang> getAllDaoTimKiem(String ten) {
        ArrayList<KhachHang> dskh = new ArrayList<>();
        String sql = "select * from khachHang\n"
                + "		where tenKhachHang like ?";
        try {
            conn = new Connect().getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                dskh.add(new KhachHang(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
        } catch (Exception e) {
            System.out.println(e); // hiển thị thông báo lỗi ở đâu
        }
        return dskh;
    }
}
