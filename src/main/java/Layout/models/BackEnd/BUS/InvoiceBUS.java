package Layout.models.BackEnd.BUS;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Layout.models.BackEnd.DAO.InvoiceDAO;
import Layout.models.BackEnd.DTO.Invoice;

public class InvoiceBUS {
    private static ArrayList<Invoice> listInvoice = new ArrayList<>();
    private InvoiceDAO invoiceDAO = new InvoiceDAO();

    public InvoiceBUS() {
        listInvoice = invoiceDAO.readDB();
    }

    public String[] getHeaders() {
        return new String[] { "Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Mã khuyến mãi", "Ngày lập", "Giờ lập",
                "Tổng tiền" };
    }

    public String getNextID() {
        return "HD" + String.valueOf(this.listInvoice.size() + 1);
    }

    public void readDB() {
        listInvoice = invoiceDAO.readDB();
    }

    public Invoice getInvoice(String idInvoice) {
        for (Invoice invoice : listInvoice) {
            if (invoice.getMaHoaDon().equals(idInvoice)) {
                return invoice;
            }
        }
        return null;
    }

    public Boolean addInvoiceBUS(Invoice invoice) {
        Boolean success = invoiceDAO.addInvoice(invoice);
        if (success) {
            listInvoice.add(invoice);
            return true;

        }
        return false;
    }

    public Boolean add(String maHoaDon, String maNhanVien, String maKhachHang, String makm, LocalDate ngayNhap,
            LocalTime gioNhap, float tongTien) {
        Invoice hd = new Invoice(maHoaDon, maNhanVien, maKhachHang, makm, ngayNhap, gioNhap, tongTien);
        return addInvoiceBUS(hd);
    }

    public Boolean updateInvoiceBUS(Invoice invoice) {
        Boolean success = invoiceDAO.update(invoice);
        if (success) {
            for (Invoice invoiceDTO : listInvoice) {
                if (invoiceDTO.getMaHoaDon().equals(invoice.getMaHoaDon())) {
                    invoiceDTO = invoice;

                }
            }
            return true;
        }
        return false;
    }

    public boolean checkInvoiceExist(String maHoaDon) {
        InvoiceDAO invoiceDAO = new InvoiceDAO();
        Invoice invoice = invoiceDAO.getInvoice(maHoaDon);

        return invoice != null;
    }

    public Boolean update(String maHoaDon, String maNhanVien, String maKhachHang, String makm, LocalDate ngayNhap,
            LocalTime gioNhap, float tongTien) {
        Invoice hd = new Invoice(maHoaDon, maNhanVien, maKhachHang, makm, ngayNhap, gioNhap, tongTien);

        return updateInvoiceBUS(hd);
    }

    public Boolean deleteInvoiceBUS(String idInvoice) {
        Boolean success = invoiceDAO.deleteInvoice(idInvoice);
        if (success) {
            for (Invoice invoice : listInvoice) {
                if (invoice.getMaHoaDon().equals(idInvoice)) {
                    listInvoice.remove(invoice);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Invoice> getListInvoice() {
        return listInvoice;
    }

    public InvoiceDAO getInvoiceDAO() {
        return invoiceDAO;
    }

    public Boolean updateTotalAmount(String idInvoice, float totalAmount) {
        Boolean success = invoiceDAO.updateTongTien(idInvoice, totalAmount);
        if (success) {
            for (Invoice invoice : listInvoice) {
                if (invoice.getMaHoaDon().equals(idInvoice)) {
                    invoice.setTongTien(totalAmount);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Invoice> searchByDate(LocalDate from, LocalDate to) {
        ArrayList<Invoice> result = new ArrayList<>();
        for (Invoice invoice : listInvoice) {
            if ((invoice.getNgayLap().isEqual(from)) || (invoice.getNgayLap().isAfter(from))
                    && (invoice.getNgayLap().isEqual(to)) || (invoice.getNgayLap().isBefore(to))) {
                result.add(invoice);
            }
        }
        return result;
    }

    public static ArrayList<Invoice> search(String keyword, String type) {
        ArrayList<Invoice> result = new ArrayList<>();
        listInvoice.forEach((hd) -> {
            switch (type) {
                case "Tất cả":
                    if (hd.getMaHoaDon().toLowerCase().contains(keyword.toLowerCase())
                            || hd.getMaNhanVien().toLowerCase().contains(keyword.toLowerCase())
                            || hd.getMaKhachHang().toLowerCase().contains(keyword.toLowerCase())
                            || hd.getMaKhuyenMai().toLowerCase().contains(keyword.toLowerCase())
                            || hd.getNgayLap().toString().toLowerCase().contains(keyword.toLowerCase())
                            || hd.getGioLap().toString().toLowerCase().contains(keyword.toLowerCase())
                            || String.valueOf(hd.getTongTien()).toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hd);
                    }
                    break;
                case "Mã hóa đơn":
                    if (hd.getMaHoaDon().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hd);
                    }
                    break;
                case "Mã nhân viên":
                    if (hd.getMaNhanVien().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hd);
                    }
                    break;
                case "Mã khách hàng":
                    if (hd.getMaKhachHang().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hd);
                    }
                    break;
                case "Mã khuyến mãi":
                    if (hd.getMaKhuyenMai().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hd);
                    }
                    break;
                case "Ngày lập":
                    if (hd.getNgayLap().toString().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hd);
                    }
                    break;
                case "Giờ lập":
                    if (hd.getGioLap().toString().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hd);
                    }
                    break;
                case "Tổng kết":
                    if (String.valueOf(hd.getTongTien()).toLowerCase().contains((keyword.toLowerCase()))) {
                        result.add(hd);
                    }
                    break;

            }
        });
        return result;
    }

}
