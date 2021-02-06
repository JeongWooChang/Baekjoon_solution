package sw;

import java.util.*;

public class Baekjoon_1759 {

	public static int L;
	public static int C;
	public static char[] arr;
	public static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		
		arr = new char[C];
		visited = new boolean[C];
		for(int i = 0 ; i < C ; i++) {
			String s = sc.next();
			arr[i] = s.charAt(0);
			
		}
		Arrays.sort(arr);
		
		dfs(0,0,0,0);
	}
	
	public static void dfs(int start, int count, int j, int m) {
		if(count == L && j >= 2 && m >= 1) {
			for(int i = 0 ; i < C ; i++)
				if(visited[i]) System.out.print(arr[i]);
			System.out.println();
		}
		for(int i = start ; i < C ; i++) {
			visited[i] = true;
			if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u')
				dfs(i+1,count+1,j, m+1);
			else dfs(i+1,count+1,j+1, m);
			
			visited[i] = false;
		}
		
		
	}
}
