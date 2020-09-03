package com.ssafy.java.day27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QuardTree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String INPUT;
	static int N, M;
	static int MAP [][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		MAP = new int[N][N];
		for(int r=0; r<N; r++) {
			INPUT = br.readLine();
			for(int c=0; c<N; c++) {
				MAP[r][c] = INPUT.charAt(c)-'0';
			}
		}
		divide(0,0,N);
		System.out.println(sb);
//		for(int[]i:MAP) {
//			System.out.println(Arrays.toString(i));
//		}
	}
	public static void divide(int row, int col, int n) {
		if(check(row, col, n)) {
			sb.append(M);
		}else {
			sb.append("(");
			int s=n/2;
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					divide(row+s*i, col+s*j, s);
				}
			}
			sb.append(")");
		}
		
	}
	
	public static boolean check(int row, int col, int n) {
		int std = MAP[row][col];
		for(int i=row; i<row+n; i++) {
			for(int j=col; j<col+n; j++) {
				if(std != MAP[i][j]) {
					return false;
				}
			}
		}
		M = std;
		return true;
	}
	

}
