package Layout.models.FrontEnd.FormCustomer;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Layout.models.BackEnd.BUS.CustomerBUS;
import Layout.models.BackEnd.DTO.Customer;

public class AddButtonCustomer extends JFrame {
    private String title;
    private String maKhachHang;
    private FormKhachHang formKhachHang;

    String type;
    CustomerBUS qlkhBUS = new CustomerBUS();
    Customer khSua;

    JTextField txMakh = new JTextField(15);
    JTextField txTenkh = new JTextField(15);
    JTextField txDiachi = new JTextField(15);
    JTextField txSDT = new JTextField(15);
    JComboBox<String> cbChonTrangThai;

    JButton btnThem = new JButton("Thêm");
    JButton btnSua = new JButton("Sửa");
    JButton btnHuy = new JButton("Hủy");

    public AddButtonCustomer(String title, String maKhachHang, FormKhachHang formKhachHang) {
        this.title = title;
        this.maKhachHang = maKhachHang;
        this.formKhachHang = formKhachHang;
        initComponents();
    }

    public void initComponents() {
        this.setLayout(new BorderLayout());
        this.setSize(450, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.type = this.title;

        // inputs
        txMakh.setBorder(BorderFactory.createTitledBorder("Mã khách hàng"));
        txTenkh.setBorder(BorderFactory.createTitledBorder("Tên khách hàng"));
        txDiachi.setBorder(BorderFactory.createTitledBorder("Địa chỉ"));
        txSDT.setBorder(BorderFactory.createTitledBorder("Số điện thoại"));
        cbChonTrangThai = new JComboBox<>(new String[] { "Ẩn", "Hiện" });

        // chon trang thai
        JPanel plChonTT = new JPanel();
        plChonTT.setBorder(BorderFactory.createTitledBorder("Trạng thái"));
        JLabel lbChonTT = new JLabel("Trạng thái: ");
        plChonTT.add(lbChonTT);
        plChonTT.add(cbChonTrangThai);

        JPanel plInput = new JPanel();
        plInput.add(txMakh);
        plInput.add(txTenkh);
        plInput.add(txDiachi);
        plInput.add(txSDT);
        plInput.add(plChonTT);

        // panel buttons
        JPanel plButton = new JPanel();

        // 2 case Thêm - Sửa
        if (this.type.equals("Thêm")) {
            this.setTitle("Thêm khách hàng");
            txMakh.setText(qlkhBUS.getNextID());
            txMakh.setEnabled(false);

            cbChonTrangThai.setSelectedItem("Hiện");

            btnThem.setIcon(new ImageIcon(this.getClass().getResource("/images/icons8_add_30px.png")));
            plButton.add(btnThem);

        } else {
            this.setTitle("Sửa khách hàng");
            for (Customer kh : qlkhBUS.getDskh()) {
                if (kh.getMaKH().equals(this.maKhachHang)) {
                    this.khSua = kh;
                }
            }
            if (this.khSua == null) {
                JOptionPane.showMessageDialog(null, "Lỗi, không tìm thấy khách hàng");
                this.dispose();
            }

            cbChonTrangThai.setSelectedItem(this.khSua.getTrangThai() == 0 ? "Hiện" : "Ẩn");
            txMakh.setText(this.khSua.getMaKH());
            txMakh.setEnabled(false);
            txTenkh.setText(this.khSua.getTenKh());
            txDiachi.setText(this.khSua.getDiaChi());
            txSDT.setText(this.khSua.getSdt());

            // txMakh.setEditable(false);

            btnSua.setIcon(new ImageIcon(this.getClass().getResource("/images/icons8_support_30px.png")));
            plButton.add(btnSua);
        }

        btnHuy.setIcon(new ImageIcon(this.getClass().getResource("/images/icons8_cancel_30px_1.png")));
        plButton.add(btnHuy);

        this.add(plInput, BorderLayout.CENTER);
        this.add(plButton, BorderLayout.SOUTH);

        // mouse listener
        btnThem.addActionListener((ae) -> {
            btnThemMouseClicked();
        });
        btnSua.addActionListener((ae) -> {
            btnSuaMouseClicked();
        });
        btnHuy.addActionListener((ae) -> {
            this.dispose();
        });

        // nhap so dien thoai
        InputVerifier phoneVerifier = new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField textField = (JTextField) input;
                String text = textField.getText();

                if (text.matches("^0\\d{9}$")) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
                    Toolkit.getDefaultToolkit().beep();
                    return false;
                }
            }
        };
        txSDT.setInputVerifier(phoneVerifier);

        this.setVisible(true);
    }

    private void btnThemMouseClicked() {
        if (checkEmpty()) {
            String makh = txMakh.getText();
            txMakh.setEnabled(false);
            String tenkh = txTenkh.getText();
            String diachi = txDiachi.getText();
            String sdt = txSDT.getText();
            int trangthai = (cbChonTrangThai.getSelectedItem().toString().equals("Hiện") ? 0 : 1);

            if (qlkhBUS.add(makh, tenkh, diachi, sdt, trangthai)) {
                JOptionPane.showMessageDialog(this, "Thêm " + tenkh + " thành công!");
                this.dispose();
            }
        }
        formKhachHang.refresh();
    }

    private void btnSuaMouseClicked() {
        txMakh.setEnabled(false);
        if (checkEmpty()) {
            String makh = txMakh.getText();
            String tenkh = txTenkh.getText();
            String diachi = txDiachi.getText();
            String sdt = txSDT.getText();
            int trangthai = (cbChonTrangThai.getSelectedItem().toString().equals("Hiện") ? 0 : 1);

            if (qlkhBUS.update(makh, tenkh, diachi, sdt, trangthai)) {
                JOptionPane.showMessageDialog(this, "Sửa " + makh + " thành công!");
                this.dispose();
            }
        }
        formKhachHang.refresh();
    }

    private Boolean checkEmpty() {
        String makh = txMakh.getText();
        String tenkh = txTenkh.getText();
        String diachi = txDiachi.getText();
        String sdt = txSDT.getText();

        if (makh.trim().equals("")) {
            return showErrorTx(txMakh, "Mã khách hàng không được để trống");

        } else if (tenkh.trim().equals("")) {
            return showErrorTx(txTenkh, "Tên khách hàng không được để trống");

        } else if (diachi.trim().equals("")) {
            return showErrorTx(txTenkh, "Địa chỉ không được để trống");

        } else if (sdt.trim().equals("")) {
            return showErrorTx(txTenkh, "Số điện thoại không được để trống");
        }

        return true;
    }

    private Boolean showErrorTx(JTextField tx, String errorInfo) {
        JOptionPane.showMessageDialog(tx, errorInfo);
        tx.requestFocus();
        return false;
    }
}
