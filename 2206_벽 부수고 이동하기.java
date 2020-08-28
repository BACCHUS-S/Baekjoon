import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int Answer,R,C;
	static char[][] map;
	static boolean visited[][][];
	static int DIR [][] = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());	
		map = new char[R][C];
		visited = new boolean[2][R][C];
		for(int r=0; r<R; r++) {
			map[r] = input.readLine().toCharArray();
		}		
		Answer = Integer.MAX_VALUE;
		
		// bfs 탐색
		bfs(0,0);
		// 목적지에 도착했다면 Answer가 갱신
		System.out.println(Answer == Integer.MAX_VALUE ? -1: Answer);
	}
	
	static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		Point start = new Point(r,c,0); // 출발 점은 언제나 공백입니다.
		q.offer(start);
		visited[0][r][c] = true;
		
		int depth = 1; // 첫번째 위치부터 count
		outer: while(!q.isEmpty()) {
			int size = q.size();
			while(--size>=0) {
				Point front = q.poll();
				if(front.r == R-1 && front.c==C-1) {
					Answer = depth;
					break outer;
				}
				for(int d=0; d<4; d++) {
					int nr = front.r + DIR[d][0];
					int nc = front.c + DIR[d][1];
					
					if(isIn(nr,nc)) {
						if(map[nr][nc]=='0') {
							if(!visited[front.breakCnt][nr][nc]) {
								visited[front.breakCnt][nr][nc] = true;
								q.offer(new Point(nr,nc,front.breakCnt));
							}
						}else {
							if(front.breakCnt==0 && !visited[1][nr][nc]) {
								visited[1][nr][nc] = true;
								q.offer(new Point(nr,nc,1));
							}
						}
					}
				}
			}
			depth++;
		}
	}
	static boolean isIn(int r, int c) {
		return 0<=r&& r<R && 0<=c && c<C;
	}
	
	
	static class Point{
		int r,c,breakCnt;

		public Point(int r, int c, int breakCnt) {
			super();
			this.r = r;
			this.c = c;
			this.breakCnt = breakCnt;
		}		
	}
	

}