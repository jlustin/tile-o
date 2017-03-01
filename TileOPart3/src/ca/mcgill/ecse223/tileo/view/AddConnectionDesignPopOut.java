package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.tileo.controller.DesignModeController;
import ca.mcgill.ecse223.tileo.controller.InvalidInputException;
import ca.mcgill.ecse223.tileo.model.Tile;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddConnectionDesignPopOut extends JDialog {
	
	private Tile chosenTile1;
	private Tile chosenTile2;
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			AddConnectionDesignPopOut dialog = new AddConnectionDesignPopOut();
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
	
	public AddConnectionDesignPopOut() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setTitle("Connect Two Tiles");
		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblChooseYoTiles = new JLabel("Choose yo tiles");
			contentPanel.add(lblChooseYoTiles);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnTileChosen = new JButton("Tile 1 Chosen");
				btnTileChosen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if (TileODesignPage.getGrid().aTileIsSelected){
							chosenTile1 = TileODesignPage.getGrid().selectedTile;
						}
					}
				});
				buttonPane.add(btnTileChosen);
			}
			{
				JButton btnChosenTile = new JButton("Tile 2 Chosen");
				btnChosenTile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (TileODesignPage.getGrid().aTileIsSelected){
							chosenTile2 = TileODesignPage.getGrid().selectedTile;
						}
					}
				});
				buttonPane.add(btnChosenTile);
			}
			{
				JButton okButton = new JButton("Connect!");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DesignModeController dmc = new DesignModeController();
						
							try {
								dmc.connectTwoTiles(chosenTile1, chosenTile2);
								close();
							} catch (InvalidInputException e1) {
								throw new RuntimeException(e1.getMessage());
							}
						
					}
				});
				okButton.setActionCommand("Connect");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						close();						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
