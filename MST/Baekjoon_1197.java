package sw;

import java.util.*;

class Nod implements Comparable<Nod>{
	int B,weight;
	
	public Nod(int b, int w) {
		this.B = b;
		this.weight = w;
	}
	@Override
	public int compareTo(Nod o) {
		return this.weight - o.weight;
	}
	
}
public class Baekjoon_1197 {//최소 스패닝 트리 , 프림 
	
	public static boolean visited[];
	public static int dist[];
	public static int INF = 1000000000;
	public static ArrayList<Nod>[] list;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();
		int count = 0;
		int sum = 0;
		
		list = new ArrayList[v+1];
		visited = new boolean[v+1];
		dist = new int[v+1];
		
		for(int i=1;i<=v;i++)
			list[i] = new ArrayList<>();
		
		for(int i=0;i<e;i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			int w = s.nextInt();
			list[a].add(new Nod(b,w));//무방향이므로 2번진행  
			list[b].add(new Nod(a,w));
		}
		
		Arrays.fill(dist, INF);
		dist[1] = 0;
		
		PriorityQueue<Nod> q = new PriorityQueue<>();
		q.add(new Nod(1, dist[1])); //시작정점 저장 
		
		while(count < v) {
			Nod n = q.poll();
			if(!visited[n.B]) {
				visited[n.B] = true;
				sum += n.weight;
				count++;
			}
			else continue;
			
			for(int i = 0 ; i < list[n.B].size() ; i++) {
				Nod node = list[n.B].get(i);
				
				if(!visited[node.B] && dist[node.B] > node.weight) {
					dist[node.B] = node.weight;
					q.offer(new Nod(node.B, node.weight));
				}
			}
		}
		
		System.out.println(sum);
	}
}
