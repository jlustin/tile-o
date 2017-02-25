/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;
import java.util.*;

// line 35 "../../../../../TileOPersistence.ump"
// line 41 "../../../../../TileO (updated Feb10).ump"
public class ActionTile extends Tile
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ActionTile Attributes
  private int inactivityPeriod;
  private int turnsUntilActive;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ActionTile(int aX, int aY, Game aGame, int aInactivityPeriod)
  {
    super(aX, aY, aGame);
    inactivityPeriod = aInactivityPeriod;
    turnsUntilActive = 0;
  }

  //------------------------
  // INTERFACE
  //------------------------
  
  public void land()
  {
	  // get current game
	  Game currentGame = getGame();
	  
	  // get current player
	  Player currentPlayer = currentGame.getCurrentPlayer();
	  
	  // set the player's current tile to the tile he has to move to
	  // possible moves from Charles
	  currentPlayer.setStartingTile(this);
	  
	  // get deck
	  Deck deck = currentGame.getDeck();
	  
	  // get the top card
	  ActionCard topCard = deck.getCurrentCard();
	  
	  Game.Mode currentMode = null;
	  
	  
	  // check what type of action card is topCard
	  if(topCard instanceof RemoveConnectionActionCard)
	  {
		  currentGame.setMode(currentMode.GAME_REMOVECONNECTIONACTIONCARD);
		  
	  }else if(topCard instanceof RollDieActionCard)
	  {
		  currentGame.setMode(currentMode.GAME_ROLLDIEACTIONCARD);
		  
	  }else if(topCard instanceof TeleportActionCard)
	  {
		  currentGame.setMode(currentMode.GAME_TELEPORTACTIONCARD);
		  
	  }else if(topCard instanceof ConnectTilesActionCard)
	  {
		  currentGame.setMode(currentMode.GAME_CONNECTTILESACTIONCARD);
		  
	  }else if(topCard instanceof LoseTurnActionCard)
	  {
		  currentGame.setMode(currentMode.GAME_LOSETURNACTIONCARD);
		  
	  }
	  
	// set possible tile that player chose, that it has been visited
	  this.setHasBeenVisited(true);
	}

  public boolean setTurnsUntilActive(int aTurnsUntilActive)
  {
    boolean wasSet = false;
    turnsUntilActive = aTurnsUntilActive;
    wasSet = true;
    return wasSet;
  }

  public int getInactivityPeriod()
  {
    return inactivityPeriod;
  }

  public int getTurnsUntilActive()
  {
    return turnsUntilActive;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "inactivityPeriod" + ":" + getInactivityPeriod()+ "," +
            "turnsUntilActive" + ":" + getTurnsUntilActive()+ "]"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 38 ../../../../../TileOPersistence.ump
  private static final long serialVersionUID = 5555555555555555555L ;

  
}