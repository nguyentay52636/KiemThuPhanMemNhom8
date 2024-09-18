/*
 * Created by JFormDesigner on Wed Apr 17 14:22:44 ICT 2024
 */

//package Layout.models.FrontEnd.FormPromotion;
//
//import Layout.models.BackEnd.BUS.PromotionBUS;
//import Layout.models.BackEnd.DTO.Promotion;
//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.impl.JDatePickerImpl;
//import org.jdatepicker.impl.UtilDateModel;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Properties;
//import javax.swing.*;
//import javax.swing.border.*;
//
///**
// * @author master
// */
//public class AddButtonKhuyenMai extends JFrame {
//
////    JButton btnThem = new JButton("Thêm");
//    JButton btnSua = new JButton("Sửa");
////    JButton btnHuy = new JButton("Hủy");
//
//    public AddButtonKhuyenMai() {
////        this.title = title;
////        this.maKhuyenMai = maKhuyenMai;
////        this.formKhuyenMai = formKhuyenMai;
//        initComponents();
//    }
//
//    private void initComponents() {
//        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
//        // Generated using JFormDesigner Evaluation license - Master
//        panel1 = new JPanel();
//        panel2 = new JPanel();
//        textField1 = new JTextField();
//        textField2 = new JTextField();
//        panel3 = new JPanel();
//        textField3 = new JTextField();
//        textField4 = new JTextField();
//        panel4 = new JPanel();
//        panel5 = new JPanel();
//        panel9 = new JPanel();
//        textField7 = new JTextField();
//        button3 = new JButton();
//        panel6 = new JPanel();
//        panel10 = new JPanel();
//        textField8 = new JTextField();
//        button4 = new JButton();
//        panel7 = new JPanel();
//        panel8 = new JPanel();
//        button1 = new JButton();
//        button2 = new JButton();
//
//        //======== this ========
//        var contentPane = getContentPane();
//        contentPane.setLayout(new BorderLayout());
//
//        //======== panel1 ========
//        {
//            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new
//            javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "" , javax
//            . swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java
//            . awt .Font ( "D\u0069al\u006fg", java .awt . Font. BOLD ,12 ) ,java . awt
//            . Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .
//            PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062or\u0064er" .
//            equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
//            panel1.setLayout(new GridLayout(2, 1));
//
//            //======== panel2 ========
//            {
//                panel2.setLayout(new FlowLayout());
//
//                //---- textField1 ----
//                textField1.setPreferredSize(new Dimension(200, 40));
//                textField1.setBorder(new TitledBorder("M\u00e3 khuy\u1ebfn m\u00e3i"));
//                panel2.add(textField1);
//
//                //---- textField2 ----
//                textField2.setPreferredSize(new Dimension(200, 40));
//                textField2.setBorder(new TitledBorder("T\u00ean khuy\u1ebfn m\u00e3i"));
//                panel2.add(textField2);
//            }
//            panel1.add(panel2);
//
//            //======== panel3 ========
//            {
//                panel3.setLayout(new FlowLayout());
//
//                //---- textField3 ----
//                textField3.setPreferredSize(new Dimension(200, 40));
//                textField3.setBorder(new TitledBorder("\u0110i\u1ec1u ki\u1ec7n khuy\u1ebfn m\u00e3i"));
//                panel3.add(textField3);
//
//                //---- textField4 ----
//                textField4.setPreferredSize(new Dimension(200, 40));
//                textField4.setBorder(new TitledBorder("Ph\u1ea7n tr\u0103m khuy\u1ebfn m\u00e3i"));
//                panel3.add(textField4);
//            }
//            panel1.add(panel3);
//        }
//        contentPane.add(panel1, BorderLayout.NORTH);
//
//        //======== panel4 ========
//        {
//            panel4.setLayout(new GridLayout(3, 1));
//
//            //======== panel5 ========
//            {
//                panel5.setLayout(new FlowLayout());
//
//                //======== panel9 ========
//                {
//                    panel9.setBorder(new TitledBorder("Ng\u00e0y b\u1eaft \u0111\u1ea7u"));
//                    panel9.setLayout(new FlowLayout());
//
//                    //---- textField7 ----
//                    textField7.setBorder(new TitledBorder(""));
//                    textField7.setPreferredSize(new Dimension(150, 40));
//                    panel9.add(textField7);
//
//                    //---- button3 ----
//                    button3.setPreferredSize(new Dimension(50, 40));
//                    panel9.add(button3);
//                }
//                panel5.add(panel9);
//            }
//            panel4.add(panel5);
//
//            //======== panel6 ========
//            {
//                panel6.setLayout(new FlowLayout());
//
//                //======== panel10 ========
//                {
//                    panel10.setBorder(new TitledBorder("Ng\u00e0y k\u1ebft th\u00fac"));
//                    panel10.setLayout(new FlowLayout());
//
//                    //---- textField8 ----
//                    textField8.setBorder(new TitledBorder(""));
//                    textField8.setPreferredSize(new Dimension(150, 40));
//                    panel10.add(textField8);
//
//                    //---- button4 ----
//                    button4.setPreferredSize(new Dimension(50, 40));
//                    panel10.add(button4);
//                }
//                panel6.add(panel10);
//            }
//            panel4.add(panel6);
//
//            //======== panel7 ========
//            {
//                panel7.setLayout(new FlowLayout());
//            }
//            panel4.add(panel7);
//        }
//        contentPane.add(panel4, BorderLayout.CENTER);
//
//        //======== panel8 ========
//        {
//            panel8.setLayout(new FlowLayout());
//
//            //---- button1 ----
//            button1.setText("Th\u00eam");
//            button1.setPreferredSize(new Dimension(120, 40));
//            panel8.add(button1);
//
//            //---- button2 ----
//            button2.setText("H\u1ee7y");
//            button2.setPreferredSize(new Dimension(120, 40));
//            panel8.add(button2);
//        }
//        contentPane.add(panel8, BorderLayout.SOUTH);
//        pack();
//        setLocationRelativeTo(getOwner());
//        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
//
//        // set icon
//        ImageIcon iconThem = new ImageIcon(getClass().getResource("/Layout/images/icons8_add_30px.png"));
//        ImageIcon iconHuy = new ImageIcon(getClass().getResource("/Layout/images/icons8_cancel_30px_1.png"));
//        ImageIcon iconLich = new ImageIcon(getClass().getResource("/Layout/images/icons8_calendar_31_30px.png"));
//
//        button1.setIcon(iconThem);
//        button2.setIcon(iconHuy);
//        button3.setIcon(iconLich);
//        button4.setIcon(iconLich);
//
//        // set font for text field
//        Font font = new Font("", Font.PLAIN, 16);
//        textField7.setFont(font);
//        textField8.setFont(font);
//
//
//
//        // data picker button3 and button4
//        button3.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                UtilDateModel model = new UtilDateModel();
//                Properties p = new Properties();
//                p.put("text.today", "Today");
//                p.put("text.month", "Month");
//                p.put("text.year", "Year");
//                JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
//                JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
//                datePicker.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent actionEvent) {
//                        // get selected date
//                        Date selectedDate = (Date) datePicker.getModel().getValue();
//
//                        // format the date to s tring
//                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                        String dateString = formatter.format(selectedDate);
//
//                        // set the date string to text field
//                        textField7.setText(dateString);
//                    }
//                });
//                JOptionPane.showMessageDialog(null, datePicker);
//            }
//        });
//
//        button4.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                UtilDateModel model = new UtilDateModel();
//                Properties p = new Properties();
//                p.put("text.today", "Today");
//                p.put("text.month", "Month");
//                p.put("text.year", "Year");
//                JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
//                JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
//
//                datePicker.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent actionEvent) {
//                        Date selectedDate = (Date) datePicker.getModel().getValue();
//                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                        String dateString = formatter.format(selectedDate);
//                        textField8.setText(dateString);
//                    }
//                });
//                JOptionPane.showMessageDialog(null, datePicker);
//            }
//        });
//
//        // khi nhan vao nut huy
//        button2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                dispose(); // thoat cua so
//            }
//        });
//    }
//
//    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
//    // Generated using JFormDesigner Evaluation license - Master
//    private JPanel panel1;
//    private JPanel panel2;
//    private JTextField textField1;
//    private JTextField textField2;
//    private JPanel panel3;
//    private JTextField textField3;
//    private JTextField textField4;
//    private JPanel panel4;
//    private JPanel panel5;
//    private JPanel panel9;
//    private JTextField textField7;
//    private JButton button3;
//    private JPanel panel6;
//    private JPanel panel10;
//    private JTextField textField8;
//    private JButton button4;
//    private JPanel panel7;
//    private JPanel panel8;
//    private JButton button1;
//    private JButton button2;
//    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
//
//}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout.models.FrontEnd.FormPromotion;

