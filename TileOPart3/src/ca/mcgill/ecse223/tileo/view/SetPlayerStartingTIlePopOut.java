package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetPlayerStartingTIlePopOut extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SetPlayerStartingTIlePopOut frame = new SetPlayerStartingTIlePopOut();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public void close() { 
		this.setVisible(false);
	    this.dispose();
	}
	
	public SetPlayerStartingTIlePopOut() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSelectTheNumber = new JLabel("Select the player's number and");
		
		JRadioButton radioButton = new JRadioButton("2");
		
		JRadioButton radioButton_1 = new JRadioButton("3");
		
		JRadioButton radioButton_2 = new JRadioButton("4");
		
		JRadioButton radioButton_3 = new JRadioButton("1");
		
		JLabel lblChooseItsStarting = new JLabel("choose its starting tile from the board.");
		
		JButton btnSet = new JButton("Set");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(190)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(radioButton_2)
								.addComponent(radioButton_1)
								.addComponent(radioButton)
								.addComponent(radioButton_3)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(129)
							.addComponent(lblSelectTheNumber))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(97)
							.addComponent(lblChooseItsStarting))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(171)
							.addComponent(btnSet)))
					.addContainerGap(99, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSelectTheNumber)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblChooseItsStarting)
					.addGap(24)
					.addComponent(radioButton_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(radioButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(radioButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(radioButton_2)
					.addGap(28)
					.addComponent(btnSet)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
