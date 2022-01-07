//***
//*** This class creates a Binary Search Tree for "CityDb". The tree has the return methods: getRoot(), setRoot(), getNodeCount(), 
//*** clearNodeCount(), incNodeCount(), dncNodeCount(), and isEmpty(). It also uses insert() to insert individual nodes, find() to
//*** search the inserted nodes and find a particular one, and listDist() which lists the latitude and longitude and distance from
//*** the given city enters
//***
public class BSTtree
{
	//**
	//**Declaration of TreeNode Root, and the Node Count variables
	//**
	private TreeNode m_objRoot;
	private int m_iNodeCount;
	
	//Gettor for Root 
	protected TreeNode getRoot(){
		return m_objRoot;
	}
	
	//Settor for Root
	protected TreeNode setRoot(TreeNode root){
		return m_objRoot = root;
	}
	
	//Gettor for node count
	public int getNodeCount(){
		return m_iNodeCount;
	}
	
	//Set node count to 0
	protected int clearNodeCount(){
		return m_iNodeCount = 0;
	}
	
	//Increment node count
	protected int incNodeCount(){
		return m_iNodeCount ++;
	}
	
	//Decrement node count
	protected int dncNodeCount(){
		return m_iNodeCount --;
	}
	
	//If the root is null, the list isEmpty()
	public boolean isEmpty() {
		return getRoot() == null;
	}
	
	//Creates a BS Tree with Root set to null and node count set to 0
	public BSTtree(){
		setRoot(null);
		clearNodeCount();
	}
	
	//**
	//** Inserts a node with the City data as the parameter
	//**
	public void insert(City data){
		
		TreeNode node = new TreeNode(data, null, null); //Make a new node with the given City data and null values to the right and left 
		incNodeCount(); // Increment node count
		
		if(isEmpty()){ // If the tree is empty (root is equal to null)
			setRoot(node); // Set the root to null
		}
		
		else{ //If the tree is not empty
			
			insert(getRoot(), node); // Insert node where getRoot() is current
		}
	}
	
	//**
	//** Inserts a node with the current node and the new node as parameters 
	//**
	protected void insert(TreeNode current, TreeNode newNode){
		
		City curData =  current.getData(); //Create a City object with the current TreeNode data in it
	    City newData = newNode.getData(); // Create a City object with the newNode TreeNode data in it
		
		if(current.getData().isGreaterThan(newNode.getData())){ // If the lat and lon of the current TreeNode is greater than that of the new node then move on
			
			if(current.getLeft() == null){ // If the current to the left is null
				current.setLeft(newNode); // Set the node to the left of the current to the new node
			}
			
			else{ // Otherwise
				insert(current.getLeft(), newNode); // Make the node to the left of the current current and insert newNode
			}
		}
			
		else{ //If the original if is not true then move on here
			
			if(current.getRight() == null){ //If the node to the right of the current is null
			
				current.setRight(newNode); // Set the node to the right of the current to the new TreeNode
			}
			
			else{ //Otherwise
				insert(current.getRight(), newNode); // Make the node to the right of the current current and insert newNode
			}
			
		}
			}
			
	//**
	//** Finds a node with a particular name
	//**
	public City find(String name){
		
		return find(getRoot(), name); // Returns the root and name 
		
	}
	
	//**
	//** Finds a node with parameters of the current node and the name of city
	//**
	protected City find(TreeNode current, String name){
		
		if(current == null){ //If the current node is null
			
			return null; //City not found, null returned 
		}
		
		if(current.getData().isEqualTo(name)){ //Ff the name of the node (String) that is entered is found
			
			return current.getData(); // Return the data associated with that name
		}
		
		City retObj = find(current.getLeft(), name); //New object in city class that finds the data to the left of the current and the name
		
		if(retObj == null){ //If the new object listed above is null
			
			return find(current.getRight(), name); // Return the one to the right instead
		}
		
		return retObj; //If all if statments fail, then just return the new object created 
	}
	
	//**
	//** Listing the Root, latitude and longitude and distance the user wants 
	//**
	public void listDist(double lat, double lon, double dist){
		
		listDist(getRoot(), lat, lon, dist);
	}
		
	//**
	//** Lists the distance of the current node with latitude and longitude values 
	//**	
	protected void listDist(TreeNode current, double lat, double lon, double dist){
		
		if(current.getLeft() != null){ //If the node to the left is not null
			
			listDist(current.getLeft(), lat, lon, dist); //list the node on the left with its coordinates and distance from the current node
		}
		
		if(current.getData().matchCriteria(lat, lon, dist)){ //if the criteria is matched for the current data (lat, lon, dist)
			
			System.out.printf("%50s - %f km\n", current.getData(), current.getData().distance(lat, lon, 0) / 10000); // Print the current node and the distance in KM
		}
		
		if(current.getRight() != null){ //If the node to the right is not null
			
			listDist(current.getRight(), lat, lon, dist); //list the node on the right with its coordinates and distance from the current node
		}
			
		
	}
	
}