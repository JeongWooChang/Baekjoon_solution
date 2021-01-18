package sw;

import java.util.*;
import java.io.*;

public class Baekjoon_1932 {

	public static void main(String[] args) throws IOException {//정수삼각형  
		Scanner s = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = s.nextInt();
		
		int[][] arr = new int[n][n];
		
		
		for(int  i = 0 ; i < n ; i++) {
			for(int j = 0 ; j <= i ; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		
		
		for(int  i = 1 ; i < n ; i++) {
			
			
			arr[i][0] += arr[i-1][0];
			arr[i][i] += arr[i-1][i-1];
			for(int j = 1 ; j < i ; j++) {
				arr[i][j] += Math.max(arr[i-1][j-1], arr[i-1][j]);
			}
		}
		Arrays.sort(arr[n-1]);
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		//System.out.println(arr[n-1][n-1]);
		//bw.write(arr[n-1][n-1] + "\n");
		//bw.flush();
		
		//br.close();
		//bw.close();
	}

}