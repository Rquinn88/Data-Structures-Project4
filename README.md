# Data-Structures-Project4

This project implements a city database using a Binary Search Tree (BST) to store database records. Each database
record contains the name of the city (a string of arbitrary length) and the coordinates of the city expressed
as a doubles (longitude and latitude).

The BST is organized by city name and performs the following operations:

• Insert records
  This is done when reading the data file and building the tree. The records are ordered
  lexicographically by the name of the city.
• Search by name
  The user is prompted for the name of the city to find. If the city is found its coordinates are
  displayed. If the city is not found, an error message is displayed.
• Display the size of the tree
  Once the program is loaded, the number of nodes in the tree is displayed.
• Print all records within a given distance
  The user is prompted for the coordinates of the point. The numbers are in decimal
  degrees format and range from -90 to 90 for latitude and -180 to 180 for longitude.
  All cities within a distance given by the user are printed to the screen
