package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.tileo.application.TileOApplication;
import ca.mcgill.ecse223.tileo.controller.InvalidInputException;
import ca.mcgill.ecse223.tileo.controller.PlayController;
import ca.mcgill.ecse223.tileo.model.Tile;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NoPossibleMovesPopOut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private PlayController pmc = TileOPlayPage.pmc;


	public void close() { 
		this.setVisible(false);
	    this.dispose();
	}
	/**
	 * Create the dialog.
	 */
	public NoPossibleMovesPopOut() {
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Sucks For You!");
		setBounds(500, 200, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblLooksLikeYoure = new JLabel("Looks like you're stuck on a tile :( Pass your turn.");
			contentPanel.add(lblLooksLikeYoure);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Feels Bad, Man.");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TileOPlayPage.refreshData();
						TileOPlayPage.setError("");
						Tile cTile = TileOApplication.getTileO().getCurrentGame().getCurrentPlayer().getCurrentTile();
						try {
							pmc.land(cTile);
						} catch (InvalidInputException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}						
						//(TileOApplication.getTileO().getCurrentGame()).setNextPlayer();						
						close();
						TileOPlayPage.refreshData();
					}
				});
				okButton.setActionCommand("FeelsBad");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
