package Layout.models.FrontEnd.FormLogin;

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
        setSize(600, 400); // Set kích thước frame mới
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding giữa các thành phần
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Khởi tạo các thành phần
        JLabel newPasswordLabel = new JLabel("Nhập mật khẩu mới:");
        newPasswordLabel.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
        newPasswordField = new JPasswordField(20);
        newPasswordField.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));

        JLabel confirmPasswordLabel = new JLabel("Xác nhận mật khẩu mới:");
        confirmPasswordLabel.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
        confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));

        resetButton = new JButton("Đặt lại mật khẩu");
        resetButton.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));

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
                        System.out.println(account);
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
                        ex.printStackTrace(); // In ra chi tiết lỗi (tùy chọn)
                    }

                }

            }
        });

        setVisible(true);
    }

}
