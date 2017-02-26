package ca.mcgill.ecse223.tileo.controller;

import ca.mcgill.ecse223.btms.application.BtmsApplication;
import ca.mcgill.ecse223.btms.controller.InvalidInputException;
import ca.mcgill.ecse223.tileo.application.TileOApplication;
import ca.mcgill.ecse223.tileo.model.ActionCard;
import ca.mcgill.ecse223.tileo.model.ConnectTilesActionCard;
import ca.mcgill.ecse223.tileo.model.Connection;
import ca.mcgill.ecse223.tileo.model.Deck;
import ca.mcgill.ecse223.tileo.model.Game;
import ca.mcgill.ecse223.tileo.model.Game.Mode;
import ca.mcgill.ecse223.tileo.model.Player;
import ca.mcgill.ecse223.tileo.model.RemoveConnectionActionCard;
import ca.mcgill.ecse223.tileo.model.TeleportActionCard;
import ca.mcgill.ecse223.tileo.model.Tile;
import ca.mcgill.ecse223.tileo.model.TileO;

public class PlayModeController {

	// METHODS
	
	/*
	 * 1. Start a game (shuffle the action cards, place players on board)
	 * Charles
	 */
	public void startGame(Game selectedGame) throws InvalidInputException {
		//TODO: CHARLES
	}

	
	/*
	 * 2. Take a turn (roll the die, move to new position)
	 * Charles
	 */
	public void moveToTile(Tile chosenTile) throws InvalidInputException {
		//TODO: CHARLES
	}

	
	/*
	 * 3. Land on a tile (basic behavior for hidden, regular, and action tiles)
	 * Chris
	 */
	public void landedOnTile() {
		//TODO: CHRIS
	}
	
	
	/*
	 * 4. Take the first card from the deck of cards
	 * CM
	 */
	public void createWinTile(int x, int y) throws InvalidInputException {
		//TODO: CM
	}

	
	/*
	 * 5. Action card "Roll the die for an extra turn"
	 * CM
	 */
	public void rollDieExtraTurn() {
		//TODO: CM
	}

	
	/*
	 * 6. Action card "Connect two adjacent tiles with a connection piece from the pile of spare connection pieces"
	 * Justin
	 */
	public void playConnectTilesActionCard (Tile selectedTile1, Tile selectedTile2) throws InvalidInputException{
		TileO tileO = TileOApplication.getTileO();
		Game currentGame = tileO.getCurrentGame();
		Deck deck = currentGame.getDeck();
		ConnectTilesActionCard connectTilesActionCard = (ConnectTilesActionCard) deck.getCard(0);
		
		try 
		{
			connectTilesActionCard.play(selectedTile1, selectedTile2);
			currentGame.setCurrentPlayer(currentGame.getPlayer(currentGame.indexOfPlayer(currentGame.getCurrentPlayer())+1));
			deck.setCurrentCard(deck.getCard(deck.indexOfCard(deck.getCurrentCard())+1));
			currentGame.setMode(Mode.GAME);
		}
		catch (RuntimeException e) 
		{
			throw new InvalidInputException(e.getMessage());
		}
	}
	
	
	/*
	 * 7. Action card "Remove a connection piece from the board and place it in the pile of spare connection pieces"
	 * Li
	 */
	public void playRemoveConnectionActionCard(Connection connection) throws InvalidInputException {
		//TODO: LI
		TileO tileO = TileOApplication.getTileO();
		Game currentGame = tileO.getCurrentGame();
		currentGame.getConnections();
		
		//validation check: connection needs to be in connections of currentGame
		//TODO: to everyone, how the fuck do you do that validation???
		/*
		if (connection instanceof currentGame.getConnections()) {
			
		}
		*/
		Deck deck = currentGame.getDeck();
		ActionCard currentCard = deck.getCurrentCard();
		Player currentPlayer = currentGame.getCurrentPlayer();
		//current card needs to be a remove connection action card
		if (currentCard instanceof RemoveConnectionActionCard) {
			//play(connection)???
			//"play() needs to be added to the removeconnectionactioncard class"
		}
		//checks if current player is the last player
		if (currentPlayer.getNumber() == currentGame.getPlayers().size()) {
			//if it is, set the first player to current player
			currentGame.setCurrentPlayer(Player.getWithNumber(1));
		}
		//if it's not, set the next player
		if (currentPlayer.getNumber() != currentGame.getPlayers().size()) {
			currentGame.setCurrentPlayer(currentGame.getPlayer(currentGame.indexOfPlayer(currentPlayer)+1));
		}
		currentGame.setMode(Mode.GAME);		
	}

	
	/*
	 * 8. Action card "Move your playing piece to an arbitrary tile that is not your current tile"
	 * Victor
	 */
	public void playTeleportActionCard(Tile tile) throws InvalidInputException {
		//TODO: VICTORIQUE
		
		//TeleportActionCard.play(tile)
//		try {
//			TeleportActionCard.play(tile);
//		}
//		catch (RuntimeException e) {
//			throw new InvalidInputException(e.getMessage());
//		}
		
		
		TileO tileO = TileOApplication.getTileO();
		Game currentGame = tileO.getCurrentGame();
		Deck deck = currentGame.getDeck();
		TeleportActionCard teleportcard = (TeleportActionCard) deck.getCurrentCard();
		deck.setCurrentCard(deck.getCard(deck.indexOfCard(teleportcard)+1));

		try{
		teleportcard.play(tile);
		}
		catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
		
		
	
	}

	
	/*
	 * 9. Save and load game to continue playing at a later point
	 * Li
	 */
	public void saveGame() {
		//TODO: LI
	}
	
	public Game loadGame(Game aGame) throws InvalidInputException {
		//TODO: LI
		//set mode to "GAME" when loading a game
		return aGame;
		
	}

	
	
}
