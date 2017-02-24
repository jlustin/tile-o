package ca.mcgill.ecse223.tileo.controller;

import ca.mcgill.ecse223.tileo.model.Connection;
import ca.mcgill.ecse223.tileo.model.Game;
import ca.mcgill.ecse223.tileo.model.Tile;

public class DesignModeController {

	//METHODS
	
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
	
	public void connectTwoTiles (Tile selectedTile1, Tile selectedTile2) throws InvalidInputException{
		// Get current game from TileOApplication
		
		try
		{
			newConnection =  game.addConnection;
			selectedTile1.addConnection(newConnection);
			selectedTile2.addConnection(newConnection);
		}
		catch (RuntimeException e){
			throw new InvalidInputException (e.getMessage());
		}
	}
	
	public void removeConnection (Connection selectedConnction) throws InvalidInputException{
		// Get current game from TileOApplication
		
		try
		{
			selectedConnection.delete();
		}
		catch (RuntimeException e){
			throw new InvalidInputException (e.getMessage());
		}
	}
	
	
	
}
