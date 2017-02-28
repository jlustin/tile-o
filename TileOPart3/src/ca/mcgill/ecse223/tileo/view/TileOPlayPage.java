package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.tileo.application.TileOApplication;
import ca.mcgill.ecse223.tileo.controller.DesignModeController;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JLabel;

public class TileOPlayPage extends JFrame {

	private static TilePanel grid = new TilePanel(TileOApplication.getTileO().getCurrentGame());
	
	
	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TileODesignPage frame = new TileODesignPage();
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
	public TileOPlayPage() {
		WelcomePage wp = new WelcomePage();
		wp.setVisible(true);
		initComponents();
		refreshData();
	}
	
	public void close() { 
		this.setVisible(false);
	    this.dispose();
	}
	
	private void initComponents(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setBounds(100, 100, 450, 300);
		this.setSize(1200, 720);
		this.setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setSize(490, 720);
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setVisible(true);
		//contentPane.setLayout(gl_contentPane);
		
		//----------------------------------------------------------------------------------------------------
//		TilePanel grid = new TilePanel(TileOApplication.getTileO().getCurrentGame());
//		grid.setVisible(true);
//		grid.setSize(700, 720);
//		
		
		
		
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setSize(1200, 720);
	    splitPane.setDividerSize(0);
	    splitPane.setDividerLocation(710);
	    splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
	    splitPane.setLeftComponent(grid);
	    splitPane.setRightComponent(contentPane);
	    
	    JLabel lblNewLabel = new JLabel("JLabel for Player x's Turn");
	    
	    JLabel lblJlabelForErrors = new JLabel("JLabel for Errors");
	    
	    JLabel lblJlabelForMode = new JLabel("JLabel for Mode");
	    
	    JButton btnSave = new JButton("Save");
	    btnSave.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		// TODO: Save the game
	    		
	    	}
	    });
	    
	    JButton btnRollDie = new JButton("Roll Die");
	    btnRollDie.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		// TODO: Roll the die
	    		
	    	}
	    });
	    GroupLayout gl_contentPane = new GroupLayout(contentPane);
	    gl_contentPane.setHorizontalGroup(
	    	gl_contentPane.createParallelGroup(Alignment.TRAILING)
	    		.addGroup(gl_contentPane.createSequentialGroup()
	    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_contentPane.createSequentialGroup()
	    					.addGap(181)
	    					.addComponent(lblNewLabel))
	    				.addGroup(gl_contentPane.createSequentialGroup()
	    					.addGap(202)
	    					.addComponent(lblJlabelForErrors)))
	    			.addContainerGap(181, Short.MAX_VALUE))
	    		.addGroup(gl_contentPane.createSequentialGroup()
	    			.addContainerGap(203, Short.MAX_VALUE)
	    			.addComponent(lblJlabelForMode)
	    			.addGap(204))
	    		.addGroup(gl_contentPane.createSequentialGroup()
	    			.addContainerGap(416, Short.MAX_VALUE)
	    			.addComponent(btnSave)
	    			.addContainerGap())
	    		.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
	    			.addContainerGap()
	    			.addComponent(btnRollDie)
	    			.addContainerGap(384, Short.MAX_VALUE))
	    );
	    gl_contentPane.setVerticalGroup(
	    	gl_contentPane.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_contentPane.createSequentialGroup()
	    			.addGap(23)
	    			.addComponent(lblNewLabel)
	    			.addGap(18)
	    			.addComponent(lblJlabelForErrors)
	    			.addGap(18)
	    			.addComponent(lblJlabelForMode)
	    			.addGap(30)
	    			.addComponent(btnRollDie)
	    			.addPreferredGap(ComponentPlacement.RELATED, 501, Short.MAX_VALUE)
	    			.addComponent(btnSave)
	    			.addContainerGap())
	    );
	    contentPane.setLayout(gl_contentPane);

	    getContentPane().add(splitPane);
	    
	    
	}
		
	public static void refreshData(){
		grid.setGame(TileOApplication.getTileO().getCurrentGame());
		grid.setVisible(true);
		grid.setSize(700, 720);
		
	}
	


}
