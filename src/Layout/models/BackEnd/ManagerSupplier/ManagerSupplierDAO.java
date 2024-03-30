package Layout.models.BackEnd.ManagerSupplier;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManagerSupplierDAO {
    ConnectionDB managerSupplierConnection;

    public ArrayList<Supplier> readDateBase() {
        ArrayList<Supplier> listSupplier = new ArrayList<>();

        managerSupplierConnection = new ConnectionDB();

        try {
            String query = "SELECT * FROM nhacungcap";
            ResultSet resultSet = managerSupplierConnection.sqlQuery(query);

            if (resultSet != null) {
                while (resultSet.next()) {
                    String mancc = resultSet.getString(1);
                    String tenncc = resultSet.getString(2);
                    String diachi = resultSet.getString(3);
                    String sdt = resultSet.getString(4);
                    String fax = resultSet.getString(5);

                    listSupplier.add(new Supplier(mancc, tenncc, diachi, sdt, fax));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không đọc được dữ liệu từ bảng nhà cung cấp !!");
        } finally {
            managerSupplierConnection.closeConnection();
        }
        return listSupplier;
    }

    public ArrayList<Supplier> search(String columnName, String value) {
        managerSupplierConnection = new ConnectionDB();
        ArrayList<Supplier> listSupplier = new ArrayList<>();

        try {
            String query = "SELECT * FROM nhacungcap WHERE " + columnName + " LIKE '%" + value + "%'";
            ResultSet resultSet = managerSupplierConnection.sqlQuery(query);

            if (resultSet != null) {
                while (resultSet.next()) {
                    String mancc = resultSet.getString(1);
                    String tenncc = resultSet.getString(2);
                    String diachi = resultSet.getString(3);
                    String sdt = resultSet.getString(4);
                    String fax = resultSet.getString(5);

                    listSupplier.add(new Supplier(mancc, tenncc, diachi, sdt, fax));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không đọc được dữ liệu từ bảng nhà cung cấp !!");
        } finally {
            managerSupplierConnection.closeConnection();
        }
        return listSupplier;
    }

    public Boolean add(Supplier supplier) {
        managerSupplierConnection = new ConnectionDB();

        Boolean success = managerSupplierConnection.sqlUpdate("INSERT INTO 'nhacungcap' ('MaNCC', 'TenNCC', 'DiaChi', 'SDT', 'Fax') VALUES ('"
                + supplier.getMaNhaCungCap() + "', '"
                + supplier.getTenNhaCungCap() + "', '"
                + supplier.getDiaChi() + "', '"
                + supplier.getSoDienThoai() + "', '"
                + supplier.getFax() + "')");

        managerSupplierConnection.closeConnection();
        return success;
    }

    public Boolean delete(String manhacungcap) {
        managerSupplierConnection = new ConnectionDB();

        Boolean success = managerSupplierConnection.sqlUpdate("DELETE FROM nhacungcap WHERE MaNCC = '" + manhacungcap + "'");

        managerSupplierConnection.closeConnection();
        return success;
    }

    public Boolean update(String manhacungcap, String tennhacungcap, String diachi, String sdt, String fax) {
        managerSupplierConnection = new ConnectionDB();

        Boolean success = managerSupplierConnection.sqlUpdate("UPDATE nhacungcap SET TenNCC = '" + tennhacungcap + "', DiaChi = '" + diachi + "', SDT = '" + sdt + "', Fax = '" + fax + "' WHERE MaNCC = '" + manhacungcap + "'");
        managerSupplierConnection.closeConnection();
        return success;
    }

    public void close() {
        managerSupplierConnection.closeConnection();
    }
}
