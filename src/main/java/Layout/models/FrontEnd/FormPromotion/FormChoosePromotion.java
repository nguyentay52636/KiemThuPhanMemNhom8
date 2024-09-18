/*
 * Created by JFormDesigner on Sat May 04 19:26:42 ICT 2024
 */

package Layout.models.FrontEnd.FormPromotion;

import Layout.models.BackEnd.BUS.PromotionBUS;
import Layout.models.BackEnd.DTO.Customer;
import Layout.models.BackEnd.DTO.Promotion;
import Layout.models.FrontEnd.FormBanHang.FormChooseCustomer;
import Layout.models.FrontEnd.FormBanHang.FormSell;

import java.awt.*;
import java.awt.event.*;
import java.security.DigestException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;

/**
 * @author master
 */
public class FormChoosePromotion extends JFrame {
    private PromotionBUS qlkm = new PromotionBUS();
    private FormSell.PromotionSelectedListener listener;

    public void setPromotionSelectedListener(FormSell.PromotionSelectedListener listener) {
        this.listener = listener;
    }

    public FormChoosePromotion() {
        initComponents();
        this.setTitle("Chọn khuyến mãi");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        refresh();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
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

                //======== panel4 ========
                {
                    panel4.setBorder(new TitledBorder("Tìm kiếm"));
                    panel4.setLayout(new FlowLayout());

                    //===== comboBox1 =====
                    comboBox1.setPreferredSize(new Dimension(130, 35));
                    panel4.add(comboBox1);

                    //---- textField1 ----
                    textField1.setPreferredSize(new Dimension(180, 55));
                    panel4.add(textField1);
                }
                panel3.add(panel4);

                //---- button1 ----
                button1.setText("L\u00e0m m\u1edbi");
                button1.setPreferredSize(new Dimension(110, 42));
                button1.setIcon(new ImageIcon(getClass().getResource("/images/icons8_data_backup_30px.png")));
                panel3.add(button1);
            }
            panel1.add(panel3);
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null, null, null, null
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

        String[] items = {"Tất cả", "Mã khuyến mãi", "Tên khuyến mãi", "Điều kiện khuyến mãi", "Phần trăm khuyến mãi", "Ngày bắt đầu", "Ngày kết thúc"};
        for (String item : items) {
            comboBox1.addItem(item);
        }

        // su kien khi chon item trong combobox1
        textField1.setBorder(BorderFactory.createTitledBorder("Tất cả"));
        comboBox1.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedItem = (String) comboBox1.getSelectedItem();
                if (selectedItem.equals("Tất cả")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Tất cả"));
                } else if (selectedItem.equals("Mã khuyến mãi")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Nhập mã khuyến mãi"));
                } else if (selectedItem.equals("Tên khuyến mãi")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Nhập tên khuyến mãi"));
                } else if (selectedItem.equals("Điều kiện khuyến mãi")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Nhập điều kiện khuyến mãi"));
                } else if (selectedItem.equals("Phần trăm khuyến mãi")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Nhập phần trăm khuyến mãi"));
                } else if (selectedItem.equals("Ngày bắt đầu")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Nhập ngày bắt đầu"));
                } else if (selectedItem.equals("Ngày kết thúc")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Nhập ngày kết thúc"));
                }
            }
        });

        // su kien khi nhan vao nut lam moi
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
                ArrayList<Promotion> result = qlkm.search(value, type, -1, -1, -1, -1, null, null);
                setDataToTable(result);
            }
        });

        // Xem chi tiet
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
                            String makm = (String) table1.getValueAt(row, 1);

                            // tim ma khach hang trong danh sach
                            Promotion selectedPromotion = null;
                            for (Promotion promotion : qlkm.getDskm()) {
                                if (promotion.getMaKhuyenMai().equals(makm)) {
                                    selectedPromotion = promotion;
                                    break;
                                }
                            }

                            // hien thi thong tin chi tiet
                            if (selectedPromotion != null) {
                                JOptionPane.showMessageDialog(null, "Mã khuyến mãi: " + selectedPromotion.getMaKhuyenMai()
                                        + "\nTên khuyến mãi: " + selectedPromotion.getTenKhuyenMai()
                                        + "\nĐiều kiện khuyến mãi: " + selectedPromotion.getDieuKienKhuyenMai()
                                        + "\nPhần trăm khuyến mãi: " + selectedPromotion.getPhanTramKhuyenMai()
                                        + "\nNgày bắt đầu: " + selectedPromotion.getNgayBatDau()
                                        + "\nNgày kết thúc: " + selectedPromotion.getNgayKetThuc()
                                        + "\nTrạng thái: " + selectedPromotion.getTrangThai());
                            } else {
                                JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng");

                            }
                        }
                    });
                    popup.show(table1, e.getX(), e.getY());
                }
            }
        });

        // su kien khi click nut chon
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Promotion selectedPromotion = getSelectedPromotion();
                if (selectedPromotion != null && listener != null) {
                    listener.onPromotionSelected(selectedPromotion);
                }
                dispose();
            }
        });

        // su kien khi nhan nut thoat
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
    }

    public String getSelectedPromotionID() {
        int row = table1.getSelectedRow();
        if (row != -1) {
            return (String) table1.getValueAt(row, 1);
        }
        return null;
    }

    public Promotion getSelectedPromotion() {
        String selectedPromotionid = getSelectedPromotionID();
        if (selectedPromotionid != null) {
            for (Promotion promotion : qlkm.getDskm()) {
                if (promotion.getMaKhuyenMai().equals(selectedPromotionid)) {
                    return promotion;
                }
            }
        }
        return null;
    }

    // refresh data
    public void refresh() {
        qlkm.readDB();
        setDataToTable(qlkm.getDskm());
    }

    // set data to table
    public void setDataToTable(ArrayList<Promotion> data) {
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("STT");
        tableModel.addColumn("Mã");
        tableModel.addColumn("Tên");
        tableModel.addColumn("Điều kiện");
        tableModel.addColumn("Giảm giá");
        tableModel.addColumn("Ngày bắt đầu");
        tableModel.addColumn("Ngày kết thúc");
        tableModel.addColumn("Trạng thái");

        int stt = 1;
        for (Promotion promotion : data) {
            if (promotion.getTrangThai().equals("Đang diễn ra")) {
                tableModel.addRow(new Object[] {
                        stt++,
                        promotion.getMaKhuyenMai(),
                        promotion.getTenKhuyenMai(),
                        promotion.getDieuKienKhuyenMai(),
                        promotion.getPhanTramKhuyenMai(),
                        promotion.getNgayBatDau(),
                        promotion.getNgayKetThuc(),
                        promotion.getTrangThai()
                });
            }
        }
        table1.setModel(tableModel);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JPanel panel3;
    private JPanel panel4;
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
                new FormChoosePromotion();
            }
        });
    }
}
