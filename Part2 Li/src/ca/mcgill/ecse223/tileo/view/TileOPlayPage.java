package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.tileo.application.TileOApplication;
import ca.mcgill.ecse223.tileo.controller.InvalidInputException;
import ca.mcgill.ecse223.tileo.controller.PlayController;
import ca.mcgill.ecse223.tileo.controller.PlayModeController;
import ca.mcgill.ecse223.tileo.model.Game;
import ca.mcgill.ecse223.tileo.model.Game.Mode;
import ca.mcgill.ecse223.tileo.model.Player;
import ca.mcgill.ecse223.tileo.model.Tile;
import ca.mcgill.ecse223.tileo.model.TileO;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class TileOPlayPage extends JFrame {

	private static TilePanelPlay grid = new TilePanelPlay(TileOApplication.getTileO().getCurrentGame());
	public static PlayController pmc = new PlayController();
	static String currentPlayer;
	public static List<Tile> possibleMoves;
	private static int currentPlayerNb = 1;
	
	
	private JPanel contentPane;
	private static JLabel playerTurnLbl;
	private static JLabel modeLbl;
	private JLabel errorLbl;
	private JPanel actionCardPnl;
	static JButton btnRollDie;
	private JButton gotItBtn;
	

	/**
	 * Create the frame.
	 */
	public TileOPlayPage() {
		setTitle("Play Mode");
		initComponents();
		refreshData();
	}
	
	public void close() { 
		this.setVisible(false);
	    this.dispose();
	}
	
	private void initComponents(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.setSize(1200, 720);
		this.setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setSize(490, 720);

		contentPane.setVisible(true);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setSize(1200, 720);
	    splitPane.setDividerSize(0);
	    splitPane.setDividerLocation(710);
	    splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
	    splitPane.setLeftComponent(grid);
	    splitPane.setRightComponent(contentPane);
	    
	    playerTurnLbl = new JLabel();
	    playerTurnLbl.setText("It is currently player X's turn.");
	    playerTurnLbl.setFont(new Font("Lucida Grande", Font.BOLD, 14));
	    
	    errorLbl = new JLabel("");
	    errorLbl.setForeground(Color.RED);
	    
	    modeLbl = new JLabel("");
	    
	    JButton saveBtn = new JButton("Save");
	    saveBtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		PlayModeController pmc = new PlayModeController();
	    		pmc.saveGame();
	    		SavePopOut spo = new SavePopOut();
	    		spo.setVisible(true);
	    		refreshData();
	    		
	    	}
	    });
	    
	    btnRollDie = new JButton("Roll Die");
	    btnRollDie.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		pmc.rollDie();
	    		possibleMoves = pmc.getPossibleMoves();
	    		grid.isAPlayerTurn = true;
	    		refreshData();
	    		grid.possibleMoves = possibleMoves;
	    		grid.refreshBoard();
	    		
	    		SelectTilePlayPopOut stpop = new SelectTilePlayPopOut();
	    		stpop.setVisible(true);
	    	}
	    });
	    
	    actionCardPnl = new JPanel();
	    
	    gotItBtn = new JButton("Got it!");
	    gotItBtn.setVisible(false);
	    GroupLayout gl_contentPane = new GroupLayout(contentPane);
	    gl_contentPane.setHorizontalGroup(
	    	gl_contentPane.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_contentPane.createSequentialGroup()
	    			.addGap(22)
	    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_contentPane.createSequentialGroup()
	    					.addComponent(btnRollDie)
	    					.addPreferredGap(ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
	    					.addComponent(actionCardPnl, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
	    				.addComponent(modeLbl)
	    				.addGroup(gl_contentPane.createSequentialGroup()
	    					.addComponent(errorLbl)
	    					.addPreferredGap(ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
	    					.addComponent(gotItBtn))
	    				.addComponent(playerTurnLbl))
	    			.addGap(33))
	    		.addGroup(gl_contentPane.createSequentialGroup()
	    			.addGap(30)
	    			.addComponent(saveBtn)
	    			.addContainerGap(383, Short.MAX_VALUE))
	    );
	    gl_contentPane.setVerticalGroup(
	    	gl_contentPane.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_contentPane.createSequentialGroup()
	    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_contentPane.createSequentialGroup()
	    					.addGap(17)
	    					.addComponent(playerTurnLbl)
	    					.addPreferredGap(ComponentPlacement.UNRELATED)
	    					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
	    						.addComponent(errorLbl)
	    						.addComponent(gotItBtn))
	    					.addPreferredGap(ComponentPlacement.UNRELATED)
	    					.addComponent(modeLbl)
	    					.addGap(48)
	    					.addComponent(btnRollDie)
	    					.addGap(479)
	    					.addComponent(saveBtn))
	    				.addGroup(gl_contentPane.createSequentialGroup()
	    					.addGap(106)
	    					.addComponent(actionCardPnl, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)))
	    			.addContainerGap(19, Short.MAX_VALUE))
	    );
	    contentPane.setLayout(gl_contentPane);

	    getContentPane().add(splitPane);
	    
	    
	}
		
	public static void refreshData(){
		TileO tileO = TileOApplication.getTileO();
		if (tileO.hasGames() && !(tileO.getCurrentGame().getMode() == Mode.DESIGN)){
			Game currentGame = tileO.getCurrentGame();
			Game.Mode currentMode = currentGame.getMode();
			Player player = currentGame.getCurrentPlayer();						
			currentPlayerNb = player.getNumber();
			
			grid.setGame(currentGame);
			try {
				pmc.load(tileO.indexOfGame(currentGame));
			} catch (InvalidInputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			grid.setVisible(true);
			grid.setSize(700, 720);
			
			playerTurnLbl.setText("It is currently player " + currentPlayerNb + "'s turn.");
			modeLbl.setText("CurrentMode: " + pmc.getModeFullName());
			
			switch (currentMode){
				case GAME_ROLLDIEACTIONCARD:
					RollDiePopOut rdpo = new RollDiePopOut();
					rdpo.setVisible(true);
					break;
				case GAME_CONNECTTILESACTIONCARD:
					AddConnectionActionCardPopOut acacpo = new AddConnectionActionCardPopOut();
					acacpo.setVisible(true);
					break;
				case GAME_REMOVECONNECTIONACTIONCARD:
					RemoveConnectionActionCardPopOut rcacpo = new RemoveConnectionActionCardPopOut();
					rcacpo.setVisible(true);
					break;
				case GAME_TELEPORTACTIONCARD:
					TeleportPopOut tpo = new TeleportPopOut();
					tpo.setVisible(true);
					break;
				case GAME_LOSETURNACTIONCARD:
					LoseTurnWarningPopOut ltwpo = new LoseTurnWarningPopOut();
					ltwpo.setVisible(true);
					break;
				case GAME_WON:
					GameWonPopOut gwpo = new GameWonPopOut();
					gwpo.setVisible(true);
				default:
			}
				
		}
		
	}
	

	public static TilePanelPlay getGrid(){
		return grid;
	}
}
