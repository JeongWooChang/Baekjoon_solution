package sw;

import java.util.*;

class Node {
	int X,Y,Z;
	int num;
	
	public Node(int x,int y, int z,int n) {
		this.X = x;
		this.Y = y;
		this.Z = z;
		this.num = n;
	}
}
class Edge implements Comparable<Edge>{
	int S,E;
	int Dist;
	public Edge(int s, int e ,int dist) {
		this.S = s;
		this.E = e;
		this.Dist = dist;
	}
	@Override
	public int compareTo(Edge o) {
		return Dist - o.Dist;
	}
}
public class Baekjoon_2887 {//행성 터널  mst, 모든 간선의 가중치 저장시 메모리 초과발생  , 다시풀어보기  

	public static int[] parent;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		parent = new int[n];
		ArrayList<Node> nodel = new ArrayList<>();
		int sum = 0,count = 0;
		
		for(int i = 0 ; i < n ; i++)
			parent[i] = i;
		
		for(int i = 0 ; i < n ;i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			int z = s.nextInt();
			nodel.add(new Node(x,y,z,i));
		}
		
		
		PriorityQueue<Edge> q = new PriorityQueue<>();
		
		Collections.sort(nodel, (o1, o2) -> o1.X - o2.X);
		for(int i = 0 ; i < nodel.size() - 1 ; i++)
			q.add(new Edge(nodel.get(i).num, nodel.get(i+1).num, Math.abs(nodel.get(i).X - nodel.get(i+1).X)));
		
		Collections.sort(nodel, (o1, o2) -> o1.Y - o2.Y);
		for(int i = 0 ; i < nodel.size() - 1 ; i++)
			q.add(new Edge(nodel.get(i).num, nodel.get(i+1).num, Math.abs(nodel.get(i).Y - nodel.get(i+1).Y)));
		
		Collections.sort(nodel, (o1, o2) -> o1.Z - o2.Z);
		for(int i = 0 ; i < nodel.size() - 1 ; i++)
			q.add(new Edge(nodel.get(i).num, nodel.get(i+1).num, Math.abs(nodel.get(i).Z - nodel.get(i+1).Z)));
		
		
		while(!q.isEmpty()) {
			Edge e = q.poll();
			if(find(e.S) != find(e.E)) {
				union(e.S,e.E);
				sum+= e.Dist;
			}
		}
		
		System.out.println(sum);
	}
	public static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	public static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		if(a != b) parent[b] = a;
		
	}

}
