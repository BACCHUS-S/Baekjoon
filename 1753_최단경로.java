package com.ssafy.java.day31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b_1753_shortest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer tokens; 
	static int V,E,START;
	static int dist[];
	static boolean visited[];
	static LinkNode [] graph;
	
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(tokens.nextToken())+1;
		E = Integer.parseInt(tokens.nextToken());
		START = Integer.parseInt(br.readLine());
		graph = new LinkNode[V];
		for(int e=0; e<E; e++) {
			tokens = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(tokens.nextToken());
			int f = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			graph[s] = new LinkNode(f, v, graph[s]);
			// 만약에 양방향 이라면?
			//graph[f] = new LinkNode(s,w,graph[f]);
		}
		//DijPQ(START);
		Dij(START);
	}
	static void DijPQ(int START) {
		visited = new boolean[V];
		dist = new int[V];
		Arrays.fill(dist, INF);
		PriorityQueue<LinkNode> pq = new PriorityQueue<>();
		
		dist[START] = 0;
		pq.offer(new LinkNode(START, 0, 0));
		while(!pq.isEmpty()) {
			LinkNode minVer = pq.poll();
			if(visited[minVer.idx]) continue;
			visited[minVer.idx] = true;
			LinkNode next = graph[minVer.idx];
			while(next != null) {
				if(!visited[next.idx] && dist[next.idx] > minVer.dist + next.value) {
					dist[next.idx]= minVer.dist+next.value; 
					pq.offer(new LinkNode(next.idx, next.value, dist[next.idx]));
				}
				next = next.link;
			}
		}
		for(int i=1; i<V; i++) {
			if(dist[i]==INF) sb.append("INF");
			else sb.append(dist[i]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void Dij(int START) {
		visited = new boolean[V];
		dist = new int[V];
		Arrays.fill(dist, INF);
		dist[START] = 0;
		
		for(int v=1; v<V; v++) {
			int minVer = 0, minCost = INF;
			for(int i=0; i<V; i++) {
				if(!visited[i] && dist[i]<minCost) {
					minCost = dist[i];
					minVer=i;
				}
			}
			visited[minVer] = true;
			LinkNode next = graph[minVer];
			while(next!=null) {
				if(!visited[next.idx]&& dist[next.idx]>dist[minVer]+next.value) {
					dist[next.idx] = dist[minVer]+next.value; 
				}
				next = next.link;
			}
		}
		for(int i=1; i<V; i++) {
			if(dist[i]==INF) sb.append("INF");
			else sb.append(dist[i]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	
	static class LinkNode implements Comparable<LinkNode>{
		int idx,value,dist;
		LinkNode link;
		public LinkNode(int idx, int value, int dist) {
			super();
			this.idx = idx;
			this.value = value;
			this.dist = dist;
		}
		public LinkNode(int idx, int value, LinkNode link) {
			super();
			this.idx = idx;
			this.value = value;
			this.link = link;
		}

		@Override
		public int compareTo(LinkNode o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.dist, o.dist);
		}
		
	}

}

/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
*/