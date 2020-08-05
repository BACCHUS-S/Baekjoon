package ssafy.java.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Numbering {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer tokens;
    static int N,CNT,TOTAL;
    static int MAP [][];
    static int ANS [];
    static Queue<Integer[]> queue;
    static int[][] DIR = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        N = Integer.parseInt(br.readLine());
        MAP = new int[N][N];
        ANS = new int[N*N];
        TOTAL = 0;
        for(int h=0;h<N; h++) {
            String input = br.readLine();
            for(int w=0;w<N;w++) {
                MAP[h][w] = input.charAt(w)-'0';
            }
        }

        for(int row=0; row<N; row++) {
            for(int col=0; col<N; col++) {
                if (MAP[row][col]==1) {
                    CNT = 0;
                    bfs(new Integer[] {row,col});
                    ANS[TOTAL++] = CNT;
                }
            }
        }
//            for(int i[] : MAP) {
//                System.out.println(Arrays.toString(i));
//            }System.out.println();
        sb.append(TOTAL).append("\n");
        int [] ans = Arrays.copyOfRange(ANS, 0, TOTAL);
        Arrays.sort(ans);
        for(int idx=0; idx<TOTAL; idx++) {
            sb.append(ans[idx]).append("\n");
        }
        System.out.println(sb);
        
    }
    
    static void bfs(Integer points[]) {
        queue = new LinkedList<Integer[]>();
        queue.offer(new Integer[] {points[0],points[1]});
        MAP[points[0]][points[1]] = 0;
        while(!queue.isEmpty()) {
            CNT++;
            Integer front [] = queue.poll();
            int row = front[0];
            int col = front[1];
            for(int idx=0;idx<DIR.length; idx++) {
                int nRow = row+DIR[idx][0];
                int nCol = col+DIR[idx][1];
                if(nRow>=0 && nRow<N && nCol>=0 && nCol<N && MAP[nRow][nCol]==1) {
                    MAP[nRow][nCol] = 0;
                    queue.offer(new Integer[] {nRow, nCol});
                }
            }
            
        }
        
    }

}
