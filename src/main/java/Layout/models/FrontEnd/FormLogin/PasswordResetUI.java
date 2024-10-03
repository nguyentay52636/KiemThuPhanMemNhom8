package Layout.models.FrontEnd.FormLogin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import Layout.models.BackEnd.DAO.AccountDAO;
import Layout.models.BackEnd.DTO.Account;

public class PasswordResetUI extends JFrame {

    private JPasswordField newPasswordField;
    private JPasswordField confirmPasswordField;
    private JButton resetButton;

    public PasswordResetUI() {
        setTitle("Lấy lại mật khẩu");
        setSize(600, 400); // Set kích thước frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding giữa các thành phần
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Đặt màu nền tối cho form
        getContentPane().setBackground(new Color(60, 63, 65));

        // Khởi tạo các thành phần
        JLabel newPasswordLabel = new JLabel("Nhập mật khẩu mới:");
        newPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        newPasswordLabel.setForeground(Color.WHITE); // Màu chữ trắng

        newPasswordField = new JPasswordField(20);
        newPasswordField.setFont(new Font("Arial", Font.PLAIN, 18));
        newPasswordField.setBackground(new Color(43, 43, 43)); // Màu nền text field
        newPasswordField.setForeground(Color.WHITE); // Màu chữ trắng
        newPasswordField.setCaretColor(Color.WHITE); // Màu con trỏ

        JLabel confirmPasswordLabel = new JLabel("Xác nhận mật khẩu mới:");
        confirmPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        confirmPasswordLabel.setForeground(Color.WHITE); // Màu chữ trắng

        confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 18));
        confirmPasswordField.setBackground(new Color(43, 43, 43)); // Màu nền text field
        confirmPasswordField.setForeground(Color.WHITE); // Màu chữ trắng
        confirmPasswordField.setCaretColor(Color.WHITE); // Màu con trỏ

        resetButton = new JButton("Đặt lại mật khẩu");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 18));
        resetButton.setBackground(new Color(50, 120, 255)); // Màu nền xanh
        resetButton.setForeground(Color.WHITE); // Màu chữ trắng

        // Add các thành phần vào frame

        // Mật khẩu mới
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(newPasswordLabel, gbc);
        gbc.gridx = 1;
        add(newPasswordField, gbc);

        // Xác nhận mật khẩu
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(confirmPasswordLabel, gbc);
        gbc.gridx = 1;
        add(confirmPasswordField, gbc);

        // Nút đặt lại mật khẩu
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(resetButton, gbc);

        // Xử lý sự kiện khi nhấn nút "Đặt lại mật khẩu"
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newPassword = new String(newPasswordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                // Validate kiểm tra 2 password
                if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(PasswordResetUI.this,
                            "Vui lòng điền đầy đủ thông tin.",
                            "Thông báo",
                            JOptionPane.WARNING_MESSAGE);
                } else if (!newPassword.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(PasswordResetUI.this,
                            "Mật khẩu xác nhận không khớp.",
                            "Lỗi",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        Account account = new Account();
                        AccountDAO accountDAO = new AccountDAO();
                        String email = "admin@example.com";

                        // Cập nhật mật khẩu trong cơ sở dữ liệu
                        boolean isUpdated = accountDAO.updatePasswordByEmail(email, newPassword);
                        if (isUpdated) {
                            JOptionPane.showMessageDialog(PasswordResetUI.this,
                                    "Mật khẩu đã được đặt lại thành công!",
                                    "Thông báo",
                                    JOptionPane.INFORMATION_MESSAGE);
                            account.setPassword(newPassword);
                            dispose(); // Đóng cửa sổ sau khi thành công
                        } else {
                            JOptionPane.showMessageDialog(PasswordResetUI.this,
                                    "Đặt lại mật khẩu thất bại. Vui lòng thử lại.",
                                    "Lỗi",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(PasswordResetUI.this,
                                "Đã xảy ra lỗi: " + ex.getMessage(),
                                "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        setVisible(true);
    }

}
