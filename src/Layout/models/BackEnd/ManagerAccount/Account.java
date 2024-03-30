package Layout.models.BackEnd.ManagerAccount;

public class Account {
    String userName, password, maNhanVien, maQuyen;

    public Account(String userName, String password, String maNhanVien, String maQuyen) {
        this.userName = userName;
        this.password = password;
        this.maNhanVien = maNhanVien;
        this.maQuyen = maQuyen;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(String maQuyen) {
        this.maQuyen = maQuyen;
    }
}
