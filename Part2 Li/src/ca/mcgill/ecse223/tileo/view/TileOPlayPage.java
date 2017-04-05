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
import javax.swing.JTextField;

public class TileOPlayPage extends JFrame {

	private static TilePanelPlay grid = new TilePanelPlay(TileOApplication.getTileO().getCurrentGame());
	public static PlayController pmc = new PlayController();
	static String currentPlayer;
	public static List<Tile> pMoves;
	private static int currentPlayerNb = 1;
	
	//all our pop outs
	private static AddConnectionActionCardPopOut addConnectionPO = new AddConnectionActionCardPopOut();
	private static LoseTurnWarningPopOut loseTurnPO = new LoseTurnWarningPopOut();
//	private static NoPossibleMovesPopOut noMovesPO = new NoPossibleMovesPopOut();
	private static RemoveConnectionActionCardPopOut removeConnectionPO = new RemoveConnectionActionCardPopOut();
	private static RevealPopOut revealPO = new RevealPopOut();
	private static RollDiePopOut rollPO = new RollDiePopOut();
//	private static SavePopOut savePO = new SavePopOut();
//	private static SelectTilePlayPopOut selectTilePO = new SelectTilePlayPopOut();
	private static TeleportPopOut teleportPO = new TeleportPopOut();
	private static RevealTilesPopOut revealTilesPO = new RevealTilesPopOut();
	
	private JPanel contentPane;
	private static JLabel playerTurnLbl;
	private static JLabel modeLbl;
	private static JLabel errorLbl;
	private JPanel actionCardPnl;
	static JButton btnRollDie;
	private JButton gotItBtn;
	private static JLabel gameModeLbl;
	private static JLabel p1InactivityLbl = new JLabel("");
	private static JLabel p2InactivityLbl = new JLabel("");
	private static JLabel p3InactivityLbl = new JLabel("");
	private static JLabel p4InactivityLbl = new JLabel("");
	

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
	
	public static void setError(String error ){
		errorLbl.setText(error);
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
	    		if(pmc.getMode().equals(PlayController.Mode.Ready) || pmc.getMode().equals(PlayController.Mode.Roll)){
	    			pmc.saveGame();
		    		SavePopOut spo = new SavePopOut();
		    		spo.setVisible(true);
		    		//refreshData();
	    		}
	    		else {
	    			errorLbl.setText("You cannot save during an action");
	    		}
	    		
	    	}
	    });
	    
	    btnRollDie = new JButton("Roll Die");
	    btnRollDie.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		if(pmc.getMode() == PlayController.Mode.Roll){
	    			pmc.rollDie();	    		
		    		pMoves = pmc.getPossibleMoves();
		    		
		    		grid.isAPlayerTurn = true; 	    		
		    		refreshData();
		    		
		    		TileOPlayPage.getGrid().aTileIsSelected = false;
					TileOPlayPage.getGrid().aConnectionIsSelected = false;
					TileOPlayPage.getGrid().selectedConnection = null;
					TileOPlayPage.getGrid().selectedTile = null;
		    		
		    		grid.possibleMoves = pMoves;
		    		grid.refreshBoard();
		    		
		    		
		    		if (pMoves.isEmpty()){
		    			NoPossibleMovesPopOut npm = new NoPossibleMovesPopOut();
						npm.setVisible(true);					
						TileOPlayPage.refreshData();
						refreshData();
		    		}
		    		else {
		    			SelectTilePlayPopOut stpop = new SelectTilePlayPopOut();
			    		stpop.setVisible(true);
		    		}
	    		}
	    		else{
	    			errorLbl.setText("Can't roll. Lmao.");
	    		}
	    		
	    		
	    	}
	    });
	    
	    actionCardPnl = new JPanel();
	    
	    gotItBtn = new JButton("Got it!");
	    gotItBtn.setVisible(false);
	    
	    gameModeLbl = new JLabel("Game.Mode");
	    
