/*
 * Created by JFormDesigner on Tue Apr 09 16:24:28 ICT 2024
 */

package Layout.models.FrontEnd.FormTypeProduct;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Layout.models.BackEnd.BUS.TypeProductBUS;
import Layout.models.BackEnd.DTO.TypeProduct;

/**
 * @author master
 */
public class FormTypeProduct extends JPanel {
    TypeProductBUS qllsp = new TypeProductBUS();

    public FormTypeProduct() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Master
        panel1 = new JPanel();
        panel2 = new JPanel();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        panel3 = new JPanel();
        panel5 = new JPanel();
        comboBox1 = new JComboBox();
        textField1 = new JTextField();
        button1 = new JButton();
        panel4 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setSize(1000, 800);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
                border. EmptyBorder( 0, 0, 0, 0) , "", javax. swing. border. TitledBorder. CENTER
                , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font
                .BOLD ,12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
                new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order"
                        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout(3, 1));

            //======== panel2 ========
            {
                panel2.setLayout(new FlowLayout());

                //---- button2 ----
                button2.setText("Thêm");
//                button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 5f));
                button2.setAutoscrolls(true);
                panel2.add(button2);
                ImageIcon addIcon = new ImageIcon(getClass().getResource("/images/icons8_add_30px.png"));
                button2.setIcon(addIcon);

                //---- button3 ----
                button3.setText("Xóa");
//                button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 5f));
                panel2.add(button3);
                ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/images/icons8_delete_forever_30px_1.png"));
                button3.setIcon(deleteIcon);

                //---- button4 ----
                button4.setText("Sửa");
//                button4.setFont(button4.getFont().deriveFont(button4.getFont().getSize() + 5f));
                panel2.add(button4);
                ImageIcon editIcon = new ImageIcon(getClass().getResource("/images/icons8_wrench_30px.png"));
                button4.setIcon(editIcon);

                //---- button5 ----
                button5.setText("Xuất Excel");
//                button5.setFont(button5.getFont().deriveFont(button5.getFont().getSize() + 5f));
                panel2.add(button5);
                ImageIcon exportIcon = new ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png"));
                button5.setIcon(exportIcon);

                //---- button6 ----
                button6.setText("Nhập Excel");
//                button6.setFont(button6.getFont().deriveFont(button6.getFont().getSize() + 5f));
                panel2.add(button6);
                ImageIcon importIcon = new ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png"));
                button6.setIcon(importIcon);
            }
            panel1.add(panel2);

            //======== panel3 ========
            {
                panel3.setLayout(new FlowLayout());

                //======== panel5 ========
                {
                    panel5.setBorder(new TitledBorder("Tìm kiếm"));
                    panel5.setFont(panel5.getFont().deriveFont(panel5.getFont().getSize() + 30f));
                    panel5.setLayout(new FlowLayout());

                    //---- comboBox1 ----
                    comboBox1.setFont(comboBox1.getFont().deriveFont(comboBox1.getFont().getSize() + 4f));
                    comboBox1.setPreferredSize(new Dimension(130, 40));
                    panel5.add(comboBox1);

                    //---- textField1 ----
//                    textField1.setFont(textField1.getFont().deriveFont(textField1.getFont().getSize() + 4f));
                    textField1.setPreferredSize(new Dimension(144, 55));
                    panel5.add(textField1);
                }
                panel3.add(panel5);

                //---- button1 ----
                button1.setText("Làm mới ");
//                button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
                panel3.add(button1);
                ImageIcon refreshIcon = new ImageIcon(getClass().getResource("/images/icons8_data_backup_30px.png"));
                button1.setIcon(refreshIcon);
            }
            panel1.add(panel3);
        }
        add(panel1, BorderLayout.NORTH);

        //======== panel4 ========
        {
            panel4.setLayout(new BorderLayout());

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                        new Object[][] {
                                {"", "", null, null},
                                {null, null, null, null},
                        },
                        new String[] {
                                "STT ", "Mã loại ", "Tên loại ", "Mô tả "
                        }
                ));
                table1.setFont(table1.getFont().deriveFont(table1.getFont().getStyle() & ~Font.BOLD, table1.getFont().getSize() - 2f));
