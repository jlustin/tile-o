/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse223.tileo.model;

// line 28 "../../../../../TileO.ump"
public class Location
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Location Attributes
  private int xComponent;
  private int yComponent;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Location(int aXComponent, int aYComponent)
  {
    xComponent = aXComponent;
    yComponent = aYComponent;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setXComponent(int aXComponent)
  {
    boolean wasSet = false;
    xComponent = aXComponent;
    wasSet = true;
    return wasSet;
  }

  public boolean setYComponent(int aYComponent)
  {
    boolean wasSet = false;
    yComponent = aYComponent;
    wasSet = true;
    return wasSet;
  }

  public int getXComponent()
  {
    return xComponent;
  }

  public int getYComponent()
  {
    return yComponent;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "xComponent" + ":" + getXComponent()+ "," +
            "yComponent" + ":" + getYComponent()+ "]"
     + outputString;
  }
}