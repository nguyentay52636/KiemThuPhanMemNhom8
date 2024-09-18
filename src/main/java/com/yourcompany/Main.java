package com.yourcompany;

import javax.swing.UnsupportedLookAndFeelException;

import Layout.models.FrontEnd.FormLogin.FormLogin;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                .getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        new FormLogin().setVisible(true);
    }
}
//

// src/main/java/com/yourcompnay/