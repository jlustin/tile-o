/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/



// line 32 "BTMS.ump"
public class DriverSchedule
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DriverSchedule Attributes
  private String assignment;

  //DriverSchedule State Machines
  enum Shift { Morning, Afternoon, Night }
  private Shift shift;

  //DriverSchedule Associations
  private Driver driver;
  private RouteAssignment routeAssignment;
  private BTMS bTMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DriverSchedule(String aAssignment, Driver aDriver, RouteAssignment aRouteAssignment, BTMS aBTMS)
  {
    assignment = aAssignment;
    boolean didAddDriver = setDriver(aDriver);
    if (!didAddDriver)
    {
      throw new RuntimeException("Unable to create driverSchedule due to driver");
    }
    boolean didAddRouteAssignment = setRouteAssignment(aRouteAssignment);
    if (!didAddRouteAssignment)
    {
      throw new RuntimeException("Unable to create driverSchedule due to routeAssignment");
    }
    boolean didAddBTMS = setBTMS(aBTMS);
    if (!didAddBTMS)
    {
      throw new RuntimeException("Unable to create schedule due to bTMS");
    }
    setShift(Shift.Morning);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAssignment(String aAssignment)
  {
    boolean wasSet = false;
    assignment = aAssignment;
    wasSet = true;
    return wasSet;
  }

  public String getAssignment()
  {
    return assignment;
  }

  public String getShiftFullName()
  {
    String answer = shift.toString();
    return answer;
  }

  public Shift getShift()
  {
    return shift;
  }

  public boolean setShift(Shift aShift)
  {
    shift = aShift;
    return true;
  }

  public Driver getDriver()
  {
    return driver;
  }

  public RouteAssignment getRouteAssignment()
  {
    return routeAssignment;
  }

  public BTMS getBTMS()
  {
    return bTMS;
  }

  public boolean setDriver(Driver aDriver)
  {
    boolean wasSet = false;
    if (aDriver == null)
    {
      return wasSet;
    }

    Driver existingDriver = driver;
    driver = aDriver;
    if (existingDriver != null && !existingDriver.equals(aDriver))
    {
      existingDriver.removeDriverSchedule(this);
    }
    driver.addDriverSchedule(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setRouteAssignment(RouteAssignment aRouteAssignment)
  {
    boolean wasSet = false;
    if (aRouteAssignment == null)
    {
      return wasSet;
    }

    RouteAssignment existingRouteAssignment = routeAssignment;
    routeAssignment = aRouteAssignment;
    if (existingRouteAssignment != null && !existingRouteAssignment.equals(aRouteAssignment))
    {
      existingRouteAssignment.removeDriverSchedule(this);
    }
    routeAssignment.addDriverSchedule(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setBTMS(BTMS aBTMS)
  {
    boolean wasSet = false;
    if (aBTMS == null)
    {
      return wasSet;
    }

    BTMS existingBTMS = bTMS;
    bTMS = aBTMS;
    if (existingBTMS != null && !existingBTMS.equals(aBTMS))
    {
      existingBTMS.removeSchedule(this);
    }
    bTMS.addSchedule(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Driver placeholderDriver = driver;
    this.driver = null;
    placeholderDriver.removeDriverSchedule(this);
    RouteAssignment placeholderRouteAssignment = routeAssignment;
    this.routeAssignment = null;
    placeholderRouteAssignment.removeDriverSchedule(this);
    BTMS placeholderBTMS = bTMS;
    this.bTMS = null;
    placeholderBTMS.removeSchedule(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "assignment" + ":" + getAssignment()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "driver = "+(getDriver()!=null?Integer.toHexString(System.identityHashCode(getDriver())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "routeAssignment = "+(getRouteAssignment()!=null?Integer.toHexString(System.identityHashCode(getRouteAssignment())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "bTMS = "+(getBTMS()!=null?Integer.toHexString(System.identityHashCode(getBTMS())):"null")
     + outputString;
  }
}