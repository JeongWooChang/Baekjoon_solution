package sw;

import java.util.*;

public class Baekjoon_1949 {//우수마을, dp문

	public static int ans = 1;
	public static int cnt = 1;
	public static int n;
	public static int m;
	public static int num;
	public static int[] arr;
	public static boolean[] visited;
	public static int[][] dp;
	public static ArrayList<Integer>[] map;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		
		m = s.nextInt();
		dp = new int[m+1][2];
		visited = new boolean[m+1];
		map = new ArrayList[m+1];
		arr = new int[m+1];
		
		for(int i = 1 ; i <= m ;i++) {
			arr[i] = s.nextInt();
			map[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < m-1 ; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			map[a].add(b);
			map[b].add(a);
		}
		
		visited[1]=true;
		dfs(1);
			
			
		System.out.println(Math.max(dp[1][0], dp[1][1]));
		//System.out.println(dp[2][0] + " " + dp[2][1]);
	

    }

	public static void dfs(int x) {
		dp[x][0] += arr[x];
		for(int i = 0 ; i < map[x].size() ; i++) {
			int node = map[x].get(i);
			if(!visited[node]) {
				visited[node] = true;
				
				dfs(node);
				
				dp[x][0] += dp[node][1];
				dp[x][1] += Math.max(dp[node][0], dp[node][1]);
			}
 		}
	}

}

