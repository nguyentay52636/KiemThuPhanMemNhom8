package Layout.models.FrontEnd.FormPermission;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Layout.models.BackEnd.BUS.PermissionBUS;
import Layout.models.BackEnd.DTO.Permission;

public class ThemSuaQuyen extends JDialog {
    private boolean isSuccess = false;
    private FormPermission.PermissionAddedListener permissionAddedListener;

    private String title;
    private String maQuyen;
    private FormPermission formPermission;

    String type;
    PermissionBUS qlqBUS = new PermissionBUS();
    Permission qSua;

    JTextField txMaQuyen = new JTextField(15);
    private JTextField txTenQuyen = new JTextField(15);
    ChiTietQuyenForm chitietForm = new ChiTietQuyenForm();

    JButton btnThem = new JButton("Thêm");
    JButton btnSua = new JButton("Sửa");
    JButton btnHuy = new JButton("Hủy");

    // public boolean showDialog() {
    // this.setModal(true);
    // this.setVisible(true);
    // return this.isSuccess;
    // }

    // public void setPermissionListener(FormPermission.PermissionAddedListener
    // listener) {
    // this.permissionAddedListener = listener;
    // }

    public ThemSuaQuyen(String title, String maQuyen, FormPermission formPermission) {
        this.title = title;
        this.maQuyen = maQuyen;
        this.formPermission = formPermission;
        initComponents();
    }

    public void initComponents() {
        this.setLayout(new BorderLayout());
        this.setSize(450, 750);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.type = this.title;

        // inputs
        txMaQuyen.setBorder(BorderFactory.createTitledBorder("Mã quyền"));
        txTenQuyen.setBorder(BorderFactory.createTitledBorder("Tên quyền"));

        JPanel plInput = new JPanel();
        plInput.add(txMaQuyen);
        plInput.add(txTenQuyen);
        plInput.add(chitietForm);

        // panel buttons
        JPanel plButton = new JPanel();

        // 2 case Thêm - Sửa
        if (this.type.equals("Thêm")) {
            this.setTitle("Thêm quyền");
            txMaQuyen.setText(qlqBUS.getNextID());

            btnThem.setIcon(new ImageIcon(this.getClass().getResource("/images/icons8_add_30px.png")));
            plButton.add(btnThem);

        } else {
            this.setTitle("Sửa quyền");
            for (Permission q : qlqBUS.getDsq()) {
                if (q.getMaQuyen().equals(this.maQuyen)) {
                    this.qSua = q;
                }
            }
            if (this.qSua == null) {
                JOptionPane.showMessageDialog(null, "Lỗi, không tìm thấy quyền");
                this.dispose();
            }

            txMaQuyen.setText(this.qSua.getMaQuyen());
            txTenQuyen.setEnabled(false);
            txTenQuyen.setText(this.qSua.getTenQuyen());
            txTenQuyen.setEnabled(false);
            chitietForm.setQuyen(this.qSua.getChiTietQuyen());

            // txMaQuyen.setEditable(false);

            btnSua.setIcon(new ImageIcon(this.getClass().getResource("/images/icons8_support_30px.png")));
            plButton.add(btnSua);
        }

        btnHuy.setIcon(new ImageIcon(this.getClass().getResource("/images/icons8_cancel_30px_1.png")));
        plButton.add(btnHuy);

        this.add(plInput, BorderLayout.CENTER);
        this.add(plButton, BorderLayout.SOUTH);

        // mouse listener
        btnThem.addActionListener((ae) -> {
            btnThemMouseClicked();
        });
        btnSua.addActionListener((ae) -> {
            btnSuaMouseClicked();
        });
        btnHuy.addActionListener((ae) -> {
            this.dispose();
        });

        this.setVisible(true);
    }

    private void btnThemMouseClicked() {
        if (checkEmpty()) {
            String maquyen = txMaQuyen.getText();
            String tenquyen = txTenQuyen.getText();
            String chitietquyen = chitietForm.getQuyen();

            if (qlqBUS.add(maquyen, tenquyen, chitietquyen)) {
                JOptionPane.showMessageDialog(this, "Thêm " + maquyen + " thành công!");
                this.isSuccess = true;
                this.dispose();
            }
        }
        formPermission.refresh();
    }

    private void btnSuaMouseClicked() {
        if (checkEmpty()) {
            String maquyen = txMaQuyen.getText();
            String tenquyen = txTenQuyen.getText();
            String chitietquyen = chitietForm.getQuyen();
            System.out.println(chitietquyen);

            if (qlqBUS.update(maquyen, tenquyen, chitietquyen)) {
                JOptionPane.showMessageDialog(this, "Sửa " + maquyen + " thành công!");
                this.isSuccess = true;
                this.dispose();
            }
        }
        formPermission.refresh();
    }

