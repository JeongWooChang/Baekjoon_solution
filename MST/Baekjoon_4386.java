package sw;

import java.util.*;

class Node{
	double X,Y;
	int num;
	
	public Node(double x, double y, int n) {
		this.X = x;
		this.Y = y;
		this.num = n;//노드 번호  
	}
}
class Edge implements Comparable<Edge>{//두 노드와 가중치를 저장  
	Node A,B;
	double Dist;
	
	public Edge(Node a, Node b) {
		this.A = a;
		this.B = b;
		this.Dist =  Math.sqrt(Math.pow(A.X - B.X, 2) + Math.pow(A.Y - B.Y, 2));
	}
	@Override
	public int compareTo(Edge o) {
		if(this.Dist < o.Dist) return -1;
		else if(this.Dist == o.Dist) return 0;
		else return 1;
	}
}


public class Baekjoon_4386 {//별자리 만들기  
	
	public static ArrayList<Node> nodel;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		double sum = 0.0;
		nodel = new ArrayList<Node>();
		int[] parent = new int[n+1];
		
		for(int i = 1 ; i <= n ; i++) {
			double x = s.nextDouble();
			double y = s.nextDouble();
			nodel.add(new Node(x,y,i));
			parent[i] = i;
		}
		
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();//간선들의 Min 우선순위 정렬  
		
		for(int i = 0 ; i < nodel.size(); i++) {
			for(int j = i+1 ; j < nodel.size() ; j++) {
				q.add(new Edge(nodel.get(i),nodel.get(j)));
			}
		}

		while(!q.isEmpty()) {
			Edge e = q.poll();
			if(find(e.A.num, parent) != find(e.B.num, parent)) {
				union(parent, e.A.num, e.B.num);
				sum+= e.Dist;
			}
		}
		
		System.out.printf("%.2f", sum);	
	}
	public static int find(int n, int[] parent) {
		if(parent[n] == n)
			return n;
		return find(parent[n], parent);
	}
	public static void union(int[] parent, int x, int y) {
		int a = find(x,parent);
		int b = find(y, parent);
		parent[a] = b;
	}
}
