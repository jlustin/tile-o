/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse223.tileo.model;

// line 53 "../../../../../TileO.ump"
public class Deck
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Deck Attributes
  private int numberOfCards;
  private ActionCard topCard;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Deck(int aNumberOfCards, ActionCard aTopCard)
  {
    numberOfCards = aNumberOfCards;
    topCard = aTopCard;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumberOfCards(int aNumberOfCards)
  {
    boolean wasSet = false;
    numberOfCards = aNumberOfCards;
    wasSet = true;
    return wasSet;
  }

  public boolean setTopCard(ActionCard aTopCard)
  {
    boolean wasSet = false;
    topCard = aTopCard;
    wasSet = true;
    return wasSet;
  }

  public int getNumberOfCards()
  {
    return numberOfCards;
  }

  public ActionCard getTopCard()
  {
    return topCard;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "numberOfCards" + ":" + getNumberOfCards()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "topCard" + "=" + (getTopCard() != null ? !getTopCard().equals(this)  ? getTopCard().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}