package dATM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LandingPageReal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel bgPane;
    private BufferedImage backgroundImage;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LandingPageReal frame = new LandingPageReal();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public LandingPageReal() {
        setTitle("Deposit Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);

        // Load background image
        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\USER\\dATM\\imgs\\bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Custom JPanel for background image
        bgPane = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        bgPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(bgPane);
        bgPane.setLayout(null);
        
        // Custom panel for logo image
        JPanel logoPanel = new ImagePanel("C:\\Users\\USER\\dATM\\imgs\\Dangal ATM.png");
        logoPanel.setBounds(280, 60, 400, 250);
        bgPane.add(logoPanel);
        
        JButton welcomeBtn = new JButton("Welcome!");
        welcomeBtn.setForeground(new Color(211, 211, 211));
        welcomeBtn.setBackground(new Color(0, 115, 242));
        welcomeBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        welcomeBtn.setBounds(415, 320, 150, 40);
        bgPane.add(welcomeBtn);
    }

    // Custom JPanel class for displaying an image
    class ImagePanel extends JPanel {
        private static final long serialVersionUID = 1L;
        private BufferedImage image;

        public ImagePanel(String imagePath) {
            try {
                image = ImageIO.read(new File(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
