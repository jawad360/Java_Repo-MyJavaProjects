import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;


public class Gui extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	public Gui() {
		setTitle("jawad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JTextArea textArea = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea, 24, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea, -276, SpringLayout.EAST, contentPane);
		textArea.setTabSize(50);
		textArea.setBackground(new Color(175, 238, 238));
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("New button");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 5, SpringLayout.SOUTH, textArea);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 24, SpringLayout.WEST, contentPane);
		btnNewButton.setAction(action);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox, 20, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox, 27, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox, 165, SpringLayout.WEST, contentPane);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"jh", "kj", "lk", "lk"}));
		contentPane.add(comboBox);
		
		JSpinner spinner = new JSpinner();
		sl_contentPane.putConstraint(SpringLayout.NORTH, spinner, 25, SpringLayout.SOUTH, comboBox);
		sl_contentPane.putConstraint(SpringLayout.WEST, spinner, 0, SpringLayout.WEST, textArea);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinner, 95, SpringLayout.WEST, textArea);
		contentPane.add(spinner);
		
		JProgressBar progressBar = new JProgressBar();
		sl_contentPane.putConstraint(SpringLayout.NORTH, progressBar, 26, SpringLayout.SOUTH, spinner);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, progressBar, -32, SpringLayout.SOUTH, contentPane);
		progressBar.setValue(34);
		sl_contentPane.putConstraint(SpringLayout.WEST, progressBar, 30, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, progressBar, 332, SpringLayout.WEST, contentPane);
		
		for(int i=1;i<=100;i++)
		progressBar.setValue(i);
		progressBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			}
		});
		contentPane.add(progressBar);
		
		JLabel lblImage = new JLabel("Image");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblImage, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblImage, 47, SpringLayout.EAST, textArea);
		contentPane.add(lblImage);
		
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
