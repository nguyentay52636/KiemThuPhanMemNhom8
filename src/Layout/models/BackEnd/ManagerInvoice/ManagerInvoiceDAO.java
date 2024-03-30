package Layout.models.BackEnd.ManagerInvoice;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
import Layout.models.BackEnd.ManagerAccount.ManagerAccountDAO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ManagerInvoiceDAO {
    ConnectionDB connection;

    public ManagerInvoiceDAO() {

    }

    public ArrayList readDataBase() {
        connection = new ConnectionDB();
        ArrayList<Invoice> listInvoice = new ArrayList<>();

        try {
            String query = "SELECT * FROM hoadon";
            ResultSet resultSet = connection.sqlQuery(query);

            if (resultSet != null) {
                while (resultSet.next()) {
                    Invoice invoice = new Invoice();
                    invoice.setMaHD(resultSet.getString("MaHD"));
                    invoice.setMaNV(resultSet.getString("MaNV"));
                    invoice.setMaKH(resultSet.getString("MaKH"));
                    invoice.setMaKM(resultSet.getString("MaKM"));
                    invoice.setNgayLap(resultSet.getDate("NgayLap").toLocalDate());
                    invoice.setGioLap(resultSet.getTime("GioLap").toLocalTime());
                    invoice.setTongtien(resultSet.getFloat("TongTien"));
                    listInvoice.add(invoice);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không đọc được dữ liệu bảng hóa đơn !!");
        } finally {
            connection.closeConnection();
        }
        return listInvoice;
    }

    public Boolean add(Invoice hd) {
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("INSERT INTO hoadon(MaHD,MaNV,MaKH,MaKM,NgayLap,GioLap,TongTien) VALUES ('"
                + hd.getMaHD() + "','"
                + hd.getMaNV() + "','"
                + hd.getMaKH() + "','"
                + hd.getMaKM() + "','"
                + hd.getNgayLap() + "','"
                + hd.getGioLap() + "','"
                + hd.getTongtien() + "');");
        connection.closeConnection();
        return success;
    }

    public Boolean delete(String mahd) {
        connection = new ConnectionDB();

        if (!connection.sqlUpdate("DELETE FROM hoadon WHERE MaHD = '" + mahd + "'")) {
            JOptionPane.showMessageDialog(null, "Lỗi xóa dữ liệu!");
            connection.closeConnection();
            return false;
        }
        connection.closeConnection();

        return true;
    }

    public Boolean update(Invoice invoice) {
        connection = new ConnectionDB();

        Boolean success = connection.sqlUpdate("UPDATE hoadon SET MaNV = '" + invoice.getMaNV() + "', MaKH = '" + invoice.getMaKH() + "', MaKM = '" + invoice.getMaKM() + "', NgayLap = '" + invoice.getNgayLap() + "', GioLap = '" + invoice.getGioLap() + "', TongTien = '" + invoice.getTongtien() + "' WHERE MaHD = '" + invoice.getMaHD() + "'");
        connection.closeConnection();

        return success;
    }

    public Boolean updateTongTien(String mahd, float tongtien) {
        connection = new ConnectionDB();

        Boolean success = connection.sqlUpdate("UPDATE hoadon SET TongTien = '" + tongtien + "' WHERE MaHD = '" + mahd + "'");
        connection.closeConnection();

        return success;
    }

    public Boolean update(String mahoadon, String manhanvien, String makhachhang, String makhuyenmai, LocalDate ngaylap, LocalTime giolap, float tongtien) {
        Invoice invoice = new Invoice();

        invoice.setMaHD(mahoadon);
        invoice.setMaNV(manhanvien);
        invoice.setMaKH(makhachhang);
        invoice.setMaKM(makhuyenmai);
        invoice.setNgayLap(ngaylap);
        invoice.setGioLap(giolap);
        invoice.setTongtien(tongtien);

        return update(invoice);
    }
}
