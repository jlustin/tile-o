/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;

// line 101 "../../../../../TileO2.ump"
public class PackOfConnectionPieces extends Element
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PackOfConnectionPieces Attributes
  private int spareConnectionPieces;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PackOfConnectionPieces(SpecificGame aBoardgame)
  {
    super(aBoardgame);
    resetSpareConnectionPieces();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSpareConnectionPieces(int aSpareConnectionPieces)
  {
    boolean wasSet = false;
    spareConnectionPieces = aSpareConnectionPieces;
    wasSet = true;
    return wasSet;
  }

  public boolean resetSpareConnectionPieces()
  {
    boolean wasReset = false;
    spareConnectionPieces = getDefaultSpareConnectionPieces();
    wasReset = true;
    return wasReset;
  }

  /**
   * while in the playing state, there is only 32 pieces
   */
  public int getSpareConnectionPieces()
  {
    return spareConnectionPieces;
  }

  public int getDefaultSpareConnectionPieces()
  {
    return 32;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "spareConnectionPieces" + ":" + getSpareConnectionPieces()+ "]"
     + outputString;
  }
}