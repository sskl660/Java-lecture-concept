package javasecondlecture;
import java.util.*;
public class AnnualSales {
	static Random rand = new Random();
	static Scanner scan = new Scanner(System.in);
	static int sales[] = new int[12];//현재 년도 판매량을 저장할 배열 생성.
	static int prev[] = new int[12];//이전 년도 판매량을 저장할 배열 생성.
	static int inc[] = new int[12];//전년도 대비 판매량 증가를 저장할 배열 생성.
	static double incR[] = new double[12];//전년도 대비 판매량 즐가율을 저장할 배열 생성.
	static int annuals = 2001;//현재 년도를 저장할 변수 생성.
	int annual, monthMax, monthMin;
	double min, max;
	int cnt = 0;

	void doit() {
		if (annuals == 2001)//초기년도는 배열이 존재하지 않으므로 판매량 생산 함수를 돌린다.
			makeSales();
		generate();
		compute();
		print();
		annuals++;
	}

	void makeSales() {//첫번째 년도 판매량을 생성.
		for (int i = 0; i < 12; i++) {
			sales[i] = rand.nextInt(30) + 70;
		}
	}

	void generate() {//이전 년도에 대비해 다음 년도 판매량을 생성.
		for (int i = 0; i < 12; i++) {
			prev[i] = sales[i];
			sales[i] = sales[i] + rand.nextInt(15) - 5;
			inc[i] = sales[i] - prev[i];
			incR[i] = (double) inc[i] / (double) prev[i] * 100;
		}
	}

	void compute() {//증감률 최대, 최소
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
			System.out.printf("증감율 최소 : %.1f (%d월)\n", min, monthMin);
			System.out.printf("증감율 최대 : %.1f (%d월)\n", max, monthMax);
		}
		System.out.println();
	}
}