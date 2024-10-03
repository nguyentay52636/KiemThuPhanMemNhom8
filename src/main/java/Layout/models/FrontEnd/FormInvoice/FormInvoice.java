
package Layout.models.FrontEnd.FormInvoice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Layout.models.BackEnd.BUS.CustomerBUS;
import Layout.models.BackEnd.BUS.InvoiceBUS;
import Layout.models.BackEnd.BUS.InvoiceDetailBUS;
import Layout.models.BackEnd.BUS.PromotionBUS;
import Layout.models.BackEnd.BUS.StaffBUS;
import Layout.models.BackEnd.DTO.Invoice;
import Layout.models.FrontEnd.FormInvoiceDetails.FormInvoiceDetails;

/**
 * @author m1lt43
 */
public class FormInvoice extends JPanel {
    public static FormInvoice currentInstance;

    InvoiceBUS invoiceBUS = new InvoiceBUS();
    StaffBUS staffBUS = new StaffBUS();
    CustomerBUS customerBUS = new CustomerBUS();
    PromotionBUS promotionBUS = new PromotionBUS();
    InvoiceDetailBUS invoiceDetailsBUS = new InvoiceDetailBUS();

    public FormInvoice() {
        initComponents();
        refresh();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
    }

    private void textField1KeyTyped(KeyEvent e) {
        // TODO add your code here
    }

