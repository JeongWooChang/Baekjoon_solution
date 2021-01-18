package sw;
import java.util.*;
import java.io.*;

public class Baekjoon_1912 {

	public static void main(String[] args) throws IOException {//연속합  
		Scanner s = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = s.nextInt();
		int max = 0;
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		for(int  i = 0 ; i < n ; i++) {
			arr[i] = s.nextInt();
		}
		
		dp[0] = arr[0];
		max = dp[0];
		for(int  i = 1 ; i < n ; i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
		
		//bw.write(max + "\n");
		//bw.flush();
		
		//br.close();
		//bw.close();
	}

}