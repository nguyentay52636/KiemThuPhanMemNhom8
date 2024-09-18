
package Layout.models.BackEnd.DAO;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
import Layout.models.BackEnd.DTO.InvoiceDetail;

public class InvoiceDetailDAO {
    ConnectionDB connection;

    public InvoiceDetailDAO() {
    }

    public ArrayList<InvoiceDetail> readBD() {
        connection = new ConnectionDB();
        ArrayList<InvoiceDetail> listInvoice = new ArrayList<>();

        try {
            String query = "SELECT * FROM invoice_details";
            ResultSet result = connection.sqlQuery(query);
            if (result != null) {
                while (result.next()) {
                    InvoiceDetail  invoiceDetails= new InvoiceDetail(result.getString("MaHD"), result.getString("MaSP"),
                            result.getInt("SoLuong"), result.getFloat("DonGia"));
                    listInvoice.add(invoiceDetails);

                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "-- ERROR! read invoice details");

        } finally {
            connection.closeConnection();
        }
        return listInvoice;
    }

//  public ArrayList<InvoiceDetailsDAO> getDetailInvoiceDAO(String maHD,String maSP) {
//     connection = new Connnection() ;
//     ArrayList<InvoiceDetailsDAO> listInvoiceDetails = new ArrayList<>();
//     try {

//     }catch(SQLException e) {
//         JOptionPane.showMessageDialog(null, "-- ERROR! read invoice details");
//     }finally {
//         connection.closeConnection();

//     }
//     return listInvoiceDetails ;
//     }

    public Boolean add(InvoiceDetail invoiceDetails) {
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate(("INSERT INTO invoice_details(MaHD,MaSP,SoLuong,DonGia) VALUES ('"
                + invoiceDetails.getMaHoaDon() + "','"
                + invoiceDetails.getMaSanPham() + "','"
                + invoiceDetails.getSoLuong() + "','"
                + invoiceDetails.getDonGia() + "');"));
        connection.closeConnection();
        return success;
    }
    // public boolean add(InvoiceDetailDTO invoiceDetails) {
    // try {
    // connection = new ConnectionDB();
    // String query = "INSERT INTO invoice_details (MaHD, MaSP, SoLuong, DonGia)
    // VALUES (?, ?, ?, ?)";
    // PreparedStatement preparedStatement = connection.prepareStatement(query);
    // preparedStatement.setString(1, invoiceDetails.getMaHoaDon());
    // preparedStatement.setString(2, invoiceDetails.getMaSanPham());
    // preparedStatement.setInt(3, invoiceDetails.getSoLuong());
    // preparedStatement.setFloat(4, invoiceDetails.getDonGia());
    // boolean success = preparedStatement.executeUpdate() > 0;
    // connection.closeConnection();
    // return success;
    // } catch (SQLException e) {
    // JOptionPane.showMessageDialog(null, "--ERROR! Không thể thêm dữ liệu vào cơ
    // sở dữ liệu" + "\n" + e.getLocalizedMessage());
    // return false;
    // }
    // }

    public Boolean delete(String maHD, String maSP) {
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("DELETE FROM invoice_details WHERE "
                + "MaHD='" + maHD
                + "' AND MaSP='" + maSP + "';");
        return success;
    }

    public Boolean update(InvoiceDetail invoiceDetails) {
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("UPDATE invoice_details SET"
                + "SoLuong='" + invoiceDetails.getSoLuong()
                + "', DonGia='" + invoiceDetails.getDonGia()
                + "' WHERE MaHD='" + invoiceDetails.getMaHoaDon() + "' AND MaSP='" + invoiceDetails.getMaSanPham()
                + "';");
        return success;

    }

    public Boolean updateInvoiceDetails(String maHD, String maSP, int soLuong, float donGia) {
        InvoiceDetail invoiceDetails = new InvoiceDetail(maHD, maSP, soLuong, donGia);
        return update(invoiceDetails);

    }
    public  Boolean deleteAll(String maHD) {
        connection = new ConnectionDB() ;
        Boolean success = connection.sqlUpdate("DELETE FROM invoice_details  WHERE MaHD='" + maHD + "';");
        connection.closeConnection();
        return success ;
    }

    public void closeConnection() {
        connection.closeConnection();
    }
}
