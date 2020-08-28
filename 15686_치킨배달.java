package com.ssafy.java.day27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Chiken {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, MIN;
	static int MAP [][];
	//static List<Integer []> house, chicken;
	static List<Chicken> house, chicken;
	static int ARR[], ANS[];
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		tokens = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		MAP = new int[N][N];
		MIN = Integer.MAX_VALUE;
		
		//house = new LinkedList<Integer[]>();
		//chicken = new LinkedList<Integer[]>();
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<N; c++) {
				int temp = Integer.parseInt(tokens.nextToken());
				if(temp == 1) {
					//house.add(new Integer [] {r,c});
					house.add(new Chicken(r,c));
				}else if(temp == 2) {
					//chicken.add(new Integer [] {r,c});
					chicken.add(new Chicken(r,c));
				}
			}
		}
		if (M > chicken.size()) M = chicken.size();
		ARR = new int[chicken.size()];		
		for(int i=0; i<chicken.size(); i++) {
			ARR[i] = i;
		}
		ANS = new int[M];
//		for(;M>=1; M--) {
//			ANS = new int[M];
//			//System.out.println(">>"+M);
//			combi(0,0);
//		}
//		//combi(0,0); // M일때부터 해보자 M이 1이 될때까지
		combi(0,0);
		System.out.println(MIN);
	}
	
	static void combi(int cnt, int start) {
		if(cnt == M) {
			int temp = 0;
			//for(Integer [] h : house) {
			for(Chicken h: house) {
				int min = Integer.MAX_VALUE;
				for(Integer i : ANS) {
					min = Math.min(min , (Math.abs(h.r-chicken.get(i).r)+Math.abs(h.c-chicken.get(i).c)));
				}
				temp += min;
			}
			if(temp < MIN) {
				MIN = temp;
			}
			//System.out.println(Arrays.toString(ANS));
			//System.out.println(MIN);
			return;
		}
		for(int idx=start; idx<ARR.length; idx++) {
			ANS[cnt] = ARR[idx];
			combi(cnt+1, idx+1);
		}
	}
	static class Chicken{
		int r;
		int c;
		public Chicken(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}

}
