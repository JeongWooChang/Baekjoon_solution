package sw;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon_1520 {//내리막길, dp문

public static int ans = 1;
public static int cnt = 1;
public static int n;
public static int m;
public static int num;
public static int[][] arr;
public static boolean[] visited;
public static int[][] dp;
public static ArrayList<Integer> score = new ArrayList<>();
public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
	
	    m = s.nextInt();
	    n = s.nextInt();
		arr = new int[m][n];
		dp = new int[m][n];
		
		
		for(int i = 0 ; i < m ;i++) {
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = s.nextInt();
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(m-1,n-1));
		for(int a = 0 ; a < m ; a++) {
			for(int b = 0 ;b < n ; b++) {
				System.out.print(dp[a][b]+" ");
			}
			System.out.println();
		}
		
		
		
		//System.out.println(dfs(m-1,n-1));
		

	}

public static int dfs(int x, int y) {
	if(x==0&&y==0) return 1;

	int[] dx = {0,0,1,-1};
	int[] dy = {1,-1,0,0};
	if(dp[x][y]==-1) {
		dp[x][y] = 0;
		for(int i = 0 ; i < 4 ; i++) {
			int a = x + dx[i];
			int b = y + dy[i];
			if(a >= 0 && a < m && b >= 0 && b < n) {
				if(arr[x][y] < arr[a][b]) {
					dp[x][y] += dfs(a,b);
				}
			}
		}
	}
	
	return dp[x][y];
}

}
