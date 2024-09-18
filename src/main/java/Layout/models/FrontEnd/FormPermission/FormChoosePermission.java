/*
 * Created by JFormDesigner on Thu Apr 25 09:57:05 ICT 2024
 */

package Layout.models.FrontEnd.FormPermission;

import Layout.models.BackEnd.BUS.PermissionBUS;
import Layout.models.BackEnd.DTO.Permission;
import Layout.models.FrontEnd.FormBanHang.FormSell;
import Layout.models.FrontEnd.FormStaff.FormChooseEmployee;

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
public class FormChoosePermission extends JFrame {
    private FormPermission.PermissionAddedListener listener;

    PermissionBUS qlq = new PermissionBUS();

    public void setPermissionSelectedListener(FormPermission.PermissionAddedListener listener) {
        this.listener = listener;
    }

    public FormChoosePermission() {
        initComponents();
        this.setTitle("Chọn khuyến mãi");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        refresh();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Master
        panel1 = new JPanel();
        panel2 = new JPanel();
        panelft = new JPanel();
        comboBox1 = new JComboBox();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
            . EmptyBorder( 0, 0, 0, 0) , "", javax. swing. border. TitledBorder. CENTER, javax
            . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
            12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans
            . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .
            getPropertyName () )) throw new RuntimeException( ); }} );
            panel1.setLayout(new FlowLayout());

            //======== panel2 ========
            {
                panel2.setBorder(new TitledBorder("T\u00ecm ki\u1ebfm"));
                panel2.setLayout(new FlowLayout());

                //---- comboBox1 ----
                comboBox1.setPreferredSize(new Dimension(130, 40));
                panel2.add(comboBox1);

                //---- textField1 ----
                textField1.setPreferredSize(new Dimension(144, 55));
                panel2.add(textField1);
            }
            panel1.add(panel2);

            //---- button1 ----
            button1.setText("L\u00e0m m\u1edbi");
            button1.setPreferredSize(new Dimension(144, 55));
            button1.setIcon(new ImageIcon(getClass().getResource("/images/icons8_data_backup_30px.png")));
            panel1.add(button1);
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null},
                    {null, null, null, null},
                },
                new String[] {
                    null, null, null, null
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);

        //======= panel footer ========
        {
            panelft.setLayout(new FlowLayout());

            //===== button2 =======
            button2.setText("Chọn");
            button2.setPreferredSize(new Dimension(130, 55));
            button2.setIcon(new ImageIcon(getClass().getResource("/images/icons8_ok_30px.png")));
            panelft.add(button2);

            //===== button3 =======
            button3.setText("Thoát");
            button3.setPreferredSize(new Dimension(130, 55));
            button3.setIcon(new ImageIcon(getClass().getResource("/images/icons8_cancel_30px_1.png")));
            panelft.add(button3);
        }
        contentPane.add(panelft, BorderLayout.SOUTH);

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

        // add item for combobox
        String[] items = {"Tất cả", "Mã quyền", "Tên quyền", "Chi tiết quyền"};
        for (String item : items) {
            comboBox1.addItem(item);
        }

        // su kien khi chon item
        textField1.setBorder(BorderFactory.createTitledBorder("Tất cả"));
        comboBox1.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedItem = (String) comboBox1.getSelectedItem();
                if (selectedItem.equals("Tất cả")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Tất cả"));
                } else if (selectedItem.equals("Mã quyền")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Mã quyền"));
                } else if (selectedItem.equals("Tên quyền")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Tên quyền"));
                } else if (selectedItem.equals("Chi tiết quyền")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Chi tiết quyền"));
                }
            }
        });

        // su kien khi nhan vao nut lam moi
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comboBox1.setSelectedItem("Tất cả");
                textField1.setText("");
            }
        });

        // su kien cho nut chon
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String selectedPermissionId = getSelectedPermissionId();
                if (selectedPermissionId == null) {
                    JOptionPane.showMessageDialog(null, "Chưa chọn quyền");
                    return;
                }
                dispose();
            }
        });

        // su kien thoat
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
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
                ArrayList<Permission> result = qlq.search(value, type);

                setDataToTable(result);
            }
        });

        // xem chi tiet
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // kiem tra chuot phai co duoc nhan hay khong
                if (SwingUtilities.isRightMouseButton(e)) {
                    // lay chi so row duojc nhan
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
                            // lay quyen dc chon tu table
                            String maQuyen = (String) table1.getValueAt(row, 1);

                            // tim quyen trong danh sach
                            Permission selectedPermission = null;
                            for (Permission p : qlq.getDsq()) {
                                if (p.getMaQuyen().equals(maQuyen)) {
                                    selectedPermission = p;
                                    break;
                                }
                            }

                            // hien thi thong tin chi tiet quyen
                            if (selectedPermission != null) {
                                JOptionPane.showMessageDialog(null, "Mã quyền" + selectedPermission.getMaQuyen()
                                + "\nTên quyền: " + selectedPermission.getTenQuyen()
                                + "\nChi tiết quyền: " + selectedPermission.getChiTietQuyen());
                            } else {
                                JOptionPane.showMessageDialog(null, "Không tìm thấy quyền");
                            }
                        }
                    });
                    popup.show(table1, e.getX(), e.getY());
                }
            }
        });
    }

    //
    public void addButtonAddActionListener(ActionListener actionListener) {
        button2.addActionListener(actionListener);
    }

    // lay ma quyen
    public String getSelectedPermissionId() {
        int selectedrow = table1.getSelectedRow();
        if (selectedrow != -1) {
            return table1.getValueAt(selectedrow, 1).toString();
        }
        return null;
    }

    // refresh data
    public void refresh() {
        qlq.readDB();
        setDataToTable(qlq.getDsq());
    }

    // set data for table
    public void setDataToTable(ArrayList<Permission> data) {
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("STT");
        tableModel.addColumn("Mã quyền");
        tableModel.addColumn("Tên quyền");
        tableModel.addColumn("Chi tiết quyền");

        int stt = 1;
        for (Permission p : data) {
            tableModel.addRow(new Object[] {
                    stt++,
                    p.getMaQuyen(),
                    p.getTenQuyen(),
                    p.getChiTietQuyen()
            });
        }
        table1.setModel(tableModel);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Master
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panelft;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JScrollPane scrollPane1;
    private JTable table1;
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
            @Override
            public void run() {
                new FormChoosePermission();
            }
        });
    }
}
