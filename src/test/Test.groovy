package test


class Test {

	static main(args) {
		String s = 'V S N H G F D E I B'
		def items = s.split(' ') as String[]
		int i=1, l=items.size()
		items.each { 
			//printf('%s ', it)
			if((i*2-1)<l && items[i*2-1].compareTo(it)>0)
			{
				printf("Fail: %s<%s!\n", it, items[i*2-1])
			}
			if(i*2<l && items[i*2].compareTo(it)>0)
			{
				printf("Fail: %s<%s!\n", it, items[i*2])
			}
			i++
		}
		println()
	}
}
