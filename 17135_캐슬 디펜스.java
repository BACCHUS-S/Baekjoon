package ssafy.java.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Archer {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer tokens;
    
    static int N,M,D,MAX;
    static List<Integer []> enemy;
    static int ans[];
    static List<Integer []> erasePnt;
    static List<Integer []> tempPnt;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        tokens = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        D = Integer.parseInt(tokens.nextToken());
        enemy = new LinkedList<Integer[]>();
        ans = new int[3];
        MAX = Integer.MIN_VALUE;
        for(int row=0;row<N; row++) {
            tokens = new StringTokenizer(br.readLine(), " ");
            for(int col=0; col<M; col++) {
                int temp = Integer.parseInt(tokens.nextToken());
                if (temp == 1) {
                    enemy.add(new Integer[] {row, col});
                }
            }
        }
//        for(Integer [] ii: enemy) {
//            System.out.println(ii[0]+ " " + ii[1]);
//        }
        combi(0,0);
        System.out.println(MAX);
        // 궁수 배치는 combi로 해요

    }
    public static void combi(int cnt, int start) {
        if (cnt == 3) {
//            System.out.println(Arrays.toString(ans));
            // 궁수 3명이 가장 가까운 것들 index으로 찾아서 넣어보기
            List<Integer[]> copyEnemy = new LinkedList<Integer[]>();
            copyEnemy.addAll(enemy);
            int CNT = 0;
            while(true) {
                if(copyEnemy.size() == 0) {
                    break;
                }
                // 궁수가 맞추고
                erasePnt = new LinkedList<Integer[]>();
                for(int idx=0; idx<ans.length; idx++) {
                    int archerCol = ans[idx];
                    int archerRow = N;
                    int minLen = Integer.MAX_VALUE;
                    tempPnt = new LinkedList<Integer[]>();
                    
                    for(int i=0; i<copyEnemy.size(); i++){
                        Integer[] enemyPnt = copyEnemy.get(i);
                        int enemyCol = enemyPnt[1];
                        int enemyRow = enemyPnt[0];
                        int len = Math.abs(archerCol-enemyCol)+Math.abs(archerRow-enemyRow);
                        if(len<=D) {
                            if(len < minLen) {
                                minLen = len;
                                tempPnt = new LinkedList<Integer[]>();
                                tempPnt.add(new Integer[] {enemyRow, enemyCol, i});
                            }else if(len == minLen) {
                                tempPnt.add(new Integer[] {enemyRow, enemyCol, i});
                            }
                        }
                    }
                    Collections.sort(tempPnt, new Comparator<Integer[]>() {

                        @Override
                        public int compare(Integer[] o1, Integer[] o2) {
                            // TODO Auto-generated method stub
                            return Integer.compare(o1[1], o2[1]);
                    }});
                    if(tempPnt.size() !=0) {
                        erasePnt.add(tempPnt.remove(0));
                    }
                    
                }
                // 궁수가 맞춘 부분 삭제하기
                TreeSet<Integer> eraseSet;
                eraseSet = new TreeSet<>(new Comparator<Integer>() {

                    @Override
                    public int compare(Integer o1, Integer o2) {
                        // TODO Auto-generated method stub
                        return Integer.compare(o2, o1);
                    }});
                
                for(int idx=0; idx<erasePnt.size(); idx++) {
                    Integer [] info = erasePnt.get(idx);
                    eraseSet.add(info[2]);
                }
//                System.out.println("처음");
//                for(Integer [] ii: copyEnemy) {
//                    System.out.print("("+ ii[0]+ "," + ii[1]+")" +"\t");
//                }System.out.println();
//                System.out.println("과정");
                for(int eraseIdx: eraseSet) {
                    copyEnemy.remove(eraseIdx);
                    CNT++;
//                    for(Integer [] ii: copyEnemy) {
//                        System.out.print("("+ ii[0]+ "," + ii[1]+")" +"\t");
//                    }System.out.println();
                }
                
                
                
                // 한 칸 이동하기
                List<Integer[]> copyEnemy2 = new LinkedList<Integer[]>();
                for(int idx=0; idx<copyEnemy.size(); idx++) {
                    Integer[] point = copyEnemy.get(idx);
//                    System.out.println(point[0]+1);
                    if(point[0]+1 < N) {
                        copyEnemy2.add(new Integer[] {point[0]+1, point[1]});
                    }
                }
                copyEnemy = new LinkedList<Integer[]>();
                copyEnemy.addAll(copyEnemy2);
               
            }
//            System.out.println("CNT : " +CNT);
            if(MAX < CNT) {
                MAX = CNT;
            }
            
            
            return;
        }
        for(int idx=start; idx<M; idx++) {
            ans[cnt] = idx;
            combi(cnt+1,idx+1);
        }
    }

}
