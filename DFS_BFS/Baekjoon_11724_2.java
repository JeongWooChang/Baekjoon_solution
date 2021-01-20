package sw;

import java.util.*;

public class Baekjoon_11724_2 {//연결요소의 개수 bfs
	
	public static int dp[][];
	public static boolean visited[];
	public static ArrayList<Integer>[] arr;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int x = s.nextInt();
		int y = s.nextInt();
		int count = 0;
		arr = new ArrayList[x+1];
		visited = new boolean[x+1];
		
		
		for(int i = 1 ; i <= x ; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < y ; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			arr[a].add(b);
			arr[b].add(a);
		}
		int first = 1;
		for(int i = first ; i <= x ;i++) {
			if(!visited[i]) {
				bfs(i);
				count++;
				first = 1;
			}
		}
		System.out.println(count);
	}
	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n] = true;
		while(!q.isEmpty()) {
			int p = q.poll();
			for(int i = 0 ; i < arr[p].size() ; i++) {
				if(!visited[arr[p].get(i)]) {
					visited[arr[p].get(i)] = true;
					q.add(arr[p].get(i));
				}
			}
		}
	}
}

