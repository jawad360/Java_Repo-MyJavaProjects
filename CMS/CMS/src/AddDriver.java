import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JEditorPane;


public class AddDriver extends JFrame {

	private JPanel contentPane;
	Statement st;
	private JTextField driverId;
	private JTextField driverName;
	private JTextField contact;
	private JTextField address;
	/**
	 * Launch the application.
	 */
	public static void main1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDriver frame = new AddDriver();
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
	public AddDriver() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 384, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblAddDriver = new JLabel("Add Driver");
		lblAddDriver.setForeground(Color.RED);
		lblAddDriver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddDriver.setBounds(183, 11, 68, 19);
		contentPane.add(lblAddDriver);
		
		JLabel lblNewLabel = new JLabel("Driver Id :");
		lblNewLabel.setBounds(38, 51, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setBounds(38, 89, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contact No. :");
		lblNewLabel_2.setBounds(38, 129, 65, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address :");
		lblNewLabel_3.setBounds(38, 170, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		driverId = new JTextField();
		driverId.setBounds(165, 48, 86, 20);
		contentPane.add(driverId);
		driverId.setColumns(10);
		
		driverName = new JTextField();
		driverName.setBounds(165, 86, 86, 20);
		contentPane.add(driverName);
		driverName.setColumns(10);
		
		contact = new JTextField();
		contact.setBounds(165, 126, 86, 20);
		contentPane.add(contact);
		contact.setColumns(10);
		
		address = new JTextField();
		address.setBounds(165, 167, 129, 20);
		contentPane.add(address);
		address.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				GetConnection getCon = new GetConnection();
				st = getCon.getConn();
				
				String id = driverId.getText();
				String name = driverName.getText();
				String contactS = contact.getText();
				String addressS = address.getText();;
				try {
					ResultSet rs = st.executeQuery("insert into DRIVER_DETAILS values ('"+id+"','"+name+"','"+contactS+"','"+addressS+"')");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Driver Inserted Successfully");
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(139, 218, 89, 23);
		contentPane.add(btnSubmit);
		
	}
}
