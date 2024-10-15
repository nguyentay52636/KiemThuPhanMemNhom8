package Layout.models.FrontEnd.FormStaff;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Layout.models.BackEnd.BUS.StaffBUS;
import Layout.models.BackEnd.DTO.Staff;

public class DisplayStaffDisableButton extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtTimKiem;
    private JTable table;

    private StaffBUS stbus = new StaffBUS();
    private DefaultTableModel model;
    private JButton btnview;
    private JButton btnedit;
    private JButton btndelete;
    private JButton btnadd;
    // private JButton btnnhap;
    private JButton btnxuat;
    private ArrayList<Staff> list;
    private JDialog editDialog;
    private JDialog addDialog;
    private JComboBox comboBox;
    private JButton btnlammoi;
    private JComboBox cbhienthi;
    private JPanel up;

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public DisplayStaffDisableButton() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 879, 598);

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        up = new JPanel();
        up.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));

        btnview = new JButton("Xem");
        // btnview.setBackground(new Color(255, 255, 255));
        btnview.setBounds(278, 5, 57, 32);
        btnview.setPreferredSize(new Dimension(144, 43));
        btnview.setIcon(new ImageIcon(getClass().getResource("/images/view.png")));

        btnview.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy chỉ số hàng được chọn trong bảng
                int selectedRow = table.getSelectedRow();

                if (selectedRow != -1) { // -1 là chỉ mục mặc định nếu không có hàng nào được chọn
                    // Lấy dữ liệu từ các cột của hàng đã chọn
                    String maNV = table.getValueAt(selectedRow, 0).toString();
                    String tenNV = table.getValueAt(selectedRow, 1).toString();
                    String ngaySinh = table.getValueAt(selectedRow, 2).toString();
                    String diaChi = table.getValueAt(selectedRow, 3).toString();
                    String soDienThoai = table.getValueAt(selectedRow, 4).toString();
                    String trangThai = table.getValueAt(selectedRow, 5).toString();

                    // Hiển thị dialog để chỉnh sửa thông tin sản phẩm
                    showDialogViewStaff(maNV, tenNV, ngaySinh, diaChi, soDienThoai, trangThai);
                } else {
                    // Nếu không có hàng nào được chọn, hiển thị thông báo cho người dùng
                    JOptionPane.showMessageDialog(DisplayStaffDisableButton.this,
                            "Vui lòng chọn một nhân viên để chỉnh sửa", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        up.add(btnview);

        btnedit = new JButton("Sửa");
        // btnedit.setBackground(new Color(255, 255, 255));
        btnedit.setBounds(355, 5, 55, 32);
        btnedit.setPreferredSize(new Dimension(144, 43));
        btnedit.setIcon(new ImageIcon(getClass().getResource("/images/editing.png")));

        btnedit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();

                if (selectedRow != -1) {
                    String maNV = table.getValueAt(selectedRow, 0).toString();
                    String tenNV = table.getValueAt(selectedRow, 1).toString();
                    String ngaySinhStr = table.getValueAt(selectedRow, 2).toString();
                    String diaChi = table.getValueAt(selectedRow, 3).toString();
                    String soDienThoai = table.getValueAt(selectedRow, 4).toString();
                    String trangThai = table.getValueAt(selectedRow, 5).toString();

                    try {
                        // Parse the date string into a java.sql.Date object
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date parsedDate = dateFormat.parse(ngaySinhStr);
                        java.sql.Date ngaySinh = new java.sql.Date(parsedDate.getTime());

                        showDialogEditStaff(maNV, tenNV, ngaySinh, diaChi, soDienThoai, trangThai);
                    } catch (ParseException ex) {
                        // Handle parsing error
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(DisplayStaffDisableButton.this, "Ngày sinh không hợp lệ", "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        up.add(btnedit);

        btndelete = new JButton("Xóa");
        // btndelete.setBackground(new Color(255, 255, 255));
        btndelete.setBounds(430, 5, 67, 32);
        btndelete.setPreferredSize(new Dimension(144, 43));
        btndelete.setIcon(new ImageIcon(getClass().getResource("/images/bin.png")));
        up.add(btndelete);

        btndelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy chỉ số hàng được chọn trong bảng
                int selectedRow = table.getSelectedRow();

                // Kiểm tra nếu không có hàng nào được chọn
                if (selectedRow == -1) {
                    // Hiển thị thông báo cho người dùng và không thực hiện gì cả
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một nhân viên để xóa", "Thông báo",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Lấy mã nhân viên từ cột đầu tiên của hàng đã chọn
                String maNV = table.getValueAt(selectedRow, 0).toString();

                // Hiển thị hộp thoại xác nhận xóa nhân viên
                int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhân viên này?",
                        "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    stbus.updateTrangthai(maNV, 1);
                    refreshTable();
                }
            }
        });

        btnadd = new JButton("Thêm");
        // btnadd.setBackground(new Color(255, 255, 255));
        btnadd.setBounds(517, 5, 59, 32);
        btnadd.setPreferredSize(new Dimension(144, 43));
        btnadd.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnadd.setIcon(new ImageIcon(getClass().getResource("/images/plus.png")));
        up.add(btnadd);

        btnadd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDialogToAddstaff();
            }
        });

        // btnnhap = new JButton("Nhập Excel");
        // btnnhap.setIcon(new
        // ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png")));
        // btnnhap.setPreferredSize(new Dimension(144, 43));
        // btnnhap.setFont(new Font("Tahoma", Font.BOLD, 12));
        // btnnhap.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent actionEvent) {
        // JFileChooser fileChooser = new JFileChooser();
        // fileChooser.setDialogTitle("Chọn file Excel");

        // int userSelection = fileChooser.showOpenDialog(null);

        // if (userSelection == JFileChooser.APPROVE_OPTION) {
        // File fileToOpen = fileChooser.getSelectedFile();

        // try (FileInputStream inputStream = new FileInputStream(fileToOpen)) {
        // Workbook workbook = new XSSFWorkbook(inputStream);

        // Sheet sheet = workbook.getSheetAt(0);
        // Iterator<Row> rowIterator = sheet.iterator();

        // // skip thee header row
        // if (rowIterator.hasNext()) {
        // rowIterator.next();
        // }

        // while (rowIterator.hasNext()) {
        // Row row = rowIterator.next();

        // String maNV = row.getCell(0).getStringCellValue();
        // String tenNV = row.getCell(1).getStringCellValue();
        // Date ngaySinh = Date.valueOf(row.getCell(2).getStringCellValue());
        // String diaChi = row.getCell(3).getStringCellValue();
        // String soDienThoai = row.getCell(4).getStringCellValue();
        // int trangThai = (int) row.getCell(5).getNumericCellValue();

        // Staff staff = new Staff(maNV, tenNV, ngaySinh, diaChi, soDienThoai,
        // trangThai);

        // // add to the database
        // stbus.addBus(staff);
        // }

        // // refresh the table
        // refreshTable();

        // JOptionPane.showMessageDialog(null, "Nhập file thành công");
        // } catch (IOException e) {
        // JOptionPane.showMessageDialog(null, "Nhập file không thành công");
        // e.printStackTrace();
        // }
        // }
        // }
        // });
        // up.add(btnnhap);

        btnxuat = new JButton("Xuất Excel");
        btnxuat.setPreferredSize(new Dimension(144, 43));
        btnxuat.setIcon(new ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png")));
        btnxuat.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnxuat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Chọn nơi lưu file");

                int userSelection = fileChooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();

                    Workbook workbook = new XSSFWorkbook();
                    Sheet sheet = workbook.createSheet("Nhân viên");

                    // tao row header
                    Row headerRow = sheet.createRow(0);
                    headerRow.createCell(0).setCellValue("Mã NV");
                    headerRow.createCell(1).setCellValue("Tên NV");
                    headerRow.createCell(2).setCellValue("Ngày sinh");
                    headerRow.createCell(3).setCellValue("Địa chỉ");
                    headerRow.createCell(4).setCellValue("SĐT");
                    headerRow.createCell(5).setCellValue("Trạng thái");

                    // them du lieu vao sheet
                    for (int i = 0; i < table.getRowCount(); i++) {
                        Row row = sheet.createRow(i + 1);
                        for (int j = 0; j < table.getColumnCount(); j++) {
                            row.createCell(j).setCellValue(table.getValueAt(i, j).toString());
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
        up.add(btnxuat);

        txtTimKiem = new JTextField("");
        txtTimKiem.setBounds(388, 0, 150, 40);
        txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
        txtTimKiem.setPreferredSize(new Dimension(150, 26));

        String[] options = { "MaNV", "TenNV", "SDT", "DiaChi" };
        comboBox = new JComboBox<>(options);
        comboBox.setBounds(306, 10, 70, 40);
        comboBox.setPreferredSize(new Dimension(90, 30));
        comboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String option = (String) comboBox.getSelectedItem();
                txtTimKiem.setText(option);
                addFocusListenerToTextField(option);
            }
        });

        txtTimKiem.setColumns(15);
        txtTimKiem.setPreferredSize(new Dimension(180, 37));
        JPanel timkiem = new JPanel();
        timkiem.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        String[] option = { "Đang hoạt động", "Đã xóa" };
        cbhienthi = new JComboBox<>(option);
        cbhienthi.setPreferredSize(new Dimension(130, 37));
        cbhienthi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });
        timkiem.add(cbhienthi);
        // Đặt txtTimKiem vào vị trí CENTER của BorderLayout trong timkiem
        JPanel com_tk = new JPanel();
        com_tk.add(comboBox);
        com_tk.add(txtTimKiem);
        com_tk.setBorder(new TitledBorder("Tìm kiếm"));
        timkiem.add(com_tk);

        // Assuming txtTimKiem is your JTextField
        txtTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = txtTimKiem.getText();
                String option = (String) cbhienthi.getSelectedItem();
                int trangthai = option.equals("Đang hoạt động") ? 0 : 1;
                Timkiem(txt, trangthai);
            }
        });

        JPanel chucnang = new JPanel();
        chucnang.setBounds(5, 5, 855, 67);
        chucnang.setLayout(new GridLayout(3, 1, 10, 0));

        chucnang.add(up);
        chucnang.add(timkiem);

        btnlammoi = new JButton("Làm mới");
        btnlammoi.setPreferredSize(new Dimension(130, 42));
        btnlammoi.setIcon(new ImageIcon(getClass().getResource("/images/icons8_data_backup_30px.png")));
        btnlammoi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable();

            }
        });
        timkiem.add(btnlammoi);

        // Tạo một bảng mới và thiết lập font
        table = new JTable();
        // set font
        Font font = new Font("Segoe", 0, 16);
        Font fontHeader = new Font("Segoe", Font.BOLD, 16);

        // font for table1
        table.setFont(font);
        table.getTableHeader().setFont(fontHeader);

        // set size for table1
        table.setRowHeight(30);
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(150);
        }

        // Tạo một model mới và thêm các cột vào model
        model = new DefaultTableModel();
        model.addColumn("Mã NV");
        model.addColumn("Tên NV");
        model.addColumn("Ngày sinh");
        model.addColumn("Địa chỉ");
        model.addColumn("SĐT");
        model.addColumn("Trạng thái");

        Trangthai((String) cbhienthi.getSelectedItem());
        table.setModel(model);
        // Đặt bảng vào scrollPane để có thể cuộn nếu cần
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(5, 117, 855, 402);
        scrollPane.setPreferredSize(new Dimension(740, 402));

        // Đặt độ rộng tối thiểu cho cột thứ 2 (Mã LSP)
        table.getColumnModel().getColumn(1).setMinWidth(75);
        contentPane.setLayout(new BorderLayout());

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // Check if it's a single click
                    int row = table.getSelectedRow(); // Get the selected row
                    if (row != -1) { // Check if a row is selected
                        String trangThai = table.getValueAt(row, 5).toString(); // Get the value of the "trangThai"
                                                                                // column
                        if (trangThai.equals("Đã xóa")) { // Check if "trangThai" is "1"
                            String maSP = table.getValueAt(row, 0).toString(); // Get the value of the "maSP" column
                            showConfirmationDialog(maSP); // Show confirmation dialog
                        }
                    }
                }
            }
        });

        contentPane.add(chucnang, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);

    }

    public JPanel getPanel() {
        return contentPane;
    }

    // private void showDialogToAddstaff() {

    // addDialog = new JDialog(this, "Thêm thông tin nhân viên mới", true);
    // addDialog.setSize(450, 400);

    // JPanel panel = new JPanel();
    // panel.setLayout(new GridLayout(8, 2, 5, 10));
    // panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    // JLabel lblMaNV = new JLabel("Mã nhân viên:");
    // JTextField txtMaNV = new JTextField();
    // JLabel lblTenNV = new JLabel("Tên nhân viên: ");
    // JTextField txtTenNV = new JTextField();
    // JLabel lblNgaySinh = new JLabel("Ngày sinh:");
    // JComboBox<Integer> dayComboBox = new JComboBox<>();
    // JComboBox<Integer> monthComboBox = new JComboBox<>();
    // JComboBox<Integer> yearComboBox = new JComboBox<>();

    // JPanel panel1 = new JPanel();
    // panel1.setLayout(new GridLayout(1, 3));
    // panel1.add(dayComboBox);
    // panel1.add(monthComboBox);
    // panel1.add(yearComboBox);

    // for (int i = 1; i <= 31; i++) {
    // dayComboBox.addItem(i);
    // }
    // for (int i = 1; i <= 12; i++) {
    // monthComboBox.addItem(i);
    // }
    // int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    // for (int i = currentYear - 100; i <= currentYear; i++) {
    // yearComboBox.addItem(i);
    // }

    // JLabel lblDiaChi = new JLabel("Địa chỉ:");
    // JTextField txtDiaChi = new JTextField();
    // JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
    // JTextField txtSoDienThoai = new JTextField();
    // JLabel lblTrangThai = new JLabel("Trạng thái:");
    // JComboBox<String> cboTrangThai = new JComboBox<>(new String[] { "Đang hoạt
    // động", "Đã xóa" });

    // panel.add(lblMaNV);
    // panel.add(txtMaNV);
    // panel.add(lblTenNV);
    // panel.add(txtTenNV);
    // panel.add(lblNgaySinh);
    // panel.add(panel1);
    // panel.add(lblDiaChi);
    // panel.add(txtDiaChi);
    // panel.add(lblSoDienThoai);
    // panel.add(txtSoDienThoai);
    // panel.add(lblTrangThai);
    // panel.add(cboTrangThai);

    // JPanel buttonPanel = new JPanel();
    // buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

    // JButton btnOK = new JButton("OK");
    // JButton btnCancel = new JButton("Cancel");
    // btnOK.setEnabled(false);
    // btnOK.setIcon(new
    // ImageIcon(this.getClass().getResource("/images/icons8_add_30px.png")));
    // btnCancel.setIcon(new
    // ImageIcon(this.getClass().getResource("/images/icons8_cancel_30px_1.png")));
    // buttonPanel.add(btnOK);
    // buttonPanel.add(btnCancel);

    // btnOK.addActionListener(new ActionListener() {
    // public void actionPerformed(ActionEvent e) {
    // String maNV = txtMaNV.getText();
    // String tenNV = txtTenNV.getText();
    // int day = (int) dayComboBox.getSelectedItem();
    // int month = (int) monthComboBox.getSelectedItem();
    // int year = (int) yearComboBox.getSelectedItem();
    // String ngaySinhStr = String.format("%d-%02d-%02d", year, month, day);
    // java.sql.Date ngaySinh = java.sql.Date.valueOf(ngaySinhStr);
    // String diaChi = txtDiaChi.getText();
    // String soDienThoai = txtSoDienThoai.getText();
    // String trangThai = doitrangthai(cboTrangThai.getSelectedItem().toString());
    // // Chuyển đổi trạng thái từ
    // // chuỗi sang int

    // if (checkinfo("addDialog", maNV, soDienThoai)) {

    // // Thêm nhân viên vào cơ sở dữ liệu
    // Staff staff = new Staff(maNV, tenNV, ngaySinh, diaChi, soDienThoai,
    // Integer.parseInt(trangThai));
    // stbus.addBus(staff);
    // refreshTable();
    // // Đóng cửa sổ thêm nhân viên
    // addDialog.dispose();
    // }
    // }
    // });

    // btnCancel.addActionListener(new ActionListener() {

    // @Override
    // public void actionPerformed(ActionEvent e) {
    // addDialog.dispose();

    // }
    // });

    // DocumentListener documentListener = new DocumentListener() {
    // @Override
    // public void insertUpdate(DocumentEvent e) {
    // checkFields();
    // }

    // @Override
    // public void removeUpdate(DocumentEvent e) {
    // checkFields();
    // }

    // @Override
    // public void changedUpdate(DocumentEvent e) {
    // checkFields();
    // }

    // private void checkFields() {
    // boolean allFieldsFilled = !txtMaNV.getText().isEmpty() &&
    // !txtTenNV.getText().isEmpty() &&
    // !txtDiaChi.getText().isEmpty() &&
    // !txtSoDienThoai.getText().isEmpty();

    // btnOK.setEnabled(allFieldsFilled);
    // }
    // };

    // txtMaNV.getDocument().addDocumentListener(documentListener);
    // txtTenNV.getDocument().addDocumentListener(documentListener);
    // txtDiaChi.getDocument().addDocumentListener(documentListener);
    // txtSoDienThoai.getDocument().addDocumentListener(documentListener);

    // panel.add(buttonPanel);

    // addDialog.getContentPane().add(panel);
    // addDialog.setLocationRelativeTo(this);
    // addDialog.setVisible(true);
    // }
    private void showDialogToAddstaff() {

        JDialog addDialog = new JDialog(this, "Thêm thông tin nhân viên mới", true);
        addDialog.setSize(500, 450);

        // Panel chính
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Panel chứa các thành phần nhập liệu
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(8, 2, 10, 10)); // Chỉnh lại khoảng cách giữa các ô
        inputPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Màu nền và font chữ cho các thành phần
        inputPanel.setBackground(new Color(240, 248, 255)); // Màu nền tương tự
        Font boldFont = new Font("Arial", Font.BOLD, 14); // Font chữ đồng nhất

        // Các thành phần trong dialog
        JLabel lblMaNV = new JLabel("Mã nhân viên:");
        lblMaNV.setFont(boldFont);
        JTextField txtMaNV = new JTextField();

        txtMaNV.setText(stbus.getNextID());
        txtMaNV.setEnabled(false);
        JLabel lblTenNV = new JLabel("Tên nhân viên:");
        lblTenNV.setFont(boldFont);
        JTextField txtTenNV = new JTextField();

        JLabel lblNgaySinh = new JLabel("Ngày sinh:");
        lblNgaySinh.setFont(boldFont);
        JComboBox<Integer> dayComboBox = new JComboBox<>();
        JComboBox<Integer> monthComboBox = new JComboBox<>();
        JComboBox<Integer> yearComboBox = new JComboBox<>();
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 3));
        panel1.add(dayComboBox);
        panel1.add(monthComboBox);
        panel1.add(yearComboBox);

        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(i);
        }
        for (int i = 1; i <= 12; i++) {
            monthComboBox.addItem(i);
        }
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentYear - 100; i <= currentYear; i++) {
            yearComboBox.addItem(i);
        }

        JLabel lblDiaChi = new JLabel("Địa chỉ:");
        lblDiaChi.setFont(boldFont);
        JTextField txtDiaChi = new JTextField();

        JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
        lblSoDienThoai.setFont(boldFont);
        JTextField txtSoDienThoai = new JTextField();

        JLabel lblTrangThai = new JLabel("Trạng thái:");
        lblTrangThai.setFont(boldFont);
        JComboBox<String> cboTrangThai = new JComboBox<>(new String[] { "Đang hoạt động", "Đã xóa" });

        // Thêm các thành phần vào input panel
        inputPanel.add(lblMaNV);
        inputPanel.add(txtMaNV);
        inputPanel.add(lblTenNV);
        inputPanel.add(txtTenNV);
        inputPanel.add(lblNgaySinh);
        inputPanel.add(panel1);
        inputPanel.add(lblDiaChi);
        inputPanel.add(txtDiaChi);
        inputPanel.add(lblSoDienThoai);
        inputPanel.add(txtSoDienThoai);
        inputPanel.add(lblTrangThai);
        inputPanel.add(cboTrangThai);

        // Panel nút OK và Cancel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new java.awt.Color(173, 216, 230)); // Màu nền cho button panel

        JButton btnOK = new JButton("OK", new ImageIcon(this.getClass().getResource("/images/icons8_add_30px.png")));
        JButton btnCancel = new JButton("Cancel",
                new ImageIcon(this.getClass().getResource("/images/icons8_cancel_30px_1.png")));
        buttonPanel.add(btnOK);
        buttonPanel.add(btnCancel);
        // Thêm sự kiện cho các nút
        btnOK.setEnabled(false);
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maNV = txtMaNV.getText();
                String tenNV = txtTenNV.getText();
                int day = (int) dayComboBox.getSelectedItem();
                int month = (int) monthComboBox.getSelectedItem();
                int year = (int) yearComboBox.getSelectedItem();
                String ngaySinhStr = String.format("%d-%02d-%02d", year, month, day);
                java.sql.Date ngaySinh = java.sql.Date.valueOf(ngaySinhStr);
                String diaChi = txtDiaChi.getText();
                String soDienThoai = txtSoDienThoai.getText();
                String trangThai = doitrangthai(cboTrangThai.getSelectedItem().toString());

                if (checkinfo("addDialog", maNV, soDienThoai)) {
                    Staff staff = new Staff(maNV, tenNV, ngaySinh, diaChi, soDienThoai, Integer.parseInt(trangThai));
                    stbus.addBus(staff);
                    refreshTable();
                    addDialog.dispose();
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addDialog.dispose();
            }
        });

        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkFields();
            }

            private void checkFields() {
                boolean allFieldsFilled = !txtMaNV.getText().isEmpty() &&
                        !txtTenNV.getText().isEmpty() &&
                        !txtDiaChi.getText().isEmpty() &&
                        !txtSoDienThoai.getText().isEmpty();
                btnOK.setEnabled(allFieldsFilled);
            }
        };

        txtMaNV.getDocument().addDocumentListener(documentListener);
        txtTenNV.getDocument().addDocumentListener(documentListener);
        txtDiaChi.getDocument().addDocumentListener(documentListener);
        txtSoDienThoai.getDocument().addDocumentListener(documentListener);

        // Thêm panel nút vào dialog
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        addDialog.getContentPane().add(mainPanel);
        addDialog.setLocationRelativeTo(this);
        addDialog.setVisible(true);
    }

    private void showDialogEditStaff(String maNV, String tenNV, Date ngaySinh, String diaChi, String soDienThoai,
            String trangThai) {
        editDialog = new JDialog(this, "Chỉnh sửa thông tin nhân viên", true);
        editDialog.setSize(450, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 5, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblMaNV = new JLabel("Mã nhân viên:");
        JTextField txtMaNV = new JTextField(maNV);
        txtMaNV.setEnabled(false);
        JLabel lblTenNV = new JLabel("Tên nhân viên: ");
        JTextField txtTenNV = new JTextField(tenNV);
        JLabel lblNgaySinh = new JLabel("Ngày sinh:");

        // Tách ngày, tháng, năm từ chuỗi ngày sinh
        Calendar cal = Calendar.getInstance();
        cal.setTime(ngaySinh);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);

        JComboBox<Integer> dayComboBox = new JComboBox<>();
        JComboBox<Integer> monthComboBox = new JComboBox<>();
        JComboBox<Integer> yearComboBox = new JComboBox<>();
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 3));
        panel1.add(dayComboBox);
        panel1.add(monthComboBox);
        panel1.add(yearComboBox);

        // Thêm các giá trị vào các combobox ngày, tháng, năm
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(i);
        }
        for (int i = 1; i <= 12; i++) {
            monthComboBox.addItem(i);
        }
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentYear - 100; i <= currentYear; i++) {
            yearComboBox.addItem(i);
        }

        // Chọn giá trị ban đầu cho các combobox ngày, tháng, năm
        dayComboBox.setSelectedItem(day);
        monthComboBox.setSelectedItem(month);
        yearComboBox.setSelectedItem(year);

        JLabel lblDiaChi = new JLabel("Địa chỉ:");
        JTextField txtDiaChi = new JTextField(diaChi);
        JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
        JTextField txtSoDienThoai = new JTextField(soDienThoai);
        JLabel lblTrangThai = new JLabel("Trạng thái:");
        JComboBox<String> cboTrangThai = new JComboBox<>(new String[] { "Đang hoạt động", "Đã xóa" });
        cboTrangThai.setSelectedItem(trangThai);

        panel.add(lblMaNV);
        panel.add(txtMaNV);
        panel.add(lblTenNV);
        panel.add(txtTenNV);
        panel.add(lblNgaySinh);
        panel.add(panel1);
        panel.add(lblDiaChi);
        panel.add(txtDiaChi);
        panel.add(lblSoDienThoai);
        panel.add(txtSoDienThoai);
        panel.add(lblTrangThai);
        panel.add(cboTrangThai);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton btnOK = new JButton("OK");
        JButton btnCancel = new JButton("Cancel");

        buttonPanel.add(btnOK);
        buttonPanel.add(btnCancel);

        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy thông tin nhân viên từ các ô nhập liệu
                String updatedMaNV = txtMaNV.getText();
                String updatedTenNV = txtTenNV.getText();
                int updatedDay = (int) dayComboBox.getSelectedItem();
                int updatedMonth = (int) monthComboBox.getSelectedItem();
                int updatedYear = (int) yearComboBox.getSelectedItem();
                String updatedNgaySinh = String.format("%02d-%02d-%04d", updatedDay, updatedMonth, updatedYear);
                String updatedDiaChi = txtDiaChi.getText();
                String updatedSoDienThoai = txtSoDienThoai.getText();
                String updatedTrangThai = doitrangthai(cboTrangThai.getSelectedItem().toString());

                java.sql.Date ngaySinh = java.sql.Date
                        .valueOf(String.format("%04d-%02d-%02d", updatedYear, updatedMonth, updatedDay));

                if (checkinfo("Edit", updatedMaNV, updatedSoDienThoai)) {
                    Staff staff = new Staff(updatedMaNV, updatedTenNV, ngaySinh, updatedDiaChi, updatedSoDienThoai,
                            Integer.parseInt(updatedTrangThai));
                    stbus.update(staff);
                    refreshTable();

                    editDialog.dispose();
                }
            }
        });

        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkFields();
            }

            private void checkFields() {
                boolean allFieldsFilled = !txtMaNV.getText().isEmpty() &&
                        !txtTenNV.getText().isEmpty() &&
                        !txtDiaChi.getText().isEmpty() &&
                        !txtSoDienThoai.getText().isEmpty();

                btnOK.setEnabled(allFieldsFilled);
            }
        };

        txtMaNV.getDocument().addDocumentListener(documentListener);
        txtTenNV.getDocument().addDocumentListener(documentListener);
        txtDiaChi.getDocument().addDocumentListener(documentListener);
        txtSoDienThoai.getDocument().addDocumentListener(documentListener);

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editDialog.dispose();
            }
        });

        panel.add(buttonPanel);

        editDialog.getContentPane().add(panel);
        editDialog.setLocationRelativeTo(this);
        editDialog.setVisible(true);
    }

    private void showDialogViewStaff(String maNV, String tenNV, String ngaySinh, String diaChi, String soDienThoai,
            String trangThai) {
        JDialog viewDialog = new JDialog(this, "Xem thông tin nhân viên", true);
        viewDialog.setSize(450, 350);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 5, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Font font = new Font("Arial", Font.BOLD, 14);
        JLabel lblMaNV = new JLabel("Mã nhân viên:");
        JTextField txtMaNV = new JTextField(maNV);
        txtMaNV.setFont(font);
        txtMaNV.setHorizontalAlignment(SwingConstants.CENTER);

        txtMaNV.setEnabled(false);

        JLabel lblTenNV = new JLabel("Tên nhân viên: ");
        JTextField txtTenNV = new JTextField(tenNV);
        txtTenNV.setHorizontalAlignment(SwingConstants.CENTER);
        txtTenNV.setFont(font);
        txtTenNV.setEnabled(false);
        JLabel lblNgaySinh = new JLabel("Ngày sinh:");
        JTextField txtNgaySinh = new JTextField(ngaySinh);
        txtNgaySinh.setFont(font);
        txtNgaySinh.setHorizontalAlignment(SwingConstants.CENTER);
        txtNgaySinh.setEnabled(false);
        JLabel lblDiaChi = new JLabel("Địa chỉ:");
        JTextField txtDiaChi = new JTextField(diaChi);
        txtDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
        txtDiaChi.setFont(font);
        txtDiaChi.setEnabled(false);
        JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
        JTextField txtSoDienThoai = new JTextField(soDienThoai);
        txtSoDienThoai.setHorizontalAlignment(SwingConstants.CENTER);
        txtSoDienThoai.setFont(font);
        txtSoDienThoai.setEnabled(false);
        JLabel lblTrangThai = new JLabel("Trạng thái:");
        JTextField txtTrangThai = new JTextField(trangThai);
        txtTrangThai.setHorizontalAlignment(SwingConstants.CENTER);
        txtTrangThai.setFont(font);
        txtTrangThai.setEnabled(false);

        panel.add(lblMaNV);
        panel.add(txtMaNV);
        panel.add(lblTenNV);
        panel.add(txtTenNV);
        panel.add(lblNgaySinh);
        panel.add(txtNgaySinh);
        panel.add(lblDiaChi);
        panel.add(txtDiaChi);
        panel.add(lblSoDienThoai);
        panel.add(txtSoDienThoai);
        panel.add(lblTrangThai);
        panel.add(txtTrangThai);

        viewDialog.getContentPane().add(panel);
        viewDialog.setLocationRelativeTo(this);
        viewDialog.setVisible(true);
    }

    // Kiểm tra thông tin
    public boolean checkinfo(String a, String maNV, String SĐT) {
        if (a == "addDialog") {
            if (stbus.checkMaMV(maNV)) {
                JOptionPane.showMessageDialog(addDialog, "Mã nhân viên đã tồn tại trong bảng.", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        // Kiểm tra số điện thoại
        if (!SĐT.matches("^0[1-9]\\d{8}$")) {
            JOptionPane.showMessageDialog(addDialog, "Số điện thoại không hợp lệ. Vui lòng nhập lại.", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public void refreshTable() {
        String option = (String) cbhienthi.getSelectedItem();
        Trangthai(option);
        comboBox.setSelectedItem("MaNV");
        addFocusListenerToTextField("MaNV");
    }

    public void Trangthai(String option) {
        model.setRowCount(0); // Clear existing rows from the table
        stbus = new StaffBUS();
        list = stbus.getList();
        up.setVisible(option.equals("Đang hoạt động"));
        for (Staff staff : list) {
            if (option.equals("Đang hoạt động") && staff.getTrangThai() == 0
                    || option.equals("Đã xóa") && staff.getTrangThai() == 1) {
                addRowToModel(staff);
            }
        }
    }

    public void Timkiem(String txt, int trangthai) {
        String selectedField = (String) comboBox.getSelectedItem();
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Staff staff : list) {
            if (staff.getTrangThai() == trangthai && stbus.isMatched(staff, selectedField, txt)) {
                addRowToModel(staff);
            }
        }
    }

    public void addRowToModel(Staff staff) {
        String ngaysinh = formatDate(staff.getNgaySinh());
        Object[] row = { staff.getMaNV(), staff.getTenNV(), ngaysinh, staff.getDiachi(), staff.getSDT(),
                doitrangthai(staff.getTrangThai() + "") };
        model.addRow(row);
    }

    // Thêm sự kiện focus cho text field
    private void addFocusListenerToTextField(String defaultText) {
        txtTimKiem.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTimKiem.getText().equals(defaultText)) {
                    txtTimKiem.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTimKiem.getText().isEmpty()) {
                    txtTimKiem.setText(defaultText);
                }
            }
        });
    }

    public String doitrangthai(String state) {
        if (state.equals("0")) {
            return "Đang hoạt động";
        } else if (state.equals("Đang hoạt động")) {
            return "0";
        } else if (state.equals("1")) {
            return "Đã xóa";
        } else if (state.equals("Đã xóa")) {
            return "1";
        }
        return "Lỗi";
    }

    // Format ngày theo định dạng dd-MM-yyyy
    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }

    public void showConfirmationDialog(String maNV) {
        int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn khôi phục nhân viên này?", "Xác nhận",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            stbus.updateTrangthai(maNV, 0);
            refreshTable();
        }
    }

    private void xuatexcel() {
        // TODO add your handling code here:
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("DisplayProduct");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < table.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(table.getColumnName(i));
                }

                for (int j = 0; j < table.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < table.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (table.getValueAt(j, k) != null) {
                            cell.setCellValue(table.getValueAt(j, k).toString());
                        }

                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                openFile(saveFile.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void disableButtons() {
        // Vô hiệu hóa các nút
        btnadd.setEnabled(false);
        btndelete.setEnabled(false);
        btnedit.setEnabled(false);
        btnview.setEnabled(false);
        // btnnhap.setEnabled(false);
        cbhienthi.removeItem("Đã xóa");
    }
}
