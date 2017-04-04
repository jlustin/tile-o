/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;

import ca.mcgill.ecse223.tileo.controller.InvalidInputException;

// line 77 "../../../../../TileOPersistence.ump"
<<<<<<< HEAD
// line 242 "../../../../../TileO (updated Feb10).ump"
=======
// line 270 "../../../../../TileO (updated April3).ump"
>>>>>>> master
public class ConnectTilesActionCard extends ActionCard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ConnectTilesActionCard(String aInstructions, Deck aDeck)
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
  // line 246 "../../../../../TileO (updated Feb10).ump"
=======
  // line 274 "../../../../../TileO (updated April3).ump"
>>>>>>> master
   public void play(Tile tile1, Tile tile2) throws InvalidInputException{
    // Get game of the card
	  	Game currentGame = super.getDeck().getGame();
	  	String error = "";
	  	try {
			// Create a connection and add the connection to the selected tiles
			Connection newConnection = currentGame.addConnection();
			tile1.addConnection(newConnection);
			tile2.addConnection(newConnection);
		}
	  	catch (RuntimeException e) {
		  	error = e.getMessage();
			throw new InvalidInputException(error);
	  	}
  }
<<<<<<< HEAD
=======


  
  // line 291 "../../../../../TileO (updated April3).ump"
   @Override
   public Game.Mode getActionCardGameMode(){
    return Game.Mode.GAME_CONNECTTILESACTIONCARD;
  }
>>>>>>> master
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 80 TileOPersistence.ump
  private static final long serialVersionUID = 3030303030303030303L ;
<<<<<<< HEAD
// line 261 ../../../../../TileO (updated Feb10).ump
  @Override
	public Game.Mode getActionCardGameMode() {return Game.Mode.GAME_CONNECTTILESACTIONCARD;};
=======
>>>>>>> master

  
}