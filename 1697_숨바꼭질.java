package ssafy.java.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HidaandSeek {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int left, right, ans, CNT;
    static boolean FLAG;
    static boolean visited[];
    static Queue<Integer>queue;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        st = new StringTokenizer(br.readLine(), " ");
        left = Integer.parseInt(st.nextToken());
        right = Integer.parseInt(st.nextToken());
        CNT = 0;
        FLAG = false;
        queue = new LinkedList<Integer>();
        visited = new boolean[100001];
        bfs(left);
        System.out.println(CNT);
            

    }
    static void bfs(int start) {
        visited[start] = true;
        queue.offer(start);
        while(queue.size()!=0) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int temp = queue.poll();
                if(temp == right) {
                    FLAG = true;
                    break;
                }
                if(temp+1<=100000 && !visited[temp+1] && !FLAG) {queue.offer(temp+1);visited[temp+1] = true;}
                if(temp-1>=0 && !visited[temp-1] && !FLAG) {queue.offer(temp-1);visited[temp-1] = true;}
                if(temp*2<=100000 && !visited[temp*2] && !FLAG) {queue.offer(temp*2);visited[temp*2] = true;}
            }
            if(FLAG)break;
            CNT++;
        }
    }

}
