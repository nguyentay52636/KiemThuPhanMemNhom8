package Layout.models.BackEnd.ManagerAccount;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManagerAccountDAO {
    ConnectionDB managerAccountConnection;

    public ManagerAccountDAO() {

    }

    public ArrayList<Account> readDataBase() {
        managerAccountConnection = new ConnectionDB();

        ArrayList<Account> danhSachTaiKhoan = new ArrayList<>();

        try {
            String qry = "SELECT * FROM taikhoan";
            ResultSet resultSet = managerAccountConnection.sqlQuery(qry);

            if (resultSet != null) {
                while (resultSet.next()) {
                    String ten = resultSet.getString("TenTaiKhoan");
                    String pass = resultSet.getString("MatKhau");
                    String manv = resultSet.getString("MaNV");
                    String maq = resultSet.getString("MaQuyen");

                    danhSachTaiKhoan.add(new Account(ten, pass, manv, manv));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "--ERROR! Lỗi đọc dữ liệu từ bảng tài khoản!");
        } finally {
            managerAccountConnection.closeConnection();
        }

        return danhSachTaiKhoan;
    }

    public Boolean add(Account account) {
        managerAccountConnection = new ConnectionDB();

        Boolean ans = managerAccountConnection.sqlUpdate("INSERT INTO 'taikhoan' (TenTaiKhoan', 'MatKhau', 'MaNV', 'MaQuyen') VALUES ('"
                + account.getUserName() + "', '" + account.getPassword() + "', '"
                + account.getMaNhanVien() + "', '" + account.getMaQuyen() + "');"
        );
        managerAccountConnection.closeConnection();
        return ans;
    }

    public Boolean delete(String username) {
        managerAccountConnection = new ConnectionDB();

        Boolean ans = managerAccountConnection.sqlUpdate("DELETE FROM 'taikhoan' WHERE 'taikhoan'.'TenTaiKhoan' = '" + username + "'");
        managerAccountConnection.closeConnection();
        return ans;
    }

    public Boolean update(String username, String pass, String maNV, String maQuyen) {
        managerAccountConnection = new ConnectionDB();

        Boolean ans = managerAccountConnection.sqlUpdate("UPDATE taikhoan SET MatKhau='" + pass + "', MaNV='" + maNV
                + "', MaQuyen='" + maQuyen + "' WHERE TenTaiKhoan='" + username + "'");
        managerAccountConnection.closeConnection();
        return ans;
    }

    public void close() {
        managerAccountConnection.closeConnection();
    }
}
