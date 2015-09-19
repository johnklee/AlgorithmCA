package uf

class QuickUnion implements UF{
	public int N=-1
	public def id=[]
	
	QuickUnion(int n)
	{
		N=n;
		n.times{ i->
			id.add(i)
		}
	}
	
	protected int root(int i)
	{
		while(id[i]!=i) i = id[i]
		return i;
	}

	@Override
	public boolean connected(int p, int q) {
		return root(p)==root(q)
	}

	@Override
	public void union(int p, int q) {
		int rp = root(p)
		int rq = root(q)
		id[rp] = rq
	}
}
