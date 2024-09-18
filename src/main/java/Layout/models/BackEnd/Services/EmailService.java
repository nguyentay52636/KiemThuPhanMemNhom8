package Layout.models.BackEnd.Services;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class EmailService {
    private static final String USERNAME = System.getenv("EMAIL_USERNAME"); // Đọc từ biến môi trường
    private static final String PASSWORD = System.getenv("EMAIL_PASSWORD"); // Đọc từ biến môi trường

    public static void sendEmail(String to, String subject, String content) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

            // Hiển thị thông báo thành công bằng JOptionPane
            JOptionPane.showMessageDialog(null, "Email đã được gửi thành công!", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (MessagingException e) {
            // Hiển thị thông báo lỗi nếu gửi email thất bại
            JOptionPane.showMessageDialog(null, "Không thể gửi email. Vui lòng thử lại sau.", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // In ra lỗi chi tiết trong log
        }
    }
}
