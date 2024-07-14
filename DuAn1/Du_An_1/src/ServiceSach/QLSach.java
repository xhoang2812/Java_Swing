package ServiceSach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Model.Sach;
import Repository.Connect;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ADmin
 */
public class QLSach {

    public ArrayList<Sach> getAll() {
        ArrayList<Sach> listSach = new ArrayList<>();
        String sql = "SELECT * FROM SanPham";
        Connection conn = Connect.getConnectDAO();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sach sp = new Sach();
                sp.setMa(rs.getInt("id_SanPham"));
                sp.setTenSach(rs.getString("tenSanPham"));
                sp.setNgayTao(rs.getString("ngayTao"));
                sp.setNgaySua(rs.getString("ngaySua"));
                listSach.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSach;
    }

    public void add(Sach sp) {
        Connection conn = Connect.getConnectDAO();
        String sql = "INSERT INTO SanPham"
                + "(tenSanPham, ngayTao)"
                + "VALUES(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, sp.getMa());
            ps.setString(1, sp.getTenSach());
            ps.setString(2, sp.getNgayTao());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Sach sp) {
        Connection conn = Connect.getConnectDAO();
        String sql = "UPDATE SanPham SET tenSanPham=?, ngaySua=? WHERE id_SanPham=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(3, sp.getMa());
            ps.setString(1, sp.getTenSach());
            ps.setString(2, sp.getNgaySua());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Sach> search(String tenSP) {
        ArrayList<Sach> listSach = new ArrayList<>();
        Connection conn = Connect.getConnectDAO();
        String sql = "SELECT * FROM SanPham WHERE tenSanPham LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + tenSP + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sach sp = new Sach();
                sp.setMa(rs.getInt("id_SanPham"));
                sp.setTenSach(rs.getString("tenSanPham"));
                sp.setNgayTao(rs.getString("ngayTao"));
                sp.setNgaySua(rs.getString("ngaySua"));
                listSach.add(sp);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSach;
    }
}
