/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLNXB;

import Model.NhaXuatBan;
import Repository.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String sql = "select id_NXB,tenNhaXuatBan from nxb";
        try {
            PreparedStatement ptsm = conn.prepareStatement(sql);
            ResultSet rs = ptsm.executeQuery();
            while (rs.next())
            {                
            NhaXuatBan nxb = new NhaXuatBan();
            nxb.setManxb(rs.getInt("id_NXB"));
            nxb.setTennxb(rs.getString("tenNhaXuatBan"));
            listNXB.add(nxb);
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNXB;
    }
    public void add(NhaXuatBan nxb ){
        String sql = "insert into nxb(tenNhaXuatBan) values(?)";
        try {
            PreparedStatement ptsm = conn.prepareStatement(sql);
            ptsm.setString(1, nxb.getTennxb());
               ptsm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void update(NhaXuatBan nxb ){
        Connection conn = Connect.getConnectDAO();
        String sql = "update nxb set tenNhaXuatBan=? where id_NXB=?  ";
        try {
            PreparedStatement ptsm = conn.prepareStatement(sql);
            ptsm.setString(1, nxb.getTennxb());
            ptsm.setInt(2, nxb.getManxb());

            ptsm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
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
