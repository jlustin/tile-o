package ca.mcgill.ecse223.tileo.controller;

import ca.mcgill.ecse223.tileo.controller.InvalidInputException;

import java.util.List;

import ca.mcgill.ecse223.tileo.application.TileOApplication;
import ca.mcgill.ecse223.tileo.model.ActionTile;
import ca.mcgill.ecse223.tileo.model.ConnectTilesActionCard;
import ca.mcgill.ecse223.tileo.model.Connection;
import ca.mcgill.ecse223.tileo.model.Deck;
import ca.mcgill.ecse223.tileo.model.Game;
import ca.mcgill.ecse223.tileo.model.Game.Mode;
import ca.mcgill.ecse223.tileo.model.NormalTile;
import ca.mcgill.ecse223.tileo.model.Player;
import ca.mcgill.ecse223.tileo.model.RemoveConnectionActionCard;
import ca.mcgill.ecse223.tileo.model.RollDieActionCard;
import ca.mcgill.ecse223.tileo.model.TeleportActionCard;
import ca.mcgill.ecse223.tileo.model.Tile;
import ca.mcgill.ecse223.tileo.model.TileO;
import ca.mcgill.ecse223.tileo.model.WinTile;

public class DesignModeController {
	

	//METHODS
	private static final String rollDieInstruction = "Roll the die for an extra turn. ";
	private static final String connectTilesInstruction = "Connect two adjacent tiles with a connection piece from the pile of spare connection pieces. "; 
	private static final String teleportInstruction = "Move your playing piece to an arbitray tile that is not your current tile. ";
	private static final String removeConnectionInstruction = "Remove a connectio piece from the board and place it in the pile of spare connection pieces. ";
	
	//TileType is chosen from UI from a button
	public void addDesignTile(int x, int y, String TileType) throws InvalidInputException {
		
		Game game = TileOApplication.getTileO().getCurrentGame();
		DesignModeController dmc = new DesignModeController();
		
		if(TileType == "NormalTile")
		{
			NormalTile normalTile = new NormalTile(x,y,game);
            game.addTile(normalTile);
            
		}
		
		if(TileType == "ActionTile")
		{
			dmc.createActionTile(x, y, game);
		}
		
		if(TileType == "WinTile")
		{	
			dmc.createWinTile(x, y, game);
			
		}
	}
	
	
	
	/*
	 * 1. Create a game with a number of players
	 * Justin
	 */
	public void createGame(int numberOfPlayers) throws InvalidInputException{
		TileO tileO = TileOApplication.getTileO();
		// Add a new game to application and set it as current game
		Game game = new Game (0,tileO);
		tileO.setCurrentGame(game);
		// Set mode to "DESIGN"
		game.setMode(Mode.DESIGN);
		
		// Assign player numbers to each player
		for(int playerNumber = 1; playerNumber < numberOfPlayers; playerNumber++){
			game.addPlayer(playerNumber);
		}
	}
	
