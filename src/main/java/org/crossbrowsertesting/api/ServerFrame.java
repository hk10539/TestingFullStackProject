package org.crossbrowsertesting.api;

import javax.swing.*;

public class ServerFrame {
    public static String serverFrame() {
        String[] options = {"Dev", "Test", "Demo", "Live"};
        int selection = JOptionPane.showOptionDialog(
                null,
                "Select Server:",
                "Server List",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );

        // Return mapped database name as String
        return switch (selection) {
            case 0 -> "springboot_dev";
            case 1 -> "springboot_test";
            case 2 -> "springboot_demo";
            case 3 -> "springboot_live";
            default -> null; // Cancel or closed
        };
    }
}
