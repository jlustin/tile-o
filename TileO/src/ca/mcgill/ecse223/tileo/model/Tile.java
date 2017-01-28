/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse223.tileo.model;

// line 33 "../../../../../TileO.ump"
public class Tile
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Tile Attributes
  private String colour;
  private Location location;
  private boolean isBeingSteppedOn;
  private boolean hasBeenVisited;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Tile(String aColour, Location aLocation, boolean aIsBeingSteppedOn, boolean aHasBeenVisited)
  {
    colour = aColour;
    location = aLocation;
    isBeingSteppedOn = aIsBeingSteppedOn;
    hasBeenVisited = aHasBeenVisited;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setColour(String aColour)
  {
    boolean wasSet = false;
    colour = aColour;
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

  public boolean setIsBeingSteppedOn(boolean aIsBeingSteppedOn)
  {
    boolean wasSet = false;
    isBeingSteppedOn = aIsBeingSteppedOn;
    wasSet = true;
    return wasSet;
  }

  public boolean setHasBeenVisited(boolean aHasBeenVisited)
  {
    boolean wasSet = false;
    hasBeenVisited = aHasBeenVisited;
    wasSet = true;
    return wasSet;
  }

  public String getColour()
  {
    return colour;
  }

  public Location getLocation()
  {
    return location;
  }

  public boolean getIsBeingSteppedOn()
  {
    return isBeingSteppedOn;
  }

  public boolean getHasBeenVisited()
  {
    return hasBeenVisited;
  }

  public boolean isIsBeingSteppedOn()
  {
    return isBeingSteppedOn;
  }

  public boolean isHasBeenVisited()
  {
    return hasBeenVisited;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "colour" + ":" + getColour()+ "," +
            "isBeingSteppedOn" + ":" + getIsBeingSteppedOn()+ "," +
            "hasBeenVisited" + ":" + getHasBeenVisited()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "location" + "=" + (getLocation() != null ? !getLocation().equals(this)  ? getLocation().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}