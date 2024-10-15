package Layout.models.FrontEnd.ThongKe.components.RenderTable;

import java.util.ArrayList;

import javax.swing.JTable;

import Layout.models.FrontEnd.ThongKe.ThongKe;

public class ReloadTable {

    private ArrayList<Object[]> dshd;
    private ArrayList<Object[]> dspn = new ArrayList<>();
    private ThongKe thongke = new ThongKe();
    DataTable table1 = new DataTable();
    private JTable table_1;
    private JTable table_2;
    private JTable table;

    public void reload(String tab) {
        if (tab.equals("Phieunhap")) {
            dspn = thongke.ListPN();
            table1.addrowtable1(dshd, "Phieunhap", table);
            table1.addrowtable2(dshd, "Phieunhap", table_1);
        } else if (tab.equals("Hoadon")) {

            dshd = thongke.ListHD();
            // Cập nhật dữ liệu cho tab 2
            table1.addrowtable1(dshd, "hoaDon", table);
            table1.addrowtable2(dshd, "hoaDon", table_2);
        }
    }
}
