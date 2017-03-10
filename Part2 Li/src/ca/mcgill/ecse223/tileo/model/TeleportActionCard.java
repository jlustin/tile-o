/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;

import ca.mcgill.ecse223.tileo.controller.InvalidInputException;

// line 89 "../../../../../TileOPersistence.ump"
// line 252 "../../../../../TileO (updated Feb10).ump"
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

  // line 261 "../../../../../TileO (updated Feb10).ump"
   public void play(Tile tile) throws InvalidInputException{
    String error = "";
	  try {
		  tile.land();
	  }
	  catch (RuntimeException e) {
		  error = e.getMessage();
		  throw new InvalidInputException(error);
	  }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 92 ../../../../../TileOPersistence.ump
  private static final long serialVersionUID = 5050505050505050505L ;
// line 255 ../../../../../TileO (updated Feb10).ump
  @Override
  	public Game.Mode getActionCardGameMode() {return Game.Mode.GAME_TELEPORTACTIONCARD;};

  
}