//	    p1InactivityLbl.setText("Player1 inactivity:");
//	    
//	    p2InactivityLbl.setText("Player 2 inactivity:");
//	    
//	    p3InactivityLbl.setText("Player 3 inactivity:");
//	    
//	    p4InactivityLbl.setText("Player 4 inactivity:");
	    GroupLayout gl_contentPane = new GroupLayout(contentPane);
	    gl_contentPane.setHorizontalGroup(
	    	gl_contentPane.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_contentPane.createSequentialGroup()
	    			.addGap(30)
	    			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
	    				.addComponent(saveBtn)
	    				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	    					.addComponent(p2InactivityLbl)
	    					.addComponent(p1InactivityLbl)
	    					.addComponent(p3InactivityLbl)
	    					.addComponent(p4InactivityLbl)))
	    			.addContainerGap(343, Short.MAX_VALUE))
	    		.addGroup(gl_contentPane.createSequentialGroup()
	    			.addGap(22)
	    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_contentPane.createSequentialGroup()
	    					.addComponent(modeLbl)
	    					.addContainerGap())
	    				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	    					.addGroup(gl_contentPane.createSequentialGroup()
	    						.addComponent(playerTurnLbl)
	    						.addContainerGap())
	    					.addGroup(gl_contentPane.createSequentialGroup()
	    						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
	    							.addGroup(gl_contentPane.createSequentialGroup()
	    								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	    									.addComponent(btnRollDie)
	    									.addGroup(gl_contentPane.createSequentialGroup()
	    										.addGap(9)
	    										.addComponent(gameModeLbl)))
	    								.addPreferredGap(ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
	    								.addComponent(actionCardPnl, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
	    							.addGroup(gl_contentPane.createSequentialGroup()
	    								.addComponent(errorLbl)
	    								.addPreferredGap(ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
	    								.addComponent(gotItBtn)))
	    						.addGap(33)))))
	    );
	    gl_contentPane.setVerticalGroup(
	    	gl_contentPane.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_contentPane.createSequentialGroup()
	    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_contentPane.createSequentialGroup()
	    					.addGap(46)
	    					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
	    						.addComponent(errorLbl)
	    						.addComponent(gotItBtn)))
	    				.addGroup(gl_contentPane.createSequentialGroup()
	    					.addGap(17)
	    					.addComponent(playerTurnLbl)))
	    			.addPreferredGap(ComponentPlacement.RELATED)
	    			.addComponent(modeLbl)
	    			.addPreferredGap(ComponentPlacement.RELATED)
	    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_contentPane.createSequentialGroup()
	    					.addGap(62)
	    					.addComponent(gameModeLbl)
	    					.addGap(29)
	    					.addComponent(btnRollDie)
	    					.addGap(189)
	    					.addComponent(p1InactivityLbl)
	    					.addPreferredGap(ComponentPlacement.RELATED)
	    					.addComponent(p2InactivityLbl)
	    					.addPreferredGap(ComponentPlacement.RELATED)
	    					.addComponent(p3InactivityLbl)
	    					.addPreferredGap(ComponentPlacement.RELATED)
	    					.addComponent(p4InactivityLbl)
	    					.addGap(155)
	    					.addComponent(saveBtn))
	    				.addGroup(gl_contentPane.createSequentialGroup()
	    					.addGap(9)
	    					.addComponent(actionCardPnl, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)))
	    			.addContainerGap(22, Short.MAX_VALUE))
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
			gameModeLbl.setText("CurrentGameMode: " + currentGame.getModeFullName());
			
//			p1InactivityLbl.setText("Player 1 inactivity: " + currentGame.getPlayer(0).getTurnsUntilActive());
//			p2InactivityLbl.setText("Player 2 inactivity: " + currentGame.getPlayer(1).getTurnsUntilActive());
//			p3InactivityLbl.setText("Player 3 inactivity: " + currentGame.getPlayer(2).getTurnsUntilActive());
//			p4InactivityLbl.setText("Player 4 inactivity: " + currentGame.getPlayer(3).getTurnsUntilActive());

			
			switch (currentMode){
				case GAME_ROLLDIEACTIONCARD:
					rollPO.setVisible(true);
					break;
				case GAME_CONNECTTILESACTIONCARD:
					addConnectionPO.setVisible(true);
					break;
				case GAME_REMOVECONNECTIONACTIONCARD:
					removeConnectionPO.setVisible(true);
					break;
				case GAME_TELEPORTACTIONCARD:
					teleportPO.setVisible(true);
					break;
				case GAME_LOSETURNACTIONCARD:
					loseTurnPO.setVisible(true);
					break;
				case GAME_REVEALACTIONCARD:
					revealPO.setVisible(true);
					break;
					
				case GAME_LOSETURNRANDOMLYACTIONCARD:
					break;
				case GAME_REVEALACTIONTILESACTIONCARD:
					revealTilesPO.setVisible(true);
					break;
				case GAME_TURNACTIONTILESINACTIVEACTIONCARD:
					break;
				case GAME_WINTILEHINTACTIONCARD:
					break;
				case GAME_SENDBACKTOSTARTACTIONCARD:
					break;
				case GAME_TELEPORTOTHERACTIONCARD:
					break;
				case GAME_WON:
					GameWonPopOut gameWonPO = new GameWonPopOut();
					gameWonPO.setVisible(true);
				default:
			}
		}		
	}
	
	public static TilePanelPlay getGrid(){
		return grid;
	}
}
