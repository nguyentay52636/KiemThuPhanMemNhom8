
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
