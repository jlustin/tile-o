/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;

// line 59 "../../../../../TileO2.ump"
public class Die
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Die Attributes
  private int numberOfFaces;
  private int rolledNumber;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Die(int aNumberOfFaces, int aRolledNumber)
  {
    numberOfFaces = aNumberOfFaces;
    rolledNumber = aRolledNumber;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumberOfFaces(int aNumberOfFaces)
  {
    boolean wasSet = false;
    numberOfFaces = aNumberOfFaces;
    wasSet = true;
    return wasSet;
  }

  public boolean setRolledNumber(int aRolledNumber)
  {
    boolean wasSet = false;
    rolledNumber = aRolledNumber;
    wasSet = true;
    return wasSet;
  }

  public int getNumberOfFaces()
  {
    return numberOfFaces;
  }

  public int getRolledNumber()
  {
    return rolledNumber;
  }

  public void delete()
  {}


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "numberOfFaces" + ":" + getNumberOfFaces()+ "," +
            "rolledNumber" + ":" + getRolledNumber()+ "]"
     + outputString;
  }
}