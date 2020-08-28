package com.ssafy.java.day29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Alphabet2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer tokens;
	static int R,C, nR, nC, MAX;
	static char [][] MAP;
	static int [][] map;
	//static boolean [] VISITED;
	static int [][] alpha;
	static int [][] DIR = {{-1,0},{1,0},{0,-1},{0,1}};
	static String input;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		MAP = new char[R][C];
		//map = new int[R][C];
		alpha = new int[R][C];
		//VISITED = new boolean[26];
		for(int r=0; r<R; r++) MAP[r] = br.readLine().toCharArray();
//		for(int r=0; r<R; r++) {
//			input = br.readLine();
//			for(int c=0; c<C; c++) map[r][c] = input.charAt(c)-'A';
//		}
		for(char []i:MAP)System.out.println(Arrays.toString(i));
		System.out.println(1<<(MAP[0][0]-'A'));
		System.out.println(MAP[0][0]-'A');
		BFS(new PNT(0,0,1<<(MAP[0][0]-'A'),1));
		//DFS(0,0,0);
		System.out.println(MAX);
	}
//	static void DFS(int r, int c, int d) {
//		if(VISITED[MAP[r][c]-'A']) {
//			MAX = Math.max(MAX, d);
//			return;
//		}else {
//			VISITED[MAP[r][c]-'A']=true;
//			for(int i=0; i<4; i++) {
//				nR = r+DIR[i][0];
//				nC = c+DIR[i][1];
//				if(nR>=0&&nR<R&&nC>=0&&nC<C) DFS(nR,nC,d+1);
//			}
//			VISITED[MAP[r][c]-'A']=false;
//		}
//	}
	static void BFS(PNT pnt) {
		Queue<PNT> queue = new LinkedList<>();
		queue.offer(pnt);
		while(!queue.isEmpty()) {
			PNT front = queue.poll();
			if(alpha[front.r][front.c]==front.a) continue;
			alpha[front.r][front.c] = front.a;
			for(int[]i:alpha) {
				for(int ii: i) System.out.print(Integer.toBinaryString(ii)+" ");
				System.out.println();
			}
			System.out.println();
			MAX = front.cnt;
			for(int i=0; i<4; i++) {
				nR = front.r+DIR[i][0];
				nC = front.c+DIR[i][1];
				if(nR>=0&&nR<R&&nC>=0&&nC<C) {
					int nextA = 1<<(MAP[nR][nC]-'A');
					//System.out.println("nextA : "+nextA+"front.a : "+front.a);
	    			if((front.a&nextA)==0) {
	    				queue.offer(new PNT(nR, nC,front.a|nextA,front.cnt+1));
	    			}
				}
				
			}
		}
	}
	static class PNT{
		int r,c,a,cnt;
		public PNT(int r, int c, int a,int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.a = a;
			this.cnt = cnt;
		}
	}

}
