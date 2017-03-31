/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;
import java.util.*;

// line 47 "../../../../../TileOPersistence.ump"
// line 199 "../../../../../TileO (updated Feb10).ump"
public class WinTile extends Tile
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WinTile(int aX, int aY, Game aGame)
  {
    super(aX, aY, aGame);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

  // line 203 "../../../../../TileO (updated Feb10).ump"
   public void doLand(){
    Game currentGame = this.getGame();  	  
  	  	this.setHasBeenVisited(true);  	 
  	  	Player currentPlayer = currentGame.getCurrentPlayer();  	 
  	  	currentPlayer.setCurrentTile(this); 
  	  	currentGame.setMode(Game.Mode.GAME_WON);
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 50 TileOPersistence.ump
  private static final long serialVersionUID = 7777777777777777777L ;

  
}