package Layout.models.FrontEnd.ThongKe.DashBoardForm.components.ChildComponents;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author DELL
 */
public class RefreshButton extends JButton {

    public RefreshButton() {
        this.setText("Làm mới");
        this.setIcon(new ImageIcon(this.getClass().getResource("/images/icons8_data_backup_30px.png")));
    }
}
