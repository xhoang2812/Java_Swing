package QLNhaCungCap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.NhaCungCap;
import Repository.Connect;

public class QLNhaCungCap {

    public ArrayList<NhaCungCap> getAll() {
        ArrayList<NhaCungCap> listNCC = new ArrayList<>();
        String sql = "SELECT * FROM nhaCungCap";
        Connection conn = Connect.getConnectDAO();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMa(rs.getInt("id_NhaCungCap"));
                ncc.setTenNCC(rs.getString("tenNhaCungCap"));
                ncc.setNgayTao(rs.getString("ngayThem"));
                ncc.setNgaySua(rs.getString("ngaySua"));
                ncc.setTrangThai(rs.getBoolean("trangThai"));
                listNCC.add(ncc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNCC;
    }
public ArrayList<NhaCungCap> getAllByTT() {
        ArrayList<NhaCungCap> listNCC = new ArrayList<>();
        String sql = "SELECT * FROM nhaCungCap where trangThai like 1";
        Connection conn = Connect.getConnectDAO();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMa(rs.getInt("id_NhaCungCap"));
                ncc.setTenNCC(rs.getString("tenNhaCungCap"));
                ncc.setNgayTao(rs.getString("ngayThem"));
                ncc.setNgaySua(rs.getString("ngaySua"));
                ncc.setTrangThai(rs.getBoolean("trangThai"));
                listNCC.add(ncc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNCC;
    }
    public void add(NhaCungCap ncc) {
        Connection conn = Connect.getConnectDAO();
        String sql = "INSERT INTO nhaCungCap"
                + "(tenNhaCungCap, ngayThem, ngaySua, trangThai)"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ncc.getTenNCC());
            ps.setString(2, ncc.getNgayTao());
            ps.setString(3, ncc.getNgaySua());
            ps.setBoolean(4, ncc.getTrangThai());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, NhaCungCap ncc) {
        Connection conn = Connect.getConnectDAO();
        String sql = "UPDATE nhaCungCap SET tenNhaCungCap=?, ngayThem=?, ngaySua=?,trangThai=? WHERE id_NhaCungCap=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(5, ncc.getMa());
            ps.setString(1, ncc.getTenNCC());
            ps.setString(2, ncc.getNgayTao());
            ps.setString(3, ncc.getNgaySua());
            ps.setBoolean(4, ncc.getTrangThai());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<NhaCungCap> search(String tenNCC) {
        ArrayList<NhaCungCap> listNCC = new ArrayList<>();
        Connection conn = Connect.getConnectDAO();
        String sql = "SELECT * FROM nhaCungCap WHERE tenNhaCungCap LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + tenNCC + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMa(rs.getInt("id_NhaCungCap"));
                ncc.setTenNCC(rs.getString("tenNhaCungCap"));
                ncc.setNgayTao(rs.getString("ngayThem"));
                ncc.setNgaySua(rs.getString("ngaySua"));
                ncc.setTrangThai(rs.getBoolean("trangThai"));
                listNCC.add(ncc);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNCC;
    }
}
