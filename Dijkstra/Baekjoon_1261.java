package sw;
import java.util.*;

class Point implements Comparable<Point>{
	int A,B,Dist;
	
	public Point (int a, int b, int d) {
		this.A = a;
		this.B = b;
		this.Dist = d;
	}
	@Override
	public int compareTo(Point o) {
		return this.Dist - o.Dist;
	}
}
public class Baekjoon_1261 {//알고스팟, 다시풀기  

	public static int n;
	public static int m;
	public static int[][] map;
	public static boolean[][] visited;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		m = s.nextInt();
		n = s.nextInt();
		map = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
		
		for(int i = 1 ; i <= n ; i++) {
			String str = s.next();
			for(int j = 1 ; j <= m ; j++) {
				map[i][j] = Integer.valueOf(str.charAt(j-1)) - '0';
			}
		}
		System.out.println(bfs(1,1));
		
	}
	public static int bfs(int x, int y) {
		PriorityQueue<Point> q = new PriorityQueue<>();
		q.add(new Point(x,y,0));
		visited[x][y] = true;
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		while(!q.isEmpty()) {
			Point point = q.poll();
			if(point.A == n && point.B == m) {
				return point.Dist;
			}
			for(int i = 0 ; i < 4 ; i++) {
				int a = dx[i] + point.A;
				int b = dy[i] + point.B;
				if(a >= 1 && b >= 1 && a <= n && b <= m) {
					if(!visited[a][b] && map[a][b] == 0) {
						visited[a][b] = true;
						q.add(new Point(a,b, point.Dist));
					}
					if(!visited[a][b] && map[a][b] == 1) {
						visited[a][b] = true;
						q.add(new Point(a,b,point.Dist+1));
					}
				}
			}
		}
		return 0;
	}

}
