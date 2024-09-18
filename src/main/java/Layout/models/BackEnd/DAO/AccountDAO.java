package Layout.models.BackEnd.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
import Layout.models.BackEnd.DTO.Account;

public class AccountDAO {
    ConnectionDB qltkConnectiion;

    public AccountDAO() {

    }

    public ArrayList<Account> readDB() {
        qltkConnectiion = new ConnectionDB();
        ArrayList<Account> dstk = new ArrayList<>();
        try {
            String qry = "SELECT * FROM account";
            ResultSet r = qltkConnectiion.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String email = r.getString("email");
                    String ten = r.getString("TenTaiKhoan");
                    String pass = r.getString("MatKhau");
                    String manv = r.getString("MaNV");
                    String maquyen = r.getString("MaQuyen");

                    dstk.add(new Account(email, ten, pass, manv, maquyen));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng tài khoản");
        } finally {
            qltkConnectiion.closeConnection();
        }
        return dstk;
    }
    // lay email

    public Boolean add(Account tk) {
        qltkConnectiion = new ConnectionDB();
        Boolean ok = qltkConnectiion.sqlUpdate("INSERT INTO account (TenTaiKhoan, MatKhau, MaNV, MAQuyen) VALUES ('"
                + tk.getUsername() + "', '" + tk.getPassword() + "', '" + tk.getMaNV() + "', '" + tk.getMaQuyen()
                + "');");
        qltkConnectiion.closeConnection();
        return ok;
    }

    public Boolean delete(String username) {
        qltkConnectiion = new ConnectionDB();
        Boolean ok = qltkConnectiion.sqlUpdate("DELETE FROM account WHERE account.TenTaiKhoan = '" + username + "'");
        qltkConnectiion.closeConnection();
        return ok;
    }

    public Boolean update(String username, String pass, String maNV, String maQuyen) {
        qltkConnectiion = new ConnectionDB();
        Boolean ok = qltkConnectiion.sqlUpdate("Update account Set MatKhau='" + pass + "',MaNV='" + maNV
                + "',MaQuyen='" + maQuyen + "' where TenTaiKhoan='" + username + "'");
        qltkConnectiion.closeConnection();
        return ok;
    }

    public void close() {
        qltkConnectiion.closeConnection();
    }

    public Boolean updatePasswordByEmail(String email, String newPassword) {
        qltkConnectiion = new ConnectionDB();
        Boolean ok = false;
        String qry = "UPDATE account SET MatKhau = ? WHERE email = ?";
        try (Connection conn = qltkConnectiion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(qry)) {
            if (checkEmailExists(email) != null) {
                pstmt.setString(1, newPassword); // Gán giá trị cho tham số thứ nhất
                pstmt.setString(2, email); // Gán giá trị cho tham số thứ hai
                int rowsAffected = pstmt.executeUpdate();
                ok = rowsAffected > 0;
            } else {
                System.out.println("Không tìm thấy email trong cơ sở dữ liệu.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            qltkConnectiion.closeConnection();
        }
        return ok;
    }

    public Account checkEmailExists(String email) {
        ArrayList<Account> accounts = readDB();
        for (Account ac : accounts) {
            if (ac.getEmail().equals(email)) {
                {
                    return ac;
                }

            }
        }
        return null;
    }
}
