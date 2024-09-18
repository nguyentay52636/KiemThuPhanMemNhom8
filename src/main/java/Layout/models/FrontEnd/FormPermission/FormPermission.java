/*
 * Created by JFormDesigner on Tue Apr 30 12:01:01 ICT 2024
 */

package Layout.models.FrontEnd.FormPermission;

import Layout.models.BackEnd.BUS.PermissionBUS;
import Layout.models.BackEnd.DTO.Permission;
import Layout.models.FrontEnd.FormAccount.FormAccount;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;

/**
 * @author master
 */
public class FormPermission extends JPanel {
    PermissionBUS qlq = new PermissionBUS();

    public FormPermission() {
        initComponents();
        setDataToTable(qlq.getDsq());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        panel2 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        panel3 = new JPanel();
        panel5 = new JPanel();
        comboBox1 = new JComboBox();
        textField1 = new JTextField();
        button6 = new JButton();
        panel4 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout(3, 1));

            //======== panel2 ========
            {
                panel2.setLayout(new FlowLayout());

                //---- button1 ----
                button1.setText("Th\u00eam");
                button1.setPreferredSize(new Dimension(144, 43));
                button1.setIcon(new ImageIcon(getClass().getResource("/images/icons8_add_30px.png")));
                panel2.add(button1);

                //---- button2 ----
                button2.setText("X\u00f3a");
                button2.setPreferredSize(new Dimension(144, 43));
                button2.setIcon(new ImageIcon(getClass().getResource("/images/icons8_delete_forever_30px_1.png")));
                panel2.add(button2);

                //---- button3 ----
                button3.setText("S\u1eeda");
                button3.setPreferredSize(new Dimension(144, 43));
                button3.setIcon(new ImageIcon(getClass().getResource("/images/icons8_wrench_30px.png")));
                panel2.add(button3);

                //---- button4 ----
                button4.setText("Xu\u1ea5t Excel");
                button4.setPreferredSize(new Dimension(144, 43));
                button4.setIcon(new ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png")));
                panel2.add(button4);

                //---- button5 ----
                button5.setText("Nh\u1eadp Excel");
                button5.setPreferredSize(new Dimension(144, 43));
                button5.setIcon(new ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png")));
                panel2.add(button5);
            }
            panel1.add(panel2);

            //======== panel3 ========
            {
                panel3.setLayout(new FlowLayout());

                //======== panel5 ========
                {
                    panel5.setBorder(new TitledBorder("T\u00ecm ki\u1ebfm"));
                    panel5.setLayout(new FlowLayout());

                    //---- comboBox1 ----
                    comboBox1.setPreferredSize(new Dimension(130, 40));
                    panel5.add(comboBox1);

                    //---- textField1 ----
                    textField1.setPreferredSize(new Dimension(144, 55));
                    panel5.add(textField1);
                }
                panel3.add(panel5);

                //---- button6 ----
                button6.setText("L\u00e0m m\u1edbi");
                button6.setPreferredSize(new Dimension(144, 45));
                button6.setIcon(new ImageIcon(getClass().getResource("/images/icons8_data_backup_30px.png")));
                panel3.add(button6);
            }
            panel1.add(panel3);

            //======== panel4 ========
            {
                panel4.setLayout(new FlowLayout());
            }
            panel1.add(panel4);
        }
        add(panel1, BorderLayout.NORTH);

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
        add(scrollPane1, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        // set font
        Font font = new Font("Segoe", 0, 16);
        Font fontHeader = new Font("Segoe", Font.BOLD, 16);

        // font for table1
        table1.setFont(font);
        table1.getTableHeader().setFont(fontHeader);

        // set size for table1
        table1.setRowHeight(30);
        TableColumnModel columnModel = table1.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(150);
        }

        // add item for comboBox
        String[] items = {"Tất cả", "Mã quyền", "Tên quyền", "Chi tiết quyền"};
        for (String item : items) {
            comboBox1.addItem(item);
        }

        textField1.setBorder(BorderFactory.createTitledBorder("Tất cả" ));
        comboBox1.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedItem = (String) comboBox1.getSelectedItem();
                if (selectedItem.equals("Tất cả")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Tất cả" ));
                } else if (selectedItem.equals("Mã quyền")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Nhập mã quyền" ));
                } else if (selectedItem.equals("Tên quyền")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Nhập tên quyền" ));
                } else if (selectedItem.equals("Chi tiết quyền")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Nhập chi tiết quyền" ));
                }
            }
        });

        // xem chi tiet
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // kiem tra chuot phai co duoc nhan hay khong
                if (SwingUtilities.isRightMouseButton(e)) {
                    // lay chi so row duoc nhan
                    int row = table1.rowAtPoint(e.getPoint());
                    table1.setRowSelectionInterval(row, row);

                    // tao popup menu
                    JPopupMenu popup = new JPopupMenu();
                    JMenuItem detail = new JMenuItem("Xem chi tiết");
                    popup.add(detail);

                    // su kien khi nhan vao xem chi tiet
                    detail.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            // lay quyen duoc chon tu table
                            String maQuyen = (String) table1.getValueAt(row, 1);

                            // tim quyen trong danh sachs
                            Permission selectedPermission = null;
                            for (Permission p : qlq.getDsq()) {
                                if (p.getMaQuyen().equals(maQuyen)) {
                                    selectedPermission = p;
                                    break;
                                }
                            }

                            // hien thi thong tin chi tiet quyen
                            if (selectedPermission != null) {
                                JOptionPane.showMessageDialog(null, "Mã quyền: " + selectedPermission.getMaQuyen()
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

        // su kien khi nhan vao nut them
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ThemSuaQuyen form = new ThemSuaQuyen("Thêm", "", FormPermission.this);
                form.setVisible(true);
            }
        });
        refresh();


        // su kien khi nhan vao nut xoa
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectedRow = table1.getSelectedRow();
                if (selectedRow != -1) {
                    String maQuyen = table1.getValueAt(selectedRow, 1).toString();

                    boolean result = qlq.delete(maQuyen);

                    if (result) {
                        JOptionPane.showMessageDialog(null, "Xóa thành công");
                        refresh();
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa thất bại");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Chọn quyền cần xóa");
                }
            }
        });

        // su kien khi nhan vao nut sua
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectedRow = table1.getSelectedRow();
                if (selectedRow != -1) {
                    String maquyen = (String) table1.getValueAt(selectedRow, 1);

                    ThemSuaQuyen add = new ThemSuaQuyen("Sửa", maquyen, FormPermission.this);
                    add.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Chọn quyền cần sửa");
                }
            }
        });
        refresh();

        // su kien khi nhan vao nut xuat excel
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Chọn nơi lưu file");

                int userSelection = fileChooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();

                    Workbook workbook = new XSSFWorkbook();
                    Sheet sheet = workbook.createSheet("Quyền");

                    // tao row header
                    Row headerRow = sheet.createRow(0);
                    headerRow.createCell(0).setCellValue("STT");
                    headerRow.createCell(1).setCellValue("Mã quyền");
                    headerRow.createCell(2).setCellValue("Tên quyền");
                    headerRow.createCell(3).setCellValue("Chi tiết quyền");

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

        // su kien khi nhan vao nut nhap excel
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

                            String maQuyen = row.getCell(1).getStringCellValue();
                            String tenQuyen = row.getCell(2).getStringCellValue();
                            String chiTietQuyen = row.getCell(3).getStringCellValue();

                            Permission permission = new Permission(maQuyen, tenQuyen, chiTietQuyen);

                            // add to the database
                            qlq.add(permission);
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

        // su kien khi nhan nut lam moi
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comboBox1.setSelectedItem("Tất cả");
                textField1.setText("");
                setDataToTable(qlq.getDsq());
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
    }

    // thong bao khi mot quyen moi duoc them vao
    public interface PermissionAddedListener {
        void onPermissionAdded(Permission newPermission);
    }

    // refresh data in table
    public void refresh() {
        qlq.readDB();
        setDataToTable(qlq.getDsq());
    }

    // set data to the table
    public void setDataToTable(ArrayList<Permission> permissions) {
        String[] columns = {"STT", "Mã quyền", "Tên quyền", "Chi tiết quyền"};
        Object[][] data = new Object[permissions.size()][columns.length];

        for (int i = 0; i < permissions.size(); i++) {
            Permission p = permissions.get(i);
            data[i][0] = i + 1;
            data[i][1] = p.getMaQuyen();
            data[i][2] = p.getTenQuyen();
            data[i][3] = p.getChiTietQuyen();
        }
        TableModel model = new DefaultTableModel(data, columns);
        table1.setModel(model);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JPanel panel2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JPanel panel3;
    private JPanel panel5;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton button6;
    private JPanel panel4;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

