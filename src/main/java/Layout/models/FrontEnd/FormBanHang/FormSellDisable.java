package Layout.models.FrontEnd.FormBanHang;

/*
 * Created by JFormDesigner on Mon Apr 15 21:55:53 ICT 2024
 */

import Layout.models.BackEnd.BUS.*;
import Layout.models.BackEnd.DTO.*;
import Layout.models.FrontEnd.FormInvoice.FormInvoice;
import Layout.models.FrontEnd.FormLogin.FormLogin;
import Layout.models.FrontEnd.FormPermission.FormChoosePermission;
import Layout.models.FrontEnd.FormPermission.FormPermission;
import Layout.models.FrontEnd.FormPromotion.FormChoosePromotion;
import Layout.models.FrontEnd.Formatter.PriceFormatter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * @author m1lt43
 */
public class FormSellDisable extends JPanel {
    ProductBUS productBUS = new ProductBUS();
    PromotionBUS promotionBUS = new PromotionBUS();
    TypeProductBUS typeProductBUS = new TypeProductBUS();
    ArrayList<InvoiceDetail> dscthd = new ArrayList<>();
    InvoiceBUS invoiceBUS = new InvoiceBUS();
    StaffBUS staffBUS = new StaffBUS();

    public FormSellDisable() {
        initComponents();
        refresh();
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void initComponents() {

        panel1 = new JPanel();
        panel4 = new JPanel();
        panel2 = new JPanel();
        txtSearch = new JTextField();
        btnReset = new JButton();
        scrollPane2 = new JScrollPane();
        tableSell = new JTable();
        panel5 = new JPanel();
        panel6 = new JPanel();
        txtMaSP = new JTextField();
        txtLoaiSP = new JTextField();
        txtTenSP = new JTextField();
        txtDonGia = new JTextField();
        txtSoLuong = new JTextField();
        image = new JLabel();
        btnAdd = new JButton();
        panel7 = new JPanel();
        panel8 = new JPanel();
        panel9 = new JPanel();
        txtMaHoaDon = new JTextField();
        textField10 = new JTextField();
        txtTongTien = new JTextField();
        txtKhachHang = new JTextField();
        txtNhanvien = new JTextField();
        txtNgayLap = new JTextField();
        txtGioLap = new JTextField();
        txtMaKhuyenMai = new JTextField();
        panel10 = new JPanel();
        panel11 = new JPanel();
        btnXoa = new JButton();
        btnSua = new JButton();
        btnReset2 = new JButton();
        btnChoose = new JButton();
        btnChooseKm = new JButton();
        textField2 = new JTextField();
        scrollPane1 = new JScrollPane();
        tableSell2 = new JTable();
        panel12 = new JPanel();
        panel13 = new JPanel();
        btnHuy = new JButton();
        btnTong = new JButton();
        comboBox = new JComboBox();

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String currentDate = now.format(dateFormatter);
        String currentTime = now.format(timeFormatter);

        Font font = new Font("Segoe UI", 0, 16);
        Font fontHeader = new Font("Segoe UI", Font.BOLD, 16);
        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new TitledBorder ( new javax . swing.
                border .EmptyBorder ( 0, 0 ,0 , 0) ,  "" , TitledBorder. CENTER
                , TitledBorder . BOTTOM, new Font ( "D\u0069al\u006fg", Font
                . BOLD ,12 ) , Color .red ) , getBorder () ) );  addPropertyChangeListener(
                new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062or\u0064er"
                        .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new BorderLayout());
        }
        add(panel1, BorderLayout.NORTH);

        //======== panel4 ========
        {
            panel4.setMinimumSize(new Dimension(600, 132));
            panel4.setPreferredSize(new Dimension(650, 631));
            panel4.setLayout(new BorderLayout());

            //======== panel2 ========
            {
                panel2.setLayout(new FlowLayout());

                //===== comboBox =====
                comboBox.setPreferredSize(new Dimension(110, 35));
                String items[] = {"Tất cả", "Mã sản phẩm", "Mã loại", "Tên", "Đơn giá", "Số lượng"};
                for (String item : items) {
                    comboBox.addItem(item);
                }
                panel2.add(comboBox);

                //---- txtSearch ----
                txtSearch.setPreferredSize(new Dimension(180, 60));
                txtSearch.setBorder(new TitledBorder(null, "T\u00ecm ki\u1ebfm:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                panel2.add(txtSearch);

                //---- btnReset ----
                btnReset.setText("L\u00e0m m\u1edbi");
                btnReset.setIcon(new ImageIcon(getClass().getResource("/images/icons8_data_backup_30px.png")));
                btnReset.setPreferredSize(new Dimension(120, 40));
                panel2.add(btnReset);
            }
            panel4.add(panel2, BorderLayout.NORTH);

            //======== scrollPane2 ========
            {


                //---- tableSell ---
                tableSell.setFont(font);
                tableSell.getTableHeader().setFont(fontHeader);
                tableSell.setRowHeight(30);
                TableColumnModel columnModel = tableSell.getColumnModel();
                for (int i = 0; i < columnModel.getColumnCount(); i++) {
                    columnModel.getColumn(i).setPreferredWidth(150);
                }
                tableSell.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //  tableSell.setCellSelectionEnabled(true);
                tableSell.setModel(new DefaultTableModel(
                        new Object[][] {
                                {null, null, null, null, null},
                        },
                        getHeaderSell1()
                ));

                tableSell.setFillsViewportHeight(true);
                tableSell.setSurrendersFocusOnKeystroke(true);
                tableSell.setShowVerticalLines(true);
                tableSell.setShowHorizontalLines(true);
                ListSelectionModel selectionModel = tableSell.getSelectionModel();
                selectionModel.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (!e.getValueIsAdjusting()) {
                            int selectedRow = tableSell.getSelectedRow();
                            if (selectedRow != -1) {
                                Object value = tableSell.getValueAt(selectedRow, 1);
                                String maSP = value.toString();

                                showInfo(maSP,1);
                            }
                        }
                    }
                });

                scrollPane2.setViewportView(tableSell);
            }
            panel4.add(scrollPane2, BorderLayout.CENTER);

            //======== panel5 ========
            {
                panel5.setPreferredSize(new Dimension(400, 200));
                panel5.setLayout(new BorderLayout());

                //======== panel6 ========
                {
                    panel6.setPreferredSize(new Dimension(200, 40));
                    panel6.setAutoscrolls(true);
                    panel6.setBorder(new EtchedBorder());
                    panel6.setLayout(new FlowLayout(FlowLayout.CENTER, 7, 7));

                    //---- txtMaSP ----
                    txtMaSP.setPreferredSize(new Dimension(140, 60));
                    txtMaSP.setBorder(new TitledBorder(null, "M\u00e3 s\u1ea3n ph\u1ea9m:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                    panel6.add(txtMaSP);

                    //---- txtLoaiSP ----
                    txtLoaiSP.setPreferredSize(new Dimension(140, 60));
                    txtLoaiSP.setBorder(new TitledBorder(null, "Lo\u1ea1i s\u1ea3n ph\u1ea9m:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                    panel6.add(txtLoaiSP);

                    //---- txtTenSP ----
                    txtTenSP.setPreferredSize(new Dimension(140, 60));
                    txtTenSP.setBorder(new TitledBorder(null, "T\u00ean s\u1ea3n ph\u1ea9m", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                    panel6.add(txtTenSP);

                    //---- txtDonGia ----
                    txtDonGia.setPreferredSize(new Dimension(140, 60));
                    txtDonGia.setBorder(new TitledBorder(null, "\u0110\u01a1n gi\u00e1:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                    panel6.add(txtDonGia);

                    //---- txtSoLuong ----
                    txtSoLuong.setPreferredSize(new Dimension(140, 60));
                    txtSoLuong.setBorder(new TitledBorder(null, "S\u1ed1 l\u01b0\u1ee3ng", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                    panel6.add(txtSoLuong);
                }
                panel5.add(panel6, BorderLayout.CENTER);

                //---- image ----
                image.setPreferredSize(new Dimension(160, 100));
                image.setForeground(Color.black);
                image.setFocusTraversalPolicyProvider(true);
                image.setBackground(Color.black);
                image.setBorder(LineBorder.createBlackLineBorder());
                panel5.add(image, BorderLayout.WEST);

                //---- btnAdd ----
                btnAdd.setText("Th\u00eam");
                btnAdd.setIcon(new ImageIcon(getClass().getResource("/images/icons8_add_30px.png")));
                btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                panel5.add(btnAdd, BorderLayout.SOUTH);
            }
            panel4.add(panel5, BorderLayout.SOUTH);
        }
        add(panel4, BorderLayout.WEST);

        //======== panel7 ========
        {
            panel7.setLayout(new BorderLayout());
        }
        add(panel7, BorderLayout.EAST);

        //======== panel8 ========
        {
            panel8.setPreferredSize(new Dimension(550, 526));
            panel8.setLayout(new BorderLayout());

            //======== panel9 ========
            {
                panel9.setPreferredSize(new Dimension(630, 200));
                panel9.setAutoscrolls(true);
                panel9.setLayout(new FlowLayout(FlowLayout.CENTER, 9, 9));

                //---- txtMaHoaDon ----
                txtMaHoaDon.setPreferredSize(new Dimension(200, 55));
                txtMaHoaDon.setBorder(new TitledBorder(null, "M\u00e3 ho\u00e1 \u0111\u01a1n", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                String nextInvoiceID = invoiceBUS.getNextID();
                txtMaHoaDon.setText(nextInvoiceID);
                panel9.add(txtMaHoaDon);

                //---- textField10 ----
                textField10.setPreferredSize(new Dimension(0, 55));
                panel9.add(textField10);

                //---- txtTongTien ----
                txtTongTien.setPreferredSize(new Dimension(200, 55));
                txtTongTien.setBorder(new TitledBorder(null, "T\u1ed5ng ti\u1ec1n(tri\u1ec7u VND)", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                panel9.add(txtTongTien);

//                ---- txtKhachHang ----
                txtKhachHang.setPreferredSize(new Dimension(200, 55));
                txtKhachHang.setBorder(new TitledBorder(null, "Kh\u00e1ch h\u00e0ng", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                panel9.add(txtKhachHang);

                //===== btnchoose =====
                btnChoose.setText("");
                btnChoose.setIcon(new ImageIcon(getClass().getResource("/images/icons8_user_30px.png")));
                btnChoose.setPreferredSize(new Dimension(50, 50));
                panel9.add(btnChoose);

                //---- txtNhanvien ----
                txtNhanvien.setPreferredSize(new Dimension(200, 55));
                txtNhanvien.setBorder(new TitledBorder(null, "Nh\u00e2n vi\u00ean", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                panel9.add(txtNhanvien);
                Staff staff = new Staff();
                staff = staffBUS.getStaff(FormLogin.loggedInMaNV);
                if (staff != null) {
                    txtNhanvien.setText(staff.getTenNV() + " - " + staff.getMaNV());
                } else {
                    txtNhanvien.setText("Không tìm thấy nhân viên");
                }

                //---- txtNgayLap ----
                txtNgayLap.setPreferredSize(new Dimension(200, 55));
                txtNgayLap.setBorder(new TitledBorder(null, "Ng\u00e0y l\u1eadp", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                txtNgayLap.setText(currentDate);
                panel9.add(txtNgayLap);

                //===== txtGioLap =====
                txtGioLap.setPreferredSize(new Dimension(200, 55));
                txtGioLap.setBorder(new TitledBorder(null, "Giờ lập", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                txtGioLap.setText(currentTime);
                panel9.add(txtGioLap);

                //---- txtMaKhuyenMai ----
                txtMaKhuyenMai.setPreferredSize(new Dimension(200, 55));
                txtMaKhuyenMai.setBorder(new TitledBorder(null, "Mã khuyến mãi", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                panel9.add(txtMaKhuyenMai);

                //===== btnChooseKm =======
                btnChooseKm.setText("");
                btnChooseKm.setIcon(new ImageIcon(getClass().getResource("/images/icons8_gift_30px.png")));
                btnChooseKm.setPreferredSize(new Dimension(50, 50));
                panel9.add(btnChooseKm);
            }
            panel8.add(panel9, BorderLayout.NORTH);

            //======== panel10 ========
            {
                panel10.setLayout(new BorderLayout());

                //======== panel11 ========
                {
                    panel11.setLayout(new FlowLayout());

                    //---- btnXoa ----
                    btnXoa.setText("Xo\u00e1");
                    btnXoa.setIcon(new ImageIcon(getClass().getResource("/images/icons8_delete_forever_30px_1.png")));
                    panel11.add(btnXoa);

                    //---- btnSua ----
                    btnSua.setText("S\u1eeda");
                    btnSua.setIcon(new ImageIcon(getClass().getResource("/images/icons8_support_30px.png")));
//                    panel11.add(btnSua);

                    //---- btnReset2 ----
                    btnReset2.setText("L\u00e0m m\u01a1i");
                    btnReset2.setIcon(new ImageIcon(getClass().getResource("/images/icons8_data_backup_30px.png")));
                    panel11.add(btnReset2);

                    //---- textField2 ----
                    textField2.setPreferredSize(new Dimension(360, 40));
                    textField2.setBorder(new TitledBorder(null, "T\u00ecm ki\u1ebfm:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
//                    panel11.add(textField2);
                }
                panel10.add(panel11, BorderLayout.PAGE_END);

                //======== scrollPane1 ========
                {

                    //---- tableSell2 ----


                    // set font for the table
                    tableSell2.setFont(font);
                    tableSell2.getTableHeader().setFont(fontHeader);
                    tableSell2.setRowHeight(30);
                    TableColumnModel columnModel = tableSell2.getColumnModel();
                    for (int i = 0; i < columnModel.getColumnCount(); i++) {
                        columnModel.getColumn(i).setPreferredWidth(150);
                    }
                    tableSell2.setBorder(new BevelBorder(BevelBorder.LOWERED));
//                     tableSell2.setCellSelectionEnabled(true);
                    tableSell2.setModel(new DefaultTableModel(
                            new Object[][] {
                                    {null, null, null, null, null},
                            },
                            getHeaderSell2()
                    ));
                    //  tableSell2.setFillsViewportHeight(true);
                    //  tableSell2.setSurrendersFocusOnKeystroke(true);
                    //  tableSell2.setShowVerticalLines(true);
                    //  tableSell2.setShowHorizontalLines(true);
                    scrollPane1.setViewportView(tableSell2);
                }
                panel10.add(scrollPane1, BorderLayout.CENTER);
            }
            panel8.add(panel10, BorderLayout.CENTER);

            //======== panel12 ========
            {
                panel12.setLayout(new FlowLayout());
            }
            panel8.add(panel12, BorderLayout.WEST);

            //======== panel13 ========
            {
                panel13.setLayout(new FlowLayout(FlowLayout.RIGHT));

                //---- btnHuy ----
                btnHuy.setText("Hu\u1ef7");
                btnHuy.setIcon(new ImageIcon(getClass().getResource("/images/icons8_cancel_30px_1.png")));
//                panel13.add(btnHuy);

                //---- btnTong ----
                btnTong.setText("Thanh toán");
                btnTong.setIcon(new ImageIcon(getClass().getResource("/images/icons8_us_dollar_30px.png")));
                btnTong.setEnabled(false);
                panel13.add(btnTong);
            }
            panel8.add(panel13, BorderLayout.SOUTH);
        }
        add(panel8, BorderLayout.CENTER);
        //btn Add

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    String maSP = txtMaSP.getText();
                    int soluong = Integer.parseInt(txtSoLuong.getText());
                    if(soluong > 0 ) {
                        addDetails(maSP, soluong);
                    } else {
                        JOptionPane.showMessageDialog(txtSoLuong, "Số lượng phải là số dương!");
                        txtSoLuong.requestFocus();
                    }
                }catch (NumberFormatException ea) {
                    JOptionPane.showMessageDialog(txtSoLuong, "Số lượng phải là số nguyên!");
                    txtSoLuong.requestFocus();
                }





            }
        });

        // lam moi
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtSearch.setText("");
                comboBox.setSelectedItem("Tất cả");
                setDataTable(productBUS.getList());
            }
        });

        // xem chi tiet san pham
        tableSell.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // kiem tra chuot phai co duoc nhan hay khong
                if (SwingUtilities.isRightMouseButton(e)) {
                    // lay chi so row duoc nhan
                    int row = tableSell.rowAtPoint(e.getPoint());
                    tableSell.setRowSelectionInterval(row, row);

                    // tao popup menu
                    JPopupMenu popup = new JPopupMenu();
                    JMenuItem detail = new JMenuItem("Xem chi tiết");
                    popup.add(detail);

                    // su kien khi nhan vao xem chi tiet
                    detail.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            // lay quyen duoc chon tu table
                            String masp = (String) tableSell.getValueAt(row, 1);

                            // tim quyen trong danh sachs
                            Product selectedProduct = null;
                            for (Product p : productBUS.getList()) {
                                if (p.getMaSP().equals(masp)) {
                                    selectedProduct = p;
                                    break;
                                }
                            }

                            // hien thi thong tin chi tiet quyen
                            if (selectedProduct != null) {
                                JOptionPane.showMessageDialog(null, "Mã sản phẩm: " + selectedProduct.getMaSP()
                                        + "\nTên sản phẩm: " + selectedProduct.getTenSP()
                                        + "\nLoại sản phẩm: " + selectedProduct.getMaLSP()
                                        + "\nĐơn giá: " + selectedProduct.getDonGia()
                                        + "\nSố lượng: " + selectedProduct.getSoLuong());
                            } else {
                                JOptionPane.showMessageDialog(null, "Không tìm thấy quyền");

                            }
                        }
                    });
                    popup.show(tableSell, e.getX(), e.getY());
                }
            }
        });

        // search
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                performSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                performSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                performSearch();
            }

            public void performSearch() {
                String value = txtSearch.getText();
                ArrayList<Product> result = productBUS.search(value, "Tất cả", -1, -1, -1, -1, -1);
                setDataTable(result);
            }
        });

        // su kien khi nhan chon khach hang
        btnChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormChooseCustomer formChooseCustomer = new FormChooseCustomer();
                formChooseCustomer.setCustomerSelectedListener(new FormSell.CustomerSelectedListener() {
                    @Override
                    public void onCustomerSelected(Customer customer) {
                        txtKhachHang.setText(customer.getTenKh() + " - " + customer.getMaKH());
                    }
                });
                formChooseCustomer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                formChooseCustomer.pack();
                formChooseCustomer.setSize(1000, 800);
                formChooseCustomer.setLocationRelativeTo(null);
                formChooseCustomer.setVisible(true);
            }
        });

        // su kien khi nhan chon khuyen mai
        btnChooseKm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FormChoosePromotion formChoosePromotion = new FormChoosePromotion();
                formChoosePromotion.setPromotionSelectedListener(new FormSell.PromotionSelectedListener() {
                    @Override
                    public void onPromotionSelected(Promotion promotion) {
                        txtMaKhuyenMai.setText(promotion.getMaKhuyenMai());
                    }
                });
                formChoosePromotion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                formChoosePromotion.pack();
                formChoosePromotion.setSize(1000, 800);
                formChoosePromotion.setLocationRelativeTo(null);
                formChoosePromotion.setVisible(true);
            }
        });

        // cap nhat tong tien sau khi chon khuyen mai
        txtMaKhuyenMai.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                updateTotalPrice();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                updateTotalPrice();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                updateTotalPrice();
            }
        });

        // khi chọn sản phẩm bên tableSell2 và nhấn nút xóa
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectedRow = tableSell2.getSelectedRow();
                if (selectedRow != -1) {
                    // Xóa sản phẩm từ danh sách chi tiết hóa đơn
                    dscthd.remove(selectedRow);
                    // Cập nhật lại tableSell2
                    setDataToTableInvoiceDetais(dscthd);
                    // Cập nhật lại tổng tiền
                    updateTotalPrice();
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần xóa!");
                }
            }
        });

        // khi chọn sản phẩm bên tablseSell2 và nhấn nút làm mới
        btnReset2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // xoa tat ca cac san pham
                dscthd.clear();
                // cap nhat lai tableSell2
                setDataToTableInvoiceDetais(dscthd);
                // cap nhat tong tien
                updateTotalPrice();
            }
        });


