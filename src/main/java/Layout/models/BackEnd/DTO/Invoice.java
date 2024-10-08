package Layout.models.BackEnd.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class Invoice {

    private String maHoaDon = "";
    private String maNhanVien = "";
    private String maKhachHang = "";
    private String maKhuyenMai = "";
    private LocalDate ngayLap;
    private LocalTime gioLap;
    private float TongTien = 0;

    public Invoice() {
        this.ngayLap = LocalDate.now();
        this.gioLap = LocalTime.now();
    }

    public Invoice(String maHoaDon, String maNhanVien, String maKhachHang, String maKhuyenMai, LocalDate ngayNhap,
                      LocalTime gioNhap, float tongTien) {
        this.maHoaDon = maHoaDon;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.maKhuyenMai = maKhuyenMai;
        this.ngayLap = ngayNhap;
        this.gioLap = gioNhap;
        this.TongTien = tongTien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public LocalTime getGioLap() {
        return gioLap;
    }

    public void setGioLap(LocalTime gioLap) {
        this.gioLap = gioLap;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }
    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }
    public String getMaKhuyenMai() {

        return maKhuyenMai;
    }



}
