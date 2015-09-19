package uf

class WQuickUnion extends QuickUnion{
	def sz=[]
	
	WQuickUnion(int n)
	{
		super(n)		
		this.N.times{ i->
			sz.add(1)
		}
	}
	
	@Override
	public void union(int p, int q) 
	{
		int rp = root(p)
		int rq = root(q)
		if(rp!=rq)
		{
			if(sz[rp]>=sz[rq])
			{
				// Point smaller tree to larger tree
				id[rq]=rp
				sz[rp]+=sz[rq]
			}
			else
			{
				id[rp]=rq
				sz[rq]+=sz[rp]
			}
		}
	}
	
	public void union(String us)
	{
		for(def pair:us.split(" "))
		{
			def items = pair.split("-")
			union(Integer.valueOf(items[0]), Integer.valueOf(items[1]))
		}
	}
	
	public void refineID(String ids)
	{
		this.id = []
		for(def i:ids.split(" ")) id.add(Integer.valueOf(i))
	}
	
	public String pathLens()
	{
		def p = []
		N.times{ i->
			int len=0
			printf("%d", i)
			while(i!=id[i])
			{				
				len++
				i = id[i]
				printf("->%d", i)
				if(len>10) break
			}
			println()
			p.add(len)
		}
		return p
	}
	
	@Override
	public String toString()
	{
		StringBuffer strBuf = new StringBuffer()
		id.each{e->strBuf.append(String.format("%s ", e))}
		return strBuf.toString().trim()
	}
	
	static void main(args)
	{
		// 0-4 6-7 6-1 9-2 8-5 0-7 5-2 0-9 5-3 
		WQuickUnion qf = new WQuickUnion(10)
		//qf.union("6-1 3-1 4-8 5-7 7-4 0-1 3-9 9-2 1-5")
		qf.refineID("0 0 4 2 0 1 0 0 0 4")
		printf("%s\n", qf)
		printf("%s\n", qf.pathLens())
	}
}
