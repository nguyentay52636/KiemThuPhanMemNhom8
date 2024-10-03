/*
 * Created by JFormDesigner on Wed Apr 17 09:06:42 ICT 2024
 */

package Layout.models.FrontEnd.FormPromotion;

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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
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

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Layout.models.BackEnd.BUS.PromotionBUS;
import Layout.models.BackEnd.DTO.Promotion;
import Layout.models.FrontEnd.Formatter.PriceFormatter;

/**
 * @author master
 */
public class FormKhuyenMai extends JPanel {
    PromotionBUS qlkm = new PromotionBUS();

    public FormKhuyenMai() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Master
        panel1 = new JPanel();
        panel2 = new JPanel();
        panelrong = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        panel3 = new JPanel();
        panel4 = new JPanel();
        paneltr = new JPanel();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();
        textField1 = new JTextField();
        button7 = new JButton();
        panel5 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(
        new javax.swing.border.EmptyBorder(0,0,0,0), ""
        ,javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
        ,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12)
        ,java.awt.Color.red), getBorder())); addPropertyChangeListener(
        new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
        ){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException()
        ;}});
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
                panel2.add(button1);

                //---- button2 ----
                button2.setText("X\u00f3a");
                button2.setPreferredSize(new Dimension(144, 43));
                panel2.add(button2);

                //---- button3 ----
                button3.setText("S\u1eeda");
                button3.setPreferredSize(new Dimension(144, 43));
                panel2.add(button3);

                //---- button4 ----
                button4.setText("K\u1ebft th\u00fac");
                button4.setPreferredSize(new Dimension(144, 43));
                panel2.add(button4);

                //---- button5 ----
                button5.setText("Xu\u1ea5t Excel");
                button5.setPreferredSize(new Dimension(144, 43));
                panel2.add(button5);

                //---- button6 ----
                button6.setText("Nh\u1eadp Excel");
                button6.setPreferredSize(new Dimension(144, 43));
                panel2.add(button6);
            }
            panel1.add(panel2);

            //======== panel3 ========
            {
                panel3.setLayout(new FlowLayout());

                //======== paneltr ========
                {
                    comboBox2.setPreferredSize(new Dimension(130, 40));
                    paneltr.add(comboBox2);
                }
                paneltr.setLayout(new FlowLayout());
                paneltr.setBorder(BorderFactory.createTitledBorder("Trạng thái khuyến mãi"));
                paneltr.setPreferredSize(new Dimension(200, 90));
                panel3.add(paneltr);

                //======== panel4 ========
                {
                    panel4.setBorder(new TitledBorder("T\u00ecm ki\u1ebfm"));
                    panel4.setLayout(new FlowLayout());

                    //---- comboBox1 ----
                    comboBox1.setPreferredSize(new Dimension(130, 40));
                    panel4.add(comboBox1);

                    //---- textField1 ----
                    textField1.setPreferredSize(new Dimension(144, 55));
                    panel4.add(textField1);
                }
                panel3.add(panel4);

                //---- button7 ----
                button7.setText("L\u00e0m m\u1edbi");
                button7.setPreferredSize(new Dimension(140, 45));
                panel3.add(button7);
            }
            panel1.add(panel3);
        }
        add(panel1, BorderLayout.NORTH);

        //======== panel5 ========
        {
            panel5.setLayout(new BorderLayout());

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
                {
                    TableColumnModel cm = table1.getColumnModel();
                    cm.getColumn(0).setPreferredWidth(45);
                    cm.getColumn(1).setPreferredWidth(45);
                    cm.getColumn(2).setPreferredWidth(200);
                    cm.getColumn(3).setPreferredWidth(100);
                    cm.getColumn(4).setPreferredWidth(70);
                    cm.getColumn(5).setPreferredWidth(90);
                    cm.getColumn(6).setPreferredWidth(90);
                    cm.getColumn(7).setPreferredWidth(100);
                }
                scrollPane1.setViewportView(table1);
            }
            panel5.add(scrollPane1, BorderLayout.CENTER);
        }
        add(panel5, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        // add icon
        ImageIcon iconThem = new ImageIcon(getClass().getResource("/images/icons8_add_30px.png"));
        ImageIcon iconXoa = new ImageIcon(getClass().getResource("/images/icons8_delete_forever_30px_1.png"));
        ImageIcon IconSua = new ImageIcon(getClass().getResource("/images/icons8_wrench_30px.png"));
        ImageIcon iconKetThuc = new ImageIcon(getClass().getResource("/images/icons8_cancel_30px_1.png"));
        ImageIcon exportIcon = new ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png"));
        ImageIcon importIcon = new ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png"));
        ImageIcon refreshIcon = new ImageIcon(getClass().getResource("/images/icons8_data_backup_30px.png"));

        button1.setIcon(iconThem);
        button2.setIcon(iconXoa);
        button3.setIcon(IconSua);
        button4.setIcon(iconKetThuc);
        button5.setIcon(exportIcon);
        button6.setIcon(importIcon);
        button7.setIcon(refreshIcon);

        // set font
        Font font = new Font("Segoe UI", 0, 16);
        Font fontHeader = new Font("Segoe UI", Font.BOLD, 16);

        // font in the table
        table1.setFont(font);
        table1.getTableHeader().setFont(fontHeader);

        // set size for the table
        table1.setRowHeight(30);
        TableColumnModel columnModel = table1.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(150);
        }

        // add item for comboBox
        String[] items = { "Tất cả", "Mã khuyến mãi", "Tên khuyến mãi", "Điều kiện", "Giảm giá", "Ngày bắt đầu",
                "Ngày kết thúc" };
        for (String item : items) {
            comboBox1.addItem(item);
        }
        String[] itemss = { "Tất cả", "Đang diễn ra", "Chưa bắt đầu", "Đã kết thúc" };
        for (String item : itemss) {
            comboBox2.addItem(item);
        }

        // su kienj khi nhan chon item
        // textField1.setBorder(BorderFactory.createTitledBorder("Tất cả"));
        // comboBox1.addItemListener(e -> {
        // if (e.getStateChange() == ItemEvent.SELECTED) {
        // String selectedItem = (String) comboBox1.getSelectedItem();
        // if (selectedItem.equals("Tất cả")) {
        // textField1.setBorder(BorderFactory.createTitledBorder("Tất cả"));
        // } else if (selectedItem.equals("Mã khuyến mãi")) {
        // textField1.setBorder(BorderFactory.createTitledBorder("Mã khuyến mãi"));
        // } else if (selectedItem.equals("Tên khuyến mãi")) {
        // textField1.setBorder(BorderFactory.createTitledBorder("Tên khuyến mãi"));
        // } else if (selectedItem.equals("Điều kiện")) {
        // textField1.setBorder(BorderFactory.createTitledBorder("Điều kiện"));
        // } else if (selectedItem.equals("Giảm giá")) {
        // textField1.setBorder(BorderFactory.createTitledBorder("Giảm giá"));
        // } else if (selectedItem.equals("Ngày bắt đầu")) {
        // textField1.setBorder(BorderFactory.createTitledBorder("Ngày bắt đầu"));
        // } else if (selectedItem.equals("Ngày kết thúc")) {
        // textField1.setBorder(BorderFactory.createTitledBorder("Ngày kết thúc"));
        // }
        // }
        // });

        comboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedItem = (String) e.getItem();

                    qlkm.readDB();
                    ArrayList<Promotion> allPromotions = qlkm.getDskm();

                    if ("Tất cả".equals(selectedItem)) {
                        setDataToTable(allPromotions);
                    } else {
                        ArrayList<Promotion> filteredPromotions = new ArrayList<>();
                        for (Promotion promotion : allPromotions) {
                            if (selectedItem.equals(promotion.getTrangThai())) {
                                filteredPromotions.add(promotion);
                            }
                        }
                        setDataToTable(filteredPromotions);
                    }
                }
            }
        });

        // su kien khi nhan vao nut them
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddButtonKhuyenMai addButtonKhuyenMai = new AddButtonKhuyenMai("Thêm", "", FormKhuyenMai.this);
                addButtonKhuyenMai.setVisible(true);
            }
        });
        refresh();

        // su kien khi nhan vao nut xoa
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectedRow = table1.getSelectedRow();
                if (selectedRow != -1) {
                    int comfirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa khuyến mãi này không?",
                            "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (comfirm == JOptionPane.YES_OPTION) {
                        String makm = (String) table1.getValueAt(selectedRow, 1);
                        if (qlkm.delete(makm)) {
                            ((DefaultTableModel) table1.getModel()).removeRow(selectedRow);
                            JOptionPane.showOptionDialog(null, "Xóa thành công", "Thông báo",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] {},
                                    null);
                        } else {
                            JOptionPane.showOptionDialog(null, "Xóa thất bại", "Thông báo", JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.ERROR_MESSAGE, null, new Object[] {}, null);
                        }
                    }
                } else {
                    JOptionPane.showOptionDialog(null, "Chưa chọn khuyến mãi nào để xóa", "Thông báo",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[] {}, null);
                }
            }
        });
        refresh();

        // su kien khi nhan vao nut sua
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectedRow = table1.getSelectedRow();
                if (selectedRow != -1) {
                    String maKhuyenMai = (String) table1.getValueAt(selectedRow, 1);
                    Promotion selectedPromotion = qlkm.getKhuyenMai(maKhuyenMai);
                    if (selectedPromotion != null) {
                        String ngayBatDau = selectedPromotion.getNgayBatDau().toString();
                        String ngayKetThuc = selectedPromotion.getNgayKetThuc().toString();

                        AddButtonKhuyenMai addButtonKhuyenMai = new AddButtonKhuyenMai("Sửa", maKhuyenMai,
                                FormKhuyenMai.this);
                        addButtonKhuyenMai.txNgayBD.setText(ngayBatDau);
                        addButtonKhuyenMai.txNgayKT.setText(ngayKetThuc);
                        addButtonKhuyenMai.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Khuyến mãi không tồn tại!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Chưa chọn khuyến mãi nào!");
                }
            }
        });
        refresh();

        // su kien khi nhan ket thuc
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectedRow = table1.getSelectedRow();
                if (selectedRow != -1) {
                    String makm = (String) table1.getValueAt(selectedRow, 1);
                    Promotion selectedPromotion = qlkm.getKhuyenMai(makm);
                    if (selectedPromotion != null && "Đang diễn ra".equals(selectedPromotion.getTrangThai())) {
                        selectedPromotion.setTrangThai("Đã kết thúc");
                        if (qlkm.update(selectedPromotion.getMaKhuyenMai(), selectedPromotion.getTenKhuyenMai(),
                                selectedPromotion.getDieuKienKhuyenMai(), selectedPromotion.getPhanTramKhuyenMai(),
                                selectedPromotion.getNgayBatDau(), selectedPromotion.getNgayKetThuc())) {
                            table1.setValueAt("Đã kết thúc", selectedRow, 7);
                            JOptionPane.showMessageDialog(null, "Kết thúc khuyến mãi thành công");
                        } else {
                            JOptionPane.showMessageDialog(null, "Kết thúc khuyến mãi thất bại");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Không thể kết thúc khuyến mãi này");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Chưa chọn khuyến mãi nào để kết thúc");
                }
            }
        });
        refresh();

        // su kien khi nhan vao nut "Xuat excel"
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Chọn nơi lưu file");

                int userSelection = fileChooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();

                    Workbook workbook = new XSSFWorkbook();
                    Sheet sheet = workbook.createSheet("Khuyến mãi");

                    // tao row header
                    Row headerRow = sheet.createRow(0);
                    headerRow.createCell(0).setCellValue("STT");
                    headerRow.createCell(1).setCellValue("Mã khuyến mãi");
                    headerRow.createCell(2).setCellValue("Tên khuyến mãi");
                    headerRow.createCell(3).setCellValue("Điều kiện");
                    headerRow.createCell(4).setCellValue("Giảm giá");
                    headerRow.createCell(5).setCellValue("Ngày bắt đầu");
                    headerRow.createCell(6).setCellValue("Ngày kết thúc");
                    headerRow.createCell(7).setCellValue("Trạng thái");

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

                            String maKhuyenMai = row.getCell(1).getStringCellValue();
                            String tenKhuyenMai = row.getCell(2).getStringCellValue();
                            float dieuKienKhuyenMai = (float) row.getCell(3).getNumericCellValue();
                            float phanTramKhuyenMai = (float) row.getCell(4).getNumericCellValue();
                            LocalDate ngayBatDau = LocalDate.parse(row.getCell(5).getStringCellValue());
                            LocalDate ngayKetThuc = LocalDate.parse(row.getCell(6).getStringCellValue());
                            String trangThai = row.getCell(7).getStringCellValue();

                            Promotion promotion = new Promotion(maKhuyenMai, tenKhuyenMai, dieuKienKhuyenMai,
                                    phanTramKhuyenMai, ngayBatDau, ngayKetThuc, trangThai);

                            // add to the database
                            qlkm.add(promotion);
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

        // su kien nut lam moi
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comboBox1.setSelectedItem("Tất cả");
                textField1.setText("");
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

            private void performSearch() {
                String value = textField1.getText();
                String type = (String) comboBox1.getSelectedItem();
                ArrayList<Promotion> result = qlkm.search(value, type, -1, -1, -1, 0 - 1, null, null);
                setDataToTable(result);
            }
        });

        // su kien khi nhan nut lam moi
        button7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comboBox1.setSelectedItem("Tất cả");
                textField1.setText("");
            }
        });
    }

    // refresh data in table
    public void refresh() {
        qlkm.readDB();
        setDataToTable(qlkm.getDskm());
    }

    // set data for the table
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
            if (promotion.getTrangThai().equals("Đang diễn ra") || promotion.getTrangThai().equals("Chưa bắt đầu")
                    || promotion.getTrangThai().equals("Đã kết thúc")) {
                tableModel.addRow(new Object[] {
                        stt++,
                        promotion.getMaKhuyenMai(),
                        promotion.getTenKhuyenMai(),
                        PriceFormatter.format(promotion.getDieuKienKhuyenMai()),
                        PriceFormatter.format(promotion.getPhanTramKhuyenMai()),
                        promotion.getNgayBatDau(),
                        promotion.getNgayKetThuc(),
                        promotion.getTrangThai()
                });
            }
        }
        table1.setModel(tableModel);
    }

    private void writePromotionstoExcel(ArrayList<Promotion> promotions, String fileName) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Khuyến mãi");

        // tao dong header
        Row rowHeader = sheet.createRow(0);
        for (int i = 0; i < table1.getColumnCount(); i++) {
            Cell cell = rowHeader.createCell(i);
            cell.setCellValue(table1.getColumnName(i));
        }

        // them data vao row
        for (int i = 0; i < promotions.size(); i++) {
            Promotion promotion = promotions.get(i);
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(i + 1);
            row.createCell(1).setCellValue(promotion.getMaKhuyenMai());
            row.createCell(2).setCellValue(promotion.getTenKhuyenMai());
            row.createCell(3).setCellValue(promotion.getDieuKienKhuyenMai());
            row.createCell(4).setCellValue(promotion.getPhanTramKhuyenMai());
            row.createCell(5).setCellValue(promotion.getNgayBatDau().toString());
            row.createCell(6).setCellValue(promotion.getNgayKetThuc().toString());
            row.createCell(7).setCellValue(promotion.getTrangThai());
        }

        // ghi vao file excel
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
        }

        // dong workbook
        workbook.close();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Master
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panelrong;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel paneltr;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JButton button7;
    private JPanel panel5;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
