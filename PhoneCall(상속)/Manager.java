package phonelog상속;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	Scanner scan = new Scanner(System.in);
	ArrayList<Call> phonelog = new ArrayList<>();

	void doit() {
		readAllCalls();
		printPhonelog();
		printTotalCharge();
		searchPhoneNum();
	}

	void readAllCalls() {
		Scanner scan = null;
		try {
			scan = new Scanner(new File("calls2.txt"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		Call call = null;
		while (scan.hasNext()) {
			String temp = scan.next();
			if (temp.contains("1588"))
				call = new FreeCall();
			else if (temp.contains("010-3333-4444"))
				call = new SaleCall();
			else if (temp.contains("010-3456-1357"))
				call = new SaleCall();
			else
				call = new Call();
			call.read(scan, temp);
			phonelog.add(call);
		}
		scan.close();
	}

	void printPhonelog() {
		for (Call record : phonelog)
			record.print();
	}

	void printTotalCharge() {
		Call total = new Call();
		total.printTotalCharge();
		for (Call log : phonelog)
			if (log instanceof SaleCall)
				if (((SaleCall) log).accumulateDone)
					((SaleCall) log).printTotalSale();
		System.out.println();
	}

	void searchPhoneNum() {
		while (true) {
			System.out.print("검색 키워드(종료는 0 입력) : ");
			String input = scan.next();
			if (input.equals("0"))
				break;
			int existcnt = 0;
			for (Call record : phonelog)
				if (record.compare(input)) {
					record.print();
					existcnt++;
				}
			if (existcnt == 0)
				System.out.println("검색 결과가 없습니다.");
		}
	}

	ArrayList<Call> findOverlapLog(String record) {
		ArrayList<Call> overlapLog = new ArrayList<>();
		for (Call list : phonelog)
			if (list.compare(record))
				overlapLog.add(list);
		return overlapLog;
	}

	public static Manager getInstance() {
		if (mng == null)
			mng = new Manager();
		return mng;
	}

	private static Manager mng = null;

	public static void main(String[] args) {
		mng = getInstance();
		mng.doit();
	}
}
