/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;

import ca.mcgill.ecse223.tileo.controller.InvalidInputException;

// line 83 "../../../../../TileOPersistence.ump"
<<<<<<< HEAD
// line 267 "../../../../../TileO (updated Feb10).ump"
=======
// line 295 "../../../../../TileO (updated April3).ump"
>>>>>>> master
public class RemoveConnectionActionCard extends ActionCard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RemoveConnectionActionCard(String aInstructions, Deck aDeck)
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
  // line 271 "../../../../../TileO (updated Feb10).ump"
=======
  // line 299 "../../../../../TileO (updated April3).ump"
>>>>>>> master
   public void play(Connection connection) throws InvalidInputException{
    try{
		  connection.delete();
	  }
	  catch (RuntimeException e) {
		  throw new InvalidInputException(e.getMessage());
	  }
  }
<<<<<<< HEAD
=======


 
  // line 309 "../../../../../TileO (updated April3).ump"
   @Override
   public Game.Mode getActionCardGameMode(){
    return Game.Mode.GAME_REMOVECONNECTIONACTIONCARD;
  }
>>>>>>> master
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 86 TileOPersistence.ump
  private static final long serialVersionUID = 4040404040404040404L ;
<<<<<<< HEAD
// line 279 ../../../../../TileO (updated Feb10).ump
  @Override
	public Game.Mode getActionCardGameMode() {return Game.Mode.GAME_REMOVECONNECTIONACTIONCARD;};
=======
>>>>>>> master

  
}