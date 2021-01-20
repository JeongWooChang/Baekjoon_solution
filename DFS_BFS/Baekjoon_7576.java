package sw;

import java.util.*;

public class Baekjoon_7576 {//토마토 bfs

	public static int dp[][];
	public static int arr[][];
	public static Queue<Integer> nx = new LinkedList<Integer>();
	public static Queue<Integer> ny = new LinkedList<Integer>();
	public static int empty = 0;
	public static int count = 0;
	public static boolean visited[][];
	public static int tomato = 0;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int x = s.nextInt();
		int y = s.nextInt();
		dp = new int[y][x];
		visited = new boolean[y][x];
		
		
		for(int i = 0 ; i < y ; i++) {
			for(int j = 0 ; j < x ; j++) {
				dp[i][j] = s.nextInt();
				if(dp[i][j] == 1) {
					nx.add(i);
					ny.add(j);
					count++;
				}
				if(dp[i][j] == -1) {
					empty++;
					visited[i][j] = true;
				}
			}
		}

		System.out.println(bfs(x,y));
		//System.out.println(empty + " " + count);
	}
	public static int bfs(int x,int y) {
		if(nx.isEmpty()) return -1;
		if(x*y == count+empty) return 0;
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		int day = 0;
		
		while(!nx.isEmpty()) {
			int fnx = nx.poll();
			int fny = ny.poll();
			visited[fnx][fny] = true;
			
			for(int i = 0 ; i < 4 ; i++) {
				int a = dx[i]+fnx;
				int b = dy[i]+fny;
				if(a >= 0 && b >= 0 && b < dp[0].length && a < dp.length) {
					if(dp[a][b] == 0 && !visited[a][b]) {
						dp[a][b] = dp[fnx][fny]+1;
						visited[a][b] = true;
						nx.add(a);
						ny.add(b);
						day = Math.max(dp[a][b], day);
						count++;
					}
				}
			}
		}
		if(x*y-empty == count) return day-1;
		else return -1;
		
	}

}
