package Layout.models.BackEnd.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
import Layout.models.BackEnd.DTO.Invoice;

public class InvoiceDAO {
    private ConnectionDB connection;

    public InvoiceDAO() {
    }

    public ArrayList<Invoice> readDB() {
        connection = new ConnectionDB();
        ArrayList<Invoice> listOrder = new ArrayList<>();

        try {
            String query = "SELECT * FROM invoice";
            ResultSet resultSet = connection.sqlQuery(query);
            if (resultSet != null) {
                while (resultSet.next()) {
                    Invoice invoice = new Invoice() ;
                    invoice.setMaHoaDon(resultSet.getString("MaHD"));
                    invoice.setMaNhanVien(resultSet.getString("MaNV"));
                    invoice.setMaKhachHang(resultSet.getString("MaKH"));
                    invoice.setMaKhuyenMai(resultSet.getString("MaKM"));
                    invoice.setNgayLap(resultSet.getDate("NgayLap").toLocalDate());
                    invoice.setGioLap(resultSet.getTime("GioLap").toLocalTime());
                    invoice.setTongTien((resultSet.getFloat("TongTien")));
                    listOrder.add(invoice);


                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không đọc được dữ liệu bảng hóa đơn !!");
            e.printStackTrace();
        } finally {
            connection.closeConnection();
        }
        return listOrder;
    }

    public Invoice getInvoice(String maHoaDon) {
        ArrayList<Invoice> invoices = readDB();
        for (Invoice invoice : invoices) {
            if (invoice.getMaHoaDon().equals(maHoaDon)) {
                return invoice;
            }
        }
        return null;
    }

    public boolean addInvoice(Invoice invoice) {
        connection = new ConnectionDB();
        String query = "INSERT INTO invoice(MaHD, MaNV, MaKH, MaKM, NgayLap,GioLap,TongTien) VALUES('" +
                invoice.getMaHoaDon() + "','" +
                invoice.getMaNhanVien() + "','" +
                invoice.getMaKhachHang() + "','" +
                invoice.getMaKhuyenMai() + "','" +
                Date.valueOf(invoice.getNgayLap()) + "','" +
                Time.valueOf(invoice.getGioLap()) + "'," +
                invoice.getTongTien() + ")";
        boolean result = connection.sqlUpdate(query);
        System.out.println("Thêm thành công!");
        return result;

    }

    public Boolean updateTongTien(String _mahd,float _tongTien){
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("UPDATE invoice SET TongTien='" + _tongTien + "' WHERE MaHD='" +_mahd + "';");
        connection.closeConnection();
        return success;
    }

    public boolean deleteInvoice(String idInvoice) {
        connection = new ConnectionDB();
        Boolean result = connection.sqlUpdate("DELETE FROM invoice WHERE MAHD = '" + idInvoice + "'");
        if (!result) {
            JOptionPane.showMessageDialog(null, "Vui long xoa het chi tiet cua hoa don truoc !!!");
            connection.closeConnection();
            return false;
        } else {
            connection.closeConnection();
            return true;
        }

    }

    public boolean update(Invoice invoice) {
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("UPDATE invoice SET "
                + "MaNV='" + invoice.getMaNhanVien()
                + "', MaKH='" + invoice.getMaKhachHang()
                + "', MaKM='" + invoice.getMaKhuyenMai()
                + "', NgayLap='" + invoice.getNgayLap()
                + "', GioLap='" + invoice.getGioLap()
                + "', TongTien='" + invoice.getTongTien()
                + "' WHERE MaHD='" + invoice.getMaHoaDon() + "';");
        connection.checkConnect();
        return success;
    }

    public boolean InvoiceTotalAmountDAO(String idInvoice, Float totalAmount) {
        connection = new ConnectionDB();
        Boolean success = connection
                .sqlUpdate("UPDATE invoice SET TongTien='" + totalAmount + "' WHERE MaHD='" + idInvoice + "';");
        connection.closeConnection();
        return success;

    }
}