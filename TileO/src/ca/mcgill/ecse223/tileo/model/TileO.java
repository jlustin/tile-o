/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.util.*;

// line 3 "../../../../../TileO.ump"
public class TileO
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TileO State Machines
  enum StateType { Designing, Playing, Ended }
  private StateType stateType;

  //TileO Associations
  private List<SpecificGame> game;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TileO()
  {
    game = new ArrayList<SpecificGame>();
    setStateType(StateType.Designing);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getStateTypeFullName()
  {
    String answer = stateType.toString();
    return answer;
  }

  public StateType getStateType()
  {
    return stateType;
  }

  public boolean setStateType(StateType aStateType)
  {
    stateType = aStateType;
    return true;
  }

  public SpecificGame getGame(int index)
  {
    SpecificGame aGame = game.get(index);
    return aGame;
  }

  public List<SpecificGame> getGame()
  {
    List<SpecificGame> newGame = Collections.unmodifiableList(game);
    return newGame;
  }

  public int numberOfGame()
  {
    int number = game.size();
    return number;
  }

  public boolean hasGame()
  {
    boolean has = game.size() > 0;
    return has;
  }

  public int indexOfGame(SpecificGame aGame)
  {
    int index = game.indexOf(aGame);
    return index;
  }

  public static int minimumNumberOfGame()
  {
    return 0;
  }

  public SpecificGame addGame()
  {
    return new SpecificGame(this);
  }

  public boolean addGame(SpecificGame aGame)
  {
    boolean wasAdded = false;
    if (game.contains(aGame)) { return false; }
    TileO existingTileO = aGame.getTileO();
    boolean isNewTileO = existingTileO != null && !this.equals(existingTileO);
    if (isNewTileO)
    {
      aGame.setTileO(this);
    }
    else
    {
      game.add(aGame);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeGame(SpecificGame aGame)
  {
    boolean wasRemoved = false;
    //Unable to remove aGame, as it must always have a tileO
    if (!this.equals(aGame.getTileO()))
    {
      game.remove(aGame);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addGameAt(SpecificGame aGame, int index)
  {  
    boolean wasAdded = false;
    if(addGame(aGame))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGame()) { index = numberOfGame() - 1; }
      game.remove(aGame);
      game.add(index, aGame);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveGameAt(SpecificGame aGame, int index)
  {
    boolean wasAdded = false;
    if(game.contains(aGame))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGame()) { index = numberOfGame() - 1; }
      game.remove(aGame);
      game.add(index, aGame);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addGameAt(aGame, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (game.size() > 0)
    {
      SpecificGame aGame = game.get(game.size() - 1);
      aGame.delete();
      game.remove(aGame);
    }
    
      
  }

}