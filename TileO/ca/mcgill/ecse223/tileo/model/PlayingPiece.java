/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;

// line 45 "../../../../../TileO2.ump"
public class PlayingPiece extends Element
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PlayingPiece Attributes
  private String color;
  private boolean isMoving;
  private int stepsDone;
  private Location startLocation;
  private Location currentLocation;

  //PlayingPiece Associations
  private Player player;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PlayingPiece(SpecificGame aBoardgame, String aColor, Location aStartLocation, Location aCurrentLocation, Player aPlayer)
  {
    super(aBoardgame);
    color = aColor;
    resetIsMoving();
    resetStepsDone();
    startLocation = aStartLocation;
    currentLocation = aCurrentLocation;
    if (aPlayer == null || aPlayer.getAvatar() != null)
    {
      throw new RuntimeException("Unable to create PlayingPiece due to aPlayer");
    }
    player = aPlayer;
  }

  public PlayingPiece(SpecificGame aBoardgame, String aColor, Location aStartLocation, Location aCurrentLocation, int aPlayerNumberForPlayer, boolean aCanDrawCardForPlayer, boolean aWillLoseNextTurnForPlayer)
  {
    super(aBoardgame);
    color = aColor;
    resetIsMoving();
    resetStepsDone();
    startLocation = aStartLocation;
    currentLocation = aCurrentLocation;
    player = new Player(aPlayerNumberForPlayer, aCanDrawCardForPlayer, aWillLoseNextTurnForPlayer, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setColor(String aColor)
  {
    boolean wasSet = false;
    color = aColor;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsMoving(boolean aIsMoving)
  {
    boolean wasSet = false;
    isMoving = aIsMoving;
    wasSet = true;
    return wasSet;
  }

  public boolean resetIsMoving()
  {
    boolean wasReset = false;
    isMoving = getDefaultIsMoving();
    wasReset = true;
    return wasReset;
  }

  public boolean setStepsDone(int aStepsDone)
  {
    boolean wasSet = false;
    stepsDone = aStepsDone;
    wasSet = true;
    return wasSet;
  }

  public boolean resetStepsDone()
  {
    boolean wasReset = false;
    stepsDone = getDefaultStepsDone();
    wasReset = true;
    return wasReset;
  }

  public boolean setStartLocation(Location aStartLocation)
  {
    boolean wasSet = false;
    startLocation = aStartLocation;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrentLocation(Location aCurrentLocation)
  {
    boolean wasSet = false;
    currentLocation = aCurrentLocation;
    wasSet = true;
    return wasSet;
  }

  public String getColor()
  {
    return color;
  }

  /**
   * while isMoving is true, will not check actionTile
   */
  public boolean getIsMoving()
  {
    return isMoving;
  }

  public boolean getDefaultIsMoving()
  {
    return false;
  }

  /**
   * while isMoving is true, it will pass by tiles, but not visit them
   * counter that will increment each time you step on a tile
   */
  public int getStepsDone()
  {
    return stepsDone;
  }

  public int getDefaultStepsDone()
  {
    return 0;
  }

  /**
   * once your steps done == rolled number, isMoving will turn to false
   */
  public Location getStartLocation()
  {
    return startLocation;
  }

  public Location getCurrentLocation()
  {
    return currentLocation;
  }

  public boolean isIsMoving()
  {
    return isMoving;
  }

  public Player getPlayer()
  {
    return player;
  }

  public void delete()
  {
    Player existingPlayer = player;
    player = null;
    if (existingPlayer != null)
    {
      existingPlayer.delete();
    }
    super.delete();
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "color" + ":" + getColor()+ "," +
            "isMoving" + ":" + getIsMoving()+ "," +
            "stepsDone" + ":" + getStepsDone()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "startLocation" + "=" + (getStartLocation() != null ? !getStartLocation().equals(this)  ? getStartLocation().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "currentLocation" + "=" + (getCurrentLocation() != null ? !getCurrentLocation().equals(this)  ? getCurrentLocation().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "player = "+(getPlayer()!=null?Integer.toHexString(System.identityHashCode(getPlayer())):"null")
     + outputString;
  }
}