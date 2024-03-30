package Layout.models.BackEnd.ManagerProduct;

public class Product {
    // san pham
    String masanpham, maloaisanpham, tensanpham, filenamehinhanh;
    float dongia;
    int soluong, trangthai;

    public Product(String masanpham, String maloaisanpham, String tensanpham, float dongia, int soluong, String filenamehinhanh, int trangthai) {
        this.masanpham = masanpham;
        this.maloaisanpham = maloaisanpham;
        this.tensanpham = tensanpham;
        this.filenamehinhanh = filenamehinhanh;
        this.dongia = dongia;
        this.soluong = soluong;
        this.trangthai = trangthai;
    }

    public String getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(String masanpham) {
        this.masanpham = masanpham;
    }

    public String getMaloaisanpham() {
        return maloaisanpham;
    }

    public void setMaloaisanpham(String maloaisanpham) {
        this.maloaisanpham = maloaisanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getFilenamehinhanh() {
        return filenamehinhanh;
    }

    public void setFilenamehinhanh(String filenamehinhanh) {
        this.filenamehinhanh = filenamehinhanh;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
}
