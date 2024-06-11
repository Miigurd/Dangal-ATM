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
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WithdrawDashBoard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel bgPane;
	private BufferedImage backgroundImage;
	private JTextField amountTxtField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WithdrawDashBoard frame = new WithdrawDashBoard();
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
	public WithdrawDashBoard() {
		setTitle("Withdraw Dashboard");
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
		
		// Custom panel for logo image
		JPanel logoPanel = new ImagePanel("C:\\Users\\USER\\dATM\\imgs\\Dangal ATM Dashboard.png");
		logoPanel.setBounds(350, 80, 250, 100);
		bgPane.add(logoPanel);
		bgPane.setLayout(null);
		
		JPanel withdrawInfoPane = new JPanel();
		withdrawInfoPane.setBackground(new Color(255, 255, 255));
		withdrawInfoPane.setBounds(38, 238, 930, 480);
		bgPane.add(withdrawInfoPane);
		withdrawInfoPane.setLayout(null);
		
		JButton cancelBtn = new JButton("CANCEL");
		cancelBtn.setForeground(new Color(255, 255, 255));
		cancelBtn.setBackground(new Color(0, 128, 0));
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		cancelBtn.setBounds(447, 367, 135, 63);
		withdrawInfoPane.add(cancelBtn);
		
		JButton confirmBtn = new JButton("CONFIRM");
		confirmBtn.setForeground(new Color(240, 255, 255));
		confirmBtn.setBackground(new Color(0, 128, 0));
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		confirmBtn.setBounds(260, 367, 135, 63);
		withdrawInfoPane.add(confirmBtn);
		
		JLabel accInfolbl = new JLabel("Account Information: ");
		accInfolbl.setBounds(93, 79, 336, 33);
		withdrawInfoPane.add(accInfolbl);
		accInfolbl.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel accNamelbl = new JLabel("Client Name :");
		accNamelbl.setBounds(110, 110, 140, 30);
		withdrawInfoPane.add(accNamelbl);
		accNamelbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel clientNumLbl = new JLabel("Client No. :");
		clientNumLbl.setBounds(110, 140, 108, 30);
		withdrawInfoPane.add(clientNumLbl);
		clientNumLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		amountTxtField = new JTextField();
		amountTxtField.setBackground(new Color(192, 192, 192));
		amountTxtField.setForeground(new Color(255, 255, 255));
		amountTxtField.setFont(new Font("Tahoma", Font.PLAIN, 45));
		amountTxtField.setBounds(117, 252, 765, 102);
		withdrawInfoPane.add(amountTxtField);
		amountTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		amountTxtField.setColumns(10);
		
		JLabel withdrawLbl = new JLabel("Withdraw: ");
		withdrawLbl.setBounds(36, 39, 207, 27);
		withdrawInfoPane.add(withdrawLbl);
		withdrawLbl.setHorizontalAlignment(SwingConstants.CENTER);
		withdrawLbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		
		JLabel balNameLbl = new JLabel("Balance: ");
		balNameLbl.setBounds(48, 185, 139, 25);
		withdrawInfoPane.add(balNameLbl);
		balNameLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel balanceLbl = new JLabel(" ");
		balanceLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		balanceLbl.setBounds(184, 185, 380, 25);
		withdrawInfoPane.add(balanceLbl);
		
		JLabel lblNewLabel = new JLabel("₱");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 95));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(36, 241, 78, 113);
		withdrawInfoPane.add(lblNewLabel);
		
		JLabel NameLbl = new JLabel(" ");
		NameLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		NameLbl.setBounds(228, 115, 135, 25);
		withdrawInfoPane.add(NameLbl);
		
		JLabel NumberLbl = new JLabel(" ");
		NumberLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		NumberLbl.setBounds(208, 144, 135, 25);
		withdrawInfoPane.add(NumberLbl);
		
		JButton eraseBTN = new JButton("DELETE");
		eraseBTN.setForeground(new Color(240, 255, 255));
		eraseBTN.setFont(new Font("Tahoma", Font.BOLD, 20));
		eraseBTN.setBackground(new Color(0, 128, 0));
		eraseBTN.setBounds(635, 367, 135, 63);
		withdrawInfoPane.add(eraseBTN);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
