package ca.mcgill.ecse223.tileo.controller;

import ca.mcgill.ecse223.tileo.application.TileOApplication;
import ca.mcgill.ecse223.tileo.model.Connection;
import ca.mcgill.ecse223.tileo.model.Game;
import ca.mcgill.ecse223.tileo.model.Player;
import ca.mcgill.ecse223.tileo.model.Tile;
import ca.mcgill.ecse223.tileo.model.TileO;

public class DesignModeController {

	//METHODS
	
	/*
	 * 1. Create a game with a number of players
	 * Justin
	 */
	public void createGame(int numberOfPlayers) throws InvalidInputException{
		
		// According to my feedback from part 2: 
				/* -2 createGame should add a new game to application and set it as the current game, 
				 instead of getting the current game; Set mode to "DESIGN".*/

		Game game = new Game(32, null);				//TODO: add TileO, this already creates a Deck and a Die (btw, check Game Class)
//		TileO.setCurrentGame(game);

		
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
				//TODO: not sure which one to use
				currentGame.removeTile(aTile);
				//aTile.delete();
			}
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
		if (currentGame.numberOfTiles() < 2){
			error = "There are less than 2 tiles in the current game.";
		}
		if ((x1 != x2+1 && y1 == y2) || (x1 != x2-1 && y1 == y2)){
			error = error + "The selected tiles are not adjacent";
		}
		if ((y1 != y2+1 && x1 == x2) || (y1 != y2-1 && x1 == x2)){
			error = error + "The selected tiles are not adjacent";
		}
		// Re-check
		if (currentGame.getCurrentConnectionPieces() < 1){
			error = error + "There are 0 connection pieces in the game";
		}
		if (error.length() > 0){
			throw new InvalidInputException (error.trim());
		}

		try
		{
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
		try
		{
			selectedConnection.delete();
		}
		catch (RuntimeException e)
		{
			throw new InvalidInputException (e.getMessage());
		}
	}
	
	
	/*
	 * 6. Identify the hidden tile
	 * CM
	 */
	public void createWinTile(int x, int y) throws InvalidInputException {
		//TODO: CM
	}
	
	
	/*
	 * 7. Identify the starting tile of a player
	 * Chris
	 */
	public void setPlayerStartingTile(Player aPlayer, Tile startingTile) throws InvalidInputException {
		//TODO: CHRIS
		
	}
	
	
	/*
	 * 8. Identify an action tile (inactivity period not required for this iteration)
	 * Victor
	 */
	public void createActionTile(int x, int y) throws InvalidInputException {
		//TODO: VICTORIQUE
	}
	
	
	/*
	 * 9. Select 32 cards from predefined choices
	 * Charles
	 */
	public void createDeck(int numberOfRollDieActionCard, int numberOfConnectTilesActionCard,
			int numberOfRemoveConnectionActionCard,
			int numberOfTeleportActionCard) throws InvalidInputException {
		//TODO: CHARLES
	}

	
	/*
	 * 10. Save and load the game design
	 * Victor
	 */
	public void saveDesign() {
		//TODO: VICTORIQUE
	}
	
	public void loadDesign(Game aGame) throws InvalidInputException {
		//TODO: VICTORIQUE
	}
	
	
}

