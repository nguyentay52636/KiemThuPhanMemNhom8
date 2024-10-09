package Layout.models.FrontEnd.MainFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import Layout.models.FrontEnd.NavBar.NewNavBar;

public class MainFrame extends JFrame {
    private NewNavBar navBar;
    // private Hello hello;

    public MainFrame(NewNavBar navBar) {
        this.navBar = navBar;
        String title = "CỬA HÀNG QUẢN LÝ BÁN ĐIỆN THOẠI";
        String formattedTitle = String.format("%" + (50 + title.length()) + "s", title);
        setTitle(formattedTitle);
        // navBar = new NewNavBar();
        // hello = new Hello();

        setLayout(new BorderLayout());

        // add the navbar to the frame
        getContentPane().add(navBar);
        getContentPane().removeAll();
        getContentPane().add(navBar, BorderLayout.CENTER);
        getContentPane().revalidate();
        getContentPane().repaint();
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1700, 900);
        setLocationRelativeTo(null);
        // setUndecorated(true);
        setMinimumSize(new Dimension(1400, 700));
    }

    public NewNavBar getNavBar() {
        return navBar;
    }
}