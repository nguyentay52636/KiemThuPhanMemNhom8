package Layout.models.FrontEnd.FormSupplier;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Layout.models.BackEnd.BUS.SupplierBUS;
import Layout.models.BackEnd.DTO.Supplier;
import Layout.models.FrontEnd.FormNhapHang.FormNhapHang;

public class FormChonNCC extends JFrame {
    private FormNhapHang.SupplierSelectedListener listener;
    SupplierBUS qlncc = new SupplierBUS();

    public void setSupplierSelectedListener(FormNhapHang.SupplierSelectedListener listener) {
        this.listener = listener;
    }

    public FormChonNCC() {
        initComponents();
        this.setTitle("Chọn nhà cung cấp");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        refresh();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel6 = new JPanel();
        comboBox1 = new JComboBox();
        textField1 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel2 = new JPanel();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout(1, 1));

            //======== panel3 ========
            {
                panel3.setLayout(new FlowLayout());
            }
//            panel1.add(panel3);

            //======== panel4 ========
            {
                panel4.setLayout(new FlowLayout());

                //======== panel6 ========
                {
                    panel6.setBorder(new TitledBorder("T\u00ecm ki\u1ebfm"));
                    panel6.setLayout(new FlowLayout());

                    //---- comboBox1 ----
                    comboBox1.setPreferredSize(new Dimension(130, 35));
                    panel6.add(comboBox1);

                    //---- textField1 ----
                    textField1.setPreferredSize(new Dimension(180, 55));
                    panel6.add(textField1);
                }
                panel4.add(panel6);

                //---- button1 ----
                button1.setText("L\u00e0m m\u1edbi");
                button1.setPreferredSize(new Dimension(110, 42));
                button1.setIcon(new ImageIcon(getClass().getResource("/images/icons8_data_backup_30px.png")));
                panel4.add(button1);
            }
            panel1.add(panel4);
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                    new Object[][] {
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                    },
                    new String[] {
                            null, null, null, null, null, null
                    }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);

        //======== panel2 ========
        {
            panel2.setLayout(new FlowLayout());

            //---- button2 ----
            button2.setText("Ch\u1ecdn");
            button2.setPreferredSize(new Dimension(110, 42));
            button2.setIcon(new ImageIcon(getClass().getResource("/images/icons8_ok_30px.png")));
            panel2.add(button2);

            //---- button3 ----
            button3.setText("Tho\u00e1t");
            button3.setPreferredSize(new Dimension(110, 42));
            button3.setIcon(new ImageIcon(getClass().getResource("/images/icons8_cancel_30px_1.png")));
            panel2.add(button3);
        }
        contentPane.add(panel2, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        // set font
        Font font = new Font("Segoe UI", 0, 16);
        Font fontHeader = new Font("Segoe UI", Font.BOLD, 16);

        // font in table
        table1.setFont(font);
        table1.getTableHeader().setFont(fontHeader);

        // set size for table
        table1.setRowHeight(30);
        TableColumnModel columnModel = table1.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(150);
        }

        String[] items = { "Tất cả", "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Trạng thái" };
        for (String item : items) {
            comboBox1.addItem(item);
        }

        // sự kiện khi chọn item trong combobox1
        textField1.setBorder(BorderFactory.createTitledBorder("Tất cả"));
        comboBox1.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedItem = (String) comboBox1.getSelectedItem();
                if (selectedItem.equals("Tất cả")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Tất cả"));
                } else if (selectedItem.equals("Mã nhà cung cấp")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Nhập mã nhà cung cấp"));
                } else if (selectedItem.equals("Tên nhà cung cấp")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Nhập tên nhà cung cấp"));
                } else if (selectedItem.equals("Số điện thoại")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Nhập số điện thoại"));
                } else if (selectedItem.equals("Địa chỉ")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Nhập địa chỉ"));
                } else if (selectedItem.equals("Trạng thái")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Nhập trạng thái"));
                }
            }
        });

        // sự kiện khi click nút làm mới
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comboBox1.setSelectedItem("Tất cả");
                textField1.setText("");
                refresh();
            }
        });

        // search
        textField1.getDocument().addDocumentListener(new DocumentListener() {
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
                String value = textField1.getText();
                String type = (String) comboBox1.getSelectedItem();
                // ArrayList<Supplier> result = qlncc.search(value, type);

                // setDataToTable(result);
            }
        });

        // xem chi tiet
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // kiem tra chuot phai co duocj nhan hay khong
                if (SwingUtilities.isRightMouseButton(e)) {
                    // lay chi so row duoc nhan
                    int row = table1.rowAtPoint(e.getPoint());
                    table1.setRowSelectionInterval(row, row);

                    // tao popup menu
                    JPopupMenu popup = new JPopupMenu();
                    JMenuItem detailItem = new JMenuItem("Xem chi tiết");
                    popup.add(detailItem);

                    // su kien khi nhan vao xem chi tiet
                    detailItem.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            // lay ma khach hang
                            String maNcc = (String) table1.getValueAt(row, 1);

                            // tim ma khach hang trong danh sach
                            Supplier selectedCustomer = null;
                            for (Supplier supplier : qlncc.getList()) {
                                if (supplier.getMaNCC().equals(maNcc)) {
                                    selectedCustomer = supplier;
                                    break;
                                }
                            }

                            // hien thi thong tin chi tiet
                            if (selectedCustomer != null) {
                                JOptionPane.showMessageDialog(null,
                                        "Mã nhà cung cấp: " + selectedCustomer.getMaNCC() + "\n"
                                                + "Tên nhà cung cấp : " + selectedCustomer.getTenNCC() + "\n"
                                                + "Địa chỉ: " + selectedCustomer.getDiaChi() + "\n"
                                                + "Số điện thoại: " + selectedCustomer.getSDT() + "\n"
                                                + "Fax :  " + selectedCustomer.getFax());
                            } else {
                                JOptionPane.showMessageDialog(null, "Không tìm thấy nhà cung cấp");

                            }
                        }
                    });
                    popup.show(table1, e.getX(), e.getY());
                }
            }
        });

        // sự kiện khi click nút chọn
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Supplier selectedSupplier = getSelectedSupplier();
                if (selectedSupplier != null && listener != null) {
                     listener.onSupplierSelected(selectedSupplier);
                }
                dispose();
            }
        });

        // su kien khi nhan vao nut thoat
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
    }

    public void addButtonAddActionListener(ActionListener actionListener) {
        button2.addActionListener(actionListener);
    }

    // lay ma nha cung cap
    public String getSelectedSupplierID() {
        int selectedRow = table1.getSelectedRow();
        if (selectedRow != -1) {
            return (String) table1.getValueAt(selectedRow, 1);
        }
        return null;
    }

    //
    public Supplier getSelectedSupplier() {
        String selectedSupplierID = getSelectedSupplierID();
        if (selectedSupplierID != null) {
            for (Supplier supplier : qlncc.getList()) {
                if (supplier.getMaNCC().equals(selectedSupplierID)) {
                    return supplier;
                }
            }
        }
        return null;
    }

    // refresh data
    public void refresh() {
        qlncc.listNCC();
        setDataToTable(qlncc.getList());
    }

    // set dât to table
    public void setDataToTable(ArrayList<Supplier> data) {
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("STT");
        tableModel.addColumn("Mã nhà cung cấp");
        tableModel.addColumn("Tên nhà cung cấp");
        tableModel.addColumn("Địa chỉ");
        tableModel.addColumn("Số điện thoại");
        tableModel.addColumn("Fax:");
        tableModel.addColumn("Trạng thái:");

        int stt = 1;
        for (Supplier suppliler : data) {
            if (suppliler.getTrangThai() == 0) {
                tableModel.addRow(new Object[] {
                        stt++,
                        suppliler.getMaNCC(),
                        suppliler.getTenNCC(),
                        suppliler.getDiaChi(),
                        suppliler.getSDT(),
                        suppliler.getFax(),
                        suppliler.getTrangThai() == 0 ? "Đang hoạt động" : "Ngừng hoạt động"
                });
            }
        }
        table1.setModel(tableModel);
    }

    // public void
    // SupplierSelectedListener(FormNhapHang.SupplierSelectedListenerSelectedListener
    // listener) {
    // this.listener = listener;
    // }

    public interface CustomerSelectedListener {
        void onSupplierSelected(Supplier customer);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel6;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel2;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
