package com.ssafy.java.day27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Oakmok {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer tokens;
	static List<PNT> black, white;
	static boolean crossLowCheck[];
	static PNT temp;
	
	public static void main(String[] args) throws IOException {
		black = new LinkedList<>();
		white = new LinkedList<>();
		for(int r=0; r<19; r++) {
			tokens = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<19; c++) {
				int item = Integer.parseInt(tokens.nextToken());
				if(item != 0) {
					PNT pnt = new PNT(r+1,c+1);
					if(item == 1) black.add(pnt);
					else if(item == 2) white.add(pnt);
				}
			}
		}
//		for(PNT p: black) {
//			System.out.println(p);
//		}
		temp = CrossCheck(black); if(temp != null) sb.append("1\n").append(temp.r).append(" ").append(temp.c);
		temp = RowCheck(black); if(temp != null) sb.append("1\n").append(temp.r).append(" ").append(temp.c);
		temp = ColCheck(black); if(temp != null) sb.append("1\n").append(temp.r).append(" ").append(temp.c);
		temp = CrossCheck(white); if(temp != null) sb.append("2\n").append(temp.r).append(" ").append(temp.c);
		temp = RowCheck(white); if(temp != null) sb.append("2\n").append(temp.r).append(" ").append(temp.c);
		temp = ColCheck(white); if(temp != null) sb.append("2\n").append(temp.r).append(" ").append(temp.c);
		if(sb.toString().equals(""))sb.append("0");
		System.out.println(sb);
	}
	static PNT RowCheck(List<PNT> P) {
		Collections.sort(P, new Comparator<PNT>() {
			@Override
			public int compare(PNT o1, PNT o2) {
				if(o1.r==o2.r) {
					return Integer.compare(o1.c, o2.c);
				}else {
					return Integer.compare(o1.r, o2.r);
				}
			}
		});
		int cnt = 1, tempR=-1, tempC=-1;
		for(PNT p: P) {
			if(tempR != p.r || tempC+1 != p.c) {
				if(cnt==5) return new PNT(tempR,tempC-4);
				cnt=1; 
			}else cnt += 1;
			tempR=p.r; tempC=p.c;
		}
		if(cnt==5) return new PNT(tempR,tempC-4);
		return null;	
	}
	
	static PNT ColCheck(List<PNT> P) {
		Collections.sort(P, new Comparator<PNT>() {
			@Override
			public int compare(PNT o1, PNT o2) {
				if(o1.c==o2.c) {
					return Integer.compare(o1.r, o2.r);
				}else {
					return Integer.compare(o1.c, o2.c);
				}
			}
		});
		int cnt = 1, tempR=-1, tempC=-1;
		for(PNT p: P) {
			if(tempC != p.c || tempR+1 != p.r) {
				if(cnt==5) return new PNT(tempR-4,tempC);
				cnt=1;
			}else cnt += 1;
			tempR=p.r; tempC=p.c;
		}
		if(cnt==5) return new PNT(tempR-4,tempC);
		return null;
	}
	
	static PNT CrossCheck(List<PNT> P) {
		Collections.sort(P, new Comparator<PNT>() {
			@Override
			public int compare(PNT o1, PNT o2) {
				if(o1.c+o1.r==o2.c+o2.r) {
					return Integer.compare(o1.r, o2.r);
				}else {
					return Integer.compare(o1.c+o1.r, o2.c+o2.r);
				}
			}
		});
		// CrossHighCheck
		int cnt = 1, tempR=-1, tempS=-1;
		for(PNT p: P) {
			if(tempS != p.r+p.c || tempR+1 != p.r) {
				if(cnt==5) return new PNT(tempR,tempS-tempR);
				cnt=1; 
			}else cnt += 1;
			tempR=p.r; tempS=p.c+p.r;
		}
		if(cnt==5) return new PNT(tempR,tempS-tempR);
		
		// CrossLowCheck
		crossLowCheck = new boolean[P.size()];		
		for(int idx=0; idx<P.size(); idx++) {
			if(! crossLowCheck[idx]) {
				crossLowCheck[idx]=true;
				int cnt2 = 1,r=P.get(idx).r,c=P.get(idx).c;
				for(int idx2=idx+1; idx2<P.size(); idx2++) {
					if(P.get(idx2).r==r+1 && P.get(idx2).c==c+1 && !crossLowCheck[idx2]) {
						cnt2+=1;r+=1;c+=1;crossLowCheck[idx2]=true;
					}
				}
				if(cnt2==5) return new PNT(r-4,c-4);
			}
		}
		
		return null;
	}
	
	static PNT CrossLowCheck(List<PNT> P) {
		Collections.sort(P, new Comparator<PNT>() {
			@Override
			public int compare(PNT o1, PNT o2) {
				if(o1.c+o1.r==o2.c+o2.r) {
					return Integer.compare(o1.r, o2.r);
				}else {
					return Integer.compare(o1.c+o1.r, o2.c+o2.r);
				}
			}
		});
		crossLowCheck = new boolean[P.size()];		
		for(int idx=0; idx<P.size(); idx++) {
			if(! crossLowCheck[idx]) {
				crossLowCheck[idx]=true;
				int cnt = 1,r=P.get(idx).r,c=P.get(idx).c;
				for(int idx2=idx+1; idx2<P.size(); idx2++) {
					if(P.get(idx2).r==r+1 && P.get(idx2).c==c+1 && !crossLowCheck[idx2]) {
						cnt+=1;r+=1;c+=1;crossLowCheck[idx2]=true;
					}
				}
				if(cnt==5) return new PNT(r-4,c-4);
			}
		}
		return null;		
	}
	
	static class PNT{
		int r;
		int c;
		public PNT(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "PNT [r=" + r + ", c=" + c + "]";
		}
	}

}
