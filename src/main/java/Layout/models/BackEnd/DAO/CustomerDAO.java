package Layout.models.BackEnd.DAO;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
import Layout.models.BackEnd.DTO.Customer;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAO {
    ConnectionDB qlkhConnection;

    public CustomerDAO() {

    }

    public ArrayList<Customer> readDB() {
        qlkhConnection= new ConnectionDB();
        ArrayList<Customer> dskh = new ArrayList<>();

        try {
            String qry = "SELECT * FROM customer";
            ResultSet r = qlkhConnection.sqlQuery(qry);

            if (r != null) {
                while (r.next()) {
                    String makh = r.getString("MaKH");
                    String tenkh = r.getString("TenKH");
                    String diachi = r.getString("DiaChi");
                    String sdt = r.getString("SDT");
                    int trangthai = r.getInt("TrangThai");
                    dskh.add(new Customer(makh, tenkh, diachi, sdt, trangthai));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng khách hàng");
        } finally {
            qlkhConnection.closeConnection();
        }
        return dskh;
    }

    public ArrayList<Customer> search(String columnName, String value) {
        qlkhConnection = new ConnectionDB();
        ArrayList<Customer> dskh = new ArrayList<>();

        try {
            String qry = "SELECT * FROM customer WHERE " + columnName + " LIKE '%" + value + "%'";
            ResultSet r = qlkhConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String makh = r.getString("MaKH");
                    String tenkh = r.getString("TenKH");
                    String diachi = r.getString("DiaChi");
                    String sdt = r.getString("SDT");
                    int trangthai = r.getInt("TrangThai");
                    dskh.add(new Customer(makh, tenkh, diachi, sdt, trangthai));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng khách hàng");
        } finally {
            qlkhConnection.closeConnection();
        }
        return dskh;
    }

    public Boolean add(Customer kh) {
        qlkhConnection = new ConnectionDB();
        Boolean result = qlkhConnection.sqlUpdate("INSERT INTO customer (MaKH, TenKH, DiaChi, SDT, TrangThai) VALUES ('"
                + kh.getMaKH() + "', '"
                + kh.getTenKh() + "', '"
                + kh.getDiaChi() + "', '"
                + kh.getSdt() + "', "
                + kh.getTrangThai() + ")");
        qlkhConnection.closeConnection();
        return result;
    }

    public Boolean delete(String makh) {
        qlkhConnection = new ConnectionDB();
        Boolean result = qlkhConnection.sqlUpdate("DELETE FROM customer WHERE MaKH='" + makh + "'");
        qlkhConnection.closeConnection();
        return result;
    }

    public Boolean update(String makh, String tenkh, String diachi, String sdt, int trangthai) {
        qlkhConnection = new ConnectionDB();
        Boolean result = qlkhConnection.sqlUpdate("UPDATE customer SET TenKH='" + tenkh
                + "', DiaChi='" + diachi
                + "', SDT='" + sdt
                + "', TrangThai=" + trangthai
                + " WHERE MaKH='" + makh + "'");
        qlkhConnection.closeConnection();
        return result;
    }

    public Boolean updateTrangThai(String makh, int trangthai) {
        qlkhConnection = new ConnectionDB();
        Boolean result = qlkhConnection.sqlUpdate("UPDATE customer SET TrangThai=" + trangthai + " WHERE MaKH='" + makh + "'");
        qlkhConnection.closeConnection();
        return result;
    }

    public void close() {
        qlkhConnection.closeConnection();
    }
}