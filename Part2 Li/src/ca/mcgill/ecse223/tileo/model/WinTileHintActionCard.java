/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;

import ca.mcgill.ecse223.tileo.controller.InvalidInputException;

// line 128 "../../../../../TileOPersistence.ump"
// line 416 "../../../../../TileO (updated April3).ump"
public class WinTileHintActionCard extends ActionCard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WinTileHintActionCard(String aInstructions, Deck aDeck)
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
  // line 421 "../../../../../TileO (updated April3).ump"
  @Override
   public Game.Mode getActionCardGameMode(){
    return Game.Mode.GAME_WINTILEHINTACTIONCARD;
  }

  // line 426 "../../../../../TileO (updated April3).ump"
   public boolean play(Tile aTile) throws InvalidInputException {
	   	Game currentGame = super.getDeck().getGame();
	    boolean hint = false;
	    
	    Tile topTile;
	    Tile bottomTile;
	    Tile rightTile;
	    Tile leftTile;
	    
	    String error = "";

			for (Tile tileInGame : currentGame.getTiles()){
				if (aTile.getY() == tileInGame.getY() -1){
					topTile = tileInGame;
				}
				if (aTile.getY() == tileInGame.getY() +1){
					bottomTile = tileInGame;
				}
				if (aTile.getX() == tileInGame.getX() -1){
					leftTile = tileInGame;
				}
				if (aTile.getX() == tileInGame.getY() +1){
					rightTile = tileInGame;
				}
			}
	    
			try {
				if (aTile instanceof WinTile) {
					hint  = true;
				}
				if (topTile != null){
					if (topTile instanceof WinTile) {
						hint = true;
					}
				}
				if (bottomTile != null) {
					
					if (bottomTile instanceof WinTile) {
						hint = true;
					}
				}
				if (rightTile != null) {
					if (rightTile instanceof WinTile) {
						hint = true;
					}				
				}
				if (leftTile != null) {
					if (leftTile instanceof WinTile) {
						hint = true;
					}
				}
				return hint;
			}
			catch (RuntimeException e) {
				error = e.getMessage();
				throw new InvalidInputException(error);
			}
	  }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 131 TileOPersistence.ump
  private static final long serialVersionUID = 1337133713371337133L ;

  
}