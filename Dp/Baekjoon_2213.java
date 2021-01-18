package sw;

import java.util.*;

public class Baekjoon_2213 {//트리의 독립집합,dp문

	public static int ans = 1;
	public static int cnt = 1;
	public static int n;
	public static int m;
	public static int num;
	public static int[] arr;
	public static boolean[] visited;
	public static int[][] dp;
	public static ArrayList<Integer> list = new ArrayList<>();
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
		if(dp[1][0] > dp[1][1]) {
			track(1,true,0);
			System.out.println(dp[1][0]);
		}
		else {
			track(1,false,0);
			System.out.println(dp[1][1]);
		}
		Collections.sort(list);
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.print(list.get(i) + " ");
		}
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
	
	public static void track(int node, boolean tf, int parent) {
		if(tf) {
			list.add(node);
			for(int i = 0 ; i < map[node].size() ; i++) {
				if(map[node].get(i) != parent) track(map[node].get(i), false, node);
			}
		}
		else {
			for(int i = 0 ; i < map[node].size() ; i++) {
				if(map[node].get(i) != parent) {
					if(dp[map[node].get(i)][0] > dp[map[node].get(i)][1]) track(map[node].get(i), true, node);
					else track(map[node].get(i), false,node);
				}
			}
		}
	}

}