//                table1.setPreferredSize(new Dimension(800, ));
                scrollPane1.setViewportView(table1);
            }
            panel4.add(scrollPane1, BorderLayout.CENTER);
        }
        add(panel4, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        // combobox
        String[] items = { "Tất cả", "Mã loại", "Tên loại", "Mô tả" };
        for (String item : items) {
            comboBox1.addItem(item);
        }

        // lắng nghe sự kiện khi nhần vào trong item
        // textField1.setBorder(BorderFactory.createTitledBorder("Tất cả"));
        // comboBox1.addItemListener(e -> {
        // if (e.getStateChange() == ItemEvent.SELECTED) {
        // String selectedItem = (String) comboBox1.getSelectedItem();
        // if (selectedItem.equals("Tất cả")) {
        // textField1.setBorder(BorderFactory.createTitledBorder("Tất cả"));
        // } else if (selectedItem.equals("Mã loại")) {
        // textField1.setBorder(BorderFactory.createTitledBorder("Mã loại"));
        // } else if (selectedItem.equals("Tên loại")) {
        // textField1.setBorder(BorderFactory.createTitledBorder("Tên loại"));
        // } else if (selectedItem.equals("Mô tả")) {
        // textField1.setBorder(BorderFactory.createTitledBorder("Mô tả"));
        // }
        // }
        // });

        // set color for button
        // button2.setBackground(Color.white);
        // button3.setBackground(Color.white);
        // button4.setBackground(Color.white);
        // button5.setBackground(Color.white);
        // button6.setBackground(Color.white);
        // button1.setBackground(new Color(135, 206, 250));

        // set size for button
        Dimension sizeButton = new Dimension(144, 35);
        button2.setPreferredSize(sizeButton);
        button3.setPreferredSize(sizeButton);
        button4.setPreferredSize(sizeButton);
        button5.setPreferredSize(sizeButton);
        button6.setPreferredSize(sizeButton);
        button1.setPreferredSize(new Dimension(140, 40));

        // font
        Font font = new Font("Segoe UI", 0, 16);
        Font fontHeader = new Font("Segoe UI", Font.BOLD, 16);

        // set font for the table
        table1.setFont(font);
        table1.getTableHeader().setFont(fontHeader);

        // set size for the table
        table1.setRowHeight(30);
        TableColumnModel columnModel = table1.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(100);
        }

        // lang nghe su kien khi nhan vao "Làm mới"
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comboBox1.setSelectedItem("Tất cả");
                textField1.setText("");
            }
        });

        // lang nghe su kien khi nhan vao nut "Thêm"
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddButton addButton = new AddButton("Thêm", "", FormTypeProduct.this);
                addButton.setVisible(true);
            }
        });
        refresh();

        // lang nghe su kien khi nhan vao nut "Xóa"
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table1.getSelectedRow();
                if (selectedRow != -1) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa loại sản phẩm này chứ?",
                            "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        String maLoai = (String) table1.getValueAt(selectedRow, 1); // Assuming the MaLoai is in the
                                                                                    // second column
                        if (qllsp.delete(maLoai)) { // Assuming you have a delete method in your TypeProductBUS class
                            ((DefaultTableModel) table1.getModel()).removeRow(selectedRow);
                            JOptionPane.showMessageDialog(null, "Xóa thành công!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Xóa không thành công!");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Chưa chọn loại sản phẩm để xóa!");
                }
            }
        });
        refresh();

        // lang nghe su kien khi nhan vao nut "Sửa"
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table1.getSelectedRow();
                if (selectedRow != -1) {
                    String maLoai = (String) table1.getValueAt(selectedRow, 1); // Assuming the MaLoai is in the second
                                                                                // column
                    // Open the AddButton window with the title "Sửa" and the selected MaLoai
                    AddButton addButton = new AddButton("Sửa", maLoai, FormTypeProduct.this);
                    addButton.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Chưa chọn loại sản phẩm để sửa!");
                }
            }
        });
        refresh();

        // lang nghe su kien khi nhan vao nut "Xuất Excel"
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Chọn nơi lưu file");

                int userSelection = fileChooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();

                    Workbook workbook = new XSSFWorkbook();
                    Sheet sheet = workbook.createSheet("Loại sản phẩm");

                    // tao row header
                    Row headerRow = sheet.createRow(0);
                    headerRow.createCell(0).setCellValue("STT");
                    headerRow.createCell(1).setCellValue("Mã loại");
                    headerRow.createCell(2).setCellValue("Tên loại");
                    headerRow.createCell(3).setCellValue("Mô tả");

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
        button6.addActionListener(new ActionListener() {
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

                            String maLoai = row.getCell(1).getStringCellValue();
                            String tenLoai = row.getCell(2).getStringCellValue();
                            String moTa = row.getCell(3).getStringCellValue();

                            TypeProduct typeProduct = new TypeProduct(maLoai, tenLoai, moTa);

                            // add to the database
                            qllsp.add(typeProduct);
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

        // search
        textField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
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

                // gọi hàm search từ TypeProductBUS
                ArrayList<TypeProduct> result = qllsp.search(value, type);

                // hiển thi kết quả tìm kiếm lên table
                setDataToTable(result);
            }
        });
    }

    // refresh data in table
    public void refresh() {
        qllsp.readDB();
        setDataToTable(qllsp.getDslsp());
    }

    // set data to table
    public void setDataToTable(ArrayList<TypeProduct> data) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("STT");
        model.addColumn("Mã loại");
        model.addColumn("Tên loại");
        model.addColumn("Mô tả");

        for (int i = 0; i < data.size(); i++) {
            TypeProduct typeProduct = data.get(i);
            model.addRow(new Object[] {
                    i + 1,
                    typeProduct.getMaLoaiSanPham(),
                    typeProduct.getTenLoaiSanPham(),
                    typeProduct.getMoTa()
            });
        }
        table1.setModel(model);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Master
    private JPanel panel1;
    private JPanel panel2;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JPanel panel3;
    private JPanel panel5;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton button1;
    private JPanel panel4;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormTypeProductDisableButton form = new FormTypeProductDisableButton();
            JFrame frame = new JFrame("LOẠI SẢN PHÂM");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(form);
            frame.pack();
            frame.setLocationRelativeTo(null); // Đưa cửa sổ vào trung tâm màn hình
            frame.setVisible(true);
        });
    }
}

// class Main {
// public static void main(String[] args) {
// SwingUtilities.invokeLater(() -> {
// FormTypeProduct form = new FormTypeProduct();
// JFrame frame = new JFrame("LOẠI SẢN PHÂM");
// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// frame.getContentPane().add(form);
// frame.pack();
// frame.setLocationRelativeTo(null); // Đưa cửa sổ vào trung tâm màn hình
// frame.setVisible(true);
// });
// }
// }
