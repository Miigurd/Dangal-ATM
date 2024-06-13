package dATM;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ActivateAccount extends JFrame {

    private static final long serialVersionUID = 1L;
    private JFrame frame;
    private JPanel ActivateAccountPane;
    private BufferedImage backgroundImage;
    private JTextField nameTextField;
//    private Dashboard dashboard;
//    private Database database;
//    private Balance balance;
    
    private String[] header = {"STUDENT NUMBER", "FIRST NAME", "LAST NAME"};
	private String[][] data = {{"2300650", "MAG-USARA, KIRT ASIA", "69420.00"},
							   {"2300649", "FATAL, MOISES JR.", "42690.00"},
							   {"2300646", "FARINAS, JORICK CHRISTIAN", "10000.00"},
							   {"2300640", "ESCUZAR, EMIEL JAMES", "20000.00"},
							   {"2302745", "PEGA, JEDE ISAIAH MAXWEIL", "30000.00"}};
	private JTextField studNumTxtField;
	private JTextField pinTxtField;
	
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ActivateAccount frame = new ActivateAccount();
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
    public ActivateAccount() {
        setTitle("Dangal ATM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);

        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\USER\\dATM\\imgs\\bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Background panel
        ActivateAccountPane = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        ActivateAccountPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(ActivateAccountPane);
        ActivateAccountPane.setLayout(null);
        
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(SystemColor.control);
        loginPanel.setBounds(46, 71, 410, 634);
        ActivateAccountPane.add(loginPanel);
        loginPanel.setLayout(null);
        
        // Custom panel for logo image
        JPanel logoPanel = new ImagePanel("C:\\Users\\USER\\dATM\\imgs\\Dangal ATM.png");
        logoPanel.setBounds(55, 80, 310, 100);
        loginPanel.add(logoPanel);
        
        JLabel customerLabel = new JLabel("Activate Account");
        customerLabel.setForeground(new Color(46, 139, 87));
        customerLabel.setFont(new Font("Poppins", Font.BOLD, 25));
        customerLabel.setBackground(Color.GREEN);
        customerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        customerLabel.setBounds(31, 221, 352, 31);
        loginPanel.add(customerLabel);
        
        // Custom panel with rounded corners
        JPanel cuslblPane = new RoundedPanel(30); 
        cuslblPane.setBackground(new Color(144, 238, 144));
        cuslblPane.setBounds(31, 210, 350, 53);
        loginPanel.add(cuslblPane);
        
        
        
        nameTextField = new JTextField();
       
        nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        nameTextField.setHorizontalAlignment(SwingConstants.CENTER);
        nameTextField.setBounds(128, 294, 241, 31);
        loginPanel.add(nameTextField);
        nameTextField.setColumns(10);
        
        JButton loginBTN = new RoundedButton("Activate");
        loginBTN.setBackground(new Color(102, 255, 102));
        loginBTN.setBounds(130, 470, 136, 40);
        loginPanel.add(loginBTN);	
        
        JLabel lblNewLabel = new JLabel("Enter Your Name :");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel.setBounds(10, 294, 122, 31);
        loginPanel.add(lblNewLabel);
        
        studNumTxtField = new JTextField();
        studNumTxtField.setHorizontalAlignment(SwingConstants.CENTER);
        studNumTxtField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        studNumTxtField.setColumns(10);
        studNumTxtField.setBounds(128, 349, 241, 31);
        loginPanel.add(studNumTxtField);
        
        JLabel studNumLbl = new JLabel("Student Number :");
        studNumLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
        studNumLbl.setBounds(10, 349, 122, 31);
        loginPanel.add(studNumLbl);
        
        pinTxtField = new JTextField();
        pinTxtField.setHorizontalAlignment(SwingConstants.CENTER);
        pinTxtField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pinTxtField.setColumns(10);
        pinTxtField.setBounds(128, 403, 241, 31);
        loginPanel.add(pinTxtField);
        
        JLabel pinLbl = new JLabel("Enter Your Pin :");
        pinLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
        pinLbl.setBounds(10, 403, 108, 31);
        loginPanel.add(pinLbl);
        
        
        
        //Events
        loginBTN.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		for(int i = 0; i <= data[0].length; i++) {
        			if(nameTextField.getText().equals(data[i][0])) {
            			ActivateAccount.this.dispose();
//            			dashboard = new Dashboard(data[i]);
//                    	dashboard.setVisible(true);
//                    	dashboard.setLocationRelativeTo(null);
                    	
        			}
        			
        		}
        		nameTextField.setText(null);
        	}
        });
        	
        nameTextField.addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent e) {
        	   if(e.getKeyCode() == e.VK_ENTER) {
        		   for(int i = 0; i <= data[0].length; i++) {
           			if(nameTextField.getText().equals(data[i][0])) {
               			ActivateAccount.this.dispose();
//               			dashboard = new Dashboard(data[i]);
//                       	dashboard.setVisible(true);
//                       	dashboard.setLocationRelativeTo(null);
           			}
           			
           		}
           		nameTextField.setText(null);
        	   }
            	}
            });	
        
    }

    // Custom JPanel class with rounded corners
    class RoundedPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        private int cornerRadius;

        public RoundedPanel(int radius) {
            super();
            this.cornerRadius = radius;
            setOpaque(false); // To ensure the background is transparent
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        }
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

    // Custom JButton class with rounded corners
    class RoundedButton extends JButton {
        private static final long serialVersionUID = 1L;
        
        public RoundedButton(String text) {
            super(text);
            setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            super.paintComponent(g2);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getForeground());
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
            g2.dispose();
        }

        @Override
        public boolean contains(int x, int y) {
            int width = getWidth();
            int height = getHeight();
            int arcWidth = 30;
            int arcHeight = 30;
            return new RoundRectangle2D.Float(0, 0, width, height, arcWidth, arcHeight).contains(x, y);
        }
    }
}