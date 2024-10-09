package Layout.models.FrontEnd.FormBanHang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
//import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
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

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

/*
 * Created by JFormDesigner on Mon Apr 15 21:55:53 ICT 2024
 */
import Layout.models.BackEnd.BUS.CustomerBUS;
import Layout.models.BackEnd.BUS.InvoiceBUS;
import Layout.models.BackEnd.BUS.ProductBUS;
import Layout.models.BackEnd.BUS.PromotionBUS;
import Layout.models.BackEnd.BUS.StaffBUS;
import Layout.models.BackEnd.BUS.TypeProductBUS;
import Layout.models.BackEnd.DAO.InvoiceDAO;
import Layout.models.BackEnd.DAO.InvoiceDetailDAO;
import Layout.models.BackEnd.DTO.Customer;
import Layout.models.BackEnd.DTO.Invoice;
import Layout.models.BackEnd.DTO.InvoiceDetail;
import Layout.models.BackEnd.DTO.Product;
import Layout.models.BackEnd.DTO.Promotion;
import Layout.models.BackEnd.DTO.Staff;
import Layout.models.FrontEnd.FormInvoice.FormInvoice;
import Layout.models.FrontEnd.FormLogin.FormLogin;
import Layout.models.FrontEnd.FormPromotion.FormChoosePromotion;
import Layout.models.FrontEnd.Formatter.PriceFormatter;
import Layout.models.WritePDF.WritePDF;

/**
 * @author m1lt43
 */
public class FormSell extends JPanel {
    private FormInvoice formInvoice;

    ProductBUS productBUS = new ProductBUS();
    PromotionBUS promotionBUS = new PromotionBUS();
    TypeProductBUS typeProductBUS = new TypeProductBUS();
    ArrayList<InvoiceDetail> dscthd = new ArrayList<>();
    InvoiceBUS invoiceBUS = new InvoiceBUS();
    StaffBUS staffBUS = new StaffBUS();
    CustomerBUS customerBUS = new CustomerBUS();

    public FormSell(FormInvoice formInvoice) {
        this.formInvoice = formInvoice;
        initComponents();
        refresh();
    }

    public void setFormSell(FormInvoice formInvoice) {
        this.formInvoice = formInvoice;
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    public ArrayList<InvoiceDetail> getDscthd() {
        return dscthd;
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

        java.awt.Font font = new java.awt.Font("Segoe UI", 0, 16);
        java.awt.Font fontHeader = new java.awt.Font("Segoe UI", Font.BOLD, 16);
        // ======== this ========
        setBorder(new javax.swing.border.CompoundBorder(
                new TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0), "", TitledBorder.CENTER,
                        TitledBorder.BOTTOM, new java.awt.Font("D\u0069al\u006fg", Font.BOLD, 12), Color.red),
                getBorder()));
        addPropertyChangeListener(
                new java.beans.PropertyChangeListener() {
                    @Override
                    public void propertyChange(java.beans.PropertyChangeEvent e) {
                        if ("\u0062or\u0064er"
                                .equals(e.getPropertyName()))
                            throw new RuntimeException();
                    }
                });
        setLayout(new BorderLayout());

        // ======== panel1 ========
        {
            panel1.setLayout(new BorderLayout());
        }
        add(panel1, BorderLayout.NORTH);

