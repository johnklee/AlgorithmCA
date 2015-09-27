package ds

abstract class AbstST<K extends Comparable,V> implements ST<K,V>{
	@Override
	public V get(K k)
	{
		return null
	}
	
	@Override
	public boolean contains(K k)
	{
		return get(k)!=null
	}
}
