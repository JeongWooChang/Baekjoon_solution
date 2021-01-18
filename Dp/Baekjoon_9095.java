package sw;

import java.util.*;

public class Baekjoon_9095 {//1,2,3 더하기 ,점화식사용 
	
    public static int[] arr;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		arr = new int[11];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		dp();
		int num = s.nextInt();
		for(int i = 0 ; i < num ; i++) {
			int n = s.nextInt();
			System.out.println(arr[n]);
		}
	}
	public static void dp() {
		for(int i = 4; i < arr.length ; i++)
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
	}

}
