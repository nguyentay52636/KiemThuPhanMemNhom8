/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout.models.BackEnd.DAO;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
import Layout.models.BackEnd.DTO.ImportDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ImportDetailsDAO {

    ConnectionDB qlctpnConnection;

    public ArrayList<ImportDetails> readDB() {
        ArrayList<ImportDetails> dsctpn = new ArrayList<>();
        qlctpnConnection = new ConnectionDB();
        try {

            String query = "SELECT * FROM import_details";
            ResultSet r = qlctpnConnection.sqlQuery(query);
            if (r != null) {
                while (r.next()) {
                    String ma = r.getString(1);
                    String maSP = r.getString(2);
                    Integer soLuong = r.getInt(3);
                    Float donGia = r.getFloat(4);

                    ImportDetails ctpn = new ImportDetails(ma, maSP, soLuong, donGia);
                    dsctpn.add(ctpn);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không thấy data cần tìm trong ResultSet");

        } finally {
            qlctpnConnection.closeConnection();
        }
        return dsctpn;

    }

    public ArrayList<ImportDetails> search(String columName, String value) {
        ArrayList<ImportDetails> dsctpn = new ArrayList<>();
        qlctpnConnection = new ConnectionDB();
        try {

            String query = "SELECT * FROM import_details WHERE" + columName + "LIKE '%" + value + "%'";
            ResultSet r = qlctpnConnection.sqlQuery(query);
            if (r != null) {
                while (r.next()) {
                    String ma = r.getString(1);
                    String maSP = r.getString(2);
                    Integer soLuong = r.getInt(3);
                    Float donGia = r.getFloat(4);

                    ImportDetails ctpn = new ImportDetails(ma, maSP, soLuong, donGia);
                    dsctpn.add(ctpn);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không thấy data cần tìm trong ResultSet");

        } finally {
            qlctpnConnection.closeConnection();
        }
        return dsctpn;

    }

    public boolean add(ImportDetails ctpn) {
        qlctpnConnection = new ConnectionDB();
        Boolean ok = qlctpnConnection.sqlUpdate("INSERT INTO import_details(MaPN,MaSP,SoLuong,DonGia) VALUE('"
                + ctpn.getMa() + "', '" + ctpn.getMaSP() + "','" + ctpn.getSoLuong() + "','" + ctpn.getDonGia() + "')");
        qlctpnConnection.closeConnection();
        return ok;

    }

    public Boolean deleteAll(String _mapn) {
        qlctpnConnection = new ConnectionDB();
        Boolean success = qlctpnConnection.sqlUpdate("DELETE FROM import_details WHERE MaPN='" + _mapn + "';");
        qlctpnConnection.closeConnection();
        return success;
    }

    public Boolean delete(String _mapn, String _masp) {
        qlctpnConnection = new ConnectionDB();
        Boolean success = qlctpnConnection.sqlUpdate("DELETE FROM import_details WHERE MaPN='" + _mapn + "' AND MaSP='" + _masp + "';");
        qlctpnConnection.closeConnection();
        return success;
    }

    public boolean update(String mapn, String masp, int soluong, float dongia) {
        qlctpnConnection = new ConnectionDB();
        Boolean ok = qlctpnConnection.sqlUpdate("UPDATE import_details SET "
                + "SoLuong='" + soluong
                + "',DonGia='" + dongia
                + "' WHERE MaPN='" + mapn + "' AND MaSP='" + masp + "';");
        qlctpnConnection.closeConnection();
        return ok;
    }
}
