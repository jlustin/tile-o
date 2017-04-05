/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;

// line 114 "../../../../../TileOPersistence.ump"
// line 391 "../../../../../TileO (updated April3).ump"
public class RevealActionTilesActionCard extends ActionCard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RevealActionTilesActionCard(String aInstructions, Deck aDeck)
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
   * @Override
   */
  // line 395 "../../../../../TileO (updated April3).ump"
  @Override
   public Game.Mode getActionCardGameMode(){
    return Game.Mode.GAME_REVEALACTIONTILESACTIONCARD;
  }

  // line 400 "../../../../../TileO (updated April3).ump"
   public void play(){
	   
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 117 TileOPersistence.ump
  private static final long serialVersionUID = 1098766543012347859L ;

  
}