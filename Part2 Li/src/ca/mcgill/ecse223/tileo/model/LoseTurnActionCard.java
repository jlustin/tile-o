/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;

// line 95 "../../../../../TileOPersistence.ump"
// line 327 "../../../../../TileO (updated Feb10).ump"
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


  /**
   * TODO: write the function for this
   */
  // line 337 "../../../../../TileO (updated Feb10).ump"
   public void play(){
    Game currentGame = super.getDeck().getGame();
	   Player currentplayer = currentGame.getCurrentPlayer();
	   currentplayer.loseTurns(1);
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 98 TileOPersistence.ump
  private static final long serialVersionUID = 6060606060606060606L ;
// line 330 ../../../../../TileO (updated Feb10).ump
  @Override
	public Game.Mode getActionCardGameMode() {return Game.Mode.GAME_LOSETURNACTIONCARD;};

  
}