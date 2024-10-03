package Layout.models.BackEnd.BUS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
import Layout.models.BackEnd.DAO.AccountDAO;
import Layout.models.BackEnd.DTO.Account;

public class AccountBUS {
    private ArrayList<Account> dstk = new ArrayList<>();
    AccountDAO qltkDAO = new AccountDAO();
    ConnectionDB connectionDB = new ConnectionDB();

    public AccountBUS() {
        dstk = qltkDAO.readDB();
    }

    // public void showConsole() {
    // dstk.forEach((tk) -> {
    // System.out.print(tk.getUsername() + " ");
    // System.out.print(tk.getPassword() + " ");
    // System.out.println(tk.getMaNV() + " ");
    // System.out.println(tk.getMaQuyen());
    // });
    // }

    public String[] getHeaders() {
        return new String[] { "Email", "Tên tài khoản", "Mật khẩu", "Mã nhân viên", "Mã quyền" };
    }

    public void readDB() {
        dstk = qltkDAO.readDB();
    }

    public Account getTaiKhoan(String tentk) {
        for (Account tk : dstk) {
            if (tk.getUsername().equals(tentk)) {
                return tk;
            }
        }
        return null;
    }

    public ArrayList<Account> search(String value, String type) {
        ArrayList<Account> result = new ArrayList<>();

        dstk.forEach((tk) -> {
            if (type.equals("Tất cả")) {

                if (tk.getEmail().toLowerCase().contains(value.toLowerCase())
                        || tk.getUsername().toLowerCase().contains(value.toLowerCase())
                        || tk.getPassword().toLowerCase().contains(value.toLowerCase())
                        || tk.getMaNV().toLowerCase().contains(value.toLowerCase())
                        || tk.getMaQuyen().toLowerCase().contains(value.toLowerCase())) {
                    result.add(tk);
                }
            } else {
                switch (type) {
                    case "Email":
                        if (tk.getEmail().toLowerCase().contains(value.toLowerCase())) {
                            result.add(tk);
                        }
                    case "Tên tài khoản":
                        if (tk.getUsername().toLowerCase().contains(value.toLowerCase())) {
                            result.add(tk);
                        }
                        break;
                    case "Mật khẩu":
                        if (tk.getPassword().toLowerCase().contains(value.toLowerCase())) {
                            result.add(tk);
                        }
                        break;
                    case "Mã nhân viên":
                        if (tk.getMaNV().toLowerCase().contains(value.toLowerCase())) {
                            result.add(tk);
                        }
                        break;
                    case "Mã quyền":
                        if (tk.getMaQuyen().toLowerCase().contains(value.toLowerCase())) {
                            result.add(tk);
                        }
                        break;
                }
            }

        });

        return result;
    }

    // lay tat ca account
    public ArrayList<Account> getAllAccounts() {
        ArrayList<Account> result = new ArrayList<>();
        String query = "SELECT a.* " +
                "FROM account a " +
                "JOIN employee e ON a.MaNV = e.MaNV ";

        try {
            Connection connection = connectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Account account = new Account(resultSet.getString("email"), resultSet.getString("TenTaiKhoan"),
                        resultSet.getString("MatKhau"), resultSet.getString("MaNV"), resultSet.getString("MaQuyen"));
                result.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // lay trang thai cua nhan vien la 0
    public ArrayList<Account> getAccountsByEmployeeStatus() {
        ArrayList<Account> result = new ArrayList<>();
        String query = "SELECT a.* " +
                "FROM account a " +
                "JOIN employee e ON a.MaNV = e.MaNV " +
                "WHERE e.TrangThai = 0";

        try {
            Connection connection = connectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Account account = new Account(rs.getString("email"), rs.getString("TenTaiKhoan"),
                        rs.getString("MatKhau"),
                        rs.getString("MaNV"), rs.getString("MaQuyen"));
                result.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // lay trang thai cua nhan vien la 1
    public ArrayList<Account> getInactiveAccountsByEmployeeStatus() {
        ArrayList<Account> result = new ArrayList<>();
        String query = "SELECT a.* " +
                "FROM account a " +
                "JOIN employee e on a.MaNV = e.MaNV " +
                "WHERE e.TrangThai = 1";

        try {
            Connection connection = connectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Account account = new Account(resultSet.getString("email"), resultSet.getString("TenTaiKhoan"),
                        resultSet.getString("MatKhau"),
                        resultSet.getString("MaNV"), resultSet.getString("MaQuyen"));
                result.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Boolean add(Account tk) {
        Boolean ok = qltkDAO.add(tk);

        if (ok) {
            dstk.add(tk);
        }
        return ok;
    }

    public Boolean add(String email, String username, String pass, String maNV, String maQuyen) {
        Account tk = new Account(email, username, pass, maNV, maQuyen);
        return add(tk);
    }

    public Boolean delete(String username) {
        Boolean ok = qltkDAO.delete(username);

        if (ok) {
            for (int i = (dstk.size() - 1); i >= 0; i--) {
                if (dstk.get(i).getUsername().equals(username)) {
                    dstk.remove(i);
                }
            }
        }
        return ok;
    }

    public Boolean update(String Email, String username, String pass, String maNV, String maQuyen) {
        Boolean ok = qltkDAO.update(Email, username, pass, maNV, maQuyen);

        if (ok) {
            dstk.forEach((tk) -> {
                if (tk.getUsername().equals(username)) {
                    tk.setPassword(pass);
                    tk.setMaNV(maNV);
                    tk.setMaQuyen(maQuyen);
                }
            });
        }

        return ok;
    }

    public ArrayList<Account> getDstk() {
        return dstk;
    }
}
