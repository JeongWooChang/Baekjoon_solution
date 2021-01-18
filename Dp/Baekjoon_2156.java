package sw;

import java.util.*;
import java.io.*;

public class Baekjoon_2156 {

	public static void main(String[] args) throws IOException {//포도주 시식  
		//Scanner s = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		int[] arr = new int[10005];
		int[] dp = new int[10005];
		
		for(int  i = 3 ; i <= n+2 ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int  i = 3 ; i <= n+2 ; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3]+arr[i-1]) +arr[i];
			dp[i] = Math.max(dp[i-1], dp[i]);
			max = Math.max(max, dp[i]);
		}
		//Arrays.sort(dp);
		
		bw.write(max + "\n");
		bw.flush();
		
		br.close();
		bw.close();
	}

}