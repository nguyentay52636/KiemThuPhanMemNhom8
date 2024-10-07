package Layout.models.FrontEnd.FormProduct;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import Layout.models.BackEnd.BUS.ProductBUS;
import Layout.models.BackEnd.BUS.TypeProductBUS;
import Layout.models.BackEnd.DTO.Product;
import Layout.models.BackEnd.DTO.TypeProduct;
import Layout.models.FrontEnd.Formatter.PriceFormatter;

public class ProductDialog {

    private JFrame parentFrame;
    private ProductBUS productBus;
    private TypeProductBUS tpbus;
    private JTable table;
    private DefaultTableModel model;

    public ProductDialog(JFrame parentFrame, ProductBUS productBus, TypeProductBUS tpbus, JTable table) {
        this.parentFrame = parentFrame;
        this.productBus = productBus;
        this.tpbus = tpbus;
        this.table = table;
    }

    public void showDialogToAddProduct() {
        JDialog addDialog = new JDialog(parentFrame, "Thêm sản phẩm", true);
        addDialog.setSize(450, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 5, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblMaSP = new JLabel("Mã sản phẩm:");
        JTextField txtMaSP = new JTextField();
        txtMaSP.setText(productBus.getNextID());
        txtMaSP.setEnabled(false);

        JLabel lblMaLSP = new JLabel("Mã lô hàng sản phẩm: ");
        ArrayList<TypeProduct> listlsp = tpbus.getDslsp();
        ArrayList<String> listMLSP = new ArrayList<>();
        for (TypeProduct lsp : listlsp) {
            listMLSP.add(lsp.getMaLoaiSanPham());
        }
        JComboBox<String> cbLSP = new JComboBox<>(listMLSP.toArray(new String[0]));

        JLabel lblTenSP = new JLabel("Tên sản phẩm:");
        JTextField txtTenSP = new JTextField();
        JLabel lblDonGia = new JLabel("Đơn giá:");
        JTextField txtDonGia = new JTextField();
        txtDonGia.setEnabled(false);

        JLabel lblFileAnh = new JLabel("File ảnh:");
        
        JButton btnChooseImage = new JButton("Chọn ảnh");

        JLabel lblSoLuong = new JLabel("Số lượng:");
        JTextField txtSoLuong = new JTextField();
        txtSoLuong.setEnabled(false);

        JLabel lblTrangThai = new JLabel("Trạng thái:");
        JComboBox<String> cboTrangThai = new JComboBox<>(new String[] { "Đang bán", "Đã xóa", "Chờ nhập hàng " });

        btnChooseImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser
                        .setCurrentDirectory(new java.io.File(System.getProperty("user.dir") + "/src/main/resources/"));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif",
                        "jpeg");
                fileChooser.addChoosableFileFilter(filter);
                fileChooser.setAcceptAllFileFilterUsed(false);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    java.io.File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getPath();
                    String fileName = selectedFile.getName();
                    btnChooseImage.setText(fileName);
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        table.setValueAt(filePath, selectedRow, 5);
                    }
                }
            }
        });

        panel.add(lblMaSP);
        panel.add(txtMaSP);
        panel.add(lblMaLSP);
        panel.add(cbLSP);
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

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton btnOK = new JButton("OK");
        JButton btnCancel = new JButton("Cancel");
        btnOK.setEnabled(false);

        buttonPanel.add(btnOK);
        buttonPanel.add(btnCancel);

        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maSP = txtMaSP.getText();
                String maLSP = (String) cbLSP.getSelectedItem();
                String tenSP = txtTenSP.getText();
                String fileAnh = btnChooseImage.getText();
                String trangThai = doitrangthai(cboTrangThai.getSelectedItem() + "");
                String formattedPrice = txtDonGia.getText();
                String txtsoLuong = txtSoLuong.getText();

                if (!ValidateInput.isNotEmpty(maSP) || !ValidateInput.isNotEmpty(maLSP)
                        || !ValidateInput.isNotEmpty(tenSP)
                        || !ValidateInput.isValidNumber(formattedPrice) || !ValidateInput.isValidInteger(txtsoLuong)) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields correctly.", "Validation Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                float donGia;
                int soLuong;
                try {
                    donGia = Float.parseFloat(formattedPrice);
                    soLuong = Integer.parseInt(txtsoLuong);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Đơn giá và số lượng phải là số.", "Validation Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (checkinform(maSP, "addDialog", donGia, soLuong)) {
                    model = (DefaultTableModel) table.getModel();
                    String formattedPriceForDisplay = PriceFormatter.format(donGia);
                    model.addRow(
                            new Object[] { maSP, maLSP, tenSP, formattedPriceForDisplay, fileAnh, soLuong, trangThai });
                    Product product = new Product(maSP, maLSP, tenSP, donGia, soLuong, fileAnh,
                            Integer.parseInt(trangThai));
                    productBus.addBus(product);
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
                boolean allFieldsFilled = ValidateInput.isNotEmpty(txtMaSP.getText()) &&
                        ValidateInput.isNotEmpty(txtTenSP.getText()) &&
                        ValidateInput.isNotEmpty(btnChooseImage.getText());

                boolean validDonGia = ValidateInput.isValidNumber(txtDonGia.getText());
                boolean validSoLuong = ValidateInput.isValidInteger(txtSoLuong.getText());

                if (!validDonGia && !txtDonGia.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Đơn giá phải là số.", "Validation Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                if (!validSoLuong && !txtSoLuong.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Số lượng phải là số.", "Validation Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                btnOK.setEnabled(allFieldsFilled && validDonGia && validSoLuong);
            }
        };

        txtTenSP.getDocument().addDocumentListener(documentListener);
        txtDonGia.getDocument().addDocumentListener(documentListener);
        txtSoLuong.getDocument().addDocumentListener(documentListener);

        panel.add(buttonPanel);
        addDialog.getContentPane().add(panel);
        addDialog.setLocationRelativeTo(parentFrame);
        addDialog.setVisible(true);
    }

    public void showDialogToEditProduct(String maSP, String maLSP, String tenSP, Float donGia, String fileAnh,
            int soLuong, String trangThai) {
        JDialog editDialog = new JDialog(parentFrame, "Chỉnh sửa sản phẩm", true);
        editDialog.setSize(450, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 5, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblMaSP = new JLabel("Mã sản phẩm:");
        JTextField txtMaSP = new JTextField(maSP);
        txtMaSP.setEnabled(false);

        JLabel lblMaLSP = new JLabel("Mã lô hàng sản phẩm: ");
        ArrayList<TypeProduct> listlsp = tpbus.getDslsp();
        ArrayList<String> listMLSP = new ArrayList<>();
        for (TypeProduct lsp : listlsp) {
            listMLSP.add(lsp.getMaLoaiSanPham());
        }
        JComboBox<String> cbLSP = new JComboBox<>(listMLSP.toArray(new String[0]));
        cbLSP.setSelectedItem(maLSP);

        JLabel lblTenSP = new JLabel("Tên sản phẩm:");
        JTextField txtTenSP = new JTextField(tenSP);
        JLabel lblDonGia = new JLabel("Đơn giá:");
        JTextField txtDonGia = new JTextField(String.valueOf(donGia));
        txtDonGia.setEnabled(false);

        JLabel lblFileAnh = new JLabel("File ảnh:");
        JButton btnChooseImage = new JButton(fileAnh);

        JLabel lblSoLuong = new JLabel("Số lượng:");
        JTextField txtSoLuong = new JTextField(String.valueOf(soLuong));
        txtSoLuong.setEnabled(false);

        JLabel lblTrangThai = new JLabel("Trạng thái:");
        JComboBox<String> cboTrangThai = new JComboBox<>(new String[] { "Đang bán", "Đã xóa", "Chờ nhập hàng " });
        cboTrangThai.setSelectedItem(trangThai);

        btnChooseImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser
                        .setCurrentDirectory(new java.io.File(System.getProperty("user.dir") + "/src/main/resources/"));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif",
                        "jpeg");
                fileChooser.addChoosableFileFilter(filter);
                fileChooser.setAcceptAllFileFilterUsed(false);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    java.io.File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getPath();
                    String fileName = selectedFile.getName();
                    btnChooseImage.setText(fileName);
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        table.setValueAt(filePath, selectedRow, 5);
                    }
                }
            }
        });

        panel.add(lblMaSP);
        panel.add(txtMaSP);
        panel.add(lblMaLSP);
        panel.add(cbLSP);
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

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton btnOK = new JButton("OK");
        JButton btnCancel = new JButton("Cancel");

        buttonPanel.add(btnOK);
        buttonPanel.add(btnCancel);

        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maLSP = (String) cbLSP.getSelectedItem();
                String tenSP = txtTenSP.getText();
                String fileAnh = btnChooseImage.getText();
                String trangThai = doitrangthai(cboTrangThai.getSelectedItem() + "");
                String formattedPrice = txtDonGia.getText();
                String txtsoLuong = txtSoLuong.getText();

                if (!ValidateInput.isNotEmpty(maSP) || !ValidateInput.isNotEmpty(maLSP)
                        || !ValidateInput.isNotEmpty(tenSP)
                        || !ValidateInput.isValidNumber(formattedPrice) || !ValidateInput.isValidInteger(txtsoLuong)) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields correctly.", "Validation Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                float donGia;
                int soLuong;
                try {
                    donGia = Float.parseFloat(formattedPrice);
                    soLuong = Integer.parseInt(txtsoLuong);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Đơn giá và số lượng phải là số.", "Validation Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (checkinform(maSP, "editDialog", donGia, soLuong)) {
                    model = (DefaultTableModel) table.getModel();
                    String formattedPriceForDisplay = PriceFormatter.format(donGia);
                    int selectedRow = table.getSelectedRow();
                    model.setValueAt(maLSP, selectedRow, 1);
                    model.setValueAt(tenSP, selectedRow, 2);
                    model.setValueAt(formattedPriceForDisplay, selectedRow, 3);
                    model.setValueAt(fileAnh, selectedRow, 4);
                    model.setValueAt(soLuong, selectedRow, 5);
                    model.setValueAt(trangThai, selectedRow, 6);
                    Product product = new Product(maSP, maLSP, tenSP, donGia, soLuong, fileAnh,
                            Integer.parseInt(trangThai));
                    productBus.update(product);
                    refreshTable();
                    editDialog.dispose();
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editDialog.dispose();
            }
        });

        panel.add(buttonPanel);
        editDialog.getContentPane().add(panel);
        editDialog.setLocationRelativeTo(parentFrame);
        editDialog.setVisible(true);
    }

    public void showDialogToDeleteProduct(String maSP) {
        int confirm = JOptionPane.showConfirmDialog(parentFrame, "Bạn có chắc chắn muốn xóa sản phẩm này?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            productBus.updateTrangthai(maSP, confirm);
            refreshTable();
        }
    }

    private boolean checkinform(String maSP, String x, Float donGiaStr, int soLuongStr) {
        if (x.equals("addDialog")) {
            if (productBus.checkidproduct(maSP)) {
                JOptionPane.showMessageDialog(parentFrame, "Mã sản phẩm đã tồn tại trong bảng.", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return false; // Thoát khỏi sự kiện nếu có lỗi
            }
        }

        if (donGiaStr < 0) {
            JOptionPane.showMessageDialog(parentFrame, "Số lượng phải là số thực không âm", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false; // Thoát khỏi sự kiện nếu có lỗi
        }

        String soLuongStr1 = String.valueOf(soLuongStr);
        if (!soLuongStr1.trim().matches("^[1-9]\\d*$")) {
            JOptionPane.showMessageDialog(parentFrame, "Số lượng phải là số dương từ 1 đến 9", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false; // tôi muốn đổi chúng sang dạng chuỗi để làm cái này
        }

        return true;
    }

    private String doitrangthai(String trangThai) {
        switch (trangThai) {
            case "Đang bán":
                return "1";
            case "Đã xóa":
                return "0";
            case "Chờ nhập hàng":
                return "2";
            default:
                return "1";
        }
    }

    private void refreshTable() {
        // Implement the logic to refresh the table data
    }
}