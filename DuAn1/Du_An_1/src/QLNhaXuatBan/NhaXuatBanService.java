/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLNhaXuatBan;

import Model.NhaXuatBan;
import Repository.Connect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NgocKhai
 */
public class NhaXuatBanService {

        private Connection conn = Connect.getConnectDAO();

    
    public ArrayList<NhaXuatBan> getAll(){
        ArrayList<NhaXuatBan> listNXB = new ArrayList<>();
        String sql = "select * from nxb";
        try {
            PreparedStatement ptsm = conn.prepareStatement(sql);
            ResultSet rs = ptsm.executeQuery();
            while (rs.next())
            {                
            NhaXuatBan nxb = new NhaXuatBan();
            nxb.setManxb(rs.getInt("id_NXB"));
            nxb.setTennxb(rs.getString("tenNhaXuatBan"));
            nxb.setNgayTao(rs.getDate(3));
            nxb.setNgaySua(rs.getDate(4));
            nxb.setTrangThai(rs.getBoolean(5));
            listNXB.add(nxb);
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNXB;
    }
    
    public ArrayList<NhaXuatBan> getAllByTT(){
        ArrayList<NhaXuatBan> listNXB = new ArrayList<>();
        String sql = "select * from nxb where trangThai like 1";
        try {
            PreparedStatement ptsm = conn.prepareStatement(sql);
            ResultSet rs = ptsm.executeQuery();
            while (rs.next())
            {                
            NhaXuatBan nxb = new NhaXuatBan();
            nxb.setManxb(rs.getInt("id_NXB"));
            nxb.setTennxb(rs.getString("tenNhaXuatBan"));
            nxb.setNgayTao(rs.getDate(3));
            nxb.setNgaySua(rs.getDate(4));
            nxb.setTrangThai(rs.getBoolean(5));
            listNXB.add(nxb);
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNXB;
    }
    public void add(NhaXuatBan nxb ){
        String sql = "insert into nxb(tenNhaXuatBan, ngayThem, trangThai) values(?,?,?)";
        try {
            PreparedStatement ptsm = conn.prepareStatement(sql);
            ptsm.setString(1, nxb.getTennxb());
            ptsm.setDate(2, Date.valueOf(LocalDate.now()));
            ptsm.setBoolean(3, nxb.isTrangThai());
               ptsm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void update(NhaXuatBan nxb ){
        Connection conn = Connect.getConnectDAO();
        String sql = "update nxb set tenNhaXuatBan=?, ngaySua = ?, trangThai = ? where id_NXB=?  ";
        try {
            PreparedStatement ptsm = conn.prepareStatement(sql);
            ptsm.setString(1, nxb.getTennxb());
            ptsm.setDate(2, Date.valueOf(LocalDate.now()));
            ptsm.setBoolean(3, nxb.isTrangThai());
            ptsm.setInt(4, nxb.getManxb());
            ptsm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<NhaXuatBan> getAllByName(String ten){
        ArrayList<NhaXuatBan> listNXB = new ArrayList<>();
        String sql = "select * from nxb where tenNhaXuatBan like ?";
        try {
            PreparedStatement ptsm = conn.prepareStatement(sql);
            ptsm.setString(1, "%" + ten + "%");
            ResultSet rs = ptsm.executeQuery();
            while (rs.next())
            {                
            NhaXuatBan nxb = new NhaXuatBan();
            nxb.setManxb(rs.getInt("id_NXB"));
            nxb.setTennxb(rs.getString("tenNhaXuatBan"));
            nxb.setNgayTao(rs.getDate(3));
            nxb.setNgaySua(rs.getDate(4));
            nxb.setTrangThai(rs.getBoolean(5));
            listNXB.add(nxb);
            }        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNXB;
    }
    
    

    public int getCount() {
        int count = 0;
        String sql = "select countid_NXB) from nxb";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    
    
}