        // ======== panel4 ========
        {
            panel4.setMinimumSize(new Dimension(600, 132));
            panel4.setPreferredSize(new Dimension(650, 631));
            panel4.setLayout(new BorderLayout());

            // ======== panel2 ========
            {
                panel2.setLayout(new FlowLayout());

                // ===== comboBox =====
                comboBox.setPreferredSize(new Dimension(110, 35));
                String items[] = { "Tất cả", "Mã sản phẩm", "Mã loại", "Tên", "Đơn giá", "Số lượng" };
                for (String item : items) {
                    comboBox.addItem(item);
                }
                panel2.add(comboBox);

                // ---- txtSearch ----
                txtSearch.setPreferredSize(new Dimension(180, 60));
                txtSearch.setBorder(new TitledBorder(null, "T\u00ecm ki\u1ebfm:", TitledBorder.LEADING,
                        TitledBorder.DEFAULT_POSITION, null, Color.black));
                panel2.add(txtSearch);

                // ---- btnReset ----
                btnReset.setText("L\u00e0m m\u1edbi");
                btnReset.setIcon(new ImageIcon(getClass().getResource("/images/icons8_data_backup_30px.png")));
                btnReset.setPreferredSize(new Dimension(120, 40));
                panel2.add(btnReset);
            }
            panel4.add(panel2, BorderLayout.NORTH);

            // ======== scrollPane2 ========
            {

                // ---- tableSell ---
                tableSell.setFont(font);
                tableSell.getTableHeader().setFont(fontHeader);
                tableSell.setRowHeight(30);
                TableColumnModel columnModel = tableSell.getColumnModel();
                for (int i = 0; i < columnModel.getColumnCount(); i++) {
                    columnModel.getColumn(i).setPreferredWidth(150);
                }
                tableSell.setBorder(new BevelBorder(BevelBorder.LOWERED));
                // tableSell.setCellSelectionEnabled(true);
                tableSell.setModel(new DefaultTableModel(
                        new Object[][] {
                                { null, null, null, null, null },
                        },
                        getHeaderSell1()));

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

                                showInfo(maSP, 1);
                            }
                        }
                    }
                });

                scrollPane2.setViewportView(tableSell);
            }
            panel4.add(scrollPane2, BorderLayout.CENTER);

            // ======== panel5 ========
            {
                panel5.setPreferredSize(new Dimension(400, 200));
                panel5.setLayout(new BorderLayout());

                // ======== panel6 ========
                {
                    panel6.setPreferredSize(new Dimension(200, 40));
                    panel6.setAutoscrolls(true);
                    panel6.setBorder(new EtchedBorder());
                    panel6.setLayout(new FlowLayout(FlowLayout.CENTER, 7, 7));

                    // ---- txtMaSP ----
                    txtMaSP.setPreferredSize(new Dimension(140, 60));
                    txtMaSP.setBorder(new TitledBorder(null, "M\u00e3 s\u1ea3n ph\u1ea9m:", TitledBorder.LEADING,
                            TitledBorder.DEFAULT_POSITION, null, Color.black));
                    panel6.add(txtMaSP);

                    // ---- txtLoaiSP ----
                    txtLoaiSP.setPreferredSize(new Dimension(140, 60));
                    txtLoaiSP.setBorder(new TitledBorder(null, "Lo\u1ea1i s\u1ea3n ph\u1ea9m:", TitledBorder.LEADING,
                            TitledBorder.DEFAULT_POSITION, null, Color.black));
                    panel6.add(txtLoaiSP);

                    // ---- txtTenSP ----
                    txtTenSP.setPreferredSize(new Dimension(140, 60));
                    txtTenSP.setBorder(new TitledBorder(null, "T\u00ean s\u1ea3n ph\u1ea9m", TitledBorder.LEADING,
                            TitledBorder.DEFAULT_POSITION, null, Color.black));
                    panel6.add(txtTenSP);

                    // ---- txtDonGia ----
                    txtDonGia.setPreferredSize(new Dimension(140, 60));
                    txtDonGia.setBorder(new TitledBorder(null, "\u0110\u01a1n gi\u00e1:", TitledBorder.LEADING,
                            TitledBorder.DEFAULT_POSITION, null, Color.black));
                    panel6.add(txtDonGia);

                    // ---- txtSoLuong ----
                    txtSoLuong.setPreferredSize(new Dimension(140, 60));
                    txtSoLuong.setBorder(new TitledBorder(null, "S\u1ed1 l\u01b0\u1ee3ng", TitledBorder.LEADING,
                            TitledBorder.DEFAULT_POSITION, null, Color.black));

                    // nhap tu ban phim la so nguyen duong
                    txtSoLuong.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyTyped(KeyEvent e) {
                            char c = e.getKeyChar();
                            if (!((c >= '0') && (c <= '9') ||
                                    (c == KeyEvent.VK_BACK_SPACE) ||
                                    (c == KeyEvent.VK_DELETE))) {
                                getToolkit().beep();
                                e.consume();
                            }
                        }
                    });

                    panel6.add(txtSoLuong);
                }
                panel5.add(panel6, BorderLayout.CENTER);

                // ---- image ----
                image.setPreferredSize(new Dimension(160, 100));
                image.setForeground(Color.black);
                image.setFocusTraversalPolicyProvider(true);
                image.setBackground(Color.black);
                image.setBorder(LineBorder.createBlackLineBorder());
                panel5.add(image, BorderLayout.WEST);

                // ---- btnAdd ----
                btnAdd.setText("Th\u00eam");
                btnAdd.setIcon(new ImageIcon(getClass().getResource("/images/icons8_add_30px.png")));
                btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                panel5.add(btnAdd, BorderLayout.SOUTH);
            }
            panel4.add(panel5, BorderLayout.SOUTH);
        }
        add(panel4, BorderLayout.WEST);

        // ======== panel7 ========
        {
            panel7.setLayout(new BorderLayout());
        }
        add(panel7, BorderLayout.EAST);

        // ======== panel8 ========
        {
            panel8.setPreferredSize(new Dimension(550, 526));
            panel8.setLayout(new BorderLayout());

            // ======== panel9 ========
            {
                panel9.setPreferredSize(new Dimension(630, 200));
                panel9.setAutoscrolls(true);
                panel9.setLayout(new FlowLayout(FlowLayout.LEFT, 9, 9));

                // ---- txtMaHoaDon ----
                txtMaHoaDon.setPreferredSize(new Dimension(150, 55));
                txtMaHoaDon.setBorder(new TitledBorder(null, "M\u00e3 ho\u00e1 \u0111\u01a1n", TitledBorder.LEADING,
                        TitledBorder.DEFAULT_POSITION, null, Color.black));
                String nextInvoiceID = invoiceBUS.getNextID();
                txtMaHoaDon.setText(nextInvoiceID);
                txtMaHoaDon.setEnabled(false);
                // panel9.add(txtMaHoaDon);

                // ---- textField10 ----
                textField10.setPreferredSize(new Dimension(0, 55));

                // panel9.add(textField10);

                // ---- txtTongTien ----
                txtTongTien.setPreferredSize(new Dimension(500, 55));
                txtTongTien.setBorder(new TitledBorder(null, "T\u1ed5ng ti\u1ec1n(tri\u1ec7u VND)",
                        TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                // panel9.add(txtTongTien);
                txtTongTien.setEnabled(false);

                // ---- txtKhachHang ----
                txtKhachHang.setPreferredSize(new Dimension(150, 55));
                txtKhachHang.setBorder(new TitledBorder(null, "Kh\u00e1ch h\u00e0ng", TitledBorder.LEADING,
                        TitledBorder.DEFAULT_POSITION, null, Color.black));
                // panel9.add(txtKhachHang);
                txtKhachHang.setEnabled(false);

                // ===== btnchoose =====
                btnChoose.setText("");
                btnChoose.setIcon(new ImageIcon(getClass().getResource("/images/icons8_user_30px.png")));
                btnChoose.setPreferredSize(new Dimension(50, 50));
                // panel9.add(btnChoose);

                // ---- txtNhanvien ----
                txtNhanvien.setPreferredSize(new Dimension(150, 55));
                txtNhanvien.setBorder(new TitledBorder(null, "Nh\u00e2n vi\u00ean", TitledBorder.LEADING,
                        TitledBorder.DEFAULT_POSITION, null, Color.black));
                // panel9.add(txtNhanvien);
                Staff staff = new Staff();
                staff = staffBUS.getStaff(FormLogin.loggedInMaNV);
                if (staff != null) {
                    txtNhanvien.setText(staff.getTenNV() + "-" + staff.getMaNV());
                } else {
                    txtNhanvien.setText("Không tìm thấy nhân viên");
                }

                txtNhanvien.setEnabled(false);
                // ---- txtNgayLap ----
                txtNgayLap.setPreferredSize(new Dimension(150, 55));
                txtNgayLap.setBorder(new TitledBorder(null, "Ng\u00e0y l\u1eadp", TitledBorder.LEADING,
                        TitledBorder.DEFAULT_POSITION, null, Color.black));
                txtNgayLap.setText(currentDate);
                txtNgayLap.setEnabled(false);
                // panel9.add(txtNgayLap);

                // ===== txtGioLap =====
                txtGioLap.setPreferredSize(new Dimension(150, 55));
                txtGioLap.setBorder(new TitledBorder(null, "Giờ lập", TitledBorder.LEADING,
                        TitledBorder.DEFAULT_POSITION, null, Color.black));
                txtGioLap.setText(currentTime);
                txtGioLap.setEnabled(false);
                // panel9.add(txtGioLap);

                // ---- txtMaKhuyenMai ----
                txtMaKhuyenMai.setPreferredSize(new Dimension(150, 55));
                txtMaKhuyenMai.setBorder(new TitledBorder(null, "Mã khuyến mãi", TitledBorder.LEADING,
                        TitledBorder.DEFAULT_POSITION, null, Color.black));
                // panel9.add(txtMaKhuyenMai);
                txtMaKhuyenMai.setEnabled(false);

                // ===== btnChooseKm =======
                btnChooseKm.setText("");
                btnChooseKm.setIcon(new ImageIcon(getClass().getResource("/images/icons8_gift_30px.png")));
                btnChooseKm.setPreferredSize(new Dimension(50, 50));
                // panel9.add(btnChooseKm);

                // Tạo JPanel mới với GridLayout
                JPanel textFieldPanel = new JPanel(new GridLayout(2, 4));
                textFieldPanel.add(txtMaHoaDon);
                textFieldPanel.add(txtNhanvien);
                textFieldPanel.add(txtKhachHang);
                JPanel buttonPanel = new JPanel();
                buttonPanel.add(btnChoose);
                textFieldPanel.add(buttonPanel);
                textFieldPanel.add(txtNgayLap);
                textFieldPanel.add(txtGioLap);
                textFieldPanel.add(txtMaKhuyenMai);
                JPanel buttonPanel2 = new JPanel();
                buttonPanel2.add(btnChooseKm);
                textFieldPanel.add(buttonPanel2);

                panel9.add(textFieldPanel);
                panel9.add(txtTongTien);
            }
            panel8.add(panel9, BorderLayout.NORTH);

            // ======== panel10 ========
            {
                panel10.setLayout(new BorderLayout());

                // ======== panel11 ========
                {
                    panel11.setLayout(new FlowLayout());

                    // ---- btnXoa ----
                    btnXoa.setText("Xo\u00e1");
                    btnXoa.setIcon(new ImageIcon(getClass().getResource("/images/icons8_delete_forever_30px_1.png")));
                    panel11.add(btnXoa);

                    // ---- btnSua ----
                    btnSua.setText("S\u1eeda");
                    btnSua.setIcon(new ImageIcon(getClass().getResource("/images/icons8_support_30px.png")));
                    // panel11.add(btnSua);

                    // ---- btnReset2 ----
                    btnReset2.setText("L\u00e0m m\u01a1i");
                    btnReset2.setIcon(new ImageIcon(getClass().getResource("/images/icons8_data_backup_30px.png")));
                    panel11.add(btnReset2);

                    // ---- textField2 ----
                    textField2.setPreferredSize(new Dimension(360, 40));
                    textField2.setBorder(new TitledBorder(null, "T\u00ecm ki\u1ebfm:", TitledBorder.LEADING,
                            TitledBorder.DEFAULT_POSITION, null, Color.black));
                    // panel11.add(textField2);
                }
                panel10.add(panel11, BorderLayout.PAGE_END);

                // ======== scrollPane1 ========
                {

                    // ---- tableSell2 ----

                    // set font for the table
                    tableSell2.setFont(font);
                    tableSell2.getTableHeader().setFont(fontHeader);
                    tableSell2.setRowHeight(30);
                    TableColumnModel columnModel = tableSell2.getColumnModel();
                    for (int i = 0; i < columnModel.getColumnCount(); i++) {
                        columnModel.getColumn(i).setPreferredWidth(150);
                    }
                    tableSell2.setBorder(new BevelBorder(BevelBorder.LOWERED));
                    // tableSell2.setCellSelectionEnabled(true);
                    tableSell2.setModel(new DefaultTableModel(
                            new Object[][] {
                                    { null, null, null, null, null },
                            },
                            getHeaderSell2()));
                    // tableSell2.setFillsViewportHeight(true);
                    // tableSell2.setSurrendersFocusOnKeystroke(true);
                    // tableSell2.setShowVerticalLines(true);
                    // tableSell2.setShowHorizontalLines(true);
                    scrollPane1.setViewportView(tableSell2);
                }
                panel10.add(scrollPane1, BorderLayout.CENTER);
            }
            panel8.add(panel10, BorderLayout.CENTER);

            // ======== panel12 ========
            {
                panel12.setLayout(new FlowLayout());
            }
            panel8.add(panel12, BorderLayout.WEST);

            // ======== panel13 ========
            {
                panel13.setLayout(new FlowLayout(FlowLayout.RIGHT));

                // ---- btnHuy ----
                btnHuy.setText("Hu\u1ef7");
                btnHuy.setIcon(new ImageIcon(getClass().getResource("/images/icons8_cancel_30px_1.png")));
                // panel13.add(btnHuy);

                // ---- btnTong ----
                btnTong.setText("Thanh toán");
                // btnTong.setEnabled(false);
                btnTong.setIcon(new ImageIcon(getClass().getResource("/images/icons8_us_dollar_30px.png")));
                btnTong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                panel13.add(btnTong);
            }
            panel8.add(panel13, BorderLayout.SOUTH);
        }
        add(panel8, BorderLayout.CENTER);
        // btn Add
        // updateBtnTongState();
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String maSP = txtMaSP.getText();
                    int soluong = Integer.parseInt(txtSoLuong.getText());
                    if (soluong > 0) {
                        addDetails(maSP, soluong);
                    } else {
                        JOptionPane.showMessageDialog(txtSoLuong, "Số lượng phải là số dương!");
                        txtSoLuong.requestFocus();
                    }
                } catch (NumberFormatException ea) {
                    JOptionPane.showMessageDialog(txtSoLuong, "Số lượng phải là số nguyên!");
                    txtSoLuong.requestFocus();
                }

            }
        });
        updateBtnTongState();
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
                String keyWord = txtSearch.getText();
                System.out.println(keyWord);
                String type = (String) comboBox.getSelectedItem();
                System.out.println(type);
                ArrayList<Product> result = productBUS.searchProduct(keyWord, type);
                System.out.println(result);
                setDataTable(result);
            }
        });

        // su kien khi nhan chon khach hang
        btnChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormChooseCustomer form = new FormChooseCustomer();
                form.setCustomerSelectedListener(new CustomerSelectedListener() {
                    @Override
                    public void onCustomerSelected(Customer customer) {
                        txtKhachHang.setText(customer.getTenKh() + "-" + customer.getMaKH());
                    }
                });
                form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                form.pack();
                form.setSize(1000, 800);
                form.setLocationRelativeTo(null);
                form.setVisible(true);
            }
        });

        // su kien khi nhan chon khuyen mai
        btnChooseKm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FormChoosePromotion formChoosePromotion = new FormChoosePromotion();
                formChoosePromotion.setPromotionSelectedListener(new PromotionSelectedListener() {
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
                int[] selectedRows = tableSell2.getSelectedRows();

                for (int i = selectedRows.length - 1; i >= 0; i--) {
                    dscthd.remove(selectedRows[i]);

                    ((DefaultTableModel) tableSell2.getModel()).removeRow(selectedRows[i]);
                }

                updateTotalPrice();
            }
        });

        // khi chọn sản phẩm bên tablseSell2 và nhấn nút làm mới
        btnReset2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                // xoa tat ca cac san pham
                dscthd.clear();
                txtMaSP.setText("");
                txtLoaiSP.setText("");
                txtTenSP.setText("");
                txtDonGia.setText("");
                txtSoLuong.setText("");
                image.setIcon(null);
                txtTongTien.setText("");
                txtKhachHang.setText("");
                txtMaKhuyenMai.setText("");
                // cap nhat lai tableSell2
                setDataToTableInvoiceDetais(dscthd);
                // cap nhat tong tien
                updateTotalPrice();

                // Tăng mã hóa đơn lên 1 đơn vị

                // tạo định dạng ngày và giờ
                // Tạo định dạng ngày và giờ
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

                // Lấy thời gian hiện tại
                LocalDateTime now = LocalDateTime.now();

                // Định dạng ngày và giờ hiện tại
                String currentDate = now.format(dateFormatter);
                String currentTime = now.format(timeFormatter);

                // Cập nhật ngày lập và giờ lập
                txtNgayLap.setText(currentDate);
                txtGioLap.setText(currentTime);
            }
        });

        // thanh toan
        btnTong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tạo một đối tượng Invoice mới từ các trường nhập liệu
                Invoice newInvoice = new Invoice();
                newInvoice.setMaHoaDon(txtMaHoaDon.getText());

                // kiem tra hoa don co trung hay khong
                String maHoaDon = txtMaHoaDon.getText();
                if (invoiceBUS.checkInvoiceExist(maHoaDon)) {
                    JOptionPane.showMessageDialog(null, "Mã hóa đơn đã tồn tại! ");
                    String currentInvoiceId = txtMaHoaDon.getText();
                    int i = currentInvoiceId.length() - 1;
                    while (i >= 0 && Character.isDigit(currentInvoiceId.charAt(i))) {
                        i--;
                    }
                    if (i + 1 <= currentInvoiceId.length()) {
                        String prefix = currentInvoiceId.substring(0, i + 1); // Lấy phần tiền tố
                        int nextInvoiceId = Integer.parseInt(currentInvoiceId.substring(i + 1)) + 1;
                        // Tăng số
                        txtMaHoaDon.setText(prefix + nextInvoiceId); // Gán mã hóa đơn mới
                    }
                    JOptionPane.showMessageDialog(null, "Mã hóa đơn mới đã được cập! ");

                    return;
                }

                newInvoice.setMaNhanVien(txtNhanvien.getText().split("-")[1]);
                String khachHang = txtKhachHang.getText();
                if (khachHang.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng!");
                    return;
                }
                newInvoice.setMaKhachHang(txtKhachHang.getText().split("-")[1]);
                String maKhuyenMai = txtMaKhuyenMai.getText();
                if (maKhuyenMai.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn mã khuyến mãi!");
                    return;
                }
                newInvoice.setMaKhuyenMai(txtMaKhuyenMai.getText());
                String formattedTotalPrice = txtTongTien.getText();
                float totalPrice = PriceFormatter.parsePrice(formattedTotalPrice); // bỏ format
                newInvoice.setTongTien(totalPrice);

                // Định dạng ngày và giờ
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                newInvoice.setNgayLap(LocalDate.parse(txtNgayLap.getText(), dateFormatter));
                newInvoice.setGioLap(LocalTime.parse(txtGioLap.getText(), timeFormatter));

                // **Thêm hộp thoại xác nhận trước khi thanh toán**
                int confirmResult = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc chắn muốn thanh toán không?", "Xác nhận thanh toán",
                        JOptionPane.YES_NO_OPTION);

                if (confirmResult == JOptionPane.YES_OPTION) {
                    // Nếu người dùng chọn "Yes", tiếp tục thanh toán

                    // Thêm đối tượng Invoice mới vào danh sách hóa đơn
                    InvoiceDAO invoiceDAO = new InvoiceDAO();
                    invoiceDAO.addInvoice(newInvoice);

                    // Thêm chi tiết hóa đơn
                    InvoiceDetailDAO invoiceDetailDAO = new InvoiceDetailDAO();
                    DefaultTableModel model = (DefaultTableModel) tableSell2.getModel();
                    for (int i = 0; i < model.getRowCount(); i++) {
                        InvoiceDetail detail = new InvoiceDetail();
                        detail.setMaHoaDon(newInvoice.getMaHoaDon());
                        detail.setMaSanPham(model.getValueAt(i, 1).toString()); // Mã sản phẩm
                        detail.setSoLuong(Integer.parseInt(model.getValueAt(i, 3).toString())); // Số lượng
                        String formattedPrice = tableSell2.getValueAt(i, 4).toString();
                        float price = PriceFormatter.parsePrice(formattedPrice); // bỏ format
                        detail.setDonGia(price);
                        invoiceDetailDAO.add(detail);
                    }

                    // In hóa đơn
                    int dialogResult = JOptionPane.showConfirmDialog(null,
                            "Thanh toán thành công! Bạn có muốn in hóa đơn không?", "In hóa đơn",
                            JOptionPane.YES_NO_OPTION);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        WritePDF writePDF = new WritePDF();
                        writePDF.writePhieuXuat(newInvoice);
                    }

                    for (InvoiceDetail cthd : dscthd) {
                        Product product = productBUS.getProduct(cthd.getMaSanPham());
                        product.setSoLuong(product.getSoLuong() - cthd.getSoLuong());
                        productBUS.update(product);
                    }
                    setDataTable(productBUS.getList());

                    // Tạo mã hóa đơn mới
                    String currentInvoiceId = txtMaHoaDon.getText();
                    int i = currentInvoiceId.length() - 1;
                    while (i >= 0 && Character.isDigit(currentInvoiceId.charAt(i))) {
                        i--;
                    }
                    if (i + 1 <= currentInvoiceId.length()) {
                        String prefix = currentInvoiceId.substring(0, i + 1); // Lấy phần tiền tố
                        int nextInvoiceId = Integer.parseInt(currentInvoiceId.substring(i + 1)) + 1; // Tăng số
                        txtMaHoaDon.setText(prefix + nextInvoiceId); // Gán mã hóa đơn mới
                    }

                } else {
                    // Nếu người dùng chọn "No", không thực hiện hành động nào
                    JOptionPane.showMessageDialog(null, "Thanh toán đã bị hủy.", "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private void updateBtnTongState() {
        DefaultTableModel model = (DefaultTableModel) tableSell2.getModel();
        btnTong.setEnabled(false);
        if (model.getRowCount() > 0) {
            btnTong.setEnabled(true);
        }
    }

    // hàm in hóa đơn
    public void printInvoice(Invoice invoice) {
        try {
            Document document = new Document();
            String invoiceId = invoice.getMaHoaDon();
            String filePath = "DataFilePDF/Invoice/Invoice " + invoiceId + ".pdf";
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            BaseFont bf = null;
            try {
                bf = BaseFont.createFont("/Arial Unicode MS Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            } catch (IOException e) {
                e.printStackTrace();
            }
            com.itextpdf.text.Font font = new com.itextpdf.text.Font(bf, 16);

            Paragraph title = new Paragraph("HÓA ĐƠN");
            title.setFont(font);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // lấy thông tin nhân viên
            Staff staff = staffBUS.getStaff(invoice.getMaNhanVien());
            String staffName = staff.getTenNV();

            // lấy thông tin khách hàng
            Customer customer = customerBUS.getCustomer(invoice.getMaKhachHang());
            String customerName = customer.getTenKh();

            // lấy thông tin khuyến mãi
            Promotion promotion = promotionBUS.getKhuyenMai(invoice.getMaKhuyenMai());
            String promotionName = promotion.getTenKhuyenMai();
            String promotionpercent = promotion.getPhanTramKhuyenMai() + "%";

            // them thong tin hoas don
            document.add(new Paragraph("Mã hóa đơn: " + invoice.getMaHoaDon()));
            document.add(new Paragraph("Nhân viên: " + staffName + " - " + invoice.getMaNhanVien()));
            document.add(new Paragraph("Khách hàng: " + customerName + " - " + invoice.getMaKhachHang()));
            document.add(new Paragraph(promotionpercent + " - " + promotionName));
            document.add(new Paragraph("Ngày lập: " + invoice.getNgayLap()));
            document.add(new Paragraph("Giờ lập: " + invoice.getGioLap()));

            // them thong tin chi tiet hoa don
            for (InvoiceDetail detail : dscthd) {
                Product product = productBUS.getProduct(detail.getMaSanPham());
                String productName = product.getTenSP();
                int quantity = detail.getSoLuong();
                float price = detail.getDonGia();

                document.add(new Paragraph("Tên sản phẩm: " + productName + " - " + detail.getMaSanPham()));
                document.add(new Paragraph("Số lượng: " + quantity));
                document.add(new Paragraph("Đơn giá: " + PriceFormatter.format(price)));
            }
            document.add(new Paragraph("Tổng tiền: " + PriceFormatter.format(invoice.getTongTien())));

            JOptionPane.showMessageDialog(null, "Hóa đơn đã được in thành công!");

            // close
            document.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void refreshTableData() {
        ArrayList<Invoice> invoiceList = invoiceBUS.getListInvoice();

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
        productBUS = new ProductBUS();
        productBUS.getList();
        ArrayList<Product> availableProducts = productBUS.getVailableProducts();
        setDataTable(availableProducts);
    }

    public void addDetails(String maSP, int soLuong) {
        Product product = productBUS.getProduct(maSP);
        Boolean checkSoLuong = false;
        for (InvoiceDetail cthd : dscthd) {
            if (cthd.getMaSanPham().equals(maSP)) {
                int tongSoLuong = soLuong + cthd.getSoLuong();
                if (tongSoLuong > product.getSoLuong()) {
                    JOptionPane.showMessageDialog(this,
                            "Số lượng sản phẩm trong kho không đủ (" + product.getSoLuong() + ")");
                    return;
                } else {
                    cthd.setSoLuong(tongSoLuong);
                    checkSoLuong = true;
                }
            }
            // setDataToTableInvoiceDetais(dscthd);
        }
        if (!checkSoLuong) {
            if (soLuong > product.getSoLuong()) {
                JOptionPane.showMessageDialog(this,
                        "Số lượng sản phẩm trong kho không đủ (" + product.getSoLuong() + ")");
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

        txtTongTien.setText(PriceFormatter.format(total));
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
                    txtMaSP.setEnabled(false);
                    txtTenSP.setText(product.getTenSP());
                    txtTenSP.setEnabled(false);
                    txtLoaiSP.setText(loai + "-" + product.getMaLSP());
                    txtLoaiSP.setEnabled(false);
                    txtDonGia.setText(PriceFormatter.format(product.getDonGia()));
                    txtDonGia.setEnabled(false);
                    txtSoLuong.setText(String.valueOf(soLuong));
                    // txtSoLuong.setEnabled(false);
                    txtSoLuong.requestFocus();
                    return;

                }

            }
        }
    }

    public void setDataTable(ArrayList<Product> data) {
        DefaultTableModel model = new DefaultTableModel();

        model.setRowCount(0);

        model.addColumn("STT");
        model.addColumn("Mã sản phẩm");
        model.addColumn("Mã loại");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Đơn giá");
        model.addColumn("Số lượng");

        int stt = 1;
        for (Product i : data) {
            model.addRow(new Object[] {
                    stt++,
                    i.getMaSP(),
                    i.getMaLSP(),
                    i.getTenSP(),
                    PriceFormatter.format(i.getDonGia()),
                    i.getSoLuong()
            });
        }
        tableSell.setModel(model);
    }

    // hiẹn thị danh sách đã thêm vào tableSell2 dscthd
    public void setDataToTableInvoiceDetais(ArrayList<InvoiceDetail> data) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("STT");

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

            model.addRow(new String[] {
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

    // getter cho cac phuong thuc nhap lieu de co the truy cap ngoai lop
    public String getMaHoaDon() {

        return txtMaHoaDon.getText();

    }

    public String getTongTien() {
        return txtTongTien.getText();
    }

    public String getKhachHang() {
        return txtKhachHang.getText();
    }

    public String getNhanVien() {
        return txtNhanvien.getText();
    }

    public String getNgayLap() {
        return txtNgayLap.getText();
    }

    public String getGioLap() {
        return txtGioLap.getText();
    }

    public String getMaKhuyenMai() {
        return txtMaKhuyenMai.getText();
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
