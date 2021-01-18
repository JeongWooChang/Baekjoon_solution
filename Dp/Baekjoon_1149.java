package sw;

import java.util.*;
import java.io.*;

public class Baekjoon_1149 {

	public static void main(String[] args) throws  IOException {//RGB거리 
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int[][] arr = new int[n+1][3];
		int[][] arr2 = new int[n+1][3];
		
		for(int i = 1 ; i <= n ; i++) {
			arr[i][0] = s.nextInt();
			arr[i][1] = s.nextInt();
			arr[i][2] = s.nextInt();
		}
		for(int i = 1 ; i <= n ; i++) {
			arr2[i][0] = Math.min(arr2[i-1][1], arr2[i-1][2]) + arr[i][0];
			arr2[i][1] = Math.min(arr2[i-1][0], arr2[i-1][2]) + arr[i][1];
			arr2[i][2] = Math.min(arr2[i-1][1], arr2[i-1][0]) + arr[i][2];
		}
		
		System.out.println(Math.min(arr2[n][2], Math.min(arr2[n][0], arr2[n][1])));
		//br.close();, 
		//bw.close();
	}
}
