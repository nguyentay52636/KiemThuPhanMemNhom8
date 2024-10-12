/*
 * Created by JFormDesigner on Sat Apr 20 12:24:48 ICT 2024
 */

package Layout.models.FrontEnd.NavBar;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Layout.models.BackEnd.BUS.AccountBUS;
import Layout.models.FrontEnd.FormAccount.FormAccount;
import Layout.models.FrontEnd.FormBanHang.FormSell;
import Layout.models.FrontEnd.FormCustomer.FormKhachHang;
import Layout.models.FrontEnd.FormCustomer.FormKhachHangDisableButton;
import Layout.models.FrontEnd.FormHello.BeginForm;
import Layout.models.FrontEnd.FormInvoice.FormInvoice;
import Layout.models.FrontEnd.FormInvoice.FormInvoiceDisableButton;
import Layout.models.FrontEnd.FormLogin.FormLogin;
import Layout.models.FrontEnd.FormNhapHang.FormNhapHang;
import Layout.models.FrontEnd.FormPermission.FormPermission;
import Layout.models.FrontEnd.FormPhieuNhap.FormPhieuNhap;
import Layout.models.FrontEnd.FormPhieuNhap.FormPhieuNhapDisableButton;
import Layout.models.FrontEnd.FormProduct.DisplayProduct;
import Layout.models.FrontEnd.FormProduct.DisplayProductDisableButton;
import Layout.models.FrontEnd.FormPromotion.FormKhuyenMai;
import Layout.models.FrontEnd.FormPromotion.FormKhuyenMaiDisableButton;
import Layout.models.FrontEnd.FormStaff.DisplayStaff;
import Layout.models.FrontEnd.FormStaff.DisplayStaffDisableButton;
import Layout.models.FrontEnd.FormSupplier.DisplaySupplier;
import Layout.models.FrontEnd.FormSupplier.DisplaySupplierDisableButton;
import Layout.models.FrontEnd.FormTypeProduct.FormTypeProduct;
import Layout.models.FrontEnd.FormTypeProduct.FormTypeProductDisableButton;
import Layout.models.FrontEnd.ThongKe.ThongKeForm;

/**
 * @author master
 */
public class NewNavBar extends JPanel {
    // private FormSell formSell;
    private String chiTietQuyen;
    // private FormInvoice formInvoice = new FormInvoice();

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel lastClickedPanel = null;
    private Color lastPanelOriginalColor = null;
    private Color lastLabelOriginalColor = null;
    private JLabel lastClickedLabel = null;
    Color mainColor = new Color(0x2B2B2B);

    DisplayProduct displayProduct;
    DisplayProductDisableButton displayProductDisableButton;
    // Hello hello = new Hello();

    FormInvoice formInvoice;
    FormSell formSell;

    FormPhieuNhap formPhieuNhap;
    FormNhapHang formNhapHang;

    FormTypeProduct formTypeProduct;
    FormTypeProductDisableButton formTypeProductDisableButton;

    FormKhuyenMai formKhuyenMai;
    FormKhuyenMaiDisableButton formKhuyenMaiDisableButton;

    FormKhachHang formKhachHang;
    FormKhachHangDisableButton formKhachHangDisableButton;

    DisplayStaff displayStaff;
    DisplayStaffDisableButton displayStaffDisableButton;

    FormAccount formAccount = new FormAccount();

    FormInvoiceDisableButton formInvoiceDisableButton;

    FormPhieuNhapDisableButton formPhieuNhapDisableButton;

    FormPermission formPermission;
    DisplaySupplier displaySupplier;
    DisplaySupplierDisableButton displaySupplierDisableButton;

    ThongKeForm formThongKe;

    public void setChiTietQuyen(String chiTietQuyen) {
        this.chiTietQuyen = chiTietQuyen;
    }

    public NewNavBar() {
        formSell = new FormSell(formInvoice);
        initComponents();
        add(cardPanel, BorderLayout.CENTER);
    }

