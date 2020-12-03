package newProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ski_Course_Design {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int []arr = new int[N];
		for(int i =0 ; i< N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int ans = Integer.MAX_VALUE;
		for(int i = 0, j = 17; j<=100; i++, j++) {
			int t = 0; 
			for(int n = 0; n< N; n++) {
				if(arr[n]<i) {
					t+=(i-arr[n])*(i-arr[n]);
				}else if(arr[n]>j) {
					t+=(j-arr[n])*(j-arr[n]);
				}
			}
			ans = t<ans?t:ans;
		}
		System.out.println(ans);
	}
}
