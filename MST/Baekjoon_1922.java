package sw;

import java.util.*;


class Node implements Comparable<Node>{//두 노드와 가중치를 저장  
	int B,Dist;
	
	public Node(int b, int d) {
		this.B = b;
		this.Dist =  d;
	}
	@Override
	public int compareTo(Node o) {
		return this.Dist - o.Dist;
	}
}


public class Baekjoon_1922 {//네트워크 연결    mst, 프림  
	
	public static ArrayList<Node>[] nodel;
	public static int dist[];
	public static boolean visited[];
	public static int INF = 1000000000;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int sum = 0;
		int count = 0;
		nodel = new ArrayList[n+1];
		dist = new int[n+1];
		visited = new boolean[n+1];
		
		Arrays.fill(dist, INF);
	
		for(int i = 1 ; i <= n ; i++) 
			nodel[i] = new ArrayList<>();
		
		
		for(int i = 0 ; i < m ; i++) {
			
			int x = s.nextInt();
			int y = s.nextInt();
			int w = s.nextInt();
			nodel[x].add(new Node(y,w));
			nodel[y].add(new Node(x,w));
		}
		
		PriorityQueue<Node> q = new PriorityQueue<Node>();//간선들의 Min 우선순위 정렬  
		dist[1] = 0;
		q.add(new Node(1, dist[1]));

		while(count < n) {
			Node node = q.poll();
			if(!visited[node.B]) {
				visited[node.B] = true;
				sum+=node.Dist;
				count++;
			}
			for(int i = 0 ; i < nodel[node.B].size() ; i++) {//선택된 노드의 거리 최신화  
				Node node2 = nodel[node.B].get(i);
				if(!visited[node2.B] && dist[node2.B] > node2.Dist) {
					dist[node2.B] = node2.Dist;
					q.add(new Node(node2.B, dist[node2.B]));
				}
			}
		}
		System.out.println(sum);
	}
	
}
