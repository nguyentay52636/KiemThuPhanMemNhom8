/*
 * Created by JFormDesigner on Sat Apr 13 22:14:26 ICT 2024
 */

package Layout.models.FrontEnd.FormLogin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.prefs.Preferences;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Layout.models.BackEnd.BUS.AccountBUS;
import Layout.models.BackEnd.BUS.StaffBUS;
import Layout.models.BackEnd.ConnectDataBasee.ConnectionDB;
import Layout.models.BackEnd.DAO.AccountDAO;
import Layout.models.BackEnd.DTO.Account;
import Layout.models.BackEnd.DTO.Staff;
import Layout.models.FrontEnd.FormBanHang.FormSell;
import Layout.models.FrontEnd.FormInvoice.FormInvoice;
import Layout.models.FrontEnd.MainFrame.MainFrame;
import Layout.models.FrontEnd.NavBar.NewNavBar;

/**
 * @author m1lt43
 */
public class FormLogin extends JFrame {
    private Preferences prefs;
    private NewNavBar newNavBar;
    private FormInvoice formInvoice = new FormInvoice();
    private FormSell formSell = new FormSell(formInvoice);
    private String maQuyen; // biến thành viên để lư MaQuyen
    private String chiTietQuyen; // bien thanh vien de luu chi tiet quyen
    public static String loggedInMaNV;

    public String getChiTietQuyen() {
        return chiTietQuyen;
    }

    public FormLogin() {
        //
        prefs = Preferences.userNodeForPackage(FormLogin.class);
        setUndecorated(true);
        initComponents();
        // pack();
    }

    private void showPasswordMouseClicked(MouseEvent e) {
        // Đặt EchoChar của JPasswordField thành 0 để hiển thị mật khẩu
        txtPassword.setEchoChar((char) 0);
        // Ẩn biểu tượng cho mật khẩu đã hiển thị
        showPassword.setVisible(false);
        showPassword.setEnabled(false);
        // Hiển thị biểu tượng cho mật khẩu đã che
        hiddenPassword.setVisible(true);
        hiddenPassword.setEnabled(true);
    }

