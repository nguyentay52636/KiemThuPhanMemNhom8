/*
 * Created by JFormDesigner on Wed Apr 24 10:48:51 ICT 2024
 */

package Layout.models.FrontEnd.FormStaff;

import Layout.models.BackEnd.BUS.StaffBUS;
import Layout.models.BackEnd.DTO.Promotion;
import Layout.models.BackEnd.DTO.Staff;
import Layout.models.FrontEnd.FormAccount.FormAccount;
import Layout.models.FrontEnd.FormPromotion.DateLabelFormatter;
import com.mysql.cj.xdevapi.Table;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.stream.Collectors;
import javax.print.Doc;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;

/**
 * @author master
 */
public class FormChooseEmployee extends JFrame {
    StaffBUS qlnv = new StaffBUS();

    public FormChooseEmployee() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        refresh();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Master
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panelft = new JPanel();
        comboBox1 = new JComboBox();
        textField1 = new JTextField();
        panel4 = new JPanel();
        textField2 = new JTextField();
        button1 = new JButton();
        textField3 = new JTextField();
        button2 = new JButton();
        button3 = new JButton();
        buttonadd = new JButton();
        buttonexit = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBorder(new CompoundBorder(new TitledBorder(new
            EmptyBorder(0,0,0,0), "",TitledBorder.CENTER,TitledBorder.BOTTOM,new Font("Dia\u006cog",Font.BOLD,12),Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(new
            PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".
            equals(e.getPropertyName()))throw new RuntimeException();}});
            panel1.setLayout(new GridLayout(1, 1));