    private Boolean checkEmpty() {
        String maquyen = txMaQuyen.getText();
        String tenquyen = txTenQuyen.getText();
        String chitietquyen = chitietForm.getQuyen();

        if (maquyen.trim().equals("")) {
            return showErrorTx(txMaQuyen, "Mã quyền không được để trống");

        } else if (tenquyen.trim().equals("")) {
            return showErrorTx(txMaQuyen, "Tên quyền không được để trống");

        } else if (chitietquyen.trim().equals("")) {
            return showErrorTx(txMaQuyen, "Bạn chưa chọn quyền nào cả !!");
        }

        return true;
    }

    private Boolean showErrorTx(JTextField tx, String errorInfo) {
        JOptionPane.showMessageDialog(tx, errorInfo);
        tx.requestFocus();
        return false;
    }
}

class ChiTietQuyenForm extends JPanel {

    final String[] type = { "Chỉ xem", "Xem và Quản lý" };
    ArrayList<PanelChooseQuyen> dsPanel = new ArrayList<>();

    public ChiTietQuyenForm() {
        setPreferredSize(new Dimension(300, 600));
        setLayout(new FlowLayout());
        setBorder(BorderFactory.createTitledBorder("Chi tiết quyền: "));

        dsPanel.add(
                new PanelChooseQuyen("Bán Hàng", new String[] { "Bán hàng," }, new String[] { "quản lý bán hàng," }));
        dsPanel.add(new PanelChooseQuyen("Nhập Hàng", new String[] { "Nhập hàng," },
                new String[] { "quản lý nhập hàng," }));
        dsPanel.add(new PanelChooseQuyen("Sản Phẩm", type, new String[] { "xem sản phẩm,", "quản lý sản phẩm," }));
        dsPanel.add(new PanelChooseQuyen("Loại Sản Phẩm", type,
                new String[] { "xem loại sản phẩm,", "quản lý loại sản phẩm," }));
        dsPanel.add(new PanelChooseQuyen("Hóa Đơn", type, new String[] { "xem hóa đơn,", "quản lý hóa đơn," }));
        dsPanel.add(
                new PanelChooseQuyen("Khuyến Mãi", type, new String[] { "xem khuyến mãi,", "quản lý khuyến mãi," }));
        dsPanel.add(new PanelChooseQuyen("Nhân Viên", type, new String[] { "xem nhân viên,", "quản lý nhân viên," }));
        dsPanel.add(
                new PanelChooseQuyen("Khách Hàng", type, new String[] { "xem khách hàng,", "quản lý khách hàng," }));
        dsPanel.add(
                new PanelChooseQuyen("Phiếu Nhập", type, new String[] { "xem phiếu nhập,", "quản lý phiếu nhập," }));
        dsPanel.add(new PanelChooseQuyen("Nhà Cung Cấp", type,
                new String[] { "xem nhà cung cấp,", "quản lý nhà cung cấp," }));
        dsPanel.add(new PanelChooseQuyen("Tài Khoản", type, new String[] { "xem tài khoản,", "quản lý tài khoản," }));
        dsPanel.add(new PanelChooseQuyen("Quyền", type, new String[] { "xem quyền,", "quản lý quyền," }));

        for (PanelChooseQuyen p : dsPanel) {
            this.add(p);
        }
    }

    public String getQuyen() {
        String result = "";
        for (PanelChooseQuyen p : dsPanel) {
            result += p.getValue();
        }
        return result.trim();
    }

    public void setQuyen(String quyen) {
        for (PanelChooseQuyen p : dsPanel) {
            p.setValue(quyen);
        }
    }
}

class PanelChooseQuyen extends JPanel {

    String name;
    String[] type, value;

    JCheckBox chb;
    JComboBox<String> cb;

    public PanelChooseQuyen(String name, String[] type, String[] value) {
        this.setPreferredSize(new Dimension(250, 50));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        this.name = name;
        this.type = type;
        this.value = value;

        this.chb = new JCheckBox(this.name);
        this.add(this.chb);

        this.cb = new JComboBox<>(this.type);
        this.cb.setEnabled(false);
        this.add(this.cb);

        chb.addActionListener((ae) -> {
            if (chb.isSelected()) {
                this.cb.setEnabled(true);
            } else {
                this.cb.setEnabled(false);
            }
        });
    }

    public String getValue() {
        String result = "";

        if (chb.isSelected()) {
            result += " " + value[cb.getSelectedIndex()];
        }

        return result;
    }

    public void setValue(String s) {
        if (s.equals("")) {
            chb.setSelected(false);
            return;
        }

        for (int i = 0; i < value.length; i++) {
            if (s.contains(value[i])) {
                cb.setSelectedIndex(i);
                cb.setEnabled(true);
                chb.setSelected(true);
            }
        }
    }
}
