package com.ssafy.java.day31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_14889_startlink {
	static int N, MIN;
	static int MAP[][];
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer tokens;
	static boolean visited[];
	static int []A,B;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		MAP = new int[N][N];
		visited = new boolean[N];
		MIN = Integer.MAX_VALUE;
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<N; c++) {
				MAP[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		bfs(0,0);
		System.out.println(MIN);
	}
	static void bfs(int cnt, int start) {
		if(cnt == N/2) {
			A = new int[N/2];
			B = new int[N/2];
			int idxA=0, idxB=0;
			for(int idx=0; idx<N; idx++) {
				if(visited[idx]) {A[idxA++] = idx;}
				else {B[idxB++] = idx;}
			}
			MIN = Math.min(MIN, Math.abs(power(A)-power(B)));
			return;
		}
		for(int idx=start; idx<N-(N/2-cnt); idx++) {
			visited[idx] = true;
			bfs(cnt+1, idx+1);
			visited[idx] = false;
		}
	}
	static int power(int[] team) {
		int sum = 0;
		for(int r=0; r<N/2; r++) {
			for(int c=0; c<N/2; c++) {
				if(r!=c) sum += MAP[team[r]][team[c]];
				
			}
		}
		return sum;
	}

}
