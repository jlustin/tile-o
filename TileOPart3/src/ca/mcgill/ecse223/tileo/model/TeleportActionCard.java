/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;

import ca.mcgill.ecse223.tileo.controller.InvalidInputException;

// line 89 "../../../../../TileOPersistence.ump"
// line 82 "../../../../../TileO (updated Feb10).ump"
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
  
  //@Override <- need to add abstract class to ActionCard
  public Game.Mode getActionCardGameMode() {
	  return Game.Mode.GAME_TELEPORTACTIONCARD;
 }

  
  public void play(Tile tile) throws InvalidInputException {
	  Deck deck = this.getDeck();	 
	  Game game = deck.getGame();
	  Player player = game.getCurrentPlayer(); 
	  player.setCurrentTile(tile);
	  
	  //add land()
	  
	  //Exception
 }
  

  public void delete()
  {
    super.delete();
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 92 ../../../../../TileOPersistence.ump
  private static final long serialVersionUID = 5050505050505050505L ;

  
}