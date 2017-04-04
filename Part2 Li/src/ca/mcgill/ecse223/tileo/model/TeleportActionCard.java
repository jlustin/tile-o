/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;

import ca.mcgill.ecse223.tileo.controller.InvalidInputException;

// line 89 "../../../../../TileOPersistence.ump"
<<<<<<< HEAD
// line 285 "../../../../../TileO (updated Feb10).ump"
=======
// line 313 "../../../../../TileO (updated April3).ump"
>>>>>>> master
public class TeleportActionCard extends ActionCard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TeleportActionCard(String aInstructions, Deck aDeck)
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

<<<<<<< HEAD
  // line 294 "../../../../../TileO (updated Feb10).ump"
=======

  /**
   * @Override
   */
  // line 318 "../../../../../TileO (updated April3).ump"
  @Override
   public Game.Mode getActionCardGameMode(){
    return Game.Mode.GAME_TELEPORTACTIONCARD;
  }

  // line 322 "../../../../../TileO (updated April3).ump"
>>>>>>> master
   public void play(Tile tile) throws InvalidInputException{
    String error = "";
	  try {
		  tile.doLand();
	  }
	  catch (RuntimeException e) {
		  error = e.getMessage();
		  throw new InvalidInputException(error);
	  }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 92 TileOPersistence.ump
  private static final long serialVersionUID = 5050505050505050505L ;
<<<<<<< HEAD
// line 288 ../../../../../TileO (updated Feb10).ump
  @Override
  	public Game.Mode getActionCardGameMode() {return Game.Mode.GAME_TELEPORTACTIONCARD;};
=======
>>>>>>> master

  
}