package com.app.service;

import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;

@Service
public class TaskScheduler {
    private final JFrame frame;
    private final Duration WINDOW_VISIBLE_DURATION = Duration.ofSeconds(20);
    private final Duration APPLICATION_RUNNING_DURATION=Duration.ofMinutes(1);



    public TaskScheduler() {
        System.setProperty("java.awt.headless", "false");
        // Create a JFrame object
        frame = new JFrame("Full-Size GUI Window");
        frame.setAlwaysOnTop(true);


        // Set the default close operation (exit the application when the window is closed)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Get the screen size using the Toolkit class
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Set the size of the frame to match the screen size
        frame.setSize(screenSize.width, screenSize.height);

        // Optional: Maximize the frame to full screen (without the taskbar)
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JLabel label = new JLabel("Give rest to your eyes for " + WINDOW_VISIBLE_DURATION.getSeconds() + " seconds", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        frame.add(label);

        // Optional: Remove the window borders and title bar for a true full-screen effect
        frame.setUndecorated(true);


        // Make the frame visible
        frame.setVisible(false);
    }

    public void scheduleTask() throws InterruptedException {
        while (true) {
           // frame.setVisible(false);
            Thread.sleep(APPLICATION_RUNNING_DURATION.toMillis());
            executeTask();
        }
    }

    private void executeTask() throws InterruptedException {
        frame.setVisible(true);
        Thread.sleep(WINDOW_VISIBLE_DURATION.toMillis());
        frame.setVisible(false);
    }
}
