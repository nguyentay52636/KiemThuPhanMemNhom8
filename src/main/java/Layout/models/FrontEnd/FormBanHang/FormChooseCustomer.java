/*
 * Created by JFormDesigner on Sat May 04 12:38:37 ICT 2024
 */

package Layout.models.FrontEnd.FormBanHang;

import Layout.models.BackEnd.BUS.CustomerBUS;
import Layout.models.BackEnd.DTO.Customer;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;

/**
 * @author master
 */
public class FormChooseCustomer extends JFrame {
    private FormSell.CustomerSelectedListener listener;

    CustomerBUS qlkh = new CustomerBUS();

    public void setCustomerSelectedListener(FormSell.CustomerSelectedListener listener) {
        this.listener = listener;
    }

    public FormChooseCustomer() {
        initComponents();
        this.setTitle("Chọn Khách Hàng");
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

        String[] items = {"Tất cả", "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại", "Trạng thái"};
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
                } else if (selectedItem.equals("Mã khách hàng")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Nhập mã khách hàng"));
                } else if (selectedItem.equals("Tên khách hàng")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Nhập tên khách hàng"));
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
                ArrayList<Customer> result = qlkh.search(value, type);

                setDataToTable(result);
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
                            String maKH = (String) table1.getValueAt(row, 1);

                            // tim ma khach hang trong danh sach
                            Customer selectedCustomer = null;
                            for (Customer customer : qlkh.getDskh()) {
                                if (customer.getMaKH().equals(maKH)) {
                                    selectedCustomer = customer;
                                    break;
                                }
                            }

                            // hien thi thong tin chi tiet
                            if (selectedCustomer != null) {
                                JOptionPane.showMessageDialog(null, "Mã khách hàng: " + selectedCustomer.getMaKH() + "\n"
                                        + "Tên khách hàng: " + selectedCustomer.getTenKh() + "\n"
                                        + "Địa chỉ: " + selectedCustomer.getDiaChi() + "\n"
                                        + "Số điện thoại: " + selectedCustomer.getSdt() + "\n"
                                        + "Trạng thái: " + (selectedCustomer.getTrangThai() == 0 ? "Đang hoạt động" : "Ngừng hoạt động"));
                            } else {
                                JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng");

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
                Customer selectedCustomer = getSelectedCustomer();
                if (selectedCustomer != null && listener != null) {
                    listener.onCustomerSelected(selectedCustomer);
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

    // lay ma khach hang
    public String getSelectedCustomerId() {
        int selectedRow = table1.getSelectedRow();
        if (selectedRow != -1) {
            return (String) table1.getValueAt(selectedRow, 1);
        }
        return null;
    }

    //
    public Customer getSelectedCustomer() {
        String selectedCustomerId = getSelectedCustomerId();
        if (selectedCustomerId != null) {
            for (Customer customer : qlkh.getDskh()) {
                if (customer.getMaKH().equals(selectedCustomerId)) {
                    return customer;
                }
            }
        }
        return null;
    }

    // refresh data
    public void refresh() {
        qlkh.readDB();
        setDataToTable(qlkh.getDskh());
    }

    // set dât to table
    public void setDataToTable(ArrayList<Customer> data) {
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("STT");
        tableModel.addColumn("Mã khách hàng");
        tableModel.addColumn("Tên khách hàng");
        tableModel.addColumn("Địa chỉ");
        tableModel.addColumn("Số điện thoại");
        tableModel.addColumn("Trạng thái");

        int stt = 1;
        for (Customer customer : data) {
            if (customer.getTrangThai() == 0) {
                tableModel.addRow(new Object[] {
                        stt++,
                        customer.getMaKH(),
                        customer.getTenKh(),
                        customer.getDiaChi(),
                        customer.getSdt(),
                        customer.getTrangThai() == 0 ? "Đang hoạt động" : "Ngừng hoạt động"
                });
            }
        }
        table1.setModel(tableModel);
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

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                .getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormChooseCustomer();
            }
        });
    }
}

