package Layout.models.BackEnd.DTO;

public class Permission {

    String MaQuyen, TenQuyen, ChiTietQuyen;

    public Permission(String maquyen, String tenquyen, String chitietquyen) {
        this.MaQuyen = maquyen;
        this.TenQuyen = tenquyen;
        this.ChiTietQuyen = chitietquyen;
    }

    public String getTenQuyen() {
        return TenQuyen;
    }

    public void setTenQuyen(String TenQuyen) {
        this.TenQuyen = TenQuyen;
    }

    public String getMaQuyen() {
        return MaQuyen;
    }

    public void setMaQuyen(String MaQuyen) {
        this.MaQuyen = MaQuyen;
    }

    public String getChiTietQuyen() {
        return ChiTietQuyen;
    }

    public void setChiTietQuyen(String ChiTietQuyen) {
        this.ChiTietQuyen = ChiTietQuyen;
    }
}
