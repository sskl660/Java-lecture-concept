package randnums;

import java.util.*;

public class K������_RandNums {
	Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	ArrayList<Integer> array = new ArrayList<>();
	int num;
	int start, end;

	public static void main(String[] args) {
		K������_RandNums a = new K������_RandNums();
		a.doit();
	}

	void doit() {
		String choice;
		while (true) {
			input();
			makeRand();
			printArr();
			printEven();
			
			System.out.println("��� �Ͻ÷��� 'y'�� �Է��Ͻÿ�.(�ٸ�Ű �Է½� ����)");
			choice = scan.nextLine();
			choice = scan.nextLine();
			if (!choice.trim().equals("y"))
				break;
		}
	}

	void input() {
		System.out.print("���� ���� ���� : ");
		num = scan.nextInt();
		System.out.print("���� �� �� : ");
		start = scan.nextInt();
		end = scan.nextInt();
	}

	void makeRand() {
		for (int i = 0; i < num; i++)
			array.add(i,rand.nextInt(end - start) + start);
	}

	void printArr() {
		System.out.print("�迭\t[ ");
		for (int i = 0; i < num; i++) {
			System.out.print("\t" + array.get(i));
			if (i % 10 == 9)
				System.out.println();
		}
		System.out.println("]");
	}

	void printEven() {
		System.out.print("¦��\t[ ");
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