import Layout.models.BackEnd.BUS.PromotionBUS;
import Layout.models.BackEnd.DTO.Product;
import Layout.models.BackEnd.DTO.Promotion;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class AddButtonKhuyenMai extends JFrame {
    private String title;
    private String maKhuyenMai;
    private FormKhuyenMai formKhuyenMai;

    String type;
    PromotionBUS qlkhBUS = new PromotionBUS();
    Promotion kmSua;

    JTextField txMaKM = new JTextField(15);
    JTextField txTenKM = new JTextField(15);
    JTextField txDieuKienKhuyenMai = new JTextField(15);
    JTextField txPhanTramKhuyenMai = new JTextField(15);
    JTextField txNgayBD = new JTextField(15);
    JTextField txNgayKT = new JTextField(15);

    JButton btnThem = new JButton("Thêm");
    JButton btnSua = new JButton("Sửa");
    JButton btnHuy = new JButton("Hủy");

    public AddButtonKhuyenMai(String title, String maKhuyenMai, FormKhuyenMai formKhuyenMai) {
        this.title = title;
        this.maKhuyenMai = maKhuyenMai;
        this.formKhuyenMai = formKhuyenMai;
        initComponents();
    }


    public void initComponents() {
        this.setLayout(new BorderLayout());
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.type = this.title;

        JButton btnLichBD = new JButton();
        JButton btnLichKT = new JButton();
        Dimension size = new Dimension(50, 40);
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/icons8_calendar_31_30px.png"));
        btnLichBD.setPreferredSize(size);
        btnLichKT.setPreferredSize(size);
        btnLichBD.setIcon(icon);
        btnLichKT.setIcon(icon);

        JPanel plNgayBD = new JPanel();
        plNgayBD.setBorder(BorderFactory.createTitledBorder("Ngày bắt đầu"));
        plNgayBD.add(txNgayBD);
        plNgayBD.add(btnLichBD);

        JPanel plNgayKT = new JPanel();
        plNgayKT.setBorder(BorderFactory.createTitledBorder("Ngày kết thúc"));
        plNgayKT.add(txNgayKT);
        plNgayKT.add(btnLichKT);

        // font
        Font font = new Font("", Font.PLAIN, 14);

        // inputs
        txMaKM.setBorder(BorderFactory.createTitledBorder("Mã khuyến mãi"));
        txTenKM.setBorder(BorderFactory.createTitledBorder("Tên khuyến mãi"));
        txDieuKienKhuyenMai.setBorder(BorderFactory.createTitledBorder("Điều kiện khuyến mãi"));
        txPhanTramKhuyenMai.setBorder(BorderFactory.createTitledBorder("Phần trăm khuyến mãi"));
        txNgayBD.setBorder(BorderFactory.createTitledBorder(" "));
        txNgayKT.setBorder(BorderFactory.createTitledBorder(" "));

        txMaKM.setFont(font);
        txTenKM.setFont(font);
        txDieuKienKhuyenMai.setFont(font);
        txPhanTramKhuyenMai.setFont(font);
        txNgayBD.setFont(font);
        txNgayKT.setFont(font);

        JPanel plInput = new JPanel();
        plInput.add(txMaKM);
        plInput.add(txTenKM);
        plInput.add(txDieuKienKhuyenMai);
        plInput.add(txPhanTramKhuyenMai);
        plInput.add(plNgayBD);
        plInput.add(plNgayKT);

        // panel buttons
        JPanel plButton = new JPanel();

        // 2 case Thêm - Sửa
        if (this.type.equals("Thêm")) {
            this.setTitle("Thêm khuyến mãi");
            txMaKM.setText(qlkhBUS.getNextID());

            btnThem.setIcon(new ImageIcon(this.getClass().getResource("/images/icons8_add_30px.png")));
            plButton.add(btnThem);

        } else {
            this.setTitle("Sửa khuyến mãi");
            for (Promotion km : qlkhBUS.getDskm()) {
                if (km.getMaKhuyenMai().equals(this.maKhuyenMai)) {
                    this.kmSua = km;
                }
            }
            if (this.kmSua == null) {
                JOptionPane.showMessageDialog(null, "Lỗi, không tìm thấy khuyến mãi");
                this.dispose();
            }

            txMaKM.setText(this.kmSua.getMaKhuyenMai());
            txTenKM.setText(this.kmSua.getTenKhuyenMai());
            txDieuKienKhuyenMai.setText(String.valueOf(this.kmSua.getDieuKienKhuyenMai()));
            txPhanTramKhuyenMai.setText(String.valueOf(this.kmSua.getPhanTramKhuyenMai()));

            txMaKM.setEditable(false);

            btnSua.setIcon(new ImageIcon(this.getClass().getResource("/images/icons8_support_30px.png")));
            plButton.add(btnSua);
        }

        btnHuy.setIcon(new ImageIcon(this.getClass().getResource("/images/icons8_cancel_30px_1.png")));
        plButton.add(btnHuy);

        this.add(plInput, BorderLayout.CENTER);
        this.add(plButton, BorderLayout.SOUTH);

        // mouse listener
        btnThem.addActionListener((ae) -> {
            btnThemMouseClicked();
        });
        btnSua.addActionListener((ae) -> {
            btnSuaMouseClicked();
        });
        btnHuy.addActionListener((ae) -> {
            this.dispose();
        });

        KeyListener keyListener = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '%') {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };
        txPhanTramKhuyenMai.addKeyListener(keyListener);

        this.setVisible(true);

        // tao date picker
        btnLichBD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UtilDateModel model = new UtilDateModel();
                Properties p = new Properties();
                p.put("text.today", "Today");
                p.put("text.month", "Month");
                p.put("text.year", "Year");

                JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
                JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
                datePicker.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        // chon date
                        Date selectedDate = (Date) datePicker.getModel().getValue();
                        // kiem tra rong
                        if (selectedDate == null) {
                            JOptionPane.showOptionDialog(null, "Chưa chọn ngày", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{}, null);
                            return;
                        }
                        // chuyen ve String
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        String dateString = formatter.format(selectedDate);
                        // dua vao text field
                        txNgayBD.setText(dateString);
                    }
                });
                JOptionPane.showMessageDialog(null, datePicker);
            }
        });

        btnLichKT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UtilDateModel model = new UtilDateModel();
                Properties p = new Properties();
                p.put("text.today", "Today");
                p.put("text.month", "Month");
                p.put("text.year", "Year");
                JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
                JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
                datePicker.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Date selectedDate = (Date) datePicker.getModel().getValue();
                        if (selectedDate == null) {
                            JOptionPane.showOptionDialog(null, "Chưa chọn ngày", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{}, null);
                            return;
                        }
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        String dateString = formatter.format(selectedDate);
                        txNgayKT.setText(dateString);

                        // kiem tra ngay ket thuc phai lon hon ngay bat dau
                        String startDateString = txNgayBD.getText();
                        try {
                            Date startDate = formatter.parse(startDateString);
                            if (startDate.after(selectedDate)) {
                                JOptionPane.showMessageDialog(null, "Ngày kết thúc phải sau ngày bắt đầu");
                                txNgayKT.setText("");
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                });
                JOptionPane.showMessageDialog(null, datePicker);
            }
        });
    }

    private void btnThemMouseClicked() {
        if (checkEmpty()) {
            String makm = txMaKM.getText();
            String tenkm = txTenKM.getText();
            float dieukien = Float.parseFloat(txDieuKienKhuyenMai.getText());
            float phantram = Float.parseFloat(txPhanTramKhuyenMai.getText());
            LocalDate ngaybd = LocalDate.parse(txNgayBD.getText());
            LocalDate ngaykt = LocalDate.parse(txNgayKT.getText());

            if (qlkhBUS.add(makm, tenkm, dieukien, phantram, ngaybd, ngaykt)) {
                JOptionPane.showMessageDialog(this, "Thêm " + tenkm + " thành công!");
                this.dispose();
            }
        }
        formKhuyenMai.refresh();
    }

    private void btnSuaMouseClicked() {
        if (checkEmpty()) {
            String makm = txMaKM.getText();
            String tenkm = txTenKM.getText();
            float dieukien = Float.parseFloat(txDieuKienKhuyenMai.getText());
            float phantram = Float.parseFloat(txPhanTramKhuyenMai.getText());
            LocalDate ngaybd = LocalDate.parse(txNgayBD.getText());
            LocalDate ngaykt = LocalDate.parse(txNgayKT.getText());

            if (qlkhBUS.update(makm, tenkm, dieukien, phantram, ngaybd, ngaykt)) {
                JOptionPane.showMessageDialog(this, "Sửa " + makm + " thành công!");
                this.dispose();
            }
        }
        formKhuyenMai.refresh();
    }

    private Boolean checkEmpty() {
        String makm = txMaKM.getText();
        String tenkm = txTenKM.getText();
        String dieukien = txDieuKienKhuyenMai.getText();
        String phantram = txPhanTramKhuyenMai.getText();
        String ngaybd = txNgayBD.getText();
        String ngaykt = txNgayKT.getText();

        if (makm.trim().equals("")) {
            return showErrorTx(txMaKM, "Mã khuyến mãi không được để trống");

        } else if (tenkm.trim().equals("")) {
            return showErrorTx(txTenKM, "Tên khuyến mãi không được để trống");

        } else if (dieukien.trim().equals("")) {
            return showErrorTx(txTenKM, "Điều kiện khuyến mãi không được để trống");

        } else if (phantram.trim().equals("")) {
            return showErrorTx(txTenKM, "Phần trăm khuyến mãi không được để trống");

        } else {
            try {
                Float.parseFloat(dieukien);
            } catch (NumberFormatException e) {
                return showErrorTx(txDieuKienKhuyenMai, "Điều kiện khuyến mãi là giá hóa đơn tối thiểu để được khuyến mãi, phải là số thực");
            }
            try {
                float fPhanTram = Float.parseFloat(phantram);
                if (fPhanTram > 100) {
                    return showErrorTx(txPhanTramKhuyenMai, "Phần trăm khuyến mãi phải là số thực < 100 (%)");
                }
            } catch (NumberFormatException e) {
                return showErrorTx(txPhanTramKhuyenMai, "Phần trăm khuyến mãi phải là số thực");
            }
            try {
                LocalDate.parse(ngaybd);
            } catch (Exception e) {
                return showErrorTx(txNgayBD, "Ngày bắt đầu không hợp lệ");
            }
            try {
                LocalDate.parse(ngaykt);
            } catch (Exception e) {
                return showErrorTx(txNgayKT, "Ngày kết thúc không hợp lệ");
            }
        }

        return true;
    }

    private Boolean showErrorTx(JTextField tx, String errorInfo) {
        JOptionPane.showMessageDialog(tx, errorInfo);
        tx.requestFocus();
        return false;
    }
}
