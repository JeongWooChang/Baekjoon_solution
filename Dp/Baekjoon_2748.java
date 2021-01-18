package sw;

import java.util.*;
import java.io.*;

public class Baekjoon_2748 {//피보나치수2 dp

	public static long n;
	public static int result;
	public static void main(String[] args) throws IOException {  
		Scanner s = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Long, Long> hm = new HashMap<>();
		
		n = s.nextLong();
		
		//int[] arr = new int[n];
		
		System.out.println(fib_dp(n, hm));
		
		//bw.write(fib_dp(n, hm) + "\n");
		//bw.flush();
		
		//br.close();
		//bw.close();
	}
	
	public static long fib_dp(long k, HashMap<Long, Long> hm) {
	    if(hm.containsKey(k)) {
			return hm.get(k);
		}
		else if(k == 0) {
			hm.put(k, (long) 0);
			return hm.get(k);
		}
		else if(k == 1) {
			hm.put(k,(long) 1);
			return hm.get(k);
		}
		else {
			long val = fib_dp(k-1,hm) + fib_dp(k-2,hm);
			hm.put(k,val);
			return val;
		}
	}
}