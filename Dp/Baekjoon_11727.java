package sw;

import java.util.*;
import java.io.*;

public class Baekjoon_11727 {

	public static void main(String[] args) throws IOException {//2xn 타일링 2,  dp
		Scanner s = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = s.nextInt();
		long[] dp = new long[1001];
		//long sum = 0;
		//int[] arr = new int[n];
		
		dp[1] = 1;
		dp[2] = 3;
		for(int  i = 3 ; i <= n ; i++) 
			dp[i] = (dp[i-2]*2 + dp[i-1])%10007;		
		
		System.out.println(dp[n]%100007);
		//bw.write(max + "\n");
		//bw.flush();
		
		//br.close();
		//bw.close();
	}

}