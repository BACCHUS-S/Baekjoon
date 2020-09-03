package com.ssafy.java.day30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class b_1197_MST {
	   
    static class Edge implements Comparable<Edge> {
        int target;
        int value;
        
        Edge(int target, int value) {
            this.target = target;
            this.value = value;
        }

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.value, o.value);
		}

		@Override
		public String toString() {
			return "Edge [target=" + target + ", value=" + value + "]";
		}
		
		
    }
    
    static ArrayList<Edge>[] graph;
    static int[] minEdge;
    static boolean[] visited;
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N];
        minEdge = new int[N];
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
        	graph[i] = new ArrayList<>();
            minEdge[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < M; i++) {
            
            st = new StringTokenizer(br.readLine(), " ");
            
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int val = Integer.parseInt(st.nextToken());
            
            graph[start].add(new Edge(end, val));
            graph[end].add(new Edge(start, val));
        }
        primPQ();
        
        
    }
    static void primPQ() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int result = 0;
		// 임의의 한 점에서 출발
		minEdge[0] = 0;
		pq.offer(new Edge(0,0));
		while(!pq.isEmpty()) {
			// 최소 비용의 녀석을 자동으로 계산함
			Edge minVertex = pq.poll();
			//System.out.println(Arrays.toString(visited));
			//System.out.println(minVertex);
			if(visited[minVertex.target])continue;
			visited[minVertex.target] = true;
			result += minVertex.value;
			//System.out.println(graph[minVertex.target].size());
			for(int i=0; i<graph[minVertex.target].size(); i++) {
				if(!visited[graph[minVertex.target].get(i).target]) {
					pq.offer(new Edge(graph[minVertex.target].get(i).target,graph[minVertex.target].get(i).value));
					//System.out.println("pq.size : "+pq.size());
				}
			}
			
		}
		System.out.println(result);
	}
    
    static void primNoPQ() {
    	int start = 0;
    	minEdge[start] = 0;
        visited[start] = true;
        int answer = 0;
        
        while(true) {
            
            for (int i = 0; i < graph[start].size(); i++) {
                
                int target = graph[start].get(i).target;
                int value = graph[start].get(i).value;
                
                if(!visited[target]) {
                    if(minEdge[target] > value) minEdge[target] = value;
                }
            }
            
            int min = Integer.MAX_VALUE;
            boolean isEnd = true;
            
            for (int i = 0; i < minEdge.length; i++) {
                
                if(visited[i] || minEdge[i] == Integer.MAX_VALUE) continue;
                
                if(minEdge[i] < min) {
                    min = minEdge[i];
                    start = i;
                    isEnd = false;
                }
            }
            
            if(isEnd) break;
            
            visited[start] = true;
            answer += min; 
            
        }
        
        System.out.println(answer);
    }
    
    
    
 
}
