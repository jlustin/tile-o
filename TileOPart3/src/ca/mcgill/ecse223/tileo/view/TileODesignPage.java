package ca.mcgill.ecse223.tileo.view;

import javax.swing.JApplet;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TileODesignPage extends JApplet {

	/**
	 * Create the applet.
	 */
	public TileODesignPage() {
		
		JLabel lblYeye = new JLabel("Yeye");
		
		JButton btnYeyeeeeee = new JButton("Yeyeeeeee");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(154)
							.addComponent(lblYeye))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(100)
							.addComponent(btnYeyeeeeee)))
					.addContainerGap(235, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblYeye)
					.addGap(98)
					.addComponent(btnYeyeeeeee)
					.addContainerGap(102, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
