package yr2019jan02;

import java.util.*;

public class Student {//학생에 대한 정보 생성, 출력. + 학생마다 대출 정보 보유.
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
		System.out.printf("[%d] %s %s (%d학년) - [%s]\n", id, name, dept, year, lib.join(score, ", "));
		if(ld.lend.size() == 0)
			return;
		System.out.printf("\t대출 : %s\n", lib.join(ld.lend, ", "));
	}
	
	@Override
	public String toString() {
		return name;
	}
}
