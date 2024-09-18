package Layout.models.BackEnd.DTO;

public class Account {
    String email, username, password, maNV, maQuyen;

    public Account(String email, String username, String password, String maNV, String maQuyen) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.maNV = maNV;
        this.maQuyen = maQuyen;
    }

    public Account() {

    }

    public String getMaNV() {
        return maNV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(String maQuyen) {
        this.maQuyen = maQuyen;
    }
}
