package sw;

import java.util.*;
import java.io.*;

public class Baekjoon_2579 {

	public static void main(String[] args) throws IOException {//계단오르기  
		//Scanner s = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[301];
		int[] dp = new int[301];
		
		for(int  i = 1 ; i <= n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		dp[3] = Math.max(arr[1], arr[2]) + arr[3];
		for(int  i = 4 ; i <= n ; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3]+arr[i-1]) + arr[i];
		}
		
		bw.write(dp[n] + "\n");
		bw.flush();
		
		br.close();
		bw.close();
	}

}