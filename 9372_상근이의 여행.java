package com.ssafy.java.day30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_9372_travel {
	static int T,N,M,result;
	static int ARR[][];
	static boolean visit[];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer tokens;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			tokens = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			result = 0;
			ARR = new int[N+1][N+1];
			visit = new boolean[N+1];
			for(int m=0; m<M; m++) {
				tokens = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(tokens.nextToken());
				int b = Integer.parseInt(tokens.nextToken());
				ARR[a][b] = 1;
				ARR[b][a] = 1;
			}
			bfs();
			sb.append(result-1).append("\n");
		}
		System.out.println(sb);
	}
	static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		visit[1] = true;
		while(!queue.isEmpty()) {
			result++;
			int val = queue.poll();
			for(int i=1; i<=N; i++) {
				if(ARR[val][i]!=0 && !visit[i]) {
					visit[i] = true;
					queue.add(i);
				}
			}
		}	
	}
}
