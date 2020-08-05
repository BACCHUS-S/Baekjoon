package ssafy.java.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato_4963 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer tokens;
    static int N,M,CNT;
    static int MAP[][];
    static Queue<Integer[]> queue;
    static int DIR[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        tokens = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        MAP = new int[M][N];
        queue = new LinkedList<Integer[]>();
        for(int m=0; m<M; m++) {
            tokens = new StringTokenizer(br.readLine(), " ");
            for(int n=0; n<N; n++) {
                MAP[m][n] = Integer.parseInt(tokens.nextToken());
                if(MAP[m][n] == 1) {
                    queue.offer(new Integer[] {m,n});
                }
            }
        }
        if(check()) {System.out.println(0);}
        else {
            CNT=0;
            bfs();
            if (!check()) {System.out.println(-1);}
            else { System.out.println(CNT-1);}
        }
        
        
        
    }
    static boolean check() {
        for(int m=0; m<M; m++) {
            for(int n=0; n<N; n++){
                if(MAP[m][n]==0) {return false;}
            }
        }
        return true;
        
    }
    static void bfs() {
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int s=0;s<size; s++) {
                Integer front [] = queue.poll();
                int row = front[0];
                int col = front[1];
                for(int idx=0; idx<4; idx++) {
                    int nRow = row+DIR[idx][0];
                    int nCol = col+DIR[idx][1];
                    if(nRow>=0 && nRow<M && nCol>=0 && nCol<N && MAP[nRow][nCol]==0) {
                        MAP[nRow][nCol] = 1;
//                        System.out.println(nRow + " "+ nCol);
                        queue.offer(new Integer[] {nRow, nCol});
                    }
                }
                
            }CNT++;
            
        }
    }

}
