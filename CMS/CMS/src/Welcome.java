import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;


public class Welcome extends JFrame {
	static Welcome frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Welcome();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		Thread.sleep(3000);
		
		frame.setVisible(false);
		frame.dispose();
		new Login().main1();
	}

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	public Welcome() throws InterruptedException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCabManagementSystem = new JLabel("Cab Management System");
		lblCabManagementSystem.setForeground(Color.RED);
		lblCabManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCabManagementSystem.setBounds(110, 119, 214, 23);
		contentPane.add(lblCabManagementSystem);
		
		
	}
}
