package dATM;

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
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Balance extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private BufferedImage backgroundImage;
    private JLabel balance;
    private Dashboard dashboard;
    
//    private String[] header = {"STUDENT NUMBER", "FIRST NAME", "LAST NAME"};
//   	private String[][] data = {{"2300650", "MAG-USARA, KIRT ASIA", "69420.00"},
//   							   {"2300649", "FATAL, MOISES JR.", "42690.00"},
//   							   {"2300646", "FARINAS, JORICK CHRISTIAN", "10000.00"},
//   							   {"2300640", "ESCUZAR, EMIEL JAMES", "20000.00"},
//   							   {"2302745", "PEGA, JEDE ISAIAH MAXWEIL", "30000.00"}};
//   	
   	private String account[];
       

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Balance frame = new Balance(new String[]{"", "", ""});
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
    public Balance(String[] account) {
    	this.account = account;
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);

        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        contentPane = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null); // Allow for absolute positioning
        setContentPane(contentPane);

        // Custom panel for logo image
        JPanel logoPanel = new ImagePanel("C:\\Users\\Kirt Asia\\Desktop\\School\\1CS-A\\2nd Sem\\CCS103\\dATM img\\Dangal ATM Dashboard.png");
        logoPanel.setBounds(350, 80, 250, 100);
        contentPane.add(logoPanel);
        
        JPanel checkb = new JPanel();
        checkb.setBackground(new Color(255, 255, 255));
        checkb.setBounds(40, 230, 930, 480);
        contentPane.add(checkb);
        checkb.setLayout(null);
        
        JButton confirm = new JButton("CONFIRM");
        confirm.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        confirm.setForeground(new Color(240, 255, 255));
        confirm.setFont(new Font("Tahoma", Font.BOLD, 20));
        confirm.setBackground(new Color(0, 128, 0));
        confirm.setBounds(703, 376, 135, 63);
        checkb.add(confirm);
        
        JLabel accInfolbl = new JLabel("Account Information: ");
        accInfolbl.setFont(new Font("Tahoma", Font.BOLD, 25));
        accInfolbl.setBounds(73, 61, 336, 33);
        checkb.add(accInfolbl);
        
        JLabel accNamw = new JLabel();
        accNamw.setFont(new Font("Tahoma", Font.BOLD, 15));
        accNamw.setBounds(240, 97, 533, 25);
        checkb.add(accNamw);
        
        JLabel accNamelbl = new JLabel("Client Name :");
        accNamelbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        accNamelbl.setBounds(90, 92, 140, 30);
        checkb.add(accNamelbl);
        
        JLabel clientNumLbl = new JLabel("Client No. :");
        clientNumLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        clientNumLbl.setBounds(90, 122, 140, 30);
        checkb.add(clientNumLbl);
        
        JLabel accNum = new JLabel();
        accNum.setFont(new Font("Tahoma", Font.BOLD, 15));
        accNum.setBounds(218, 127, 555, 25);
        checkb.add(accNum);
        
        JLabel lblCheckBalance = new JLabel("Check Balance");
        lblCheckBalance.setHorizontalAlignment(SwingConstants.CENTER);
        lblCheckBalance.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblCheckBalance.setBounds(35, 30, 277, 27);
        checkb.add(lblCheckBalance);
        
        JPanel panel = new JPanel();
        panel.setBounds(142, 215, 631, 104);
        checkb.add(panel);
        panel.setLayout(null);
        
        balance = new JLabel("Balance");
        balance.setBounds(0, 23, 631, 54);
        panel.add(balance);
        balance.setHorizontalAlignment(SwingConstants.CENTER);
        balance.setForeground(new Color(0, 100, 0));
        balance.setBackground(new Color(255, 255, 255));
        balance.setFont(new Font("Tahoma", Font.PLAIN, 44));
        
        JButton cancelBtn = new JButton("CANCEL");
        cancelBtn.setForeground(new Color(240, 255, 255));
        cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        cancelBtn.setBackground(new Color(0, 128, 0));
        cancelBtn.setBounds(535, 376, 135, 63);
        checkb.add(cancelBtn);

        accNum.setText(account[0]);
        accNamw.setText(account[1]);
        balance.setText(account[2]);
        
//        -------------- EVENTS ---------------

        cancelBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dashboard = new Dashboard(account);
        		dashboard.setVisible(true);
        		dashboard.setLocationRelativeTo(null);
        		Balance.this.dispose();
        	}
        });
         
        
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
