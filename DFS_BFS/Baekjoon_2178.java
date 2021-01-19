package sw;

import java.util.*;

public class Baekjoon_2178 {//미로탐색  그래프탐색, bfs 

	public static int dp[][];
	public static int arr[][];
	public static boolean visited[][];
	public static int max = 0;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int x = s.nextInt();
		int y = s.nextInt();
		dp = new int[x][y];
		visited = new boolean[x][y];
		
		
		for(int i = 0 ; i < x ; i++) {
			String str = s.next();
			for(int j = 0 ; j < y ; j++) {
				dp[i][j] = (int)str.charAt(j)- 48;
			}
		}
		//System.out.println(dp[0][0]);

		System.out.println(bfs(x-1,y-1));
	}
	public static int bfs(int x,int y) {
		Queue<Integer> nx = new LinkedList<Integer>();
		Queue<Integer> ny = new LinkedList<Integer>();
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		visited[0][0] = true;
		nx.add(0);
		ny.add(0);
		while(!nx.isEmpty()) {
			int fnx = nx.poll();
			int fny = ny.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int a = dx[i]+fnx;
				int b = dy[i]+fny;
				if(a >= 0 && b >= 0 && b < dp[0].length && a < dp.length) {
					if(dp[a][b] == 1 && !visited[a][b]) {
						visited[a][b] = true;
						dp[a][b] += dp[fnx][fny];
						nx.add(a);
						ny.add(b);
					}
				}
			}
		}
		return dp[x][y];
	}

}
