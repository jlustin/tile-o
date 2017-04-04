/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;

import ca.mcgill.ecse223.tileo.controller.InvalidInputException;

// line 121 "../../../../../TileOPersistence.ump"
// line 403 "../../../../../TileO (updated April3).ump"
public class TurnActionTilesInactiveActionCard extends ActionCard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TurnActionTilesInactiveActionCard(String aInstructions, Deck aDeck)
  {
    super(aInstructions, aDeck);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }
//test commit

  /**
   * @Override
   */
  // line 407 "../../../../../TileO (updated April3).ump"
  @Override
   public Game.Mode getActionCardGameMode(){
    return Game.Mode.GAME_TURNACTIONTILESINACTIVEACTIONCARD;
  }

  // line 412 "../../../../../TileO (updated April3).ump"
   public void play() throws InvalidInputException{
    String error = "";
    try {
    	
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 124 TileOPersistence.ump
  private static final long serialVersionUID = 3829385123748593214L ;

  
}