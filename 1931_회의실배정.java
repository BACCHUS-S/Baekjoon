package com.ssafy.java.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MeetingRoom2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer tokens;
	static int room[][];
	static int N,CNT,END;
	static boolean FLAG;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		N = Integer.parseInt(br.readLine());
		CNT = 0; END = -1;
		room = new int[N][2];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(br.readLine(), " ");
			room[i][0] = Integer.parseInt(tokens.nextToken());
			room[i][1] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(room, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return Integer.compare(o1[0], o2[0]);
				}else {
					return Integer.compare(o1[1], o2[1]);
				}
			}
		});
		
//		for(int r[]:room) {
//			System.out.println(Arrays.toString(r));
//		}
		
		for(int i=0; i<N; i++) {
			if(room[i][0] >= END) {
				END = room[i][1];
				CNT++;
			}
		}
		System.out.println(CNT);
		
	}

}
