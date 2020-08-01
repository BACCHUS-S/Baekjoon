import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(input.readLine());
        StringTokenizer tokens = new StringTokenizer(input.readLine(), " ");
        
        Stack<Tower> stack = new Stack<Tower>();
        for(int i=1; i<=N; i++) {
            //System.out.println("스택 상태 : "+stack);
            int newHeight = Integer.parseInt(tokens.nextToken());
            // 새로운 타워를 세울건데,.. 기존 타워가 더 작으면 버림
            while(!stack.isEmpty()) {
                if(stack.peek().height < newHeight) {
                    stack.pop();
                }else {
                    break;
                }
            }
            if(stack.isEmpty()) {
                sb.append("0 ");
            }else {
                sb.append(stack.peek().idx+" " );
            }
            // 새로운 타워 추가
            stack.push(new Tower(newHeight, i));
        }
        System.out.println(sb);
        
        // TODO Auto-generated method stub

    }
    static class Tower{
        int height, idx;
        public Tower(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Tower [height=").append(height).append(", idx=").append(idx)
                    .append("]");
            return builder.toString();
        }
        
    }
    
    static String src = "5\r\n" +  "6 9 5 7 4";

}
