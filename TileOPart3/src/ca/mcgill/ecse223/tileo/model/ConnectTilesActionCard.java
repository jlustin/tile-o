/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;

// line 77 "../../../../../TileOPersistence.ump"
// line 74 "../../../../../TileO (updated Feb10).ump"
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
  
  public void play (Tile tile1, Tile tile2){
	  Game currentGame = super.getDeck().getGame();
	  
	  Connection newConnection = currentGame.addConnection();
	  tile1.addConnection(newConnection);
	  tile2.addConnection(newConnection);
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 80 ../../../../../TileOPersistence.ump
  private static final long serialVersionUID = 3030303030303030303L ;

  
}