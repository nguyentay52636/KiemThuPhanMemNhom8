package Layout.models.FrontEnd.MainFrame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class PieChartDemo extends JFrame {

    private JFXPanel javafxPanel;
    private WebEngine webEngine;

    public PieChartDemo() {
        initSwingComponents();
        initFXComponents();
    }

    private void initSwingComponents() {
        // Cài đặt JFrame
        setTitle("Pie Chart with JavaFX WebView");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tạo một panel chứa WebView
        javafxPanel = new JFXPanel();
        add(javafxPanel, BorderLayout.CENTER);
    }

    private void initFXComponents() {
        Platform.runLater(() -> {
            WebView webView = new WebView();
            webEngine = webView.getEngine();

            // Tải file HTML từ đường dẫn hoặc URL
            webEngine.load(getClass().getResource("../ThongKe/components/UIThongkeWeb/index.html").toExternalForm());

            // Thêm WebView vào Scene JavaFX và hiển thị trong JFXPanel
            javafxPanel.setScene(new Scene(webView));
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PieChartDemo demo = new PieChartDemo();
            demo.setVisible(true);
        });
    }
}