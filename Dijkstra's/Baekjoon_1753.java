package sw;

import java.util.*;

class Node implements Comparable<Node>{
	int end, weight;
	
	public Node(int e, int w) {
		this.end =e;
		this.weight=w;
	}
	@Override
	public int compareTo(Node t) {
		return weight - t.weight;
	}
}
public class Baekjoon_1753 {//**** 최단경로  다익스트라(dp)  ,인접리스트, 구조체, 우선순위큐  (난이도 상)


	public static int dist[];
	public static boolean visited[];
	public static int INF = 100000;
	public static int start;
	public static ArrayList<Node>[] list;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int x = s.nextInt();
		int n = s.nextInt();
		start = s.nextInt();
		
		dist = new int[x+1];
		visited = new boolean[x+1];
		list = new ArrayList[x+1];
		
		Arrays.fill(dist, INF);
		
		for(int i = 1 ; i <= x ; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < n ; i++) {
			int f = s.nextInt();
			int e = s.nextInt();
			int w = s.nextInt();
			list[f].add(new Node(e,w));
		}
		dij();
		
		for(int i = 1 ; i <= x ; i++) {
			if(dist[i] == INF) System.out.println("INF");
			else System.out.println(dist[i]);
		}
		//System.out.println(empty + " " + count);
	}
	public static void dij() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start,0));
		dist[start] = 0;
		while(!q.isEmpty()) {
			Node fir = q.poll();
			int n = fir.end;
			if(!visited[n]) {
				visited[n] = true;
				for(Node node : list[n]) {
					if(dist[node.end] > dist[n] + node.weight) {
						dist[node.end] = dist[n] + node.weight;
						q.add(new Node(node.end, dist[node.end]));
					}
				}
			}
			
		}
		
	}
}
