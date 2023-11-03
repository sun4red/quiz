package doit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Q1920 {

	public static void main(String[] args) {

		/*
		 * ==================1차시도======================
		 * 
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * // 문제 생성 중...
		 * 
		 * int range = 2 * (int) Math.sqrt(31);
		 * 
		 * int N = 5; int M = 6;
		 * 
		 * N = sc.nextInt(); int[] A = new int[N]; for (int i = 0; i < N; i++) { A[i] =
		 * sc.nextInt(); }
		 * 
		 * int[] B = new int[M];
		 * 
		 * // A 난수 생성중.. for (int i = 0; i < A.length; i++) {
		 * 
		 * int r = (int) (Math.random() * range); int minus = (int) (Math.random() * 2);
		 * if (minus == 1) { r *= (-1); }
		 * 
		 * A[i] = r;
		 * 
		 * if (i > 0) { for (int j = 0; j < i; j++) {
		 * 
		 * if (A[j] == A[i]) { i--; } } } } // A 난수 생성 종료
		 * 
		 * for (int i = 0; i < A.length; i++) { System.out.println("A[" + i + "] : " +
		 * A[i]); }
		 * 
		 * System.out.println("===============");
		 * 
		 * // B 난수 생성중.. for (int i = 0; i < B.length; i++) {
		 * 
		 * int r = (int) (Math.random() * range); int minus = (int) (Math.random() * 2);
		 * if (minus == 1) { r *= (-1); }
		 * 
		 * B[i] = r;
		 * 
		 * if (i > 0) { for (int j = 0; j < i; j++) {
		 * 
		 * if (B[j] == B[i]) { i--; } } } } // B 난수 생성 종료
		 * 
		 * for (int i = 0; i < B.length; i++) { System.out.println("B[" + i + "] : " +
		 * B[i]); }
		 * 
		 * System.out.println("===============");
		 * 
		 * for (int i = 0; i < B.length; i++) { int check = 0; for (int j = 0; j <
		 * A.length; j++) { if (B[i] == A[j]) { check = 1; continue; } }
		 * System.out.println(check); }
		 * 
		 * }
		 * 
		 * ====================1차시도 실패===================
		 */

		/*
		 * ==================2차시도====================
		 * 
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * int N = 0; int M = 0;
		 * 
		 * 
		 * int range = (int)(Math.pow(2,31)-1); int [] A1 = new int [range]; int [] A2 =
		 * new int [range]; int [] A3 = new int [1];
		 * 
		 * System.out.println(range);
		 * 
		 * N = sc.nextInt();
		 * 
		 * for(int i = 0; i < N; i++) {
		 * 
		 * int n = sc.nextInt();
		 * 
		 * if(N>0) { A1[n] = 1; }else if(N<0) { A2[n*(-1)]=1; }else if(n==0) { A3[0] =
		 * 1; }
		 * 
		 * }
		 * 
		 * M = sc.nextInt();
		 * 
		 * for (int i = 0; i<M; i++) { int m = sc.nextInt(); if(m>0 && A1[m]==1) {
		 * System.out.println(1); }else if(m<0 && A2[m*(-1)]==1) {
		 * System.out.println(1); }else if(m==0 && A3[0] == 1) { System.out.println(1);
		 * }else { System.out.println(0); } }
		 * 
		 * =================2차시도 실패=====================
		 */

		// ===============3차시도===================

		/*
		 * 
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * int N = 100; int M = 100;
		 * 
		 * int count = 0; int ran = 10000;
		 * 
		 * // N = sc.nextInt();
		 * 
		 * int A[] = new int[N];
		 * 
		 * for (int i = 0; i < N; i++) { // A[i] = sc.nextInt(); A[i] = (int)
		 * (Math.random() * ran); System.out.println("A[" + i + "] = " + A[i]); }
		 * 
		 * for (int i = 0; i < A.length - 1; i++) { for (int j = 0; j < A.length; j++) {
		 * if (A[i] > A[j]) { int temp = A[i]; A[i] = A[j]; A[j] = A[i]; } } }
		 * 
		 * // M = sc.nextInt();
		 * 
		 * for (int i = 0; i < M; i++) { // int m = sc.nextInt(); int m = (int)
		 * (Math.random() * ran); System.out.println("m = " + m);
		 * 
		 * // ==================테스트 문제 생성 부분==================
		 * 
		 * 
		 * 
		 * int M0 = 0; int M1 = M - 1;
		 * 
		 * while (M0 != M1) {
		 * 
		 * // System.out.println("===================================="); //
		 * System.out.println("연산 실행 (M0 : " + M0 + ", M1 : " + M1); //
		 * System.out.println(" m = " + m);
		 * 
		 * if (A[(M0 + M1) / 2] == m) { System.out.println("결과 값 : " + 1); count++;
		 * break; } else if (A[(M0 + M1) / 2 + 1] == m) { System.out.println("결과 값 : " +
		 * 1); count++; break; } else if (A[(M0 + M1) / 2] < m) { M1 = (M0 + M1) / 2; }
		 * else if (A[(M0 + M1) / 2] > m) { M0 = (M0 + M1) / 2; }
		 * 
		 * if (M0 == M1 || M1 - M0 == 1) { System.out.println("결과 값 : " + 0); break; } }
		 * } System.out.println("count = " + count);
		 */

		// =============3차시도 실패=======================

		// ====================4차시도========================
		/*
		
		// 자료 생성

		int N = 0;
		int M = 0;

		Scanner sc = new Scanner(System.in);

		// N = sc.nextInt();
		N = 10;
		
		List<Integer> A = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			// A.add(sc.nextInt());
			A.add((int)(Math.random()*100)+1);
		}
		A.sort(null);

		
		 for (int i = 0; i<A.size(); i++ ) { System.out.println(A.get(i)); }
		
		
		// M = sc.nextInt();
		M = 10;
		
		for(int i = 0; i < M; i++) {

			// int m = sc.nextInt();
			int m = (int)(Math.random()*100)+1;
			
			int M0 = 0;
			int M1 = M-1;
			
			while(true) {
				
				if(m == A.get((M0+M1)/2) || m == A.get((M0+M1)/2+1)) {
					System.out.println(1);
					break;
				}else if(m > A.get((M0+M1)/2)) {
					M0 = (M0+M1)/2;
				}else if(m < A.get((M0+M1)/2)) {
					M1 = (M0+M1)/2;
				}

				if(M0 == M1 || M1 - M0 == 1) {
					System.out.println(0);
					break;
				}
			}
			
			
		}
		*/ //========================4차시도 실패========================

		// ================== 5차시도 ================
		
		int N = 0;
		int M = 0;
		Scanner sc = new Scanner(System.in);
		
		Map<Integer, Integer> A = new HashMap();
		
		N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
		A.put(sc.nextInt(), 1);
		}
		
		M = sc.nextInt();
		
		for(int i = 0; i < M; i++) {
			if(A.containsKey(sc.nextInt())){
				System.out.println(1);
			}else {
				System.out.println(0);
			}
			
			// ===============5차시도 성공 =========================
			
		}
		
	}
}
