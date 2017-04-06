package ca.mcgill.ecse223.tileo.view;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ca.mcgill.ecse223.tileo.application.TileOApplication;
import ca.mcgill.ecse223.tileo.controller.InvalidInputException;
import ca.mcgill.ecse223.tileo.controller.PlayController;
import ca.mcgill.ecse223.tileo.model.Tile;

import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class RevealTilesPopOut extends JFrame{
	
	private JPanel contentPane;
	private PlayController pmc = TileOPlayPage.pmc;
	
	private JLabel lblYouHaveDrawn;
	private JLabel lblWhenReady;
	private JLabel lblAllTheAction;
	private JLabel errorLbl;
	private String error = "";
	private JButton revealBtn;
	private JButton btnClose;
	
	public static boolean used = false;
	public static boolean showing = true;
	

	/**
	 * Create the frame.
	 * @throws InvalidInputException 
	 */
	public void close(){ 
		this.setVisible(false);
		used = false;
		error = "";
		errorLbl.setText(error);
		TileOPlayPage.getGrid().showActionTiles = false;
		TileOPlayPage.refreshData();
	}
	
	public RevealTilesPopOut() {
		setTitle("Reveal Action Tiles Action Card");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblYouHaveDrawn = new JLabel("You have drawn a Reveal Action Tiles Action Card,");
		lblYouHaveDrawn.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblWhenReady = new JLabel("when ready, click on reveal tiles to reveal");
		lblWhenReady.setHorizontalAlignment(SwingConstants.CENTER);
		
		revealBtn = new JButton("Reveal Tiles");
		revealBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (used){
					error = "You have already revealed the action tiles!";
					errorLbl.setText(error);
				}
				else {
					TileOPlayPage.getGrid().showActionTiles = showing;
					TileOPlayPage.getGrid().setGame(TileOApplication.getTileO().getCurrentGame());
					TileOPlayPage.refreshData();
					try {
						pmc.playRevealActionTilesActionCard();
					} catch (InvalidInputException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
//					long startTime = System.nanoTime();
//					long fiveSec = (long) (5* Math.pow(10, 9));
//					long currentTime = System.nanoTime();
//					
//					while (currentTime < startTime + fiveSec)  {
//						currentTime = System.nanoTime();
//					}
//					TileOPlayPage.getGrid().showActionTiles = false;
//					TileOPlayPage.getGrid().setGame(TileOApplication.getTileO().getCurrentGame());
//					TileOPlayPage.refreshData();
					error = "";
					errorLbl.setText("");
					used = true;	
				}
			}
			
	});
		
		errorLbl = new JLabel("");
		errorLbl.setForeground(Color.RED);
		
		lblAllTheAction = new JLabel("all the action tiles for 5 seconds");
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!used) {
					error = "You haven't revealed the tiles yet";
					errorLbl.setText(error);
				}
				else {
					close();
				}
			}
		});
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(110)
					.addComponent(lblAllTheAction)
					.addContainerGap(127, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(92, Short.MAX_VALUE)
					.addComponent(lblWhenReady)
					.addGap(89))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(65, Short.MAX_VALUE)
					.addComponent(lblYouHaveDrawn)
					.addGap(60))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addComponent(revealBtn)
					.addGap(70)
					.addComponent(btnClose)
					.addContainerGap(98, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(81, Short.MAX_VALUE)
					.addComponent(errorLbl, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
					.addGap(72))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblYouHaveDrawn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblWhenReady)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAllTheAction)
					.addGap(29)
					.addComponent(errorLbl)
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(revealBtn)
						.addComponent(btnClose))
					.addGap(58))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
//	protected void refresh() {
//		if (used){
//			time();
//			TileOPlayPage.getGrid().showActionTiles = false;
//			TileOPlayPage.getGrid().refreshBoard();
//		}
//	}

	//waits 5 seconds
//	private void time(){
//		long startTime = System.nanoTime();
//		long fiveSec = (long) (5* Math.pow(10, 9));
//		long currentTime = System.nanoTime();
//		
//		while (currentTime < startTime + fiveSec)  {
//			currentTime = System.nanoTime();
//		}
//	}
	
}
