
package Layout.models.BackEnd.BUS;

import Layout.models.BackEnd.DAO.InvoiceDetailDAO;
import Layout.models.BackEnd.DTO.InvoiceDetail;
import Layout.models.BackEnd.DTO.Product;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.BoldAction;

public class InvoiceDetailBUS {
    private InvoiceDetailDAO invoiceDetailsDAO = new InvoiceDetailDAO();
    private static ArrayList<InvoiceDetail> listInvoiceDetails = new ArrayList<>();
    private ProductBUS productBUS = new ProductBUS();
    private InvoiceBUS invoiceBUS = new InvoiceBUS();

    public InvoiceDetailBUS() {
        listInvoiceDetails = invoiceDetailsDAO.readBD();
    }

    public String[] getHeaders() {
        return new String[] { "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền" };
    };

    public void readDB() {
        listInvoiceDetails = invoiceDetailsDAO.readBD();
    }

    public ArrayList<InvoiceDetail> getListInvoiceDetails() {
        return this.listInvoiceDetails;
    }

    public ArrayList<InvoiceDetail> getInvoiceDetailsByMaHD(String maHD) {
        ArrayList<InvoiceDetail> result = new ArrayList<>();
        for (InvoiceDetail detail : listInvoiceDetails) {
            if (detail.getMaHoaDon().equals(maHD)) {
                result.add(detail);
            }
        }
        return result;
    }

    public InvoiceDetail getDetailsInvoice(String maHD, String maSP) {
        for (InvoiceDetail i : listInvoiceDetails) {
            if (i.getMaHoaDon().equals(maHD) && i.getMaSanPham().equals(maSP)) {
                return i;
            }
        }
        return null;
    }

    public ArrayList<InvoiceDetail> listInvoideDetails(String maHD) {
        ArrayList<InvoiceDetail> result = new ArrayList<>();
        for (InvoiceDetail i : listInvoiceDetails) {
            if (i.getMaHoaDon().equals(maHD)) {
                result.add(i);
            }
        }
        return result;
    }

    public Boolean add(InvoiceDetail invoice) {
        int soLuong = invoice.getSoLuong();
        ArrayList<InvoiceDetail> toRemote = new ArrayList<>();
        // tìm các chi tiết cùng mã, và tính tổng số lượng
        int tongSoLuong = invoice.getSoLuong();
        for (InvoiceDetail i : listInvoiceDetails) {
            if (i.getMaHoaDon().equals(invoice.getMaHoaDon()) && i.getMaSanPham().equals(invoice.getMaSanPham())) {
                tongSoLuong += i.getSoLuong();
                toRemote.add(i);
            }
            listInvoiceDetails.removeAll(toRemote);
            invoiceDetailsDAO.delete(invoice.getMaHoaDon(), invoice.getMaSanPham());
            invoice.setSoLuong(tongSoLuong);
            Boolean success = invoiceDetailsDAO.add(invoice);
            if (success) {
                listInvoiceDetails.add(invoice);
                updateQuantityProduct(invoice.getMaSanPham(), -soLuong);
                return true;
            }

        }
        return null;
    }


    private Boolean updateQuantityProduct(String maSP, int newQuantity) {
        for (Product product : productBUS.getList()) {
            if (product.getMaSP().equals(maSP)) {
                // return productBUS.(maSP, product.getSoLuong() + newQuantity);

            }
        }
        return false;
    }

    private Boolean updateTotalAmount(String maHD) {
        float Total = 0;
        for (InvoiceDetail i : listInvoiceDetails) {
            if (i.getMaHoaDon().equals(maHD)) {
                Total += ((i.getSoLuong()) * (i.getDonGia()));
            }
        }
        Boolean success = invoiceBUS.updateTotalAmount(maHD, Total);
        return success;
    }

    public Boolean update(InvoiceDetail invoice) {
        Boolean success = invoiceDetailsDAO.update(invoice);
        for (InvoiceDetail i : listInvoiceDetails) {
            if (i.getMaHoaDon().equals(invoice.getMaHoaDon())) {
                i = invoice;
            }
        }
        updateTotalAmount(invoice.getMaHoaDon());
        return success;
    }

    public Boolean delete(String maHD, String maSP) {
        Boolean success = invoiceDetailsDAO.delete(maHD, maSP);
        if (success) {
            for (InvoiceDetail i : listInvoiceDetails) {
                if (i.getMaHoaDon().equals(maHD) && i.getMaSanPham().equals(maSP)) {
                    updateQuantityProduct(maSP, i.getSoLuong());
                    listInvoiceDetails.remove(i);
                    updateTotalAmount(maHD);
                    return true;

                }
            }
        }
        return false;

    }

    public Boolean deleteAll(String maHD) {
        Boolean success = invoiceDetailsDAO.deleteAll(maHD);
        if (success) {
            for (InvoiceDetail i : listInvoiceDetails) {
                if (i.getMaHoaDon().equals(maHD)) {
                    listInvoiceDetails.remove(i);

                }
            }
            updateTotalAmount(maHD);
            return true;
        }
        return false;
    }

    public static ArrayList<InvoiceDetail> search(String type, String keyword) {
        ArrayList<InvoiceDetail> result = new ArrayList<>();

        listInvoiceDetails.forEach((hd) -> {
            switch (type) {
                case "Tất cả":
                    if (hd.getMaHoaDon().toLowerCase().contains(keyword.toLowerCase())
                            || hd.getMaSanPham().toLowerCase().contains(keyword.toLowerCase())
                            || String.valueOf(hd.getSoLuong()).toLowerCase().contains(keyword.toLowerCase())
                            || String.valueOf(hd.getDonGia()).toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hd);
                    }

                    break;

                case "Mã sản phẩm":
                    if (hd.getMaSanPham().toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hd);
                    }
                    break;

                case "Số lượng":
                    if (String.valueOf(hd.getSoLuong()).toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hd);
                    }
                    break;

                case "Đơn giá":
                    if (String.valueOf(hd.getDonGia()).toLowerCase().contains(keyword.toLowerCase())) {
                        result.add(hd);
                    }
                    break;
                case "Thành tiền":
                    if (String.valueOf(hd.getDonGia() * hd.getSoLuong()).toLowerCase()
                            .contains(keyword.toLowerCase())) {
                        result.add(hd);
                    }
                    break;
            }
        });

        // for (int i = result.size() - 1; i >= 0; i--) {
        // InvoiceDetailDTO ct = result.get(i);
        // int sl = ct.getSoLuong();
        // float tt = ct.getDonGia() * sl;
        //
        //// Boolean soLuongKhongThoa = (soLuong1 != -1 && sl < soLuong1) || (soLuong2
        // != -1 && sl > soLuong2);
        //// Boolean donGiaKhongThoa = (thanhTien1 != -1 && tt < thanhTien1) ||
        // (thanhTien2 != -1 && tt > thanhTien2);
        //
        //// if (soLuongKhongThoa || donGiaKhongThoa) {
        //// result.remove(ct);
        //// }
        // }
        return result;
    }

}
