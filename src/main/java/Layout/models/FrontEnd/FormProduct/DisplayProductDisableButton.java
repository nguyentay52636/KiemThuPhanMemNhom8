package Layout.models.FrontEnd.FormProduct;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Layout.models.BackEnd.BUS.ProductBUS;
import Layout.models.BackEnd.BUS.TypeProductBUS;
import Layout.models.BackEnd.DTO.Product;
import Layout.models.BackEnd.DTO.TypeProduct;
import Layout.models.FrontEnd.Formatter.PriceFormatter;

public class DisplayProductDisableButton extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtTimKiem;
    private JTable table;
    private ProductBUS prbus = new ProductBUS();
    private TypeProductBUS tpbus = new TypeProductBUS();
    private JButton btnadd;
    private JButton btndelete;
    private JButton btnedit;
    private JButton btnview;
    private JButton btnxuat;
    // private JButton btnnhap;
    private JComboBox comboBox1;
    private DefaultTableModel model;
    private JScrollPane scrollPane1;
    private ArrayList<Product> listsp;
    private JPanel paneltimkiem;
    private JPanel panelloc;
    private JPanel panel_1;
    private JComboBox cbhienthi;
    private JDialog editDialog;
    private JDialog addDialog;
    private JTextField tu;
    private JTextField toi;
    private JPanel panel2;
    private JDialog dialog;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DisplayProduct frame = new DisplayProduct();
                    frame.setMinimumSize(new Dimension(700, 600));

                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void updateProductDisplay(ArrayList<Product> data) {
        // Khởi tạo mô hình bảng
        DefaultTableModel model = new DefaultTableModel();

        // Thêm các cột vào mô hình bảng
        model.addColumn("Mã SP");
        model.addColumn("Mã LSP");
        model.addColumn("Tên SP");
        model.addColumn("Đơn giá");
        model.addColumn("Số lượng");
        model.addColumn("File ảnh"); // Cột sẽ chứa biểu tượng hình ảnh
        model.addColumn("Trạng thái");

        // Lặp qua danh sách sản phẩm và thêm từng hàng vào bảng
        for (Product i : data) {
            // Tạo ImageIcon từ đường dẫn hình ảnh, xử lý lỗi nếu đường dẫn không hợp lệ
            ImageIcon imageIcon;
            if (i.getHinhAnh() != null && !i.getHinhAnh().isEmpty()) {
                URL imageUrl = getClass().getResource("/images/Product Images/" + i.getHinhAnh());
                if (imageUrl != null) {
                    imageIcon = new ImageIcon(imageUrl);
                } else {
                    imageIcon = new ImageIcon(getClass().getResource("/images/default.png"));
                }
            } else {
                // Sử dụng một biểu tượng mặc định nếu không có hình ảnh
                imageIcon = new ImageIcon(getClass().getResource("/images/default.png"));
            }

            model.addRow(new Object[] {
                    i.getMaSP(),
                    i.getMaLSP(),
                    i.getTenSP(),
                    i.getDonGia(),
                    i.getSoLuong(),
                    imageIcon, // Thay thế link bằng ImageIcon
                    i.getTrangthai()
            });
        }

        // Gán mô hình cho JTable
        table.setModel(model);

        // Tùy chỉnh renderer cho cột "File ảnh"
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn imageColumn = columnModel.getColumn(5); // Cột index 5 cho File ảnh
        imageColumn.setCellRenderer(new IconCellRenderer());
    }

    public DisplayProductDisableButton() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1));

        panel2 = new JPanel();
        FlowLayout fl_panel2 = new FlowLayout();
        fl_panel2.setVgap(15);

        panel2.setLayout(fl_panel2);
        panel1.add(panel2);

        btnadd = new JButton("Thêm");
        // btnadd.setBackground(new Color(255, 255, 255));
        btnadd.setPreferredSize(new Dimension(144, 43));
        btnadd.setIcon(new ImageIcon(getClass().getResource("/images/plus.png")));
        panel2.add(btnadd);

        // Sự kiện khi nhấn nút "ADD"
        btnadd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Hiển thị dialog để nhập thông tin sản phẩm mới
                showDialogToAddProduct();
                refreshTable();
            }
        });

        btndelete = new JButton("Xóa");
        // btndelete.setBackground(new Color(255, 255, 255));
        btndelete.setPreferredSize(new Dimension(144, 43));
        btndelete.setIcon(new ImageIcon(getClass().getResource("/images/bin.png")));

        btndelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy chỉ mục của hàng được chọn
                int selectedRow = table.getSelectedRow();

                // Kiểm tra xem có hàng nào được chọn không
                if (selectedRow != -1) {
                    // Hiển thị hộp thoại xác nhận xóa
                    int option = JOptionPane.showConfirmDialog(DisplayProductDisableButton.this,
                            "Bạn có chắc chắn muốn xóa sản phẩm này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

                    // Nếu người dùng đồng ý xóa
                    if (option == JOptionPane.YES_OPTION) {
                        String maSP = (String) table.getValueAt(selectedRow, 0);
                        prbus.updateTrangthai(maSP, 1);
                        refreshTable();
                        // Hiển thị thông báo xóa thành công
                        JOptionPane.showMessageDialog(DisplayProductDisableButton.this, "Xóa sản phẩm thành công!",
                                "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    // Nếu không có hàng nào được chọn, hiển thị thông báo cho người dùng
                    JOptionPane.showMessageDialog(DisplayProductDisableButton.this, "Vui lòng chọn một sản phẩm để xóa",
                            "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        panel2.add(btndelete);

        // Sự kiện khi nhấn nút "DELETE"

        btnedit = new JButton("Sửa");
        // btnedit.setBackground(new Color(255, 255, 255));
        btnedit.setPreferredSize(new Dimension(144, 43));
        btnedit.setIcon(new ImageIcon(getClass().getResource("/images/editing.png")));

        btnedit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy chỉ mục của hàng được chọn
                int selectedRow = table.getSelectedRow();

                // Kiểm tra xem có hàng nào được chọn không
                if (selectedRow != -1) {
                    // Lấy thông tin của hàng được chọn
                    String maSP = (String) table.getValueAt(selectedRow, 0);
                    String maLSP = (String) table.getValueAt(selectedRow, 1);
                    String tenSP = (String) table.getValueAt(selectedRow, 2);
                    String formattedDonGia = (String) table.getValueAt(selectedRow, 3);
                    Float donGia = PriceFormatter.parsePrice(formattedDonGia);
                    int soLuong = (int) table.getValueAt(selectedRow, 4);
                    String fileAnh = (String) table.getValueAt(selectedRow, 5);
                    String trangThai = (String) table.getValueAt(selectedRow, 6);

                    showDialogToEditProduct(maSP, maLSP, tenSP, donGia, fileAnh, soLuong, trangThai);

                } else {
                    // Nếu không có hàng nào được chọn, hiển thị thông báo cho người dùng
                    JOptionPane.showMessageDialog(DisplayProductDisableButton.this,
                            "Vui lòng chọn một sản phẩm để chỉnh sửa", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
                refreshTable();
            }
        });

        panel2.add(btnedit);

        // Sự kiện khi nhấn nút "EDIT"

        btnview = new JButton("Xem");
        // btnview.setBackground(new Color(255, 255, 255));
        btnview.setPreferredSize(new Dimension(144, 43));
        btnview.setIcon(new ImageIcon(getClass().getResource("/images/view.png")));

        btnview.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();

                if (selectedRow != -1) {
                    String maSP = (String) table.getValueAt(selectedRow, 0);
                    String maLSP = (String) table.getValueAt(selectedRow, 1);
                    String tenSP = (String) table.getValueAt(selectedRow, 2);
                    String formattedDonGia = (String) table.getValueAt(selectedRow, 3);
                    Float donGia = PriceFormatter.parsePrice(formattedDonGia);
                    int soLuong = (int) table.getValueAt(selectedRow, 4);

                    String fileAnh = (String) table.getValueAt(selectedRow, 5);

                    String trangThai = (String) table.getValueAt(selectedRow, 6);

                    showProductDetailsDialog(maSP, maLSP, tenSP, donGia, fileAnh, soLuong, trangThai);
                } else {
                    JOptionPane.showMessageDialog(DisplayProductDisableButton.this,
                            "Vui lòng chọn một sản phẩm để xem chi tiết", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        panel2.add(btnview);

        btnxuat = new JButton("Xuất Excel");
        btnxuat.setBackground(new Color(255, 255, 255));
        btnxuat.setPreferredSize(new Dimension(144, 43));
        btnxuat.setIcon(new ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png")));
        btnxuat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Chọn nơi lưu file");

                int userSelection = fileChooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();

                    Workbook workbook = new XSSFWorkbook();
                    Sheet sheet = workbook.createSheet("Sản phẩm");

                    // tao row header
                    Row headerRow = sheet.createRow(0);
                    // headerRow.createCell(1).setCellValue("STT");
                    headerRow.createCell(1).setCellValue("Mã SP");
                    headerRow.createCell(2).setCellValue("Mã LSP");
                    headerRow.createCell(3).setCellValue("Tên SP");
                    headerRow.createCell(4).setCellValue("Đơn giá");
                    headerRow.createCell(5).setCellValue("Số lượng");
                    headerRow.createCell(6).setCellValue("File ảnh");
                    headerRow.createCell(7).setCellValue("Trạng thái");

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
        panel2.add(btnxuat);

        // btnnhap = new JButton("Nhập Excel");
        // // btnnhap.setBackground(new Color(255, 255, 255));
        // btnnhap.setPreferredSize(new Dimension(144, 43));
        // btnnhap.setIcon(new
        // ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png")));
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

        // String maSp = row.getCell(1).getStringCellValue();
        // String maLsp = row.getCell(2).getStringCellValue();
        // String tenSp = row.getCell(3).getStringCellValue();
        // float donGia = (float) row.getCell(4).getNumericCellValue();
        // int soLuong = (int) row.getCell(5).getNumericCellValue();
        // String fileAnh = row.getCell(6).getStringCellValue();
        // int trangThai = (int) row.getCell(7).getNumericCellValue();

        // Product product = new Product(maSp, maLsp, tenSp, donGia, soLuong, fileAnh,
        // trangThai);

        // // add to the database
        // prbus.addBus(product);
        // }

        // //
        // refreshTable();

        // JOptionPane.showMessageDialog(null, "Nhập file thành công");
        // } catch (IOException e) {
        // JOptionPane.showMessageDialog(null, "Nhập file không thành công");
        // e.printStackTrace();
        // }
        // }
        // }
        // });
        // panel2.add(btnnhap);

        JPanel panel3 = new JPanel();
        FlowLayout fl_panel3 = new FlowLayout();
        fl_panel3.setVgap(0);
        panel3.setLayout(fl_panel3);
        panel1.add(panel3);

        panel_1 = new JPanel();
        panel3.add(panel_1);

        String[] items = { "Đang bán", "Đã xóa" }; // Initialize an array of strings with your desired items
        cbhienthi = new JComboBox<>(items);
        panel_1.add(cbhienthi);

        paneltimkiem = new JPanel();
        paneltimkiem.setBorder(new TitledBorder("Tìm kiếm"));
        paneltimkiem.setLayout(new FlowLayout());
        panel3.add(paneltimkiem);

        String[] options = { "MaSP", "TenSP", "MaLSP", "Dongia", "Soluong" };
        comboBox1 = new JComboBox<>(options);
        comboBox1.setBackground(new Color(255, 255, 255));
        comboBox1.setPreferredSize(new Dimension(130, 40));
        paneltimkiem.add(comboBox1);
        comboBox1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String option = (String) comboBox1.getSelectedItem();
                eventJTextfield(option);
            }
        });

        txtTimKiem = new JTextField("");
        txtTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
        txtTimKiem.setPreferredSize(new Dimension(144, 55));
        paneltimkiem.add(txtTimKiem);
        sukientimkiem(txtTimKiem);

        panelloc = new JPanel();
        panelloc.setVisible(false);
        panelloc.setBorder(new TitledBorder("Lọc"));
        panelloc.setLayout(new FlowLayout());
        panel3.add(panelloc);

        tu = new JTextField("Từ");
        tu.setHorizontalAlignment(SwingConstants.CENTER);
        tu.setPreferredSize(new Dimension(65, 25));
        panelloc.add(tu);
        addFocusListenerToTextField(tu, "Từ");
        sukientimkiem(tu); // Pass tu to sukientimkiem

        toi = new JTextField("Tới");
        toi.setHorizontalAlignment(SwingConstants.CENTER);
        toi.setPreferredSize(new Dimension(65, 25));
        panelloc.add(toi);
        addFocusListenerToTextField(toi, "Tới");
        sukientimkiem(toi);
        JButton btnlammoi = new JButton("Làm mới");
        btnlammoi.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnlammoi.setIcon(new ImageIcon(getClass().getResource("/images/icons8_data_backup_30px.png")));
        btnlammoi.setPreferredSize(new Dimension(144, 45));
        panel3.add(btnlammoi);
        btnlammoi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });

        scrollPane1 = new JScrollPane();
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
        model.addColumn("Mã SP");
        model.addColumn("Mã LSP");
        model.addColumn("Tên SP");
        model.addColumn("Đơn giá");
        model.addColumn("Số lượng");
        model.addColumn("File ảnh");
        model.addColumn("Trạng thái");
        String hienthi = (String) cbhienthi.getSelectedItem();
        Trangthai(hienthi);
        cbhienthi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hienthi = (String) cbhienthi.getSelectedItem();
                Trangthai(hienthi);
                refreshTable();
            }
        });

        table.setModel(model);
        scrollPane1.setViewportView(table);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // Check if it's a single click
                    int row = table.getSelectedRow(); // Get the selected row
                    if (row != -1) { // Check if a row is selected
                        String trangThai = table.getValueAt(row, 6).toString(); // Get the value of the "trangThai"
                                                                                // column
                        if (trangThai.equals("Đã xóa")) { // Check if "trangThai" is "1"
                            String maSP = table.getValueAt(row, 0).toString(); // Get the value of the "maSP" column
                            showConfirmationDialog(maSP); // Show confirmation dialog
                        }
                    }
                }
            }
        });

        contentPane.add(panel1, BorderLayout.NORTH);
        contentPane.add(scrollPane1, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return contentPane;
    }

    private void showDialogToAddProduct() {
        // Tạo một dialog mới
        JDialog addDialog = new JDialog(this, "Thêm sản phẩm", true);
        addDialog.setSize(500, 450);

        // Panel chính
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Panel chứa các thành phần nhập liệu
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(8, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Màu nền và font chữ
        inputPanel.setBackground(new Color(240, 248, 255));
        Font boldFont = new Font("Arial", Font.BOLD, 14);
        // Các thành phần trong dialog
        JLabel lblMaSP = new JLabel("Mã sản phẩm:");
        lblMaSP.setFont(new Font("Arial", Font.BOLD, 14));
        lblMaSP.setFont(boldFont);
        JTextField txtMaSP = new JTextField();
        txtMaSP.setText(prbus.getNextID());
        txtMaSP.setEnabled(false);

        JLabel lblMaLSP = new JLabel("Mã lô hàng sản phẩm:");
        lblMaLSP.setFont(boldFont);

        ArrayList<TypeProduct> listlsp = tpbus.getDslsp();
        ArrayList<String> listMLSP = new ArrayList<>();
        for (TypeProduct lsp : listlsp) {
            listMLSP.add(lsp.getMaLoaiSanPham());
        }
        JComboBox<String> cbLSP = new JComboBox<>(listMLSP.toArray(new String[0]));

        JLabel lblTenSP = new JLabel("Tên sản phẩm:");
        lblTenSP.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField txtTenSP = new JTextField();

        JLabel lblDonGia = new JLabel("Đơn giá:");
        lblDonGia.setFont(boldFont);
        JTextField txtDonGia = new JTextField();
        txtDonGia.setEnabled(false);

        JLabel lblFileAnh = new JLabel("File ảnh:");
        lblFileAnh.setFont(boldFont);
        JButton btnChooseImage = new JButton("Chọn ảnh");

        JLabel lblSoLuong = new JLabel("Số lượng:");
        lblSoLuong.setFont(boldFont);
        JTextField txtSoLuong = new JTextField();
        txtSoLuong.setEnabled(false);

        JLabel lblTrangThai = new JLabel("Trạng thái:");
        lblTrangThai.setFont(boldFont);
        JComboBox<String> cboTrangThai = new JComboBox<>(new String[] { "Đang bán", "Đã xóa" });
        btnChooseImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tạo một hộp thoại chọn file
                JFileChooser fileChooser = new JFileChooser();

                // Thiết lập chỉ cho phép chọn file ảnh (có định dạng jpg, png, gif)
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif");
                fileChooser.setFileFilter(filter);

                // Hiển thị hộp thoại chọn file và lấy đường dẫn của file được chọn
                int result = fileChooser.showOpenDialog(null); // null để hiển thị ở giữa màn hình

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String imagePath = selectedFile.getAbsolutePath();

                    // Hiển thị đường dẫn ảnh đã chọn trên JTextField (hoặc JButton nếu bạn dùng nó)
                    btnChooseImage.setText(imagePath);
                }
            }
        });

        // Thêm vào input panel
        inputPanel.add(lblMaSP);
        inputPanel.add(txtMaSP);
        inputPanel.add(lblMaLSP);
        inputPanel.add(cbLSP);
        inputPanel.add(lblTenSP);
        inputPanel.add(txtTenSP);
        inputPanel.add(lblDonGia);
        inputPanel.add(txtDonGia);
        inputPanel.add(lblFileAnh);
        inputPanel.add(btnChooseImage);
        inputPanel.add(lblSoLuong);
        inputPanel.add(txtSoLuong);
        inputPanel.add(lblTrangThai);
        inputPanel.add(cboTrangThai);

        // Panel nút OK và Cancel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(173, 216, 230));

        JButton btnOK = new JButton("OK", new ImageIcon("ok_icon.png"));
        btnOK.setIcon(new ImageIcon(this.getClass().getResource("/images/icons8_add_30px.png")));
        JButton btnCancel = new JButton("Cancel", new ImageIcon("cancel_icon.png"));
        btnCancel.setIcon(new ImageIcon(this.getClass().getResource("/images/icons8_cancel_30px_1.png")));
        // Thêm các nút vào panel nút
        buttonPanel.add(btnOK);
        buttonPanel.add(btnCancel);
        // Sự kiện khi nhấn OK
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maSP = txtMaSP.getText();
                String maLSP = (String) cbLSP.getSelectedItem();
                String tenSP = txtTenSP.getText();
                String fileAnh = btnChooseImage.getText();
                String trangThai = doitrangthai(cboTrangThai.getSelectedItem() + "");

                // Kiểm tra các trường bắt buộc
                if (!ValidateInput.isNotEmpty(maSP) || !ValidateInput.isNotEmpty(maLSP)
                        || !ValidateInput.isNotEmpty(tenSP)) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields correctly.", "Validation Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Giá trị đơn giá và số lượng đã mặc định là 0, không cần kiểm tra người dùng
                // nhập
                float donGia = 0.0f;// Giá trị mặc định
                int soLuong = 0; // Giá trị mặc định

                // Kiểm tra xem giá trị mã sản phẩm đã tồn tại hay không, và kiểm tra trạng
                // thái.
                if (checkinform(maSP, "addDialog", donGia, soLuong)) {
                    model = (DefaultTableModel) table.getModel();

                    // Định dạng đơn giá để hiển thị
                    String formattedPriceForDisplay = PriceFormatter.format(donGia);

                    // Thêm dữ liệu vào bảng
                    model.addRow(
                            new Object[] { maSP, maLSP, tenSP, formattedPriceForDisplay, fileAnh, soLuong, trangThai });

                    // Tạo đối tượng Product và thêm vào danh sách
                    Product product = new Product(maSP, maLSP, tenSP, donGia, soLuong, fileAnh,
                            Integer.parseInt(trangThai));
                    prbus.addBus(product);

                    // Làm mới bảng hiển thị
                    refreshTable();
                    JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công!", "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE);

                    // Đóng dialog sau khi thêm thành công
                    addDialog.dispose();
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addDialog.dispose();
            }
        });

        // Thêm các nút vào panel
        buttonPanel.add(btnOK);
        buttonPanel.add(btnCancel);

        // Thêm panel vào dialog
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        addDialog.getContentPane().add(mainPanel);

        // Hiển thị dialog
        addDialog.setLocationRelativeTo(this);
        addDialog.setVisible(true);
    }

    private void showDialogToEditProduct(String maSP, String maLSP, String tenSP, Float donGia, String fileAnh,
            int soLuong, String trangThai) {
        // Tạo một dialog mới
        JDialog editDialog = new JDialog(this, "Chỉnh sửa sản phẩm", true);
        editDialog.setSize(500, 400);

        // Panel để chứa các thành phần trong dialog
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 5, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Các thành phần trong dialog (tương tự như phương thức showDialogToAddProduct)
        JLabel lblMaSP = new JLabel("Mã sản phẩm:");
        lblMaSP.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField txtMaSP = new JTextField(maSP);
        txtMaSP.setEnabled(false);
        JLabel lblMaLSP = new JLabel("Mã lô sản phẩm");
        lblMaLSP.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField txtMaLSP = new JTextField(maLSP);
        txtMaLSP.setEnabled(false);
        JLabel lblTenSP = new JLabel("Tên sản phẩm:");
        lblTenSP.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField txtTenSP = new JTextField(tenSP);
        JLabel lblDonGia = new JLabel("Đơn giá:");
        lblDonGia.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField txtDonGia = new JTextField(donGia + "");
        txtDonGia.setEnabled(false);
        JLabel lblFileAnh = new JLabel("File ảnh:");
        lblFileAnh.setFont(new Font("Arial", Font.BOLD, 14));
        JButton btnChooseImage = new JButton(fileAnh);
        JLabel lblSoLuong = new JLabel("Số lượng:");
        lblSoLuong.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField txtSoLuong = new JTextField(soLuong + "");
        txtSoLuong.setEnabled(false);
        JLabel lblTrangThai = new JLabel("Trạng thái:");
        lblTrangThai.setFont(new Font("Arial", Font.BOLD, 14));
        JComboBox<String> cboTrangThai = new JComboBox<>(new String[] { "Đang bán", "Đã xóa" });
        cboTrangThai.setSelectedItem(trangThai);

        btnChooseImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Tạo một hộp thoại chọn file
                JFileChooser fileChooser = new JFileChooser();

                // Thiết lập chỉ cho phép chọn file ảnh
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Ảnh (*.jpg, *.png, *.gif)", "jpg", "png",
                        "gif");
                fileChooser.setFileFilter(filter);

                // Hiển thị hộp thoại chọn file và lấy đường dẫn của file được chọn
                int result = fileChooser.showOpenDialog(DisplayProductDisableButton.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String imagePath = selectedFile.getAbsolutePath();

                    // Hiển thị đường dẫn ảnh đã chọn trên JTextField
                    btnChooseImage.setText(imagePath);
                }
            }
        });

        // Thêm các thành phần vào panel
        panel.add(lblMaSP);
        panel.add(txtMaSP);
        panel.add(lblMaLSP);
        panel.add(txtMaLSP);
        panel.add(lblTenSP);
        panel.add(txtTenSP);
        panel.add(lblDonGia);
        panel.add(txtDonGia);
        panel.add(lblFileAnh);
        panel.add(btnChooseImage);
        panel.add(lblSoLuong);
        panel.add(txtSoLuong);
        panel.add(lblTrangThai);
        panel.add(cboTrangThai);

        // Tạo một panel mới để chứa nút OK và Cancel (tương tự như phương thức
        // showDialogToAddProduct)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(173, 216, 230));

        JButton btnOK = new JButton("OK", new ImageIcon("ok_icon.png"));
        btnOK.setIcon(new ImageIcon(this.getClass().getResource("/images/icons8_add_30px.png")));
        JButton btnCancel = new JButton("Cancel", new ImageIcon("cancel_icon.png"));
        btnCancel.setIcon(new ImageIcon(this.getClass().getResource("/images/icons8_cancel_30px_1.png")));

        // Thêm các nút vào panel nút
        buttonPanel.add(btnOK);
        buttonPanel.add(btnCancel);

        // Sự kiện khi thay đổi trường dữ liệu nhập vào
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
                // Kiểm tra xem các trường dữ liệu có đầy đủ không
                boolean allFieldsFilled = !txtMaSP.getText().isEmpty() &&
                        !txtTenSP.getText().isEmpty() &&
                        !txtMaLSP.getText().isEmpty() &&
                        !txtDonGia.getText().isEmpty() &&
                        !btnChooseImage.getText().isEmpty() &&
                        !txtSoLuong.getText().isEmpty();

                // Kích hoạt hoặc vô hiệu hóa nút "OK" tùy thuộc vào việc các trường đã được
                // nhập đầy đủ hay không
                btnOK.setEnabled(allFieldsFilled);
            }
        };

        // Gắn DocumentListener với mỗi JTextField
        txtTenSP.getDocument().addDocumentListener(documentListener);
        txtMaLSP.getDocument().addDocumentListener(documentListener);
        txtDonGia.getDocument().addDocumentListener(documentListener);
        txtSoLuong.getDocument().addDocumentListener(documentListener);

        // Sự kiện khi nhấn nút "OK"
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy chỉ mục của hàng đã được chọn trong bảng
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(editDialog, "Vui lòng chọn một sản phẩm để chỉnh sửa", "Thông báo",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Lấy thông tin sản phẩm từ các ô nhập liệu
                String newMaSP = txtMaSP.getText();
                String newMaLSP = txtMaLSP.getText();
                String newTenSP = txtTenSP.getText();
                String newFileAnh = btnChooseImage.getText();
                String newDonGia = txtDonGia.getText();
                String newSoLuong = txtSoLuong.getText();
                String newTrangThai = doitrangthai((String) cboTrangThai.getSelectedItem());

                float newdongia = Float.parseFloat(newDonGia);
                int newsoluong = Integer.parseInt(newSoLuong);
                if (checkinform(newMaSP, "editDialog", newdongia, newsoluong)) {

                    Product pr = new Product(newMaSP, newMaLSP, newTenSP, newdongia, newsoluong, newFileAnh,
                            Integer.parseInt(newTrangThai));
                    prbus.update(pr);

                    editDialog.dispose();
                }
            }
        });

        // Sự kiện khi nhấn nút "Cancel" (tương tự như phương thức
        // showDialogToAddProduct)
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Đóng dialog khi nhấn nút "Cancel"
                editDialog.dispose();
            }
        });

        // Thêm panel nút vào cuối panel chính (tương tự như phương thức
        // showDialogToAddProduct)
        panel.add(buttonPanel);

        // Thêm panel chứa các thành phần vào dialog (tương tự như phương thức
        // showDialogToAddProduct)
        editDialog.getContentPane().add(panel);

        // Đặt vị trí hiển thị dialog (theo cửa sổ cha) (tương tự như phương thức
        // showDialogToAddProduct)
        editDialog.setLocationRelativeTo(this);

        // Hiển thị dialog
        editDialog.setVisible(true);
    }

    // Phương thức để hiển thị dialog thông tin sản phẩm
    private void showProductDetailsDialog(String maSP, String maLSP, String tenSP, Float donGia, String fileAnh,
            int soLuong, String trangThai) {
        // Tạo một dialog mới
        JDialog detailsDialog = new JDialog(this, "Chi tiết sản phẩm", true);
        detailsDialog.setSize(700, 600);

        // Panel chính để chứa các thành phần
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));

        // Panel bên trái để chứa hình ảnh sản phẩm
        JPanel imagePanel = new JPanel();
        FlowLayout fl_panel2 = new FlowLayout();
        fl_panel2.setVgap(40);
        imagePanel.setLayout(fl_panel2);

        // Thêm border cho imagePanel với độ dày 1.5px và màu đen
        imagePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, (int) 1.5f));

        // Thêm hình ảnh vào panel bên trái
        JLabel imageLabel = new JLabel(new ImageIcon(getClass().getResource("/images/Product Images/" + fileAnh)));
        imageLabel.setPreferredSize(new Dimension(400, 420));
        imagePanel.add(imageLabel);

        // Panel bên phải để chứa thông tin sản phẩm
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(7, 2, 10, 5));

        // Tạo font in đậm và cỡ chữ 16
        Font boldFont = new Font("Arial", Font.BOLD, 15);

        // Thêm các thông tin sản phẩm vào panel bên phải
        JLabel maSPLabel = new JLabel("Mã sản phẩm:");
        maSPLabel.setHorizontalAlignment(SwingConstants.CENTER);
        maSPLabel.setFont(boldFont); // In đậm và chỉnh cỡ chữ
        infoPanel.add(maSPLabel);

        JLabel maSPValueLabel = new JLabel(maSP);
        maSPValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        maSPValueLabel.setFont(boldFont);
        infoPanel.add(maSPValueLabel);

        JLabel maLSPLabel = new JLabel("Mã lô sản phẩm:");
        maLSPLabel.setHorizontalAlignment(SwingConstants.CENTER);
        maLSPLabel.setFont(boldFont);
        infoPanel.add(maLSPLabel);

        JLabel maLSPValueLabel = new JLabel(maLSP);
        maLSPValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        maLSPValueLabel.setFont(boldFont);
        infoPanel.add(maLSPValueLabel);

        JLabel tenSPLabel = new JLabel("Tên sản phẩm:");
        tenSPLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tenSPLabel.setFont(boldFont);
        infoPanel.add(tenSPLabel);

        JLabel tenSPValueLabel = new JLabel(tenSP);
        tenSPValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tenSPValueLabel.setFont(boldFont);
        infoPanel.add(tenSPValueLabel);

        JLabel donGiaLabel = new JLabel("Đơn giá:");
        donGiaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        donGiaLabel.setFont(boldFont);
        infoPanel.add(donGiaLabel);

        JLabel donGiaValueLabel = new JLabel(String.valueOf(donGia));
        donGiaValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        donGiaValueLabel.setFont(boldFont);
        infoPanel.add(donGiaValueLabel);

        JLabel soLuongLabel = new JLabel("Số lượng:");
        soLuongLabel.setHorizontalAlignment(SwingConstants.CENTER);
        soLuongLabel.setFont(boldFont);
        infoPanel.add(soLuongLabel);

        JLabel soLuongValueLabel = new JLabel(String.valueOf(soLuong));
        soLuongValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        soLuongValueLabel.setFont(boldFont);
        infoPanel.add(soLuongValueLabel);

        JLabel trangThaiLabel = new JLabel("Trạng thái:");
        trangThaiLabel.setHorizontalAlignment(SwingConstants.CENTER);
        trangThaiLabel.setFont(boldFont);
        infoPanel.add(trangThaiLabel);

        JLabel trangThaiValueLabel = new JLabel(trangThai);
        trangThaiValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        trangThaiValueLabel.setFont(boldFont);
        infoPanel.add(trangThaiValueLabel);

        // Thêm panel hình ảnh và panel thông tin sản phẩm vào panel chính
        mainPanel.add(imagePanel);
        mainPanel.add(infoPanel);

        // Thêm panel chính vào dialog
        detailsDialog.getContentPane().add(mainPanel);

        // Đặt vị trí hiển thị dialog (theo cửa sổ cha)
        detailsDialog.setLocationRelativeTo(this);

        // Hiển thị dialog
        detailsDialog.setVisible(true);
    }

    public boolean checkinform(String maSP, String x, Float donGiaStr, int soLuongStr) {

        if (x == "addDialog") {
            if (prbus.checkidproduct(maSP)) {
                JOptionPane.showMessageDialog(dialog, "Mã sản phẩm đã tồn tại trong bảng.", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return false; // Thoát khỏi sự kiện nếu có lỗi
            }
        }

        return true;
    }

    public void refreshTable() {
        String option = (String) cbhienthi.getSelectedItem();
        Trangthai(option);
        comboBox1.setSelectedItem("MaSP");
        eventJTextfield("MaSP");

    }

    public JPanel getPanel_disable() {
        disableButtons();
        return contentPane;
    }

    // public void refresh() {
    // prbus.readDB();
    // setDataProduct(prbus.getList());
    // }

    public void Trangthai(String option) {
        model.setRowCount(0); // Clear existing rows from the table
        prbus = new ProductBUS();
        listsp = prbus.getList();

        panel2.setVisible(option.equals("Đang bán")); // Set panel visibility based on option

        for (Product sp : listsp) {
            if ((option.equals("Đã xóa") && sp.getTrangthai() == 1)
                    || (option.equals("Đang bán") && sp.getTrangthai() == 0)) {
                addRowToModel(sp);
            }
        }

    }

    public void sukientimkiem(JTextField x) {
        x.addActionListener(e -> {
            String choice = (String) cbhienthi.getSelectedItem();
            String searchText = txtTimKiem.getText();
            String Tu = tu.getText();
            String Toi = toi.getText();
            int trangthai = choice.equals("Đang bán") ? 0 : 1; // Simplified trangthai assignment

            if (x == txtTimKiem) {
                Timkiem(searchText, trangthai);
            } else if (x == tu || x == toi) {
                loc(Tu, Toi, trangthai);
            }
        });
    }

    public void Timkiem(String txt, int trangthai) {
        String combox = (String) comboBox1.getSelectedItem();
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Product product : listsp) {
            if (product.getTrangthai() == trangthai && prbus.isMatched(product, combox, txt)) {
                addRowToModel(product);
            }
        }
    }

    public void showConfirmationDialog(String maSP) {
        int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn khôi phục sản phẩm này?", "Xác nhận",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            prbus.updateTrangthai(maSP, 0);
            refreshTable();
        } else {
            // Do nothing
        }
    }

    public void eventJTextfield(String option) {
        boolean isTextVisible = option.equals("MaSP") || option.equals("TenSP") || option.equals("MaLSP");
        txtTimKiem.setVisible(isTextVisible);
        panelloc.setVisible(!isTextVisible);

        if (isTextVisible) {
            // txtTimKiem.setText(option);

        } else {
            txtTimKiem.setText(""); // Clear text
            panelloc.setBorder(new TitledBorder(option)); // Set panel border title
            tu.setText("Từ");
            toi.setText("Tới");
        }
        addFocusListenerToTextField(txtTimKiem, option);
    }

    private void addRowToModel(Product product) {

        model.addRow(new Object[] {
                product.getMaSP(), product.getMaLSP(), product.getTenSP(), PriceFormatter.format(product.getDonGia()),
                product.getSoLuong(),
                product.getHinhAnh(), doitrangthai(product.getTrangthai() + "")
        });
    }

    private void addFocusListenerToTextField(JTextField textField, String text) {
        textField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(text)) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(text);
                }
            }
        });
    }

    public void loc(String tu, String toi, int trangthai) {
        String combox = (String) comboBox1.getSelectedItem();

        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        String errorMessage = prbus.checkvalid(tu, toi, combox, trangthai);
        if (errorMessage != null) {
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            refreshTable();
            return;
        }

        if (combox.equals("Dongia")) {
            ArrayList<Product> lispr = prbus.getList();
            float tu1 = Integer.parseInt(tu);
            float toi1 = Integer.parseInt(toi);
            for (Product pr : lispr) {
                if (pr.getDonGia() >= tu1 && pr.getDonGia() <= toi1 && pr.getTrangthai() == trangthai) {
                    model.addRow(new Object[] { pr.getMaSP(), pr.getMaLSP(), pr.getTenSP(),
                            pr.getDonGia(), pr.getSoLuong(), pr.getHinhAnh(), pr.getTrangthai() });
                }
            }

        }

        if (combox.equals("Soluong")) {
            ArrayList<Product> lispr = prbus.getList();
            float tu1 = Float.parseFloat(tu);
            float toi1 = Float.parseFloat(toi);
            for (Product pr : lispr) {
                if (pr.getSoLuong() >= tu1 && pr.getSoLuong() <= toi1 && pr.getTrangthai() == trangthai) {
                    model.addRow(new Object[] { pr.getMaSP(), pr.getMaLSP(), pr.getTenSP(),
                            pr.getDonGia(), pr.getSoLuong(), pr.getHinhAnh(), pr.getTrangthai() });
                }
            }

        }

    }

    public String doitrangthai(String state) {
        if (state.equals("0")) {
            return "Đang bán";
        } else if (state.equals("Đang bán")) {
            return "0";
        } else if (state.equals("1")) {
            return "Đã xóa";
        } else if (state.equals("Đã xóa")) {
            return "1";
        }
        return "Lỗi";
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
                String filePath = saveFile.toString();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void nhapExcel(String filePath) {

        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên, có thể thay đổi nếu cần

            Iterator<Row> iterator = sheet.iterator();
            ArrayList<Integer> dong = new ArrayList<>();
            int i = 1;
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                // Bỏ qua hàng đầu tiên vì nó chứa tiêu đề
                if (currentRow.getRowNum() == 0) {
                    continue;
                }

                // Đọc dữ liệu từ các ô trong hàng
                String masp = cellIterator.next().getStringCellValue(); // Điều chỉnh loại dữ liệu nếu cần
                String malsp = cellIterator.next().getStringCellValue(); // Điều chỉnh loại dữ liệu nếu cần
                String tensp = cellIterator.next().getStringCellValue();
                Float dongia = Float.parseFloat(cellIterator.next().getStringCellValue());
                int soluong = Integer.parseInt(cellIterator.next().getStringCellValue());
                String fileanh = cellIterator.next().getStringCellValue();
                int trangthai = Integer.parseInt(doitrangthai(cellIterator.next().getStringCellValue()));
                i++;
                if (prbus.checkidproduct(masp)) {
                    dong.add(i);
                } else {
                    Product pr = new Product(masp, malsp, tensp, dongia, soluong, fileanh, trangthai);
                    listsp.add(pr);
                }

            }

            if (dong.size() > 0) {
                System.out.print("Các dòng có mã sản phẩm đã tồn tại trong bảng: ");
                for (int rowIndex : dong) {
                    Row row = sheet.getRow(rowIndex);
                    if (row != null) {
                        Cell cell = row.getCell(0); // Giả sử cột đầu tiên là cột chứa mã sản phẩm
                        if (cell != null) {
                            String masp = cell.getStringCellValue();
                            System.out.print(masp + " ");
                        }
                    }
                }
                System.out.println(); // Xuống dòng sau khi in xong
            }

            workbook.close();
            inputStream.close();
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
}
