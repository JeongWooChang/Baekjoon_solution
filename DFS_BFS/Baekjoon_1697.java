package sw;

import java.util.*;

public class Baekjoon_1697 {//숨바꼭질  bfs

	public static int dp[];
	public static int arr[][];
	public static boolean visited[];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int x = s.nextInt();
		int y = s.nextInt();
		dp = new int[100001];
		visited = new boolean[100001];
		
		visited[x] = true;

		System.out.println(bfs(x,y));
		//System.out.println(empty + " " + count);
	}
	public static int bfs(int x,int y) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		int start = x;
		while(!q.isEmpty() && start != y) {
			start = q.poll();
			if(start-1 >= 0 && !visited[start-1]) {
				dp[start-1] = dp[start]+1;
				visited[start-1] = true;
				q.add(start-1);
			}
			if(start+1 <= 100000 && !visited[start+1]) {
				dp[start+1] = dp[start]+1;
				visited[start+1] = true;
				q.add(start+1);
			}
			if(2*start <= 100000 && !visited[2*start]) {
				dp[2*start] = dp[start]+1;
				visited[start*2]= true;
				q.add(2*start);
			}
		}
		return dp[y];	
	}

}
