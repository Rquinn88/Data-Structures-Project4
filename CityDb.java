import java.util.*;
import java.io.*;
import java.util.Scanner;


public class CityDb
{
    /**
    /* Main method of the City database program.
	/* CityDb implements the binary search tree and allows the user to find a particular city from the inserted list. The longitude and latitude are displayed if the first option   /* is chosen by the user. If the second option is chosen, the user will enter cooridinates for a city and a distance. Cities within that distance from the cooridinates entered /* are then displayed.
    /* @param command line arguments (not used in this program)
     */
    public static void main(String[] args)
    {
        //************************************************************************************
        //*** Declaration of variables used by main().                                     ***
        //************************************************************************************
        Scanner input  = new Scanner(System.in);        // Scanner object for interaction with user`

        String sCityName;                               // Name of the city for searches and reading
        double lat, lon, dist;                          // Latitude, longitude, and distance for a point

        BSTtree theTree = new BSTtree();                  // Instance of the tree where cities are stored

        char cOption;                                   // Menu selection 
        City oCityRef;                                  // Reference to the city object

        //***
        //*** Attempt to load a tree.  The name of the data file is hardcoded. Comma is used
        //*** as a delimiter.
        //***
        if (! loadTree(theTree, "cities.csv", ","))
        {
            //***
            //*** Load has failed, program is terminating
            //***
            System.out.println("*** Tree was not loaded, program won't continue.\n");
            return;
        }

        //***
        //*** Start the main loop of the program
        do
        {
           //***
           //*** Display a menu
           //***
           System.out.println("\n=======================================================");
           System.out.println("   1. Find a city");
           System.out.println("   2. Display distance");
           System.out.println();
           System.out.println("   3. Quit");
           System.out.println("=======================================================");
           System.out.print("Choose an option: ==>> ");

           //***
           //*** Read menu choice.  If user types nothing, treat it as an invalid choice.
           //***
           String sInput = input.nextLine().trim();
           if (sInput.length() > 0)
           {
              cOption = sInput.charAt(0);
           }
           else
           {
              cOption = 'B';
           }

           
           //***
           //*** Determine what to do, based on user's choice.
           //***
           switch (cOption)
           {
                   //***
                   //*** Search for city by name
                   //*** 
                   case '1':    //***
                                //*** Prompt the user
                                //***
                                System.out.print("\nName of the city:   -->>  ");
                                sCityName = input.nextLine().trim().toUpperCase();
                                if (sCityName.length() == 0)
                                {
                                    //***
                                    //*** Making sure the user entered something
                                    //***
                                    System.out.println("\n\n*** City name is not provided.  \n\n");
                                }
                                else 
                                {
                                    //***
                                    //*** Searching the tree using the name provided
                                    //***
                                    oCityRef = theTree.find(sCityName);   
                                    if (oCityRef == null)
                                    {
                                        //***
                                        //*** Not found
                                        //***
                                        System.out.printf("\n\n*** City %s is not found.  \n\n\n", sCityName);
                                    }
                                    else
                                    {
                                        //***
                                        //*** City is found - display it
                                        //***
                                        System.out.printf("\n%s\n\n\n", oCityRef);
                                    }
                                }
                                break;
                   //***
                   //*** Finding all cities wihin a specified distance
                   //***
                   case '2':    //***
                                //*** Prompt the user for latitude, longitude, and distance
                                //***
                                System.out.print("\nLatitude:           -->>  ");
                                lat = input.nextDouble();

                                System.out.print("\nLongitude:          -->>  ");
                                lon = input.nextDouble();

                                System.out.print("\nDistance Limit:     -->>  ");
                                dist = input.nextDouble();
                                input.nextLine();

                                //***
                                //*** Treverse the tree displaying all cities that match criteria
                                //***
                                theTree.listDist(lat, lon, dist);
                                System.out.println("\n");
                                break;
                   //***
                   //*** Exiting the program
                   //***
                   case '3':    System.out.println("\n\nThank you for using our database!!!\n\n");
                                break;

                   //***
                   //*** Ignore the blank <ENTER> menu choice.
                   //***
                   case 'B':    System.out.println("\n\n");
                                break;
                   //***
                   //*** Error of invalid meny choice
                   //***
                   default:     System.out.printf("\n\n*** Option '%c' is not a valid option.  \n\n\n", cOption);
           }
        } while (cOption != '3');

    }


    /**
     * Method to load a tree from the .csv file
     * @param tree Reference to the tree being loaded
     * @param sFileName Name of the file from which the tree is loaded.
     * @param sDelimiter Delimiter within a record.
     * @return True if succesful; False if failed.
     */
    public static boolean loadTree(BSTtree tree, String sFileName, String sDelimiter)
    {
        int retCode = 0;                            //***Code returned by read
        String[] retArr = new String[3];            //***Return array (pass by reference)
                                                    //    Shold be the size of record in fields. (3 in this case)
        double longitude;
        double latitude;
        String city;

        try {
            //***
            //*** Create a new DelimReader using the file to be read and delimiter
            //***
            DelimReader dr = new DelimReader(sFileName, sDelimiter);

            //***
            //** Try reading the first record.  The record is placed into retArr
            retCode = dr.readRecord(retArr);
            while (retCode != DelimReader.EOF)
            {
                 try 
                 {
                     //***
                     //*** Succesfully read - extract latitude, longitude, and city
                     //***
                     latitude = Double.parseDouble(retArr[0]);               // Pull out latitude
                     longitude = Double.parseDouble(retArr[1]);              // Pull out longitude
                     city = retArr[2];
                     City newCity = new City(city, latitude, longitude, 0);
                     System.out.printf("%10.4f    %10.4f    %s\n", latitude, longitude, city);
                     tree.insert(newCity);
                 }
                 catch (NumberFormatException ne)
                 {
                     System.out.println("**** BAD DATA READ");
                 }
                 //***
                 //*** Read the next record
                 //***
                 retCode = dr.readRecord(retArr);
            }
        }
		//***
		//*** Catch exception if file isn't found
		//***
        catch (FileNotFoundException e)
        {
            System.out.println("**** CAN'T OPEN FILE FORE READ");
            return false;
        }

       // System.out.printf("%d nodes inserted!\n", tree.getNodeCount()); Line to print all Cities in CSV file 
        return true;
    } 
}