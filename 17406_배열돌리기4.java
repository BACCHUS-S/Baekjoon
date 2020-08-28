package com.ssafy.java.day27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Spin {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,K,MIN;
	static int [] ANS, ARR;
	static int [][] MAP, CMAP;
	static List<Info> INFO;
	static boolean VISIT[];
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		MIN = Integer.MAX_VALUE;
		MAP = new int[N][M];
		CMAP = new int[N][M];
		INFO = new ArrayList<>();
		VISIT = new boolean[K];
		ANS = new int[K];
		ARR = new int[K];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<M; c++) {
				MAP[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

		for(int k=0; k<K; k++) {
			tokens = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			int s = Integer.parseInt(tokens.nextToken());
			Info info = new Info(r,c,s);
			info.s = Math.min(Math.min(Math.min(info.r-1, N-info.r), Math.min(info.c-1, M-info.c)), info.s);
			ARR[k] = k;
//			Rotate(info);
//			for(int i[]: MAP) {
//				System.out.println(Arrays.toString(i));
//			}
//			System.out.println(MinArray());
			INFO.add(info);
		}
		Permu(0);
		System.out.println(MIN);
		
	}
	
	static void Permu(int cnt) {
		if(cnt == K) {
			for(int r=0; r<N; r++) {
				CMAP[r] = MAP[r].clone();
			}
			for(int idx=0; idx<K; idx++) {
				Rotate(INFO.get(ANS[idx]));				
			}
			MIN = Math.min(MIN, MinArray());
			return;
		}
		for(int idx=0; idx<ARR.length; idx++) {
			if(!VISIT[idx]) {
				ANS[cnt] = ARR[idx];
				VISIT[idx] = true;
				Permu(cnt+1);
				VISIT[idx] = false;
			}
		}
	}
	
	public static int MinArray() {
		int min=Integer.MAX_VALUE;
		for(int[]i: CMAP) {
			int sum = 0;
			for(int ii: i) {
				sum += ii;
			}
			min = Math.min(min, sum);
		}
		return min;
	}
	
	public static void Rotate(Info info){
		int r=info.r-1, c=info.c-1;
		for(int s=1; s<=info.s; s++) {
			int temp = CMAP[r+s][c+s];
			// 4번 반복함 : 오,위,왼,아래
			// c+s에서 / r+s-1 -> r-s
			for(int rr=r+s-1; rr>=r-s; rr--) {
				CMAP[rr+1][c+s] = CMAP[rr][c+s];
			}
			// r-s에서 / c+s-1 -> c-s
			for(int cc=c+s-1; cc>=c-s; cc--) {
				CMAP[r-s][cc+1] = CMAP[r-s][cc];
			}
			// c-s에서 / r-s+1 -> r+s
			for(int rr=r-s+1; rr<=r+s; rr++) {
				CMAP[rr-1][c-s] = CMAP[rr][c-s];
			}
			// r+s에서  / c-s+1 -> c+s
			for(int cc=c-s+1; cc<=c+s; cc++) {
				CMAP[r+s][cc-1] = CMAP[r+s][cc];
			}
			CMAP[r+s][c+s-1] = temp;			
		}
	}
	
	public static class Info{
		public int r,c,s;
		public Info(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}
		@Override
		public String toString() {
			return "Info [r=" + r + ", c=" + c + ", s=" + s + "]";
		}
		
	}

}
