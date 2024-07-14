/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceTheLoai;

import Model.TheLoai;
import Repository.Connect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class theLoaiService {

    public ArrayList<TheLoai> getAll() {
        ArrayList<TheLoai> list = new ArrayList<>();
        try {
            String sql = "select * from TheLoai";
            Connection cn = Connect.getConnectDAO();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TheLoai theLoai = new TheLoai();
                theLoai.setId_theLoai(rs.getInt(1));
                theLoai.setTenTheLoai(rs.getString(2));
                theLoai.setNgayTao(rs.getDate(3));
                theLoai.setNgaySua(rs.getDate(4));
                list.add(theLoai);
            }

            rs.close();
            ps.close();
            cn.close();
        } catch (Exception e) {
            // Xử lý exception
            e.printStackTrace();
        }
        return list;

    }
    

    public Integer insertTheLoai(TheLoai theLoai) {
        Integer row = null;
        try {
            String sql = "INSERT INTO TheLoai (tenTheLoai, ngayThem) VALUES (?, ?)";
            Connection cn = Connect.getConnectDAO();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, theLoai.getTenTheLoai());
            ps.setDate(2, Date.valueOf(LocalDate.now()));
            row = ps.executeUpdate();
            ps.close();
            cn.close();
        } catch (Exception e) {
            // Xử lý exception
            e.printStackTrace();
        }
        return row;
    }

    public Integer updateTheLoai(TheLoai theLoai) {
        Integer row = null;
        try {
            String sql = "UPDATE TheLoai SET tenTheLoai = ?, ngaySua = ? WHERE id_TheLoai = ?";
            Connection cn = Connect.getConnectDAO();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, theLoai.getTenTheLoai());
            ps.setDate(2, Date.valueOf(LocalDate.now()));
           
            ps.setInt(3, theLoai.getId_theLoai());
            row = ps.executeUpdate();
            ps.close();
            cn.close();
        } catch (Exception e) {
            // Xử lý exception
            e.printStackTrace();
        }
        return row;
    }
}