	/*
	 * 2. Place a tile on the game board
	 * Chris
	 */
	public void placeNormalTile(int x, int y) throws InvalidInputException {
		//TODO: CHRIS
	}
		
	
	/*
	 * 3. Remove a tile from the game board
	 * Li
	 */
	public void removeTileFromGame(Tile aTile) throws InvalidInputException{
		TileO tileO = TileOApplication.getTileO();
		Game currentGame = tileO.getCurrentGame();
		if (aTile.hasConnections()) {
			String error = "Cannot delete a tile that has connections.";
			throw new InvalidInputException(error.trim());
		}
		try
		{
			if (!aTile.hasConnections()) {
				aTile.delete();
			}
			//TileOApplication.save();
		}
		catch (RuntimeException e){
			throw new InvalidInputException (e.getMessage());
		}
	}
	
	
	/*
	 * 4. Connect two tiles with a connection piece
	 * Justin
	 */
	public void connectTwoTiles (Tile selectedTile1, Tile selectedTile2) throws InvalidInputException{
		TileO tileO = TileOApplication.getTileO();
		Game currentGame = tileO.getCurrentGame();
		
		int x1 = selectedTile1.getX();
		int y1 = selectedTile1.getY();
		int x2 = selectedTile2.getX();
		int y2 = selectedTile2.getY();
		
		String error = "";
		// Check if there are tiles that can be selected in the game
		if (currentGame.numberOfTiles() < 2){
			error = "There are less than 2 tiles in the current game.";
		}
		// Check if the selected tiles are adjacent
		if ((x1 != x2+1 && y1 == y2) || (x1 != x2-1 && y1 == y2)){
			error = error + "The selected tiles are not adjacent";
		}
		if ((y1 != y2+1 && x1 == x2) || (y1 != y2-1 && x1 == x2)){
			error = error + "The selected tiles are not adjacent";
		}
//		
//		if (currentGame.getCurrentConnectionPieces() < 1){
//			error = error + "There are 0 connection pieces in the game";
//		}
		
		// Check if there is an error
		if (error.length() > 0){
			throw new InvalidInputException (error.trim());
		}

		try
		{
			// Create a connection and add the connection to the selected tiles
			Connection newConnection =  currentGame.addConnection();
			selectedTile1.addConnection(newConnection);
			selectedTile2.addConnection(newConnection);
		}
		catch (RuntimeException e)
		{
			error = e.getMessage();
			throw new InvalidInputException (error);
		}
	}
	
	
	/*
	 * 5. Remove connection between two tiles
	 * Justin
	 */
	public void removeConnection (Connection selectedConnection) throws InvalidInputException{
		TileO tileO = TileOApplication.getTileO();
		Game currentGame = tileO.getCurrentGame();
		String error = "";
		
		// Check if there are conneciton pieces in the game
		if (currentGame.getCurrentConnectionPieces() <= 0){
			error = error + "There are no connection pieces in the current game.";
		}
		// Check if error detected
		if (error.length() > 0){
			throw new InvalidInputException (error.trim());
		}
		
		try
		{
			// Delete the selected connection
			selectedConnection.delete();
		}
		catch (RuntimeException e)
		{
			error = e.getMessage();
			throw new InvalidInputException (error);
		}
	}
	
	
	/*
	 * 6. Identify the hidden tile
	 * CM
	 */
	public void createWinTile(int x, int y, Game game) throws InvalidInputException {
		String error = "";
		if(game.hasWinTile()){
			error += "You already have a Win Tile on the board!";
		}
		
		if (error.length() > 0) {
			throw new InvalidInputException(error.trim());
		}
		
		try {
			WinTile winTile = new WinTile(x,y,game);
			game.addTile(winTile);
		}
		catch (RuntimeException e){
			throw new InvalidInputException (e.getMessage());
		}
	}
	
	
	/*
	 * 7. Identify the starting tile of a player
	 * Chris
	 */
	public void setPlayerStartingTile(Player player, Tile startingTile) throws InvalidInputException {
		

		// I don't know if this is correct or not
		player.setStartingTile(startingTile);

		TileO tileO = TileOApplication.getTileO();
		Game currentGame = tileO.getCurrentGame();
		for(int i = 0; i<currentGame.numberOfPlayers(); i++)
		{
			player = currentGame.getPlayer(i);
			player.setStartingTile(startingTile);
		}

		
	}
	
	
	/*
	 * 8. Identify an action tile (inactivity period not required for this iteration)
	 * Victor
	 */
	public void createActionTile(int x, int y, Game game) throws InvalidInputException {
		try{
			ActionTile actionTile = new ActionTile(x,y,game, 3);	//inactivity period fixed at 3 for now (not supposed to implement)
	        game.addTile(actionTile);
		}
		catch (RuntimeException e){
			throw new InvalidInputException (e.getMessage());
		}
	}
	
	
	/*
	 * 9. Select 32 cards from predefined choices
	 * Charles
	 */
	public void createDeck(int numberOfRollDieActionCard, int numberOfConnectTilesActionCard,
			int numberOfRemoveConnectionActionCard,
			int numberOfTeleportActionCard) throws InvalidInputException {
		//TODO: CHARLES
		String error = "";
		if(numberOfRollDieActionCard+ numberOfConnectTilesActionCard+numberOfRemoveConnectionActionCard
				+numberOfTeleportActionCard != 32) {
			error = "The sum of numbers of different types of acton cards should be 32. ";
		}
		if (error.length() > 0) {
			throw new InvalidInputException(error.trim());
		}
		try{
			TileO tileO = TileOApplication.getTileO();
			Game currentGame = tileO.getCurrentGame();
			Deck deck = currentGame.getDeck();
			for(int i = 0; i < numberOfRollDieActionCard;i++){
				RollDieActionCard rollDieActionCard = new RollDieActionCard(rollDieInstruction,deck);
				deck.addCard(rollDieActionCard);
			}
			for(int j = 0; j < numberOfConnectTilesActionCard;j++) {
				ConnectTilesActionCard connectTilesActionCard = new ConnectTilesActionCard(connectTilesInstruction,deck);
				deck.addCard(connectTilesActionCard);
			}
			for(int k = 0; k < numberOfRemoveConnectionActionCard;k++){
				RemoveConnectionActionCard removeConnectionActionCard = new RemoveConnectionActionCard(removeConnectionInstruction,deck);
				deck.addCard(removeConnectionActionCard);
			}
			for(int z = 0; z < numberOfTeleportActionCard;z++) {
				TeleportActionCard teleportActionCard = new TeleportActionCard(teleportInstruction,deck);
				deck.addCard(teleportActionCard);
			}
		}
		catch (RuntimeException e) {
			throw new InvalidInputException(error);
		}
		    
		
		
		
	}

	
	/*
	 * 10. Save and load the game design
	 * Victor
	 */
	public void saveDesign() {
		//TODO: VICTORIQUE
		TileOApplication.save();
	}
	
	public void loadDesign(Game aGame) throws InvalidInputException {
		//TODO: VICTORIQUE
		TileO tileO = TileOApplication.load();
		Game game = tileO.getCurrentGame();
		game.setMode(Game.Mode.DESIGN);
		
	}
	
	
}

