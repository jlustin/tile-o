package ca.mcgill.ecse223.tileo.controller;

import ca.mcgill.ecse223.tileo.model.Tile;

public class PlayModeController {

	// METHODS
	
	public void actionCardAddConnection (Tile selectedTile1, Tile selectedTile2){
		// Get tileO from TilOApplication
		// Get current game from tileO
		// Get currentConnectionPieces from game
		
		int usedConnections = game.getCurrentConnectionPieces();
		
		try 
		{
			if (usedConnections <= 32){
				newConnection =  game.addConnection;
				selectedTile1.addConnection(newConnection);
				selectedTile2.addConnection(newConnection);
			}
		}
		catch (RuntimeException e){
			throw new InvalidInputException (e.getMessage());
		}
	}
	
}
