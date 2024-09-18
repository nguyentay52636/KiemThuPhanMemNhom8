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
import javax.swing.JTextField;

import Layout.models.BackEnd.Services.EmailService;

public class PasswordResetForm extends JFrame {

    private JTextField emailField;
    private JButton sendButton;

    public PasswordResetForm() {
        setTitle("Khôi phục mật khẩu");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Khởi tạo các thành phần
        JLabel emailLabel = new JLabel("Nhập email:");
        emailField = new JTextField(20); // Set preferred column width for the text field
        sendButton = new JButton("Gửi email khôi phục");

        // Add email label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.anchor = GridBagConstraints.EAST;
        add(emailLabel, gbc);

        // Add email text field
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        add(emailField, gbc);

        // Add send button
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(sendButton, gbc);

        // Xử lý sự kiện khi nhấn nút gửi
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(PasswordResetForm.this,
                            "Vui lòng nhập email.",
                            "Thông báo",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    String htmlFilePath = "/Users/m1lt43/Desktop/QuanLyBanDienThoai/src/main/java/Layout/models/BackEnd/Services/email-content.html";
                    String codeVerify = EmailService.generateCode(); // Lưu mã xác thực
                    boolean success = EmailService.sendEmail(email, "Cấp lại tài khoản", htmlFilePath, codeVerify);
                    if (success) {
                        JOptionPane.showMessageDialog(PasswordResetForm.this,
                                "Email đã được gửi thành công!",
                                "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                        // Mở frame nhập mã xác thực
                        new CodeVerificationForm(codeVerify);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(PasswordResetForm.this,
                                "Đã xảy ra lỗi khi gửi email.",
                                "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new PasswordResetForm();
    }
}
