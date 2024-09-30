package Layout.models.FrontEnd.FormSupplier;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Layout.models.BackEnd.BUS.SupplierBUS;
import Layout.models.BackEnd.DTO.Supplier;



public class DisplaySupplier extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private ArrayList<Supplier> dsncc= new ArrayList<>();
    private SupplierBUS supplierBus= new SupplierBUS();
    private JDialog addDialog;
    private JDialog editDialog;
    private JTable table1;
    private DefaultTableModel model;
    private JComboBox<String> cbhienthi;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton buttonview;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DisplaySupplier frame = new DisplaySupplier();

                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public DisplaySupplier() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1));
        contentPane.add(panel1, BorderLayout.NORTH);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel1.add(panel2);

        button1 = new JButton("Thêm");
        button1.setIcon(new ImageIcon(getClass().getResource("/images/icons8_add_30px.png")));
        button1.setPreferredSize(new Dimension(120, 42));
        panel2.add(button1);
        button1.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showDialogToAddSupplier();
                refreshTable();

            }
        });

        buttonview = new JButton("Xem");
        buttonview.setIcon(new ImageIcon(getClass().getResource("/images/icons8_show_property_30px.png")));
        buttonview.setPreferredSize(new Dimension(120, 42));
        panel2.add(buttonview);
        buttonview.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy chỉ số hàng được chọn trong bảng
                int Select = table1.getSelectedRow();

                if (Select != -1) { // -1 là chỉ mục mặc định nếu không có hàng nào được chọn
                    String mancc=table1.getValueAt(Select, 0).toString();
                    String tenncc=table1.getValueAt(Select, 1).toString();
                    String diachi=table1.getValueAt(Select, 2).toString();
                    String sdt=table1.getValueAt(Select, 3).toString();
                    String fax=table1.getValueAt(Select, 4).toString();
                    String trangthai=table1.getValueAt(Select,5).toString();

                    showDialogViewSupplier(mancc, tenncc, diachi, sdt, fax,trangthai);
                    refreshTable();
                } else {
                    // Nếu không có hàng nào được chọn, hiển thị thông báo cho người dùng
                    JOptionPane.showMessageDialog(DisplaySupplier.this, "Vui lòng chọn một nhân viên để xem", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }




            }
        });

        button2 = new JButton("Xóa");
        button2.setIcon(new ImageIcon(getClass().getResource("/images/icons8_delete_forever_30px_1.png")));
        button2.setPreferredSize(new Dimension(120, 42));
        panel2.add(button2);
        button2.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int Select = table1.getSelectedRow();
                if(Select!=-1) {
                    String mancc=table1.getValueAt(Select, 0).toString();
                    supplierBus.updateTrangthai(mancc, 1);
                    refreshTable();
                }else {
                    JOptionPane.showMessageDialog(DisplaySupplier.this, "Vui lòng chọn một NCC để chỉnh sửa", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }


            }
        });

        button3 = new JButton("Sửa");
        button3.setIcon(new ImageIcon(getClass().getResource("/images/icons8_wrench_30px.png")));
        button3.setPreferredSize(new Dimension(120, 42));
        panel2.add(button3);
        button3.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int Select = table1.getSelectedRow();
                if(Select!=-1) {
                    String mancc=table1.getValueAt(Select, 0).toString();
                    String tenncc=table1.getValueAt(Select, 1).toString();
                    String diachi=table1.getValueAt(Select, 2).toString();
                    String sdt=table1.getValueAt(Select, 3).toString();
                    String fax=table1.getValueAt(Select, 4).toString();
                    String trangthai= table1.getValueAt(Select,5).toString();
                    showDialogEditSupplier(mancc, tenncc, diachi, sdt, fax,trangthai);
                    refreshTable();
                }else {
                    JOptionPane.showMessageDialog(DisplaySupplier.this, "Vui lòng chọn một NCC để chỉnh sửa", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        button4 = new JButton("Xuất Excel");
        button4.setIcon(new ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png")));
        button4.setPreferredSize(new Dimension(135, 42));
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Chọn nơi lưu file");

                int userSelection = fileChooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();

                    Workbook workbook = new XSSFWorkbook();
                    Sheet sheet = workbook.createSheet("Nhà cung cấp");

                    // tao row header
                    Row headerRow = sheet.createRow(0);

                    headerRow.createCell(0).setCellValue("MaNCC");
                    headerRow.createCell(1).setCellValue("TenNCC");
                    headerRow.createCell(2).setCellValue("DiaChi");
                    headerRow.createCell(3).setCellValue("SDT");
                    headerRow.createCell(4).setCellValue("Fax");
                    headerRow.createCell(5).setCellValue("Trạng thái");

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
        panel2.add(button4);


        button5 = new JButton("Nhập Excel");
        button5.setIcon(new ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png")));
        button5.setPreferredSize(new Dimension(135, 42));
        button5.addActionListener(new ActionListener() {
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

                            String maNhaCungCap = row.getCell(0).getStringCellValue();
                            String tenNhaCungCap = row.getCell(1).getStringCellValue();
                            String diaChi = row.getCell(2).getStringCellValue();
                            String soDienThoai = row.getCell(3).getStringCellValue();
                            String fax = row.getCell(4).getStringCellValue();
                            int trangThai = Integer.parseInt(row.getCell(5).getStringCellValue());

                            Supplier supplier = new Supplier(maNhaCungCap, tenNhaCungCap, diaChi, soDienThoai, fax, trangThai);

                            // add to the database
                            supplierBus.add(supplier);
                        }

                        //
                        refreshTable();

                        JOptionPane.showMessageDialog(null, "Nhập file thành công");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Nhập file không thành công");
                        e.printStackTrace();
                    }
                }
            }
        });
        panel2.add(button5);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        panel1.add(panel3);

        cbhienthi= new JComboBox<String>();
        String[] option = {"Đang hoạt động","Đã xóa"};
        cbhienthi = new JComboBox<>(option);
        cbhienthi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });
        panel3.add(cbhienthi);
        JPanel panel4 = new JPanel();
        panel4.setBorder(new TitledBorder("Tìm kiếm"));
        panel4.setLayout(new FlowLayout());
        panel3.add(panel4);

        String[] searchItems = {"MaNCC", "TenNCC","Địa chỉ","SDT"};
        comboBox1 = new JComboBox<>(searchItems);
        comboBox1.setPreferredSize(new Dimension(115, 35));
        panel4.add(comboBox1);
        comboBox1.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String option=(String) comboBox1.getSelectedItem();
                textField1.setText(option);
                addFocusListenerToTextField(option);
            }
        });

        textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(140, 35));
        textField1.setHorizontalAlignment(SwingConstants.CENTER);
        panel4.add(textField1);
        textField1.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = textField1.getText();
                String option = (String) cbhienthi.getSelectedItem();
                int trangthai = option.equals("Đang hoạt động") ? 0 : 1;
                Timkiem(txt, trangthai);

            }
        });




        JButton button6 = new JButton("Làm mới");
        button6.setPreferredSize(new Dimension(135, 43));
        button6.setIcon(new ImageIcon(getClass().getResource("/images/icons8_data_backup_30px.png")));
        panel3.add(button6);
        button6.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });

        JScrollPane scrollPane1 = new JScrollPane();
        contentPane.add(scrollPane1, BorderLayout.CENTER);

        table1 = new JTable();
        model = new DefaultTableModel();
        model.addColumn("MaNCC");
        model.addColumn("TenNCC");
        model.addColumn("DiaChi");
        model.addColumn("SDT");
        model.addColumn("Fax");
        model.addColumn("Trạng thái");
        String options= (String) cbhienthi.getSelectedItem();
        Trangthai(options);
        table1.setModel(model);
        scrollPane1.setViewportView(table1);

        // set font
        Font font = new Font("Segoe UI", 0, 16);
        Font fontHeader = new Font("Segoe UI", Font.BOLD, 16);

        // set font for the table
        table1.setFont(font);
        table1.getTableHeader().setFont(fontHeader);

        // set size for the table
        table1.setRowHeight(30);
        TableColumnModel columnModel = table1.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(150);
        }


        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // Check if it's a single click
                    int row = table1.getSelectedRow(); // Get the selected row
                    if (row != -1) { // Check if a row is selected
                        String trangThai = table1.getValueAt(row, 5).toString(); // Get the value of the "trangThai" column
                        if (trangThai.equals("Đã xóa")) { // Check if "trangThai" is "1"
                            String maSP = table1.getValueAt(row, 0).toString(); // Get the value of the "maSP" column
                            showConfirmationDialog(maSP); // Show confirmation dialog
                        }
                    }
                }
            }
        });
        setContentPane(contentPane);
    }


    public JPanel getPanel_disable() {
        disableButtons();
        return contentPane;
    }


    private void showDialogToAddSupplier() {

        addDialog = new JDialog(this, "Thêm thông tin nhân viên mới", true);
        addDialog.setSize(450, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 5, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblMaNCC = new JLabel("Mã NCC:");
        JTextField txtMaNCC = new JTextField();
        JLabel lblTenNCC = new JLabel("Tên NCC: ");
        JTextField txtTenNCC = new JTextField();
        JLabel lblDiaChi = new JLabel("Địa chỉ:");
        JTextField txtDiaChi = new JTextField();
        JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
        JTextField txtSoDienThoai = new JTextField();
        JLabel lblfax = new JLabel("Fax:");
        JTextField txtfax = new JTextField();
        JLabel lblTrangThai= new JLabel("Trạng thái");
        String[] items = {"Đang hoạt động", "Đã xóa"}; // Tạo một mảng chứa các số nguyên
        JComboBox<String> cbtrangthai = new JComboBox<>(items); // Khởi tạo JComboBox với mảng số nguyên


        panel.add(lblMaNCC);
        panel.add(txtMaNCC);
        panel.add(lblTenNCC);
        panel.add(txtTenNCC);
        panel.add(lblDiaChi);
        panel.add(txtDiaChi);
        panel.add(lblSoDienThoai);
        panel.add(txtSoDienThoai);
        panel.add(lblfax);
        panel.add(txtfax);
        panel.add(lblTrangThai);
        panel.add(cbtrangthai);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton btnOK = new JButton("OK");
        JButton btnCancel = new JButton("Cancel");
        btnOK.setEnabled(false);

        buttonPanel.add(btnOK);
        buttonPanel.add(btnCancel);

        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String trangthai1=doitrangthai(cbtrangthai.getSelectedItem().toString());
                int trangthai=Integer.parseInt(trangthai1);
                if (checkinfo(addDialog, txtMaNCC.getText(), txtSoDienThoai.getText())) {

                    // Thêm nhân viên vào cơ sở dữ liệu
                    Supplier NCC = new Supplier(txtMaNCC.getText(), txtTenNCC.getText(), txtDiaChi.getText(),txtSoDienThoai.getText(), txtfax.getText(),trangthai);
                    supplierBus.add(NCC);

                    // Đóng cửa sổ thêm nhân viên
                    addDialog.dispose();
                }
            }
        });



        btnCancel.addActionListener(new ActionListener() {

            @Override
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
                boolean allFieldsFilled = !txtMaNCC.getText().isEmpty() &&
                        !txtTenNCC.getText().isEmpty() &&
                        !txtDiaChi.getText().isEmpty()&&
                        !txtSoDienThoai.getText().isEmpty()&&
                        !txtfax.getText().isEmpty();

                btnOK.setEnabled(allFieldsFilled);
            }
        };

        txtMaNCC.getDocument().addDocumentListener(documentListener);
        txtTenNCC.getDocument().addDocumentListener(documentListener);
        txtDiaChi.getDocument().addDocumentListener(documentListener);
        txtSoDienThoai.getDocument().addDocumentListener(documentListener);
        txtfax.getDocument().addDocumentListener(documentListener);

        panel.add(buttonPanel);

        addDialog.getContentPane().add(panel);
        addDialog.setLocationRelativeTo(this);
        addDialog.setVisible(true);
    }



    private void showDialogEditSupplier(String Mancc, String tenncc,  String diaChi, String soDienThoai,String fax,String trangthai) {
        editDialog = new JDialog(this, "Chỉnh sửa thông tin NCC", true);
        editDialog.setSize(450, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 5, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblMaNCC = new JLabel("Mã NCC:");
        JTextField txtMaNCC = new JTextField(Mancc);
        txtMaNCC.setEnabled(false);
        JLabel lblTenNCC = new JLabel("Tên NCC: ");
        JTextField txtTenNCC = new JTextField(tenncc);
        JLabel lblDiaChi = new JLabel("Địa chỉ:");
        JTextField txtDiaChi = new JTextField(diaChi);
        JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
        JTextField txtSoDienThoai = new JTextField(soDienThoai);
        JLabel lblfax = new JLabel("Fax:");
        JTextField txtfax= new JTextField(fax);
        JLabel lbltrangthai = new JLabel("Trạng thái:");
        String[] items = {"Đang hoạt động", "Đã xóa"}; // Tạo một mảng chứa các số nguyên
        JComboBox<String> cbtrangthai = new JComboBox<>(items); // Khởi tạo JComboBox với mảng số nguyên
        cbtrangthai.setSelectedItem(trangthai);

        panel.add(lblMaNCC);
        panel.add(txtMaNCC);
        panel.add(lblTenNCC);
        panel.add(txtTenNCC);
        panel.add(lblDiaChi);
        panel.add(txtDiaChi);
        panel.add(lblSoDienThoai);
        panel.add(txtSoDienThoai);
        panel.add(lblfax);
        panel.add(txtfax);
        panel.add(lbltrangthai);
        panel.add(cbtrangthai);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton btnOK = new JButton("OK");
        JButton btnCancel = new JButton("Cancel");

        buttonPanel.add(btnOK);
        buttonPanel.add(btnCancel);

        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String trangthai = doitrangthai(cbtrangthai.getSelectedItem().toString());
                int trangthaiValue=Integer.parseInt(trangthai);
                if(checkinfo(editDialog,txtMaNCC.getText(),txtSoDienThoai.getText())) {
                    Supplier supplier= new Supplier(txtMaNCC.getText(),txtTenNCC.getText(),txtDiaChi.getText(),txtSoDienThoai.getText(),txtfax.getText(),trangthaiValue);
                    supplierBus.update(supplier);

                    editDialog.dispose();
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editDialog.dispose();
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
                boolean allFieldsFilled = !txtMaNCC.getText().isEmpty() &&
                        !txtTenNCC.getText().isEmpty() &&
                        !txtDiaChi.getText().isEmpty()&&
                        !txtSoDienThoai.getText().isEmpty()&&
                        !txtfax.getText().isEmpty();

                btnOK.setEnabled(allFieldsFilled);
            }
        };

        txtMaNCC.getDocument().addDocumentListener(documentListener);
        txtTenNCC.getDocument().addDocumentListener(documentListener);
        txtDiaChi.getDocument().addDocumentListener(documentListener);
        txtSoDienThoai.getDocument().addDocumentListener(documentListener);
        txtfax.getDocument().addDocumentListener(documentListener);
        panel.add(buttonPanel);

        editDialog.getContentPane().add(panel);
        editDialog.setLocationRelativeTo(this);
        editDialog.setVisible(true);
    }



    private void showDialogViewSupplier(String MaNCC, String TenNCC, String diachi, String sdt, String fax, String trangthai) {
        JDialog viewDialog = new JDialog(this, "Xem thông tin nhân viên", true);
        viewDialog.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 5, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Font font = new Font("Arial", Font.BOLD, 14);
        JLabel lblMaNCC = new JLabel("Mã NCC:");
        JTextField txtMaNCC = new JTextField(MaNCC);
        txtMaNCC.setFont(font);
        txtMaNCC.setHorizontalAlignment(SwingConstants.CENTER);
        txtMaNCC.setEnabled(false);
        JLabel lblTenNCC = new JLabel("Tên NCC: ");
        JTextField txtTenNCC = new JTextField(TenNCC);
        txtTenNCC.setHorizontalAlignment(SwingConstants.CENTER);
        txtTenNCC.setFont(font);
        txtTenNCC.setEnabled(false);
        JLabel lblDiaChi = new JLabel("Địa chỉ:");
        JTextField txtDiaChi = new JTextField(diachi);
        txtDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
        txtDiaChi.setFont(font);
        txtDiaChi.setEnabled(false);
        JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
        JTextField txtSoDienThoai = new JTextField(sdt);
        txtSoDienThoai.setHorizontalAlignment(SwingConstants.CENTER);
        txtSoDienThoai.setFont(font);
        txtSoDienThoai.setEnabled(false);
        JLabel lblfax = new JLabel("Fax:");
        JTextField txtfax = new JTextField(fax);
        txtfax.setHorizontalAlignment(SwingConstants.CENTER);
        txtfax.setFont(font);
        txtfax.setEnabled(false);
        JLabel lbltrangthai = new JLabel("Trạng thái:");
        JTextField txttrangthai = new JTextField(trangthai);
        txttrangthai.setHorizontalAlignment(SwingConstants.CENTER);
        txttrangthai.setFont(font);
        txttrangthai.setEnabled(false);

        panel.add(lblMaNCC);
        panel.add(txtMaNCC);
        panel.add(lblTenNCC);
        panel.add(txtTenNCC);
        panel.add(lblDiaChi);
        panel.add(txtDiaChi);
        panel.add(lblSoDienThoai);
        panel.add(txtSoDienThoai);
        panel.add(lblfax);
        panel.add(txtfax);
        panel.add(lbltrangthai);
        panel.add(txttrangthai);

        viewDialog.getContentPane().add(panel);
        viewDialog.setLocationRelativeTo(this);
        viewDialog.setVisible(true);
    }


    // Kiểm tra thông tin
    public boolean checkinfo(JDialog a, String maNV, String SĐT) {
        if (a==addDialog) {
            if (supplierBus.checkId(maNV)) {
                JOptionPane.showMessageDialog(addDialog, "Mã nhân viên đã tồn tại trong bảng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }


        // Kiểm tra số điện thoại
        if (!SĐT.matches("^0[1-9]\\d{8}$")) {
            JOptionPane.showMessageDialog(addDialog, "Số điện thoại không hợp lệ. Vui lòng nhập lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Nếu không có lỗi
        return true;
    }

    public void refreshTable() {
        String option = (String) cbhienthi.getSelectedItem();
        Trangthai(option);
        comboBox1.setSelectedItem("MaNCC");
        addFocusListenerToTextField("MaNCC");
    }


    public void Trangthai(String option) {
        model.setRowCount(0); // Clear existing rows from the table
        supplierBus = new SupplierBUS();
        dsncc = supplierBus.getList();
        for(Supplier sup : dsncc) {
            if(option.equals("Đang hoạt động") && sup.getTrangThai() == 0 || option.equals("Đã xóa") && sup.getTrangThai() == 1 ) {
                addRowToModel(sup);
            }
        }
    }


    public void Timkiem(String txt, int trangthai) {
        String selectedField = (String) comboBox1.getSelectedItem();
        model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);

        for(Supplier sup : dsncc) {
            if (sup.getTrangThai() == trangthai && supplierBus.isMatched(sup, selectedField, txt)) {
                addRowToModel(sup);
            }
        }
    }

    public void addRowToModel(Supplier sup) {
        Object[] row = { sup.getMaNCC(), sup.getTenNCC(), sup.getDiaChi(), sup.getSDT(), sup.getFax(),doitrangthai(sup.getTrangThai()+"") };
        model.addRow(row);
    }





    // Thêm sự kiện focus cho text field
    private void addFocusListenerToTextField(String defaultText) {
        textField1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField1.getText().equals(defaultText)) {
                    textField1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField1.getText().isEmpty()) {
                    textField1.setText(defaultText);
                }
            }
        });
    }

    public void showConfirmationDialog(String maNV) {
        int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn khôi phục nhân viên này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            supplierBus.updateTrangthai(maNV, 0);
            refreshTable();
        }
    }

    public  String doitrangthai(String state) {
        if (state.equals("0")) {
            return "Đang hoạt động";
        } else if (state.equals("Đang hoạt động")) {
            return "0";
        } else if(state.equals("1")){
            return "Đã xóa";
        }else if(state.equals("Đã xóa")) {
            return "1";
        }
        return "Lỗi";
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
                for (int i = 0; i < table1.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(table1.getColumnName(i));
                }

                for (int j = 0; j < table1.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < table1.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (table1.getValueAt(j, k) != null) {
                            cell.setCellValue(table1.getValueAt(j, k).toString());
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
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button5.setEnabled(false);
        buttonview.setEnabled(false);
        cbhienthi.removeItem("Đã xóa");
    }


}
