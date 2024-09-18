package Layout.models.FrontEnd.MainFrame;

import Layout.models.FrontEnd.FormBanHang.FormSell;
import Layout.models.FrontEnd.FormHello.Hello;
import Layout.models.FrontEnd.NavBar.NewNavBar;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private NewNavBar navBar;
//    private Hello hello;


    public MainFrame(NewNavBar navBar) {
        this.navBar = navBar;
        String title = "CỬA HÀNG QUẢN LÝ BÁN ĐIỆN THOẠI";
        String formattedTitle = String.format("%" + (50 + title.length()) + "s", title);
        setTitle(formattedTitle);
//        navBar = new NewNavBar();
//        hello = new Hello();

        setLayout(new BorderLayout());

        // add the navbar to the frame
        getContentPane().add(navBar);
        getContentPane().removeAll();
        getContentPane().add(navBar, BorderLayout.CENTER);
        getContentPane().revalidate();
        getContentPane().repaint();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1750, 900);
        setLocationRelativeTo(null);

        setMinimumSize(new Dimension(900, 700));
    }

    public NewNavBar getNavBar() {
        return navBar;
    }
}