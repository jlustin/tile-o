/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;
import java.util.*;

// line 35 "../../../../../TileOPersistence.ump"
// line 1 "../../../../../TileOStates.ump"
// line 136 "../../../../../TileO (updated Feb10).ump"
public class ActionTile extends Tile
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ActionTile Attributes
  private int inactivityPeriod;
  private int turnsUntilActive;

  //ActionTile State Machines
  public enum TileStatus { Active, Inactive }
  private TileStatus tileStatus;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ActionTile(int aX, int aY, Game aGame, int aInactivityPeriod)
  {
    super(aX, aY, aGame);
    inactivityPeriod = aInactivityPeriod;
    turnsUntilActive = 0;
    setTileStatus(TileStatus.Active);
  }

  //------------------------
  // INTERFACE
  //------------------------

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

  public String getTileStatusFullName()
  {
    String answer = tileStatus.toString();
    return answer;
  }

  public TileStatus getTileStatus()
  {
    return tileStatus;
  }

  public boolean land()
  {
    boolean wasEventProcessed = false;
    
    TileStatus aTileStatus = tileStatus;
    switch (aTileStatus)
    {
      case Active:
        if (inactivityPeriod==0)
        {
        // line 4 "../../../../../TileOStates.ump"
          doLand();
          setTileStatus(TileStatus.Active);
          wasEventProcessed = true;
          break;
        }
        if (inactivityPeriod>0)
        {
        // line 7 "../../../../../TileOStates.ump"
          doLand();
          setTileStatus(TileStatus.Inactive);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setTileStatus(TileStatus aTileStatus)
  {
    tileStatus = aTileStatus;
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
// line 142 ../../../../../TileO (updated Feb10).ump
  @Override
	public void doLand() {Game currentGame = getGame();
		Player currentPlayer = currentGame.getCurrentPlayer();
		currentPlayer.setCurrentTile(this);
		Deck deck = currentGame.getDeck();
		ActionCard currentCard = deck.getCurrentCard();	  
		currentGame.setMode(currentCard.getActionCardGameMode());
		setHasBeenVisited(true);};

  
}