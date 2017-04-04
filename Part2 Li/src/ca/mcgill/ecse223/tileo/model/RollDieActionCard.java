/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
<<<<<<< HEAD
import java.util.List;
import java.io.Serializable;

// line 71 "../../../../../TileOPersistence.ump"
// line 228 "../../../../../TileO (updated Feb10).ump"
=======
import java.io.Serializable;
import java.util.List;

// line 71 "../../../../../TileOPersistence.ump"
// line 256 "../../../../../TileO (updated April3).ump"
>>>>>>> master
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

<<<<<<< HEAD
  // line 232 "../../../../../TileO (updated Feb10).ump"
=======
  // line 260 "../../../../../TileO (updated April3).ump"
>>>>>>> master
   public List<Tile> play(){
    Game currentGame = getDeck().getGame();
	  return currentGame.rollDie();
  }
<<<<<<< HEAD
=======


  /**
   * @Override
   */
  // line 266 "../../../../../TileO (updated April3).ump"
   public Game.Mode getActionCardGameMode(){
    return Game.Mode.GAME_ROLLDIEACTIONCARD;
  }
>>>>>>> master
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 74 TileOPersistence.ump
  private static final long serialVersionUID = 2020202020202020202L ;
<<<<<<< HEAD
// line 236 ../../../../../TileO (updated Feb10).ump
  @Override
	public Game.Mode getActionCardGameMode() {return Game.Mode.GAME_ROLLDIEACTIONCARD;};
=======
>>>>>>> master

  
}