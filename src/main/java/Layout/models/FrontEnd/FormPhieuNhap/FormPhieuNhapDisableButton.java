/*
 * Created by JFormDesigner on Sun Apr 14 16:08:58 ICT 2024
 */

package Layout.models.FrontEnd.FormPhieuNhap;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Layout.models.BackEnd.BUS.ImportBUS;
import Layout.models.BackEnd.BUS.StaffBUS;
import Layout.models.BackEnd.DTO.Import;
import Layout.models.FrontEnd.FormImportDetails.FormImportDetails;
import Layout.models.FrontEnd.Formatter.PriceFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static java.awt.SystemColor.text;

/**
 * @author master
 */
public class FormPhieuNhapDisableButton extends JPanel {
    ImportBUS importBUS = new ImportBUS();
    StaffBUS staffBUS = new StaffBUS();

    public FormPhieuNhapDisableButton() {

        initComponents();
        refresh();
        disableButton();

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Master
        panel1 = new JPanel();
        panel2 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        panel3 = new JPanel();
        panel4 = new JPanel();
        comboBox1 = new JComboBox();
        textField1 = new JTextField();
        panel5 = new JPanel();
        textField2 = new JTextField();
        button4 = new JButton();
        textField3 = new JTextField();
        button5 = new JButton();
        panel6 = new JPanel();
        textField4 = new JTextField();
        textField5 = new JTextField();
        button6 = new JButton();
        button7 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel7 = new JPanel();
        panel8 = new JPanel();
        textField6 = new JTextField();
        textField7 = new JTextField();
        textField8 = new JTextField();
        textField9 = new JTextField();
        panel9 = new JPanel();
        textField10 = new JTextField();
        textField11 = new JTextField();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
                . EmptyBorder( 0, 0, 0, 0) , "", javax. swing. border. TitledBorder. CENTER, javax
                . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
                12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans
                . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .
                getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout(2, 1));

            //======== panel2 ========
            {
                panel2.setLayout(new FlowLayout());

                //---- button1 ----
                button1.setText("Xu\u1ea5t Excel");
                button1.setPreferredSize(new Dimension(144, 43));
                panel2.add(button1);

                //---- button2 ----
                button2.setText("Nh\u1eadp Excel");
                button2.setPreferredSize(new Dimension(144, 43));
                panel2.add(button2);

                //---- button3 ----
//                button3.setText("In PDF");
//                button3.setPreferredSize(new Dimension(140, 43));
//                panel2.add(button3);
            }
            panel1.add(panel2);

