package ca.mcgill.ecse223.tileo.controller;

import ca.mcgill.ecse223.tileo.application.TileOApplication;
import ca.mcgill.ecse223.tileo.model.Connection;
import ca.mcgill.ecse223.tileo.model.Game;
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
	 * 3. Remove a tile from the game board
	 * Lily
	 */
	public void removeTileFromGame(Tile aTile) throws InvalidInputException{
		TileO tileO = new TileOApplication();
		Game aGame = tileO.getCurrentGame();
		
		if (aTile.hasConnections()) {
			String error = "Cannot delete a tile that has connections.";
			throw new InvalidInputException(error.trim());
		}
		
		try
		{
			if (!aTile.hasConnections()) {
				aTile.delete();
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
		try
		{
			Connection newConnection =  currentGame.addConnection();
			selectedTile1.addConnection(newConnection);
			selectedTile2.addConnection(newConnection);
		}
		catch (RuntimeException e)
		{
			throw new InvalidInputException (e.getMessage());
		}
	}
	
	/*
	 * 5. Remove connection between two tiles
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
	
	
	
}

