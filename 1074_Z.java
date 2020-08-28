package com.ssafy.java.day27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,r,c,count;
	static int [] item;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		r = Integer.parseInt(tokens.nextToken());
		c = Integer.parseInt(tokens.nextToken());		
		search(0,0,2<<(N-1));
	}
	
	static void search(int x, int y, int n) {
		while(n > 0) {
            n /= 2; 
            if(r < x+n && c < y+n) {
                count += n * n * 0;
                System.out.println("1");
            }
            else if(r < x+n) {
                count += n * n * 1;
                y += n;
                System.out.println("2");
            }
            else if(c < y+n) {
                count += n * n * 2;
                x += n;
                System.out.println("3");
            }
            else {
                count += n * n * 3;
                x += n;
                y += n;
                System.out.println("4");
            }
            if(n == 1) {
                System.out.println(count);
                break;
            }
        }

    }

}