    public FormSell getFormSell() {
        return formSell;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Master
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel7 = new JPanel();
        label20 = new JLabel();
        panel6 = new JPanel();
        panel8 = new JPanel();
        panel9 = new JPanel();
        panel10 = new JPanel();
        label1 = new JLabel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        panel11 = new JPanel();
        panel12 = new JPanel();
        label4 = new JLabel();
        panel13 = new JPanel();
        label5 = new JLabel();
        panel14 = new JPanel();
        label6 = new JLabel();
        panel15 = new JPanel();
        label7 = new JLabel();
        panel16 = new JPanel();
        label8 = new JLabel();
        panel17 = new JPanel();
        label9 = new JLabel();
        panel18 = new JPanel();
        label10 = new JLabel();
        panel19 = new JPanel();
        label11 = new JLabel();
        panel20 = new JPanel();
        label12 = new JLabel();
        panel21 = new JPanel();
        label13 = new JLabel();
        panel22 = new JPanel();
        label14 = new JLabel();
        panel23 = new JPanel();
        label15 = new JLabel();
        panel24 = new JPanel();
        label16 = new JLabel();
        panel25 = new JPanel();
        label17 = new JLabel();
        panel26 = new JPanel();
        label18 = new JLabel();
        setCustomCursorAndHoverEffect(panel4);
        setCustomCursorAndHoverEffect(panel5);
        setCustomCursorAndHoverEffect(panel7);
        setCustomCursorAndHoverEffect(panel6);
        setCustomCursorAndHoverEffect(panel8);
        setCustomCursorAndHoverEffect(panel9);
        setCustomCursorAndHoverEffect(panel10);
        setCustomCursorAndHoverEffect(panel11);
        setCustomCursorAndHoverEffect(panel12);
        setCustomCursorAndHoverEffect(panel13);
        setCustomCursorAndHoverEffect(panel14);
        setCustomCursorAndHoverEffect(panel15);
        setCustomCursorAndHoverEffect(panel16);
        setCustomCursorAndHoverEffect(panel17);
        setCustomCursorAndHoverEffect(panel18);
        setCustomCursorAndHoverEffect(panel19);
        setCustomCursorAndHoverEffect(panel20);
        setCustomCursorAndHoverEffect(panel21);
        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border
                .EmptyBorder(0,0,0,0), "",javax.swing.border.TitledBorder.CENTER,javax
                .swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,
                12),java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans
                .PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".equals(e.
                getPropertyName()))throw new RuntimeException();}});
        setLayout(new BorderLayout());

        //======== panel4 ========
        {
            panel4.setLayout(new BorderLayout());

            //======== panel5 ========
            {
                panel5.setForeground(Color.black);
                panel5.setBackground(mainColor);
                panel5.setLayout(new FlowLayout());

                //======== panel7 ========
                {
                    panel7.setForeground(Color.white);
                    panel7.setBackground(mainColor);
                    panel7.setLayout(new FlowLayout());

                    //---- label20 ----
                    label20.setText("text");
                    panel7.add(label20);
                }
                panel5.add(panel7);
            }
            panel4.add(panel5, BorderLayout.NORTH);
        }
        add(panel4, BorderLayout.CENTER);

        //======== panel6 ========
        {
            panel6.setBackground(mainColor);
            panel6.setLayout(new BoxLayout(panel6, BoxLayout.Y_AXIS));

            //======== panel8 ========
            {
                panel8.setBackground(mainColor);
                panel8.setLayout(new BorderLayout());

                //======== panel9 ========
                {
                    panel9.setBackground(mainColor);
                    panel9.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //======== panel10 ========
                    {
                        panel10.setBackground(mainColor);
                        panel10.setLayout(new FlowLayout());

                        //---- label1 ----
                        label1.setText("");
                        label1.setIcon(new ImageIcon(getClass().getResource("/images/icons8_exit_30px.png")));
                        label1.setForeground(Color.white);
                        label1.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        panel10.add(label1);

                        //---- label3 ----
                        label3.setIcon(new ImageIcon(getClass().getResource("/images/icons8_settings_30px_1.png")));
                        label3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        panel10.add(label3);
                    }
                    panel9.add(panel10);
                }
                panel8.add(panel9, BorderLayout.NORTH);

                //======== scrollPane1 ========
                {
                    scrollPane1.setBackground(mainColor);

                    //======== panel11 ========
                    {
                        panel11.setBackground(mainColor);
                        panel11.setFocusCycleRoot(true);
                        panel11.setFocusTraversalPolicyProvider(true);
                        panel11.setLayout(new GridBagLayout());
//                        panel11.setPreferredSize(new Dimension(200, 600));
                        ((GridBagLayout)panel11.getLayout()).columnWidths = new int[] {232, 0};
                        ((GridBagLayout)panel11.getLayout()).rowHeights = new int[] {22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        ((GridBagLayout)panel11.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
                        ((GridBagLayout)panel11.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                        //======== panel12 ========
                        {
                            panel12.setBackground(mainColor);
                            panel12.setForeground(Color.white);
                            panel12.setFocusCycleRoot(true);
                            panel12.setFocusTraversalPolicyProvider(true);
                            panel12.setLayout(new FlowLayout(FlowLayout.LEFT));

                            //---- label4 ----
                            label4.setText("B\u00e1n h\u00e0ng");
                            label4.setIcon(new ImageIcon(getClass().getResource("/images/icons8_small_business_30px_3.png")));
                            label4.setForeground(new Color(0xcccccc));
                            label4.setVerticalAlignment(SwingConstants.CENTER);
                            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 6f));
                            panel12.add(label4);
                        }
                        panel11.add(panel12, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 0), 0, 0));

                        //======== panel13 ========
                        {
                            panel13.setBackground(mainColor);
                            panel13.setLayout(new FlowLayout(FlowLayout.LEFT));

                            //---- label5 ----
                            label5.setText("Nh\u1eadp h\u00e0ng");
                            label5.setIcon(new ImageIcon(getClass().getResource("/images/icons8_downloads_30px.png")));
                            label5.setForeground(new Color(0xcccccc));
                            label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 6f));
                            panel13.add(label5);
                        }
                        panel11.add(panel13, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 0), 0, 0));

                        //======== panel14 ========
                        {
                            panel14.setBackground(mainColor);
                            panel14.setFocusCycleRoot(true);
                            panel14.setFocusTraversalPolicyProvider(true);
                            panel14.setLayout(new FlowLayout(FlowLayout.LEFT));

                            //---- label6 ----
                            label6.setText("S\u1ea3n ph\u1ea9m");
                            label6.setIcon(new ImageIcon(getClass().getResource("/images/icons8_multiple_smartphones_30px.png")));
                            label6.setForeground(new Color(0xcccccc));
                            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 6f));
                            panel14.add(label6);
                        }
                        panel11.add(panel14, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 0), 0, 0));

                        //======== panel15 ========
                        {
                            panel15.setBackground(mainColor);
                            panel15.setLayout(new FlowLayout(FlowLayout.LEFT));

                            //---- label7 ----
                            label7.setText("Lo\u1ea1i s\u1ea3n ph\u1ea9m");
                            label7.setIcon(new ImageIcon(getClass().getResource("/images/icons8_dossier_folder_30px.png")));
                            label7.setForeground(new Color(0xcccccc));
                            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 6f));
                            panel15.add(label7);
                        }
                        panel11.add(panel15, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 0), 0, 0));

                        //======== panel16 ========
                        {
                            panel16.setBackground(mainColor);
                            panel16.setForeground(new Color(0xcccccc));
                            panel16.setLayout(new FlowLayout(FlowLayout.LEFT));

                            //---- label8 ----
                            label8.setText("H\u00f3a \u0111\u01a1n");
                            label8.setIcon(new ImageIcon(getClass().getResource("/images/icons8_agreement_30px.png")));
                            label8.setForeground(new Color(0xcccccc));
                            label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 6f));
                            panel16.add(label8);
                        }
                        panel11.add(panel16, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 0), 0, 0));

                        //======== panel17 ========
                        {
                            panel17.setBackground(mainColor);
                            panel17.setLayout(new FlowLayout(FlowLayout.LEFT));

                            //---- label9 ----
                            label9.setText("Phi\u1ebfu nh\u1eadp");
                            label9.setIcon(new ImageIcon(getClass().getResource("/images/icons8_truck_30px.png")));
                            label9.setForeground(new Color(0xcccccc));
                            label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 6f));
                            panel17.add(label9);
                        }
                        panel11.add(panel17, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 0), 0, 0));

                        //======== panel18 ========
                        {
                            panel18.setBackground(mainColor);
                            panel18.setLayout(new FlowLayout(FlowLayout.LEFT));

                            //---- label10 ----
                            label10.setText("Khuy\u1ebfn m\u00e3i");
                            label10.setIcon(new ImageIcon(getClass().getResource("/images/icons8_gift_30px.png")));
                            label10.setForeground(new Color(0xcccccc));
                            label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 6f));
                            panel18.add(label10);
                        }
                        panel11.add(panel18, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 0), 0, 0));

                        //======== panel19 ========
                        {
                            panel19.setBackground(mainColor);
                            panel19.setLayout(new FlowLayout(FlowLayout.LEFT));

                            //---- label11 ----
                            label11.setText("Nh\u00e2n vi\u00ean");
                            label11.setIcon(new ImageIcon(getClass().getResource("/images/icons8_assistant_30px.png")));
                            label11.setForeground(new Color(0xcccccc));
                            label11.setFont(label11.getFont().deriveFont(label11.getFont().getSize() + 6f));
                            panel19.add(label11);
                        }
                        panel11.add(panel19, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 0), 0, 0));

                        //======== panel20 ========
                        {
                            panel20.setBackground(mainColor);
                            panel20.setLayout(new FlowLayout(FlowLayout.LEFT));

                            //---- label12 ----
                            label12.setText("Kh\u00e1ch h\u00e0ng");
                            label12.setIcon(new ImageIcon(getClass().getResource("/images/icons8_user_30px.png")));
                            label12.setForeground(new Color(0xcccccc));
                            label12.setFont(label12.getFont().deriveFont(label12.getFont().getSize() + 6f));
                            panel20.add(label12);
                        }
                        panel11.add(panel20, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 0), 0, 0));

                        //======== panel21 ========
                        {
                            panel21.setBackground(mainColor);
                            panel21.setLayout(new FlowLayout(FlowLayout.LEFT));

                            //---- label13 ----
                            label13.setText("Nh\u00e0 cung c\u1ea5p");
                            label13.setIcon(new ImageIcon(getClass().getResource("/images/icons8_company_30px.png")));
                            label13.setForeground(new Color(0xcccccc));
                            label13.setFont(label13.getFont().deriveFont(label13.getFont().getSize() + 6f));
                            panel21.add(label13);
                        }
                        panel11.add(panel21, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 0), 0, 0));

                        //======== panel22 ========
                        {
                            panel22.setBackground(mainColor);
                            panel22.setLayout(new FlowLayout(FlowLayout.LEFT));

                            //---- label14 ----
                            label14.setText("T\u00e0i kho\u1ea3n");
                            label14.setIcon(new ImageIcon(getClass().getResource("/images/icons8_key_30px.png")));
                            label14.setForeground(new Color(0xcccccc));
                            label14.setFont(label14.getFont().deriveFont(label14.getFont().getSize() + 6f));
                            panel22.add(label14);
                        }
                        panel11.add(panel22, new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 0), 0, 0));

                        //======== panel23 ========
                        {
                            panel23.setBackground(mainColor);
                            panel23.setLayout(new FlowLayout(FlowLayout.LEFT));

                            //---- label15 ----
                            label15.setText("Quy\u1ec1n");
                            label15.setIcon(new ImageIcon(getClass().getResource("/images/icons8_police_badge_30px.png")));
                            label15.setForeground(new Color(0xcccccc));
                            label15.setFont(label15.getFont().deriveFont(label15.getFont().getSize() + 6f));
                            panel23.add(label15);
                        }
                        panel11.add(panel23, new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 0), 0, 0));

                        //======== panel24 ========
                        {
                            panel24.setBackground(mainColor);
                            panel24.setLayout(new FlowLayout(FlowLayout.LEFT));

                            //---- label16 ----
                            label16.setText("Th\u1ed1ng k\u00ea");
                            label16.setIcon(new ImageIcon(getClass().getResource("/images/icons8_bar_chart_30px.png")));
                            label16.setForeground(new Color(0xcccccc));
                            label16.setFont(label16.getFont().deriveFont(label16.getFont().getSize() + 6f));
                            panel24.add(label16);
                        }
                        panel11.add(panel24, new GridBagConstraints(0, 12, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 0), 0, 0));

                        //======== panel25 ========
                        {
                            panel25.setBackground(mainColor);
                            panel25.setLayout(new FlowLayout(FlowLayout.LEFT));

                            //---- label17 ----
                            label17.setText("C\u00f4ng c\u1ee5");
                            label17.setIcon(new ImageIcon(getClass().getResource("/images/icons8_maintenance_30px.png")));
                            label17.setForeground(new Color(0xcccccc));
                            label17.setFont(label17.getFont().deriveFont(label17.getFont().getSize() + 6f));
                            panel25.add(label17);
                        }
                        panel11.add(panel25, new GridBagConstraints(0, 13, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 0), 0, 0));

                        //======== panel26 ========
                        {
                            panel26.setBackground(mainColor);
                            panel26.setLayout(new FlowLayout(FlowLayout.LEFT));

                            //---- label18 ----
                            label18.setText("C\u00e0i \u0111\u1eb7t");
                            label18.setIcon(new ImageIcon(getClass().getResource("/images/icons8_settings_30px.png")));
                            label18.setForeground(new Color(0xcccccc));
                            label18.setFont(label18.getFont().deriveFont(label18.getFont().getSize() + 6f));
                            panel26.add(label18);
                        }
                        panel11.add(panel26, new GridBagConstraints(0, 14, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 0), 0, 0));
                    }
                    scrollPane1.setViewportView(panel11);
                }
                panel8.add(scrollPane1, BorderLayout.CENTER);
            }
            panel6.add(panel8);
        }
        add(panel6, BorderLayout.WEST);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        // set size for panel
        Dimension sizePanel = new Dimension(250, 60);
        panel12.setPreferredSize(sizePanel);
        panel13.setPreferredSize(sizePanel);
        panel14.setPreferredSize(sizePanel);
        panel15.setPreferredSize(sizePanel);
        panel16.setPreferredSize(sizePanel);
        panel17.setPreferredSize(sizePanel);
        panel18.setPreferredSize(sizePanel);
        panel19.setPreferredSize(sizePanel);
        panel20.setPreferredSize(sizePanel);
        panel21.setPreferredSize(sizePanel);
        panel22.setPreferredSize(sizePanel);
        panel23.setPreferredSize(sizePanel);
        panel24.setPreferredSize(sizePanel);
        panel25.setPreferredSize(sizePanel);
        panel26.setPreferredSize(sizePanel);

        // su kien khi dang xuat
        label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất?", "Xác nhận",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    SwingUtilities.getWindowAncestor(label1).setVisible(false);
                    FormLogin formLogin = new FormLogin();
                    formLogin.setVisible(true);
                }
            }
        });
        label3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String username = AccountBUS.getCurrentUsername();
                if (username != null && !username.isEmpty()) {
                    FormChangePassword formChangePassword = new FormChangePassword(username);
                    formChangePassword.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No user is currently logged in.");
                }
            }
        });
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        String username = AccountBUS.getCurrentUsername();
        cardPanel.add(new BeginForm("Chào " + AccountBUS.getCurrentUsername()), BorderLayout.CENTER);
        ;

        formSell = new FormSell(formInvoice);
        cardPanel.add(formSell, "formSell");

        formNhapHang = new FormNhapHang(formPhieuNhap);
        cardPanel.add(formNhapHang, "FormNhapHang");

        cardPanel.add(formAccount, "FormAccount");

        // them su kien khi nhan vao panel de chuyer background
        panel24.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (lastClickedPanel != null) {
                    lastClickedPanel.setBackground(lastPanelOriginalColor);
                    lastClickedLabel.setForeground(lastLabelOriginalColor);
                }
                lastClickedPanel = panel24;
                lastPanelOriginalColor = panel24.getBackground();
                lastClickedLabel = label16;
                lastLabelOriginalColor = label16.getForeground();
                panel24.setBackground(Color.WHITE);
                label16.setForeground(Color.BLACK);
                formThongKe = new ThongKeForm();
                cardPanel.add(formThongKe.getPanel(), "ThongKe");
                cardLayout.show(cardPanel, "ThongKe");
            }
        });
        panel25.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (lastClickedPanel != null) {
                    lastClickedPanel.setBackground(lastPanelOriginalColor);
                    lastClickedLabel.setForeground(lastLabelOriginalColor);
                }
                lastClickedPanel = panel25;
                lastPanelOriginalColor = panel25.getBackground();
                lastClickedLabel = label17;
                lastLabelOriginalColor = label17.getForeground();
                panel25.setBackground(Color.WHITE);
                label17.setForeground(Color.BLACK);
            }
        });
        panel26.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (lastClickedPanel != null) {
                    lastClickedPanel.setBackground(lastPanelOriginalColor);
                    lastClickedLabel.setForeground(lastLabelOriginalColor);
                }
                lastClickedPanel = panel26;
                lastPanelOriginalColor = panel26.getBackground();
                lastClickedLabel = label18;
                lastLabelOriginalColor = label18.getForeground();
                panel26.setBackground(Color.WHITE);
                label18.setForeground(Color.BLACK);
            }
        });
    }

    public JLabel getLabel1() {
        return label1;
    }

    // ẩn các panel
    public void hidePanel() {
        panel12.setVisible(false);
        panel13.setVisible(false);
        panel14.setVisible(false);
        panel15.setVisible(false);
        panel16.setVisible(false);
        panel17.setVisible(false);
        panel18.setVisible(false);
        panel19.setVisible(false);
        panel20.setVisible(false);
        panel21.setVisible(false);
        panel22.setVisible(false);
        panel23.setVisible(false);
        panel25.setVisible(false);
        panel26.setVisible(false);
    }

    // hien thi ra cac panel tuong ung voi chi tiet quyen
    public void updatePanelVisibility(String chiTietQuyen) {

        hidePanel();

        String[] permissions = chiTietQuyen.split(" ");
        System.out.println("Permission: " + Arrays.toString(permissions));

        // // duyet qua mang permission
        for (String permission : permissions) {
            if ("quanlybanhang".equals(permission)) {
                panel12.setVisible(true);
                panel12.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel12;
                        lastPanelOriginalColor = panel12.getBackground();
                        lastClickedLabel = label4;
                        lastLabelOriginalColor = label4.getForeground();
                        panel12.setBackground(Color.WHITE);
                        label4.setForeground(Color.BLACK);

                        formSell.refresh();

                        cardLayout.show(cardPanel, "formSell");
                    }
                });
            }
            if ("quanlynhaphang".equals(permission)) {
                panel13.setVisible(true);
                panel13.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel13;
                        lastPanelOriginalColor = panel13.getBackground();
                        lastClickedLabel = label5;
                        lastLabelOriginalColor = label5.getForeground();
                        panel13.setBackground(Color.WHITE);
                        label5.setForeground(Color.BLACK);

                        formNhapHang.refresh();

                        cardLayout.show(cardPanel, "FormNhapHang");
                    }
                });
            }
            if ("xemsanpham".equals(permission)) {
                panel14.setVisible(true);
                panel14.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel14;
                        lastPanelOriginalColor = panel14.getBackground();
                        lastClickedLabel = label6;
                        lastLabelOriginalColor = label6.getForeground();
                        panel14.setBackground(Color.WHITE);
                        label6.setForeground(Color.BLACK);

                        displayProductDisableButton = new DisplayProductDisableButton();
                        cardPanel.add(displayProductDisableButton.getPanel_disable(), "FormSanPham_disable");
                        cardLayout.show(cardPanel, "FormSanPham_disable");
                    }
                });
            }
            if ("quanlysanpham".equals(permission))

            {
                panel14.setVisible(true);
                panel14.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel14;
                        lastPanelOriginalColor = panel14.getBackground();
                        lastClickedLabel = label6;
                        lastLabelOriginalColor = label6.getForeground();
                        panel14.setBackground(Color.WHITE);
                        label6.setForeground(Color.BLACK);

                        displayProductDisableButton = new DisplayProductDisableButton();
                        cardPanel.add(displayProductDisableButton.getPanel(), "FormSanPham");

                        cardLayout.show(cardPanel, "FormSanPham");
                    }
                });
            }
            if ("quanlynhanvien".equals(permission)) {
                panel19.setVisible(true);
                panel19.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel19;
                        lastPanelOriginalColor = panel19.getBackground();
                        lastClickedLabel = label11;
                        lastLabelOriginalColor = label11.getForeground();
                        panel19.setBackground(Color.WHITE);
                        label11.setForeground(Color.BLACK);

                        displayStaffDisableButton = new DisplayStaffDisableButton();
                        cardPanel.add(displayStaffDisableButton.getPanel(), "FormNhanVien");

                        cardLayout.show(cardPanel, "FormNhanVien");
                    }
                });
            }
            if ("xemnhanvien".equals(permission)) {
                panel19.setVisible(true);
                panel19.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel19;
                        lastPanelOriginalColor = panel19.getBackground();
                        lastClickedLabel = label11;
                        lastLabelOriginalColor = label11.getForeground();
                        panel19.setBackground(Color.WHITE);
                        label11.setForeground(Color.BLACK);

                        displayStaff = new DisplayStaff();
                        cardPanel.add(displayStaff.getPanel_disable(), "FormNhanVien_disable");

                        cardLayout.show(cardPanel, "FormNhanVien_disable");
                    }
                });
            }
            if ("quanlyloaisanpham".equals(permission)) {
                panel15.setVisible(true);
                panel15.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel15;
                        lastPanelOriginalColor = panel15.getBackground();
                        lastClickedLabel = label7;
                        lastLabelOriginalColor = label7.getForeground();
                        panel15.setBackground(Color.WHITE);
                        label7.setForeground(Color.BLACK);

                        formTypeProduct = new FormTypeProduct();
                        cardPanel.add(formTypeProduct, "FormTypeProduct");

                        cardLayout.show(cardPanel, "FormTypeProduct");
                    }
                });
            }
            if ("xemloaisanpham".equals(permission)) {
                panel15.setVisible(true);
                panel15.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel15;
                        lastPanelOriginalColor = panel15.getBackground();
                        lastClickedLabel = label7;
                        lastLabelOriginalColor = label7.getForeground();
                        panel15.setBackground(Color.WHITE);
                        label7.setForeground(Color.BLACK);

                        formTypeProductDisableButton = new FormTypeProductDisableButton();
                        cardPanel.add(formTypeProductDisableButton, "FormTypeProductDisableButton");

                        cardLayout.show(cardPanel, "FormTypeProductDisableButton");
                    }
                });
            }
            if ("quanlyhoadon".equals(permission)) {
                panel16.setVisible(true);
                panel16.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel16;
                        lastPanelOriginalColor = panel16.getBackground();
                        lastClickedLabel = label8;
                        lastLabelOriginalColor = label8.getForeground();
                        panel16.setBackground(Color.WHITE);
                        label8.setForeground(Color.BLACK);

                        formInvoice = new FormInvoice();
                        cardPanel.add(formInvoice, "FormInvoice");

                        cardLayout.show(cardPanel, "FormInvoice");
                    }
                });
            }
            if ("xemhoadon".equals(permission)) {
                panel16.setVisible(true);
                panel16.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel16;
                        lastPanelOriginalColor = panel16.getBackground();
                        lastClickedLabel = label8;
                        lastLabelOriginalColor = label8.getForeground();
                        panel16.setBackground(Color.WHITE);
                        label8.setForeground(Color.BLACK);

                        formInvoiceDisableButton = new FormInvoiceDisableButton();
                        cardPanel.add(formInvoiceDisableButton, "FormInvoiceDisableButton");

                        cardLayout.show(cardPanel, "FormInvoiceDisableButton");
                    }
                });
            }
            if ("quanlyphieunhap".equals(permission)) {
                panel17.setVisible(true);
                panel17.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel17;
                        lastPanelOriginalColor = panel17.getBackground();
                        lastClickedLabel = label9;
                        lastLabelOriginalColor = label9.getForeground();
                        panel17.setBackground(Color.WHITE);
                        label9.setForeground(Color.BLACK);

                        formPhieuNhap = new FormPhieuNhap();
                        cardPanel.add(formPhieuNhap, "FormPhieuNhap");

                        cardLayout.show(cardPanel, "FormPhieuNhap");
                    }
                });
            }
            if ("xemphieunhap".equals(permission)) {
                panel17.setVisible(true);
                panel17.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel17;
                        lastPanelOriginalColor = panel17.getBackground();
                        lastClickedLabel = label9;
                        lastLabelOriginalColor = label9.getForeground();
                        panel17.setBackground(Color.WHITE);
                        label9.setForeground(Color.BLACK);

                        formPhieuNhapDisableButton = new FormPhieuNhapDisableButton();
                        cardPanel.add(formPhieuNhapDisableButton, "FormPhieuNhapDisableButton");

                        cardLayout.show(cardPanel, "FormPhieuNhapDisableButton");
                    }
                });
            }
            if ("quanlykhuyenmai".equals(permission)) {
                panel18.setVisible(true);
                panel18.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel18;
                        lastPanelOriginalColor = panel18.getBackground();
                        lastClickedLabel = label10;
                        lastLabelOriginalColor = label10.getForeground();
                        panel18.setBackground(Color.WHITE);
                        label10.setForeground(Color.BLACK);

                        formKhuyenMai = new FormKhuyenMai();
                        cardPanel.add(formKhuyenMai, "FormKhuyenMai");

                        cardLayout.show(cardPanel, "FormKhuyenMai");
                    }
                });
            }
            if ("quanlyquyen".equals(permission)) {
                panel23.setVisible(true);
                panel23.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel23;
                        lastPanelOriginalColor = panel23.getBackground();
                        lastClickedLabel = label15;
                        lastLabelOriginalColor = label15.getForeground();
                        panel23.setBackground(Color.WHITE);
                        label15.setForeground(Color.BLACK);

                        formPermission = new FormPermission();
                        cardPanel.add(formPermission, "FormPermission");

                        cardLayout.show(cardPanel, "FormPermission");
                    }
                });
            }
            if ("quanlytaikhoan".equals(permission)) {
                panel22.setVisible(true);
                panel22.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel22;
                        lastPanelOriginalColor = panel22.getBackground();
                        lastClickedLabel = label14;
                        lastLabelOriginalColor = label14.getForeground();
                        panel22.setBackground(Color.WHITE);
                        label14.setForeground(Color.BLACK);

                        cardLayout.show(cardPanel, "FormAccount");
                    }
                });
            }
            if ("xemnhacungcap".equals(permission)) {
                panel21.setVisible(true);
                panel21.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel21;
                        lastPanelOriginalColor = panel21.getBackground();
                        lastClickedLabel = label13;
                        lastLabelOriginalColor = label13.getForeground();
                        panel21.setBackground(Color.WHITE);
                        label13.setForeground(Color.BLACK);

                        displaySupplier = new DisplaySupplier();
                        cardPanel.add(displaySupplier.getPanel_disable(), "FormNhaCungCap_disable");

                        cardLayout.show(cardPanel, "FormNhaCungCap_disable");
                    }
                });
            }
            if ("quanlynhacungcap".equals(permission)) {
                panel21.setVisible(true);
                panel21.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel21;
                        lastPanelOriginalColor = panel21.getBackground();
                        lastClickedLabel = label13;
                        lastLabelOriginalColor = label13.getForeground();
                        panel21.setBackground(Color.WHITE);
                        label13.setForeground(Color.BLACK);
                        displaySupplierDisableButton = new DisplaySupplierDisableButton();
                        cardPanel.add(displaySupplierDisableButton.getPanel(), "FormNhaCungCap");

                        cardLayout.show(cardPanel, "FormNhaCungCap");
                    }
                });
            }
            if ("xemkhachhang".equals(permission)) {
                panel20.setVisible(true);
                panel20.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel20;
                        lastPanelOriginalColor = panel20.getBackground();
                        lastClickedLabel = label12;
                        lastLabelOriginalColor = label12.getForeground();
                        panel20.setBackground(Color.WHITE);
                        label12.setForeground(Color.BLACK);

                        formKhuyenMaiDisableButton = new FormKhuyenMaiDisableButton();
                        cardPanel.add(formKhachHangDisableButton, "FormKhachHangDisableButton");

                        cardLayout.show(cardPanel, "FormKhachHangDisableButton");
                    }
                });
            }
            if ("quanlykhachhang".equals(permission)) {
                panel20.setVisible(true);
                panel20.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel20;
                        lastPanelOriginalColor = panel20.getBackground();
                        lastClickedLabel = label12;
                        lastLabelOriginalColor = label12.getForeground();
                        panel20.setBackground(Color.WHITE);
                        label12.setForeground(Color.BLACK);

                        formKhachHang = new FormKhachHang();
                        cardPanel.add(formKhachHang, "FormKhachHang");

                        cardLayout.show(cardPanel, "FormKhachHang");
                    }
                });
            }
            if ("xemkhuyenmai".equals(permission)) {
                panel18.setVisible(true);
                panel18.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (lastClickedPanel != null) {
                            lastClickedPanel.setBackground(lastPanelOriginalColor);
                            lastClickedLabel.setForeground(lastLabelOriginalColor);
                        }
                        lastClickedPanel = panel18;
                        lastPanelOriginalColor = panel18.getBackground();
                        lastClickedLabel = label10;
                        lastLabelOriginalColor = label10.getForeground();
                        panel18.setBackground(Color.WHITE);
                        label10.setForeground(Color.BLACK);

                        formKhuyenMaiDisableButton = new FormKhuyenMaiDisableButton();
                        cardPanel.add(formKhuyenMaiDisableButton, "FormKhuyenMaiDisableButton");

                        cardLayout.show(cardPanel, "FormKhuyenMaiDisableButton");
                    }
                });
            }
        }
    }

    private void setCustomCursorAndHoverEffect(JPanel panel) {
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // panel.addMouseListener(new MouseAdapter() {
        // Color originalColor = panel.getBackground();

        // @Override
        // public void mouseEntered(MouseEvent e) {
        // panel.setBackground(Color.BLACK);
        // }

        // @Override
        // public void mouseExited(MouseEvent e) {
        // panel.setBackground(originalColor);
        // }
        // });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Master
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel7;
    private JLabel label20;
    private JPanel panel6;
    private JPanel panel8;
    private JPanel panel9;
    private JPanel panel10;
    private JLabel label1;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JPanel panel11;
    private JPanel panel12;
    private JLabel label4;
    private JPanel panel13;
    private JLabel label5;
    private JPanel panel14;
    private JLabel label6;
    private JPanel panel15;
    private JLabel label7;
    private JPanel panel16;
    private JLabel label8;
    private JPanel panel17;
    private JLabel label9;
    private JPanel panel18;
    private JLabel label10;
    private JPanel panel19;
    private JLabel label11;
    private JPanel panel20;
    private JLabel label12;
    private JPanel panel21;
    private JLabel label13;
    private JPanel panel22;
    private JLabel label14;
    private JPanel panel23;
    private JLabel label15;
    private JPanel panel24;
    private JLabel label16;
    private JPanel panel25;
    private JLabel label17;
    private JPanel panel26;
    private JLabel label18;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}