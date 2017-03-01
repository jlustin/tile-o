package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.tileo.application.TileOApplication;
import ca.mcgill.ecse223.tileo.controller.DesignModeController;
import ca.mcgill.ecse223.tileo.controller.InvalidInputException;
import ca.mcgill.ecse223.tileo.controller.PlayModeController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveConnectionActionCardPopOut extends JFrame {
	
	public void close() { 
		this.setVisible(false);
	    this.dispose();
	}
	
	private static TilePanelPlay grid = new TilePanelPlay(TileOApplication.getTileO().getCurrentGame());
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RemoveConnectionActionCardPopOut frame = new RemoveConnectionActionCardPopOut();
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
	public RemoveConnectionActionCardPopOut() {
		setTitle("Remove Connection Action Card");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblYouHaveDrawn = new JLabel("You have drawn a Remove Connection Action Card.");
		lblYouHaveDrawn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblSelectAConnection = new JLabel("Select a connection on the board to remove it.");
		lblSelectAConnection.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnRemoveConnection = new JButton("Remove Connection");
		btnRemoveConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(grid.aConnectionIsSelected){
					PlayModeController pmc = new PlayModeController();
					
					try 
					{						
						pmc.playRemoveConnectionActionCard(grid.selectedConnection);
						close();
					}
					catch (InvalidInputException e2){
						throw new RuntimeException (e2.getMessage());
					}
				}
				
			}
			
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(87)
							.addComponent(lblSelectAConnection))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addComponent(lblYouHaveDrawn)))
					.addContainerGap(64, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(153, Short.MAX_VALUE)
					.addComponent(btnRemoveConnection)
					.addGap(142))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblYouHaveDrawn)
					.addGap(11)
					.addComponent(lblSelectAConnection)
					.addPreferredGap(ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
					.addComponent(btnRemoveConnection)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
