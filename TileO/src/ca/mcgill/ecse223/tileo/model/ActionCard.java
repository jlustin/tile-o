/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse223.tileo.model;

// line 59 "../../../../../TileO.ump"
public class ActionCard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ActionCard Attributes
  private String effect;

  //ActionCard State Machines
  enum ActionCardType { DiceRoll, Connection, Removal, Move, TurnLoss }
  private ActionCardType actionCardType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ActionCard(String aEffect)
  {
    effect = aEffect;
    setActionCardType(ActionCardType.DiceRoll);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setEffect(String aEffect)
  {
    boolean wasSet = false;
    effect = aEffect;
    wasSet = true;
    return wasSet;
  }

  public String getEffect()
  {
    return effect;
  }

  public String getActionCardTypeFullName()
  {
    String answer = actionCardType.toString();
    return answer;
  }

  public ActionCardType getActionCardType()
  {
    return actionCardType;
  }

  public boolean setActionCardType(ActionCardType aActionCardType)
  {
    actionCardType = aActionCardType;
    return true;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "effect" + ":" + getEffect()+ "]"
     + outputString;
  }
}