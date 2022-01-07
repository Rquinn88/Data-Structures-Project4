public class TreeNode
{
	//variables
	private City m_objData;
	private TreeNode m_objLeft;
	private TreeNode m_objRight;
	
	//gettor for data in node
	public City getData(){
		return m_objData;
	}
	
	//settor for data in node
	public City setData(City data){
		return m_objData = data;
	}
	
	//gettor for node to the left
	public TreeNode getLeft(){
		return m_objLeft;
	}
	
	//settor for node to the left
	public TreeNode setLeft(TreeNode left){
		return m_objLeft = left;
	}
	
	//gettor for node to the right
	public TreeNode getRight(){
		return m_objRight;
	}
	
	//settor for node to the right
	public TreeNode setRight(TreeNode right){
		return m_objRight = right;
	}
	
	
	//initizlizing constructor for the TreeNode
	public TreeNode(City data, TreeNode left, TreeNode right){
		setData(data);
		setLeft(left);
		setRight(right);
	}
}