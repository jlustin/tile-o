/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;

// line 146 "../../../../../TileO2.ump"
public class ActionTile
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ActionTile Attributes
  private boolean isNormal;
  private int turnsBeforeAction;
  private int turnCounter;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ActionTile(boolean aIsNormal, int aTurnsBeforeAction)
  {
    isNormal = aIsNormal;
    turnsBeforeAction = aTurnsBeforeAction;
    resetTurnCounter();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsNormal(boolean aIsNormal)
  {
    boolean wasSet = false;
    isNormal = aIsNormal;
    wasSet = true;
    return wasSet;
  }

  public boolean setTurnCounter(int aTurnCounter)
  {
    boolean wasSet = false;
    turnCounter = aTurnCounter;
    wasSet = true;
    return wasSet;
  }

  public boolean resetTurnCounter()
  {
    boolean wasReset = false;
    turnCounter = getDefaultTurnCounter();
    wasReset = true;
    return wasReset;
  }

  public boolean getIsNormal()
  {
    return isNormal;
  }

  /**
   * normal means that it acts as an action tile
   * will have a method that will draw a (top) card from the deck
   */
  public int getTurnsBeforeAction()
  {
    return turnsBeforeAction;
  }

  public int getTurnCounter()
  {
    return turnCounter;
  }

  public int getDefaultTurnCounter()
  {
    return 0;
  }

  public boolean isIsNormal()
  {
    return isNormal;
  }

  public void delete()
  {}


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "isNormal" + ":" + getIsNormal()+ "," +
            "turnsBeforeAction" + ":" + getTurnsBeforeAction()+ "," +
            "turnCounter" + ":" + getTurnCounter()+ "]"
     + outputString;
  }
}