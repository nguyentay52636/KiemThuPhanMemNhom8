////package Layout.models.BackEnd.DAO;
////
////import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
////import Layout.models.BackEnd.DTO.Product;
////
////import javax.swing.*;
////import java.sql.ResultSet;
////import java.sql.SQLException;
////import java.util.ArrayList;
////
////public class ProductDAO {
////    ConnectionDB qlspConnection;
////
////    public ProductDAO() {
////
////    }
////
////    public ArrayList<Product> readDB() {
////        qlspConnection = new ConnectionDB();
////        ArrayList<Product> dssp = new ArrayList<>();
////        try {
////            String qry = "SELECT * FROM product";
////            ResultSet r = qlspConnection.sqlQuery(qry);
////            if (r != null) {
////                while (r.next()) {
////                    String masp = r.getString("MaSP");
////                    String loaisp = r.getString("MaLSP");
////                    String tensp = r.getString("TenSP");
////                    float dongia = r.getFloat("DonGia");
////                    int soluong = r.getInt("SoLuong");
////                    String url = r.getString("HinhAnh");
////                    int trangthai = r.getInt("TrangThai");
////                    dssp.add(new Product(masp, loaisp, tensp, dongia, soluong, url, trangthai));
////                }
////            }
////
////        } catch (SQLException ex) {
////            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng sản phẩm");
////        } finally {
////            qlspConnection.closeConnection();
////        }
////        return dssp;
////    }
////
////    public ArrayList<Product> search(String columnName, String value) {
////        qlspConnection = new ConnectionDB();
////        ArrayList<Product> dssp = new ArrayList<>();
////
////        try {
////            String qry = "SELECT * FROM product WHERE " + columnName + " LIKE '%" + value + "%'";
////            ResultSet r = qlspConnection.sqlQuery(qry);
////            if (r != null) {
////                while (r.next()) {
////                    String masp = r.getString("MaSP");
////                    String loaisp = r.getString("MaLSP");
////                    String tensp = r.getString("TenSP");
////                    float dongia = r.getFloat("DonGia");
////                    int soluong = r.getInt("SoLuong");
////                    String url = r.getString("HinhAnh");
////                    int trangthai = r.getInt("TrangThai");
////                    dssp.add(new Product(masp, loaisp, tensp, dongia, soluong, url, trangthai));
////                }
////            }
////
////        } catch (SQLException ex) {
////            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu " + columnName + " = " + value + " bảng sản phẩm");
////        } finally {
////            qlspConnection.closeConnection();
////        }
////
////        return dssp;
////    }
////
////    public Boolean add(Product sp) {
////        qlspConnection = new ConnectionDB();
////        Boolean result = qlspConnection.sqlUpdate("INSERT INTO product (MaSP, MaLSP,TenSP,DonGia,SoLuong,HinhAnh,TrangThai) VALUES ('"
////                + sp.getMaSP() + "','"
////                + sp.getMaLSP() + "','"
////                + sp.getTenSP() + "','"
////                + sp.getDonGia() + "','"
////                + sp.getSoLuong() + "','"
////                + sp.getHinhAnh() + "','"
////                + sp.getTrangthai()+ "');");
////        qlspConnection.closeConnection();
////        return result;
////    }
////
////    public Boolean delete(String masp) {
////        qlspConnection = new ConnectionDB();
////        Boolean result = qlspConnection.sqlUpdate("DELETE FROM product WHERE product.MaSP = '" + masp + "'");
////        qlspConnection.closeConnection();
////        return result;
////    }
////
////    public Boolean update(String MaSP, String MaLSP, String TenSP, float DonGia, int SoLuong, String filename, int trangthai) {
////        qlspConnection = new ConnectionDB();
////        Boolean result = qlspConnection.sqlUpdate("Update product Set "
////                + "MaLSP='" + MaLSP
////                + "',TenSP='" + TenSP
////                + "',DonGia='" + DonGia
////                + "',SoLuong='" + SoLuong
////                + "',HinhAnh='" + filename
////                + "',TrangThai='" + trangthai
////                + "' where MaSP='" + MaSP + "'");
////        qlspConnection.closeConnection();
////        return result;
////    }
////
////    public Boolean updateSoLuong(String MaSP, int SoLuong) {
////        qlspConnection = new ConnectionDB();
////        Boolean result = qlspConnection.sqlUpdate("Update product Set "
////                + "SoLuong='" + SoLuong
////                + "' where MaSP='" + MaSP + "'");
////        qlspConnection.closeConnection();
////        return result;
////    }
////
////    public Boolean updateTrangThai(String MaSP, int trangthai) {
////        qlspConnection = new ConnectionDB();
////        Boolean result = qlspConnection.sqlUpdate("Update product Set "
////                + "TrangThai='" + trangthai
////                + "' where MaSP='" + MaSP + "'");
////        qlspConnection.closeConnection();
////        return result;
////    }
////
////    public void close() {
////        qlspConnection.closeConnection();
////    }
////}
//
//package Layout.models.BackEnd.DAO;
//
//import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
//import Layout.models.BackEnd.DTO.Product;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//
//public class ProductDAO {
//
//    private ConnectionDB con;
//    ArrayList<Product> dssp= new ArrayList<Product>() ;
//    public ProductDAO () {
//
//    }
//
//
//    public ArrayList<Product > selectAll() {
//        //Tạo danh sách kết quả lưu các danh sách khách hàng rồi in ra
//
//        try {
//            con= new ConnectionDB();
//
//            String sql="select* from product";
//            ResultSet rs=con.sqlQuery(sql);
//
//            //Lấy từng khách hàng từ rs cho vào kết quả
//            while(rs.next()) {
//                String maSP = rs.getString("MaSP");
//                String MaLSP=rs.getString("MaLSP");
//                String TenSP=rs.getString("TenSP");
//                float dongia= rs.getFloat("DonGia");
//                int soluong=rs.getInt("SoLuong");
//                String Hinhanh=rs.getString("HinhAnh");
//                int TrangThai=rs.getInt("TrangThai");
//
//                Product  nv = new Product (maSP,MaLSP,TenSP,dongia,soluong,Hinhanh,TrangThai);
//                dssp.add(nv);
//            }
//            con.closeConnection();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return dssp;
//    }
//
//    public Boolean addDao(Product   product) {
//        con = new ConnectionDB();
//
//        String sql = "INSERT INTO product (MaSP, MaLSP, TenSP, DonGia, SoLuong, HinhAnh, TrangThai) VALUES ('" + product.getMaSP() + "', '" + product.getMaLSP() +
//                "', '"+ product.getTenSP() + "', " + product.getDonGia() + ", " + product.getSoLuong() + ", '" + product.getHinhAnh() + "', '" + product.getTrangthai() + "')";
//        Boolean result = con.sqlUpdate(sql);
//
//        System.out.println("Thêm sản phẩm thành công!");
//        con.closeConnection();
//        return result;
//    }
//
//
//    public Boolean update(Product   product) {
//
//        con= new ConnectionDB();
//        // Tạo đối tượng prepareStatement
//        String sql = "UPDATE product SET MaLSP='" + product.getMaLSP() +
//                "', TenSP='" + product.getTenSP() +
//                "', DonGia=" + product.getDonGia() +
//                ", SoLuong=" + product.getSoLuong() +
//                ", HinhAnh='" + product.getHinhAnh() +
//                "', TrangThai=" + product.getTrangthai() +
//                " WHERE MaSP='" + product.getMaSP() + "'";
//        // Set các giá trị cho các tham số
//        Boolean kq=con.sqlUpdate(sql);
//        con.closeConnection();
//        return kq; // Return the number of affected rows
//
//
//    }
//
//    public boolean updateTrangThai(String maSP, int trangThai) {
//        con= new ConnectionDB();
//        String sql = "UPDATE product SET TrangThai = "+trangThai+ "WHERE MaSP = "+maSP;
//        Boolean kq=con.sqlUpdate(sql);
//        con.sqlQuery(sql);
//        return kq;
//    }
//
//}
//
//

