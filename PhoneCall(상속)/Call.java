package phonelog상속;

import java.util.Scanner;

public class Call {
	String phoneNum, time;
	int month, day , duration;
	int no;
	int charge;
	boolean accumulateDone = false;
	static int cnt = 0, sumDuration = 0, sumCharge = 0;

	void read(Scanner scan, String temp) {
		no = cnt + 1;
		cnt++;
		phoneNum = temp;
		month = scan.nextInt();
		day = scan.nextInt();
		time = scan.next();
		duration = scan.nextInt();
		computeCharge();
	}
	
	void computeCharge() {
		charge = duration * 3;
		sumDuration += duration;
		sumCharge += charge;
	}
	
	boolean compare(String kwd) {
		if(phoneNum.contains(kwd))
			return true;
		return false;
	}

	void print() {
		System.out.printf("[%2d] %s\t", no, phoneNum);
		if(phoneNum.length() < 10)
			System.out.print("\t");
		System.out.printf("%d/%d %s (%d초)", month, day, time, duration);
		printChargeType();
		System.out.println();
	}
	
	void printChargeType() {
	}
	
	void printTotalCharge() {
		System.out.printf("총 통화시간 %d초, 통화요금 %d원\n", sumDuration, sumCharge);
	}
}
