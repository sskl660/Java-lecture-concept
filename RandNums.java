package randnums;

import java.util.*;

public class K김태현_RandNums {
	Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	ArrayList<Integer> array = new ArrayList<>();
	int num;
	int start, end;

	public static void main(String[] args) {
		K김태현_RandNums a = new K김태현_RandNums();
		a.doit();
	}

	void doit() {
		String choice;
		while (true) {
			input();
			makeRand();
			printArr();
			printEven();
			
			System.out.println("계속 하시려면 'y'를 입력하시오.(다른키 입력시 종료)");
			choice = scan.nextLine();
			choice = scan.nextLine();
			if (!choice.trim().equals("y"))
				break;
		}
	}

	void input() {
		System.out.print("난수 생성 개수 : ");
		num = scan.nextInt();
		System.out.print("시작 끝 값 : ");
		start = scan.nextInt();
		end = scan.nextInt();
	}

	void makeRand() {
		for (int i = 0; i < num; i++)
			array.add(i,rand.nextInt(end - start) + start);
	}

	void printArr() {
		System.out.print("배열\t[ ");
		for (int i = 0; i < num; i++) {
			System.out.print("\t" + array.get(i));
			if (i % 10 == 9)
				System.out.println();
		}
		System.out.println("]");
	}

	void printEven() {
		System.out.print("짝수\t[ ");
		int k = 0;
		for (int i = 0; i < num; i++) {
			if (array.get(i) % 2 == 0) {
				System.out.print("\t" + array.get(i));
				k++;
			}
				
			if(k % 10 == 0 && k != 0) {
				if(array.get(i) % 2 == 0) {
					System.out.println();
					k = 0;
				}
			}
			}
		System.out.println("]");
	}
}