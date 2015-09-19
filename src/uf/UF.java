package uf;

public interface UF {
	public boolean connected(int p, int q);
	public void union(int p, int q);
}
