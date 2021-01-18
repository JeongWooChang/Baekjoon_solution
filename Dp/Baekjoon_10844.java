package sw;

import java.util.*;
import java.io.*;

public class Baekjoon_10844 {

	public static void main(String[] args) throws IOException {//쉬운계단수 다시풀기  
		Scanner s = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = s.nextInt();
		long sum = 0;
		//int[] arr = new int[n];
		long[][] dp = new long[101][11];
		
		for(int  i = 1 ; i <= 9 ; i++) {
			dp[1][i]= 1;
		}
		
		for(int  i = 2 ; i <= n ; i++) {
			dp[i][0] = dp[i-1][1];
			for(int j = 1 ; j <= 9 ; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
			}
		}
		for(int i = 0 ; i <= 9 ; i++) {
			sum += dp[n][i];
		}
		System.out.println(sum%1000000000);
		//bw.write(max + "\n");
		//bw.flush();
		
		//br.close();
		//bw.close();
	}

}