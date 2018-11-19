import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;


public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JButton addCab;
	private JButton rmCab;
	private JButton viewCabs;
	private JButton addDriver;
	private JButton rmDriver;
	private JButton fare;
	private JButton driverCab;
	private JButton cabDate;

	/**
	 * Launch the application.
	 */
	public static void main1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setForeground(Color.RED);
		lblAdmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdmin.setBounds(192, 11, 50, 22);
		contentPane.add(lblAdmin);
		
		JLabel lblCab = new JLabel("Cab Details");
		lblCab.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCab.setBounds(26, 57, 67, 17);
		contentPane.add(lblCab);
		
		JLabel lblDriverDetails = new JLabel("Driver Details");
		lblDriverDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDriverDetails.setBounds(26, 158, 80, 17);
		contentPane.add(lblDriverDetails);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 44, 414, 2);
		contentPane.add(separator);
		
		addCab = new JButton("Add Cab");
		addCab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new AddCab().main1();
			}
		});
		addCab.setBounds(36, 107, 99, 28);
		contentPane.add(addCab);
		
		rmCab = new JButton("Remove Cab");
		rmCab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					new RemoveCab().main1();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		rmCab.setBounds(147, 107, 132, 28);
		contentPane.add(rmCab);
		
		viewCabs = new JButton("View Cabs");
		viewCabs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					new ViewCab().main1();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		viewCabs.setBounds(304, 107, 109, 28);
		contentPane.add(viewCabs);
		
		addDriver = new JButton("Add Driver");
		addDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new AddDriver().main1();
			}
		});
		addDriver.setBounds(36, 206, 99, 28);
		contentPane.add(addDriver);
		
		rmDriver = new JButton("Remove Driver");
		rmDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					new RemoveDriver().main1();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		rmDriver.setBounds(147, 206, 132, 28);
		contentPane.add(rmDriver);
		
		JButton viewDriver = new JButton("View Drivers");
		viewDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					new ViewDriver().main1();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		viewDriver.setBounds(304, 206, 112, 28);
		contentPane.add(viewDriver);
		
		JLabel lblRequestData = new JLabel("Request Data ");
		lblRequestData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRequestData.setBounds(26, 255, 109, 16);
		contentPane.add(lblRequestData);
		
		JLabel lblNewLabel = new JLabel("Fare in a particular period");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(38, 296, 275, 16);
		contentPane.add(lblNewLabel);
		
		fare = new JButton("GET ");
		fare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					new Fare().main1();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		fare.setBounds(301, 291, 90, 28);
		contentPane.add(fare);
		
		JLabel lblNewLabel_1 = new JLabel("Driver and its corressponding cabs");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(38, 346, 223, 16);
		contentPane.add(lblNewLabel_1);
		
		driverCab = new JButton("GET");
		driverCab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new DriverCab().main1();
			}
		});
		driverCab.setBounds(301, 341, 90, 28);
		contentPane.add(driverCab);
		
		JLabel lblNewLabel_2 = new JLabel("Cabs booked on a particular date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(38, 394, 223, 16);
		contentPane.add(lblNewLabel_2);
		
		cabDate = new JButton("GET");
		cabDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new CabDate().main1();
			}
		});
		cabDate.setBounds(301, 389, 90, 28);
		contentPane.add(cabDate);
	}
}
