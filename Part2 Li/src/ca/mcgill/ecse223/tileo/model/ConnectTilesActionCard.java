/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;

// line 77 "../../../../../TileOPersistence.ump"
// line 269 "../../../../../TileO (updated Feb10).ump"
public abstract class ConnectTilesActionCard extends ActionCard
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

  // line 273 "../../../../../TileO (updated Feb10).ump"
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
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 80 TileOPersistence.ump
  private static final long serialVersionUID = 3030303030303030303L ;
// line 288 ../../../../../TileO (updated Feb10).ump
  @Override
	public Game.Mode getActionCardGameMode() {return Game.Mode.GAME_CONNECTTILESACTIONCARD;};

  
}