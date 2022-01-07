
/**
 * Data class to define the City.  The city has the name, latitude, longitude, and elevation.  
 * The city is the data item store in a binary tree.
 */
public class City
{
    //************************************************************************************
    //*** Definition of private class attributes.                                      ***
    //************************************************************************************
    private String m_sName;                         // Name of the city
    private double m_dfLongitude;                   // Longitude of the city`
    private double m_dfLatitude;                    // Latitude of the city
    private double m_dfElevation;                   // Elevation, i.e. height of the city
    //************************************************************************************
   

    //************************************************************************************
    //************************************************************************************
    //************************************************************************************



    //************************************************************************************
    //*** PRoperty methods to set/get values of the attributes.                        ***
    //************************************************************************************
 
 
    //************************************************************************************
    /**
     * Property method to GET the name of the City instance.
     * @return Name of the city.
     */
    public String getName()              { return m_sName;            }
    //************************************************************************************
 


    //************************************************************************************
    /**
     * Property method to SET the name of the City instance.
     * @param name The name of the city which will be set to the instance.
     * @return The value that was set to the name attribute of the City instance.
     */
    public String setName(String name)   { return m_sName = name;     }
    //************************************************************************************
   


    //************************************************************************************
    /**
     * Property method to GET the longitude of the City instance.
     * @return Longitude of the city.
     */
    public double getLongitude()         { return m_dfLongitude;      }
    //************************************************************************************
   
  

    //************************************************************************************
    /**
     * Property method to SET the longitude of the City instance.
     * @param name The longitude of the city which will be set to the instance.
     * @return The value that was set to the longitude attribute of the City instance.
     */
    public double setLongitude(double l) { return m_dfLongitude = l;  }
    //************************************************************************************
   


    //************************************************************************************
    /**
     * Property method to GET the Latitude of the City instance.
     * @return Latitude of the city.
     */
    public double getLatitude()          { return m_dfLatitude;       }
    //************************************************************************************



    //************************************************************************************
    /**
     * Property method to SET the lotitude of the City instance.
     * @param name The lotitude of the city which will be set to the instance.
     * @return The value that was set to the lotitude attribute of the City instance.
     */
    public double setLatitude(double l)  { return m_dfLatitude = l;   }
    //************************************************************************************
   


    //************************************************************************************
    /**
     * Property method to GET the elevation of the City instance.
     * @return Elevation of the city.
     */
    public double getElevation()         { return m_dfElevation;      }
    //************************************************************************************



    //************************************************************************************
    /**
     * Property method to SET the Elevation of the City instance.
     * @param name The Elevation of the city which will be set to the instance.
     * @return The value that was set to the Elevation attribute of the City instance.
     */
    public double setElevation(double l) { return m_dfElevation = l;  }
    //************************************************************************************
    


    //************************************************************************************
    //*** CONSTRUCTOR(S)                                                               ***
    //************************************************************************************



    //************************************************************************************
    /**
     * Default constructor.  This constructor creates an instance of City with all 
     * attributes initialized to the default, i.e. blank values.
     */
    public City()
    {
        setName("");
        setLatitude(0.0);
        setLongitude(0.0);
        setElevation(0.0);
    }
    //************************************************************************************



    //************************************************************************************
    /**
     * Parameterized constructor.  This constructor creates an instance of City with all 
     * attributes initialized to the values passed via the parameters.
     * @param name Name of the City
     * @param latitude Latitude coordinate of the city
     * @param longitude Longitude coordinate of the city
     * @param elevation Elevation above sea level in meters.
     */
    public City(String name, double latitude, double longitude, double elevation)
    {
        setName(name);
        setLatitude(latitude);
        setLongitude(longitude);
        setElevation(elevation);
    }
    //************************************************************************************


    //************************************************************************************
    //************************************************************************************
    //************************************************************************************


    //************************************************************************************
    /**
     * Method to override the toString method inherited from the Object class.  
     * @return String to display the object.
     */
    public String toString()
    {
        if (getElevation() == 0)
        {
            return getName() + ": " + "(" + getLatitude() + ", " + getLongitude() + ")";
        }
        else
        {
            return getName() + ": " + "(" + getLatitude() + ", " + getLongitude() + 
                                   ", " + getElevation() + ")";
        }
    }
    //************************************************************************************
  
    
    