package Layout.models.BackEnd.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
import Layout.models.BackEnd.DTO.Product;

public class ProductDAO {

    private ConnectionDB con;
    ArrayList<Product> dssp = new ArrayList<Product>();

    public ProductDAO() {

    }

    public ArrayList readDB() {
        con = new ConnectionDB();
        ArrayList<Product> dssp = new ArrayList<>();
        try {
            String qry = "SELECT * FROM product";
            ResultSet rs = con.sqlQuery(qry);
            if (rs != null) {

                while (rs.next()) {
                    Product product = new Product();
                    product.getMaSP();
                    product.getMaLSP();
                    product.getTenSP();
                    product.getDonGia();
                    product.getSoLuong();
                    product.getHinhAnh();
                    product.getTrangthai();
                    dssp.add(product);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Khong tim thay du lieu !!");
        } finally {
            con.closeConnection();
        }
        return dssp;
    }

    public boolean getIdProduct(String id) {
        con = new ConnectionDB();
        String sql = "SELECT * FROM product WHERE MaSP = '" + id + "'";
        ResultSet rs = con.sqlQuery(sql);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Product> selectAll() {
        // Tạo danh sách kết quả lưu các danh sách khách hàng rồi in ra

        try {
            con = new ConnectionDB();

            String sql = "select* from product";
            ResultSet rs = con.sqlQuery(sql);

            // Lấy từng khách hàng từ rs cho vào kết quả
            while (rs.next()) {
                String maSP = rs.getString("MaSP");
                String MaLSP = rs.getString("MaLSP");
                String TenSP = rs.getString("TenSP");
                float dongia = rs.getFloat("DonGia");
                int soluong = rs.getInt("SoLuong");
                String Hinhanh = rs.getString("HinhAnh");
                int TrangThai = rs.getInt("TrangThai");

                Product nv = new Product(maSP, MaLSP, TenSP, dongia, soluong, Hinhanh, TrangThai);
                dssp.add(nv);
            }
            con.closeConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dssp;
    }

    public Boolean addDao(Product product) {
        con = new ConnectionDB();

        String sql = "INSERT INTO product (MaSP, MaLSP, TenSP, DonGia, SoLuong, HinhAnh, TrangThai) VALUES ('"
                + product.getMaSP() + "', '" + product.getMaLSP() +
                "', '" + product.getTenSP() + "', " + product.getDonGia() + ", " + product.getSoLuong() + ", '"
                + product.getHinhAnh() + "', '" + product.getTrangthai() + "')";
        Boolean result = con.sqlUpdate(sql);

        System.out.println("Thêm sản phẩm thành công!");
        con.closeConnection();
        return result;
    }

    public Boolean updateSoLuong(String MaSP, int SoLuong) {
        con = new ConnectionDB();
        Boolean ok = con.sqlUpdate("Update SanPham Set "
                + "SoLuong='" + SoLuong
                + "' where MaSP='" + MaSP + "'");
        con.closeConnection();
        return ok;
    }

    public Boolean update(Product product) {

        con = new ConnectionDB();
        // Tạo đối tượng prepareStatement
        String sql = "UPDATE product SET MaLSP='" + product.getMaLSP() +
                "', TenSP='" + product.getTenSP() +
                "', DonGia=" + product.getDonGia() +
                ", SoLuong=" + product.getSoLuong() +
                ", HinhAnh='" + product.getHinhAnh() +
                "', TrangThai=" + product.getTrangthai() +
                " WHERE MaSP='" + product.getMaSP() + "'";
        // Set các giá trị cho các tham số
        Boolean kq = con.sqlUpdate(sql);
        con.closeConnection();
        return kq; // Return the number of affected rows

    }

    public boolean updateTrangThai(String maSP, int trangThai) {
        con = new ConnectionDB();
        // Đảm bảo sử dụng dấu nháy đơn cho các giá trị chuỗi và thêm khoảng trắng vào
        // câu lệnh SQL
        String sql = "UPDATE product SET TrangThai = " + trangThai + " WHERE MaSP = '" + maSP + "'";
        boolean kq = con.sqlUpdate(sql);
        return kq;
    }

}
