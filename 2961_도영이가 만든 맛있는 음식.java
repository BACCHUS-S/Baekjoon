package com.ssafy.java.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Food {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer tokens;
	static int N, MIN;
	static int left[], right[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		N = Integer.parseInt(br.readLine());
		left = new int[N];
		right = new int[N];
		MIN = Integer.MAX_VALUE;
		for(int idx=0; idx<N; idx++) {
			tokens = new StringTokenizer(br.readLine(), " ");
			left[idx] = Integer.parseInt(tokens.nextToken());
			right[idx] = Integer.parseInt(tokens.nextToken());
		}
		sub();
		System.out.println(MIN);

	}
	
	static void sub() {
		for(int i=1; i<(1<<N); i++) {
			List<Integer> queue = new ArrayList<Integer>();
			for(int j=0; j<N; j++) {
				if((i&(1<<j))>0) {
					queue.add(j);
				}
			}
			int leftVal=1, rightVal=0;
			for(int idx=0; idx<queue.size(); idx++) {
				int IDX = queue.get(idx);
				leftVal*=left[IDX];
				rightVal+=right[IDX];
			}
			if(Math.abs(leftVal-rightVal) < MIN) {
				MIN = Math.abs(leftVal-rightVal);
			}
		}
	}

}
