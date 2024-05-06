package GameDisplay;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class StartingMenu extends JFrame {

    private static final int MENU_WIDTH = 800; // Fixed width of the starting menu
    private static final int MENU_HEIGHT = 600; // Fixed height of the starting menu

    public StartingMenu() {
        setTitle("Starting Menu");
        setResizable(false); // Disable window resizing
        setSize(MENU_WIDTH, MENU_HEIGHT);
        setLocationRelativeTo(null);

        // Create a layered pane to hold the background image and buttons
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(MENU_WIDTH, MENU_HEIGHT));

        // Load the background image
        try {
            BufferedImage backgroundImage = ImageIO.read(new File("D:\\Data-Algorithm-Data-Structure-Project\\src\\background.jpeg"));

            // Resize the background image to match the size of the starting menu
            Image scaledImage = backgroundImage.getScaledInstance(MENU_WIDTH, MENU_HEIGHT, Image.SCALE_DEFAULT);

            JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
            backgroundLabel.setBounds(0, 0, MENU_WIDTH, MENU_HEIGHT);
            layeredPane.add(backgroundLabel, Integer.valueOf(0));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Make the panel transparent
        buttonPanel.setLayout(new GridBagLayout());

        JButton startButton = new JButton();
        startButton.setPreferredSize(new Dimension(200, 80)); // Set button size
        startButton.setFocusable(false); // Disable focus border
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setIcon(new ImageIcon("D:\\Data-Algorithm-Data-Structure-Project\\src\\start.png")); // Set image icon
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of the GameFrame
                GameFrame gameFrame = new GameFrame();
                gameFrame.setVisible(true);

                // Hide the starting menu
                StartingMenu.this.setVisible(false);
            }
        });

        JButton exitButton = new JButton();
        exitButton.setPreferredSize(new Dimension(200, 80)); // Set button size
        exitButton.setFocusable(false); // Disable focus border
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        exitButton.setIcon(new ImageIcon("D:\\Data-Algorithm-Data-Structure-Project\\src\\start.png")); // Set image icon
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle exit button action
                System.exit(0);
            }
        });

        // Add the buttons to the button panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0); // Add some vertical spacing between buttons
        buttonPanel.add(startButton, gbc);

        gbc.gridy = 1;
        buttonPanel.add(exitButton, gbc);

        // Set the position of the button panel within the layered pane
        buttonPanel.setBounds(
                (MENU_WIDTH - startButton.getPreferredSize().width) / 2,
                (MENU_HEIGHT - startButton.getPreferredSize().height * 2) / 2,
                startButton.getPreferredSize().width,
                startButton.getPreferredSize().height * 2
        );
        layeredPane.add(buttonPanel, Integer.valueOf(1));

        // Add the layered pane to the content pane
        getContentPane().add(layeredPane);

        // Make sure the layered pane is the preferred size of the frame
        layeredPane.setPreferredSize(new Dimension(MENU_WIDTH, MENU_HEIGHT));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                StartingMenu startingMenu = new StartingMenu();
                startingMenu.setVisible(true);
            }
        });
    }
}