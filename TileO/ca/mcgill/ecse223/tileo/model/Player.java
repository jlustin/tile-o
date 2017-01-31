/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;

// line 13 "../../../../../TileO2.ump"
public class Player extends User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Player Attributes
  private int playerNumber;
  private boolean myTurn;
  private boolean canDrawCard;
  private boolean willLoseNextTurn;

  //Player Associations
  private PlayingPiece avatar;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Player(int aPlayerNumber, boolean aCanDrawCard, boolean aWillLoseNextTurn, PlayingPiece aAvatar)
  {
    super();
    playerNumber = aPlayerNumber;
    resetMyTurn();
    canDrawCard = aCanDrawCard;
    willLoseNextTurn = aWillLoseNextTurn;
    if (aAvatar == null || aAvatar.getPlayer() != null)
    {
      throw new RuntimeException("Unable to create Player due to aAvatar");
    }
    avatar = aAvatar;
  }

  public Player(int aPlayerNumber, boolean aCanDrawCard, boolean aWillLoseNextTurn, SpecificGame aBoardgameForAvatar, String aColorForAvatar, Location aStartLocationForAvatar, Location aCurrentLocationForAvatar)
  {
    super();
    playerNumber = aPlayerNumber;
    resetMyTurn();
    canDrawCard = aCanDrawCard;
    willLoseNextTurn = aWillLoseNextTurn;
    avatar = new PlayingPiece(aBoardgameForAvatar, aColorForAvatar, aStartLocationForAvatar, aCurrentLocationForAvatar, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPlayerNumber(int aPlayerNumber)
  {
    boolean wasSet = false;
    playerNumber = aPlayerNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setMyTurn(boolean aMyTurn)
  {
    boolean wasSet = false;
    myTurn = aMyTurn;
    wasSet = true;
    return wasSet;
  }

  public boolean resetMyTurn()
  {
    boolean wasReset = false;
    myTurn = getDefaultMyTurn();
    wasReset = true;
    return wasReset;
  }

  public boolean setCanDrawCard(boolean aCanDrawCard)
  {
    boolean wasSet = false;
    canDrawCard = aCanDrawCard;
    wasSet = true;
    return wasSet;
  }

  public boolean setWillLoseNextTurn(boolean aWillLoseNextTurn)
  {
    boolean wasSet = false;
    willLoseNextTurn = aWillLoseNextTurn;
    wasSet = true;
    return wasSet;
  }

  public int getPlayerNumber()
  {
    return playerNumber;
  }

  /**
   * only turns true once isMoving is false
   */
  public boolean getMyTurn()
  {
    return myTurn;
  }

  public boolean getDefaultMyTurn()
  {
    return false;
  }

  public boolean getCanDrawCard()
  {
    return canDrawCard;
  }

  public boolean getWillLoseNextTurn()
  {
    return willLoseNextTurn;
  }

  public boolean isMyTurn()
  {
    return myTurn;
  }

  public boolean isCanDrawCard()
  {
    return canDrawCard;
  }

  public boolean isWillLoseNextTurn()
  {
    return willLoseNextTurn;
  }

  public PlayingPiece getAvatar()
  {
    return avatar;
  }

  public void delete()
  {
    PlayingPiece existingAvatar = avatar;
    avatar = null;
    if (existingAvatar != null)
    {
      existingAvatar.delete();
    }
    super.delete();
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "playerNumber" + ":" + getPlayerNumber()+ "," +
            "myTurn" + ":" + getMyTurn()+ "," +
            "canDrawCard" + ":" + getCanDrawCard()+ "," +
            "willLoseNextTurn" + ":" + getWillLoseNextTurn()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "avatar = "+(getAvatar()!=null?Integer.toHexString(System.identityHashCode(getAvatar())):"null")
     + outputString;
  }
}