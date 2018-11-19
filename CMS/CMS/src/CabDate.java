import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CabDate extends JFrame {

	private JPanel contentPane;
	private JTextField date;
	Statement st;
	int no = 0;
	JLabel[] label = null;
	static CabDate frame;
	/**
	 * Launch the application.
	 */
	public static void main1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CabDate();
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
	public CabDate() 
	{
		GetConnection getCon = new GetConnection();
		st = getCon.getConn();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectDate = new JLabel("Select Date :");
		lblSelectDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectDate.setBounds(84, 58, 111, 14);
		contentPane.add(lblSelectDate);
		
		date = new JTextField();
		date.setBounds(205, 57, 94, 20);
		contentPane.add(date);
		date.setColumns(10);
		
		JLabel lblmmddyyy = new JLabel("(dd/mm/yyy)");
		lblmmddyyy.setBounds(319, 60, 72, 14);
		contentPane.add(lblmmddyyy);
		
		JLabel lblBookedCabs = new JLabel("Booked Cabs :");
		lblBookedCabs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBookedCabs.setBounds(84, 103, 111, 14);
		contentPane.add(lblBookedCabs);
		
		JButton btnGet = new JButton("Get");
		btnGet.setBounds(186, 215, 89, 23);
		contentPane.add(btnGet);
		
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(label!=null)
				{
					for(int i=0;i<no;i++)
						frame.remove(label[i]);
				}
				frame.repaint();
				try
				{
					int i= 0;
					
					ResultSet rs = st.executeQuery("select count(*) from cab_details C, cab_booking B where B.cab_no = C.cab_no and B.DOB = '"+date.getText()+"' and B.status='Booked'");
					while(rs.next())
						no = Integer.parseInt((rs.getString("COUNT(*)")));
					
					label = new JLabel[no];
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				try
				{
					int i= 0;
					int x = 0;
					ResultSet rs = st.executeQuery("select C.cab_no, C.cab_model from cab_details C, cab_booking B where B.cab_no = C.cab_no and B.DOB = '"+date.getText()+"' and B.status='Booked'");
					while(rs.next())
					{
						label[x] = new JLabel(rs.getString("CAB_NO")+" "+rs.getString("CAB_MODEL"));
						label[x].setFont(new Font("Tahoma", Font.PLAIN, 14));
						label[x].setBounds(205, 102+i, 185, 14);
						contentPane.add(label[x]);
						
						i += 25;
						x++;
						frame.repaint();
					}
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		});
	}
}
