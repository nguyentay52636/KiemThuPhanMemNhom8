/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout.models.BackEnd.DAO;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
import Layout.models.BackEnd.DTO.Import;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ImportDAO {

    ConnectionDB connection;

    public ImportDAO() {
    }

    public ArrayList readDB() {
        connection = new ConnectionDB();
        ArrayList<Import> dspn = new ArrayList<>();
        try {
            String qry = "SELECT * FROM import";
            ResultSet rs = connection.sqlQuery(qry);
            if (rs != null) {

                while (rs.next()) {
                    Import pn = new Import();

                    pn.setMaPN(rs.getString(1));
                    pn.setMaNCC(rs.getString(2));
                    pn.setMaNV(rs.getString(3));
                    pn.setNgayNhap(rs.getDate(4).toLocalDate());
                    pn.setGioNhap(rs.getTime(5).toLocalTime());
                    pn.setTongTien(rs.getFloat(6));
                    dspn.add(pn);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Khong tim thay du lieu !!");
        } finally {
            connection.closeConnection();
        }
        return dspn;
    }

    public Boolean add(Import pn) {
        connection = new ConnectionDB();
        Boolean ok = connection.sqlUpdate("INSERT INTO import(MaPN,MaNCC,MaNV,NgayNhap,GioNhap,TongTien) VALUES ('"
                + pn.getMaPN() + "','"
                + pn.getMaNCC() + "','"
                + pn.getMaNV() + "','"
                + pn.getNgayNhap() + "','"
                + pn.getGioNhap() + "','"
                + pn.getTongTien() + "');");
        connection.closeConnection();
        return ok;
    }

    public Boolean delete(String mapn) {
        connection = new ConnectionDB();
        if (!connection.sqlUpdate("DELETE FROM import WHERE MaPN='" + mapn + "';")) {
            JOptionPane.showMessageDialog(null, "Vui long xoa het chi tiet cua phiếu nhập truoc !!!");
            connection.closeConnection();
            return false;
        }
        connection.closeConnection();
        return false;
    }

    public Boolean update(Import pn) {
        connection = new ConnectionDB();
        Boolean ok = connection.sqlUpdate("UPDATE import SET "
                + "MaNCC='" + pn.getMaNCC()
                + "', MaNV='" + pn.getMaNV()
                + "', NgayNhap='" + pn.getNgayNhap()
                + "', GioNhap='" + pn.getGioNhap()
                + "', TongTien='" + pn.getTongTien()
                + "' WHERE MaPN='" + pn.getMaPN() + "';");
        connection.closeConnection();
        return ok;
    }

    public Boolean updateTongTien(String _mapn, float _tongTien) {
        connection = new ConnectionDB();
        Boolean ok = connection.sqlUpdate("UPDATE import SET TongTien='" + _tongTien + "' WHERE MaPN='" + _mapn + "';");
        connection.closeConnection();
        return ok;
    }

    public Boolean update(String maPN, String maNCC, String maNV, LocalDate ngayNhap, LocalTime gioNhap, float tongTien) {
        Import pn = new Import();
        pn.setMaPN(maPN);
        pn.setMaNCC(maNCC);
        pn.setMaNV(maNV);
        pn.setNgayNhap(ngayNhap);
        pn.setGioNhap(gioNhap);
        pn.setTongTien(tongTien);
        return update(pn);
    }
}
