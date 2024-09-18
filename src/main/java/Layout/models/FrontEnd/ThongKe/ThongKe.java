package Layout.models.FrontEnd.ThongKe;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import com.toedter.calendar.JDateChooser;

import Layout.models.BackEnd.BUS.CustomerBUS;
import Layout.models.BackEnd.BUS.ImportBUS;
import Layout.models.BackEnd.BUS.ImportDetailsBUS;
import Layout.models.BackEnd.BUS.InvoiceBUS;
import Layout.models.BackEnd.BUS.InvoiceDetailBUS;
import Layout.models.BackEnd.BUS.ProductBUS;
import Layout.models.BackEnd.BUS.StaffBUS;
import Layout.models.BackEnd.BUS.SupplierBUS;
import Layout.models.BackEnd.DTO.Customer;
import Layout.models.BackEnd.DTO.Import;
import Layout.models.BackEnd.DTO.ImportDetails;
import Layout.models.BackEnd.DTO.Invoice;
import Layout.models.BackEnd.DTO.InvoiceDetail;
import Layout.models.BackEnd.DTO.Product;
import Layout.models.BackEnd.DTO.Staff;
import Layout.models.BackEnd.DTO.Supplier;

public class ThongKe {

    private ArrayList<Object[]> dshd;
    private ArrayList<Object[]> dspn;
    private InvoiceBUS invoibus;
    private InvoiceDetailBUS invdetail;
    private ImportBUS importbus;
    private ImportDetailsBUS impdetailbus;
    private StaffBUS staffbus = new StaffBUS();
    private ProductBUS spbus = new ProductBUS();
    private CustomerBUS nvbus = new CustomerBUS();
    private SupplierBUS nccbus = new SupplierBUS();

    public ThongKe() {

    }

    public ArrayList<Object[]> ListHD() {
        if (dshd == null) {
            dshd = new ArrayList<Object[]>();
            dshd = selectALLhoadon();
        }
        return dshd;
    }

    public ArrayList<Object[]> ListPN() {
        if (dspn == null) {
            dspn = new ArrayList<Object[]>();
            dspn = selectALLphieunhap();
        }
        return dspn;
    }