            //======== panel2 ========
            {
                panel2.setLayout(new FlowLayout());

                //======== panel3 ========
                {
                    panel3.setBorder(new TitledBorder("T\u00ecm ki\u1ebfm"));
                    panel3.setLayout(new FlowLayout());

                    //---- comboBox1 ----
                    comboBox1.setPreferredSize(new Dimension(130, 40));
                    panel3.add(comboBox1);

                    //---- textField1 ----
                    textField1.setPreferredSize(new Dimension(144, 55));
                    panel3.add(textField1);
                }
                panel2.add(panel3);

                //======== panel4 ========
                {
                    panel4.setBorder(new TitledBorder("Ng\u00e0y sinh"));
                    panel4.setLayout(new FlowLayout());

                    //---- textField2 ----
                    textField2.setPreferredSize(new Dimension(100, 55));
                    textField2.setBorder(BorderFactory.createTitledBorder("Từ"));
                    panel4.add(textField2);

                    //---- button1 ----
                    button1.setPreferredSize(new Dimension(55, 55));
                    button1.setIcon(new ImageIcon(getClass().getResource("/images/icons8_calendar_31_30px.png")));
                    panel4.add(button1);

                    //---- textField3 ----
                    textField3.setPreferredSize(new Dimension(100, 55));
                    textField3.setBorder(BorderFactory.createTitledBorder("Đến"));
                    panel4.add(textField3);

                    //---- button2 ----
                    button2.setPreferredSize(new Dimension(55, 55));
                    button2.setIcon(new ImageIcon(getClass().getResource("/images/icons8_calendar_31_30px.png")));
                    panel4.add(button2);
                }
                panel2.add(panel4);

                //---- button3 ----
                button3.setText("L\u00e0m m\u1edbi");
                button3.setPreferredSize(new Dimension(144, 55));
                button3.setIcon(new ImageIcon(getClass().getResource("/images/icons8_data_backup_30px.png")));
                panel2.add(button3);
            }
            panel1.add(panel2);
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null, null, null
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);

        //======== panelfooter ========
        {
            panelft.setLayout(new FlowLayout());

            //========= buttonadd ========
            buttonadd.setText("Chọn");
            buttonadd.setPreferredSize(new Dimension(130, 55));
            buttonadd.setIcon(new ImageIcon(getClass().getResource("/images/icons8_ok_30px.png")));
            panelft.add(buttonadd);

            //========= buttondel =========
            buttonexit.setText("Thoát");
            buttonexit.setPreferredSize(new Dimension(130, 55));
            buttonexit.setIcon(new ImageIcon(getClass().getResource("/images/icons8_cancel_30px_1.png")));
            panelft.add(buttonexit);
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

        // add item for comboBox1
        String[] items = {"Tất cả", "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Trạng thái"};
        for (String item : items) {
            comboBox1.addItem(item);
        }

        // su kien khi chon item trong comboBox1
        textField1.setBorder(BorderFactory.createTitledBorder("Tất cả"));
        comboBox1.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedItem = (String) comboBox1.getSelectedItem();
                if (selectedItem.equals("Tất cả")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Tất cả"));
                } else if (selectedItem.equals("Mã nhân viên")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Mã nhân viên"));
                } else if (selectedItem.equals("Tên nhân viên")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Tên nhân viên"));
                } else if (selectedItem.equals("Ngày sinh")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Ngày sinh"));
                } else if (selectedItem.equals("Địa chỉ")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Địa chỉ"));
                } else if (selectedItem.equals("Số điện thoại")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Số điện thoại"));
                } else if (selectedItem.equals("Trạng thái")) {
                    textField1.setBorder(BorderFactory.createTitledBorder("Trạng thái"));
                }
            }
        });

        // su kien khi nhan vao nut lam moi
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comboBox1.setSelectedItem("Tất cả");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
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
                ArrayList<Staff> result = qlnv.search(value, type);

                // search by data
                setDataToTable(result);
            }
        });

        // chon ngay sinh bat dau
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UtilDateModel model = new UtilDateModel();
                Properties p = new Properties();
                p.put("text.today", "Today");
                p.put("text.month", "Month");
                p.put("text.year", "Year");

                JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
                JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
                datePicker.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Date selectedDate = (Date) datePicker.getModel().getValue();
                        if (selectedDate == null) {
                            JOptionPane.showOptionDialog(null, "Chưa chọn ngày", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{}, null);
                            return;
                        }
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        String dateString = formatter.format(selectedDate);
                        textField2.setText(dateString);
                    }
                });
                JOptionPane.showMessageDialog(null, datePicker);
            }
        });

        // chon ngay sinh ket thuc
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UtilDateModel model = new UtilDateModel();
                Properties p = new Properties();
                p.put("text.today", "Today");
                p.put("text.month", "Month");
                p.put("text.year", "Year");
                JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
                JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
                datePicker.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Date selectedDate = (Date) datePicker.getModel().getValue();
                        if (selectedDate == null) {
                            JOptionPane.showOptionDialog(null, "Chưa chọn ngày", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{}, null);
                            return;
                        }
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        String dateString = formatter.format(selectedDate);
                        textField3.setText(dateString);

                        // kiem tra ngay ket thuc phai lon hon ngay bat dau
                        String startDateString = textField2.getText();
                        try {
                            Date startDate = formatter.parse(startDateString);
                            if (startDate.after(selectedDate)) {
                                JOptionPane.showMessageDialog(null, "Ngày kết thúc phải sau ngày bắt đầu");
                                textField3.setText("");
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                });
                JOptionPane.showMessageDialog(null, datePicker);

                // loc ngay sinh sau khi chon ngay ket thuc
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                final LocalDate startDate;
                final LocalDate endDate;
                try {
                    startDate = LocalDate.parse(textField2.getText(), formatter);
                    endDate = LocalDate.parse(textField3.getText(), formatter);
                } catch (DateTimeParseException e) {
                    // Handle exception if date format is incorrect
                    JOptionPane.showMessageDialog(null, "Định dạng ngày không hợp lệ. Vui lòng nhập lại.");
                    return;
                }

                // Filter the employees based on the date range
                if (startDate != null && endDate != null) {
                    ArrayList<Staff> result = qlnv.getList().stream()
                            .filter(staff -> {
                                LocalDate staffBirthDate = staff.getNgaySinh().toLocalDate();
                                return (staffBirthDate.isAfter(startDate) || staffBirthDate.isEqual(startDate)) &&
                                        (staffBirthDate.isBefore(endDate) || staffBirthDate.isEqual(endDate));
                            })
                            .collect(Collectors.toCollection(ArrayList::new));

                    // Set the filtered data to the table
                    setDataToTable(result);
                }
            }
        });

        // su kien cho nut chon
        buttonadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String selectedEmployeeId = getSelectedEmployeeId();
                if (selectedEmployeeId == null) {
                    JOptionPane.showMessageDialog(null, "Chưa chọn nhân viên");
                    return;
                }
                dispose();
            }
        });

        // su kien cho nut thoat
        buttonexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
    }

    // su kien khi nhan vao buttonadd (chon)
    public void addButtonAddActionListener(ActionListener actionListener) {
        buttonadd.addActionListener(actionListener);

    }

    // lay id
    public String getSelectedEmployeeId() {
        int selectedRow = table1.getSelectedRow();
        if (selectedRow != -1) {
            return table1.getValueAt(selectedRow, 1).toString();
        }
        return null;
    }

    // refresh data
    public void refresh() {
        qlnv.readDB();
        setDataToTable(qlnv.getList());
    }

    // set data for table
    public void setDataToTable(ArrayList<Staff> data) {
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("STT");
        tableModel.addColumn("Mã nhân viên");
        tableModel.addColumn("Tên nhân viên");
        tableModel.addColumn("Ngày sinh");
        tableModel.addColumn("Địa chỉ");
        tableModel.addColumn("Số điện thoại");
        tableModel.addColumn("Trạng thái");

        int stt = 1;
        for (Staff staff : data) {
            if (staff.getTrangThai() == 0) {
                tableModel.addRow(new Object[] {
                        stt++,
                        staff.getMaNV(),
                        staff.getTenNV(),
                        staff.getNgaySinh(),
                        staff.getDiachi(),
                        staff.getSDT(),
                        staff.getTrangThai() == 0 ? "Đang hoạt động" : "Ngừng hoạt động"
                });
            }
        }
        table1.setModel(tableModel);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Master
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panelft;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JPanel panel4;
    private JTextField textField2;
    private JButton button1;
    private JTextField textField3;
    private JButton button2;
    private JButton button3;
    private JButton buttonadd;
    private JButton buttonexit;
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
                new FormChooseEmployee();
            }
        });
    }
}


