package ssafy.java.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SnowWhite {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer tokens;
    static int dwarf[];
    static int realDwarf[];
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        dwarf = new int[9];
        realDwarf = new int[7];
        for(int i=0;i<9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
        }
        combi(0,0);
        System.out.println(sb);
    }
    
    static void combi(int cnt, int start) {
        if(cnt == 7) {
            int sum = 0;
            for(int rd: realDwarf) {
                sum += rd;
            }
            if(sum == 100) {
                Arrays.sort(realDwarf);
                for(int rd:realDwarf) {
                    sb.append(rd).append("\n");
                }
            }
            return;
        }
        for(int idx=start; idx<9; idx++) {
            realDwarf[cnt] = dwarf[idx];
            combi(cnt+1,idx+1);
        }
    }

}
