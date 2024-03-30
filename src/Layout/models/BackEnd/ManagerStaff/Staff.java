package Layout.models.BackEnd.ManagerStaff;

import java.time.LocalDate;

public class Staff
{
    // nhan vien
    String manhanvien, tennhanvien, diachi, sdt;
    LocalDate ngaysinh;
    int trangthai;

    public Staff(String manhanvien, String tennhanvien, String diachi, String sdt, LocalDate ngaysinh, int trangthai) {
        this.manhanvien = manhanvien;
        this.tennhanvien = tennhanvien;
        this.diachi = diachi;
        this.sdt = sdt;
        this.ngaysinh = ngaysinh;
        this.trangthai = trangthai;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public LocalDate getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(LocalDate ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
}
