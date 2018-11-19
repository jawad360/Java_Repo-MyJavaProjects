import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserLogin extends JFrame {

	private JPanel contentPane;
	String name;
	private JButton bookCab;
	private JButton delAcc;
	Statement st;
	static UserLogin frame;
	/**
	 * Launch the application.
	 */
	public void main1(final String custName) 
	{
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UserLogin(custName);
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
	public UserLogin(String custName)
	{
		name = custName;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		GetConnection getCon = new GetConnection();
		st = getCon.getConn();
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hi, "+name);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(21, 41, 241, 19);
		getContentPane().add(lblNewLabel);
		
		bookCab = new JButton("Book A Cab");
		bookCab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					new BookCab().main1();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		bookCab.setBounds(161, 86, 111, 32);
		getContentPane().add(bookCab);
		
		delAcc = new JButton("Delete My Account");
		delAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				try 
				{
					ResultSet rs = st.executeQuery("DELETE FROM CUSTOMER WHERE NAME='"+name+"'");
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Account Deleted Successfully");
				frame.setVisible(false);
				frame.dispose();
			}
		});
		delAcc.setBounds(130, 158, 173, 32);
		getContentPane().add(delAcc);
		
	}

	public UserLogin()
	{
		
	}

}