            //======== panel3 ========
            {
                panel3.setBorder(null);
                panel3.setLayout(new FlowLayout());

                //======== panel4 ========
                {
                    panel4.setBorder(new TitledBorder("T\u00ecm ki\u1ebfm"));
                    panel4.setLayout(new FlowLayout());
                    panel4.add(comboBox1);
                    panel4.add(textField1);
                }
                panel3.add(panel4);

                //======== panel5 ========
                {
                    panel5.setBorder(new TitledBorder("Ng\u00e0y l\u1eadp"));
                    panel5.setLayout(new FlowLayout());

                    //---- textField2 ----
                    textField2.setBorder(new TitledBorder("T\u1eeb"));
                    panel5.add(textField2);

                    //---- button4 ----
                    button4.setText("");
                    panel5.add(button4);

                    //---- textField3 ----
                    textField3.setBorder(new TitledBorder("\u0110\u1ebfn"));
                    panel5.add(textField3);

                    //---- button5 ----
                    button5.setText("");
                    panel5.add(button5);
                }
                panel3.add(panel5);

                //======== panel6 ========
                {
                    panel6.setBorder(new TitledBorder("T\u1ed5ng ti\u1ec1n"));
                    panel6.setLayout(new FlowLayout());

                    //---- textField4 ----
                    textField4.setBorder(new TitledBorder("T\u1eeb"));
                    panel6.add(textField4);

                    //---- textField5 ----
                    textField5.setBorder(new TitledBorder("\u0110\u1ebfn"));
                    panel6.add(textField5);
                }
                panel3.add(panel6);

                //---- button6 ----
                button6.setText("Xem chi ti\u1ebft");
                panel3.add(button6);

                //---- button7 ----
                button7.setText("L\u00e0m m\u1edbi");
                panel3.add(button7);
            }
            panel1.add(panel3);
        }
        add(panel1, BorderLayout.NORTH);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                    new Object[][] {
                            {1,"Tay", null, null, null, null, null},
                    },
                    getHeaders()
            ));
            Font font = new Font("Segoe UI", 0, 16);
            Font fontHeader = new Font("Segoe UI", Font.BOLD, 16);
            table1.setFont(font);
            table1.getTableHeader().setFont(fontHeader);
            table1.setRowHeight(30);
            TableColumnModel columnModel = table1.getColumnModel();
            for (int i = 0; i < columnModel.getColumnCount(); i++) {
                columnModel.getColumn(i).setPreferredWidth(150);
            }
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1, BorderLayout.CENTER);

        //======== panel7 ========
        {
            panel7.setLayout(new GridLayout(2, 1));

            //======== panel8 ========
            {
                panel8.setLayout(new FlowLayout());

                //---- textField6 ----
                textField6.setBorder(new TitledBorder("M\u00e3 phi\u1ebfu nh\u1eadp"));
                panel8.add(textField6);

                //---- textField7 ----
                textField7.setBorder(new TitledBorder("Nh\u00e0 cung c\u1ea5p"));
                panel8.add(textField7);

                //---- textField8 ----
                textField8.setBorder(new TitledBorder("Nh\u00e2n vi\u00ean"));
                panel8.add(textField8);

                //---- textField9 ----
                textField9.setBorder(new TitledBorder("Ng\u00e0y l\u1eadp"));
                panel8.add(textField9);
            }
            panel7.add(panel8);

            //======== panel9 ========
            {
                panel9.setLayout(new FlowLayout());

                //---- textField10 ----
                textField10.setBorder(new TitledBorder("Gi\u1edd l\u1eadp"));
                panel9.add(textField10);

                //---- textField11 ----
                textField11.setBorder(new TitledBorder("T\u1ed5ng ti\u1ec1n (Tri\u1ec7u VN\u0110)"));
                panel9.add(textField11);
            }
            panel7.add(panel9);
        }
        add(panel7, BorderLayout.SOUTH);
        // JFormDesigner - End of compnvonent initialization  //GEN-END:initComponents  @formatter:on

        // add item in comboBox
        String[] items = { "Tất cả", "Mã phiếu nhập", "Mã nhà cung cấp", "Mã nhân viên", "Ngày lập", "Giờ lập","Tổng tiền" };
        for (String item : items) {
            comboBox1.addItem(item);
        }

        // set size for button
        Dimension sizeButton = new Dimension(150, 40);
        button1.setPreferredSize(sizeButton);
        button2.setPreferredSize(sizeButton);
        button3.setPreferredSize(new Dimension(100, 35));
        button4.setPreferredSize(new Dimension(50, 40));
        button5.setPreferredSize(new Dimension(50, 40));
        button6.setPreferredSize(new Dimension(160, 40));
        button7.setPreferredSize(new Dimension(140, 40));

        // set size for combobox
        comboBox1.setPreferredSize(new Dimension(130, 40));

        // set size for textfield
        Dimension sizeTextField = new Dimension(200, 55);
        textField1.setPreferredSize(new Dimension(144, 55));
        textField2.setPreferredSize(new Dimension(80, 55));
        textField3.setPreferredSize(new Dimension(80, 55));
        textField4.setPreferredSize(new Dimension(80, 55));
        textField5.setPreferredSize(new Dimension(80, 55));

        textField6.setPreferredSize(sizeTextField);
        textField7.setPreferredSize(sizeTextField);
        textField8.setPreferredSize(sizeTextField);
        textField9.setPreferredSize(sizeTextField);
        textField10.setPreferredSize(sizeTextField);
        textField11.setPreferredSize(sizeTextField);

        // set icon
        ImageIcon iconXuatExcel = new ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png"));
        ImageIcon iconNhapExcel = new ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png"));
        ImageIcon iconLich = new ImageIcon(getClass().getResource("/images/icons8_calendar_31_30px.png"));
        ImageIcon iconXem = new ImageIcon(getClass().getResource("/images/icons8_show_property_30px.png"));
        ImageIcon iconLamMoi = new ImageIcon(getClass().getResource("/images/icons8_data_backup_30px.png"));

        button1.setIcon(iconXuatExcel);
        button2.setIcon(iconNhapExcel);
        button4.setIcon(iconLich);
        button5.setIcon(iconLich);
        button6.setIcon(iconXem);
        button7.setIcon(iconLamMoi);

        // lắng nghe sự kiện khi click vào item
        textField1.setBorder(BorderFactory.createTitledBorder("Tất cả"));
        comboBox1.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedItem = (String) comboBox1.getSelectedItem();
                if (selectedItem.equals("Tất cả")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Tất cả"));
                } else if (selectedItem.equals("Mã phiếu nhập")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Mã phiếu nhập"));
                } else if (selectedItem.equals("Mã nhà cung cấp")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Mã Nhà cung cấp"));
                } else if (selectedItem.equals("Mã nhân viên")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Mã Nhân viên"));
                } else if (selectedItem.equals("Ngày lập")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Ngày lập"));
                } else if (selectedItem.equals("Giờ lập")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Giờ lập"));
                } else if (selectedItem.equals("Tổng tiền")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Tổng tiền"));
                }
            }
        });

        // sự kiện khi nhấn vào xuất Excel
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    XSSFWorkbook workbook = new XSSFWorkbook();
                    XSSFSheet sheet = workbook.createSheet("Phiếu nhập");

                    // tao row header
                    Row headerRow = sheet.createRow(0);
                    for (int i = 0; i < table1.getColumnCount(); i++) {
                        Cell cell = headerRow.createCell(i);
                        cell.setCellValue(table1.getColumnName(i));
                    }

                    // them data vao row
                    for (int i = 0; i < table1.getRowCount(); i++) {
                        Row row = sheet.createRow(i + 1);
                        for (int j = 0; j < table1.getColumnCount(); j++) {
                            Cell cell = row.createCell(j);
                            cell.setCellValue(table1.getValueAt(i, j).toString());
                        }
                    }

                    // ghi vao file excel co ten la PhieuNhap.xlsx
                    try (FileOutputStream fileOut = new FileOutputStream("PhieuNhap.xlsx")) {
                        workbook.write(fileOut);
                    }

                    // dong workbook
                    workbook.close();
                    JOptionPane.showMessageDialog(null, "Xuất Excel thành công");
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Xuất Excel không thành công");
                }
            }
        });
        ListSelectionModel selectionModel = table1.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Lấy chỉ số hàng được chọn
                    int selectedRow = table1.getSelectedRow();
                    if (selectedRow != -1) {
                        String maPN = (String) table1.getValueAt(selectedRow, 1);
                        displayInfo(maPN);
                    }
                }
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table1.getSelectedRow();
                if (selectedRow != -1) {
                    String maPN = table1.getValueAt(selectedRow, 1).toString();
                    JFrame frame = new JFrame();
                    frame.setTitle("Quản lý phiếu nhập");
                    FormImportDetails importDetailForm = new FormImportDetails(maPN);
                    frame.add(importDetailForm);
                    frame.setSize(800, 600);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn phiếu nhập cần xem chi tiết");

                }
            }
        });
        textField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                perfomSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                perfomSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                perfomSearch();
            }

            public void perfomSearch() {
                String keyWord = textField1.getText();
                System.out.println(keyWord);
                String type = (String) comboBox1.getSelectedItem();
                System.out.println(type);

                ArrayList<Import> result = importBUS.search(keyWord, type);
                System.out.println(result);
                setDataImport(result);
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comboBox1.setSelectedItem("Tất cả");
                textField1.setText("");

            }

        });
    }

    public String[] getHeaders() {
        return new String[] { "Mã phiếu nhập ", "Mã nhà cung cấp", "Mã nhân viên", "Ngày nhập", "Giờ nhập",
                "Tổng tiền" };
    }

    // set data to the table

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Master
    private JPanel panel1;
    private JPanel panel2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel panel3;
    private JPanel panel4;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JPanel panel5;
    private JTextField textField2;
    private JButton button4;
    private JTextField textField3;
    private JButton button5;
    private JPanel panel6;
    private JTextField textField4;
    private JTextField textField5;
    private JButton button6;
    private JButton button7;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel7;
    private JPanel panel8;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JPanel panel9;
    private JTextField textField10;
    private JTextField textField11;

    private void setDataImport(ArrayList<Import> data) {
        DefaultTableModel model = new DefaultTableModel();
        int stt = 1  ;
        model.addColumn("STT");
        model.addColumn("Mã phiếu nhập");
        model.addColumn("Mã nhà cung cấp");
        model.addColumn("Mã nhân viên");
        model.addColumn("Ngày lập");
        model.addColumn("Giờ lập");
        model.addColumn("Tổng tiền");
        for(Import i : data) {
            model.addRow(new Object[]{
                    stt++,
                    i.getMaPN(),
                    i.getMaNCC(),
                    i.getMaNV(),
                    String.valueOf(i.getNgayNhap()),
                    String.valueOf(i.getGioNhap()),
                    PriceFormatter.format(i.getTongTien())
            });
        }
        table1.setModel(model);


    }
    public void refresh() {
        importBUS.readDB() ;
        setDataImport(importBUS.getDspn());

    }

    public void disableButton() {
        button2.setEnabled(false);
    }

    private void displayInfo(String maPN) {
        if(maPN != null) {
            for(Import i : importBUS.getDspn()) {
                if(i.getMaPN().equals(maPN)) {
                    String tenNhanVien = staffBUS.getStaff(i.getMaNV()).getTenNV() ;
                    String tenNhaCungCap = "Nha cung cap" ;
                    textField6.setText(i.getMaPN()) ;
                    textField7.setText(tenNhaCungCap + "-" +i.getMaNCC());
                    textField8.setText(tenNhanVien + "-" + i.getMaNV());
                    textField9.setText(i.getNgayNhap().toString());
                    textField10.setText(i.getGioNhap().toString());
                    textField11.setText( PriceFormatter.format(i.getTongTien()));



                }

            }
        }
    }

}

