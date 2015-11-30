package ds

public class BST<K extends Comparable<K>, V> {
	Node root
	boolean debug=false
	
	private class Node
	{
		K 		key = null
		V 		value = null
		Node 	left = null
		Node 	right = null
		int		count=0
	}
	
	public void put(K k, V v){root = put(root, k, v)}
	
	protected Node put(Node x, K k, V v)
	{
		// Number of compares is equal to 1 + depth of node.
		if(x==null) return new Node(key:k, value:v, count:1)
		int c = k.compareTo(x.key)
		if(c<0) x.left = put(x.left, k, v)
		else if(c>0) x.right = put(x.right, k, v)
		else x.value = v
		x.count = 1 + size(x.left)+size(x.right)
		return x
		
	}
	public V get(K k)
	{
		// Number of compares is equal to 1 + depth of node.
		Node x = root
		while(x!=null)
		{
			if(debug) printf("Comparing key='%s'...\n", x.key)
			int c = k.compareTo(x.key)
			if(c<0) x = x.left
			else if(c>0) x = x.right
			else return x.value
		}
		return null
	}
	public V delete(K k)
	{
		return delete(root, k)
	}
	
	public Node delete(Node x, K k)
	{
		if(x==null) return null
		int c = k.compareTo(x.key)
		if(c>0) x.right = delete(x.right, k)
		else if(c<0) x.left = delete(x.left, k)
		else
		{
			if(x.right==null) return x.left
			if(x.left==null) return x.right
			
			// Both x.right & x.left are not null
			Node t = x
			x = min(t.right)
			x.right = deleteMin(t.right)
			x.left = t.left
		}
		x.count = 1+size(x.left)+size(x.right)
		return x
	}
	
	public void deleteMin()
	{
		root=deleteMin(root)
	}
	public Node deleteMin(Node x)
	{
		if(x.left==null) return x.right
		x.left = deleteMin(x.left)
		x.count = 1+size(x.left)+size(x.right)
		return x	
	}
	
	public Node min(Node x)
	{
		if(x.left==null) return x
		return min(x.left)
	}
	
	public Node max(Node x)
	{
		if(x.right==null) return x
		return max(x.right)
	}
	
	public K ceiling(K k)
	{
		Node x = ceiling(root, k)
		return (x!=null)?x.key:null
	}
	
	public Node ceiling(Node x, K key)
	{
		if(x==null) return null
		int c = key.compareTo(x.key)
		
		if(c==0) return x
		if(c>0) return ceiling(x.right, key)
		
		Node t = ceiling(x.left, key)
		return (t!=null)?t:x
	}
	
	public K floor(K k)
	{
		Node x = floor(root, k)
		return (x!=null)?x.key:null
	}
	
	public Node floor(Node x, K key)
	{
		if(x==null) return null
		int c = key.compareTo(x.key)
		
		if(c==0) return x
		if(c<0) return floor(x.left, key)
		
		Node t = floor(x.right, key)
		return (t!=null)?t:x
	}
	
	public Iterable<K> itrator()
	{
		Queue<K> queue = new LinkedList<K>()
		inorder(root, queue)
		return queue	
	}
	
	public int size(){return size(root)}
	public int size(Node x){ return (x==null)?0:x.count}
	
	/**
	 * How many keys < k ?
	 * @param k
	 * @return
	 */
	public int rank(K k){return rank(root, k)}
	public int rank(Node x, K key)
	{
		if(x==null) return 0
		int c = key.compareTo(x.key)
		if(c>0) return 1+rank(x.right)+rank(x.left)
		else if(c<0) return rank(x.left)
		else return rank(x.left)
	}
	
	private void inorder(Node x, Queue<K> queue)
	{
		// Property. Inorder traversal of a BST yields keys in ascending order.
		if(x==null) return null
		inorder(x.left, queue)
		queue.add(x.key)
		inorder(x.right, queue)
	}
	
	private void levelOrder(Queue<Node> queue){levelOrder(root, queue)}
	private void levelOrder(Node x, Queue<Node> queue)
	{
		Queue<Node> iQueue = new LinkedList<Node>(); iQueue.add(root)
		while(!iQueue.isEmpty())
		{
			Node n = iQueue.poll()
			queue.add(n.key)
			if(n.left!=null) iQueue.add(n.left)
			if(n.right!=null) iQueue.add(n.right)
		}
	}
	
	
	static void main(args)
	{
		
	}
}
