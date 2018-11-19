package banking_A;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;


public class Update extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	Statement st;
	ResultSet rs;
	JTextField[] textF;
	ResultSetMetaData md;
	private JButton update;
	/**
	 * Launch the application.
	 */
	public static void main1(final String table) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update(table);
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
	public Update()
	{
		
	}
	public Update(final String tableN) throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		GetConnection con = new GetConnection();
		st = con.getConn();
		
		if(tableN.equals("CUSTOMERS"))
			rs = st.executeQuery("select * from Cust_1A natural join Cust_2A ");
		else if(tableN.equals("ACCOUNT"))
			rs = st.executeQuery("select * from ACCCUR_2A union select * from ACCSAV_1A");
		else
			rs = st.executeQuery("select * from "+tableN);
		
		md = rs.getMetaData();
		final int no = md.getColumnCount();
		
		textF = new JTextField[no];
		
		int i=0;
		while(i<no)
		{
			JLabel lblNewLabel = new JLabel(md.getColumnName(i+1));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(51, 80+i*40, 122, 18);
			contentPane.add(lblNewLabel);
		
		
			textF[i] = new JTextField();
			textF[i].setBounds(204, 80+i*40, 86, 20);
			contentPane.add(textF[i]);
			textF[i].setColumns(10);
			i++;
		
		}
		
		JLabel lblSelectRowTo = new JLabel("Select Row to update:");
		lblSelectRowTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectRowTo.setBounds(32, 36, 178, 17);
		contentPane.add(lblSelectRowTo);
		
		ArrayList<String>al = new ArrayList<String>();
		while(rs.next())
		{
			
			al.add(rs.getString(1)+" "+rs.getString(2)) ;
			
		}
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					if(tableN.equals("CUSTOMERS"))
						rs = st.executeQuery("select * from Cust_1A natural join Cust_2A where "+md.getColumnName(1)+" = "+comboBox.getSelectedItem().toString().split(" ")[0]);
					else if(tableN.equals("ACCOUNT"))
						rs = st.executeQuery("select * from ACCSAV_1A union select * from ACCCUR_2A where "+md.getColumnName(1)+" = "+comboBox.getSelectedItem().toString().split(" ")[0]);
					else
						rs = st.executeQuery("select * From "+tableN+" where "+md.getColumnName(1)+" = "+comboBox.getSelectedItem().toString().split(" ")[0]);
					rs.next();
					for(int i=0; i<no ;i++)
						textF[i].setText(rs.getString(i+1));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(al.toArray()));
		comboBox.setBounds(240, 36, 104, 20);
		contentPane.add(comboBox);
		
		update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					if(tableN.equals("CUSTOMERS"))
						st.executeQuery("delete from CUST_1A where "+md.getColumnName(1)+" = '"+comboBox.getSelectedItem().toString().split(" ")[0]+"'");
					else if(tableN.equals("ACCOUNT"))
					{
						rs = st.executeQuery("delete from ACCCUR_2A where "+md.getColumnName(1)+" = "+comboBox.getSelectedItem().toString().split(" ")[0]);
						rs = st.executeQuery("delete from ACCSAV_1A where "+md.getColumnName(1)+" = "+comboBox.getSelectedItem().toString().split(" ")[0]);
					}
					else
						st.executeQuery("delete From "+tableN+" where "+md.getColumnName(1)+" = '"+comboBox.getSelectedItem().toString().split(" ")[0]+"'");
					
					
					if(tableN.equals("CUSTOMERS"))
					{	
						JOptionPane.showMessageDialog(null, textF[3].getText().split(" ")[0]);
						rs = st.executeQuery("insert into Cust_1A values ('"+textF[0].getText()+"','"+textF[1].getText()+"')");
						st.executeQuery("insert into Cust_2A values ('"+textF[0].getText()+"','"+textF[2].getText()+"',TO_DATE('"+textF[3].getText().split(" ")[0]+"','YYYY-MM-DD'))");
					}
					else if(tableN.equals("ACCOUNT"))
					{
						if(textF[2].getText().equalsIgnoreCase("Saving"))
							st.executeQuery("insert into ACCSAV_1A values ('"+textF[0].getText()+"','"+textF[1].getText()+"','"+textF[2].getText()+"','"+textF[3].getText()+"','"+textF[4].getText()+"','"+textF[5].getText()+"')");
						else
							st.executeQuery("insert into ACCCUR_2A values ('"+textF[0].getText()+"','"+textF[1].getText()+"','"+textF[2].getText()+"','"+textF[3].getText()+"','"+textF[4].getText()+"','"+textF[5].getText()+"')");	
					}
					else
					{
						String sql="x";
						for(JTextField jtf: textF)
							sql+=",'"+jtf.getText()+"'";
						sql = sql.replaceAll("x,", "");
						st.executeQuery("insert into "+tableN+" values ("+sql+")");
					}
					JOptionPane.showMessageDialog(null, "Row updated successfully");

						
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		update.setBounds(179, 302, 89, 23);
		contentPane.add(update);
	}

}
