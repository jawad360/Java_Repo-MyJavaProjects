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


public class ViewCab extends JFrame {
	private JTable table;
	Statement st;
	ResultSet rs;
	String title[];
	String[][] cabs;
	/**
	 * Launch the application.
	 */
	public static void main1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCab frame = new ViewCab();
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
	public ViewCab() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 448, 325);
		getContentPane().setLayout(null);
		
		GetConnection con = new GetConnection();
		st = con.getConn();
		rs = st.executeQuery("select * from cab_details");
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
        cabs = new String[no1][no];
		int i=0;
		while(rs.next())
		{
			cabs[i][0] = rs.getString("CAB_NO");					//can be written as, if no of col not
			cabs[i][1] = rs.getString("CAB_TYPE");
			cabs[i][2] = rs.getString("CAB_MODEL");
			i++;												//known sop(rs.getInt("id")+rs.getString("name")+....
		}
		rs.close();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(45, 62, 341, 188);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(cabs,title));
		
		scrollPane.setViewportView(table);
		
		JLabel lblCabDetails = new JLabel("Cab Details");
		lblCabDetails.setForeground(Color.RED);
		lblCabDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCabDetails.setBounds(180, 15, 72, 19);
		getContentPane().add(lblCabDetails);
		
		
	}
}
