/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.controller;
import java.util.*;

import ca.mcgill.ecse223.tileo.application.TileOApplication;
import ca.mcgill.ecse223.tileo.model.*;
import ca.mcgill.ecse223.tileo.model.ActionTile.ActionTileStatus;

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
        // line 9 "../../../../../playState.ump"
        doStartGame(TileOApplication.getTileO().getCurrentGame());
        setMode(Mode.Roll);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean load(int gameIndex) throws InvalidInputException
  {
    boolean wasEventProcessed = false;
    
    Mode aMode = mode;
    switch (aMode)
    {
      case Ready:
        if (isInGameMode(gameIndex))
        {
        // line 12 "../../../../../playState.ump"
          loadGame(gameIndex);
          setMode(Mode.Roll);
          wasEventProcessed = true;
          break;
        }
        if (isInWonMode(gameIndex))
        {
        // line 15 "../../../../../playState.ump"
          loadGame(gameIndex);
          setMode(Mode.Won);
          wasEventProcessed = true;
          break;
        }
        if (isNotInGameOrWonMode(gameIndex))
        {
        // line 18 "../../../../../playState.ump"
          loadGame(gameIndex);
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
        // line 25 "../../../../../playState.ump"
        possibleMoves = doRollDie();
        setMode(Mode.Move);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean land(Tile tile) throws InvalidInputException
  {
    boolean wasEventProcessed = false;
    
    Mode aMode = mode;
    switch (aMode)
    {
      case Move:
        if (isNormalTile(tile))
        {
        // line 32 "../../../../../playState.ump"
          doLand(tile);
          setMode(Mode.Roll);
          wasEventProcessed = true;
          break;
        }
        if (isWinTile(tile))
        {
        // line 35 "../../../../../playState.ump"
          doLand(tile);
          setMode(Mode.Won);
          wasEventProcessed = true;
          break;
        }
        if (isActionTileAndInactive(tile))
        {
        // line 38 "../../../../../playState.ump"
          doLand(tile);
          setMode(Mode.Roll);
          wasEventProcessed = true;
          break;
        }
        if (isActiveActionTile(tile))
        {
        // line 41 "../../../../../playState.ump"
          doLand(tile);
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
        // line 48 "../../../../../playState.ump"
          doPlayRollDieActionCard();
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

  public boolean playConnectTilesActionCard(Tile tile1,Tile tile2) throws InvalidInputException
  {
    boolean wasEventProcessed = false;
    
    Mode aMode = mode;
    switch (aMode)
    {
      case ActionCard:
        if (isConnectTilesActionCard())
        {
        // line 51 "../../../../../playState.ump"
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

  public boolean playRemoveConnectionActionCard(Connection c) throws InvalidInputException
  {
    boolean wasEventProcessed = false;
    
    Mode aMode = mode;
    switch (aMode)
    {
      case ActionCard:
        if (isRemoveConnectionActionCard())
        {
        // line 54 "../../../../../playState.ump"
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

  public boolean playTeleportActionCard(Tile tile) throws InvalidInputException
  {
    boolean wasEventProcessed = false;
    
    Mode aMode = mode;
    switch (aMode)
    {
      case ActionCard:
        if (isTeleportAndNormalTile(tile))
        {
        // line 57 "../../../../../playState.ump"
          doPlayTeleportActionCard(tile);
          setMode(Mode.Roll);
          wasEventProcessed = true;
          break;
        }
        if (isTeleportAndWinTile(tile))
        {
        // line 60 "../../../../../playState.ump"
          doPlayTeleportActionCard(tile);
          setMode(Mode.Won);
          wasEventProcessed = true;
          break;
        }
        if (isTeleportAndInactiveActionTile(tile))
        {
        // line 63 "../../../../../playState.ump"
          doPlayTeleportActionCard(tile);
          setMode(Mode.Roll);
          wasEventProcessed = true;
          break;
        }
        if (isTeleportAndActiveActionTile(tile))
        {
        // line 66 "../../../../../playState.ump"
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

  public boolean playLoseTurnActionCard() throws InvalidInputException
  {
    boolean wasEventProcessed = false;
    
    Mode aMode = mode;
    switch (aMode)
    {
      case ActionCard:
        if (isLoseTurnActionCard())
        {
        // line 69 "../../../../../playState.ump"
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

  public boolean playRevealActionCard(Tile tile) throws InvalidInputException
  {
    boolean wasEventProcessed = false;
    
    Mode aMode = mode;
    switch (aMode)
    {
      case ActionCard:
        if (isRevealActionCard())
        {
        // line 72 "../../../../../playState.ump"
          doPlayRevealActionCard(tile);
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
   * Guards
   */
  // line 90 "../../../../../playState.ump"
   private boolean isNormalTile(Tile selectedTile){
    return (selectedTile instanceof NormalTile);
  }

  // line 94 "../../../../../playState.ump"
   private boolean isActiveActionTile(Tile selectedTile){
    if(selectedTile instanceof ActionTile && ((ActionTile)selectedTile).getActionTileStatus().equals(ActionTileStatus.Active)){
			return true;
		}
  		return false;
  }

  // line 101 "../../../../../playState.ump"
   private boolean isWinTile(Tile selectedTile){
    return (selectedTile instanceof WinTile);
  }

  // line 106 "../../../../../playState.ump"
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
  // line 154 "../../../../../playState.ump"
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
  // line 167 "../../../../../playState.ump"
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
  // line 194 "../../../../../playState.ump"
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
   * 5. Action card "Roll the die for an extra turn"
   * CM
   */
  // line 215 "../../../../../playState.ump"
   public void doPlayRollDieActionCard(){
    TileO tileO = TileOApplication.getTileO();
		Game currentGame = tileO.getCurrentGame();		
		RollDieActionCard rollDieActionCard = (RollDieActionCard) drawCard(currentGame);
		
		possibleMoves = rollDieActionCard.play();
		
		currentGame.setMode(Game.Mode.GAME);
  }


  /**
   * 6. Action card "Connect two adjacent tiles with a connection piece from the pile of spare connection pieces"
   * Justin
   */
  // line 230 "../../../../../playState.ump"
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
  // line 267 "../../../../../playState.ump"
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
  // line 294 "../../../../../playState.ump"
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
  // line 320 "../../../../../playState.ump"
   private void doPlayLoseTurnActionCard() throws InvalidInputException{
    TileO tileO = TileOApplication.getTileO();
		Game currentGame = tileO.getCurrentGame();
		ActionCard currentCard = drawCard(currentGame);
		try {
			if (currentCard instanceof LoseTurnActionCard) {
				((LoseTurnActionCard) currentCard).play();
			}
			currentGame.setNextPlayer();
			currentGame.setMode(Game.Mode.GAME);	
		}
		catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
  }


  /**
   * Action card "Reveal the type of a tile"
 * @throws InvalidInputException 
   */
  // line 340 "../../../../../playState.ump"
   private void doPlayRevealActionCard(Tile tile) throws InvalidInputException{
    TileO tileO = TileOApplication.getTileO();
		Game currentGame = tileO.getCurrentGame();
		ActionCard currentCard = drawCard(currentGame);
		try {
			if (currentCard instanceof RevealActionCard) {
				((RevealActionCard) currentCard).play(tile);
			}
			currentGame.setNextPlayer();
			currentGame.setMode(Game.Mode.GAME);	
		}
		catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
  }


  /**
   * 9. Save and load game to continue playing at a later point
   * Li
   */
  // line 361 "../../../../../playState.ump"
   public void saveGame(){
    TileOApplication.save();
  }

  // line 365 "../../../../../playState.ump"
   public Game loadGame(int index) throws InvalidInputException{
    TileO tileO = TileOApplication.getTileO();
		try {
			Game loadedGame = tileO.getGame(index);
			return loadedGame;
		}
		catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
  }


  /**
   * Helper method to check if two tiles are adjacent
   */
  // line 381 "../../../../../playState.ump"
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
  // line 403 "../../../../../playState.ump"
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


  /**
   * Guards
   */
  // line 415 "../../../../../playState.ump"
   private boolean isInGameMode(int gameIndex){
    Game selectedGame = TileOApplication.getTileO().getGame(gameIndex);
	   if(selectedGame.getMode().equals(Game.Mode.GAME)) {
		   return true;
	   }
	   return false;
  }

  // line 423 "../../../../../playState.ump"
   private boolean isInWonMode(int gameIndex){
    Game selectedGame = TileOApplication.getTileO().getGame(gameIndex);
	   if(selectedGame.getMode().equals(Game.Mode.GAME_WON)){
		   return true;	   
	   }
	   return false;
  }

  // line 431 "../../../../../playState.ump"
   private boolean isNotInGameOrWonMode(int gameIndex){
    Game selectedGame = TileOApplication.getTileO().getGame(gameIndex);
	   if(selectedGame.getMode().equals(Game.Mode.GAME)||selectedGame.getMode().equals(Game.Mode.GAME_WON)){
		   return false;
	   }
	   return true;
  }

  // line 439 "../../../../../playState.ump"
   private boolean isRollDieActionCard(){
    ActionCard aActionCard = TileOApplication.getTileO().getCurrentGame().getDeck().getCurrentCard();
	   if(aActionCard instanceof RollDieActionCard ) {
		   return true;
	   }
	   return false;
  }

  // line 447 "../../../../../playState.ump"
   private boolean isConnectTilesActionCard(){
    ActionCard aActionCard = TileOApplication.getTileO().getCurrentGame().getDeck().getCurrentCard();
	   if(aActionCard instanceof ConnectTilesActionCard ) {
		   return true;
	   }
	   return false;
  }

  // line 455 "../../../../../playState.ump"
   private boolean isRemoveConnectionActionCard(){
    ActionCard aActionCard = TileOApplication.getTileO().getCurrentGame().getDeck().getCurrentCard();
	   if(aActionCard instanceof RemoveConnectionActionCard ) {
		   return true;
	   }
	   return false;
  }

  // line 463 "../../../../../playState.ump"
   private boolean isLoseTurnActionCard(){
    ActionCard aActionCard = TileOApplication.getTileO().getCurrentGame().getDeck().getCurrentCard();
	   if(aActionCard instanceof LoseTurnActionCard ) {
		   return true;
	   }
	   return false;
  }

  // line 471 "../../../../../playState.ump"
   private boolean isRevealActionCard(){
    ActionCard aActionCard = TileOApplication.getTileO().getCurrentGame().getDeck().getCurrentCard();
	   if(aActionCard instanceof RevealActionCard ) {
		   return true;
	   }
	   return false;
  }

  // line 479 "../../../../../playState.ump"
   private boolean isTeleportAndNormalTile(Tile tile){
    ActionCard aActionCard = TileOApplication.getTileO().getCurrentGame().getDeck().getCurrentCard();
	   if(aActionCard instanceof TeleportActionCard && tile instanceof NormalTile ) {
		   return true;
	   }
	   return false;
  }

  // line 487 "../../../../../playState.ump"
   private boolean isTeleportAndWinTile(Tile tile){
    ActionCard aActionCard = TileOApplication.getTileO().getCurrentGame().getDeck().getCurrentCard();
	   if(aActionCard instanceof TeleportActionCard && tile instanceof WinTile ) {
		   return true;
	   }
	   return false;
  }

  // line 495 "../../../../../playState.ump"
   private boolean isTeleportAndInactiveActionTile(Tile tile){
    ActionCard aActionCard = TileOApplication.getTileO().getCurrentGame().getDeck().getCurrentCard();   		
   		if (aActionCard instanceof TeleportActionCard && 
   			tile instanceof ActionTile && 
   			((ActionTile)tile).getActionTileStatus().equals(ActionTileStatus.Inactive)) {
   			return true;
   		}
   		return false;
  }

  // line 505 "../../../../../playState.ump"
   private boolean isActionTileAndInactive(Tile tile){
    if (tile instanceof ActionTile && ((ActionTile)tile).getActionTileStatus().equals(ActionTileStatus.Inactive)) {
			return true;
			}
		return false;
  }

  // line 512 "../../../../../playState.ump"
   private boolean isTeleportAndActiveActionTile(Tile tile){
    ActionCard aActionCard = TileOApplication.getTileO().getCurrentGame().getDeck().getCurrentCard();
	   if(aActionCard instanceof TeleportActionCard && 
	   		tile instanceof ActionTile &&
	   		((ActionTile)tile).getActionTileStatus().equals(ActionTileStatus.Active)) {
		   return true;
	   }
	   return false;
  }

}