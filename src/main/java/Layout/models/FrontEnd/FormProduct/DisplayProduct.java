package Layout.models.FrontEnd.FormProduct;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Layout.models.BackEnd.BUS.ProductBUS;
import Layout.models.BackEnd.BUS.TypeProductBUS;
import Layout.models.BackEnd.DTO.Product;

public class DisplayProduct extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private ProductBUS productBus;
    private TypeProductBUS tpbus;
    private ProductDialog productDialog;

    public DisplayProduct() {
        productBus = new ProductBUS();
        tpbus = new TypeProductBUS();
        model = new DefaultTableModel();
        table = new JTable(model);
        productDialog = new ProductDialog(this, productBus, tpbus, table);

        // Initialize components
        initComponents();
    }

    private void initComponents() {
        // Add columns to the model
        model.addColumn("Mã sản phẩm");
        model.addColumn("Mã lô sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Đơn giá");
        model.addColumn("File ảnh");
        model.addColumn("Số lượng");
        model.addColumn("Trạng thái");

        // Set custom renderer for the image column
        table.getColumn("File ảnh").setCellRenderer(new ImageRenderer());

        // Load data into the table
        loadData();

        // Add buttons and their action listeners
        JButton btnAdd = new JButton("Add");
        JButton btnEdit = new JButton("Edit");
        JButton btnDelete = new JButton("Delete");

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productDialog.showDialogToAddProduct();
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String maSP = (String) model.getValueAt(selectedRow, 0);
                    String maLSP = (String) model.getValueAt(selectedRow, 1);
                    String tenSP = (String) model.getValueAt(selectedRow, 2);
                    Float donGia = Float.parseFloat((String) model.getValueAt(selectedRow, 3));
                    String fileAnh = (String) model.getValueAt(selectedRow, 4);
                    int soLuong = Integer.parseInt((String) model.getValueAt(selectedRow, 5));
                    String trangThai = (String) model.getValueAt(selectedRow, 6);

                    productDialog.showDialogToEditProduct(maSP, maLSP, tenSP, donGia, fileAnh, soLuong, trangThai);
                } else {
                    JOptionPane.showMessageDialog(DisplayProduct.this, "Please select a product to edit.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String maSP = (String) model.getValueAt(selectedRow, 0);
                    productDialog.showDialogToDeleteProduct(maSP);
                } else {
                    JOptionPane.showMessageDialog(DisplayProduct.this, "Please select a product to delete.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add components to the frame
        JPanel panel = new JPanel();
        panel.add(btnAdd);
        panel.add(btnEdit);
        panel.add(btnDelete);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, "Center");
        add(panel, "South");

        setTitle("Product Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void loadData() {
        productBus.readDB();
        for (Product product : productBus.getList()) {
            ImageIcon imageIcon = null;
            String imagePath = product.getHinhAnh(); // Assuming the correct method name is getHinhAnh()
            if (imagePath != null && !imagePath.isEmpty()) {
                java.io.File imageFile = new java.io.File(imagePath);
                if (imageFile.exists()) {
                    imageIcon = new ImageIcon(imagePath);
                    // Optionally, scale the image to fit the table cell
                    Image img = imageIcon.getImage();
                    Image scaledImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(scaledImg);
                }
            }

            model.addRow(new Object[] {
                    product.getMaSP(),
                    product.getMaLSP(),
                    product.getTenSP(),
                    String.valueOf(product.getDonGia()),
                    imageIcon, // Use ImageIcon instead of string
                    String.valueOf(product.getSoLuong()),
                    String.valueOf(product.getTrangthai())
            });
        }
    }

    // Method to check if an image has been added to a row
    private boolean isImageAddedToRow(int rowIndex) {
        Object value = model.getValueAt(rowIndex, 4); // Assuming the image is in the 5th column (index 4)
        return value instanceof ImageIcon;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DisplayProduct displayProduct = new DisplayProduct();
                displayProduct.setVisible(true);

                // Example usage of isImageAddedToRow method
                int rowIndex = 0; // Check the first row
                boolean isImageAdded = displayProduct.isImageAddedToRow(rowIndex);
                System.out.println("Is image added to row " + rowIndex + ": " + isImageAdded);
            }
        });
    }

    // Custom renderer for image column
    class ImageRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            if (value instanceof ImageIcon) {
                setIcon((ImageIcon) value);
                setText(null);
            } else {
                setIcon(null);
                setText(value != null ? value.toString() : "");
            }
            return this;
        }
    }
}