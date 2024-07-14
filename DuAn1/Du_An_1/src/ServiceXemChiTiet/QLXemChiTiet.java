/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceXemChiTiet;

import Model.SanPhamChiTietViewModel;
import Repository.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QLXemChiTiet {

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
}
