package sw;
import java.util.*;

class Node implements Comparable<Node>{
	int end, weight;
	public Node(int e, int w) {
		this.end = e;
		this.weight = w;
	}
	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}
public class Baekjoon_1916 {//최소비용 구하기  , 우선순위 큐 사용  

	public static ArrayList<Node>[] nodel;
	public static int[] dist;
	public static int INF = 1000000000;
	public static boolean[]  visited;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int m = s.nextInt();
		nodel = new ArrayList[n+1];
		dist = new int[n+1];
		visited = new boolean[n+1];
		
		Arrays.fill(dist, INF);
		
		for(int i = 1; i <= n ; i++)
			nodel[i] = new ArrayList<>();
		
		for(int i = 0 ; i < m ; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			int w = s.nextInt();
			nodel[a].add(new Node(b,w));
		}
		int start = s.nextInt();
		int e = s.nextInt();
		
		dij(start, e);
		System.out.println(dist[e]);

	}
	public static void dij(int start, int e) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		dist[start] = 0;
		q.add(new Node(start, dist[start]));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(!visited[node.end]) {
				visited[node.end] = true;
				for(int i = 0 ; i < nodel[node.end].size() ; i++) {
					Node enode = nodel[node.end].get(i);
					if(dist[enode.end] > dist[node.end]+enode.weight) {
						dist[enode.end] = dist[node.end]+enode.weight;
						q.add(new Node(enode.end, dist[enode.end]));
					}
				}
			}
		}
	}

}
