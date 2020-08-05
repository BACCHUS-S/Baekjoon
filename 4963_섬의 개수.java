package ssafy.java.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Island_4963 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer tokens;
    static int W,H,CNT;
    static int MAP [][];
    static Queue<Integer[]> queue;
    static int[][] DIR = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        while(true) {
            tokens = new StringTokenizer(br.readLine(), " ");
            W = Integer.parseInt(tokens.nextToken());
            H = Integer.parseInt(tokens.nextToken());
            CNT = 0;
            if(W == 0 && H == 0) {break;}
            MAP = new int[H][W];
            for(int h=0;h<H; h++) {
                tokens = new StringTokenizer(br.readLine(), " ");
                for(int w=0;w<W;w++) {
                    MAP[h][w] = Integer.parseInt(tokens.nextToken());
                }
            }
            for(int row=0; row<H; row++) {
                for(int col=0; col<W; col++) {
                    if (MAP[row][col]==1) {
                        bfs(new Integer[] {row,col});
                    }
                }
            }
            sb.append(CNT).append("\n");
//            for(int i[] : MAP) {
//                System.out.println(Arrays.toString(i));
//            }System.out.println();
        }System.out.println(sb);
    }
    
    static void bfs(Integer points[]) {
        queue = new LinkedList<Integer[]>();
        queue.offer(new Integer[] {points[0],points[1]});
        MAP[points[0]][points[1]] = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int s=0; s<size; s++) {
                Integer front [] = queue.poll();
                int row = front[0];
                int col = front[1];
                for(int idx=0;idx<DIR.length; idx++) {
                    int nRow = row+DIR[idx][0];
                    int nCol = col+DIR[idx][1];
                    if(nRow>=0 && nRow<H && nCol>=0 && nCol<W && MAP[nRow][nCol]==1) {
                        MAP[nRow][nCol] = 0;
                        queue.offer(new Integer[] {nRow, nCol});
                    }
                }
            }
        }
        CNT++;
    }

}
