package Layout.models.BackEnd.ManagerCustomer;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
import Layout.models.BackEnd.ManagerAccount.ManagerAccountDAO;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManagerCustomerDAO {
    ConnectionDB managerCustomerConnection = new ConnectionDB();

    public ManagerCustomerDAO() {

    }

    public ArrayList<Customer> readDataBase() {
        managerCustomerConnection = new ConnectionDB();

        ArrayList<Customer> listCustomer = new ArrayList<>();

        try {
            String query = "SELECT * FROM khachhang";
            ResultSet resultSet = managerCustomerConnection.sqlQuery(query);

            if (resultSet != null) {
                while (resultSet.next()) {
                    String makh = resultSet.getString("MaKH");
                    String tenkh = resultSet.getString("TenKH");
                    String diachi = resultSet.getString("DiaChi");
                    String sdt = resultSet.getString("SDT");
                    int trangthai = resultSet.getInt("TrangThai");

                    listCustomer.add(new Customer(makh, tenkh, diachi, sdt, trangthai));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "--ERROR! Lỗi đọc dữ liệu từ bảng khách hàng!");
        } finally {
            managerCustomerConnection.closeConnection();
        }

        return listCustomer;
    }

    public ArrayList<Customer> search(String columnName, String value) {
        managerCustomerConnection = new ConnectionDB();
        ArrayList<Customer> listCustomer = new ArrayList<>();

        try {
            String query = "SELECT * FROM khachhang WHERE " + columnName + " LIKE '%" + value + "%'";
            ResultSet resultSet = managerCustomerConnection.sqlQuery(query);

            if (resultSet != null) {
                while (resultSet.next()) {
                    String makh = resultSet.getString("MaKH");
                    String tenkh = resultSet.getString("TenKH");
                    String diachi = resultSet.getString("DiaChi");
                    String sdt = resultSet.getString("SDT");
                    int trangthai = resultSet.getInt("TrangThai");

                    listCustomer.add(new Customer(makh, tenkh, diachi, sdt, trangthai));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "--ERROR! Lỗi đọc dữ liệu " + columnName + " = " + value +  " từ bảng khách hàng!");
        } finally {
            managerCustomerConnection.closeConnection();
        }

        return listCustomer;
    }

    public Boolean add(Customer customer) {
        managerCustomerConnection = new ConnectionDB();

        Boolean ans = managerCustomerConnection.sqlUpdate("INSERT INTO 'khachhang' ('MaKH', 'TenKH', 'DiaChi', 'SDT', 'TrangThai') VALUES ('"
                + customer.getMaKH() + "', '" + customer.getTenKH() + "', '"
                + customer.getDiaChi() + "', '" + customer.getSdt() + "', '" + customer.getTrangThai() + "');"
        );

        managerCustomerConnection.closeConnection();
        return ans;
    }

    public Boolean delete(String makh) {
        managerCustomerConnection = new ConnectionDB();

        Boolean ans = managerCustomerConnection.sqlUpdate("DELETE FROM 'khachhang' WHERE 'khachhang'.'MaKH' = '" + makh + "'");
        managerCustomerConnection.closeConnection();

        return ans;
    }

    public Boolean update(String makh, String tenkh, String diachi, String sdt, int trangthai) {
        managerCustomerConnection = new ConnectionDB();

        Boolean ans = managerCustomerConnection.sqlUpdate("Update KhachHang Set "
                + "TenKH='" + tenkh + "', DiaChi='" + diachi + "', SDT='" + sdt + "', TrangThai='" + trangthai + "' WHERE MaKH='" + makh + "'");

        managerCustomerConnection.closeConnection();
        return ans;
    }

    public Boolean updateTrangThai(String makh, int trangthai) {
        managerCustomerConnection = new ConnectionDB();

        Boolean ans = managerCustomerConnection.sqlUpdate("Update KhachHang Set " + "TrangThai='" + trangthai + "' WHERE MaKH='" + makh + "'");
        managerCustomerConnection.closeConnection();

        return ans;
    }

    public void close() {
        managerCustomerConnection.closeConnection();
    }
}
