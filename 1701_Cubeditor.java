package com.ssafy.java.day32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b_1701_cubeditor {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String input;
	static int MAX = Integer.MIN_VALUE, length;
	public static void main(String[] args) throws IOException {
		input = br.readLine();
		length = input.length();
		for(int i=0; i< length; i++) {
			//MAX = Math.max(MAX, getMax(input.substring(i, length)));
			MAX = Math.max(MAX, getPi(input.substring(i, length)));
		}
		System.out.println(MAX);
	}
	
	static int getMax(String s) {
		int j = 0, n = s.length(), max = 0;
		int pi[] = new int[n];
		for(int i = 1; i < n; i++) {
			while(j > 0 && s.charAt(i) != s.charAt(j)) j = pi[j-1];
			if(s.charAt(i) == s.charAt(j)) {
				max = Math.max(max, pi[i] = ++j);
				System.out.println(Arrays.toString(pi));
			}
		}
		return max;
	}
	
	static int getPi(String pattern) {
		int patternLen = pattern.length();
		int [] pi = new int[patternLen];
		int begin=1, matched=0, max=0;
		while(begin+matched<=patternLen-1) {
			if(pattern.charAt(matched)==pattern.charAt(begin+matched)) {
				matched++;
				pi[begin+matched-1] = matched;
				max = Math.max(max, matched);
			}
			else {
				if(matched==0) begin++;
				else {
					begin = begin+matched-pi[matched-1];
					matched = pi[matched-1];
				}
			}
		}		
		return max;
	}
	

}
