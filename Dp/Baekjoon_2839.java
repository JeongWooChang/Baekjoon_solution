package sw;

import java.util.*;

public class Baekjoon_2839 {

	public static void main(String[] args) {//설탕배달
		Scanner s = new Scanner(System.in);
		
		int num = s.nextInt();
		int quo = 0;
		int rem = 0;
		
		quo = num / 5;
		for(int i = quo ; i >= 0 ; i--) {
			rem = num - i*5;
			if(i == 0 && rem%3 != 0) System.out.print(-1);
			//return -1; 
			if(rem % 3 == 0) {
				System.out.print(rem/3 + i);
				break;
			}
		}
	}

}
