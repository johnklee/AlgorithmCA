package graph

import org.jgrapht.graph.DefaultDirectedGraph
import org.jgrapht.graph.DefaultEdge
import org.jgrapht.traverse.BreadthFirstIterator
import org.jgrapht.traverse.DepthFirstIterator
import org.jgrapht.traverse.GraphIterator

class Digraph<V,E> extends DefaultDirectedGraph<V,E>{
		
	def adj(V v){return edgesOf(v).iterator()}
	
	def V() {return vertexSet().size()}
	
	def E() {return edgeSet().size()}
	
	def bfsIter(V sv=null)
	{
		GraphIterator<Integer, DefaultEdge> iterator = null
		if(sv!=null)
		{
			iterator = new BreadthFirstIterator<Integer, DefaultEdge>(this, sv);
		}
		else
		{
			iterator = new BreadthFirstIterator<Integer, DefaultEdge>(this);
		}
		return iterator
	}
	
	def dfsIter(V sv=null)
	{
		GraphIterator<Integer, DefaultEdge> iterator = null
		if(sv!=null)
		{
			iterator = new DepthFirstIterator<Integer, DefaultEdge>(this, sv);
		}
		else
		{
			iterator = new DepthFirstIterator<Integer, DefaultEdge>(this);
		}
		return iterator
	}
	
	static void main(args)
	{
		Digraph dg = new Digraph()	
		
	}
}
