/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
<<<<<<< HEAD

import ca.mcgill.ecse223.tileo.controller.InvalidInputException;

// line 320 "../../../../../TileO (updated Feb10).ump"
=======
import java.io.Serializable;

import ca.mcgill.ecse223.tileo.controller.InvalidInputException;

// line 149 "../../../../../TileOPersistence.ump"
// line 348 "../../../../../TileO (updated April3).ump"
>>>>>>> master
public class RevealActionCard extends ActionCard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RevealActionCard(String aInstructions, Deck aDeck)
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
  // line 329 "../../../../../TileO (updated Feb10).ump"
   public String play(Tile aTile) throws InvalidInputException{
    String type = null;
    String error = "";
=======

  /**
   * @Override
   */
  // line 353 "../../../../../TileO (updated April3).ump"
  @Override
   public Game.Mode getActionCardGameMode(){
    return Game.Mode.GAME_REVEALACTIONCARD;
  }

  // line 357 "../../../../../TileO (updated April3).ump"
   public String play(Tile aTile) throws InvalidInputException{
    String type = null;
		String error = "";
>>>>>>> master
		try {
			if (aTile instanceof NormalTile) {
				type = "Normal Tile";
			}
			else if (aTile instanceof ActionTile) {
				type = "Action Tile";
			}
			else if (aTile instanceof WinTile) {
				type = "Win Tile";
			}
			return type;
		}
		catch (RuntimeException e) {
			error = e.getMessage();
			throw new InvalidInputException(error);
		}
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
<<<<<<< HEAD
  // line 323 ../../../../../TileO (updated Feb10).ump
  @Override
	public Game.Mode getActionCardGameMode() {return Game.Mode.GAME_REVEALACTIONCARD;};
=======
  // line 152 TileOPersistence.ump
  private static final long serialVersionUID = 4938573821423152358L ;
>>>>>>> master

  
}