package task;

import java.util.Scanner;

public class Lecture {
	String code, title, professor, time;
	int stNum, no;
	static int cnt = 0;

	void read(Scanner scan) {
		no = cnt + 1;
		cnt++;
		code = scan.next();
		title = scan.next();
		stNum = scan.nextInt();
		professor = scan.next();
		time = scan.next();
	}

	boolean compare(String kwd) {
		if (code.contains(kwd))
			return true;
		if (time.contains(kwd))
			return true;
		if (professor.contains(kwd))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return title;
	}

	void print() {
		System.out.printf("%s %d / %s / %s %s\n", code, stNum, professor, time, title);
	}
}
