import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private int current;
	private int[][] board;
	private boolean[][] isBlocked;
	private WeightedQuickUnionUF uf;
	
	public Percolation(int n){
		board = new int[n][n];
		isBlocked = new boolean[n][n];
		uf = new WeightedQuickUnionUF(n*n);
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				isBlocked[i][j] = true;
			}
		}
	}
	public void open(int row, int col){
		current = board[row][col];
	}
	
	public boolean isOpen(int row, int col){
		return !isBlocked[row][col];
	}
	
	public boolean isFull(int row, int col){
		return isBlocked[row][col];
	}
	
	public int numberOfOpenSites(){
		int cnt = 0;
		for(int i = 0; i < this.isBlocked.length; i++){
			for(int j = 0; j < this.isBlocked[i].length; j++){
				if(!isBlocked[i][j]) { cnt++; }
			}
		}
		return cnt;
	}
	
	public boolean percolates(){
		return true;
	}
	
	public static void main(String[] args){
		Percolation p = new Percolation(10);
		StdOut.println(p.percolates());
	}
}
