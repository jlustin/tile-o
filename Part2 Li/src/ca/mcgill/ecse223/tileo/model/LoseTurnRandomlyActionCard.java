/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

// line 107 "../../../../../TileOPersistence.ump"
// line 378 "../../../../../TileO (updated April3).ump"
public class LoseTurnRandomlyActionCard extends ActionCard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LoseTurnRandomlyActionCard(String aInstructions, Deck aDeck)
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


  
  // line 383 "../../../../../TileO (updated April3).ump"
  @Override
   public Game.Mode getActionCardGameMode(){
    return Game.Mode.GAME_LOSETURNRANDOMLYACTIONCARD;
  }

  // line 388 "../../../../../TileO (updated April3).ump"
   public void play(){
	   Game currentGame = getDeck().getGame();
	   Random randomGenerator = new Random();
	   List<Player> listOfPlayers = currentGame.getPlayers();
	   
	   for (Player aPlayer : listOfPlayers){
		   aPlayer.loseTurns(randomGenerator.nextInt(3));
	   }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 110 TileOPersistence.ump
  private static final long serialVersionUID = 1029384756019283745L ;

  
}