package ca.mcgill.ecse223.tileo.view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class RevealPopOut extends JFrame{
	public RevealPopOut() {
		setTitle("Reveal Action Card");
		
		JLabel revealLbl = new JLabel("Select a Tile to reveal it's type");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(118)
					.addComponent(revealLbl)
					.addContainerGap(145, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(revealLbl)
					.addContainerGap(233, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}

}
