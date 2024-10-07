package Layout.models.FrontEnd.FormProduct;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class IconCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        // Nếu giá trị là một ImageIcon
        if (value instanceof ImageIcon) {
            JLabel label = new JLabel((ImageIcon) value); // Tạo nhãn chứa biểu tượng
            label.setHorizontalAlignment(JLabel.CENTER); // Căn giữa hình ảnh trong ô
            return label; // Trả về nhãn để hiển thị trong ô
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}