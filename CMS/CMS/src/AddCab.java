import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AddCab extends JFrame {

	private JPanel contentPane;
	private JTextField cabNo;
	private JTextField cabModel;
	private JRadioButton noACRbt;
	private JRadioButton acRbt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnSubmit;
	String cabNoSt;
	String cabModelSt;
	String cabType;
	Statement st;
	/**
	 * Launch the application.
	 */
	public static void main1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCab frame = new AddCab();
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
	public AddCab() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddCab = new JLabel("Add Cab");
		lblAddCab.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddCab.setBounds(191, 24, 52, 17);
		contentPane.add(lblAddCab);
		
		JLabel lblNewEnterCab = new JLabel("New Enter Cab No.");
		lblNewEnterCab.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewEnterCab.setBounds(33, 63, 106, 15);
		contentPane.add(lblNewEnterCab);
		
		JLabel lblCabType = new JLabel("Cab Type :");
		lblCabType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCabType.setBounds(33, 108, 60, 15);
		contentPane.add(lblCabType);
		
		cabNo = new JTextField();
		cabNo.setBounds(180, 61, 86, 20);
		contentPane.add(cabNo);
		cabNo.setColumns(10);
		
		noACRbt = new JRadioButton("Non AC");
		buttonGroup.add(noACRbt);
		noACRbt.setBounds(33, 136, 86, 23);
		contentPane.add(noACRbt);
		
		acRbt = new JRadioButton("AC");
		buttonGroup.add(acRbt);
		acRbt.setBounds(161, 136, 60, 23);
		contentPane.add(acRbt);
		
		
		
		JLabel lblEnterCabModel = new JLabel("Enter Cab Model");
		lblEnterCabModel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEnterCabModel.setBounds(33, 188, 106, 15);
		contentPane.add(lblEnterCabModel);
		
		cabModel = new JTextField();
		cabModel.setColumns(10);
		cabModel.setBounds(180, 186, 86, 20);
		contentPane.add(cabModel);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(172, 227, 89, 23);
		contentPane.add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				cabModelSt = cabModel.getText();
				cabNoSt = cabNo.getText();
				if(acRbt.isSelected())
					cabType = "AC";
				else if(noACRbt.isSelected())
					cabType = "NON AC";
				
				GetConnection getCon = new GetConnection();
				st = getCon.getConn();
				
				try {
					ResultSet rs = st.executeQuery("insert into cab_details values ('"+cabNoSt+"','"+cabType+"','"+cabModelSt+"')");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Cab Inserted Successfully");
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}
}
