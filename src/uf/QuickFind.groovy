package uf

class QuickFind implements UF{
	int N=-1
	def id=[]
	
	QuickFind(int n)
	{
		N=n;
		n.times{ i->
			id.add(i)
		}
	}
		
	@Override
	public boolean connected(int p, int q) {
		return id[p]==id[q]
	}

	@Override
	public void union(int p, int q) {
		int pid = id[p]
		int qid = id[q]
		N.times{ i->
			if(id[i]==pid) id[i]=qid
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
	
	@Override
	public String toString()
	{
		StringBuffer strBuf = new StringBuffer()
		id.each{e->strBuf.append(String.format("%s ", e))}
		return strBuf.toString().trim()	
	}
	
	static void main(args)
	{
		QuickFind qf = new QuickFind(10)
		// 3-0 5-7 9-2 2-3 7-9 4-3
		qf.union("3-0 1-9 3-8 9-0 6-2 9-6")
		printf("%s", qf)
	}
}
