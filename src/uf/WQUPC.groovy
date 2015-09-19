package uf

class WQUPC extends WQuickUnion{

	WQUPC(int n){super(n)}
	
	protected int root(int i)
	{
		while(id[i]!=i) 
		{
			id[i]=id[id[i]]// Path compression
			i = id[i]
		}
		return i;
	}
}
