package Layout.models.FrontEnd.ThongKe.components.DisplayComponets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class DisplayTongQuat {

    public JPanel displaybai1() {

        // Tạo một JPanel mới để chứa tất cả các thành phần
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));

        JPanel sanpham = new JPanel();
        sanpham.setBackground(new Color(255, 128, 192));
        sanpham.setPreferredSize(new Dimension(180, 200));
        sanpham.setBorder(new LineBorder(Color.BLACK));
        panel_1.add(sanpham);
        sanpham.setLayout(new BorderLayout(0, 0));

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(44, 153, 252));
        sanpham.add(panel_3, BorderLayout.NORTH);
        panel_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));

        JLabel lblNewLabel = new JLabel("Sản phẩm");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel_3.add(lblNewLabel);

        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(186, 222, 254));
        FlowLayout flowLayout_6 = (FlowLayout) panel_5.getLayout();
        flowLayout_6.setVgap(50);
        JLabel phone = new JLabel(new ImageIcon(getClass().getResource("/images/icons8_google_mobile_100px.png")));
        phone.setHorizontalAlignment(SwingConstants.LEFT);
        panel_5.add(phone);
        sanpham.add(panel_5, BorderLayout.WEST);

        JPanel panel_6 = new JPanel();
        panel_6.setBackground(new Color(186, 222, 254));
        sanpham.add(panel_6, BorderLayout.CENTER);
        panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 70));

        lblsp = new JLabel();
        lblsp.setHorizontalAlignment(SwingConstants.RIGHT);
        panel_6.add(lblsp);
        lblsp.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(panel_1, BorderLayout.NORTH);

        JPanel nhanvien = new JPanel();
        nhanvien.setBackground(new Color(255, 185, 220));
        nhanvien.setPreferredSize(new Dimension(180, 200));
        nhanvien.setBorder(new LineBorder(Color.BLACK));
        panel_1.add(nhanvien);
        nhanvien.setLayout(new BorderLayout(0, 0));

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(44, 153, 252));
        FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        nhanvien.add(panel_2, BorderLayout.NORTH);

        JLabel lblNewLabel_2 = new JLabel("Nhân viên");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel_2.add(lblNewLabel_2);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(186, 222, 254));
        FlowLayout flowLayout_7 = (FlowLayout) panel_4.getLayout();
        flowLayout_7.setVgap(50);
        JLabel lblnhanvien = new JLabel(new ImageIcon(getClass().getResource("/images/icons8_assistant_100px.png")));
        panel_4.add(lblnhanvien);
        nhanvien.add(panel_4, BorderLayout.WEST);

        JPanel panel_7 = new JPanel();
        panel_7.setBackground(new Color(186, 222, 254));
        FlowLayout flowLayout_1 = (FlowLayout) panel_7.getLayout();
        flowLayout_1.setVgap(70);
        nhanvien.add(panel_7, BorderLayout.CENTER);

        lblnv = new JLabel();
        lblnv.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel_7.add(lblnv);

        JPanel khachhang = new JPanel();
        khachhang.setPreferredSize(new Dimension(180, 200));
        khachhang.setBorder(new LineBorder(Color.BLACK));
        panel_1.add(khachhang);
        khachhang.setLayout(new BorderLayout(0, 0));

        JPanel panel_8 = new JPanel();
        panel_8.setBackground(new Color(44, 153, 252));
        FlowLayout flowLayout_2 = (FlowLayout) panel_8.getLayout();
        flowLayout_2.setAlignment(FlowLayout.RIGHT);
        khachhang.add(panel_8, BorderLayout.NORTH);

        JLabel lblNewLabel_4 = new JLabel("Khách hàng");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel_8.add(lblNewLabel_4);

        JPanel panel_10 = new JPanel();
        panel_10.setBackground(new Color(186, 222, 254));
        FlowLayout flowLayout_8 = (FlowLayout) panel_10.getLayout();
        flowLayout_8.setVgap(25);
        JLabel lblkhachhang = new JLabel(new ImageIcon(getClass().getResource("/images/icons8_person_male_100px.png")));
        panel_10.add(lblkhachhang);
        khachhang.add(panel_10, BorderLayout.WEST);

        JPanel panel_12 = new JPanel();
        panel_12.setBackground(new Color(186, 222, 254));
        FlowLayout flowLayout_4 = (FlowLayout) panel_12.getLayout();
        flowLayout_4.setVgap(70);
        khachhang.add(panel_12, BorderLayout.CENTER);

        lblkh = new JLabel();
        lblkh.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel_12.add(lblkh);

        JPanel NCC = new JPanel();
        NCC.setPreferredSize(new Dimension(180, 200));
        NCC.setBorder(new LineBorder(Color.BLACK));
        panel_1.add(NCC);
        NCC.setLayout(new BorderLayout(0, 0));

        JPanel panel_9 = new JPanel();
        panel_9.setBackground(new Color(44, 153, 252));
        FlowLayout flowLayout_3 = (FlowLayout) panel_9.getLayout();
        flowLayout_3.setAlignment(FlowLayout.RIGHT);
        NCC.add(panel_9, BorderLayout.NORTH);

        JLabel lblNewLabel_5 = new JLabel("Nhà cung cấp");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel_9.add(lblNewLabel_5);

        JPanel panel_11 = new JPanel();
        panel_11.setBackground(new Color(186, 222, 254));
        FlowLayout flowLayout_9 = (FlowLayout) panel_11.getLayout();
        flowLayout_9.setVgap(50);
        JLabel lblNCC = new JLabel(new ImageIcon(getClass().getResource("/images/icons8_company_100px.png")));
        panel_11.add(lblNCC);
        NCC.add(panel_11, BorderLayout.WEST);

        JPanel panel_13 = new JPanel();
        panel_13.setBackground(new Color(186, 222, 254));
        FlowLayout flowLayout_5 = (FlowLayout) panel_13.getLayout();
        flowLayout_5.setVgap(70);
        NCC.add(panel_13, BorderLayout.CENTER);

        lblncc = new JLabel();
        lblncc.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel_13.add(lblncc);

        JPanel panel_14 = new JPanel();
        panel_14.setBackground(new Color(255, 255, 255));
        panel.add(panel_14, BorderLayout.CENTER);
        panel_14.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 50));

        // thongketonghop();

        return panel;
    }

    private JLabel lblkh;
    private JLabel lblncc;
    private JLabel lblnv;
    private JLabel lblsp;
}
