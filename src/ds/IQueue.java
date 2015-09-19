package ds;

public interface IQueue<E> extends Iterable<E>{
	public void enqueue(E e);
	public E dequeue();
	public boolean isEmpty();
	public int size();
}
