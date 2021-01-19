package sw;

import java.util.Scanner;

public class Baekjoon_1987 {//알파벳  그래프탐색, dfs, backtracking 

	public static int dp[][];
	public static int arr[][];
	public static boolean visited[];
	public static int max = 0;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int x = s.nextInt();
		int y = s.nextInt();
		
		//arr = new int[x][y];
		dp = new int[x][y];
		visited = new boolean[26];
		for(int i = 0 ; i < x ; i++) {
			String str = s.next();
			for(int j = 0 ; j < str.length() ; j++) {
				dp[i][j] = (int)str.charAt(j) - 'A';
			}
		}
		//System.out.println(dp[0][0]);
		visited[dp[0][0]] = true;
		dfs(0,0,1);
		System.out.println(max);
	}
	public static void dfs(int x,int y, int count) {
		max = Math.max(count, max);
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		for(int i = 0 ; i < 4 ; i++) {
			int a = dx[i]+x;
			int b = dy[i]+y;
			if(a >= 0 && b >= 0 && b < dp[0].length && a < dp.length) {
				if(!visited[dp[a][b]]) {
				   visited[dp[a][b]] = true;
				   dfs(a,b,count+1);
				   visited[dp[a][b]] = false;
				}
			}
		}
	}

}