    private void hiddenPasswordMouseClicked(MouseEvent e) {
        // Đặt EchoChar của JPasswordField thành '*' để che mật khẩu
        txtPassword.setEchoChar('*');
        // Hiển thị biểu tượng cho mật khẩu đã che
        showPassword.setVisible(true);
        showPassword.setEnabled(true);
        // Ẩn biểu tượng cho mật khẩu đã hiển thị
        hiddenPassword.setVisible(false);
        hiddenPassword.setEnabled(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Teddy
        this2 = new JPanel();
        panel1 = new JPanel();
        label1 = new JLabel();
        panel2 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        panel3 = new JPanel();
        userNameLabel = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        passwordLabel = new JLabel();
        label9 = new JLabel();
        showPassword = new JLabel();
        checkBox1 = new JCheckBox();
        label10 = new JLabel();
        label11 = new JLabel();
        btnLogin = new JButton();
        txtuserName = new JTextField();
        txtPassword = new JPasswordField();
        hiddenPassword = new JLabel();
        IconClose = new JLabel();
//        currentFormSell = new FormSell();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== this2 ========
        {
//            this2.setBackground(new Color(0xcccccc));
            this2.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax .
                    swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e" , javax. swing .border
                    . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069al\u006fg"
                    , java .awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,this2. getBorder
                    () ) ); this2. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java
                                                                                                                                                         . beans. PropertyChangeEvent e) { if( "\u0062or\u0064er" .equals ( e. getPropertyName () ) )throw new RuntimeException
                ( ) ;} } );
            this2.setLayout(null);

            //======== panel1 ========
            {
//                panel1.setBackground(new Color(0xdfe1e5));
                panel1.setLayout(new BorderLayout());

                //---- label1 ----
                label1.setText("");
                label1.setIcon(new ImageIcon(getClass().getResource("/images/content.jpg")));
//                label1.setIcon(new ImageIcon(getClass().getResource("/images/bg-login.png")));
                label1.setFont(new Font("Inter", Font.PLAIN, 16));
//                label1.setPreferredSize(new Dimension(200, 50));
                panel1.add(label1, BorderLayout.CENTER);
            }
            this2.add(panel1);
            panel1.setBounds(0, 0, 515, 585);

            //======== panel2 ========
            {
                panel2.setBackground(new Color(0x2B2B2B));
                panel2.setFont(new Font("Inter", Font.PLAIN, 18));
                panel2.setLayout(null);

                //---- label2 ----
                label2.setText("Đăng nhập");
                label2.setHorizontalAlignment(SwingConstants.CENTER);
                label2.setFont(new Font("Luminari", Font.BOLD| Font.ITALIC, 28));
                label2.setForeground(new Color(255, 255, 255, 203));
                label2.setIconTextGap(10);
                panel2.add(label2);
                label2.setBounds(5, 95, 560, 50);

                //---- label3 ----
                label3.setText("CỬA HÀNG ĐIỆN THOẠI");
                label3.setFont(new Font("Kokonor", Font.ITALIC, 16));
                label3.setForeground(new Color(255, 255, 255, 203));
                label3.setHorizontalAlignment(SwingConstants.CENTER);
                panel2.add(label3);
                label3.setBounds(55, 160, 465, 30);

                //======== panel3 ========
                {
                    panel3.setAutoscrolls(true);
                    panel3.setBackground(new Color(0x2B2B2B));
                    panel3.setForeground(new Color(0x0066ff));
                    panel3.setLayout(null);

                    //---- userNameLabel ----
                    userNameLabel.setText("Tên người dùng");
                    userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    userNameLabel.setFont(new Font("Inter", Font.BOLD, 13));
                    userNameLabel.setForeground((new Color(255, 255, 255, 203)));
                    panel3.add(userNameLabel);
                    userNameLabel.setBounds(45, 70, 200, 40);

                    //---- label5 ----
                    label5.setText("____________________________________________________");
                    label5.setBackground(Color.white);
                    label5.setForeground((new Color(255, 255, 255, 203)));
                    panel3.add(label5);
                    label5.setBounds(90, 115, 330, 30);

                    //---- label6 ----
                    label6.setIcon(new ImageIcon(getClass().getResource("/images/icons8_user_20px_1.png")));
                    label6.setHorizontalAlignment(SwingConstants.CENTER);
                    label6.setIconTextGap(5);
                    label6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panel3.add(label6);
                    label6.setBounds(425, 95, 35, 35);

                    //---- passwordLabel ----
                    passwordLabel.setText("Mật khẩu");
                    passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    passwordLabel.setFont(new Font("Inter", Font.BOLD, 13));
                    passwordLabel.setForeground((new Color(255, 255, 255, 203)));
                    panel3.add(passwordLabel);
                    passwordLabel.setBounds(72, 135, 105, 40);

                    //---- label9 ----
                    label9.setBackground(Color.white);
                    label9.setText("_____________________________________________________");
                    label9.setForeground((new Color(255, 255, 255, 203)));
                    panel3.add(label9);
                    label9.setBounds(90, 175, 335, 35);

                    //---- showPassword ----
                    showPassword.setText("text");
                    showPassword.setIcon(new ImageIcon(getClass().getResource("/images/icons8_invisible_20px_1.png")));
                    showPassword.setFont(new Font("Inter", Font.PLAIN, 12));
                    showPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    showPassword.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            showPasswordMouseClicked(e);
                        }
                    });
                    panel3.add(showPassword);
                    showPassword.setBounds(435, 160, 25, 35);

                    //---- checkBox1 ----
                    checkBox1.setText("Giữ đăng nhập");
                    checkBox1.setBackground(new Color(0x2B2B2B));
                    checkBox1.setAutoscrolls(true);
                    checkBox1.setHorizontalAlignment(SwingConstants.LEFT);
                    checkBox1.setFont(new Font("Inter", Font.BOLD, 13));
                    checkBox1.setForeground((new Color(255, 255, 255, 203)));
                    panel3.add(checkBox1);
                    checkBox1.setBounds(90, 210, 155, checkBox1.getPreferredSize().height);
                    // luu ten user va password
                    txtuserName.setText(prefs.get("username", ""));
                    txtuserName.setForeground((new Color(255, 255, 255, 203)));
                    txtPassword.setText(prefs.get("password", ""));
                    txtPassword.setForeground((new Color(255, 255, 255, 203)));
                    checkBox1.setSelected(prefs.getBoolean("keepLoggedIn", false));

                    //---- label10 ----
                    label10.setText("Quên mật khẩu ?");
                    label10.setFont(new Font("Inter", Font.BOLD, 13));
                    label10.setForeground((new Color(255, 255, 255, 203)));
                    label10.setHorizontalAlignment(SwingConstants.CENTER);
                    label10.setIconTextGap(5);
                    label10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panel3.add(label10);
                    label10.setBounds(320, 210, 130, label10.getPreferredSize().height);

                    //---- label11 ----
                    label11.setText("Let Go !!!");
                    label11.setIconTextGap(6);
                    label11.setFont(new Font("Luminari", Font.BOLD, 21));
                    label11.setHorizontalAlignment(SwingConstants.CENTER);
                    label11.setForeground((new Color(255, 255, 255, 203)));
                    panel3.add(label11);
                    label11.setBounds(180, 10, 165, label11.getPreferredSize().height);

                    //---- btnLogin ----
                    btnLogin.setText("ĐĂNG NHẬP");
                    btnLogin.setBackground((new Color(56, 112, 176, 255)));
                    btnLogin.setForeground(new Color(255, 255, 255)); // Màu chữ trắng

                    btnLogin.setFont(new Font("Oriya MN", Font.BOLD, 18));
                    btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    panel3.add(btnLogin);
                    btnLogin.setBounds(90, 255, 335, 40);

                    //---- txtuserName ----
                    txtuserName.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                    txtuserName.setDisabledTextColor(new Color(0x2B2B2B));
                    txtuserName.setSelectionColor(new Color(0x2B2B2B));
                    txtuserName.setBackground(new Color(0x2B2B2B));
                    txtuserName.setBorder(null);
                    panel3.add(txtuserName);
                    txtuserName.setBounds(90, 95, 335, 35);

                    //---- txtPassword ----
                    txtPassword.setBackground(new Color(0x2B2B2B));
                    txtPassword.setBorder(null);
                    panel3.add(txtPassword);
                    txtPassword.setBounds(90, 160, 335, 35);

                    //---- hiddenPassword ----
                    hiddenPassword.setText("text");
                    hiddenPassword.setIcon(new ImageIcon(getClass().getResource("/images/icons8_eye_20px_1.png")));
                    hiddenPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    hiddenPassword.setEnabled(false);
                    hiddenPassword.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            hiddenPasswordMouseClicked(e);
                        }
                    });
                    panel3.add(hiddenPassword);
                    hiddenPassword.setBounds(435, 160, 25, 35);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel3.getComponentCount(); i++) {
                            Rectangle bounds = panel3.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel3.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel3.setMinimumSize(preferredSize);
                        panel3.setPreferredSize(preferredSize);
                    }
                }
                panel2.add(panel3);
                panel3.setBounds(30, 205, 510, 345);

                //---- IconClose ----
                IconClose.setText("X");
                IconClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                IconClose.setBackground(new Color(0xff0033));
                IconClose.setForeground(Color.white);
                IconClose.setHorizontalAlignment(SwingConstants.CENTER);
                IconClose.setFont(new Font("Inter", Font.BOLD, 18));
                IconClose.setBorder(BorderFactory.createEmptyBorder());
                panel2.add(IconClose);
                IconClose.setBounds(535, 0, 29, 30);
            }
            this2.add(panel2);
            panel2.setBounds(515, 0, 565, 585);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < this2.getComponentCount(); i++) {
                    Rectangle bounds = this2.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = this2.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                this2.setMinimumSize(preferredSize);
                this2.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(this2);
        this2.setBounds(0, 0, 1080, 555);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        IconClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        // su kien khi nhan vao nut dang nhap, giu dang nhap
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String username = txtuserName.getText();
                String password = new String(txtPassword.getPassword());

                // kiem tra username va password khong duoc trong
                if (username.trim().isEmpty() && password.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tên đăng nhập và mật khẩu không được để trống");
                    return;
                } else if (username.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tên đăng nhập không được để trống");
                    return;
                } else if (password.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống");
                    return;
                }

                // kiem tra trang thai cua nhan vien
                AccountBUS qltk = new AccountBUS();
                Account tk = qltk.getTaiKhoan(username);

                if (tk != null) {
                    StaffBUS staffBUS = new StaffBUS();
                    Staff staff = staffBUS.getStaff(tk.getMaNV());
                    if (staff.getTrangThai() == 1) {
                        JOptionPane.showMessageDialog(null,
                                "Tài khoản này đã bị khóa, do chủ nhân tài khoản này đã bị Ẩn khỏi hệ thống");
                        return;
                    }
                }

                AccountDAO accountDAO = new AccountDAO();
                ArrayList<Account> accounts = accountDAO.readDB();

                boolean isLoginSuccessful = false;
                boolean isUsernameExit = false;
                for (Account account : accounts) {
                    if (account.getUsername().equals(username)) {
                        isUsernameExit = true;
                        if (account.getPassword().equals(password)) {
                            isLoginSuccessful = true;
                        }
                        break;
                    }
                }

                if (isLoginSuccessful) {
                    if (checkBox1.isSelected()) {
                        prefs.put("username", username);
                        prefs.put("password", password);
                        prefs.putBoolean("keepLoggedIn", true);
                    } else {
                        prefs.remove("username");
                        prefs.remove("password");
                        prefs.putBoolean("keepLoggedIn", false);
                    }

                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công");

                    // Set the current username
                    AccountBUS.setCurrentUsername(username);

                    // lay thong tin nhan vien tu tai khoan da dang nhap
                    StaffBUS staffBUS = new StaffBUS();
                    Staff staff = staffBUS.getStaff(tk.getMaNV());
                    loggedInMaNV = tk.getMaNV();

                    formSell.setNhanVien(staff.getTenNV());

                    // luu MaQuyen vào biến thành viên
                    maQuyen = tk.getMaQuyen();

                    // truy van ChiTietQuyen tu bang permission
                    ConnectionDB connectionDB = new ConnectionDB();
                    chiTietQuyen = connectionDB.getUserPermissionDetailsFromDatabase(maQuyen);
                    System.out.println("Chi tiet quyen: " + chiTietQuyen);

                    newNavBar = new NewNavBar();
                    newNavBar.setChiTietQuyen(chiTietQuyen);
                    // hien thi cac panel tuong ung voi ChiTietQuyen
                    newNavBar.updatePanelVisibility(chiTietQuyen);

                    // render giao dien MainFrame
                    MainFrame mainFrame = new MainFrame(newNavBar);
                    // dat ten nhan vien vao label1
                    if (staff != null) {
                        mainFrame.getNavBar().getLabel1().setText(staff.getTenNV());
                        System.out.println("Ten nhan vien: " + staff.getTenNV() + " - " + staff.getMaNV());
                    } else {

                    }
                    mainFrame.setVisible(true);
                    // dong form login
                    FormLogin.this.setVisible(false);
                } else {
                    if (isUsernameExit) {
                        JOptionPane.showMessageDialog(null, "Mật khẩu không đúng");
                    } else {
                        JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại");
                    }
                }
            }
        });
        label10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new PasswordResetForm().setVisible(true);

            }
        });
        // sự kiện khi nhấn enter
        txtPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnLogin.doClick();
                }
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Teddy
    private JPanel this2;
    private JPanel panel1;
    private JLabel label1;
    private JPanel panel2;
    private JLabel label2;
    private JLabel label3;
    private JPanel panel3;
    private JLabel userNameLabel;
    private JLabel label5;
    private JLabel label6;
    private JLabel passwordLabel;
    private JLabel label9;
    private JLabel showPassword;
    private JCheckBox checkBox1;
    private JLabel label10;
    private JLabel label11;
    private JButton btnLogin;
    private JTextField txtuserName;
    private JPasswordField txtPassword;
    private JLabel hiddenPassword;
    private JLabel IconClose;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
