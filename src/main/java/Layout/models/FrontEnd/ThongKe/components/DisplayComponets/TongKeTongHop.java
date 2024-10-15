package Layout.models.FrontEnd.ThongKe.components.DisplayComponets;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;

import Layout.models.BackEnd.BUS.CustomerBUS;
import Layout.models.BackEnd.BUS.ProductBUS;
import Layout.models.BackEnd.BUS.StaffBUS;
import Layout.models.BackEnd.BUS.SupplierBUS;
import Layout.models.BackEnd.DTO.Customer;
import Layout.models.BackEnd.DTO.Product;
import Layout.models.BackEnd.DTO.Staff;
import Layout.models.BackEnd.DTO.Supplier;

public class TongKeTongHop {
    private ProductBUS spbus = new ProductBUS();
    private CustomerBUS cusbus = new CustomerBUS();
    private StaffBUS stbus = new StaffBUS();
    private SupplierBUS supbus = new SupplierBUS();

    private HashMap<String, Object> tongKet;

    private JLabel lblncc;
    private JLabel lblkh;
    private JLabel lblnv;
    private JLabel lblsp;

    public void thongketonghop() {
        int soluongsp = 0;
        for (Product pr : spbus.getList()) {
            if (pr.getTrangthai() == 0) {
                soluongsp++;
            }
        }
        lblsp.setText(soluongsp + "");

        ArrayList<Staff> dsnv = new ArrayList<>();
        dsnv = stbus.getList();
        int soluongnv = 0;
        for (Staff nv : dsnv) {
            if (nv.getTrangThai() == 0) {
                soluongnv++;
            }
        }
        lblnv.setText(soluongnv + "");

        ArrayList<Customer> dskh = new ArrayList<>();
        dskh = cusbus.getDskh();
        int soluongkh = 0;
        for (Customer kh : dskh) {
            if (kh.getTrangThai() == 0) {
                soluongkh++;
            }
        }
        lblkh.setText(soluongkh + "");

        ArrayList<Supplier> dsncc = new ArrayList<>();
        dsncc = supbus.getList();
        int soluongncc = 0;
        for (Supplier ncc : dsncc) {
            if (ncc.getTrangThai() == 0) {
                soluongncc++;
            }
        }
        lblncc.setText(soluongncc + "");

    }
}
