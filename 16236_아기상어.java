package com.ssafy.java.day35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_16236_BayShark {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, fishCnt, time, preTime;
	static int SHARK[];
	static int MAP[][];
	static int DIR[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean visited[][];
	static Queue<PNT> queue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		SHARK = new int[4];
		MAP = new int[N][N];	 	
		fishCnt = 0;preTime=time = 0;
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<N; c++) {
				MAP[r][c] = Integer.parseInt(tokens.nextToken());
				if(MAP[r][c] == 9) {SHARK[0] = r; SHARK[1]=c; SHARK[2]=2; SHARK[3]=0;}
				if(MAP[r][c] != 0) fishCnt++;
			}
		}		
		visited = new boolean[N][N];
		queue = new LinkedList<>();
		queue.offer(new PNT(SHARK[0],SHARK[1]));
		visited[SHARK[0]][SHARK[1]] = true;
		
		while(!queue.isEmpty()) {
			if(fishCnt==0)break;
			int size = queue.size();
			PriorityQueue<PNT> eatable = new PriorityQueue<>();
			while(size-->0) {
				PNT pnt = queue.poll();
				for(int i=0; i<4; i++) {
					int nR = pnt.r+DIR[i][0];
					int nC = pnt.c+DIR[i][1];
					if(nR>=0 && nR<N && nC>=0 && nC<N && !visited[nR][nC] && MAP[nR][nC]<=SHARK[2]) {
						visited[nR][nC] = true;
						if(MAP[nR][nC]==SHARK[2] || MAP[nR][nC]==0) queue.offer(new PNT(nR,nC));
						else eatable.offer(new PNT(nR,nC));
					}
				}
			}
			if(eatable.size() !=0) {
				fishCnt--;
				MAP[SHARK[0]][SHARK[1]]=0;
				PNT nextPnt = eatable.poll();
				MAP[nextPnt.r][nextPnt.c]=9; SHARK[0]=nextPnt.r; SHARK[1]=nextPnt.c; SHARK[3]+=1;
				if(SHARK[2]==SHARK[3]) {SHARK[2]++; SHARK[3]=0;}
				preTime = time+1;
				queue = new LinkedList<>();
				queue.offer(new PNT(SHARK[0],SHARK[1]));
				visited = new boolean[N][N];
				visited[SHARK[0]][SHARK[1]] = true;
			}
			time += 1;			
		}
		System.out.println(preTime);
	}
	static class PNT implements Comparable<PNT>{
		int r,c;

		public PNT(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(PNT o) {
			// TODO Auto-generated method stub
			if(this.r==o.r) {
				return Integer.compare(this.c, o.c);
			}
			return Integer.compare(this.r,o.r);
		}
	}

}
