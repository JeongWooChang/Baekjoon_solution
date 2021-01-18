package sw;

import java.util.*;
import java.io.*;

public class Baekjoon_11726 {

	public static void main(String[] args) throws  IOException {//2xn 타일링, f[n] = f[n-1] + f[n-2] (단,n > 2)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		arr[1] = 1;
		arr[2] = 2;
		
		if(n <= 2) {
			bw.write(arr[n] + "\n");
			bw.flush();
		}
		else {
			for(int j = 3 ; j <= n ; j++)
				arr[j] = (arr[j-1] + arr[j-2])%10007;
			bw.write(arr[n] + "\n");
			bw.flush();
		}
		
		
		//System.out.println(arr[num][0] + " " + arr[num][1]);
		br.close();
		bw.close();
	}
}