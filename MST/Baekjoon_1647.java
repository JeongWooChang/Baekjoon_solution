package sw;

import java.util.*;

class Nod implements Comparable<Nod>{
	int B,Dist;
	public Nod(int b, int d) {
		this.B = b;
		this.Dist = d;
	}
	@Override
	public int compareTo(Nod o) {
		return this.Dist - o.Dist;
	}
}
public class Baekjoon_1647 {//도시분할계획 mst   인접행렬이용시 메모리초과,  인접리스트+우선순위 큐 이용  
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int max = 0;
		int n = s.nextInt();
		int m = s.nextInt();
		int INF = 100000000;
		int sum = 0;
		int count = 0;
		ArrayList<Nod>[] l = new ArrayList[n+1];
		int[] dist = new int[n+1];
		boolean visited[] = new boolean[n+1];
		
		for(int i = 1 ; i <= n ; i++)
			l[i] = new ArrayList<>();
		
		for(int i = 0 ; i < m ; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			int w = s.nextInt();
			l[a].add(new Nod(b,w)); //무방향이므로 각각 저장   총2번  
			l[b].add(new Nod(a,w));
		}
		
		Arrays.fill(dist, INF);
		dist[1] = 0;//시작정점 초기화  
		
		PriorityQueue<Nod> q = new PriorityQueue<>();
		q.add(new Nod(1, dist[1]));
		
		while(!q.isEmpty()) {
			Nod node = q.poll();
			
			if(!visited[node.B]) {//선택된 노드 방문처리 및 최소길이가 sum에 저장  
				visited[node.B] = true;
				sum+=node.Dist;
				count++;
			}
			else continue;
			
			//System.out.println(node.B + " " + node.Dist);
			if(max < node.Dist) max = node.Dist;
				
			
			for(int i = 0 ; i < l[node.B].size() ; i++) {//선택된 노드와 연결된 가중치 최신화  
				Nod node2 = l[node.B].get(i);
				if(!visited[node2.B] && node2.Dist < dist[node2.B]) {
					dist[node2.B] = node2.Dist;
					q.add(new Nod(node2.B, node2.Dist));
				}
			}
		}
		System.out.println(sum-max);
	}
}