    public ArrayList<Object[]> timkiem(JDateChooser dateChooserFrom, JDateChooser dateChooserTo,
            ArrayList<Object[]> dshd) {
        ArrayList<Object[]> listtk = new ArrayList<>();

        try {
            LocalDate ngay1 = dateChooserFrom.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate ngay2 = dateChooserTo.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if (ngay1 != null && ngay2 != null) {
                for (Object[] invoice : dshd) {
                    LocalDate ngayLap = ((LocalDate) invoice[1]); // Chuyển đổi thành LocalDate

                    // Kiểm tra nếu ngày lập hóa đơn nằm trong khoảng thời gian fromDate - toDate
                    if (ngayLap.compareTo(ngay1) >= 0 && ngayLap.compareTo(ngay2) <= 0) {
                        listtk.add(invoice); // Nếu thỏa mãn, thêm hóa đơn vào danh sách kết quả
                    }
                }
            } else {
                System.out.println("Vui lòng chọn ngày bắt đầu và ngày kết thúc.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listtk;
    }

    public ArrayList<Object[]> selectALLhoadon() {
        ArrayList<Object[]> listInvoice = new ArrayList<>();
        invoibus = new InvoiceBUS();

        for (Invoice hd : invoibus.getListInvoice()) {
            // Lấy danh sách chi tiết hóa đơn cho mỗi hóa đơn
            invdetail = new InvoiceDetailBUS();
            ArrayList<Object[]> chiTietHoaDonCuaHoaDonNay = new ArrayList<>();

            for (InvoiceDetail cthd : invdetail.getListInvoiceDetails()) {
                // Kiểm tra xem chi tiết hóa đơn có thuộc hóa đơn hiện tại không
                if (hd.getMaHoaDon().equals(cthd.getMaHoaDon())) {
                    // Lấy thông tin sản phẩm cho chi tiết hóa đơn
                    Product sp = spbus.getProduct(cthd.getMaSanPham());
                    // Tạo mảng chứa thông tin chi tiết hóa đơn
                    Object[] chiTietHoaDon = new Object[4];
                    chiTietHoaDon[0] = cthd.getMaHoaDon();
                    chiTietHoaDon[1] = sp.getTenSP();
                    chiTietHoaDon[2] = cthd.getDonGia();
                    chiTietHoaDon[3] = cthd.getSoLuong();
                    // Thêm chi tiết hóa đơn vào danh sách
                    chiTietHoaDonCuaHoaDonNay.add(chiTietHoaDon);
                }
            }

            // Tạo mảng chứa thông tin hóa đơn kèm chi tiết
            Object[] hdWithChiTiet = new Object[6];
            hdWithChiTiet[0] = hd.getMaHoaDon();
            hdWithChiTiet[1] = hd.getNgayLap();
            hdWithChiTiet[2] = hd.getTongTien();
            Staff nv = staffbus.getStaff(hd.getMaNhanVien());
            hdWithChiTiet[3] = nv.getTenNV();
            Customer kh = nvbus.getCustomer(hd.getMaKhachHang());
            hdWithChiTiet[4] = kh.getTenKh();
            hdWithChiTiet[5] = chiTietHoaDonCuaHoaDonNay;
            // Thêm thông tin hóa đơn vào danh sách
            listInvoice.add(hdWithChiTiet);
        }

        return listInvoice;
    }

    public ArrayList<Object[]> selectALLphieunhap() {

        ArrayList<Object[]> listimport = new ArrayList<>();

        importbus = new ImportBUS();
        // Kết hợp thông tin chi tiết hóa đơn vào từng hóa đơn
        for (Import pn : importbus.getDspn()) {
            impdetailbus = new ImportDetailsBUS();
            ArrayList<Object[]> chitietPN = new ArrayList<>();
            for (ImportDetails ctpn : impdetailbus.getlist()) {

                if (pn.getMaPN().equals(ctpn.getMa())) { // Kiểm tra xem MaHD của hóa đơn có khớp với MaHD của chi tiết
                                                         // hóa đơn không
                    // Lấy thông tin sản phẩm cho chi tiết hóa đơn
                    Product sp = spbus.getProduct(ctpn.getMaSP());

                    // Tạo mảng chứa thông tin chi tiết hóa đơn
                    Object[] chiTietHoaDon = new Object[4];
                    chiTietHoaDon[0] = ctpn.getMa();
                    chiTietHoaDon[1] = sp.getTenSP();
                    chiTietHoaDon[2] = sp.getDonGia();
                    chiTietHoaDon[3] = ctpn.getSoLuong();
                    // Thêm chi tiết hóa đơn vào danh sách
                    chitietPN.add(chiTietHoaDon);
                }
            }
            // Tạo một mảng mới có kích thước lớn hơn để lưu trữ thông tin chi tiết hóa đơn
            Object[] hdWithChiTiet = new Object[6];
            hdWithChiTiet[0] = pn.getMaPN();
            hdWithChiTiet[1] = pn.getNgayNhap();
            hdWithChiTiet[2] = pn.getTongTien();
            Staff nv = staffbus.getStaff(pn.getMaNV());
            hdWithChiTiet[3] = nv.getTenNV();
            Supplier NCC = nccbus.getsupplierDTO(pn.getMaNCC());
            hdWithChiTiet[4] = NCC.getTenNCC();
            hdWithChiTiet[5] = chitietPN; // Thêm danh sách chi tiết hóa đơn vào hóa đơn tương ứng
            listimport.add(hdWithChiTiet);

        }

        return listimport;
    }

    public String findMostSoldProductID() {
        invdetail = new InvoiceDetailBUS();
        ArrayList<InvoiceDetail> dscthd = invdetail.getListInvoiceDetails();
        HashMap<String, Integer> productSoldCount = new HashMap<>();

        // Đếm số lượng sản phẩm đã bán
        for (InvoiceDetail invoiceDetail : dscthd) {
            String maSP = invoiceDetail.getMaSanPham();
            int soLuong = invoiceDetail.getSoLuong();
            productSoldCount.put(maSP, productSoldCount.getOrDefault(maSP, 0) + soLuong);
        }

        // Tìm mã sản phẩm có số lượng bán nhiều nhất
        String mostSoldProductID = "";
        int maxSoldQuantity = 0;
        for (Entry<String, Integer> entry : productSoldCount.entrySet()) {
            if (entry.getValue() > maxSoldQuantity) {
                mostSoldProductID = entry.getKey();
                maxSoldQuantity = entry.getValue();
            }
        }
        System.out.print(mostSoldProductID);
        return mostSoldProductID;
    }

    public String findMostImportedProductID() {
        impdetailbus = new ImportDetailsBUS();
        ArrayList<ImportDetails> dsctpn = impdetailbus.getlist();
        HashMap<String, Integer> productImportCount = new HashMap<>();

        // Đếm số lượng sản phẩm đã nhập
        for (ImportDetails importDetail : dsctpn) {
            String maSP = importDetail.getMaSP();
            int soLuong = importDetail.getSoLuong();
            productImportCount.put(maSP, productImportCount.getOrDefault(maSP, 0) + soLuong);
        }

        // Tìm mã sản phẩm có số lượng nhập nhiều nhất
        String mostImportedProductID = "";
        int maxImportedQuantity = 0;
        for (Entry<String, Integer> entry : productImportCount.entrySet()) {
            if (entry.getValue() > maxImportedQuantity) {
                mostImportedProductID = entry.getKey();
                maxImportedQuantity = entry.getValue();
            }
        }
        System.out.print(mostImportedProductID);
        return mostImportedProductID;
    }

    public HashMap<String, Object> tongket(ArrayList<Object[]> obj) {
        // HashMap để lưu trữ thông tin tổng kết
        HashMap<String, Object> tongKet = new HashMap<>();

        // Biến đếm
        int tongSoHoaDon = 0;
        HashSet<String> nhanVienSet = new HashSet<>();
        HashSet<String> khachHangSet = new HashSet<>();
        HashSet<String> tenSanPhamSet = new HashSet<>();
        int tongSoSanPham = 0;
        double tongTien = 0;

        // Lặp qua mỗi hóa đơn
        for (Object[] invoice : obj) {
            tongSoHoaDon++;

            // Đếm nhân viên và khách hàng
            nhanVienSet.add((String) invoice[3]);
            khachHangSet.add((String) invoice[4]);

            // Lặp qua mỗi chi tiết hóa đơn
            ArrayList<Object[]> chiTietHoaDon = (ArrayList<Object[]>) invoice[5];
            for (Object[] chiTiet : chiTietHoaDon) {
                String tenSP = (String) chiTiet[1];

                // Đếm số lượng sản phẩm
                int soLuong = (int) chiTiet[3];
                tongSoSanPham += soLuong;

                tenSanPhamSet.add(tenSP);

                // Tính tổng tiền
                double donGia = Double.parseDouble(chiTiet[2].toString());
                tongTien += donGia * soLuong;
            }
        }

        // Lưu trữ thông tin tổng kết vào HashMap
        tongKet.put("TongSoHoaDon", tongSoHoaDon);
        tongKet.put("TongSoNhanVien", nhanVienSet.size());
        tongKet.put("TongSoKhachHang", khachHangSet.size());
        tongKet.put("SoTenSanPham", tenSanPhamSet.size());
        tongKet.put("TongSoSanPhamDaBan", tongSoSanPham);
        tongKet.put("TongTien", tongTien);

        return tongKet;
    }

    // public static void main(String[] args) {
    // ThongKe thongkeDAO = new ThongKe();
    // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // java.util.Date startDate;
    // java.util.Date endDate;

    // try {
    // startDate = dateFormat.parse("2019-04-04");
    // endDate = dateFormat.parse("2019-04-26"); // Lấy ngày hiện tại làm ngày kết
    // thúc
    // } catch (ParseException e) {
    // e.printStackTrace();
    // return; // Kết thúc chương trình nếu xảy ra lỗi khi chuyển đổi ngày
    // }

    // JDateChooser dateChooserFrom = new JDateChooser();
    // JDateChooser dateChooserTo = new JDateChooser();

    // // Thiết lập ngày cho dateChooserFrom và dateChooserTo
    // dateChooserFrom.setDate(startDate);
    // dateChooserTo.setDate(endDate);
    // // Cần khởi tạo và điền dữ liệu cho danh sách hóa đơn (dshd) trước khi truyền
    // vào phương thức timkiem
    // ArrayList<Object[]> dshd = new ArrayList<>(); // Ví dụ: bạn có thể khởi tạo
    // dshd từ một nguồn dữ liệu nào đó
    // dshd=thongkeDAO.ListHD();
    // ArrayList<Object[]> invoices = thongkeDAO.timkiem(dateChooserFrom,
    // dateChooserTo, dshd); // Gọi phương thức tìm kiếm

    // // Hiển thị thông tin hóa đơn và chi tiết hóa đơn
    // for (Object[] invoice : invoices) {
    // System.out.println("Phieu nhap:");
    // System.out.println("MaPN: " + invoice[0]);
    // System.out.println("NgayLap: " + invoice[1]);
    // System.out.println("TongTien: " + invoice[2]);
    // System.out.println("TenNV: " + invoice[3]);
    // System.out.println("NCC: " + invoice[4]);
    // System.out.println("Chi tiết PN:");
    // ArrayList<Object[]> chiTietHoaDon = (ArrayList<Object[]>) invoice[5];
    // for (Object[] chiTiet : chiTietHoaDon) {
    // System.out.println("MaPN: " + chiTiet[0]);
    // System.out.println("TenSP: " + chiTiet[1]);
    // System.out.println("DonGia: " + chiTiet[2]);
    // System.out.println("SoLuong: " + chiTiet[3]);
    // }
    // System.out.println("-----------------------------------------");
    // }
    // }
}
