package Layout.models.FrontEnd.NavBar;

import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Layout.models.BackEnd.BUS.AccountBUS;
import Layout.models.BackEnd.DTO.Account;

public class FormChangePassword extends JFrame {

    Account tk;

    JPasswordField txMatKhauCu = new JPasswordField(15);
    JPasswordField txMatKhauMoi = new JPasswordField(15);
    JPasswordField txXacNhanMatKhau = new JPasswordField(15);

    JButton btnDongY = new JButton("Đồng ý");
    JButton btnHuy = new JButton("Hủy");

    public FormChangePassword(String matk) {
        setLayout(new BorderLayout());
        setSize(350, 350);
        setTitle("Đổi mật khẩu");
        setLocationRelativeTo(null);
        tk = new AccountBUS().getTaiKhoan(matk);

        // input
        JPanel plInput = new JPanel();
        txMatKhauCu.setBorder(BorderFactory.createTitledBorder("Mật khẩu cũ: "));
        txMatKhauMoi.setBorder(BorderFactory.createTitledBorder("Mật khẩu mới: "));
        txXacNhanMatKhau.setBorder(BorderFactory.createTitledBorder("Xác nhận mật khẩu: "));

        plInput.add(txMatKhauCu);
        plInput.add(txMatKhauMoi);
        plInput.add(txXacNhanMatKhau);

        this.add(plInput, BorderLayout.CENTER);

        // button
        JPanel plButton = new JPanel();
        plButton.add(btnDongY);
        plButton.add(btnHuy);

        // Load icons safely
        URL cancelIconUrl = this.getClass().getResource("/images/icons8_cancel_30px_1.png");
        URL okIconUrl = this.getClass().getResource("/images/icons8_add_30px.png");
        if (cancelIconUrl != null) {
            btnHuy.setIcon(new ImageIcon(cancelIconUrl));
        } else {
            System.err.println("Resource not found: /giaodienchuan/images/icons8_cancel_30px_1.png");
        }

        if (okIconUrl != null) {
            btnDongY.setIcon(new ImageIcon(okIconUrl));
        } else {
            System.err.println("Resource not found: /giaodienchuan/images/icons8_ok_30px.png");
        }

        btnHuy.addActionListener((ae) -> {
            this.dispose();
        });
        btnDongY.addActionListener((ae) -> {
            if (checkPass()) {
                if (new AccountBUS().update(tk.getEmail(), tk.getUsername(), txMatKhauMoi.getText(), tk.getMaNV(),
                        tk.getMaQuyen())) {
                    JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!");
                    this.dispose();
                }
            }
        });

        this.add(plButton, BorderLayout.SOUTH);
    }

    private Boolean checkPass() {
        String mkcu = txMatKhauCu.getText();
        String mkmoi = txMatKhauMoi.getText();
        String xnmk = txXacNhanMatKhau.getText();

        if (!mkcu.equals(tk.getPassword())) {
            JOptionPane.showMessageDialog(txMatKhauCu, "Mật khẩu cũ không đúng!");
            txMatKhauCu.requestFocus();
            return false;

        } else if (mkmoi.equals("") || xnmk.equals("")) {
            JOptionPane.showMessageDialog(txMatKhauMoi, "Mật khẩu mới không được để trống!");
            txMatKhauMoi.requestFocus();
            return false;

        } else if (!mkmoi.equals(xnmk)) {
            JOptionPane.showMessageDialog(txXacNhanMatKhau, "Mật khẩu mới không khớp!");
            txXacNhanMatKhau.requestFocus();
            return false;
        }

        return true;
    }
}