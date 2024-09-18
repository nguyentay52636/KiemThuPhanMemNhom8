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

public class CodeVerificationForm extends JFrame {

    private JTextField codeField; // Ô nhập mã xác thực
    private JButton verifyButton; // Nút xác minh mã
    private String codeVerify; // Mã xác thực đã gửi

    public CodeVerificationForm(String codeVerify) {
        this.codeVerify = codeVerify; // Lưu mã xác thực được truyền vào từ frame trước

        setTitle("Xác minh mã");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Khởi tạo các thành phần
        JLabel codeLabel = new JLabel("Nhập mã xác thực:");
        codeField = new JTextField(6); // Ô nhập mã xác thực (6 chữ số)
        verifyButton = new JButton("Xác minh mã");

        // Add code label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(codeLabel, gbc);

        // Add code text field
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(codeField, gbc);

        // Add verify button
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(verifyButton, gbc);

        // Xử lý sự kiện khi nhấn nút xác minh mã
        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputCode = codeField.getText();
                if (inputCode.equals(codeVerify)) {
                    JOptionPane.showMessageDialog(CodeVerificationForm.this,
                            "Mã xác thực đúng. Bạn có thể đặt lại mật khẩu.",
                            "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE);
                    new PasswordResetUI().setVisible(true);

                    dispose(); // Đóng cửa sổ sau khi mã xác thực thành công
                } else {
                    JOptionPane.showMessageDialog(CodeVerificationForm.this,
                            "Mã xác thực không đúng. Vui lòng thử lại.",
                            "Lỗi",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }
}
