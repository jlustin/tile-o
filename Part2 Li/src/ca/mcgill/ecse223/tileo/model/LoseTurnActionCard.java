/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;

// line 95 "../../../../../TileOPersistence.ump"
<<<<<<< HEAD
// line 305 "../../../../../TileO (updated Feb10).ump"
=======
// line 333 "../../../../../TileO (updated April3).ump"
>>>>>>> master
public class LoseTurnActionCard extends ActionCard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LoseTurnActionCard(String aInstructions, Deck aDeck)
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
  // line 314 "../../../../../TileO (updated Feb10).ump"
=======

  
  // line 338 "../../../../../TileO (updated April3).ump"
  @Override
   public Game.Mode getActionCardGameMode(){
    return Game.Mode.GAME_LOSETURNACTIONCARD;
  }

  // line 342 "../../../../../TileO (updated April3).ump"
>>>>>>> master
   public void play(){
    Game currentGame = super.getDeck().getGame();
	   	Player currentplayer = currentGame.getCurrentPlayer();
	   	currentplayer.loseTurns(currentGame.numberOfPlayers() + 1);
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 98 TileOPersistence.ump
  private static final long serialVersionUID = 6060606060606060606L ;
<<<<<<< HEAD
// line 308 ../../../../../TileO (updated Feb10).ump
  @Override
	public Game.Mode getActionCardGameMode() {return Game.Mode.GAME_LOSETURNACTIONCARD;};
=======
>>>>>>> master

  
}