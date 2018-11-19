import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import oracle.sql.DATE;

import java.awt.Color;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Fare extends JFrame {

	private JPanel contentPane;
	private JTextField strtDt;
	private JTextField endDt;
	private JLabel lblNewLabel_3;
	Statement st;
	private JLabel amountS;
	private JButton btnCalculate;
	/**
	 * Launch the application.
	 */
	public static void main1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fare frame = new Fare();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public Fare() throws ParseException 
	{
		GetConnection getCon = new GetConnection();
		st = getCon.getConn();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Start Date :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(39, 43, 86, 14);
		contentPane.add(lblNewLabel);
		
		strtDt = new JTextField();
		strtDt.setBounds(184, 42, 86, 20);
		contentPane.add(strtDt);
		strtDt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("(dd/mm/yyyy)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(292, 45, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("End Date :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(39, 97, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		endDt = new JTextField();
		endDt.setBounds(184, 96, 86, 20);
		contentPane.add(endDt);
		endDt.setColumns(10);
		
		lblNewLabel_3 = new JLabel("(dd/mm/yyyy)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(292, 99, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		btnCalculate = new JButton("CALCULATE");
		btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalculate.setBounds(147, 157, 139, 23);
		contentPane.add(btnCalculate);
		
		JLabel lblNewLabel_4 = new JLabel("Amount : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(79, 213, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		amountS = new JLabel("0 /-");
		amountS.setForeground(Color.BLUE);
		amountS.setFont(new Font("Tahoma", Font.BOLD, 14));
		amountS.setBounds(210, 215, 76, 14);
		contentPane.add(amountS);
		
        btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String amount = null;
					ResultSet rs = st.executeQuery("select sum(amount)from cab_booking where dob between '"+strtDt.getText()+"' and '"+endDt.getText()+"'");
					while(rs.next())
						amount = rs.getString("SUM(AMOUNT)");
					amountS.setText(amount+"/-");
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		});
        
	}
}
