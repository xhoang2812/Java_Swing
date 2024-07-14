/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLSPCT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Model.SanPhamChiTiet;
import Model.SanPhamChiTietViewModel;
import Repository.Connect;

/**
 *
 * @author Admin
 */
public class SPCTService {

    public List<SanPhamChiTietViewModel> findAll() {
        ArrayList<SanPhamChiTietViewModel> list = new ArrayList<>();
        try {
            String sql = "select SanPhamChiTiet.id_SanPhamChiTiet,sanPham.id_SanPham, sanPham.tenSanPham, nxb.tenNhaXuatBan, nhaCungCap.tenNhaCungCap, tacGia.tenTacGia,TheLoai, giaBan, soLuong, sanPhamChiTiet.ngayTao,sanPhamChiTiet.ngaySua, sanPhamChiTiet.trangThai\n"
                    + "from tacGia inner join SanPhamChiTiet on tacGia.id_TacGia = SanPhamChiTiet.id_TacGia\n"
                    + "join nhaCungCap on nhaCungCap.id_NhaCungCap = SanPhamChiTiet.id_NhaCungCap\n"
                    + "join nxb on nxb.id_NXB = SanPhamChiTiet.id_NXB\n"
                    + "join sanPham on sanPham.id_SanPham = SanPhamChiTiet.id_SanPham";
            Connection cn = Connect.getConnectDAO();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamChiTietViewModel sp = new SanPhamChiTietViewModel();
                sp.setId_SanPhamChiTiet(rs.getInt(1));
                sp.setId_SanPham(rs.getInt(2));
                sp.setTen_SanPham(rs.getString(3));
                sp.setTen_NXB(rs.getString(4));
                sp.setTen_NhaCungCap(rs.getString(5));
                sp.setTen_TacGia(rs.getString(6));
                sp.setTheLoai(rs.getString(7));
                sp.setGiaBan(rs.getFloat(8));
                sp.setSoLuong(rs.getInt(9));
                sp.setNgayTao(rs.getDate(10));
                sp.setNgaySua(rs.getDate(11));
                sp.setTrangThai(rs.getBoolean(12));
                list.add(sp);
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return list;
    }
    
     public List<SanPhamChiTiet> findAllID() {
        ArrayList<SanPhamChiTiet> list = new ArrayList<>();
        try {
            String sql = "select * from SanPhamChiTiet";
            Connection cn = Connect.getConnectDAO();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamChiTiet sp = new SanPhamChiTiet();
                sp.setId_SanPhamChiTiet(rs.getInt(1));
                sp.setId_SanPham(rs.getInt(5));
                sp.setId_NXB(rs.getInt(2));
                sp.setId_NhaCungCap(rs.getInt(4));
                sp.setId_TacGia(rs.getInt(3));
                sp.setTheLoai(rs.getString(6));
                sp.setGiaBan(rs.getFloat(7));
                sp.setSoLuong(rs.getInt(8));
                sp.setNgayTao(rs.getDate(9));
                sp.setNgaySua(rs.getDate(10));
                sp.setTrangThai(rs.getBoolean(11));
                list.add(sp);
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return list;
    }

    public Integer add(SanPhamChiTiet sp) {
        Integer row = null;
        try {
            String sql = "insert into SanPhamChiTiet(id_NXB,id_NhaCungCap,id_TacGia, giaBan, soLuong, ngayTao, trangThai,id_sanPham,theLoai)\n"
                    + "			values(?,?,?,?,?,?,?,?,?)";
            Connection cn = Connect.getConnectDAO();
            PreparedStatement ps = cn.prepareStatement(sql);
            SanPhamChiTiet spct = new SanPhamChiTiet();
            ps.setInt(1, sp.getId_NXB());
            ps.setInt(2, sp.getId_NhaCungCap());
            ps.setInt(3, sp.getId_TacGia());
            ps.setFloat(4, sp.getGiaBan());
            ps.setInt(5, sp.getSoLuong());
            ps.setDate(6, java.sql.Date.valueOf(LocalDate.now()));
            ps.setBoolean(7, sp.isTrangThai());
            ps.setInt(8, sp.getId_SanPham());
            ps.setString(9, sp.getTheLoai());
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    public Integer update(SanPhamChiTiet sp) {
        Integer row = null;
        try {
            String sql = "update SanPhamChiTiet \n"
                    + "set id_NXB = ?, id_TacGia = ?, id_NhaCungCap = ?, giaBan = ?, soLuong=?, ngaySua = ? , trangThai = ?, theLoai = ?\n"
                    + "where id_SanPhamChiTiet like ?";
            Connection cn = Connect.getConnectDAO();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, sp.getId_NXB());
            ps.setInt(2, sp.getId_TacGia());
            ps.setInt(3, sp.getId_NhaCungCap());
            ps.setDouble(4, sp.getGiaBan());
            ps.setInt(5, sp.getSoLuong());
            ps.setDate(6, java.sql.Date.valueOf(LocalDate.now()));
            ps.setBoolean(7, sp.isTrangThai());
            ps.setString(8, sp.getTheLoai());
            ps.setInt(9, sp.getId_SanPhamChiTiet());
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi sua services");
        }
        return row;
    }

    public List<SanPhamChiTietViewModel> findByName(String ten) {
        ArrayList<SanPhamChiTietViewModel> list = new ArrayList<>();
        try {
            String sql = "select SanPhamChiTiet.id_SanPhamChiTiet,sanPham.id_SanPham, sanPham.tenSanPham, nxb.tenNhaXuatBan, nhaCungCap.tenNhaCungCap, tacGia.tenTacGia,TheLoai, giaBan, soLuong, sanPhamChiTiet.ngayTao,sanPhamChiTiet.ngaySua, sanPhamChiTiet.trangThai\n"
                    + "from tacGia inner join SanPhamChiTiet on tacGia.id_TacGia = SanPhamChiTiet.id_TacGia\n"
                    + "join nhaCungCap on nhaCungCap.id_NhaCungCap = SanPhamChiTiet.id_NhaCungCap\n"
                    + "join nxb on nxb.id_NXB = SanPhamChiTiet.id_NXB\n"
                    + "join sanPham on sanPham.id_SanPham = SanPhamChiTiet.id_SanPham\n"
                    + "where sanPham.tenSanPham like ?";
            Connection cn = Connect.getConnectDAO();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamChiTietViewModel sp = new SanPhamChiTietViewModel();
                sp.setId_SanPhamChiTiet(rs.getInt(1));
                sp.setId_SanPham(rs.getInt(2));
                sp.setTen_SanPham(rs.getString(3));
                sp.setTen_NXB(rs.getString(4));
                sp.setTen_NhaCungCap(rs.getString(5));
                sp.setTen_TacGia(rs.getString(6));
                sp.setTheLoai(rs.getString(7));
                sp.setGiaBan(rs.getFloat(8));
                sp.setSoLuong(rs.getInt(9));
                sp.setNgayTao(rs.getDate(10));
                sp.setNgaySua(rs.getDate(11));
                sp.setTrangThai(rs.getBoolean(12));
                list.add(sp);
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi tim kiem services");
        }
        return list;
    }

}
