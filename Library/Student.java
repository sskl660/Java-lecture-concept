package yr2019jan02;

import java.util.*;

public class Student {//�л��� ���� ���� ����, ���. + �л����� ���� ���� ����.
	ArrayList<Integer> score = new ArrayList<>();
	Lend ld = new Lend();
	String dept, name;
	int id, year;
	int sNum;

	void read(Scanner scan) {
		dept = scan.next();
		id = scan.nextInt();
		name = scan.next();
		year = scan.nextInt();
		sNum = scan.nextInt();
		for (int i = 0; i < sNum; i++)
			score.add(scan.nextInt());
	}

	void print() {
		Library lib = Library.getInstance();
		System.out.printf("[%d] %s %s (%d�г�) - [%s]\n", id, name, dept, year, lib.join(score, ", "));
		if(ld.lend.size() == 0)
			return;
		System.out.printf("\t���� : %s\n", lib.join(ld.lend, ", "));
	}
	
	@Override
	public String toString() {
		return name;
	}
}
