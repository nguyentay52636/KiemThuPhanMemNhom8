package Layout.models.FrontEnd.ThongKeCharGoogle.google;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

public class WebPanel extends JPanel {

    private JFXPanel panel = new JFXPanel();
    private WebView webView;

    public WebPanel() {
        setLayout(new BorderLayout()); // Sử dụng BorderLayout cho JPanel
        setBackground(Color.WHITE);
        add(panel, BorderLayout.CENTER);
    }

    public void load(String content) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (webView == null) {
                    webView = new WebView();
                    panel.setScene(new Scene(webView));
                }
                webView.getEngine().loadContent(content);
                repaint();
                revalidate();
            }
        });
    }
}
