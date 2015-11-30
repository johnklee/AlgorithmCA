package graph.alg

import graph.alg.cust.JPrimMinimumSpanningTree

import org.jgrapht.graph.DefaultWeightedEdge
import org.jgrapht.graph.SimpleWeightedGraph

// 0) Initialize Graph  
SimpleWeightedGraph<String, DefaultWeightedEdge> g =  
            new SimpleWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class)
			

// 1) Build Graph																										
g.addVertex("A") 
g.addVertex("B")
g.addVertex("C")
g.addVertex("D")
g.addVertex("E")
g.addVertex("F")

def edges = [:]
edges["A"]=["B": 6, "F":12, "E":10]
edges["B"]=["A": 6, "C": 3, "D": 5, "F": 8]
edges["C"]=["B": 3, "D": 7]
edges["D"]=["B": 5, "C": 7, "E": 9, "F":11]
edges["E"]=["A":10, "D": 9, "F":16]
edges["F"]=["A":12, "B": 8, "D":11, "E":16]

edges.each{ k, v->
	v.each{ n, w->
		DefaultWeightedEdge e = g.addEdge(k, n)
		if(e!=null)
		{			
			g.setEdgeWeight(e, w)
		}
	}
}

printf("\t[Test] Graph:\n%s\n\n", g)

printf("\t[Info] JPrim's MST:\n")
JPrimMinimumSpanningTree pMST = new JPrimMinimumSpanningTree(g, "A")
for(DefaultWeightedEdge e:pMST.getMinimumSpanningTreeEdgeList())
{
	printf("\t%s (%.01f)\n", e, e.getWeight())
}