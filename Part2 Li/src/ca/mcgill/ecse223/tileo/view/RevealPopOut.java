package ca.mcgill.ecse223.tileo.view;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ca.mcgill.ecse223.tileo.controller.InvalidInputException;
import ca.mcgill.ecse223.tileo.controller.PlayController;
import ca.mcgill.ecse223.tileo.model.Tile;

import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RevealPopOut extends JFrame{
	
	private final JPanel contentPanel = new JPanel();
	private PlayController pmc = TileOPlayPage.pmc;
	private JLabel revealLbl;
	private JButton tileSelectedBtn;
	private JButton rememberBtn;
	private int choosen = 0;
	private String error;
	private Tile chosenTile = null;
	
	
	public RevealPopOut() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setAlwaysOnTop(true);
		init();
	}
	
	
	private void init() {
		setTitle("Reveal Action Card");
		setResizable(false);
		setBounds(500, 200, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		
		revealLbl = new JLabel("Select a Tile to reveal it's type");
		
		tileSelectedBtn = new JButton("Tile Selected");
		tileSelectedBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (TileOPlayPage.getGrid().aTileIsSelected){
					chosenTile = TileOPlayPage.getGrid().selectedTile;
				}
				if (chosenTile == null) {
					error = "Please click a tile on the board!";
				}
				try {
					pmc.playRevealActionCard(chosenTile);
					TileOPlayPage.refreshData();
					
				} catch (InvalidInputException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		rememberBtn = new JButton("I'll remember!");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(118)
							.addComponent(revealLbl))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(tileSelectedBtn)
							.addGap(51)
							.addComponent(rememberBtn)))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(revealLbl)
					.addGap(100)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tileSelectedBtn)
						.addComponent(rememberBtn))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	public void close() { 
		this.setVisible(false);
	    this.dispose();
	}
}
