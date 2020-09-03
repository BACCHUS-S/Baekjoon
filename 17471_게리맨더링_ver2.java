package com.ssafy.java.day32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_17471_mendering2 {
	static int N,answer,count;
	static int [] people;
	static int [][] arr;
	static boolean [] visited, team;
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		people = new int[N+1];
		team = new boolean[N+1];
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		answer = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			for(int j=0;j<temp;j++) {
				int linkNum = Integer.parseInt(st.nextToken());
				arr[i][linkNum] = 1;
				arr[linkNum][i] = 1;
			}
		}
		divide(1);
		if(!flag)answer = -1;
		System.out.println(answer);
	}
	
	public static void divide(int cnt) {
		if(cnt == N+1) {
			if(team[1]) {
				Arrays.fill(visited, false);
				count = 0;
				for(int i=1;i<=N;i++) {
					if(team[i]) {dfs(i,true);break;}
				}
				for(int i=1;i<=N;i++) {
					if(!team[i]) {dfs(i,false);break;}
				}
				if(count != N)  return;				
				flag = true;
				int sumA = 0;	int sumB = 0;
				for(int i=1;i<=N;i++) {
					if(team[i]) sumA += people[i];
					else sumB += people[i];
				}
				answer = Math.min(answer, Math.abs(sumA - sumB));
				return;
			}
			return;
		}
		
		team[cnt] = true;
		divide(cnt+1);
		team[cnt] = false;
		divide(cnt+1);
	}
	
	public static void dfs(int start, boolean teamNum) {
		visited[start] = true;
		count++;
		for(int i=1;i<=N;i++) {
			if(!visited[i] && team[i] == teamNum && arr[start][i] == 1) dfs(i,teamNum);
		}
	}
}