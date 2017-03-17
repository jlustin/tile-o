/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;
import java.util.*;

// line 41 "../../../../../TileOPersistence.ump"
// line 167 "../../../../../TileO (updated Feb10).ump"
public class NormalTile extends Tile
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public NormalTile(int aX, int aY, Game aGame)
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
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 44 TileOPersistence.ump
  private static final long serialVersionUID = 6666666666666666666L ;
// line 170 ../../../../../TileO (updated Feb10).ump
  @Override
  	public void doLand() {
	  Game currentGame = getGame();
  	  	Player currentPlayer = currentGame.getCurrentPlayer();  	 
  	  	currentPlayer.setCurrentTile(this);  	 
  	  	currentGame.setNextPlayer();
  	  	// set possible tile that player chose, that it has been visited
  	  	this.setHasBeenVisited(true);
  	  	currentGame.setMode(Game.Mode.GAME);	//added 552
  	  	
};

  
}