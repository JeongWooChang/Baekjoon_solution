package sw;

import java.util.*;

public class Baekjoon_9663 {

	public static int N;
	public static int count;
	
	public static void main(String[] args) {//Nqueen 다시풀기  
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		count = 0;
		
		for(int i = 1 ; i <= N ; i++) {
			int[] col = new int[N+1];
			
			col[1]= i;
			dfs(col, 1);
		}
		System.out.println(count);

	}
	public static void dfs(int[] col, int row) {
		if(row == N) count++;
		else {
			int nextrow = row+1;
			for(int i = 1 ; i <= N ; i++) {
				col[nextrow] = i;
				if(possible(col, nextrow))
					dfs(col, nextrow);
			}
		}
		
	}
	public static boolean possible(int[] col, int row) {
		for(int i = 1 ; i < row ; i++) {
			if(col[i] == col[row]) return false;
			if(Math.abs(i-row) == Math.abs(col[i]-col[row])) return false;
		}
		return true;
	}

}
