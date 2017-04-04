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

public class TeleportOtherPopOut extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeleportOtherPopOut frame = new TeleportOtherPopOut();
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
	public TeleportOtherPopOut() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("You have drawn a TeleportOther Action Card!");
		
		JLabel lblPleaseSelectA = new JLabel("Please select a player you would like to move and the tile");
		
		JRadioButton rdbtnPlayer = new JRadioButton("Player 1");
		
		JRadioButton rdbtnPlayer_1 = new JRadioButton("Player 2");
		
		JRadioButton rdbtnPlayer_2 = new JRadioButton("Player 3");
		
		JRadioButton rdbtnPlayer_3 = new JRadioButton("Player 4");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(84)
					.addComponent(lblNewLabel)
					.addContainerGap(134, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(46, Short.MAX_VALUE)
					.addComponent(lblPleaseSelectA)
					.addGap(35))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnPlayer_3)
						.addComponent(rdbtnPlayer_2)
						.addComponent(rdbtnPlayer_1)
						.addComponent(rdbtnPlayer))
					.addContainerGap(274, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(lblPleaseSelectA)
					.addGap(41)
					.addComponent(rdbtnPlayer)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnPlayer_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnPlayer_2)
					.addGap(18)
					.addComponent(rdbtnPlayer_3)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
