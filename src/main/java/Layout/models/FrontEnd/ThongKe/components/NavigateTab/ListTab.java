package Layout.models.FrontEnd.ThongKe.components.NavigateTab;

import java.util.ArrayList;

import javax.swing.JLabel;

import Layout.models.BackEnd.BUS.CustomerBUS;
import Layout.models.BackEnd.BUS.ImportBUS;
import Layout.models.BackEnd.BUS.InvoiceBUS;
import Layout.models.BackEnd.BUS.ProductBUS;
import Layout.models.BackEnd.BUS.StaffBUS;
import Layout.models.BackEnd.BUS.SupplierBUS;
import Layout.models.BackEnd.DTO.Import;
import Layout.models.BackEnd.DTO.Invoice;
import Layout.models.BackEnd.DTO.Product;
import Layout.models.FrontEnd.Formatter.PriceFormatter;
import Layout.models.FrontEnd.ThongKe.ThongKe;

public class ListTab {

    private ArrayList<Object[]> dshd;
    private ArrayList<Object[]> dspn = new ArrayList<>();

    private ProductBUS spbus = new ProductBUS();
    private CustomerBUS cusbus = new CustomerBUS();
    private StaffBUS stbus = new StaffBUS();
    private SupplierBUS supbus = new SupplierBUS();

    private InvoiceBUS invoice = new InvoiceBUS();
    private ImportBUS phieunhap = new ImportBUS();
    private ThongKe thongke = new ThongKe();

    private JLabel lblspnhieunhat;

    private JLabel lblspnhapnhieunhat;
    private JLabel lbltongtienchira;
    private JLabel lbltongtienthudc;

    public void tab2() {

        String tensp = ""; // Khởi tạo biến tensp trước khi sử dụng
        for (Product pr : spbus.getList()) {
            if (pr.getTrangthai() == 0 && pr.getMaSP().equals(thongke.findMostSoldProductID())) {
                tensp = pr.getTenSP();
            }
        }
        lblspnhieunhat.setText(tensp);

        float tongtienthuduoc = 0;
        ArrayList<Invoice> dsinvoice = invoice.getListInvoice();
        for (Invoice invoi : dsinvoice) {
            tongtienthuduoc += invoi.getTongTien();
            System.out.println(invoi.getTongTien());
        }
        String formattedNumber = PriceFormatter.format(tongtienthuduoc);
        lbltongtienthudc.setText(formattedNumber);
    }

    public void tab3() {

        String tenspnhap = "";
        for (Product pr : spbus.getList()) {
            if (pr.getTrangthai() == 0 && pr.getMaSP().equals(thongke.findMostImportedProductID())) {
                tenspnhap = pr.getTenSP();
            }
        }
        lblspnhapnhieunhat.setText(tenspnhap);

        float tongtienchira = 0;
        ArrayList<Import> dsimport = phieunhap.getDspn();
        for (Import inp : dsimport) {
            tongtienchira += inp.getTongTien();

        }
        lbltongtienchira.setText(tongtienchira + "");

    }
}