    //************************************************************************************
    /**
     * Method to determine whether the calling City instance contains the name of the city
     * that is greater than the name of the City instance passed in via parameter, 
     * lexicographically.
     * @param obj Instance of City against which the comparison is made.
     * @return True if the name of the calling instance is greater than the name of the 
     * instance passed in.
     */
    public boolean isGreaterThan(City obj)
    {
        return getName().compareToIgnoreCase(obj.getName()) > 0;
    }
    //************************************************************************************
    


    //************************************************************************************
    /**
     * Method to determine whether the calling City instance contains the name of the city
     * that is greater than the name passed in the string as a parameter, lexicographically.
     * @param name Name against which the comparison is made
     * @return True if the name of the calling instance is greater than the value of the 
     * parameter.
     */
    public boolean isGreaterThan(String name)
    {
        return getName().compareToIgnoreCase(name) > 0;
    }
    //************************************************************************************
    

    
    //************************************************************************************
    /**
     * Method to determine whether the calling City instance contains the name of the city
     * that is less than the name of the City instance passed in via parameter, 
     * lexicographically.
     * @param obj Instance of City against which the comparison is made.
     * @return True if the name of the calling instance is less than the name of the 
     * instance passed in.
     */
    public boolean isLessThan(City obj)
    {
        return getName().compareToIgnoreCase(obj.getName()) < 0;
    }
    //************************************************************************************
   
  
    
    //************************************************************************************
    /**
     * Method to determine whether the calling City instance contains the name of the city
     * that is less than the name passed in the string as a parameter, lexicographically.
     * @param name Name against which the comparison is made
     * @return True if the name of the calling instance is less than the value of the 
     * parameter.
     */
    public boolean isLessThan(String name)
    {
        return getName().compareToIgnoreCase(name) < 0;
    }
    //************************************************************************************
    
 

    //************************************************************************************
    /**
     * Method to determine whether the calling City instance contains the name of the city
     * that is equal to the name of the City instance passed in via parameter, 
     * lexicographically.
     * @param obj Instance of City against which the comparison is made.
     * @return True if the name of the calling instance is equal to the name of the 
     * instance passed in.
     */
    public boolean isEqualTo(City obj)
    {
        return getName().compareToIgnoreCase(obj.getName()) == 0;
    }
    //************************************************************************************



    //************************************************************************************
    /**
     * Method to determine whether the calling City instance contains the name of the city
     * that is equal to than the name passed in the string as a parameter, lexicographically.
     * @param name Name against which the comparison is made
     * @return True if the name of the calling instance is equal to than the value of the 
     * parameter.
     */
    public boolean isEqualTo(String name)
    {
        return getName().compareToIgnoreCase(name) == 0;
    }
    //************************************************************************************

   
    
    //************************************************************************************
    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     * 
     * @param lat - lattitude of the starting point
     * @param lon - longitude at the starting point
     * @param el - elevation at the starting point (altitude in meters)
     * 
     * @returns Distance in Meters
     */
    public double distance(double lat, double lon, double el)
    {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat - getLatitude());
        double lonDistance = Math.toRadians(lon - getLongitude());
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(getLatitude())) * Math.cos(Math.toRadians(lat))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height;
       
        height = (getElevation() == 0) ? 0 : getElevation() - el;
    
        distance = Math.pow(distance, 2) + Math.pow(height, 2);
    
        return Math.sqrt(distance);
    }
    //************************************************************************************

   
    
    //************************************************************************************
    /**
     * Method to determine whether it meets the criteria of the traversal search.  In this
     * case the only criterion is that the city is within the specified distance from the
     * point determined by the coordinates entered.  This method does not consider the elevation.
     * @param lat Latitude of the specified of the point.
     * @param lon Longitude of the point
     * @param @dist distance from the point
     */
    public boolean matchCriteria(double lat, double lon, double dist)
    {
        return distance(lat, lon, 0) <= dist;
    }
    //************************************************************************************
}