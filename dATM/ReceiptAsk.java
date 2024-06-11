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
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReceiptAsk {

    private JFrame frame;
    private JPanel bgPane;
    private BufferedImage backgroundImage;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	ReceiptAsk window = new ReceiptAsk();
                    window.frame.setVisible(true);
                    window.frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ReceiptAsk() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Deposit Dashboard");
        frame.setBounds(100, 100, 1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load background image
        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\bg.png"));
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
        frame.setContentPane(bgPane);
        bgPane.setLayout(null);

        // Custom panel for logo image
        JPanel logoPanel = new ImagePanel("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\Dangal ATM Dashboard.png");
        logoPanel.setBounds(350, 80, 250, 100);
        bgPane.add(logoPanel);

        JPanel DepositDashboardInfoPane = new JPanel();
        DepositDashboardInfoPane.setBackground(new Color(255, 255, 255));
        DepositDashboardInfoPane.setBounds(45, 238, 930, 480);
        bgPane.add(DepositDashboardInfoPane);
        DepositDashboardInfoPane.setLayout(null);

        JButton yesBtn = new JButton("YES");
        yesBtn.setForeground(new Color(255, 255, 255));
        yesBtn.setBackground(new Color(0, 128, 0));
        yesBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        yesBtn.setBounds(712, 271, 135, 63);
        DepositDashboardInfoPane.add(yesBtn);

        JLabel askLabel = new JLabel("DO YOU WANT A RECEIPT?");
        askLabel.setBounds(35, 39, 597, 73);
        DepositDashboardInfoPane.add(askLabel);
        askLabel.setHorizontalAlignment(SwingConstants.CENTER);
        askLabel.setFont(new Font("Tahoma", Font.BOLD, 40));

        JLabel balanceLbl = new JLabel(" ");
        balanceLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
        balanceLbl.setBounds(662, 87, 258, 25);
        DepositDashboardInfoPane.add(balanceLbl);

        JLabel NameLbl = new JLabel(" ");
        NameLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
        NameLbl.setBounds(260, 115, 135, 25);
        DepositDashboardInfoPane.add(NameLbl);

        JLabel NumberLbl = new JLabel(" ");
        NumberLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
        NumberLbl.setBounds(238, 144, 135, 25);
        DepositDashboardInfoPane.add(NumberLbl);

        JButton noBtn = new JButton("NO");
        noBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action for NO button
            }
        });
        noBtn.setForeground(new Color(240, 255, 255));
        noBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        noBtn.setBackground(new Color(0, 128, 0));
        noBtn.setBounds(712, 367, 135, 63);
        DepositDashboardInfoPane.add(noBtn);

        JTextPane infoText = new JTextPane();
        infoText.setFont(new Font("Monospaced", Font.PLAIN, 18));
        infoText.setText("Skip the receipt and help reduce waste.\nEach receipt declined saves paper and ink, reducing landfill waste and chemical pollution. Join us in this small step towards a more sustainable future. Next time, just say \"No receipt, please!\"");

        // Justify the text
        StyledDocument doc = infoText.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_JUSTIFIED);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        infoText.setBounds(76, 146, 458, 242);
        infoText.setEditable(false);
        DepositDashboardInfoPane.add(infoText);
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
