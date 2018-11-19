import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Arrays;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	String username;
	String passwd;
	String[] custId;
	String[] custPass;
	String[] custName;
	int id = -1;
	boolean flag = false;
	static Login frame;
	/**
	 * Launch the application.
	 */
	public static void main1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
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
	public Login() 
	{
		getData();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCabManagementSystem = new JLabel("Cab Management System");
		lblCabManagementSystem.setForeground(Color.RED);
		lblCabManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCabManagementSystem.setBounds(132, 25, 170, 19);
		contentPane.add(lblCabManagementSystem);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(115, 83, 67, 16);
		contentPane.add(lblUsername);
		
		user = new JTextField();
		user.setBounds(216, 82, 86, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(115, 146, 64, 16);
		contentPane.add(lblPassword);
		
		pass = new JPasswordField();
		pass.setBounds(216, 145, 86, 20);
		contentPane.add(pass);
		
		JButton btnSubmit = new JButton("Log In");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				username = user.getText();
				passwd = pass.getText();
				
				if(username.equals("admin"))
				{
					if(passwd.equals("123456"))
					{
						frame.setVisible(false);
						frame.dispose();
						new AdminLogin().main1();
					}
					else
						JOptionPane.showMessageDialog(null, "Invalid username or password");
				}
				else
				{
					for(String t : custId)
					{
						id++;
						if(username.equals(t))
						{
							flag = true;
							break;
						}
					}
					if(flag && username.equals(custId[id]))
					{
						if(passwd.equals(custPass[id]))
						{
							frame.setVisible(false);
							frame.dispose();
							new UserLogin().main1(custName[id]);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Invalid username or password");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid username or password");
					}
				}
				id=-1;
			}
		});
		btnSubmit.setBounds(174, 186, 86, 28);
		contentPane.add(btnSubmit);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				frame.dispose();
				new UserSignUp().main1();
			}
		});
		btnNewButton.setBounds(174, 226, 86, 28);
		contentPane.add(btnNewButton);
		
		
		
	}

	private void getData() 
	{
		// TODO Auto-generated method stub
		Connection conn = null;
		try
		{
			String user = "jawad";
			String pass = "123456";				//null:
			String url = "jdbc:oracle:thin:@localhost:1521:xe";		//dont know
			Class.forName ("oracle.jdbc.OracleDriver");	//No need require in older version..
			
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("select cust_id,NAME,password from customer");
			
			
	        int no = 0;
	        		
	        while(rs.next())
	        {
	        	no++;
	        }
	        rs.beforeFirst();
			custId = new String[no];
			custPass = new String[no];
			custName = new String[no];
			
			int i=0;
			while(rs.next())
			{
				custId[i] = rs.getString("cust_id");
				custName[i] = rs.getString("NAME"); 				//can be written as, if no of col not
				custPass[i] = rs.getString("password"); 
				i++;												//known sop(rs.getInt("id")+rs.getString("name")+....
			}
			rs.close();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
