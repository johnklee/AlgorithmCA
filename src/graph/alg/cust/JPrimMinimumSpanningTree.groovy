package graph.alg.cust

import org.jgrapht.Graph
import org.jgrapht.alg.interfaces.MinimumSpanningTree

class JPrimMinimumSpanningTree <V, E> implements MinimumSpanningTree<V, E>{

	/**
	 * Minimum Spanning-Tree/Forest edge set
	 */
	private final List<E> minimumSpanningTreeEdgeList;

	/**
	 * Minimum Spanning-Tree/Forest edge set overall weight
	 */
	private final double minimumSpanningTreeTotalWeight;

	public JPrimMinimumSpanningTree(final Graph<V, E> g, V sv = null)
	{
		minimumSpanningTreeEdgeList = new LinkedList<E>()	
		Set<V> unspanned = new HashSet<V>(g.vertexSet())
		Set<V> spanned = new HashSet<V>()
		
		while (!unspanned.isEmpty()) 
		{
			PriorityQueue<E> dangling =
			new PriorityQueue<E>(
				g.edgeSet().size(),
				new Comparator<E>() {
					@Override public int compare(E lop, E rop)
					{
						return Double.valueOf(g.getEdgeWeight(lop))
							.compareTo(g.getEdgeWeight(rop));
					}
				});
			if(sv==null)
			{
				sv = unspanned.iterator().next()
				unspanned.remove(sv)
			}
			spanned.add(sv)
			
			dangling.addAll(g.edgesOf(sv))
			sv = null
			while(dangling.size()>0)
			{
				E edge = dangling.poll()
				V s = edge.getSource(); V t = edge.getTarget()
				boolean hit=false
				if(unspanned.remove(s)) hit=true
				if(unspanned.remove(t)) hit=true				
				if(hit)
				{
					minimumSpanningTreeEdgeList.add(edge)
					minimumSpanningTreeTotalWeight+=edge.getWeight()
					printf("\t[Test] MST Edge=%s\n", edge)
					if(spanned.add(s))
					{
						for(E se:g.edgesOf(s))
						{
							if(!spanned.contains(se.getSource())||!spanned.contains(se.getTarget()))
							{
								dangling.add(se)
								printf("\t\tAdd Edge=%s\n", se)
							}
						}
					}					
					if(spanned.add(t))
					{
						for(E se:g.edgesOf(t))
						{
							if(!spanned.contains(se.getSource())||!spanned.contains(se.getTarget()))
							{
								dangling.add(se)
								printf("\t\tAdd Edge=%s\n", se)
							}
						}
					}										
				}				
			}
		}
	}
	
	public List<E> getMinimumSpanningTreeEdgeList(){return Collections.unmodifiableList(minimumSpanningTreeEdgeList)}
	
	@Override public Set<E> getMinimumSpanningTreeEdgeSet()
    {
		Set<E> set = new HashSet<E>(); set.addAll(minimumSpanningTreeEdgeList)
        return Collections.unmodifiableSet(set);
    }

    @Override public double getMinimumSpanningTreeTotalWeight()
    {
        return minimumSpanningTreeTotalWeight;
    }
}
