import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RemoveCab extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	Statement st;
	ResultSet rs;
	String[] cabName ; 
	static RemoveCab frame;
	/**
	 * Launch the application.
	 */
	public static void main1() 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new RemoveCab();
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
	public RemoveCab() throws SQLException 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemoveCab = new JLabel("Remove Cab");
		lblRemoveCab.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRemoveCab.setBounds(170, 27, 93, 21);
		contentPane.add(lblRemoveCab);
		
		JLabel lblNewLabel = new JLabel("Select Cab to Remove");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(34, 95, 145, 19);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox();
		GetConnection con = new GetConnection();
		st = con.getConn();
		try {
			rs = st.executeQuery("select cab_no from cab_details");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int no = 0;
		
        while(rs.next())
        {
        	no++;
        }
        rs.beforeFirst();
        cabName = new String[no];
		int i=0;
		while(rs.next())
		{
			cabName[i] = rs.getString("cab_no");					//can be written as, if no of col not
			i++;												//known sop(rs.getInt("id")+rs.getString("name")+....
		}
		rs.close();
		comboBox.setModel(new DefaultComboBoxModel(cabName));
		comboBox.setBounds(237, 95, 99, 20);
		contentPane.add(comboBox);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String t = (String) comboBox.getSelectedItem();
				try {
					rs = st.executeQuery("DELETE FROM cab_details WHERE cab_no='"+t+"'");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Cab successfully deleted from the Record");
				comboBox.removeItem(t);
				frame.repaint();
			}
		});
		btnRemove.setBounds(156, 167, 89, 23);
		contentPane.add(btnRemove);
	}
}
