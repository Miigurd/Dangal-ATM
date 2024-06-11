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

public class PIN {

	private JFrame frame;
	private JPanel bgPane;
	private BufferedImage backgroundImage;
	private JTextField pinLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PIN window = new PIN();
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
	public PIN() {
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
		
		// Custom panel for logo image
		JPanel logoPanel = new ImagePanel("C:\\Users\\Kirt Asia\\Dangal-ATM\\dATM\\img\\Dangal ATM Dashboard.png");
		logoPanel.setBounds(350, 80, 250, 100);
		bgPane.add(logoPanel);
		bgPane.setLayout(null);
		
		JPanel DepositDashboardInfoPane = new JPanel();
		DepositDashboardInfoPane.setBackground(new Color(255, 255, 255));
		DepositDashboardInfoPane.setBounds(45, 238, 930, 480);
		bgPane.add(DepositDashboardInfoPane);
		DepositDashboardInfoPane.setLayout(null);
		
		JButton cancelBtn = new JButton("CANCEL");
		cancelBtn.setForeground(new Color(255, 255, 255));
		cancelBtn.setBackground(new Color(0, 128, 0));
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		cancelBtn.setBounds(385, 367, 135, 63);
		DepositDashboardInfoPane.add(cancelBtn);
		
		JButton confirmBtn = new JButton("CONFIRM");
		confirmBtn.setForeground(new Color(240, 255, 255));
		confirmBtn.setBackground(new Color(0, 128, 0));
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		confirmBtn.setBounds(137, 367, 135, 63);
		DepositDashboardInfoPane.add(confirmBtn);
		
		pinLabel = new JTextField();
		pinLabel.setBackground(new Color(192, 192, 192));
		pinLabel.setForeground(new Color(0, 100, 0));
		pinLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		pinLabel.setBounds(78, 168, 765, 102);
		DepositDashboardInfoPane.add(pinLabel);
		pinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pinLabel.setColumns(10);
		
		JLabel DepositDashboardLbl = new JLabel("Enter pin");
		DepositDashboardLbl.setBounds(10, 25, 307, 43);
		DepositDashboardInfoPane.add(DepositDashboardLbl);
		DepositDashboardLbl.setHorizontalAlignment(SwingConstants.CENTER);
		DepositDashboardLbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		
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
		
		JButton eraseBTN = new JButton("DELETE");
		eraseBTN.setForeground(new Color(240, 255, 255));
		eraseBTN.setFont(new Font("Tahoma", Font.BOLD, 20));
		eraseBTN.setBackground(new Color(0, 128, 0));
		eraseBTN.setBounds(635, 367, 135, 63);
		DepositDashboardInfoPane.add(eraseBTN);
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