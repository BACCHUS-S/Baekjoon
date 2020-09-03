import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Algo3_서울_7반_배성현 {
	// BufferedReader 를 통해서 input을 받습니다.
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// br로 받은 input을 tokens을 통해서 쪼갭니다.
	static StringTokenizer tokens;
	// n,k,index,cnt,depth,ans를 초기화 시킵니다.
	static int N,K,INDEX,CNT,DEPTH,ANS;
	// 탐색했는지 확인하는 visited 배열을 선언합니다.
	static boolean visited[];
	// bfs에 쓸 LOC를 선언합니다.
	static Queue<Integer> LOC;
	public static void main(String[] args) throws IOException {
		// StringTokenizer를 통해서 한 줄을 읽어오고
		tokens = new StringTokenizer(br.readLine(), " ");
		// 한 칸씩 input을 받습니다.
		N = Integer.parseInt(tokens.nextToken());
		// 한 칸씩 input을 받습니다.
		K = Integer.parseInt(tokens.nextToken());
		// LOC를 Queue로 선언해줍니다.
		LOC = new LinkedList<Integer>();
		// bfs의 depth, 정답의 ans 갯수의 cnt를 초기화합니다.
		DEPTH=1;ANS=0;CNT=0;
		// 음수까지 생각해서 index를 지정합니다.
		INDEX = 100000000+100000;
		// visited를 초기화합니다.
		visited = new boolean[INDEX*2+1];
		// StringTokenizer를 통해서 한 줄을 읽어오고
		tokens = new StringTokenizer(br.readLine(), " ");
		for(int n=0; n<N; n++) {
			// 한 칸씩 input을 받습니다.
			int input = Integer.parseInt(tokens.nextToken());
			// input 값은 loc에 넣구
			LOC.offer(input);
			// 넣은 값들이 있는 곳에 true로 바꿉니다.
			visited[input+INDEX] = true;
		}
		//bfs를 실행하고
		bfs();
		//답을 꺼냅니다.
		System.out.println(ANS);
	}
	
	static void bfs() {
		// 끝났는 지 확인하는 변수 선언합니다.
		boolean endFlag = false;
		// loc 가 없을 때까지 돌립니다.
		while(!LOC.isEmpty()) {
			// depth를 확인하는 size 변수를 초기화 시킵니다.
			int size = LOC.size();
			// size가 0 이 될때까지
			while(--size>=0) {
				// front에서 꺼냅니다.
				int front = LOC.poll();
				// front보다 앞에 있는 것이 있다면 loc에 집어 넣구, ans와 cnt를 update합니다. 그리고 visited = true로 만들어줍니다.
				if(!visited[front+INDEX+1]) {LOC.offer(front+1); ANS+=DEPTH;CNT++;visited[front+INDEX+1]=true;}		
				// 조건이 만족하면 break;합니다.
				if(CNT==K) {endFlag = true; break;}
				// front보다 뒤에 있는 것이 있다면 loc에 집어 넣구, ans와 cnt를 update합니다. 그리고 visited = true로 만들어줍니다.
				if(!visited[front+INDEX-1]) {LOC.offer(front-1); ANS+=DEPTH;CNT++;visited[front+INDEX-1]=true;}
				// 조건이 만족하면 break;합니다.
				if(CNT==K) {endFlag = true; break;}
			}
			// 깊이를 1씩 추가시킵니다.
			DEPTH++;
			// 조건이 만족하면 break;합니다.
			if(endFlag)break;
		}
	}

}
