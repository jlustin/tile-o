/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.controller;
import ca.mcgill.ecse223.tileo.model.Tile;
import java.util.*;

import ca.mcgill.ecse223.tileo.application.TileOApplication;
import ca.mcgill.ecse223.tileo.model.*;


// line 4 "../../../../../playState.ump"
public class PlayController
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PlayController State Machines
  public enum Mode { Ready, Roll, Move, ActionCard, Won }
  private Mode mode;

  //PlayController Associations
  private List<Tile> possibleMoves;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PlayController()
  {
    possibleMoves = new ArrayList<Tile>();
    setMode(Mode.Ready);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getModeFullName()
  {
    String answer = mode.toString();
    return answer;
  }

  public Mode getMode()
  {
    return mode;
  }

  public boolean startGame() throws InvalidInputException
  {
    boolean wasEventProcessed = false;
    
    Mode aMode = mode;
    switch (aMode)
    {
      case Ready:
        // line 10 "../../../../../playState.ump"
        doStartGame(TileOApplication.getTileO().getCurrentGame());
        setMode(Mode.Roll);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean load(Game selectedGame)
  {
    boolean wasEventProcessed = false;
    
    Mode aMode = mode;
    switch (aMode)
    {
      case Ready:
        if (isInGameMode(selectedGame))
        {
        // line 13 "../../../../../playState.ump"
          doLoad(selectedGame);
          setMode(Mode.Roll);
          wasEventProcessed = true;
          break;
        }
        if (isInWonMode(selectedGame))
        {
        // line 16 "../../../../../playState.ump"
          doLoad(selectedGame);
          setMode(Mode.Won);
          wasEventProcessed = true;
          break;
        }
        if (isNotInGameOrWonMode(selectedGame))
        {
        // line 19 "../../../../../playState.ump"
          doLoad(selectedGame);
          setMode(Mode.ActionCard);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean rollDie()
  {
    boolean wasEventProcessed = false;
    
    Mode aMode = mode;
    switch (aMode)
    {
      case Roll:
        // line 26 "../../../../../playState.ump"
        possibleMoves = doRollDie();
        setMode(Mode.Move);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean land(Tile tile)
  {
    boolean wasEventProcessed = false;
    
    Mode aMode = mode;
    switch (aMode)
    {
      case Move:
        if (isNormalTile(tile))
        {
        // line 33 "../../../../../playState.ump"
          doLandTile(tile);
          setMode(Mode.Roll);
          wasEventProcessed = true;
          break;
        }
        if (isWinTile(tile))
        {
        // line 36 "../../../../../playState.ump"
          doLandTile(tile);
          setMode(Mode.Won);
          wasEventProcessed = true;
          break;
        }
        if (isActionTile(tile))
        {
        // line 39 "../../../../../playState.ump"
          doLandTile(tile);
          setMode(Mode.ActionCard);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean playRollDieActionCard()
  {
    boolean wasEventProcessed = false;
    
    Mode aMode = mode;
    switch (aMode)
    {
      case ActionCard:
        if (isRollDieActionCard())
        {
        // line 46 "../../../../../playState.ump"
          possibleMoves = doPlayRollDieActionCard();
          setMode(Mode.Roll);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean playConnectTilesActionCard(Tile tile1,Tile tile2)
  {
    boolean wasEventProcessed = false;
    
    Mode aMode = mode;
    switch (aMode)
    {
      case ActionCard:
        if (isConnectTilesActionCard())
        {
        // line 49 "../../../../../playState.ump"
          doPlayConnectTilesActionCard(tile1, tile2);
          setMode(Mode.Roll);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean playRemoveConnectionActionCard(Connection c)
  {
    boolean wasEventProcessed = false;
    
    Mode aMode = mode;
    switch (aMode)
    {
      case ActionCard:
        if (isRemoveConnectionActionCard())
        {
        // line 52 "../../../../../playState.ump"
          doPlayRemoveConnectionActionCard(c);
          setMode(Mode.Roll);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean playTeleportActionCard(Tile tile)
  {
    boolean wasEventProcessed = false;
    
    Mode aMode = mode;
    switch (aMode)
    {
      case ActionCard:
        if (isTeleportAndNormalTile(tile))
        {
        // line 55 "../../../../../playState.ump"
          doPlayTeleportActionCard(tile);
          setMode(Mode.Roll);
          wasEventProcessed = true;
          break;
        }
        if (isTeleportAndWinTile(tile))
        {
        // line 58 "../../../../../playState.ump"
          doPlayTeleportActionCard(tile);
          setMode(Mode.Won);
          wasEventProcessed = true;
          break;
        }
        if (isTeleportAndActionTile(tile))
        {
        // line 61 "../../../../../playState.ump"
          doPlayTeleportActionCard(tile);
          setMode(Mode.ActionCard);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean playLoseTurnActionCard()
  {
    boolean wasEventProcessed = false;
    
    Mode aMode = mode;
    switch (aMode)
    {
      case ActionCard:
        if (isLoseTurnActionCard())
        {
        // line 64 "../../../../../playState.ump"
          doPlayLoseTurnActionCard();
          setMode(Mode.Roll);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setMode(Mode aMode)
  {
    mode = aMode;
  }

  public Tile getPossibleMove(int index)
  {
    Tile aPossibleMove = possibleMoves.get(index);
    return aPossibleMove;
  }

  public List<Tile> getPossibleMoves()
  {
    List<Tile> newPossibleMoves = Collections.unmodifiableList(possibleMoves);
    return newPossibleMoves;
  }

  public int numberOfPossibleMoves()
  {
    int number = possibleMoves.size();
    return number;
  }

  public boolean hasPossibleMoves()
  {
    boolean has = possibleMoves.size() > 0;
    return has;
  }

  public int indexOfPossibleMove(Tile aPossibleMove)
  {
    int index = possibleMoves.indexOf(aPossibleMove);
    return index;
  }

  public static int minimumNumberOfPossibleMoves()
  {
    return 0;
  }

  public boolean addPossibleMove(Tile aPossibleMove)
  {
    boolean wasAdded = false;
    if (possibleMoves.contains(aPossibleMove)) { return false; }
    possibleMoves.add(aPossibleMove);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePossibleMove(Tile aPossibleMove)
  {
    boolean wasRemoved = false;
    if (possibleMoves.contains(aPossibleMove))
    {
      possibleMoves.remove(aPossibleMove);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPossibleMoveAt(Tile aPossibleMove, int index)
  {  
    boolean wasAdded = false;
    if(addPossibleMove(aPossibleMove))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPossibleMoves()) { index = numberOfPossibleMoves() - 1; }
      possibleMoves.remove(aPossibleMove);
      possibleMoves.add(index, aPossibleMove);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePossibleMoveAt(Tile aPossibleMove, int index)
  {
    boolean wasAdded = false;
    if(possibleMoves.contains(aPossibleMove))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPossibleMoves()) { index = numberOfPossibleMoves() - 1; }
      possibleMoves.remove(aPossibleMove);
      possibleMoves.add(index, aPossibleMove);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPossibleMoveAt(aPossibleMove, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    possibleMoves.clear();
  }


  /**
   * Condition
   */
  // line 81 "../../../../../playState.ump"
   public boolean checkGameMode(Game.Mode aMode){
    return aMode == TileOApplication.getTileO().getCurrentGame().getMode();
  }

  // line 85 "../../../../../playState.ump"
   public boolean isNormalTile(Tile selectedTile){
    return (selectedTile instanceof NormalTile);
  }

  // line 89 "../../../../../playState.ump"
   public boolean isActionTile(Tile selectedTile){
    return (selectedTile instanceof ActionTile);
  }

  // line 93 "../../../../../playState.ump"
   public boolean isWinTile(Tile selectedTile){
    return (selectedTile instanceof WinTile);
  }

  // line 98 "../../../../../playState.ump"
   private void doStartGame(Game selectedGame) throws InvalidInputException{
    //TODO: CHARLES
		String error = "";
		if(selectedGame.getDeck().numberOfCards() != 32) {
			error = "The action cards in the deck must be equal to 32.";
		}
		if(selectedGame.hasWinTile() == false) {
			error = "The winTile does not exist." ;
		}
		for(int i = 0 ; i < selectedGame.numberOfPlayers(); i++) {
			if(selectedGame.getPlayer(i).hasStartingTile() == false){
				error = "Player " + (i+1) + " does not have a starting tile." ;
			}
		}
		if(error.length() > 0) {
			throw new InvalidInputException(error.trim());
		}
		
		TileO tileO = TileOApplication.getTileO();
		try {
			tileO.setCurrentGame(selectedGame);
			Deck deck = selectedGame.getDeck();
			deck.shuffle();
			for(int i = 0 ; i < selectedGame.numberOfTiles(); i++){
				selectedGame.getTiles().get(i).setHasBeenVisited(false);
			}
			
			for(int j = 0; j < selectedGame.numberOfPlayers(); j++){
				Tile startingTile = selectedGame.getPlayer(j).getStartingTile();
				selectedGame.getPlayers().get(j).setCurrentTile(startingTile);
				selectedGame.getPlayers().get(j).getCurrentTile().setHasBeenVisited(true);
			}
			
			selectedGame.setCurrentPlayer(selectedGame.getPlayers().get(0));
			selectedGame.setCurrentConnectionPieces(Game.SpareConnectionPieces);
			selectedGame.setMode(Game.Mode.GAME);
		}
		catch(RuntimeException e){
			error = e.getMessage();
			throw new InvalidInputException(error);
		}
  }


  /**
   * 2. Take a turn (roll the die, move to new position)
   * Charles
   */
  // line 146 "../../../../../playState.ump"
   private List<Tile> doRollDie(){
    //TODO: CHARLES
		TileO tileO = TileOApplication.getTileO(); 
		Game currentGame = tileO.getCurrentGame();
		List<Tile> possibleMoves = currentGame.rollDie();
		return possibleMoves; //method in Game class
  }


  /**
   * 3. Land on a tile (basic behavior for hidden, regular, and action tiles)
   * Chris
   */
  // line 159 "../../../../../playState.ump"
   private void doLand(Tile tile) throws InvalidInputException{
    TileO tileO = TileOApplication.getTileO();
		Game currentGame = tileO.getCurrentGame();
		List<Tile> tiles = currentGame.getTiles();
	
		String error = "";
		if(tiles.contains(tile) == false){
			error = "The tile does not exist in the Board.";
		}
		if (error.length() > 0){
			throw new InvalidInputException(error.trim());
		}
		
		try{
			tile.doLand();
		}
		catch(RuntimeException e){
			throw new InvalidInputException(e.getMessage());
		}
  }


  /**
   * 4. Take the first card from the deck of cards
   * CM
   * helper method called within this controller
   */
  // line 186 "../../../../../playState.ump"
   private ActionCard drawCard(Game currentGame){
    Deck deck = currentGame.getDeck();
		ActionCard drawnCard = deck.getCurrentCard();
		ActionCard nextCard;
		
		if(deck.indexOfCard(drawnCard) < 31){ //index range: [0,31]
			nextCard = deck.getCard(deck.indexOfCard(drawnCard) + 1);
		}
		else{ //the index of the card must be 31, which is the last card
			deck.shuffle();
			nextCard = deck.getCard(0);
		}
		deck.setCurrentCard(nextCard);		
		return drawnCard;
  }


  /**
   * TODO: CM t'as besoin de changer ca
   * 5. Action card "Roll the die for an extra turn"
   * CM
   */
  // line 207 "../../../../../playState.ump"
   public void doPlayRollDieActionCard(){
    TileO tileO = TileOApplication.getTileO();
		Game currentGame = tileO.getCurrentGame();		
		RollDieActionCard rollDieActionCard = (RollDieActionCard) drawCard(currentGame);
		
		rollDieActionCard.play();
		
		currentGame.setMode(Game.Mode.GAME);
  }


  /**
   * 6. Action card "Connect two adjacent tiles with a connection piece from the pile of spare connection pieces"
   * Justin
   */
  // line 222 "../../../../../playState.ump"
   private void doPlayConnectTilesActionCard(Tile selectedTile1, Tile selectedTile2) throws InvalidInputException{
    TileO tileO = TileOApplication.getTileO();
		Game currentGame = tileO.getCurrentGame();
		ConnectTilesActionCard connectTilesActionCard = (ConnectTilesActionCard) drawCard(currentGame);
		
		String error = "";
		if (currentGame.numberOfTiles() < 2){
			error = "There are less than 2 tiles in the current game.";
		}
		if (!isAdjacent(selectedTile1, selectedTile2)){
			error = "The selected tiles are not adjacent.";
		}
		if (currentGame.getCurrentConnectionPieces() < 1){
			error = "There are 0 connection pieces available.";
		}
		if (isConnected(selectedTile1, selectedTile2)){
			error = "The two selected tiles are already connected.";
		}
		if (error.length() > 0){
			throw new InvalidInputException (error.trim());
		}
		
		try {
			connectTilesActionCard.play(selectedTile1, selectedTile2);			
			currentGame.setNextPlayer();
			currentGame.setMode(Game.Mode.GAME);
		}
		catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
  }


  /**
   * 7. Action card "Remove a connection piece from the board and place it in the pile of spare connection pieces"
   * Li
   */
  // line 259 "../../../../../playState.ump"
   private void doPlayRemoveConnectionActionCard(Connection connection) throws InvalidInputException{
    //TODO: LI
		TileO tileO = TileOApplication.getTileO();
		Game currentGame = tileO.getCurrentGame();
		List<Connection> connectionList = currentGame.getConnections();
		
		if (connectionList.contains(connection)) {
			ActionCard currentCard = drawCard(currentGame);
			
			try {
				if (currentCard instanceof RemoveConnectionActionCard) {				
					((RemoveConnectionActionCard) currentCard).play(connection);
				}				
				currentGame.setNextPlayer();		
				currentGame.setMode(Game.Mode.GAME);
			} 
			catch (RuntimeException e) {
				throw new InvalidInputException(e.getMessage());	
			}
		}
  }


  /**
   * 8. Action card "Move your playing piece to an arbitrary tile that is not your current tile"
   * Victor
   */
  // line 286 "../../../../../playState.ump"
   private void doPlayTeleportActionCard(Tile tile) throws InvalidInputException{
    TileO tileO = TileOApplication.getTileO();
		Game currentGame = tileO.getCurrentGame();
		ActionCard currentCard = drawCard(currentGame);
		List<Tile> tiles = currentGame.getTiles();
		String error = "";
		if(tiles.contains(tile) == false){
			error = "Please select an existing tile on the board.";
		}
		if(error.length() > 0){
			throw new InvalidInputException(error.trim());
		}
		
		try{
			if (currentCard instanceof TeleportActionCard){
				((TeleportActionCard) currentCard).play(tile);
			}
		}
		catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
  }


  /**
   * Action card "Lose your next turn"
   */
  // line 312 "../../../../../playState.ump"
   private void doPlayLoseTurnActionCard() throws InvalidInputException{
    TileO tileO = TileOApplication.getTileO();
		Game currentGame = tileO.getCurrentGame();
		ActionCard currentCard = drawCard(currentGame);
		if (currentCard instanceof LoseTurnActionCard) {
			((LoseTurnActionCard) currentCard).play();
		}
		currentGame.determineNextPlayer();
		currentGame.updateTileStatus();
		currentGame.setMode(Game.Mode.GAME);
  }


  /**
   * 9. Save and load game to continue playing at a later point
   * Li
   */
  // line 329 "../../../../../playState.ump"
   public void saveGame(){
    TileOApplication.save();
  }

  // line 333 "../../../../../playState.ump"
   public Game loadGame(int index) throws InvalidInputException{
    TileO tileO = TileOApplication.getTileO();
		try {
			Game loadedGame = tileO.getGame(index);
			loadedGame.setMode(Game.Mode.GAME);
			return loadedGame;
		}
		catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
  }


  /**
   * Helper method to check if two tiles are adjacent
   */
  // line 350 "../../../../../playState.ump"
   public boolean isAdjacent(Tile tile1, Tile tile2){
    int x1 = tile1.getX();
		int y1 = tile1.getY();
		int x2 = tile2.getX();
		int y2 = tile2.getY();
		if (x1-x2 == -1 || x1-x2 == 1){
			if(y1-y2 ==0){
				return true;
			}
		}
		if (y1-y2 == -1 || y1-y2 == 1){
			if(x1-x2 ==0){
				return true;
			}
		}		
		return false;
  }


  /**
   * Helper method to check if two tiles are already connected
   */
  // line 372 "../../../../../playState.ump"
   public boolean isConnected(Tile tile1, Tile tile2){
    for (Connection c1: tile1.getConnections()){
			for (Connection c2: tile2.getConnections()){
				if (c1 == c2){
					return true;
				}
			}
		}
		return false;
  }

}