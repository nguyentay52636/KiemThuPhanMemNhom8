package Layout.models.BackEnd.ManagerInvoice;

import java.time.LocalDate;
import java.time.LocalTime;

public class Invoice {
    // hoa don
    private String maHD = "";
    private String maNV = "";
    private String maKH = "";
    private String maKM = "";
    private LocalDate ngayLap;
    private LocalTime gioLap;
    private float tongtien = 0;

    public Invoice() {
        ngayLap = LocalDate.now();
        gioLap = LocalTime.now();
    }

    public Invoice(String maHD, String maNV, String maKH, String maKM, LocalDate ngayLap, LocalTime gioLap, float tongtien) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.maKM = maKM;
        this.ngayLap = ngayLap;
        this.gioLap = gioLap;
        this.tongtien = tongtien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
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

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }
}
