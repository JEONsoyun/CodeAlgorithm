package newProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MooTube {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		ArrayList<int[]> [] al  = new ArrayList[N+1];
		for(int i =1; i <= N; i++) {
			al[i] = new ArrayList<int[]>();
		}
		for(int i =1 ; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			int p  = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r  = Integer.parseInt(st.nextToken());
			al[p].add(new int[] {q,r});
			al[q].add(new int[] {p,r});
		}
		StringBuilder sb = new StringBuilder();
		for(int i =0; i< Q ; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			int cnt = 0; 
			Queue<Integer> q = new LinkedList<Integer>();
			boolean[] v = new boolean[N+1];
			v[V] = true;
			q.offer(V);
			while(!q.isEmpty()) {
				int t = q.poll();
				for(int[] a : al[t]) {
					if(!v[a[0]] && a[1]>=K ) {
						cnt++;q.offer(a[0]);
						v[a[0]]= true;
					}
				}
			}
			sb.append(cnt).append("\n");
			
		}
		System.out.println(sb);
	}
}
