package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.tileo.controller.DesignModeController;
import ca.mcgill.ecse223.tileo.controller.InvalidInputException;
import ca.mcgill.ecse223.tileo.controller.PlayModeController;
import ca.mcgill.ecse223.tileo.model.Tile;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectTilePlayPopOut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	Tile chosenTile=null;
	String error;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			SelectTilePlayPopOut dialog = new SelectTilePlayPopOut();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	
	public void close() { 
		this.setVisible(false);
	    this.dispose();
	}
	
	
	public SelectTilePlayPopOut() {
		setTitle("Move To A Tile");
		setResizable(false);
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblPleaseClickOn = new JLabel("Please click on a highlighted tile on the board in order to move to it.");
			contentPanel.add(lblPleaseClickOn);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Move To This Tile");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						PlayModeController pmc = new PlayModeController();
						if (TileODesignPage.getGrid().aTileIsSelected){
							chosenTile = TileODesignPage.getGrid().selectedTile;
							try {
								pmc.landedOnTile(chosenTile);
							} catch (InvalidInputException e) {
								throw new RuntimeException(e.getMessage());
							}
							
						}
					}
				});
				okButton.setActionCommand("MoveToThisTile");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
