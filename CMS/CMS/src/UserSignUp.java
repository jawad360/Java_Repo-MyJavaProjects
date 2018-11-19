import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JPasswordField;


public class UserSignUp extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField contact;
	private JTextField address;
	private JTextField email;
	private JPasswordField password;
	Statement st;
	/**
	 * Launch the application.
	 */
	public static void main1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSignUp frame = new UserSignUp();
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
	public UserSignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewCustomerSign = new JLabel("New Customer Sign Up");
		lblNewCustomerSign.setForeground(Color.RED);
		lblNewCustomerSign.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewCustomerSign.setBounds(128, 11, 178, 20);
		contentPane.add(lblNewCustomerSign);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 42, 414, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Enter the following Details :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(20, 55, 168, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name : ");
		lblNewLabel_1.setBounds(30, 91, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblContact = new JLabel("Contact :");
		lblContact.setBounds(30, 125, 46, 14);
		contentPane.add(lblContact);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(30, 160, 46, 14);
		contentPane.add(lblAddress);
		
		JLabel lblEmailId = new JLabel("Email Id :");
		lblEmailId.setBounds(30, 195, 46, 14);
		contentPane.add(lblEmailId);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(30, 231, 63, 14);
		contentPane.add(lblPassword);
		
		name = new JTextField();
		name.setBounds(157, 88, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		contact = new JTextField();
		contact.setBounds(157, 122, 86, 20);
		contentPane.add(contact);
		contact.setColumns(10);
		
		address = new JTextField();
		address.setBounds(157, 157, 86, 20);
		contentPane.add(address);
		address.setColumns(10);
		
		email = new JTextField();
		email.setBounds(157, 192, 86, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(157, 228, 86, 20);
		contentPane.add(password);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Random rd = new Random();
				String id = Integer.toString((1000+rd.nextInt(8999)));
				String nameS = name.getText();
				String contactS = contact.getText();
				String addressS = address.getText();
				String emailS = email.getText();
				String passS = password.getText();
				
				GetConnection getCon = new GetConnection();
				st = getCon.getConn();
				
				try {
					ResultSet rs = st.executeQuery("insert into CUSTOMER values ('"+id+"','"+nameS+"','"+contactS+"','"+addressS+"','"+emailS+"','"+passS+"')");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Account Successfully created\nUserId : "+id+"\nPassword : "+passS);
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(172, 263, 89, 23);
		contentPane.add(btnSubmit);
		
	}
}
