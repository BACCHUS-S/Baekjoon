package com.ssafy.java.day32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class b_17471_mendering {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, MIN;
	static int [] people;
	static List<int []> graph;
	static boolean visited [];
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		graph = new ArrayList<>();
		graph.add(new int[] {});
		visited = new boolean[N];
		MIN = Integer.MAX_VALUE;
		tokens = new StringTokenizer(br.readLine(), " ");
		for(int n=0; n<N; n++) people[n] = Integer.parseInt(tokens.nextToken());
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(tokens.nextToken());
			int temp[] = new int[size];
			for(int s=0; s<size; s++) temp[s] = Integer.parseInt(tokens.nextToken());
			graph.add(temp);
		}
//		for(int[] i: graph) {
//			System.out.println(Arrays.toString(i));
//		}
		subSet(0);
		if(MIN==Integer.MAX_VALUE)MIN=-1;
		System.out.println(MIN);
		
	}
	static int isGraph(Set<Integer> S) {
		Iterator<Integer> it = S.iterator();
		Queue<Integer> queue = new LinkedList<>();
		boolean v[] = new boolean[N];
		int nextInt = it.next();
		queue.add(nextInt);
		int sum = 0;
		while(!queue.isEmpty() && !S.isEmpty()) {
			int front = queue.poll();
			if(S.contains(front)) {S.remove(front);sum+=people[front-1];}
			if(!v[front-1]) {
				v[front-1] = true;
				for(int i : graph.get(front)) {
					if(S.contains(i))queue.offer(i);
				};
			}
		}
		if(S.size()!=0) return -1;
		return sum;
		
	}
	
	
	static void subSet(int cnt) {
		if(cnt==N) {
			if(visited[0]) {
				Set<Integer> A = new HashSet<>();
				Set<Integer> B = new HashSet<>();
				for(int idx=1; idx<=N; idx++) {
					if(visited[idx-1]) A.add(idx);
					else B.add(idx);
				}
				if(A.size()!=0 && B.size()!=0) {
					int a = isGraph(A);
					int b = isGraph(B);
					if(a!=-1 && b!=-1) MIN = Math.min(MIN, Math.abs(a-b));
				}
			}
			return;
		}
		visited[cnt] = true;
		subSet(cnt+1);
		visited[cnt] = false;
		subSet(cnt+1);
	}
}
