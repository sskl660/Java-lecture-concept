package task;

import java.util.*;

public class Student {
	Enroll enroll = null;
	String name, dept, phoneNum, code[];
	int id, grade, no;
	static int cnt = 0;

	void read(Scanner scan) {
		no = cnt + 1;
		cnt++;
		id = scan.nextInt();
		name = scan.next();
		dept = scan.next();
		grade = scan.nextInt();
		phoneNum = scan.next();
		code = scan.nextLine().trim().split(" ");
	}

	boolean checkProfessor(String professor) {
		return enroll.compareProfessor(professor);
	}

	void print() {
		System.out.printf("%d %s/%s/%d«–≥‚(%s)\n", id, name, dept, grade, phoneNum);
		if (enroll != null)
			enroll.print();
	}

	void setEnroll(Enroll en) {
		enroll = en;
	}

	@Override
	public String toString() {
		return name;
	}
}
