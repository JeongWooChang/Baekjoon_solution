package Baekjoon;

import java.util.*;

public class Baekjoon_2225 {//합분해, dp

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr = new int[201][201];

		if(K == 1 || N == 0) System.out.println(1);
		else if(K == 2) System.out.println(N+1);
		else {
			for(int i = 0 ; i <= N; i++)
				arr[2][i] = i+1;
			for(int i = 0 ; i <= K ; i++)
				arr[i][0] = 1;

			for(int i = 3 ; i <= K ; i++) {
				for(int j = 1 ; j <= N ; j++) {
					arr[i][j] = (arr[i][j-1] + arr[i-1][j])%1000000000;
				}
			}
			System.out.println(arr[K][N]%1000000000);
		}
	}

}
