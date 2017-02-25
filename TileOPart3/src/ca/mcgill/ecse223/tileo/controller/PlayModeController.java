package ca.mcgill.ecse223.tileo.controller;

import ca.mcgill.ecse223.tileo.application.TileOApplication;
import ca.mcgill.ecse223.tileo.model.ActionCard;
import ca.mcgill.ecse223.tileo.model.ConnectTilesActionCard;
import ca.mcgill.ecse223.tileo.model.Deck;
import ca.mcgill.ecse223.tileo.model.Game;
import ca.mcgill.ecse223.tileo.model.Tile;
import ca.mcgill.ecse223.tileo.model.TileO;

public class PlayModeController {

	// METHODS
	
	public void playConnectTilesActionCard (Tile selectedTile1, Tile selectedTile2){
		TileO tileO = TileOApplication.getTileO();
		Game currentGame = tileO.getCurrentGame();
		Deck deck = currentGame.getDeck();
		ActionCard currentCard = deck.getCard(0);
		
		ConnectTilesActionCard.play(selectedTile1, selectedTile2);
		
		
//		int usedConnections = currentGame.getCurrentConnectionPieces();
//		
//		try 
//		{
//			if (usedConnections <= 32){
//				newConnection =  game.addConnection;
//				selectedTile1.addConnection(newConnection);
//				selectedTile2.addConnection(newConnection);
//			}
//		}
//		catch (RuntimeException e){
//			throw new InvalidInputException (e.getMessage());
//		}
	}
	
}
