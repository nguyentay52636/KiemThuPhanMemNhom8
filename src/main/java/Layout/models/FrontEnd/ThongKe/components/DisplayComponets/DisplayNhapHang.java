package Layout.models.FrontEnd.ThongKe.components.DisplayComponets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Layout.models.FrontEnd.ThongKe.components.NavigateTab.ListTab;
// Correct the import statements
import Layout.models.FrontEnd.ThongKe.components.RenderTable.ReloadTable;
import Layout.models.FrontEnd.ThongKe.components.RenderTable.Table1;

public class DisplayNhapHang {
    Table1 table1 = new Table1();
    ReloadTable reload = new ReloadTable();
    ListTab listtab = new ListTab();

    public JPanel displaybai3(ArrayList<Object[]> list, String type) {

        // Tạo panel chứa nội dung của tab 2
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setHgap(20);
        flowLayout.setVgap(20);
        panel.add(panel_1, BorderLayout.NORTH);

        JPanel panel_15 = new JPanel();
        panel_15.setBackground(new Color(223, 223, 255));
        panel_1.add(panel_15);
        panel_15.setLayout(new GridLayout(2, 1, 0, 15));

        // Additional code...

        return panel;
    }
}