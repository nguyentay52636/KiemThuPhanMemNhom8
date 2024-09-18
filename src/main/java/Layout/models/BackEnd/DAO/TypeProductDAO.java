package Layout.models.BackEnd.DAO;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
import Layout.models.BackEnd.DTO.TypeProduct;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypeProductDAO {
    ConnectionDB qllspConnection;

    public TypeProductDAO() {

    }

    public ArrayList<TypeProduct> readDB() {
        qllspConnection = new ConnectionDB();

        ArrayList<TypeProduct> dslsp = new ArrayList<>();
        try {
            String qry = "SELECT * FROM type_product";
            ResultSet r = qllspConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String malsp = r.getString(1);
                    String tenlsp = r.getString(2);
                    String mota = r.getString(3);

                    dslsp.add(new TypeProduct(malsp, tenlsp, mota));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng loại sản phẩm");
        } finally {
            qllspConnection.closeConnection();
        }

        return dslsp;
    }

    public ArrayList<TypeProduct> search(String columnName, String value) {
        qllspConnection = new ConnectionDB();
        ArrayList<TypeProduct> dslsp = new ArrayList<>();

        try {
            String qry = "SELECT * FROM type_product WHERE " + columnName + " LIKE '%" + value + "%'";
            ResultSet r = qllspConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String malsp = r.getString(1);
                    String tenlsp = r.getString(2);
                    String mota = r.getString(3);

                    dslsp.add(new TypeProduct(malsp, tenlsp, mota));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu " + columnName + " = " + value + " bảng loại sản phẩm");
        } finally {
            qllspConnection.closeConnection();
        }

        return dslsp;
    }

    public Boolean add(TypeProduct typeProduct) {
        qllspConnection= new ConnectionDB();
        Boolean result = qllspConnection.sqlUpdate("INSERT INTO type_product (MaLSP,TenLSP,MoTa) VALUES ('"
                + typeProduct.getMaLoaiSanPham() + "','"
                + typeProduct.getTenLoaiSanPham() + "','"
                + typeProduct.getMoTa() + "')");

        qllspConnection.closeConnection();
        return result;
    }

    public boolean delete(String maLoaiSanPham) {
        qllspConnection = new ConnectionDB();
        Boolean result = qllspConnection.sqlUpdate("DELETE FROM type_product WHERE MaLSP = '" + maLoaiSanPham + "'");
        qllspConnection.closeConnection();
        return result;
    }

    public Boolean update(String maLoaiSanPham, String tenLoaiSanPham, String moTa) {
        qllspConnection = new ConnectionDB();
        Boolean ok = qllspConnection.sqlUpdate("Update type_product Set TenLSP='" + tenLoaiSanPham + "', MoTa='" + moTa + "' where MaLSP='" + maLoaiSanPham + "'");
        qllspConnection.closeConnection();
        return ok;
    }

    public void close() {
        qllspConnection.closeConnection();
    }
}
