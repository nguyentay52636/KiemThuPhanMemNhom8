package Layout.models.BackEnd.ManagerInvoice;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ManagerInvoiceBUS {
    // quan ly hao don BUS
    ArrayList<Invoice> listInvoice = new ArrayList<>();
    private ManagerInvoiceDAO managerInvoiceDAO = new ManagerInvoiceDAO();

    public ManagerInvoiceBUS() {
        listInvoice = managerInvoiceDAO.readDataBase();
    }

    public ArrayList<Invoice> getListInvoice() {
        return this.listInvoice;
    }

    public void readDataBase() {
        listInvoice = managerInvoiceDAO.readDataBase();
    }

    public String[] getHeaders() {
        return new String[]{"Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Mã khuyến mãi", "Ngày lập", "Giờ lập", "Tổng tiền"};
    }

    public String getNextID() {
        return "HD" + String.valueOf(this.listInvoice.size() + 1);
    }

    public Invoice getInvoice(String mahd) {
        for (Invoice hd : listInvoice) {
            if (hd.getMaHD().equals(mahd)) {
                return hd;
            }
        }
        return null;
    }

    public Boolean add(Invoice hd) {
        Boolean success = managerInvoiceDAO.add(hd);
        if (success) {
            listInvoice.add(hd);
            return true;
        }
        return false;
    }

    public Boolean add(String mahoadon, String manhanvien, String makhachhang, String makhuyenmai, LocalDate ngaylap, LocalTime giolap, float tongtien) {
        Invoice hd = new Invoice(mahoadon, manhanvien, makhachhang, makhuyenmai, ngaylap, giolap, tongtien);
        return add(hd);
    }
    
    public Boolean update(String mahoadon, String manhanvien, String makhachhang, String makhuyenmai, LocalDate ngaylap, LocalTime giolap, float tongtien) {
        Invoice hd = new Invoice(mahoadon, manhanvien, makhachhang, makhuyenmai, ngaylap, giolap, tongtien);
        return update(hd);
    }

    private Boolean update(Invoice invoice) {
        Boolean success = managerInvoiceDAO.update(invoice);

        if (success) {
            for (Invoice invoiceDetails : listInvoice) {
                if (invoiceDetails.getMaHD().equals(invoice.getMaHD())) {
                    invoiceDetails = invoice;
                }
            }
            return true;
        }
        return false;
    }

    public Boolean updateTongTien(String mahd, float tongtien) {
        Boolean success = managerInvoiceDAO.updateTongTien(mahd, tongtien);

        if (success) {
            for (Invoice invoiceDetails : listInvoice) {
                if (invoiceDetails.getMaHD().equals(mahd)) {
                    invoiceDetails.setTongtien(tongtien);
                }
            }
            return true;
        }
        return false;
    }

    public Boolean delete(String mahd) {
        Boolean success = managerInvoiceDAO.delete(mahd);
        if (success) {
            for (Invoice hd : listInvoice) {
                if (hd.getMaHD().equals(mahd)) {
                    listInvoice.remove(hd);
                    break;
                }
            }
            return true;
        }
        return false;
    }

    public ArrayList<Invoice> search(String type, String keyword, LocalDate ngay1, LocalDate ngay2, int tong1, int tong2) {
        ArrayList<Invoice> result = new ArrayList<>();

        listInvoice.forEach(invoice -> {
            switch (type) {
                case "Tất cả":
                    if (invoice.getMaHD().toLowerCase().contains(keyword.toLowerCase())
                            || invoice.getMaNV().toLowerCase().contains(keyword.toLowerCase())
                            || invoice.getMaKH().toLowerCase().contains(keyword.toLowerCase())
                            || invoice.getMaKM().toLowerCase().contains(keyword.toLowerCase())
                            || invoice.getNgayLap().toString().toLowerCase().contains(keyword.toLowerCase())
                            || invoice.getGioLap().toString().toLowerCase().contains(keyword.toLowerCase())
                            || String.valueOf(invoice.getTongtien()).toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(invoice);
                    }
                    break;
                case "Mã hóa đơn":
                    if (invoice.getMaHD().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(invoice);
                    }
                    break;
                case "Mã nhân viên":
                    if (invoice.getMaNV().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(invoice);
                    }
                    break;
                case "Mã khách hàng":
                    if (invoice.getMaKH().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(invoice);
                    }
                    break;
                case "Mã khuyến mãi":
                    if (invoice.getMaKM().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(invoice);
                    }
                    break;
                case "Ngày lập":
                    if (invoice.getNgayLap().toString().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(invoice);
                    }
                    break;
                case "Giờ lập":
                    if (invoice.getGioLap().toString().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(invoice);
                    }
                    break;
                case "Tổng tiền":
                    if (String.valueOf(invoice.getTongtien()).toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(invoice);
                    }
                    break;
            }
        });

        for (int i = result.size() - 1; i >= 0; i--){
            Invoice invoice = result.get(i);
            LocalDate ngayLap = invoice.getNgayLap();
            float tongTien = invoice.getTongtien();

            Boolean ngayKhongThoa = (ngay1 != null && ngayLap.isBefore(ngay1)) || (ngay2 != null && ngayLap.isAfter(ngay2));
            Boolean tienKhongThoa = (tong1 != -1 && tongTien < tong1) || (tong2 != -1 && tongTien > tong2);

            if (ngayKhongThoa || tienKhongThoa) {
                result.remove(invoice);
            }
        }
        return result;
    }
}

