package javasecondlecture;
import java.util.*;
public class AnnualSales {
	static Random rand = new Random();
	static Scanner scan = new Scanner(System.in);
	static int sales[] = new int[12];//���� �⵵ �Ǹŷ��� ������ �迭 ����.
	static int prev[] = new int[12];//���� �⵵ �Ǹŷ��� ������ �迭 ����.
	static int inc[] = new int[12];//���⵵ ��� �Ǹŷ� ������ ������ �迭 ����.
	static double incR[] = new double[12];//���⵵ ��� �Ǹŷ� ������ ������ �迭 ����.
	static int annuals = 2001;//���� �⵵�� ������ ���� ����.
	int annual, monthMax, monthMin;
	double min, max;
	int cnt = 0;

	void doit() {
		if (annuals == 2001)//�ʱ�⵵�� �迭�� �������� �����Ƿ� �Ǹŷ� ���� �Լ��� ������.
			makeSales();
		generate();
		compute();
		print();
		annuals++;
	}

	void makeSales() {//ù��° �⵵ �Ǹŷ��� ����.
		for (int i = 0; i < 12; i++) {
			sales[i] = rand.nextInt(30) + 70;
		}
	}

	void generate() {//���� �⵵�� ����� ���� �⵵ �Ǹŷ��� ����.
		for (int i = 0; i < 12; i++) {
			prev[i] = sales[i];
			sales[i] = sales[i] + rand.nextInt(15) - 5;
			inc[i] = sales[i] - prev[i];
			incR[i] = (double) inc[i] / (double) prev[i] * 100;
		}
	}

	void compute() {//������ �ִ�, �ּ�
		for (double i : incR) {
			if (i > 0)
				cnt++;
		}
		min = incR[0];
		max = incR[0];
		for (int i = 0; i < 12; i++) {
			if (min >= incR[i]) {
				min = incR[i];
				monthMin = i + 1;
			}
			if (max <= incR[i]) {
				max = incR[i];
				monthMax = i + 1;
			}
		}
		annual = annuals;
	}

	void print() {
		System.out.print("[" + annuals + "]");
		for (int i : sales)
			System.out.print("\t" + i);
		System.out.println();
		if (annuals > 2001) {
			for (int i : inc)
				System.out.print("\t" + i);
			System.out.println();
			for (double i : incR)
				System.out.printf("\t%.1f", i);
			System.out.println();
			System.out.printf("������ �ּ� : %.1f (%d��)\n", min, monthMin);
			System.out.printf("������ �ִ� : %.1f (%d��)\n", max, monthMax);
		}
		System.out.println();
	}
}