package sw;

import java.util.*;
import java.io.*;

public class Baekjoon_1003 {

	public static void main(String[] args) throws  IOException {//피보나치 함수, 점화식이용 -> f[n] = f[n-1]+f[n-2] 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test = Integer.parseInt(br.readLine());
		int[][] arr = new int[41][2];
		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[1][0] = 0;
		arr[1][1] = 1;
		
		
		
		for(int i = 0 ; i < test ; i++) {
			int num = Integer.parseInt(br.readLine());
			if(arr[num][0] == 0) {
				for(int j = 2 ; j <= num ; j++) {
					arr[j][0] = arr[j-1][0] + arr[j-2][0];
					arr[j][1] = arr[j-1][1] + arr[j-2][1];
				}
			}
			bw.write(arr[num][0] + " " +arr[num][1] + "\n");
			bw.flush();
			//System.out.println(arr[num][0] + " " + arr[num][1]);
		}
		
		br.close();
		bw.close();
	}
}
