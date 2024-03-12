package Layout.models.FrontEnd.FormDisplay;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LoginForm extends JFrame {
        private JButton btnDangNhap;
        private JLabel lbAva;
        private JLabel lbHeader;
        private JLabel lbImgPass;
        private JLabel lbImgUser;
        private JPanel plDangNhap;
        private JPanel plForm;
        private JPanel plHeader;
        private JPanel plInput;
        private JRadioButton rbNhoMatKhau;
        private JPasswordField txMatKhau;
        private JTextField txTenDangNhap;
        private JButton btnDangXuat;

        public LoginForm() {

                setTitle("Đăng nhập");
                setSize(800, 600);
                ImageIcon logo = new ImageIcon(
                                getClass().getResource("../../../images/icons8_windows_phone_store_30px.png"));
                setIconImage(logo.getImage());
                initComponents();
                // setUndecorated(true);
                this.setLocationRelativeTo(null);

        }

        private void initComponents() {

                plForm = new JPanel();
                plDangNhap = new JPanel();
                btnDangNhap = new JButton();
                plInput = new JPanel();
                rbNhoMatKhau = new JRadioButton();
                txTenDangNhap = new JTextField();
                lbImgPass = new JLabel();
                lbImgUser = new JLabel();
                txMatKhau = new JPasswordField();
                plHeader = new JPanel();
                lbHeader = new JLabel();
                lbAva = new JLabel();
                btnDangXuat = new JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                plForm.setBackground(new java.awt.Color(51, 51, 51));

                // btnDangNhap.setBackground(new java.awt.Color(0, 204, 102));
                btnDangNhap.setIcon(new ImageIcon(
                                getClass().getResource("../image/button.png")));
                btnDangNhap.setText("Đăng nhập ");
                btnDangNhap.setToolTipText("Đăng nhập vào hệ thống");
                btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {

                        }
                });
                btnDangXuat.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("../../../images/icons8_cancel_30px_1.png")));
                btnDangXuat.setText("Đăng xuất");
                btnDangXuat.setToolTipText("Thoát chương trình");
                btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cancelActionPerformed(evt);
                        }
                });
                JPanel panel = new JPanel(new java.awt.GridLayout(1, 1));
                panel.add(btnDangNhap);
                panel.add(btnDangXuat);
                // Tạo GroupLayout cho panel plDangNhap
                javax.swing.GroupLayout plDangNhapLayout = new javax.swing.GroupLayout(plDangNhap);
                plDangNhap.setLayout(plDangNhapLayout);

                // Thiết lập căn chỉnh theo chiều ngang
                plDangNhapLayout.setHorizontalGroup(
                                plDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(plDangNhapLayout.createSequentialGroup()
                                                                .addComponent(btnDangNhap)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(btnDangXuat)));

                // Thiết lập căn chỉnh theo chiều dọc
                plDangNhapLayout.setVerticalGroup(
                                plDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(plDangNhapLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(plDangNhapLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btnDangNhap)
                                                                                .addComponent(btnDangXuat))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                rbNhoMatKhau.setFont(new java.awt.Font("Dialog", 0, 14));
                rbNhoMatKhau.setText("Giữ đăng nhập");
                rbNhoMatKhau.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {

                        }
                });

                txTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 18));

                lbImgPass.setIcon(
                                new javax.swing.ImageIcon(getClass()
                                                .getResource("../../../images/icons8_password_40px.png")));

                lbImgUser.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource(
                                                "../../../images/icons8_circled_user_male_skin_type_1_2_40px.png")));

                txMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 18));

                javax.swing.GroupLayout plInputLayout = new javax.swing.GroupLayout(plInput);
                plInput.setLayout(plInputLayout);
                plInputLayout.setHorizontalGroup(
                                plInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(plInputLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(lbImgPass)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(plInputLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(plInputLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(rbNhoMatKhau)
                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                .addComponent(txMatKhau))
                                                                .addContainerGap())
                                                .addGroup(plInputLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(plInputLayout.createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addComponent(lbImgUser,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                40,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(txTenDangNhap)
                                                                                .addContainerGap())));
                plInputLayout.setVerticalGroup(
                                plInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plInputLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap(70, Short.MAX_VALUE)
                                                                .addGroup(plInputLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(lbImgPass,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                39,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txMatKhau,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                35,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(14, 14, 14)
                                                                .addComponent(rbNhoMatKhau)
                                                                .addContainerGap())
                                                .addGroup(plInputLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(plInputLayout.createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addGroup(plInputLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(txTenDangNhap,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                36,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(lbImgUser,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                36,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addContainerGap(109,
                                                                                                Short.MAX_VALUE))));

                plHeader.setBackground(new java.awt.Color(0, 0, 0));

                lbHeader.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
                lbHeader.setForeground(new java.awt.Color(255, 255, 255));
                lbHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbHeader.setText("QUẢN LÝ ĐIỆN THOẠI");

                javax.swing.GroupLayout plHeaderLayout = new javax.swing.GroupLayout(plHeader);
                plHeader.setLayout(plHeaderLayout);
                plHeaderLayout.setHorizontalGroup(
                                plHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(plHeaderLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(lbHeader,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                347, Short.MAX_VALUE)
                                                                .addContainerGap()));
                plHeaderLayout.setVerticalGroup(
                                plHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(plHeaderLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(lbHeader,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                41, Short.MAX_VALUE)
                                                                .addContainerGap()));

                lbAva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbAva.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource(
                                                "../../../images"))); // NOI18N

                javax.swing.GroupLayout plFormLayout = new javax.swing.GroupLayout(plForm);
                plForm.setLayout(plFormLayout);
                plFormLayout.setHorizontalGroup(
                                plFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(plDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(plHeader, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(plInput, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addComponent(lbAva, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE));
                plFormLayout.setVerticalGroup(
                                plFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plFormLayout
                                                                .createSequentialGroup()
                                                                .addComponent(plHeader,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lbAva)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(plInput,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(plDangNhap,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(plForm, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(plForm, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE));

                pack();

        }

        public void loginActionPerformed(java.awt.event.ActionEvent event) {

        }

        private void cancelActionPerformed(java.awt.event.ActionEvent event) {
                System.exit(0);
        }

        public static void main(String[] args) {
                new LoginForm().setVisible(true);
                ;
                ;
        }
}
