package ssafy.java.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SafeArea {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, MIN, MAX, ANS;
    static int MAP[][];
    static int cMAP [][];
    static int DIR[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        N = Integer.parseInt(br.readLine());
        MAP = new int[N][N];
        MIN = Integer.MAX_VALUE; MAX = Integer.MIN_VALUE;
        ANS = 1;
        for(int r=0; r<N; r++) {
            tokens = new StringTokenizer(br.readLine(), " ");
            for(int c=0; c<N; c++) {
                MAP[r][c] = Integer.parseInt(tokens.nextToken());
                if (MAP[r][c] < MIN) {MIN = MAP[r][c];}
                if (MAP[r][c] > MAX) {MAX = MAP[r][c];}
            }
        }
        
//        for (int i[]: MAP) {
//            System.out.println(Arrays.toString(i));
//        }
        for(int depth=MIN; depth<MAX; depth++) {
//            System.out.println("depth : " + depth);
            cMAP = new int[N][N];
            for(int i=0; i<N; i++) {
                cMAP[i] = MAP[i].clone();
            }
//            for (int i[]: cMAP) {
//                System.out.println(Arrays.toString(i));
//            }
//            break;
            for(int r=0; r<N; r++) {
                for(int c=0; c<N; c++) {
                    if(cMAP[r][c] <= depth) {cMAP[r][c] = 0;}
                    else {cMAP[r][c] = 1;}
                }
            }
//              for (int i[]: cMAP) {
//              System.out.println(Arrays.toString(i));
//          }
            int cnt = 0;
            for(int r=0; r<N; r++) {
                for(int c=0; c<N; c++) {
                    if (cMAP[r][c]==1) {
                        dfs(r,c);
                        cnt++;
                    }
                    
                }
            }
            if (ANS < cnt) {ANS = cnt;}
            
        }
        System.out.println(ANS);
        

    }
    
    static void dfs(int row, int col) {
        cMAP[row][col] = 0;
        for(int i=0; i<4; i++) {
            int nRow = row+DIR[i][0];
            int nCol = col+DIR[i][1];
            if(nRow>=0 && nRow<N && nCol>=0 && nCol<N && cMAP[nRow][nCol] == 1) {
                dfs(nRow, nCol);
            }
        }
    }

}
