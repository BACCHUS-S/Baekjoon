import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Algo2_서울_7반_배성현 {
	// bufferedrader 를 통해서 input을 받습니다.
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// br로 받은 input을 tokens을 통해서 쪼갭니다.
	static StringTokenizer tokens;
	// 연산에 쓰이는 m,n,cnt를 준비합니다.
	static int M,N,CNT;
	// 모든 점수를 기록하는 socre 이차 행렬을 선언합니다.
	static int SCORE[][];
	// class, 학생을 비교할 때 쓰이는 일차 행렬을 선언합니다.
	static int [] ClassCompare, StudentCompare;
	// combi해서 찾은 학생의 조합을 저장하는 list를 선언합니다.
	static List<Integer []> SCList;
	public static void main(String[] args) throws IOException {
		// StringTokenizer를 통해서 한 줄을 읽어오고
		tokens = new StringTokenizer(br.readLine(), " ");
		// 한 칸씩 input을 받습니다.
		M = Integer.parseInt(tokens.nextToken());
		// 한 칸씩 input을 받습니다.
		N = Integer.parseInt(tokens.nextToken());
		// score의 크기를 선언합니다.
		SCORE = new int[M][N];
		// 답을 초기화 시킵니다.
		CNT = 0;
		// score 한 줄씩 input 받습니다.
		for(int m=0; m<M; m++) {
			// StringTokenizer를 통해서 한 줄을 읽어오고
			tokens = new StringTokenizer(br.readLine(), " ");
			for(int n=0; n<N; n++) {
				// score 한 칸씩 input 받습니다.
				SCORE[m][n] = Integer.parseInt(tokens.nextToken());
			}
		}
		//SCList를 초기화 시킵니다. -> 순차탐색이므로 arraylist로 선언
		SCList = new ArrayList<Integer[]>();
		// StudentCompare는 무조건 크기가 2입니다.
		StudentCompare = new int[2];
		// 학생 조합 시작
		StudentCombi(0,0);
		// ClassCompare는 무조건 크기가 2입니다.
		ClassCompare = new int[2];
		// 학급 조합 시작
		ClassCombi(0,0);
		// 결과값을 나타냅니다.
		System.out.println(CNT);
		
		

	}
	static void ClassCombi(int cnt, int start) {
		// 크기가 2 일 때
		if(cnt==2) {
			// 찾은 조합이 조건에 부합하는 지 확인합니다.
			boolean FLAG = true;
			// A,B 둘로 나눕니다.
			int A = ClassCompare[0], B = ClassCompare[1];
			// SCList를 다 돌면서 하나씩 봅니다.
			for(int i=0; i<SCList.size(); i++) {
				// left 변수 초기화
				int left = SCList.get(i)[0];
				// right 변수 초기화
				int right = SCList.get(i)[1];
				// 조건 1에 부합하는지 확인합니다.
				if(SCORE[A][left] < SCORE[A][right]) {FLAG = (SCORE[B][left] < SCORE[B][right]);}
				// 조건 2에 부합하는지 확인합니다.
				else if(SCORE[A][left] > SCORE[A][right]) {FLAG = (SCORE[B][left] > SCORE[B][right]);} 		
				// 조건 3에 부합하는지 확인합니다.
				else {FLAG = (SCORE[B][left] == SCORE[B][right]);}
				// 조건에 부합하지 않으면 break;
				if(!FLAG)break;
			}
			// 조건에 부합하다면 cnt++해줍니다.
			if(FLAG)CNT++;
			return;
		}
		// 모든 조합의 경우를 보는 코드입니다.
		for(int idx=start; idx<M; idx++) {
			ClassCompare[cnt] = idx;
			ClassCombi(cnt+1,idx+1);
		}
	}
	
	static void StudentCombi(int cnt, int start) {
		// 학생의 수가 2가 되었을 때
		if(cnt==2) {
			// SCList에 학생 index를 집어 넣습니다.
			SCList.add(new Integer[] {StudentCompare[0], StudentCompare[1]});
			return;
		}
		// 모든 조합의 경우를 보는 코드입니다.
		for(int idx=start; idx<N; idx++) {
			StudentCompare[cnt] = idx;
			StudentCombi(cnt+1,idx+1);
		}
	}


}
