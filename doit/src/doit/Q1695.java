/*
[문제]
앞에서 뒤로 보나, 뒤에서 앞으로 보나 같은 수열을 팰린드롬 이라고 한다. 
예를 들어 {1}, {1, 2, 1}, {1, 2, 2, 1}과 같은 수열은 팰린드롬 이지만, 
{1, 2, 3}, {1, 2, 3, 2} 등은 팰린드롬이 아니다.

한 수열이 주어졌을 때, 이 수열에 최소 개수의 수를 끼워 넣어 팰린드롬을 만들려고 한다. 
최소 몇 개의 수를 끼워 넣으면 되는지를 알아내는 프로그램을 작성하시오.

[입력]
첫째 줄에 수열의 길이 N(1≤N≤5,000)이 주어진다. 
다음 줄에는 N개의 수열을 이루는 수들이 주어진다. 각 수들은 int 범위이다.

ex)
5
1 2 3 4 2

[출력]
첫째 줄에 끼워 넣을 수들의 최소 개수를 출력한다.

ex)
2
*/

package doit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 테스트 케이스
class Test {

	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> case1(List<Integer> list) {

		list.clear();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(2);

		return list;
	}

	public List<Integer> case2(int N, List<Integer> list) {

		list.clear();

		for (int i = 0; i < N; i++) {
			int n = (int) (Math.random() * 10) + 1;
			list.add(n);
		}

		return list;
	}

	public int[] case1(int[] list) {
		int[] array = { 1, 2, 3, 4, 2 };

		return array;
	}
	
	public void result(int n, List<Integer> list){
		
		System.out.print(n + "차 결과 값 : { ");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println("}");
		
	}

}

public class Q1695 {

	public static void main(String[] args) {

		Test t = new Test();
		
		// ======= 2차시도 실패 ============

		Scanner sc = new Scanner(System.in);

		int N = 0;
		N = 12;
		// N = sc.nextInt();

		List<Integer> list = new ArrayList<Integer>();

		// for (int i = 0; i < N; i++) {
		// list.add(sc.nextInt());
		// }

		t.case2(N, list);

		t.result(0,list);

		int N0 = 0;
		int N1 = N - 1;
		int N2 = N - 1;


			if (list.get(N0) == list.get(N1)) {
				N0 += 1;
				N1 -= 1;
			}

			if (list.get(N0) != list.get(N1)) {

				int left = 0;
				int right = 0;
				int insert = 0;

				while (insert == 0) {
					if (list.get(N0) != list.get(N1 - left)) {
						left++;
						if (list.get(N0) == list.get(N1 - left)) {
							insert = left;
							right = 0;
							break;
						}
					}
					if (list.get(N0 + right) != list.get(N1)) {
						right++;
						if (list.get(N0 + right) == list.get(N1)) {
							insert = right;
							left = 0;
							break;
						}
					}
				}

				for (int j = 0; j < left; j++) {
					list.add(N0 + j, null);

				}
				for (int k = 0; k < right; k++) {
					list.add(N1 + 1 + k, null);
				}

				N0 = N0 + left;
				N1 = N1 + left;

				System.out.println("left : " + left);
				System.out.println("right : " + right);
				System.out.println("insert : " + insert);
				
			}

t.result(0, list);
		

		/*
		 * 
		 * // 1차시도 =================================
		 * 
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * int N = 0;
		 * 
		 * N = 6; // testcase
		 * 
		 * // N = sc.nextInt();
		 * 
		 * List<Integer> list = new ArrayList<Integer>();
		 * 
		 * // for (int i = 0; i < N; i++) { // list.add(sc.nextInt()); // }
		 * 
		 * // =====테스트 케이스 삽입======= // t.case1(list); t.case2(N, list);
		 * System.out.print("최초 수열 : { "); for (int i = 0; i < list.size(); i++) {
		 * System.out.print(list.get(i) + " "); } System.out.println("}");
		 * 
		 * // 문제풀이 시작===============================
		 * 
		 * int N0 = 0; int N1 = N - 1; int count = 0; System.out.println("N0 : " + N0 +
		 * ", N1 : " + N1);
		 * 
		 * while (true) {
		 * 
		 * if (list.get(N0) == list.get(N1) && (N0 == N1 || N1 - N0 == 1 || N1 - N0 ==
		 * (-1))) { break; } else if (list.get(N0) == list.get(N1)) { N0 += 1; N1 -= 1;
		 * } else if (list.get(N0) == list.get(N1 - 1)) { list.add(N0, list.get(N1)); N0
		 * += 1; count += 1; } else if (list.get(N0 + 1) == list.get(N1)) { list.add(N1
		 * + 1, list.get(N0)); N0 += 2; N1 -= 1; count += 1; } else { list.add(N1 + 1,
		 * list.get(N0)); N0 += 1; count += 1; } System.out.print("변경된 수열 : { "); for
		 * (int i = 0; i < list.size(); i++) { System.out.print(list.get(i) + " "); }
		 * System.out.println("}");
		 * 
		 * }
		 * 
		 * System.out.println("변경 횟수 : " + count);
		 * 
		 * // 틀림
		 * 
		 * 
		 */

	}	// main end
}		// class end
