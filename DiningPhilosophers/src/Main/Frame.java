package Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {
        setTitle("My Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 400));

        // Create a toolbar and add it to the frame
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false); // Make the toolbar non-draggable
        toolbar.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add some padding
        toolbar.setBackground(new Color(66, 133, 244)); // Change the background color
        add(toolbar, BorderLayout.PAGE_START);

        // Add the start button to the left side of the toolbar
        JButton startButton = new JButton("Start");
        startButton.setFocusPainted(false); // Remove the focus border
        startButton.setToolTipText("Start the process"); // Add a tooltip
        startButton.setBorderPainted(false); // Remove the border
        startButton.setBackground(new Color(66, 133, 244)); // Change the background color
        startButton.setForeground(new Color(255, 255, 255)); // Change the text color
        startButton.addMouseListener(new ButtonHoverEffect()); // Add a hover effect
        toolbar.add(startButton);

        // Add the stop button to the left side of the toolbar
        JButton stopButton = new JButton("Stop");
        stopButton.setFocusPainted(false); // Remove the focus border
        stopButton.setToolTipText("Stop the process"); // Add a tooltip
        stopButton.setBorderPainted(false); // Remove the border
        stopButton.setBackground(new Color(66, 133, 244)); // Change the background color
        stopButton.setForeground(new Color(255, 255, 255)); // Change the text color
        stopButton.addMouseListener(new ButtonHoverEffect()); // Add a hover effect
        toolbar.add(stopButton);

        // Add a spacer to the right side of the toolbar to move the dropdown to the
        // right
        toolbar.add(Box.createHorizontalGlue());

        // Create the dropdown menu and add it to the right side of the toolbar
        String[] options = { "1 per second", "3 per second", "5 per second", "10 per second" };
        JComboBox<String> ticksPerSecondDropdown = new JComboBox<>(options);
        ticksPerSecondDropdown.setMaximumSize(new Dimension(120, 30)); // Limit the size of the dropdown
        ticksPerSecondDropdown.setFocusable(false); // Remove the focus border
        ticksPerSecondDropdown.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 1)); // Add a border
        ticksPerSecondDropdown.setBackground(new Color(66, 133, 244)); // Change the background color
        ticksPerSecondDropdown.setForeground(new Color(255, 255, 255)); // Change the text color
        ticksPerSecondDropdown.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,
                        cellHasFocus);
                if (isSelected) {
                    renderer.setBackground(new Color(200, 220, 255));
                } else {
                    renderer.setBackground(new Color(66, 133, 244));
                }
                return renderer;
            }
        });
        toolbar.add(ticksPerSecondDropdown);
    }
}
