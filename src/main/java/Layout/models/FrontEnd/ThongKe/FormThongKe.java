package Layout.models.FrontEnd.ThongKe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import Layout.models.FrontEnd.ThongKe.components.DisplayComponets.DisplayBanRa;
import Layout.models.FrontEnd.ThongKe.components.DisplayComponets.DisplayNhapHang;
import Layout.models.FrontEnd.ThongKe.components.DisplayComponets.DisplayTongQuat;

public class FormThongKe extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormThongKe frame = new FormThongKe();
                    frame.getPanel();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JPanel getPanel() {
        return contentPane;
    }

    private JPanel contentPane;
    private JTabbedPane tabbedPane;
    private ArrayList<Object[]> dshd;
    private ArrayList<Object[]> dspn = new ArrayList<>();
    ThongKe thongke = new ThongKe();
    DisplayTongQuat tongQuat = new DisplayTongQuat();
    DisplayBanRa banRa = new DisplayBanRa();
    DisplayNhapHang nhapHang = new DisplayNhapHang();

    public FormThongKe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1094, 558);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        tabbedPane = new JTabbedPane();

        dshd = thongke.ListHD();
        dspn = thongke.ListPN();
        tabbedPane.addTab("Tổng quát", tongQuat.displaybai1()); // Thêm panel1 vào tab 1
        tabbedPane.addTab("Bán ra", banRa.displaybai2(dshd, "hoaDon"));
        tabbedPane.addTab("Nhập hàng", nhapHang.displaybai3(dspn, "Phieunhap"));

        contentPane.add(tabbedPane, BorderLayout.CENTER);
    }
}