    // private void button4(ActionEvent e) {
    // FormDetailsInvoice detailsInvoice = new FormDetailsInvoice();
    // detailsInvoice.setVisible(true);
    // }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Teddy
        this2 = new JPanel();
        this3 = new JPanel();
        panel1 = new JPanel();
        btnAction = new JPanel();
        panel2 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        search = new JPanel();
        panel3 = new JPanel();
        comboBox1 = new JComboBox();
        textField1 = new JTextField();
        panel4 = new JPanel();
        textField2 = new JTextField();
        textField3 = new JTextField();
        panel5 = new JPanel();
        btnxemChiTiet = new JButton();
        btnReload = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel6 = new JPanel();
        panel7 = new JPanel();
        txtMaHoaDon = new JTextField();
        txtNhanVien = new JTextField();
        txtKhachHang = new JTextField();
        txtKhuyenMai = new JTextField();
        panel8 = new JPanel();
        txtNgayLap = new JTextField();
        txtTongTien = new JTextField();
        txtGioLap = new JTextField();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
                . swing. border. EmptyBorder( 0, 0, 0, 0) , "", javax. swing
                . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
                Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
        ) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
        public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName (
        ) )) throw new RuntimeException( ); }} );
        setLayout(new BorderLayout());

        //======== this2 ========
        {
            this2.setLayout(new BorderLayout());

            //======== this3 ========
            {
                this3.setLayout(new BorderLayout());

                //======== panel1 ========
                {
                    panel1.setLayout(new BorderLayout());

                    //======== btnAction ========
                    {
                        btnAction.setLayout(new BorderLayout());

                        //======== panel2 ========
                        {
                            panel2.setLayout(new FlowLayout());

                            //---- button1 ----
                            button1.setText("Xu\u1ea5t Excel");
                            button1.setIcon(new ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png")));
                            button1.setPreferredSize(new Dimension(130, 55));
                            button1.addActionListener(e -> {
                                button1(e);
                                button1(e);
                            });
                            panel2.add(button1);

                            //---- button2 ----
                            button2.setText("Nh\u1eadp Excel");
                            button2.setIcon(new ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png")));
                            button2.setPreferredSize(new Dimension(130, 55));
                            button2.addActionListener(e -> button2(e));
                            panel2.add(button2);

                            //
                            //

                        }
                        btnAction.add(panel2, BorderLayout.NORTH);

                        //======== search ========
                        {
                            search.setMinimumSize(new Dimension(1200, 76));
                            search.setLayout(new FlowLayout());

                            //======== panel3 ========
                            {
                                panel3.setBorder(new TitledBorder(null, "T\u00ecm ki\u1ebfm:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
//                                panel3.setMinimumSize(new Dimension(500, 49));
//                                panel3.setPreferredSize(new Dimension(220, 49));
                                panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
                                String[] items = { "Tất cả", "Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Mã khuyến mãi", "Ngày lập","Giờ lập","Tổng tiền" };
                                for (String item : items) {
                                    comboBox1.addItem(item);
                                }
                                comboBox1.setPreferredSize(new Dimension(130, 40));
                                panel3.add(comboBox1);

                                //---- textField1 ----
                                textField1.setPreferredSize(new Dimension(144, 55));
                                textField1.addKeyListener(new KeyAdapter() {
                                    @Override
                                    public void keyTyped(KeyEvent e) {
                                        textField1KeyTyped(e);
                                    }
                                });
                                panel3.add(textField1);
                            }
                            search.add(panel3);

                            //======== panel4 ========
                            {
                                panel4.setBorder(new TitledBorder(null, "Ng\u00e0y l\u1eadp:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
//                                panel4.setMinimumSize(new Dimension(220, 66));
//                                panel4.setPreferredSize(new Dimension(200, 62));
                                panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));

                                //---- textField2 ----
                                textField2.setBorder(new TitledBorder(null, "T\u1eeb:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                                textField2.setPreferredSize(new Dimension(80, 55));
                                panel4.add(textField2);

                                //---- textField3 ----
                                textField3.setBorder(new TitledBorder(null, "\u0110\u1ebfn:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                                textField3.setPreferredSize(new Dimension(80, 55));
                                panel4.add(textField3);
                            }
                            search.add(panel4);

                            //======== panel5 ========
                            {
                                panel5.setPreferredSize(new Dimension(300, 70));
                                panel5.setLayout(new BoxLayout(panel5, BoxLayout.X_AXIS));

                                //---- button4 ----
                                btnxemChiTiet.setText("Xem chi ti\u1ebft");
                                btnxemChiTiet.setPreferredSize(new Dimension(100, 100));
                                btnxemChiTiet.setIcon(new ImageIcon(getClass().getResource("/images/icons8_show_property_30px.png")));
                                btnxemChiTiet.setMaximumSize(new Dimension(160, 60));
                                btnxemChiTiet.setIconTextGap(3);
                                btnxemChiTiet.setMinimumSize(new Dimension(100, 40));
                                btnxemChiTiet.addActionListener(e -> {
                                    //			button4(e);
                                    //			button4(e);
                                });
                                panel5.add(btnxemChiTiet);

                                //---- button5 ----
                                btnReload.setText("L\u00e0m m\u1edbi");
                                btnReload.setIcon(new ImageIcon(getClass().getResource("/images/icons8_data_backup_30px.png")));
                                btnReload.setPreferredSize(new Dimension(100, 50));
                                btnReload.setMaximumSize(new Dimension(119, 60));
                                panel5.add(btnReload);
                            }
                            search.add(panel5);
                        }
                        btnAction.add(search, BorderLayout.CENTER);
                    }
                    panel1.add(btnAction, BorderLayout.NORTH);

                    //======== scrollPane1 ========
                    {    Font font = new Font("Segoe UI", 0, 16);
                        Font fontHeader = new Font("Segoe UI", Font.BOLD, 16);

                        // set font for the table
                        table1.setFont(font);
                        table1.getTableHeader().setFont(fontHeader);
                        table1.setRowHeight(30);
                        TableColumnModel columnModel = table1.getColumnModel();
                        for (int i = 0; i < columnModel.getColumnCount(); i++) {
                            columnModel.getColumn(i).setPreferredWidth(150);
                        }

                        ListSelectionModel selectionModel = table1.getSelectionModel();
                        selectionModel.addListSelectionListener(new ListSelectionListener() {
                            @Override
                            public void valueChanged(ListSelectionEvent e) {
                                if (!e.getValueIsAdjusting()) {
                                    // Lấy chỉ số hàng được chọn
                                    int selectedRow = table1.getSelectedRow();
                                    if (selectedRow != -1) {String maHD = (String) table1.getValueAt(selectedRow, 1);
                                        displayInfo(maHD);
                                    }
                                }
                            }
                        });
                        btnxemChiTiet.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int selectedRow = table1.getSelectedRow();
                                if (selectedRow != -1) {
                                    String maHD = table1.getValueAt(selectedRow, 1).toString();
                                    System.out.println("Selected MaHD: " + maHD);

                                    JFrame frame = new JFrame("Chi tiết hóa đơn");
                                    FormInvoiceDetails formInvoiceDetails = new FormInvoiceDetails(maHD);
                                    frame.add(formInvoiceDetails);
                                    frame.setSize(800, 600);
                                    frame.setLocationRelativeTo(null);
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setVisible(true);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn cần xem chi tiết");
                                }
                            }
                        });

                        //---- table1 ----
                        table1.setModel(new DefaultTableModel(
                                new Object[][] {
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},


                                },
                                invoiceBUS.getHeaders()
                        ));


                        table1.setFocusable(false);
                        table1.setAutoCreateRowSorter(true);
                        scrollPane1.setViewportView(table1);


                    }
                    panel1.add(scrollPane1, BorderLayout.CENTER);

                    //======== panel6 ========
                    {
                        panel6.setLayout(new GridLayout(3, 1));

                        //======== panel7 ========
                        {
                            panel7.setLayout(new FlowLayout());

                            //---- textField5 ----
                            txtMaHoaDon.setBorder(new TitledBorder(null, "M\u00e3 ho\u00e1 \u0111\u01a1n ", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                            txtMaHoaDon.setPreferredSize(new Dimension(200, 55));
                            panel7.add(txtMaHoaDon);

                            //---- textField6 ----
                            txtNhanVien.setBorder(new TitledBorder(null, "Nh\u00e2n vi\u00ean ", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                            txtNhanVien.setPreferredSize(new Dimension(200, 55));
                            panel7.add(txtNhanVien);

                            //---- textField7 ----
                            txtKhachHang.setBorder(new TitledBorder(null, "Kh\u00e1ch h\u00e0ng", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                            txtKhachHang.setPreferredSize(new Dimension(200, 55));
                            panel7.add(txtKhachHang);

                            //---- textField8 ----
                            txtKhuyenMai.setBorder(new TitledBorder(null, "Khuy\u1ebfn m\u00e3i", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                            txtKhuyenMai.setPreferredSize(new Dimension(200, 55));
                            panel7.add(txtKhuyenMai);
                        }
                        panel6.add(panel7);

                        //======== panel8 ========
                        {
                            panel8.setLayout(new FlowLayout());

                            //---- textField9 ----
                            txtNgayLap.setBorder(new TitledBorder(null, "T\u1ed5ng ti\u1ec1n (Tri\u1ec7u VN\u0110)", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                            txtNgayLap.setPreferredSize(new Dimension(200, 55));
                            panel8.add(txtNgayLap);

                            //---- textField10 ----
                            txtGioLap.setBorder(new TitledBorder(null, "Ng\u00e0y l\u1eadp", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                            txtGioLap.setPreferredSize(new Dimension(200, 55));
                            panel8.add(txtGioLap);

                            //---- textField11 ----
                            txtTongTien.setBorder(new TitledBorder(null, "Gi\u1edd l\u1eadp", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                            txtTongTien.setPreferredSize(new Dimension(200, 55));
                            panel8.add(txtTongTien);
                        }
                        panel6.add(panel8);
                    }
                    panel1.add(panel6, BorderLayout.SOUTH);
                }
                this3.add(panel1, BorderLayout.CENTER);
            }
            this2.add(this3, BorderLayout.CENTER);
        }
        add(this2, BorderLayout.CENTER);
        textField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) {
                perfomSearch();
            }
            @Override public void removeUpdate(DocumentEvent e) {
                perfomSearch();
            }
            @Override public void changedUpdate(DocumentEvent e) {
                perfomSearch();
            }


            public void perfomSearch() {
                String keyWord=  textField1.getText() ;
                String type = (String)comboBox1.getSelectedItem() ;
                ArrayList <Invoice> result = InvoiceBUS.search(keyWord,type);

                setDataToTable(result);
            }
        });

        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                performSearch();
            }

            public void performSearch() {
                String fromDate = textField2.getText();
                String toDate = textField3.getText();

                // Chuyển đổi từ String sang LocalDate
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                try {
                    LocalDate from = LocalDate.parse(fromDate, formatter);
                    LocalDate to = LocalDate.parse(toDate, formatter);

                    // Tìm kiếm hóa đơn có ngày lập nằm trong khoảng từ 'from' đến 'to'
                    ArrayList<Invoice> result = invoiceBUS.searchByDate(from, to);

                    // Cập nhật bảng với kết quả tìm kiếm
                    setDataToTable(result);
                } catch (DateTimeParseException e) {
                    System.out.println("Ngày không hợp lệ");
                }
            }
        };
        textField2.getDocument().addDocumentListener(documentListener);
        textField3.getDocument().addDocumentListener(documentListener);

        KeyListener keyListener = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '-') {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };
        textField2.addKeyListener(keyListener);
        textField3.addKeyListener(keyListener);

        btnReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comboBox1.setSelectedItem("Tất cả ");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                refresh();
            }

        });

        // xuat excel
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Chọn nơi lưu file");

                int userSelection = fileChooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();

                    Workbook workbook = new XSSFWorkbook();
                    Sheet sheet = workbook.createSheet("Hóa Đơn");

                    // tao row header
                    Row headerRow = sheet.createRow(0);
                    headerRow.createCell(0).setCellValue("STT");
                    headerRow.createCell(1).setCellValue("Mã hoá đơn");
                    headerRow.createCell(2).setCellValue("Mã nhân viên");
                    headerRow.createCell(3).setCellValue("Mã khách hàng");
                    headerRow.createCell(4).setCellValue("Mã khuyến mãi");
                    headerRow.createCell(5).setCellValue("Ngày lập");
                    headerRow.createCell(6).setCellValue("Giờ lập");
                    headerRow.createCell(7).setCellValue("Tổng tiền");

                    // them du lieu vao sheet
                    for (int i = 0; i < table1.getRowCount(); i++) {
                        Row row = sheet.createRow(i + 1);
                        for (int j = 0; j < table1.getColumnCount(); j++) {
                            row.createCell(j).setCellValue(table1.getValueAt(i, j).toString());
                        }
                    }

                    // ghi vao file
                    try (FileOutputStream outputStream = new FileOutputStream(fileToSave)) {
                        workbook.write(outputStream);
                        JOptionPane.showMessageDialog(null, "Xuất file thành công");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Xuất file không thành công");
                        e.printStackTrace();
                    }
                }
            }
        });

        // nhap excel
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Chọn file Excel");

                int userSelection = fileChooser.showOpenDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToOpen = fileChooser.getSelectedFile();

                    try (FileInputStream inputStream = new FileInputStream(fileToOpen)) {
                        Workbook workbook = new XSSFWorkbook(inputStream);

                        Sheet sheet = workbook.getSheetAt(0);
                        Iterator<Row> rowIterator = sheet.iterator();

                        // skip thee header row
                        if (rowIterator.hasNext()) {
                            rowIterator.next();
                        }

                        while (rowIterator.hasNext()) {
                            Row row = rowIterator.next();

                            String maHoaDon = row.getCell(1).getStringCellValue();
                            String maNhanVien = row.getCell(2).getStringCellValue();
                            String maKhachHang = row.getCell(3).getStringCellValue();
                            String maKhuyenMai = row.getCell(4).getStringCellValue();
                            String ngayLap = row.getCell(5).getStringCellValue();
                            String gioLap = row.getCell(6).getStringCellValue();
                            float tongTien = (float) row.getCell(7).getNumericCellValue();

                            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

                            LocalDate localDate = LocalDate.parse(ngayLap, dateTimeFormatter);
                            LocalTime localTime = LocalTime.parse(gioLap, timeFormatter);

                            Invoice invoice = new Invoice(maHoaDon, maNhanVien, maKhachHang, maKhuyenMai, localDate, localTime, tongTien);

                            // add to the database
                            invoiceBUS.add(maHoaDon, maNhanVien, maKhachHang, maKhuyenMai, localDate, localTime, tongTien);
                        }

                        //
                        refresh();

                        JOptionPane.showMessageDialog(null, "Nhập file thành công");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Nhập file không thành công");
                        e.printStackTrace();
                    }
                }
            }
        });

        // in pdf

    }
    private  void viewDetailsMouseClick() {

    }
    public void refresh() {
        invoiceBUS.readDB();
        setDataToTable(invoiceBUS.getListInvoice());
        // checkTable();
    }
    // public void checkTable() {
    //     // Lấy số hàng và số cột của bảng
    //     int rowCount = table1.getRowCount();
    //     int columnCount = table1.getColumnCount();

    //     // In ra số hàng và số cột của bảng
    //     System.out.println("Number of rows: " + rowCount);
    //     System.out.println("Number of columns: " + columnCount);

    //     // Duyệt qua từng ô của bảng và in ra giá trị của từng ô
    //     for (int i = 0; i < rowCount; i++) {
    //         for (int j = 0; j < columnCount; j++) {
    //             Object value = table1.getValueAt(i, j);
    //             System.out.print(value + "\t");
    //         }
    //         System.out.println();
    //     }
    // }

    public void setDataToTable(ArrayList<Invoice> data) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("STT");
        model.addColumn("Mã hoá đơn");
        model.addColumn("Mã nhân viên");
        model.addColumn("Mã khách hàng");
        model.addColumn("Mã khuyến mãi");
        model.addColumn("Ngày lập");
        model.addColumn("Giờ lập");
        model.addColumn("Tổng tiền");
        int stt = 1;
        DecimalFormat df = new DecimalFormat("#,###");
        for (Invoice invoice : data) {
            model.addRow(new Object[] {
                    stt++,
                    invoice.getMaHoaDon(),
                    invoice.getMaNhanVien(),
                    invoice.getMaKhachHang(),
                    invoice.getMaKhuyenMai(),
                    invoice.getNgayLap(),
                    invoice.getGioLap(),
                    format(invoice.getTongTien())
            });

        }

        table1.setModel(model);

    }



    private JPanel this2;
    private JPanel this3;
    private JPanel panel1;
    private JPanel btnAction;
    private JPanel panel2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel search;
    private JPanel panel3;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JPanel panel4;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel panel5;
    private JButton btnxemChiTiet;
    private JButton btnReload;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel6;
    private JPanel panel7;
    private JTextField txtMaHoaDon ;
    private JTextField txtNhanVien;
    private JTextField txtKhachHang;
    private JTextField txtKhuyenMai ;
    private JPanel panel8;
    private JTextField txtNgayLap;
    private JTextField txtTongTien;
    private JTextField txtGioLap;

    public static String format(float num) {
        BigDecimal trieu = new BigDecimal(num * 1000000);

        Locale vietnam = new Locale("vi", "VN");

        NumberFormat fmoney = NumberFormat.getCurrencyInstance(vietnam);

        return fmoney.format(trieu);
    }
    private void displayInfo(String maHD){
        if(maHD != null) {
            for(Invoice i : invoiceBUS.getListInvoice()) {
                if(i.getMaHoaDon().equals(maHD)){
                    String tenNV = staffBUS.getStaff(i.getMaNhanVien()).getTenNV();
                    System.out.println(tenNV);
                    String tenKH = customerBUS.getCustomer(i.getMaKhachHang()).getTenKh();
                    System.out.println(tenKH);
                    String tenKM = promotionBUS.getKhuyenMai(i.getMaKhuyenMai()).getTenKhuyenMai();
                    System.out.println(tenKM);
                    // tra du lieu vao o textfiled
                    txtMaHoaDon.setText(i.getMaHoaDon()) ;
                     txtMaHoaDon.setEnabled(false);
                    txtNhanVien.setText(tenNV+ "-" + i.getMaNhanVien());
                    txtNhanVien.setEnabled(false);
                    txtKhachHang.setText(tenKH+"-" +i.getMaKhachHang());
                    txtKhachHang.setEnabled(false);
                    txtKhuyenMai.setText(tenKM + "-" + i.getMaKhuyenMai());
                    txtKhuyenMai.setEnabled(false);
                    txtTongTien.setText(i.getNgayLap().toString());
                    txtTongTien.setEnabled(false);
                    txtGioLap.setText(i.getGioLap().toString());
                    txtGioLap.setEnabled(false);    
                    txtNgayLap.setText(format(i.getTongTien()));
                    txtNgayLap.setEnabled(false);
                    return ;
                }
            }
        }
    }
}
