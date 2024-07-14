/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceNhanVien;

import java.util.ArrayList;
import java.util.List;
import Model.NhanVien;
import java.sql.*;
import java.time.LocalDate;
import Repository.Connect;

/**
 *
 * @author Admin
 */
public class nhanVienService {

    String getAll = "select * from nhanVien";
    String findByEmail = "select * from nhanVien\n"
            + "where email like ?";
    String findByUserName = "select * from nhanVien\n"
            + "where userName like ?";
    String add = "insert into nhanVien(userName, password, tenNhanVien, gioiTinh, email, sdt,ngayTao, trangThai, vaitro)\n"
            + "			values(?, ?, ?, ?, ?,?, ?, ?,?)";
    String delete = "delete nhanVien\n"
            + "where id_nhanVien like ?";
    String findNhanVien = "select * from nhanVien\n"
            + "where sdt like ? or email like ?";

    public List<NhanVien> findAll() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
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
        }
        return list;
    }

    public Integer add(NhanVien o) {
        Integer row = null;
        try {
            Connection cn = Connect.getConnectDAO();
            PreparedStatement ps = cn.prepareStatement(add);
            ps.setString(1, o.getUserName());
            ps.setString(2, o.getPassWord());
            ps.setString(3, o.getTenNhanVien());
            ps.setBoolean(4, o.isGioiTinh());
            ps.setString(5, o.getEmail());
            ps.setString(6, o.getSdt());
            ps.setDate(7, Date.valueOf(LocalDate.now()));
            ps.setBoolean(8, o.isTrangThai());
            ps.setBoolean(9, o.isVaiTro());

            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;

    }

    public Integer update(NhanVien o) {
        Integer row = null;
        try {
            String update = "update nhanVien\n"
                    + "set userName = ?, password = ?, tenNhanVien =?, gioiTinh = ?, email = ?, sdt = ?,ngaySua = ?,  trangThai = ?, vaitro = ?\n"
                    + "where id_nhanVien like ?";
            Connection cn = Connect.getConnectDAO();
            PreparedStatement ps = cn.prepareStatement(update);
            ps.setInt(10, o.getId());
            ps.setString(1, o.getUserName());
            ps.setString(2, o.getPassWord());
            ps.setString(3, o.getTenNhanVien());
            ps.setBoolean(4, o.isGioiTinh());
            ps.setString(5, o.getEmail());
            ps.setString(6, o.getSdt());
            ps.setDate(7, Date.valueOf(LocalDate.now()));
            ps.setBoolean(8, o.isTrangThai());
            ps.setBoolean(9, o.isVaiTro());
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    public ArrayList<NhanVien> findNhanVien( String sdt, String email) {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            Connection cn = Connect.getConnectDAO();
            PreparedStatement ps = cn.prepareStatement(findNhanVien);
       
            ps.setString(1, '%' + sdt + '%');
            ps.setString(2, '%' + email + '%');
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setId(rs.getInt("id_NhanVien"));
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
        }
        return list;
    }
    
    public NhanVien findByEmail(String email){
        try {
            Connection cn = Connect.getConnectDAO();
            PreparedStatement ps = cn.prepareStatement(findByEmail);
            ps.setString(1, email);
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
                return nv;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public NhanVien findByUserName(String userName){
        try {
            Connection cn = Connect.getConnectDAO();
            PreparedStatement ps = cn.prepareStatement(findByUserName);
            ps.setString(1, userName);
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
                return nv;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    
}
