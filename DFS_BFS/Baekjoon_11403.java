package sw;

import java.util.*;

public class Baekjoon_11403 {//경로찾기  bfs


	public static int arr[][];
	public static ArrayList<Integer>[] list;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int x = s.nextInt();
		//int y = s.nextInt();
		arr = new int[x][x];
		list = new ArrayList[x];
		
		for(int i = 0 ; i < x ; i++) {
			list[i] = new ArrayList<>();
			for(int j = 0 ; j < x ; j++) {
				arr[i][j] = s.nextInt();
				if(arr[i][j] == 1) list[i].add(j);
			}
		}
		bfs(x);
		
		for(int i = 0 ; i < x ; i++) {
			for(int j = 0 ; j < x ; j++) {
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}

		
		
		//System.out.println(empty + " " + count);
	}
	public static void bfs(int x) {
		for(int j = 0 ; j < x ; j++) {
			Queue<Integer> q = new LinkedList<>();
			boolean v[] = new boolean[x];
			q.add(j);
			while(!q.isEmpty()) {
				int n = q.poll();
				if(!v[n]) {
					for(int i =0 ; i < list[n].size() ;i++) {
						arr[j][list[n].get(i)] = 1;
						q.add(list[n].get(i));
						
					}
				}
				v[n] = true;
			}
		}
	}
}
