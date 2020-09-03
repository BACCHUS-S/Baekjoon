package com.ssafy.java.day32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_1786_search {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer tokens;
	static String target, pattern;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		target = br.readLine();
		pattern = br.readLine();
		cnt=0;
		KMP();
		System.out.println(cnt);
		System.out.println(sb);
	}
	static void KMP() {
		int patternLen = pattern.length();
		int targetLen = target.length();
        int[] pi = getPi();
        int begin=0, matched=0;
        while(begin+patternLen<=targetLen) {
        	if(matched<patternLen && pattern.charAt(matched)==target.charAt(matched + begin)) {
        		matched++;
        		if(matched==patternLen) {cnt++;sb.append(begin+1).append(" ");}
        	}
        	else {
        		if(matched==0) begin++;
        		else {
        			begin = begin+matched-pi[matched-1];
        			matched=pi[matched-1];
        		}
        	}
        }
	}
	
	static int[] getPi() {
		int patternLen = pattern.length();
		int [] pi = new int[patternLen];
		int begin=1, matched=0;
		while(begin+matched<=patternLen-1) {
			if(pattern.charAt(matched)==pattern.charAt(begin+matched)) {
				matched++;
				pi[begin+matched-1] = matched;
			}
			else {
				if(matched==0) begin++;
				else {
					begin = begin+matched-pi[matched-1];
					matched = pi[matched-1];
				}
			}
		}		
		return pi;
	}
}