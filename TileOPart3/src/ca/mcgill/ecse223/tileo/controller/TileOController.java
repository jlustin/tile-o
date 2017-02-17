package ca.mcgill.ecse223.tileo.controller;

import ca.mcgill.ecse223.tileo.model.Game;

public class TileOController {

	//METHODS
	
	public void createGame(int numberOfPlayers) throws InvalidInputException{
		Game game = new Game(32, null);				//TODO: add TileO, this already creates a Deck and a Die (btw, check Game Class)
		TileO.setCurrentGame(game);
		
		for(int playerNumber = 1; playerNumber < numberOfPlayers; playerNumber++){
			game.addPlayer(playerNumber);
		}
	}
}

