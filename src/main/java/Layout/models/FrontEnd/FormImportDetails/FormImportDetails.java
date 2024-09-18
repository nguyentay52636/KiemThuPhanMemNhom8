package Layout.models.FrontEnd.FormImportDetails;

import Layout.models.BackEnd.BUS.ImportDetailsBUS;
import Layout.models.BackEnd.BUS.ProductBUS;
import Layout.models.BackEnd.DTO.ImportDetails;
import Layout.models.FrontEnd.Formatter.PriceFormatter;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormImportDetails extends JPanel {
    ProductBUS productBUS = new ProductBUS();
    ImportDetailsBUS importDetailsBUS = new ImportDetailsBUS();

    public FormImportDetails(String maPN) {
        this.maPN = maPN;
        initComponents();
        refresh();
    }

    private void initComponents() {
        panel1 = new JPanel();
        panel2 = new JPanel();
        comboBox1 = new JComboBox();
        textField1 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        // ======== this ========
        setBorder(new CompoundBorder(new TitledBorder(
                new javax.swing.border.EmptyBorder(0, 0, 0, 0), "",
                TitledBorder.CENTER, TitledBorder.BOTTOM,
                new Font("Dialo\u0067", Font.BOLD, 12), Color.red), getBorder()));
        addPropertyChangeListener(
                new java.beans.PropertyChangeListener() {
                    @Override
                    public void propertyChange(java.beans.PropertyChangeEvent e) {
                        if ("borde\u0072".equals(e.getPropertyName()))
                            throw new RuntimeException();
                    }
                });
        setLayout(new BorderLayout());

        // ======== panel1 ========
        {
            panel1.setBorder(new CompoundBorder(
                    new TitledBorder(""),
                    null));
            panel1.setPreferredSize(new Dimension(120, 100));
            panel1.setMinimumSize(new Dimension(800, 80));
            panel1.setLayout(new FlowLayout());

            // ======== panel2 ========
            {
                panel2.setBorder(new TitledBorder(null, "T\u00ecm ki\u1ebfm:", TitledBorder.LEADING,
                        TitledBorder.DEFAULT_POSITION, null, Color.black));
                panel2.setPreferredSize(new Dimension(300, 80));
                panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));

                // ---- comboBox1 ----
                comboBox1.setMinimumSize(new Dimension(200, 35));
                comboBox1.setPreferredSize(new Dimension(70, 40));
                String[] items = { "Tất cả", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền" };
                for (String item : items) {
                    comboBox1.addItem(item);
                }
                panel2.add(comboBox1);

                // ---- textField1 ----
                textField1.setPreferredSize(new Dimension(230, 10));
                panel2.add(textField1);
            }
            panel1.add(panel2);



            // ---- button1 ----
            button1.setText("L\u00e0m m\u1edbi");
            button1.setIcon(new ImageIcon(getClass().getResource("/images/icons8_data_backup_30px.png")));
            button1.setMaximumSize(new Dimension(100, 50));
            button1.setPreferredSize(new Dimension(120, 50));
            button1.setIconTextGap(1);
            button1.setMinimumSize(new Dimension(100, 40));
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    refresh();
                }
            });
            panel1.add(button1);
        }
        add(panel1, BorderLayout.NORTH);

        // ======== scrollPane1 ========
        {
            Font font = new Font("Segoe UI", 0, 16);
            Font fontHeader = new Font("Segoe UI", Font.BOLD, 16);

            // set font for the table
            table1.setFont(font);
            table1.getTableHeader().setFont(fontHeader);
            table1.setRowHeight(30);
            TableColumnModel columnModel = table1.getColumnModel();
            for (int i = 0; i < columnModel.getColumnCount(); i++) {
                columnModel.getColumn(i).setPreferredWidth(150);
            }
            // ---- table1 ----
            table1.setModel(new DefaultTableModel(
                    new Object[][] {
                            { null, null, null, null, null },

                    },
                    getHeaders()));

            table1.setFocusCycleRoot(true);
            table1.setFocusTraversalPolicyProvider(true);
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1, BorderLayout.CENTER);
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
            public void changedUpdate(DocumentEvent e) {
                performSearch();

            }

            public void performSearch() {
                String keyWord = textField1.getText();
                String type = (String) comboBox1.getSelectedItem();
                ArrayList<ImportDetails> result = ImportDetailsBUS.search(type, keyWord);
                setDataTable(result);

            }
        });
    }

    public String[] getHeaders() {
        return new String[] { "Mã phiếu nhập ", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá",
                "Thành tiền" };
    }

    public void refresh() {
        importDetailsBUS.readDB();
        ArrayList<ImportDetails> importDetails = importDetailsBUS.getImportDetailsByMaHD(maPN);
        setDataTable(importDetails);
    }

    public void setDataTable(ArrayList<ImportDetails> data) {

        DefaultTableModel models = new DefaultTableModel();
        models.addColumn("STT");
        models.addColumn("Mã phiếu nhập");
        models.addColumn("Mã sản phẩm");
        models.addColumn("Tên sản phẩm");
        models.addColumn("Số lượng");
        models.addColumn("Đơn giá");
        models.addColumn("Thành tiền");
        for (int i = 0; i < data.size(); i++) {
            ImportDetails invoiceDetails = data.get(i);
            models.addRow(new String[] {
                    String.valueOf(i + 1),
                    invoiceDetails.getMa(),
                    invoiceDetails.getMaSP(),
                    productBUS.getProduct(invoiceDetails.getMaSP()).getTenSP(),
                    String.valueOf(invoiceDetails.getSoLuong()),
                    PriceFormatter.format(invoiceDetails.getDonGia()),
                    PriceFormatter.format((invoiceDetails.getDonGia()) * (invoiceDetails.getSoLuong())),
            });
        }
        table1.setModel(models);

    }

    private String maPN;
    private JPanel panel1;
    private JPanel panel2;
    private JComboBox comboBox1;
    private JTextField textField1;

    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;

}

