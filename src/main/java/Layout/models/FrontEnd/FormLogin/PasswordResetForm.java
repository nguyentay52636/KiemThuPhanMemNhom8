package Layout.models.FrontEnd.FormLogin;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PasswordResetForm extends JFrame {

    private JTextField emailField;
    private JButton sendButton;
    private JLabel messageLabel;

    public PasswordResetForm() {
        setTitle("Khôi phục mật khẩu");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Khởi tạo các thành phần
        JLabel emailLabel = new JLabel("Nhập email:");
        emailField = new JTextField();
        sendButton = new JButton("Gửi email khôi phục");
        messageLabel = new JLabel();

        // Thêm các thành phần vào cửa sổ
        add(emailLabel);
        add(emailField);
        add(sendButton);
        add(messageLabel);

        // Xử lý sự kiện khi nhấn nút gửi
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                if (email.isEmpty()) {
                    messageLabel.setText("Vui lòng nhập email.");
                } else {
                    // Gọi phương thức gửi email ở đây
                    boolean success = sendPasswordResetEmail(email);
                    if (success) {
                        messageLabel.setText("Email đã được gửi thành công!");
                    } else {
                        messageLabel.setText("Đã xảy ra lỗi khi gửi email.");
                    }
                }
            }
        });

        setVisible(true);
    }

    // Phương thức gửi email
    private boolean sendPasswordResetEmail(String email) {
        // Thay thế với mã gửi email thực tế
        // Ví dụ: sử dụng dịch vụ gửi email như JavaMail API
        // Đây chỉ là một ví dụ, bạn cần thay đổi nó cho phù hợp với dự án của bạn
        try {
            // Giả lập gửi email thành công
            return true; // Hoặc trả về kết quả thực tế từ dịch vụ gửi email
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}