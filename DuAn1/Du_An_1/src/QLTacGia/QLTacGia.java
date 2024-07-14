package QLTacGia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.TacGia;
import Repository.Connect;

public class QLTacGia {

    public ArrayList<TacGia> getAll() {
        ArrayList<TacGia> listTG = new ArrayList<>();
        String sql = "SELECT * FROM tacGia";
        Connection conn = Connect.getConnectDAO();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TacGia tg = new TacGia();
                tg.setMa(rs.getInt("id_TacGia"));
                tg.setTenTG(rs.getString("tenTacGia"));
                tg.setNgayTao(rs.getString("ngayThem"));
                tg.setNgaySua(rs.getString("ngaySua"));
                tg.setTrangThai(rs.getBoolean("trangThai"));
                listTG.add(tg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTG;
    }
    
    public ArrayList<TacGia> getAllByTT() {
        ArrayList<TacGia> listTG = new ArrayList<>();
        String sql = "SELECT * FROM tacGia where trangThai like 1";
        Connection conn = Connect.getConnectDAO();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TacGia tg = new TacGia();
                tg.setMa(rs.getInt("id_TacGia"));
                tg.setTenTG(rs.getString("tenTacGia"));
                tg.setNgayTao(rs.getString("ngayThem"));
                tg.setNgaySua(rs.getString("ngaySua"));
                tg.setTrangThai(rs.getBoolean("trangThai"));
                listTG.add(tg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTG;
    }

    public void add(TacGia tg) {
        Connection conn = Connect.getConnectDAO();
        String sql = "INSERT INTO tacGia"
                + "(tenTacGia, ngayThem, ngaySua, trangThai)"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tg.getTenTG());
            ps.setString(2, tg.getNgayTao());
            ps.setString(3, tg.getNgaySua());
            ps.setBoolean(4, tg.getTrangThai());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, TacGia tg) {
        Connection conn = Connect.getConnectDAO();
        String sql = "UPDATE tacGia SET tenTacGia=?, ngayThem=?, ngaySua=?,trangThai=? WHERE id_TacGia=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(5, tg.getMa());
            ps.setString(1, tg.getTenTG());
            ps.setString(2, tg.getNgayTao());
            ps.setString(3, tg.getNgaySua());
            ps.setBoolean(4, tg.getTrangThai());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<TacGia> search(String tenTG) {
        ArrayList<TacGia> listTG = new ArrayList<>();
        Connection conn = Connect.getConnectDAO();
        String sql = "SELECT * FROM tacGia WHERE tenTacGia LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + tenTG + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TacGia tg = new TacGia();
                tg.setMa(rs.getInt("id_TacGia"));
                tg.setTenTG(rs.getString("tenTacGia"));
                tg.setNgayTao(rs.getString("ngayThem"));
                tg.setNgaySua(rs.getString("ngaySua"));
                tg.setTrangThai(rs.getBoolean("trangThai"));
                listTG.add(tg);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTG;
    }
}
