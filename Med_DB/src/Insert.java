import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Insert extends JFrame {

	private JPanel contentPane;
	Statement st;
	ResultSet rs;
	JTextField[] textF;
	private JButton ok;
	/**
	 * Launch the application.
	 */
	public static void main1(final String table) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert frame = new Insert(table);
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
	public Insert()
	{
		getContentPane().setLayout(null);			
		
		
	}
	public Insert(final String tableN) throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		
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
		
		textF = new JTextField[no];
		
		int i=0;
		while(i<no)
		{
			JLabel lblNewLabel = new JLabel(md.getColumnName(i+1));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(51, 48+i*40, 122, 18);
			contentPane.add(lblNewLabel);
		
		
			textF[i] = new JTextField();
			textF[i].setBounds(204, 49+i*40, 86, 20);
			contentPane.add(textF[i]);
			textF[i].setColumns(10);
			i++;
		
		}
		ok = new JButton("Submit");
		ok.setBounds(172, 266, 89, 23);
		contentPane.add(ok);
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tableN.equals("Customer"))
					{	rs = st.executeQuery("insert into Cust_1P values ('"+textF[0].getText()+"','"+textF[1].getText()+"')");
						st.executeQuery("insert into Cust_2P values ('"+textF[0].getText()+"','"+textF[2].getText()+"','"+textF[3].getText()+"')");
					}
					else if(tableN.equals("Supplier"))
					{
						if(Integer.parseInt(textF[4].getText())>10)
							st.executeQuery("insert into Supp_2P values ('"+textF[0].getText()+"','"+textF[1].getText()+"','"+textF[2].getText()+"','"+textF[3].getText()+"','"+textF[4].getText()+"')");
						else
							st.executeQuery("insert into Supp_1P values ('"+textF[0].getText()+"','"+textF[1].getText()+"','"+textF[2].getText()+"','"+textF[3].getText()+"','"+textF[4].getText()+"')");	
					}
					else
					{
						String sql="x";
						for(JTextField jtf: textF)
							sql+=",'"+jtf.getText()+"'";
						sql = sql.replaceAll("x,", "");
						st.executeQuery("insert into "+tableN+" values ("+sql+")");
					}
					JOptionPane.showMessageDialog(null, "Row inserted successfully");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
