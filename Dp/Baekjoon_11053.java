package sw;

import java.util.*;
import java.io.*;

public class Baekjoon_11053 {

	public static void main(String[] args) throws IOException {//가장 긴 증가하는 부분 수열  
		Scanner s = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = s.nextInt();
		int max = 1;
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		for(int  i = 0 ; i < n ; i++) {
			arr[i] = s.nextInt();
		}
		
		dp[0] = 1;
		for(int  i = 1 ; i < n ; i++) {
			for(int j = 0 ; j < i ; j++) {
				if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j]);
			}
			dp[i] +=1;
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
		//bw.write(max + "\n");
		//bw.flush();
		
		//br.close();
		//bw.close();
	}

}