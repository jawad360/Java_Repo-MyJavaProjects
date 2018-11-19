import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;


public class View extends JFrame {
	private JTable table;
	Statement st;
	ResultSet rs;
	String title[];
	String[][] drivers;
	/**
	 * Launch the application.
	 */
	public static void main1(final String table) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View(table);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public View(String tableN) throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 448, 325);
		getContentPane().setLayout(null);
		
		GetConnection con = new GetConnection();
		st = con.getConn();
		if(tableN.equals("Customer"))
			rs = st.executeQuery("select * from Cust_1P natural join Cust_2P ");
		else if(tableN.equals("Supplier"))
			rs = st.executeQuery("select * from Supp_1P union select * from Supp_2P");
		else
			rs = st.executeQuery("select * from "+tableN);
		ResultSetMetaData md = rs.getMetaData();
		int no = md.getColumnCount();
		title = new String[no];
		
		for(int i=1;i<=no;i++)
			title[i-1] = md.getColumnName(i);
		int no1 = 0;
		
        while(rs.next())
        {
        	no1++;
        }
        rs.beforeFirst();
        drivers = new String[no1][no];
		int i=0;
		while(rs.next())
		{
			for(int j=0;j<no;j++)
			drivers[i][j] = rs.getString(title[j]);					//can be written as, if no of col not
			
			i++;												//known sop(rs.getInt("id")+rs.getString("name")+....
		}
		rs.close();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(45, 62, 341, 188);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(drivers,title));
		
		scrollPane.setViewportView(table);
		
		JLabel lblCabDetails = new JLabel("Table Details");
		lblCabDetails.setForeground(Color.RED);
		lblCabDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCabDetails.setBounds(169, 11, 121, 19);
		getContentPane().add(lblCabDetails);
		
		
	}
	public View ()
	{
		
	}
}