//        // thanh toán
//        btnTong.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                FormInvoice formInvoice = new FormInvoice();
//                formInvoice.addDataToTable(dscthd);
//            }
//        });
    }

    public void setNhanVien(String nhanVien) {
        txtNhanvien.setText(nhanVien);
    }

    public JTextField getJTextField() {
        return txtNhanvien;
    }

    public interface CustomerSelectedListener {
        void onCustomerSelected(Customer customer);
    }

    public interface PromotionSelectedListener {
        void onPromotionSelected(Promotion promotion);
    }

    public String[] getHeaderSell1() {
        return new String[] { "Mã sản phẩm", "Mã loại", "Tên", "Đơn giá", "Số lượng",
        };
    }

    public String[] getHeaderSell2() {
        return new String[] { "STT", "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng", "Thành tiền",
        };
    }
    private int getRowCount() {
        return tableSell2.getRowCount();
    }
    public void refresh() {
        productBUS.Listsp();
        setDataTable(productBUS.getList());
//        setDataToTableInvoiceDetais(dscthd);
    }
    public void addDetails(String maSP, int soLuong) {
        Product product = productBUS.getProduct(maSP);
        Boolean checkSoLuong = false;
        for (InvoiceDetail cthd : dscthd) {
            if (cthd.getMaSanPham().equals(maSP)) {
                int tongSoLuong = soLuong + cthd.getSoLuong();
                if (tongSoLuong > product.getSoLuong()) {
                    JOptionPane.showMessageDialog(this, "Số lượng sản phẩm trong kho không đủ (" + product.getSoLuong() + ")");
                    return;
                } else {
                    cthd.setSoLuong(tongSoLuong);
                    checkSoLuong = true;
                }
            }
//            setDataToTableInvoiceDetais(dscthd);
        }
        if (!checkSoLuong) {
            if(soLuong > product.getSoLuong()) {
                JOptionPane.showMessageDialog(this, "Số lượng sản phẩm trong kho không đủ (" + product.getSoLuong() + ")");
                return;
            }
            InvoiceDetail invoiceDetail = new InvoiceDetail(invoiceBUS.getNextID(), maSP, soLuong, product.getDonGia());
            dscthd.add(invoiceDetail);
        }
        updateTotalPrice();
        setDataToTableInvoiceDetais(dscthd);
    }

    public void updateTotalPrice() {
        float total = 0;
        for (InvoiceDetail detail : dscthd) {
            total += detail.getDonGia() * detail.getSoLuong();
        }

        // lay ma khuyen mai tu txtKhuyenMai
        String maKhuyenMai = txtMaKhuyenMai.getText();

        // Lay thong tin khuyen mai tu ma khuyen mai
        Promotion promotion = promotionBUS.getKhuyenMai(maKhuyenMai);

        // kiem tra xem khuyen mai co ton tai khong
        if (promotion != null) {
            total = total - (total * promotion.getPhanTramKhuyenMai() / 100);
        }

        txtTongTien.setText(String.valueOf(total));
    }

    public void refreshAll() {
        // refreshTable();
        txtMaSP.setText("");
        txtLoaiSP.setText("");
        txtTenSP.setText("");
        txtDonGia.setText("");
        txtSoLuong.setText("");
        image.setIcon(null);
    }

    public void showInfo(String maSP, int soLuong) {
        if (maSP != null) {
            for (Product product : productBUS.getList()) {
                if (product.getMaSP().equals(maSP)) {
                    int w = image.getWidth();
                    int h = image.getHeight();
                    ImageIcon lbImage = new ImageIcon(
                            getClass().getResource("/images/Product Images/" + product.getHinhAnh()));
                    Image imageScaled = lbImage.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT);
                    image.setIcon(new ImageIcon(imageScaled));
                    String loai = typeProductBUS.getLoaiSanPham(product.getMaLSP()).getTenLoaiSanPham();
                    txtMaSP.setText(product.getMaSP());
                    txtTenSP.setText(product.getTenSP());
                    txtLoaiSP.setText(loai + "-" + product.getMaLSP());
                    txtDonGia.setText(PriceFormatter.format(product.getDonGia()));
                    txtSoLuong.setText(String.valueOf(soLuong));
                    return ;

                }

            }
        }}

    private void setDataTable(ArrayList<Product> data) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("STT");
        model.addColumn("Mã sản phẩm");
        model.addColumn("Mã loại");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Đơn giá");
        model.addColumn("Số lượng");
        int stt = 1;
        for (Product i : productBUS.getList()) {
            model.addRow(new Object[] {
                    stt++,
                    i.getMaSP(),
                    i.getMaLSP(),
                    i.getTenSP(),
                    i.getDonGia(),
                    i.getSoLuong()
            });
        }
        tableSell.setModel(model);

    }
    // hiẹn thị danh sách đã thêm vào tableSell2  dscthd
    public void setDataToTableInvoiceDetais(ArrayList<InvoiceDetail> data) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("STT");
        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Số lượng");
        model.addColumn("Đơn giá");
        model.addColumn("Thành tiền");

        float tongtien = 0;
        int stt = 1;
        for (InvoiceDetail cthd : dscthd) {

            String masp = cthd.getMaSanPham();
            Product sp = productBUS.getProduct(masp);
            String tensp = sp.getTenSP();
            int soluong = cthd.getSoLuong();
            float dongia = cthd.getDonGia();
            float thanhtien = soluong * dongia;

            model.addRow(new String[]{
                    String.valueOf(stt),
                    masp,
                    tensp,
                    String.valueOf(soluong),
                    PriceFormatter.format(dongia),
                    PriceFormatter.format(thanhtien)
            });
            stt++;
            tongtien += thanhtien;
        }
        tableSell2.setModel(model);
    }

    private JPanel panel1;
    private JPanel panel4;
    private JPanel panel2;
    private JTextField txtSearch;
    private JButton btnReset;
    private JScrollPane scrollPane2;
    private JTable tableSell;
    private JPanel panel5;
    private JPanel panel6;
    private JTextField txtMaSP;
    private JTextField txtLoaiSP;
    private JTextField txtTenSP;
    private JTextField txtDonGia;
    private JTextField txtSoLuong;
    private JLabel image;
    private JButton btnAdd;
    private JPanel panel7;
    private JPanel panel8;
    private JPanel panel9;
    private JTextField txtMaHoaDon;
    private JTextField textField10;
    private JTextField txtTongTien;
    private JTextField txtKhachHang;
    private JTextField txtNhanvien;
    private JTextField txtNgayLap;
    private JTextField txtGioLap;
    private JTextField txtMaKhuyenMai;
    private JPanel panel10;
    private JPanel panel11;
    private JButton btnXoa;
    private JButton btnSua;
    private JButton btnReset2;
    private JButton btnChoose;
    private JButton btnChooseKm;
    private JTextField textField2;
    private JScrollPane scrollPane1;
    private JTable tableSell2;
    private JPanel panel12;
    private JPanel panel13;
    private JButton btnHuy;
    private JButton btnTong;
    private JComboBox comboBox;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

