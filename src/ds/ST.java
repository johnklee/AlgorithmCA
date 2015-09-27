package ds;

public interface ST<K extends Comparable<K>,V> {
	public void put(K k, V v);
	public V get(K k);
	public V delete(K k);
	public boolean contains(K k);
	public boolean isEmpty();
	public int size();
	public Iterable<K> keys();
}
