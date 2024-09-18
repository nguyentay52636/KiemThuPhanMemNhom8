package Layout.models.BackEnd.DTO;

import java.time.LocalDate;

public class Promotion {
    String maKhuyenMai, tenKhuyenMai;
    float dieuKienKhuyenMai, phanTramKhuyenMai;
    LocalDate ngayBatDau, ngayKetThuc;

    private String trangThai;

    public Promotion(String maKhuyenMai, String tenKhuyenMai, float dieuKienKhuyenMai, float phanTramKhuyenMai, LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        this.maKhuyenMai = maKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.dieuKienKhuyenMai = dieuKienKhuyenMai;
        this.phanTramKhuyenMai = phanTramKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public Promotion(String maKhuyenMai, String tenKhuyenMai, float dieuKienKhuyenMai, float phanTramKhuyenMai, LocalDate ngayBatDau, LocalDate ngayKetThuc, String trangThai) {
        this.maKhuyenMai = maKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.dieuKienKhuyenMai = dieuKienKhuyenMai;
        this.phanTramKhuyenMai = phanTramKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
    }

    public String getTrangThai() {
        LocalDate dayNow = LocalDate.now();
        if (dayNow.isBefore(this.ngayBatDau)) {
            return "Chưa bắt đầu";
        } else if (dayNow.isAfter(this.ngayKetThuc)) {
            return "Đã kết thúc";
        } else {
            return "Đang diễn ra";
        }
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public float getDieuKienKhuyenMai() {
        return dieuKienKhuyenMai;
    }

    public void setDieuKienKhuyenMai(float dieuKienKhuyenMai) {
        this.dieuKienKhuyenMai = dieuKienKhuyenMai;
    }

    public float getPhanTramKhuyenMai() {
        return phanTramKhuyenMai;
    }

    public void setPhanTramKhuyenMai(float phanTramKhuyenMai) {
        this.phanTramKhuyenMai = phanTramKhuyenMai;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
