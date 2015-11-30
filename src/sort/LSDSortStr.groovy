package sort

import java.util.List;

class LSDSortStr<String> extends SortAlgImp<String> {
	int R = 10
	 
	/**
	 * Return character as Integer of input String at specific position
	 * 
	 * @param val: String value
	 * @param d: Position of character
	 * 
	 * @return character at specific position of input string as integer.
	 */
	int charAt(String val, d)
	{
		if( d >= val.length()) return 0
		else return (int)val[d]
	}
	
	void sort(List<String> list, int s, int e, int mlen)
	{
		int N = list.size()
		def aux = []; N.times{aux[it]=null}
		def count = new int[R+1] as int[]; (R+1).times{count[it]=0}
		mlen.times{ d->
			d = (mlen-d-1)
			// Count frequencies of each letter using key as index.
			for(String str:list) {				
				count[charAt(str, d)+1]++				
			}
			
			// Compute frequency cumulates which specify destinations.
			int p=0
			R.times{ r->				
				count[r+1]+=count[r]				
			}
			
			// Access cumulates using key as index to move items.
			N.times{ n->				
				aux[count[charAt(list[n], d)]++] = list[n]
			}
			
			// Copy back into original array.
			N.times{ n->
				list[n] = aux[n]
			}
			
			// Clean
			(R+1).times{count[it]=0}
		}
	}

	@Override
	public void sort(List<String> list) {
		int mlen=0
		
		// Find the longest length -> mlen
		list.each{if(it.length()>mlen) mlen=it.length()}
		
		// Start sorting from least significant digit
		sort(list, 0, list.size()-1, mlen)	
	}

	static void main(args)
	{
		def data = ["John", "Joseph", "Ken", "Mary", "Peter", "johnson",
					"Tim", "Tom", "Anderson", "Andy", "Bob", "Forry",
					"Carter", "Derek"]
		LSDSortStr lsdSort = new LSDSortStr(R:65536)
		lsdSort.test(data)
	}
}
