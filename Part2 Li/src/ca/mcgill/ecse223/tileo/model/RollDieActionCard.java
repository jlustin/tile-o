/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;
import java.util.List;

// line 71 "../../../../../TileOPersistence.ump"
// line 249 "../../../../../TileO (updated Feb10).ump"
public class RollDieActionCard extends ActionCard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RollDieActionCard(String aInstructions, Deck aDeck)
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

  // line 253 "../../../../../TileO (updated Feb10).ump"
   public List<Tile> play(){
    Game currentGame = getDeck().getGame();
	  return currentGame.rollDie();
  }

  // line 258 "../../../../../TileO (updated Feb10).ump"
   public Game.Mode getActionCardGameMode(){
    return Game.Mode.GAME_ROLLDIEACTIONCARD;
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 74 TileOPersistence.ump
  private static final long serialVersionUID = 2020202020202020202L ;

  
}