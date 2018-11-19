package listnertest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;
import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JProgressBar;
import javax.swing.JLabel;

public class ListenrTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	JProgressBar progressBar;
	JSlider slider;
	private JLabel lblNewLabel;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListenrTest frame = new ListenrTest();
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
	public ListenrTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		 progressBar = new JProgressBar();
		 progressBar.setValue(10);
		contentPane.add(progressBar);
		 
		 lblNewLabel = new JLabel("10");
		 contentPane.add(lblNewLabel);
		
		 slider = new JSlider();
		slider.setValue(10);
		contentPane.add(slider);
	
		ChangeListener listener = new ChangeListener()
		{
			

			@Override
			public void stateChanged(ChangeEvent e) 
			{
				int x = slider.getValue();
				progressBar.setValue(x);
				lblNewLabel.setText(Integer.toString(x));
			}
			
		};
		slider.addChangeListener(listener );
	}

}
