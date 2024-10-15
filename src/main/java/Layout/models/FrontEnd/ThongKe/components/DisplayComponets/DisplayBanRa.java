package Layout.models.FrontEnd.ThongKe.components.DisplayComponets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

import com.toedter.calendar.JDateChooser;

import Layout.models.FrontEnd.ThongKe.ThongKe;
import Layout.models.FrontEnd.ThongKe.components.NavigateTab.ListTab;
import Layout.models.FrontEnd.ThongKe.components.RenderTable.DataTable;
import Layout.models.FrontEnd.ThongKe.components.RenderTable.ReloadTable;

public class DisplayBanRa {
    private ThongKe thongke = new ThongKe();
    DataTable setDataTable1 = new DataTable();
    ListTab listtab = new ListTab();

    ReloadTable reload = new ReloadTable();

    public JPanel displaybai2(ArrayList<Object[]> list, String type) {

        // Tạo panel chứa nội dung của tab 2
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setHgap(20);
        flowLayout.setVgap(20);
        panel.add(panel_1, BorderLayout.NORTH);

        JPanel panel_16 = new JPanel();
        panel_16.setForeground(Color.BLACK);
        panel_16.setBackground(new Color(223, 223, 255));
        panel_1.add(panel_16);
        panel_16.setLayout(new GridLayout(2, 1, 0, 15));

        JLabel lblNewLabel_10 = new JLabel("Sản phẩm được bán nhiều nhất");
        lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_10.setBackground(new Color(223, 223, 255));
        lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_16.add(lblNewLabel_10);

        lblspnhieunhat = new JLabel();
        lblspnhieunhat.setText("");
        lblspnhieunhat.setHorizontalAlignment(SwingConstants.CENTER);
        lblspnhieunhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_16.add(lblspnhieunhat);

        JPanel panel3 = new JPanel();
        FlowLayout fl_panel3 = new FlowLayout();
        fl_panel3.setVgap(0);
        panel3.setLayout(fl_panel3);
        panel_1.add(panel3);

        JDateChooser dateChooserFrom = new JDateChooser();
        JDateChooser dateChooserTo = new JDateChooser();
        dateChooserFrom.setPreferredSize(new Dimension(140, 25));
        dateChooserTo.setPreferredSize(new Dimension(140, 25));
        dateChooserTo.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    ArrayList<Object[]> timdc = thongke.timkiem(dateChooserFrom, dateChooserTo, list);
                    setDataTable1.addrowtable1(timdc, type, table2);
                    setDataTable1.addrowtable2(timdc, type, table_2);
                }
            }
        });
        JPanel panelloc = new JPanel();
        panelloc.setBorder(new TitledBorder("Thống kê theo thời gian"));
        panelloc.setLayout(new FlowLayout());
        panel3.add(panelloc);

        panelloc.add(dateChooserFrom);

        JLabel lblNewLabel_8 = new JLabel("Đến");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panelloc.add(lblNewLabel_8);

        panelloc.add(dateChooserTo);

        JButton btnlammoi = new JButton("Làm mới");
        btnlammoi.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnlammoi.setPreferredSize(new Dimension(80, 30));
        panel3.add(btnlammoi);

        JPanel panel_19 = new JPanel();
        panel_19.setBackground(new Color(223, 223, 255));
        panel_1.add(panel_19);
        panel_19.setLayout(new GridLayout(2, 1, 30, 20));

        JLabel label_19 = new JLabel("Tổng tiền thu được ");
        label_19.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_19.add(label_19);

        lbltongtienthudc = new JLabel("");
        lbltongtienthudc.setHorizontalAlignment(SwingConstants.CENTER);
        lbltongtienthudc.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel_19.add(lbltongtienthudc);
        btnlammoi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                reload.reload("Hoadon");
            }
        });
        JPanel panel_2 = new JPanel(new BorderLayout());

        // Tạo JTable với DefaultTableModel
        table2 = new JTable();
        table2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        setDataTable1.addrowtable1(list, type, table2);
        table2.setShowGrid(false); // Ẩn đường viền
        table2.setShowHorizontalLines(false); // Ẩn đường kẻ ngang
        table2.setShowVerticalLines(false); // Ẩn đường kẻ dọc

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table2.setDefaultRenderer(Object.class, centerRenderer);
        // Thêm JTable vào JScrollPane để có thanh cuộn
        JScrollPane scrollPane = new JScrollPane(table2);
        panel_2.add(scrollPane);
        panel.add(panel_2, BorderLayout.CENTER);

        JPanel panel_3 = new JPanel();
        panel.add(panel_3, BorderLayout.SOUTH);
        panel_3.setLayout(new BorderLayout());

        table_2 = new JTable();
        setDataTable1.addrowtable2(list, type, table_2);
        panel_3.add(table_2);
        listtab.tab2();
        return panel;

    }

    private JLabel lblspnhieunhat;
    private JTable table_2;
    private JTable table2;
    private JLabel lbltongtienthudc;
}
