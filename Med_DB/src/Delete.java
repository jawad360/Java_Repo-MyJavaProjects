import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class Delete extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton deleteBt;
	private JLabel lblDeleteRow;
	Statement st;
	ResultSet rs;
	String title[];
	String[][] drivers;
	static Delete frame;
	/**
	 * Launch the application.
	 */
	public static void main1(final String table) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Delete(table);
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
	public Delete()
	{
		
	}
	public Delete(final String tableN) throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 434, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
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
		scrollPane.setBounds(45, 62, 341, 164);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(drivers,title));
		
		scrollPane.setViewportView(table);
		
		deleteBt = new JButton("Delete");
		deleteBt.setBounds(172, 255, 89, 23);
		contentPane.add(deleteBt);
		
		lblDeleteRow = new JLabel("Delete Row");
		lblDeleteRow.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeleteRow.setBounds(172, 21, 89, 17);
		contentPane.add(lblDeleteRow);
		
		deleteBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int delNo = table.getSelectedRow();
				try 
				{
					if(tableN.equals("Customer"))
						st.executeQuery("delete from CUST_1P where "+title[0]+" = "+drivers[delNo][0]);
					else if(tableN.equals("Supplier"))
					{
						st.executeQuery("delete from SUPP_1P where "+title[0]+" = "+drivers[delNo][0]);
						st.executeQuery("delete from SUPP_2P where "+title[0]+" = "+drivers[delNo][0]);
					}
					else
						st.executeQuery("delete from "+tableN+" where "+title[0]+" = "+drivers[delNo][0]);
				} catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Successfully Deleted");
				frame.repaint();
			}
		});
	}
}
