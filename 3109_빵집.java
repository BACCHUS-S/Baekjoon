package com.ssafy.java.day29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bread {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R,C, result;
	static char MAP[][];
	static int DIR[][] = {{-1,1},{0,1},{1,1}};
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		MAP = new char[R][C];
		visited = new boolean[R][C];
		for(int r=0; r<R; r++) MAP[r] = br.readLine().toCharArray();
		for(int r=0; r<R; r++) {
			System.out.println("r : "+r);
			result += BackTracking(r,0);
			System.out.println("result : "+result);
		}
		System.out.println(result);
	}
	static int BackTracking(int r, int c) {
		visited[r][c] = true;
		if(c==C-1) return 1;
		for(int i=0; i<3; i++) {
			int nRow = r+DIR[i][0];
			int nCol = c+DIR[i][1];
			if(0<=nRow&&nRow<R&&0<=nCol&&nCol<C&&!visited[nRow][nCol]&&MAP[nRow][nCol]=='.') {
				int v = BackTracking(nRow, nCol);
				if(v!=0)return v;
			}
		}
		
		return 0;
	}

}
