package Layout.models.FrontEnd.NavBar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPaneExample {
    public static void main(String[] args) {
        // Tạo frame
        JFrame frame = new JFrame("Tabbed Pane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);

        // Tạo JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Tạo các biểu tượng (icon) cho từng tab với đường dẫn cụ thể
        Icon overviewIcon = new ImageIcon("images/icons8_small_business_30px_3.png");
        Icon productIcon = new ImageIcon("images/icons8_box_30px.png");
        Icon employeeIcon = new ImageIcon("images/icons8_employee_30px.png");
        Icon customerIcon = new ImageIcon("images/icons8_customer_30px.png");
        Icon supplierIcon = new ImageIcon("images/icons8_supplier_30px.png");

        // Tạo các panel cho mỗi tab
        JPanel overviewPanel = new JPanel();
        overviewPanel.add(new JLabel("Thống kê tổng quát"));

        JPanel productPanel = new JPanel();
        productPanel.add(new JLabel("Sản phẩm"));

        JPanel employeePanel = new JPanel();
        employeePanel.add(new JLabel("Nhân viên"));

        JPanel customerPanel = new JPanel();
        customerPanel.add(new JLabel("Khách hàng"));

        JPanel supplierPanel = new JPanel();
        supplierPanel.add(new JLabel("Nhà cung cấp"));

        // Thêm các tab vào JTabbedPane với tên và icon
        tabbedPane.addTab("Thống kê tổng quát", overviewIcon, overviewPanel);
        tabbedPane.addTab("Sản phẩm", productIcon, productPanel);
        tabbedPane.addTab("Nhân viên", employeeIcon, employeePanel);
        tabbedPane.addTab("Khách hàng", customerIcon, customerPanel);
        tabbedPane.addTab("Nhà cung cấp", supplierIcon, supplierPanel);

        // Thêm JTabbedPane vào frame
        frame.add(tabbedPane);

        // Hiển thị frame
        frame.setVisible(true);
    }
}