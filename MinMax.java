package minmax;

import java.util.*;

public class MinMax {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	int num, start, end;
	ArrayList<Integer> randArray = new ArrayList<>();
	int min, max;
	int tries = 0;
	int player;
	double avg, winneravg = 0;

	public static void main(String[] args) {
		MinMax m = new MinMax();
		m.doit();
	}

	void doit() {
		while (true) {
			input();// 값 입력 함수.
			if (num == 0 && tries == 1) {
				System.out.println("0을 입력하여 프로그램을 종료합니다.");
				break;
			}
			if (num == 0) {
				System.out.println("winner is [" + player + "]-th player!!");// 입력 값을 함수로 리턴 받아 0이라면 종료.
				break;
			}
			makeArray(num, end, start);// 난수 생성.
			max = computeMax();
			min = computeMin();
			avg = computeAvg();// 최대, 최소, 평균 계산. 재사용성을 위하여 일부러 세가지로 나눔.
			printArray();// 배열 출력.
		}
	}

	void input() {
		tries++;
		System.out.print("[" + tries + "] " + "난수 생성 개수 : ");
		num = scan.nextInt();
		if (num == 0)
			return;
		System.out.print("시작 끝 값 : ");
		start = scan.nextInt();
		end = scan.nextInt();
	}

	void makeArray(int num, int end, int start) {
		for (int i = 0; i < num; i++) {
			randArray.add(i,rand.nextInt(end - start) + start); 
		}
	}

	int computeMax() {
		int compare = randArray.get(0);
		for (int i = 0; i < num; i++) {
			if (compare < randArray.get(i))
				compare = randArray.get(i);
		}
		return compare;
	}

	int computeMin() {
		int compare = randArray.get(0);
		for (int i = 0; i < num; i++) {
			if (compare > randArray.get(i))
				compare = randArray.get(i);
		}
		return compare;
	}

	double computeAvg() {
		double sum = 0, avg;
		int cnt = 0;
		for (int i = 0; i < num; i++) {
			sum = sum + randArray.get(i);
			cnt++;
		}
		avg = sum / cnt;
		if (winneravg < avg) {
			winneravg = avg;
			player = tries;
		}
		return avg;
	}

	void printArray() {
		System.out.print("배열 [");
		for (int i = 0; i < num; i++) {
			System.out.print("\t" + randArray.get(i));
			if (i % 10 == 9)
				System.out.println();
		}
		System.out.println("]");// 배열 출력

		for (int i = 0; i < num; i++) {
			if (randArray.get(i) == max) {
				System.out.print("\t^^" + randArray.get(i));
				max = start - 1;
			} else if (randArray.get(i) == min) {
				System.out.print("\t__" + randArray.get(i));
				min = end + 1;
			} else
				System.out.print("\t" + randArray.get(i));
		} // 최대,최소가 적용된 배열 출력

		System.out.println("\t(avg " + avg + ")");// 평균 출력.
	}
}
