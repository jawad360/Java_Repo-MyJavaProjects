import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.DefaultComboBoxModel;


public class BookCab extends JFrame {

	private JPanel contentPane;
	private JTextField source;
	private JTextField destn;
	private JTextField date;
	private JButton book;
	private JLabel amount;
	private JComboBox avaCabs;
	Statement st;
	String[] ava;
	String[] cabNoS;
	String[] cabNameS;
	String[] cabTypeS;
	static BookCab frame;
	/**
	 * Launch the application.
	 */
	public static void main1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BookCab();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * Query
	 * select distinct C.cab_no
		from  cab_booking B ,cab_details C 
		where   (B.DOB != '03/02/2015' OR B.status ='Cancelled') and C.cab_no = B.cab_no
union
select distinct C.cab_no
from  cab_details C, cab_booking B
where C.cab_no not in (select cab_no from cab_booking)
;
		
		select count(*)
from (select distinct C.cab_no
		from  cab_booking B ,cab_details C 
		where   (B.DOB != '03/02/2015' OR B.status ='Cancelled') and C.cab_no = B.cab_no
union
select distinct C.cab_no
from  cab_details C, cab_booking B
where C.cab_no not in (select cab_no from cab_booking)
);


	 * @throws SQLException 
	 */
	public BookCab() throws SQLException 
	{
		GetConnection getCon = new GetConnection();
		st = getCon.getConn();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookACab = new JLabel("Book A Cab");
		lblBookACab.setForeground(Color.RED);
		lblBookACab.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBookACab.setBounds(175, 15, 111, 20);
		contentPane.add(lblBookACab);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 46, 414, 2);
		contentPane.add(separator);
		
		JLabel lblEnterSource = new JLabel("Enter Source :");
		lblEnterSource.setBounds(26, 71, 96, 14);
		contentPane.add(lblEnterSource);
		
		JLabel lblEnterDestinatin = new JLabel("Enter Destination :");
		lblEnterDestinatin.setBounds(26, 113, 111, 14);
		contentPane.add(lblEnterDestinatin);
		
		source = new JTextField();
		source.setBounds(194, 68, 86, 20);
		contentPane.add(source);
		source.setColumns(10);
		
		destn = new JTextField();
		destn.setBounds(194, 110, 86, 20);
		contentPane.add(destn);
		destn.setColumns(10);
		
		JLabel lblEnterDate = new JLabel("Enter Date :");
		lblEnterDate.setBounds(26, 156, 96, 14);
		contentPane.add(lblEnterDate);
		
		date = new JTextField();
		date.setBounds(194, 153, 86, 20);
		contentPane.add(date);
		date.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("(mm-dd-yyyy)");
		lblNewLabel.setBounds(290, 156, 96, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAvailableCabs = new JLabel("Available Cabs :");
		lblAvailableCabs.setBounds(26, 199, 111, 14);
		contentPane.add(lblAvailableCabs);
		
		avaCabs = new JComboBox();
		
		
		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setBounds(26, 243, 64, 14);
		contentPane.add(lblAmount);
		
		amount = new JLabel("0 /-");
		amount.setForeground(Color.BLUE);
		amount.setFont(new Font("Tahoma", Font.BOLD, 13));
		amount.setBackground(Color.RED);
		amount.setBounds(194, 243, 46, 14);
		contentPane.add(amount);
		
		
		date.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) 
			{
				
				int no = 0;
				try
				{
					ResultSet rs = st.executeQuery("select count(*) from (select distinct C.cab_no from  cab_booking B ,cab_details C where   (B.DOB != '"+date.getText()+"' OR B.status ='Cancelled') and C.cab_no = B.cab_no union select distinct C.cab_no from  cab_details C, cab_booking B where C.cab_no not in (select cab_no from cab_booking))");
					while(rs.next())
					no = Integer.parseInt(rs.getString("COUNT(*)"));
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				cabNoS = new String[no];
				cabNameS = new String[no];
				cabTypeS = new String[no];
				String[] ava = new String[no];
				try
				{
					ResultSet rs = st.executeQuery("select distinct C.cab_no , C.cab_model, C.cab_type from  cab_booking B ,cab_details C	where   (B.DOB != '"+date.getText()+"' OR B.status ='Cancelled') and C.cab_no = B.cab_no union select distinct C.cab_no ,C.cab_model, C.cab_type from  cab_details C, cab_booking B where C.cab_no not in (select cab_no from cab_booking)");
					int i=0;
					while(rs.next())
					{
						cabNoS[i] = rs.getString("CAB_NO");
						cabNameS[i] = rs.getString("CAB_MODEL");
						cabTypeS[i] = rs.getString("CAB_TYPE");
						
						ava[i] = cabNameS[i]+" : "+cabTypeS[i];
						i++;
					}
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				avaCabs.setModel(new DefaultComboBoxModel(ava));
				avaCabs.setBounds(194, 196, 135, 20);
				contentPane.add(avaCabs);	
				
				frame.repaint();
				
				avaCabs.addActionListener(
						new ActionListener()
						{
							@Override
							public void actionPerformed(ActionEvent arg0) 
							{
								//JOptionPane.showMessageDialog(null, cabNameS[avaCabs.getSelectedIndex()]);
								int dist = 1 + (new Random().nextInt(40));
								
								if(cabTypeS[avaCabs.getSelectedIndex()].equals("NON AC"))
									amount.setText(Integer.toString(dist*20));
								else
									amount.setText(Integer.toString(dist*24));
								
							}
						});
				frame.repaint();
			}
		});
		
		book = new JButton("Book Now");
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String sourceS = source.getText();
				String destS = destn.getText();
				String dateS = date.getText();
				
				int no = avaCabs.getSelectedIndex();
				JOptionPane.showMessageDialog(null, "Cab successfully booked\nCab No : "+cabNoS[no]+"\nAmount : "+amount.getText());
				
				try
				{
					ResultSet rs = st.executeQuery("INSERT INTO CAB_BOOKING VALUES(145,0937,'"+dateS+"',800,'MH02 5572','Mahim','Dadar',6,100,'2-Feb-15','Booked'); ");
				}
				catch(SQLException e)
				{
					
				}
			}
		});
		book.setBounds(161, 278, 111, 23);
		contentPane.add(book);
	}
}
