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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private BufferedImage backgroundImage;
	private Balance balance;
	private Withdraw withdraw;
	private String account[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard(new String[]{"", "", ""});
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
	public Dashboard(String[] account) {
		this.account = account;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 768);

		// Load background image
		try {
			backgroundImage = ImageIO.read(new File("C:\\Users\\Kirt Asia\\Desktop\\School\\1CS-A\\2nd Sem\\CCS103\\dATM img\\bg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Custom JPanel for background image
		contentPane = new JPanel() {
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

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);  // Using null layout for custom placement of components
		
		// Custom panel for logo image
		JPanel logoPanel = new ImagePanel("C:\\Users\\Kirt Asia\\Desktop\\School\\1CS-A\\2nd Sem\\CCS103\\dATM img\\Dangal ATM Dashboard.png");
		logoPanel.setBounds(175, 15, 200, 80);
		contentPane.add(logoPanel);
		
		JButton CBbtn = new JButton("Check Balance");
		
		CBbtn.setText("CHECK BALANCE");
		CBbtn.setForeground(new Color(0, 102, 51));
		CBbtn.setFont(new Font("Poppins Medium", Font.BOLD, 40));
		CBbtn.setBounds(55, 108, 435, 159);
		CBbtn.setBackground(new Color(153, 204, 153));
		contentPane.add(CBbtn);
		
		JButton withdrawBtn = new JButton("WITHDRAW");
		
		withdrawBtn.setFont(new Font("Poppins Medium", Font.BOLD, 40));
		withdrawBtn.setBackground(new Color(153, 204, 153));
		withdrawBtn.setForeground(new Color(0, 102, 51));
		withdrawBtn.setBounds(55, 309, 435, 159);
		contentPane.add(withdrawBtn);
		
		JButton deposit = new JButton("DEPOSIT");
		deposit.setFont(new Font("Poppins Medium", Font.BOLD, 40));
		deposit.setForeground(new Color(0, 102, 51));
		deposit.setBackground(new Color(153, 204, 153));
		deposit.setBounds(55, 506, 435, 159);
		contentPane.add(deposit);
		
//		------------- EVENTS -----------
		
		CBbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				balance = new Balance(account);
				balance.setVisible(true);
				balance.setLocationRelativeTo(null);
				Dashboard.this.dispose();
			}
		});
		
		withdrawBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw = new Withdraw(account);
				withdraw.setVisible(true);
				withdraw.setLocationRelativeTo(null);
				Dashboard.this.dispose();
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
