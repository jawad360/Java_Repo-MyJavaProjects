import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JProgressBar;


public class GUI extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Jawad Sonalkar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 151, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 41, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 260, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JToggleButton tglbtnButton = new JToggleButton("Button");
		tglbtnButton.setAction(action);
		sl_contentPane.putConstraint(SpringLayout.NORTH, tglbtnButton, 49, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, tglbtnButton, 21, SpringLayout.WEST, contentPane);
		contentPane.add(tglbtnButton);
		
		JButton btnButton = new JButton("Button 2");
		btnButton.setAction(action_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnButton, 33, SpringLayout.SOUTH, tglbtnButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnButton, 0, SpringLayout.EAST, tglbtnButton);
		contentPane.add(btnButton);
		
		JMenu mnNewMenu = new JMenu("New menu");
		sl_contentPane.putConstraint(SpringLayout.WEST, mnNewMenu, 75, SpringLayout.EAST, tglbtnButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, mnNewMenu, 0, SpringLayout.SOUTH, tglbtnButton);
		contentPane.add(mnNewMenu);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(17);
		sl_contentPane.putConstraint(SpringLayout.WEST, progressBar, 33, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, progressBar, -37, SpringLayout.SOUTH, contentPane);
		contentPane.add(progressBar);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
