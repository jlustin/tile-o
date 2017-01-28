/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse223.tileo.model;

// line 8 "../../../../../TileO.ump"
public class SpecificGame
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SpecificGame Associations
  private TileO tileO;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SpecificGame(TileO aTileO)
  {
    boolean didAddTileO = setTileO(aTileO);
    if (!didAddTileO)
    {
      throw new RuntimeException("Unable to create game due to tileO");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public TileO getTileO()
  {
    return tileO;
  }

  public boolean setTileO(TileO aTileO)
  {
    boolean wasSet = false;
    if (aTileO == null)
    {
      return wasSet;
    }

    TileO existingTileO = tileO;
    tileO = aTileO;
    if (existingTileO != null && !existingTileO.equals(aTileO))
    {
      existingTileO.removeGame(this);
    }
    tileO.addGame(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    TileO placeholderTileO = tileO;
    this.tileO = null;
    placeholderTileO.removeGame(this);
  }

}