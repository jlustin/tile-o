/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;

// line 132 "../../../../../TileO2.ump"
public class ConnectionPiece
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ConnectionPiece Attributes
  private boolean isUsed;
  private Location location;

  //ConnectionPiece Associations
  private Board board;
  private Tile tile;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ConnectionPiece(Location aLocation, Board aBoard, Tile aTile)
  {
    isUsed = false;
    location = aLocation;
    boolean didAddBoard = setBoard(aBoard);
    if (!didAddBoard)
    {
      throw new RuntimeException("Unable to create connectionPiece due to board");
    }
    boolean didAddTile = setTile(aTile);
    if (!didAddTile)
    {
      throw new RuntimeException("Unable to create connectionPiece due to tile");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsUsed(boolean aIsUsed)
  {
    boolean wasSet = false;
    isUsed = aIsUsed;
    wasSet = true;
    return wasSet;
  }

  public boolean setLocation(Location aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

  /**
   * 0..2 -- 1 Tile;	//can only be connected to 0 OR 2 tiles
   */
  public boolean getIsUsed()
  {
    return isUsed;
  }

  public Location getLocation()
  {
    return location;
  }

  public boolean isIsUsed()
  {
    return isUsed;
  }

  public Board getBoard()
  {
    return board;
  }

  public Tile getTile()
  {
    return tile;
  }

  public boolean setBoard(Board aBoard)
  {
    boolean wasSet = false;
    if (aBoard == null)
    {
      return wasSet;
    }

    Board existingBoard = board;
    board = aBoard;
    if (existingBoard != null && !existingBoard.equals(aBoard))
    {
      existingBoard.removeConnectionPiece(this);
    }
    board.addConnectionPiece(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setTile(Tile aTile)
  {
    boolean wasSet = false;
    //Must provide tile to connectionPiece
    if (aTile == null)
    {
      return wasSet;
    }

    //tile already at maximum (4)
    if (aTile.numberOfConnectionPieces() >= Tile.maximumNumberOfConnectionPieces())
    {
      return wasSet;
    }
    
    Tile existingTile = tile;
    tile = aTile;
    if (existingTile != null && !existingTile.equals(aTile))
    {
      boolean didRemove = existingTile.removeConnectionPiece(this);
      if (!didRemove)
      {
        tile = existingTile;
        return wasSet;
      }
    }
    tile.addConnectionPiece(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Board placeholderBoard = board;
    this.board = null;
    placeholderBoard.removeConnectionPiece(this);
    Tile placeholderTile = tile;
    this.tile = null;
    placeholderTile.removeConnectionPiece(this);
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "isUsed" + ":" + getIsUsed()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "location" + "=" + (getLocation() != null ? !getLocation().equals(this)  ? getLocation().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "board = "+(getBoard()!=null?Integer.toHexString(System.identityHashCode(getBoard())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "tile = "+(getTile()!=null?Integer.toHexString(System.identityHashCode(getTile())):"null")
     + outputString;
  }
}