package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.tileo.application.TileOApplication;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NoPossibleMovesPopOut extends JDialog {

	private final JPanel contentPanel = new JPanel();


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
						(TileOApplication.getTileO().getCurrentGame()).setNextPlayer();
						TileOPlayPage.refreshData();
						close();
					}
				});
				okButton.setActionCommand("FeelsBad");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
