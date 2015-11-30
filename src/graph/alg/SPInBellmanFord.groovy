package graph.alg

import org.jgrapht.alg.BellmanFordShortestPath
import org.jgrapht.graph.DefaultWeightedEdge
import org.jgrapht.graph.SimpleDirectedWeightedGraph

// 0) Initialize Graph  
SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge> g =  
            new SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge>(DefaultWeightedEdge.class)

// 1) Build Graph
6.times{
	g.addVertex(it)
}

def edges = [:]
edges[0]=[1:8]
edges[1]=[2: 6,4:16]
edges[2]=[3:10,5:15]
edges[4]=[0:12]
edges[5]=[1:12,4:14,3:20]

edges.each{ k, v->
	v.each{ n, w->
		DefaultWeightedEdge e = g.addEdge(k, n)
		if(e!=null)
		{
			g.setEdgeWeight(e, w)
		}
	}
}

printf("\t[Info] Graph:\n%s\n", g)

// 2) Algorithm
printf("\t[Info] Running Bellman-Ford Shortest Path:\n")
BellmanFordShortestPath bfSP = new BellmanFordShortestPath(g, 0)
(1..5).each { d->
	printf("\t0->%d (%.01f):\t", d, bfSP.getCost(d))
	for(DefaultWeightedEdge e:bfSP.getPathEdgeList(d)) printf("%s ", e)
	println()
}