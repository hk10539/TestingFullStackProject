package org.crossbrowsertesting.utils;

import javax.swing.*;
import java.awt.*;

public class ServerFrame {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Server List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(2, 2)); // 2 rows x 2 columns
        // Create 4 Play buttons
        JButton playButton1 = new JButton("Dev");
        JButton playButton2 = new JButton("Test");
        JButton playButton3 = new JButton("Demo");
        JButton playButton4 = new JButton("Live");
        // Add buttons to frame
        frame.add(playButton1);
        frame.add(playButton2);
        frame.add(playButton3);
        frame.add(playButton4);
        // Show frame
        frame.setVisible(true);
    }
}

