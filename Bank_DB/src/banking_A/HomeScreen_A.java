package banking_A;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.SQLException;


public class HomeScreen_A extends JFrame {

	private JPanel contentPane;
	private JComboBox viewCB;
	private JComboBox updateCB;
	private JComboBox deleteCB;
	private JComboBox insertCB;
	private JButton viewBt;
	private JButton insertBt;
	private JButton deleteBt;
	private JButton updateBt;
	String[] tables = new String[]{"CUSTOMERS","ACCOUNT","BRANCH_A", "Loan_A","STAFF_A"};
	private JLabel lblTopic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen_A frame = new HomeScreen_A();
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
	public HomeScreen_A() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewTable = new JLabel("View Table :");
		lblViewTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblViewTable.setBounds(47, 61, 152, 20);
		contentPane.add(lblViewTable);
		
		JLabel lblInsertIntoTable = new JLabel("Insert Into Table :");
		lblInsertIntoTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInsertIntoTable.setBounds(47, 108, 152, 19);
		contentPane.add(lblInsertIntoTable);
		
		JLabel lblDeleteFromTable = new JLabel("Delete from Table :");
		lblDeleteFromTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeleteFromTable.setBounds(47, 157, 152, 19);
		contentPane.add(lblDeleteFromTable);
		
		JLabel lblUpadetTable = new JLabel("Update Table");
		lblUpadetTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpadetTable.setBounds(47, 209, 152, 19);
		contentPane.add(lblUpadetTable);
		
		viewCB = new JComboBox();
		viewCB.setModel(new DefaultComboBoxModel(tables));
		viewCB.setBounds(203, 60, 111, 20);
		contentPane.add(viewCB);
		
		insertCB = new JComboBox();
		insertCB.setModel(new DefaultComboBoxModel(tables));
		insertCB.setBounds(203, 107, 111, 20);
		contentPane.add(insertCB);
		
		deleteCB = new JComboBox();
		deleteCB.setModel(new DefaultComboBoxModel(tables));
		deleteCB.setBounds(203, 156, 111, 20);
		contentPane.add(deleteCB);
		
		updateCB = new JComboBox();
		updateCB.setModel(new DefaultComboBoxModel(tables));
		updateCB.setBounds(203, 208, 111, 20);
		contentPane.add(updateCB);
		
		viewBt = new JButton("View");
		viewBt.setBounds(337, 61, 89, 23);
		contentPane.add(viewBt);
		
		insertBt = new JButton("Insert");
		insertBt.setBounds(337, 107, 89, 23);
		contentPane.add(insertBt);
		
		deleteBt = new JButton("Delete");
		deleteBt.setBounds(337, 156, 89, 23);
		contentPane.add(deleteBt);
		
		updateBt = new JButton("Update");
		updateBt.setBounds(337, 208, 89, 23);
		contentPane.add(updateBt);
		
		lblTopic = new JLabel("Topic");
		lblTopic.setForeground(Color.BLUE);
		lblTopic.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTopic.setBounds(204, 11, 43, 22);
		contentPane.add(lblTopic);
		
		JButton btnComplexQuery = new JButton("Complex Query");
		btnComplexQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new ComplexQuery().main1("xxv");
			}
		});
		btnComplexQuery.setBounds(172, 261, 107, 23);
		contentPane.add(btnComplexQuery);
		
		viewBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new View().main1(viewCB.getSelectedItem().toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		insertBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Insert().main1(insertCB.getSelectedItem().toString());

			}
		});
		deleteBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Delete().main1(deleteCB.getSelectedItem().toString());
			}
		});
		updateBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Update().main1(updateCB.getSelectedItem().toString());
			}
		});
	
	}
}
