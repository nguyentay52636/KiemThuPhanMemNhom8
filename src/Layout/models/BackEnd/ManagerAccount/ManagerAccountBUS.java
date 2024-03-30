package Layout.models.BackEnd.ManagerAccount;

import com.mysql.cj.conf.url.XDevApiConnectionUrl;

import java.util.ArrayList;

public class ManagerAccountBUS {

    private ArrayList<Account> danhSachTaiKhoan = new ArrayList<>();

    ManagerAccountDAO managerAccountDAO = new ManagerAccountDAO();

    public ManagerAccountBUS() {
        danhSachTaiKhoan = managerAccountDAO.readDataBase();
    }

    public void showConsole() {
        danhSachTaiKhoan.forEach((account) -> {
            System.out.println(account.getUserName() + " " + account.getPassword() + " " + account.getMaNhanVien() + " " + account.getMaQuyen());
        });
    }

    public String[] getHeaders() {
        return new String[]{"Tên tài khoản", "Mật khẩu", "Mã nhân viên", "Mã quyền"};
    }

    public void readDataBase() {
        danhSachTaiKhoan = managerAccountDAO.readDataBase();
    }

    public Account getAccount(String username) {
        for (Account account : danhSachTaiKhoan) {
            if (account.getUserName().equals(username)) {
                return account;
            }
        }
        return null;
    }

    public ArrayList<Account> search(String value, String type) {
        ArrayList<Account> result = new ArrayList<>();

        danhSachTaiKhoan.forEach(account -> {
            if (type.equals("Tất cả")) {
                if (account.getUserName().toLowerCase().contains(value.toLowerCase())
                        || account.getPassword().toLowerCase().contains(value.toLowerCase())
                        || account.getMaNhanVien().toLowerCase().contains(value.toLowerCase())
                        || account.getMaQuyen().toLowerCase().contains(value.toLowerCase())) {
                    result.add(account);
                }
            } else {
                switch (type) {
                    case "Tên tài khoản":
                        if (account.getUserName().toLowerCase().contains(value.toLowerCase())) {
                            result.add(account);
                        }
                        break;
                    case "Mật khẩu":
                        if (account.getPassword().toLowerCase().contains(value.toLowerCase())) {
                            result.add(account);
                        }
                        break;
                    case "Mã nhân viên":
                        if (account.getMaNhanVien().toLowerCase().contains(value.toLowerCase())) {
                            result.add(account);
                        }
                        break;
                    case "Mã quyền":
                        if (account.getMaQuyen().toLowerCase().contains(value.toLowerCase())) {
                            result.add(account);
                        }
                        break;
                }
            }
        });
        return result;
    }

    public Boolean add(Account account) {
        Boolean ans = managerAccountDAO.add(account);
        if (ans) {
            danhSachTaiKhoan.add(account);
        }
        return ans;
    }

    public Boolean add(String username, String password, String maNhanVien, String maQuyen) {
        Account account = new Account(username, password, maNhanVien, maQuyen);
        return add(account);
    }

    public Boolean delete(String username) {
        Boolean ans = managerAccountDAO.delete(username);

        if (ans) {
            for (int i = (danhSachTaiKhoan.size() - 1); i >= 0; i--) {
                if (danhSachTaiKhoan.get(i).getUserName().equals(username)) {
                    danhSachTaiKhoan.remove(i);
                }
            }
        }
        return ans;
    }

    public Boolean update(String username, String password, String maNhanVien, String maQuyen) {
        Boolean ans = managerAccountDAO.update(username, password, maNhanVien, maQuyen);

        if (ans) {
            danhSachTaiKhoan.forEach(account -> {
                if (account.getUserName().equals(username)) {
                    account.setPassword(password);
                    account.setMaNhanVien(maNhanVien);
                    account.setMaQuyen(maQuyen);
                }
            });
        }
        return ans;
    }

    public ArrayList<Account> getDanhSachTaiKhoan() {
        return danhSachTaiKhoan;
    }
}
