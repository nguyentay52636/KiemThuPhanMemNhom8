/*
 * Created by JFormDesigner on Thu Apr 11 09:58:22 ICT 2024
 */

package Layout.models.FrontEnd.FormCustomer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Layout.models.BackEnd.BUS.CustomerBUS;
import Layout.models.BackEnd.DTO.Customer;

/**
 * @author master
 */
public class FormKhachHang extends JPanel {
    CustomerBUS qlkh = new CustomerBUS();

    public FormKhachHang() {
        initComponents();
        // setDataToTable(qlkh.getDskh());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Master
        panel1 = new JPanel();
        panel2 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        // button5 = new JButton();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();
        textField1 = new JTextField();
        button8 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
        .swing.border.EmptyBorder(0,0,0,0), "",javax.swing
        .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
        Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red
        ), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
        public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName(
        )))throw new RuntimeException();}});
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout(3, 1));

            //======== panel2 ========
            {
                panel2.setLayout(new FlowLayout());

                //---- button1 ----
                button1.setText("Th\u00eam");
                panel2.add(button1);

                //---- button2 ----
                button2.setText("X\u00f3a");
                panel2.add(button2);

                //---- button3 ----
                button3.setText("S\u1eeda");
                panel2.add(button3);

                //---- button4 ----
                button4.setText("Xu\u1ea5t Excel");
                panel2.add(button4);

                //---- button5 ----
                // button5.setText("Nh\u1eadp Excel");
                // panel2.add(button5);
            }
            panel1.add(panel2);

            //======== panel3 ========
            {
                panel3.setLayout(new FlowLayout());

                //====== panel5 ========
                {
                    panel5.setBorder(new TitledBorder("Trạng thái khách hàng"));
                    panel5.setLayout(new FlowLayout());

                    //====== comboBox2 =======
                    comboBox2.setPreferredSize(new Dimension(200, 55));
                    panel5.add(comboBox2);
                }
                panel3.add(panel5);

                //======== panel4 ========
                {
                    panel4.setBorder(new TitledBorder("T\u00ecm ki\u1ebfm"));
                    panel4.setLayout(new FlowLayout());

                    //---- comboBox1 ----
                    comboBox1.setBorder(null);
                    panel4.add(comboBox1);
                    panel4.add(textField1);
                }
                panel3.add(panel4);

                //---- button8 ----
                button8.setText("L\u00e0m m\u1edbi");
                panel3.add(button8);
            }
            panel1.add(panel3);
        }
        add(panel1, BorderLayout.NORTH);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, "", null, null},
                    {null, null, null, null, null, null},
                },
                new String[] {
                    "STT", "M\u00e3 kh\u00e1ch h\u00e0ng ", "T\u00ean kh\u00e1ch h\u00e0ng", "\u0110\u1ecba ch\u1ec9", "S\u1ed1 \u0111i\u1ec7n tho\u1ea1i", "Tr\u1ea1ng th\u00e1i "
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        // set size for button
        Dimension size = new Dimension(144, 43);
        button1.setPreferredSize(size);
        button2.setPreferredSize(size);
        button3.setPreferredSize(size);
        button4.setPreferredSize(size);
        // button5.setPreferredSize(size);
        button8.setPreferredSize(new Dimension(140, 40));

        // set size for combobox
        comboBox1.setPreferredSize(new Dimension(140, 40));
        textField1.setPreferredSize(new Dimension(144, 55));

        // set icon
        ImageIcon iconThem = new ImageIcon(getClass().getResource("/images/icons8_add_30px.png"));
        ImageIcon iconXoa = new ImageIcon(getClass().getResource("/images/icons8_delete_forever_30px_1.png"));
        ImageIcon IconSua = new ImageIcon(getClass().getResource("/images/icons8_wrench_30px.png"));
        // ImageIcon exportIcon = new
        // ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png"));
        ImageIcon importIcon = new ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png"));
        ImageIcon refreshIcon = new ImageIcon(getClass().getResource("/images/icons8_data_backup_30px.png"));

        button1.setIcon(iconThem);
        button2.setIcon(iconXoa);
        button3.setIcon(IconSua);
        // button4.setIcon(exportIcon);
        // button5.setIcon(importIcon);
        button8.setIcon(refreshIcon);

        // set background for button
        // button1.setBackground(Color.white);
        // button2.setBackground(Color.white);
        // button3.setBackground(Color.white);
        // button4.setBackground(Color.white);
        // button5.setBackground(Color.white);
        // button8.setBackground(new Color(135, 206, 250));

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

        // add item for combobox
        String[] items = { "Tất cả", "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại", "Trạng thái" };
        for (String item : items) {
            comboBox1.addItem(item);
        }

        String[] items2 = { "Tất cả", "Đang hoạt động", "Đã khóa" };
        for (String item : items2) {
            comboBox2.addItem(item);
        }

        // // lang nghe su kien khi nhan vao item
        // textField1.setBorder(BorderFactory.createTitledBorder("Tất cả"));
        // comboBox1.addItemListener(e -> {
        // if (e.getStateChange() == ItemEvent.SELECTED) {
        // String selectedItem = (String) comboBox1.getSelectedItem();
        // if (selectedItem.equals("Tất cả")) {
        // textField1.setBorder(BorderFactory.createTitledBorder("Tất cả"));
        // } else if (selectedItem.equals("Mã khách hàng")) {
        // textField1.setBorder(BorderFactory.createTitledBorder("Mã khách hàng"));
        // } else if (selectedItem.equals("Tên khách hàng")) {
        // textField1.setBorder(BorderFactory.createTitledBorder("Tên khách hàng"));
        // } else if (selectedItem.equals("Địa chỉ")) {
        // textField1.setBorder(BorderFactory.createTitledBorder("Địa chỉ"));
        // } else if (selectedItem.equals("Số điện thoại")) {
        // textField1.setBorder(BorderFactory.createTitledBorder("Số điện thoại"));
        // } else if (selectedItem.equals("Trạng thái")) {
        // textField1.setBorder(BorderFactory.createTitledBorder("Trạng thái"));
        // }
        // }
        // });

        comboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedStatus = (String) comboBox2.getSelectedItem();
                    ArrayList<Customer> result;
                    if (selectedStatus.equals("Tất cả")) {
                        result = qlkh.getDskh();
                    } else {
                        int status;
                        if (selectedStatus.equals("Đang hoạt động")) {
                            status = 0;
                        } else {
                            status = 1;
                        }
                        result = qlkh.filterByStatus(status);
                    }
                    setDataToTable(result);
                }
            }
        });

        // lang nghe su kien khi nhan vao nut lam moi
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comboBox1.setSelectedItem("Tất cả");
                textField1.setText("");
            }
        });

        // lang nghe su kien khi nhan vao nut "Thêm"
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddButtonCustomer add = new AddButtonCustomer("Thêm", "", FormKhachHang.this);
                add.setVisible(true);
            }
        });
        refresh();

        // lang nghe su kien khi nhan vao nut "Xóa"
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table1.getSelectedRow();
                if (selectedRow != -1) {
                    int comfirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không?", "Xác nhận",
                            JOptionPane.YES_NO_OPTION);
                    if (comfirm == JOptionPane.YES_OPTION) {
                        String makh = (String) table1.getValueAt(selectedRow, 1);
                        if (qlkh.delete(makh)) {
                            ((DefaultTableModel) table1.getModel()).removeRow(selectedRow);
                            JOptionPane.showMessageDialog(null, "Xóa thành công!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Xóa thất bại!");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng cần xóa!");
                }
            }
        });
        refresh();

        // lang nghe su kien khi nhan vao nut sua
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectedRow = table1.getSelectedRow();
                if (selectedRow != -1) {
                    String makh = (String) table1.getValueAt(selectedRow, 1);

                    AddButtonCustomer add = new AddButtonCustomer("Sửa", makh, FormKhachHang.this);
                    add.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng cần sửa!");
                }
            }
        });
        refresh();

        // lang nghe su kien khi nhan vao nut "Xuất Excel"
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Chọn nơi lưu file");

                int userSelection = fileChooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();

                    Workbook workbook = new XSSFWorkbook();
                    Sheet sheet = workbook.createSheet("Khách hàng");

                    // tao row header
                    Row headerRow = sheet.createRow(0);
                    headerRow.createCell(0).setCellValue("STT");
                    headerRow.createCell(1).setCellValue("Mã khách hàng");
                    headerRow.createCell(2).setCellValue("Tên khách hàng");
                    headerRow.createCell(3).setCellValue("Địa chỉ");
                    headerRow.createCell(4).setCellValue("Số điện thoại");
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

        // nhap excel
        // button5.addActionListener(new ActionListener() {
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

        // String makh = row.getCell(1).getStringCellValue();
        // String tenkh = row.getCell(2).getStringCellValue();
        // String diachi = row.getCell(3).getStringCellValue();
        // String sdt = row.getCell(4).getStringCellValue();
        // int trangthai = (int) row.getCell(5).getNumericCellValue();

        // Customer customer = new Customer(makh, tenkh, diachi, sdt, trangthai);

        // // add to the database
        // qlkh.add(customer);
        // }

        // //
        // refresh();

        // JOptionPane.showMessageDialog(null, "Nhập file thành công");
        // } catch (IOException e) {
        // JOptionPane.showMessageDialog(null, "Nhập file không thành công");
        // e.printStackTrace();
        // }
        // }
        // }
        // });

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

            private void performSearch() {
                // lấy giá trị tìm kiếm và loại tìm kiếm
                String value = textField1.getText();
                String type = (String) comboBox1.getSelectedItem();

                // gọi hàm search từ CustomerBUS
                ArrayList<Customer> result = qlkh.search(value, type);

                // hiển thị kết quả tìm kiếm lên table
                setDataToTable(result);
            }
        });
    }

    // refresh data in table
    public void refresh() {
        qlkh.readDB();
        setDataToTable(qlkh.getDskh());
    }

    // set data for the table
    public void setDataToTable(ArrayList<Customer> data) {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("STT");
        model.addColumn("Mã khách hàng");
        model.addColumn("Tên khách hàng");
        model.addColumn("Địa chỉ");
        model.addColumn("Số điện thoại");
        model.addColumn("Trạng thái");

        for (int i = 0; i < data.size(); i++) {
            Customer kh = data.get(i);
            model.addRow(new Object[] {
                    i + 1,
                    kh.getMaKH(),
                    kh.getTenKh(),
                    kh.getDiaChi(),
                    kh.getSdt(),
                    kh.getTrangThai() == 0 ? "Đang hoạt động" : "Đã khóa"
            });
        }
        table1.setModel(model);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Master
    private JPanel panel1;
    private JPanel panel2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // private JButton button5;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JButton button8;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
