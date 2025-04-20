package org.crossbrowsertesting.herokuapp;
import javax.swing.*;

public class BuildFrame {
    public static String serverFrame() {
        String[] options = {"drag_and_drop", "dropdown", "dynamic_content", "dynamic_controls","dynamic_loading"};
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
            case 0 -> "drag_and_drop";
            case 1 -> "dropdown";
            case 2 -> "dynamic_content";
            case 3 -> "dynamic_controls";
            case 4 -> "dynamic_loading";
            default -> null; // Cancel or closed
        };
    }
}
