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
	
	/*
	 * 1. Start a game (shuffle the action cards, place players on board)
	 * Charles
	 */
	
	
	/*
	 * 2. Take a turn (roll the die, move to new position)
	 * Charles
	 */
	
	/*
	 * 3. Land on a tile (basic behavior for hidden, regular, and action tiles)
	 * Chris
	 */
	
	/*
	 * 4. Take the first card from the deck of cards
	 * CM
	 */
	
	
	/*
	 * 5. Action card "Roll the die for an extra turn"
	 * CM
	 */
	
	/*
	 * 6. Action card "Connect two adjacent tiles with a connection piece from the pile of spare connection pieces"
	 * Justin
	 */
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
	
	
	/*
	 * 7. Action card "Remove a connection piece from the board and place it in the pile of spare connection pieces"
	 * Li
	 */
	
	/*
	 * 8. Action card "Move your playing piece to an arbitrary tile that is not your current tile"
	 * Victor
	 */
	
	/*
	 * 9. Save and load game to continue playing at a later point
	 * Li
	 */
	
	
}
