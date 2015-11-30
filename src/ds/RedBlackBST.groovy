package ds

import java.util.Queue;

import ds.BST.Node;

class RedBlackBST<K extends Comparable<K>,V> {
	private static boolean 		RED=true
	private static boolean 		BLACK=false
	private Node<K,V>			root=null
	
	public static class Node<K,V>{
		K 			key
		V 			value
		Node<K,V> 	left=null
		Node<K,V> 	right=null
		Boolean 	color=false
		
		@Override
		public String toString()
		{
			return String.format("(%s,%s,%s)|%s|%s", key, value, color, left, right)
		}
		
		public void b(){color=false}
		public void r(){color=true}
	}
	
	private boolean isRed(Node n){
		if(n==null) return false
		else return n.color
	}
	public void put(K key, V value)
	{
		root=put(root, key, value)		
		root.color=false
	}
	
	public Node put(Node h, K key, V value)
	{
		if(h == null) return new Node(key:key, value:value,color:true)
		int cmp = key.compareTo(h.key)
		if(cmp < 0)			h.left =  put(h.left,  key, value)
		else if(cmp > 0)	h.right = put(h.right, key, value)
		else 				h.value = value
		
		if(isRed(h.right) && !isRed(h.left))		h = rotateLeft(h)
		if(isRed(h.left)  && isRed(h.left.left))	h = rotateRight(h)
		if(isRed(h.left)  && isRed(h.right))		flipColors(h)
		
		return h
	}
	public V get(K k)
	{		
		Node<K,V> node = root		
		while(node!=null)
		{
			int c = k.compareTo(node.key)
			if(c==0) return node.value
			else if(c<0) node = node.left
			else node = node.right
		}
		return null
	}
	private Node rotateLeft(Node h)
	{		
		assert(isRed(h.right))
		Node x = h.right
		h.right = x.left
		x.left = h
		x.color = h.color
		h.r()
		return x
	}
	private Node rotateRight(Node h)
	{		
		assert(isRed(h.left))
		Node x = h.left
		h.left = x.right
		x.right = h
		x.color = h.color
		h.r()
		return x
	}
	private Node flipColors(Node h)
	{		
		assert(!isRed(h))
		assert(isRed(h.left))
		assert(isRed(h.right))
		h.r()
		h.left.b()	
		h.right.b()
	}
	
	public Iterable<Node> itratorNode()
	{
		Queue<Node> queue = new LinkedList<Node>()
		inorder(root, queue)
		return queue
	}
	
	private void inorder(Node x, Queue<Node> queue)
	{
		// Property. Inorder traversal of a BST yields keys in ascending order.
		if(x==null) return null
		inorder(x.left, queue)
		queue.add(x)
		inorder(x.right, queue)
	}
	
	private void levelOrder(Queue<Node> queue){levelOrder(root, queue)}
	private void levelOrder(Node x, Queue<Node> queue)
	{
		Queue<Node> iQueue = new LinkedList<Node>(); iQueue.add(root)
		while(!iQueue.isEmpty())
		{
			Node n = iQueue.poll()
			queue.add(n)
			if(n.left!=null) iQueue.add(n.left)
			if(n.right!=null) iQueue.add(n.right)
		}
	}
}
