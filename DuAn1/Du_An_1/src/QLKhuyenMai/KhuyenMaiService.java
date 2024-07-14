/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLKhuyenMai;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.KhuyenMai;
import Repository.Connect;

/**
 *
 * @author DELL
 */
public class KhuyenMaiService {

    public ArrayList<KhuyenMai> getAll() {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        String sql = "UPDATE CTKM_HoaDon\n"
                + "SET trangThai = CASE\n"
                + "    WHEN ngayBatDau > GETDATE() THEN 0\n"
                + "    WHEN ngayKetThuc < GETDATE() THEN 0\n"
                + "    ELSE 1\n"
                + "END;"
                + "select * from CTKM_HoaDon";
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
        }
        return list;
    }
//create table CTKM_HoaDon(
//	id_CTKM_HoaDon int identity(1,1) primary key,
//	tenCTKM nvarchar(128),
//	giaTriGiam int,
//	ngayTao date,
//	ngaySua date,
//	ngayBatDau date,
//	ngayKetThuc date,
//	trangThai bit,
//	
//) 

    public void addKhuyenMai(KhuyenMai km) {
        Connection conn = Connect.getConnectDAO();
        String sql = "INSERT INTO CTKM_HoaDon"
                + "(tenCTKM,giaTriGiam,soLuong,ngayBatDau,ngayKetThuc,hoaDonToiThieu)"
                + "VALUES(?,?,?,?,?,?)";
        try {
            java.sql.Date sqlStartDate = new java.sql.Date(km.getNgayBatDau().getTime());
            java.sql.Date sqlEndDate = new java.sql.Date(km.getNgayKetThuc().getTime());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, km.getTenCTKM());
            ps.setInt(2, km.getGiaTriGiam());
            ps.setInt(3, km.getSoLuong());
            ps.setDate(4, sqlStartDate);
            ps.setDate(5, sqlEndDate);
            ps.setFloat(6, km.getHoaDonToiThieu());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateKhuyenMai(int id, KhuyenMai km) {
        Connection conn = Connect.getConnectDAO();
        String sql = "UPDATE CTKM_HoaDon SET tenCTKM=?, giaTriGiam=?,  soLuong=?, ngayBatDau=?, ngayKetThuc=?, hoaDonToiThieu = ? WHERE id_CTKM_HoaDon=?";
        try {
            java.sql.Date sqlStartDate = new java.sql.Date(km.getNgayBatDau().getTime());
            java.sql.Date sqlEndDate = new java.sql.Date(km.getNgayKetThuc().getTime());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(7, km.getId_CTKM_HoaDon());
            ps.setString(1, km.getTenCTKM());
            ps.setInt(2, km.getGiaTriGiam());
            ps.setInt(3, km.getSoLuong());
            ps.setDate(4, sqlStartDate);
            ps.setDate(5, sqlEndDate);
            ps.setFloat(6, km.getHoaDonToiThieu());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteKhuyenMai(int id_CTKM_HoaDon) {
        Connection conn = Connect.getConnectDAO();
        String sql = "DELETE FROM CTKM_HoaDon WHERE id_CTKM_HoaDon=?  ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_CTKM_HoaDon);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<KhuyenMai> search(String tenkm) {
        ArrayList<KhuyenMai> listkm = new ArrayList<>();
        Connection conn = Connect.getConnectDAO();
        String sql = "SELECT * FROM CTKM_HoaDon WHERE tenCTKM LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + tenkm + "%");
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
                listkm.add(km);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listkm;
    }
}
