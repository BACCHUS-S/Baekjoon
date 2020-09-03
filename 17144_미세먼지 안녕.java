package com.ssafy.java.day32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b_17144_bye {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R,C,T,ANS;
	static int [][] MAP, FRESH, MAP2;
	static int DIR [][]= {{-1,0},{1,0},{0,-1},{0,1}};
	//static List<pnt> DUST;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());
		MAP = new int[R][C];
		FRESH = new int[2][2];
		
		int tempIdx=0;		
		for(int r=0; r<R; r++) {
			tokens = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<C; c++) {
				MAP[r][c] = Integer.parseInt(tokens.nextToken());
				if(MAP[r][c] == -1) {
					FRESH[tempIdx][0]=r;
					FRESH[tempIdx][1]=c;
					tempIdx++;
				}
			}
		}
		
		for(int t=0; t<T; t++) {
			Spread();
			Fresh();
			
		}
//		for(int i[]:MAP) {
//			System.out.println(Arrays.toString(i));
//		}
		ANS=0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(MAP[r][c]!=0) ANS+=MAP[r][c];
			}
		}
		System.out.println(ANS+2);
	}
	static void Fresh() {
		int fR=FRESH[0][0], fC=FRESH[0][1];
		for(int r=fR-2; r>=0; r--) MAP[r+1][0]=MAP[r][0];
		for(int c=1; c<C; c++) MAP[0][c-1]=MAP[0][c];
		for(int r=1; r<=fR; r++) MAP[r-1][C-1]=MAP[r][C-1];
		for(int c=C-2; c>=fC; c--) MAP[fR][c+1] = MAP[fR][c]; 
		MAP[fR][fC+1]=0;
		fR=FRESH[1][0]; fC=FRESH[1][1];
		for(int r=fR+2; r<R; r++) MAP[r-1][0]=MAP[r][0];
		for(int c=1; c<C; c++) MAP[R-1][c-1]=MAP[R-1][c];
		for(int r=R-2; r>=fR; r--) MAP[r+1][C-1]=MAP[r][C-1];
		for(int c=C-2; c>=fC; c--) MAP[fR][c+1] = MAP[fR][c]; 
		MAP[fR][fC+1]=0;
	}
	static void Spread() {
		//DUST = new ArrayList<>();
		MAP2 = new int[R][C];
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(MAP[r][c] != 0 && MAP[r][c] !=-1) {
					// 한 점에서 전파 할 수 있는 갯수 구하기
					// 한점에서 전파 하는 값 구하기
					if(MAP[r][c]>4) {
						int value = MAP[r][c]/5;
						int cnt=0;
						for(int i=0; i<4; i++) {
							int nR = r+DIR[i][0];
							int nC = c+DIR[i][1];
							if(nR>=0 && nR<R && nC>=0 && nC<C && MAP[nR][nC]!=-1) {
								cnt++;
								//DUST.add(new pnt(nR,nC,value));
								MAP2[nR][nC] += value;
							}
						}
						MAP[r][c] -= (value*cnt);
					}
				}
			}
		}
//		for(int i=0; i<DUST.size(); i++) {
//			pnt p = DUST.get(i);
//			MAP[p.r][p.c]+=p.v;
//		}
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				MAP[r][c] += MAP2[r][c];
			}
		}
		
	}
//	static class pnt{
//		int r,c,v;
//
//		public pnt(int r, int c, int v) {
//			super();
//			this.r = r;
//			this.c = c;
//			this.v = v;
//		}
//		
//	}

}
