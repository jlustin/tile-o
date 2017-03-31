/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;

// line 375 "../../../../../TileO (updated Feb10).ump"
public abstract class ShowActionTilesActionCard extends ActionCard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ShowActionTilesActionCard(String aInstructions, Deck aDeck)
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

  // line 379 "../../../../../TileO (updated Feb10).ump"
   public Game.Mode getActionCardGameMore(){
    return Game.Mode.GAME_REVEALACTIONTILESACTIONCARD;
  }

}