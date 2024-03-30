package Layout.models.BackEnd.ManagerProduct;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManagerProductDAO {
    ConnectionDB managerProductConnection = new ConnectionDB();

    public ManagerProductDAO() {

    }

    public ArrayList<Product> readDataBase() {
        managerProductConnection = new ConnectionDB();

        ArrayList<Product> listProduct = new ArrayList<>();

        try {
            String query = "SELECT * FROM sanpham";
            ResultSet resultSet = managerProductConnection.sqlQuery(query);

            if (resultSet != null) {
                while (resultSet.next()) {
                    String masp = resultSet.getString("MaSP");
                    String loaisp = resultSet.getString("MaLSP");
                    String tensp = resultSet.getString("TenSP");
                    float dongia = resultSet.getFloat("DonGia");
                    int soluong = resultSet.getInt("SoLuong");
                    String url = resultSet.getString("HinhAnh");
                    int trangthai = resultSet.getInt("TrangThai");

                    listProduct.add(new Product(masp, loaisp, tensp, dongia, soluong, url, trangthai));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "--ERROR! Lỗi đọc dữ liệu từ bảng sản phẩm!");
        } finally {
            managerProductConnection.closeConnection();
        }

        return listProduct;
    }

    public ArrayList<Product> search(String columnName, String value) {
        managerProductConnection = new ConnectionDB();
        ArrayList<Product> listProduct = new ArrayList<>();

        try {
            String query = "SELECT * FROM sanpham WHERE " + columnName + " LIKE '%" + value + "%'";
            ResultSet resultSet = managerProductConnection.sqlQuery(query);

            if (resultSet != null) {
                String masp = resultSet.getString("MaSP");
                String loaisp = resultSet.getString("MaLSP");
                String tensp = resultSet.getString("TenSP");
                float dongia = resultSet.getFloat("DonGia");
                int soluong = resultSet.getInt("SoLuong");
                String url = resultSet.getString("HinhAnh");
                int trangthai = resultSet.getInt("TrangThai");

                listProduct.add(new Product(masp, loaisp, tensp, dongia, soluong, url, trangthai));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "--ERROR! Lỗi tìm dữ liệu " + columnName + " = " + value + " bảng sản phẩm");
        } finally {
            managerProductConnection.closeConnection();
        }
        return listProduct;
    }

    public Boolean add(Product product) {
        managerProductConnection = new ConnectionDB();
        Boolean success = managerProductConnection.sqlUpdate("INSERT INTO sanpham(MaSP,MaLSP,TenSP,DonGia,SoLuong,HinhAnh,TrangThai) VALUES ('"
                + product.getMasanpham() + "','"
                + product.getMaloaisanpham() + "','"
                + product.getTensanpham() + "','"
                + product.getDongia() + "','"
                + product.getSoluong() + "','"
                + product.getFilenamehinhanh() + "','"
                + product.getTrangthai() + "');");
        managerProductConnection.closeConnection();
        return success;
    }

    public Boolean delete(String masp) {
        managerProductConnection = new ConnectionDB();

        Boolean success = managerProductConnection.sqlUpdate("DELETE FROM sanpham WHERE MaSP = '" + masp + "'");
        managerProductConnection.closeConnection();

        return success;
    }

    public Boolean update(String masanpham, String maloaisanpham, String tensanpham, float dongia, int soluong, String filename, int trangthai) {
        managerProductConnection = new ConnectionDB();

        Boolean success = managerProductConnection.sqlUpdate("UPDATE sanpham SET MaLSP = '" + maloaisanpham + "', TenSP = '" + tensanpham + "', DonGia = '" + dongia + "', SoLuong = '" + soluong + "', HinhAnh = '" + filename + "', TrangThai = '" + trangthai + "' WHERE MaSP = '" + masanpham + "'");
        managerProductConnection.closeConnection();

        return success;
    }

    public Boolean updateSoluong(String masanpham, int soluong) {
        managerProductConnection = new ConnectionDB();

        Boolean success = managerProductConnection.sqlUpdate("UPDATE SanPham SET SoLuong = '" + soluong + "' WHERE MaSP = '" + masanpham + "'");
        managerProductConnection.closeConnection();

        return success;
    }

    public Boolean updateTrangThai(String masanpham, int trangthai) {
        managerProductConnection = new ConnectionDB();

        Boolean success = managerProductConnection.sqlUpdate("UPDATE SanPham SET TrangThai = '" + trangthai + "' WHERE MaSP = '" + masanpham + "'");

        managerProductConnection.closeConnection();
        return success;
    }
}
