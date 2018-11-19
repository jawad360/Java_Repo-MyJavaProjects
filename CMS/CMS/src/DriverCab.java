import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;


public class DriverCab extends JFrame {

	private JPanel contentPane;
	Statement st;
	private JComboBox comboBox;
	String[] drivers;
	static DriverCab frame;
	JLabel[] label = null;
	int no = 0;
	/**
	 * Launch the application.
	 */
	public static void main1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DriverCab();
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
	public DriverCab() 
	{
		GetConnection getCon = new GetConnection();
		st = getCon.getConn();
		
		try
		{
			int no = 0;
			ResultSet rs = st.executeQuery("select count(*) from driver_details");
			while(rs.next())
				no = Integer.parseInt(rs.getString("COUNT(*)"));
			
			drivers = new String[no];
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		try
		{
			int i=0;
			ResultSet rs = st.executeQuery("select name from driver_details");
			while(rs.next())
			{
				drivers[i] = rs.getString("NAME");
				i++;
			}
		}
		catch(SQLException ex1)
		{
			ex1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Driver : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(55, 49, 131, 14);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(drivers));
		comboBox.setBounds(212, 48, 114, 20);
		contentPane.add(comboBox);
		
		JLabel lblListOfCabs = new JLabel("List of Cabs :");
		lblListOfCabs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListOfCabs.setBounds(55, 102, 114, 14);
		contentPane.add(lblListOfCabs);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				if(label!=null)
				{
					for(int i=0;i<no;i++)
						frame.remove(label[i]);
				}
					
				try
				{
					int i= 0;
					
					ResultSet rs = st.executeQuery("select count(*) from driver_details D, cab_details C , cab_booking B where D.driver_id = B.driver_id AND B.cab_no = C.cab_no and D.name='"+comboBox.getSelectedItem()+"' ");
					while(rs.next())
						no = Integer.parseInt((rs.getString("COUNT(*)")));
					
					label = new JLabel[no];
				}
				catch(SQLException e1)
				{
					
				}
				try
				{
					int i= 0;
					int x = 0;
					ResultSet rs = st.executeQuery("select C.cab_no, C.cab_model from driver_details D, cab_details C , cab_booking B where D.driver_id = B.driver_id AND B.cab_no = C.cab_no and D.name='"+comboBox.getSelectedItem()+"' ");
					while(rs.next())
					{
						label[x] = new JLabel(rs.getString("CAB_NO")+" "+rs.getString("CAB_MODEL"));
						label[x].setFont(new Font("Tahoma", Font.PLAIN, 14));
						label[x].setBounds(212, 102+i, 185, 14);
						contentPane.add(label[x]);
						
						i += 25;
						x++;
						frame.repaint();
					}
				}
				catch(SQLException e1)
				{
					
				}
			}
		});
	}
}
