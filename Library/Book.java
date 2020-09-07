package yr2019jan02;

import java.util.*;

public class Book {// å�� ���� ���� ����, ���. + å���� ���� ���� ����.
	ArrayList<String> author = new ArrayList<>();
	String title, pub, isbn, location, type;
	int bookNum, year, bVolumes, no;
	int loan = 0;
	static int cnt = 0;

	void read(Scanner scan) {
		no = cnt + 1;
		cnt++;
		title = scan.next();
		pub = scan.next();
		bookNum = scan.nextInt();
		year = scan.nextInt();
		while (true) {
			String name = scan.next();
			if (name.equals("0"))
				break;
			author.add(name);
		}
		isbn = scan.next();
		bVolumes = scan.nextInt();
		location = scan.next();
		type = scan.next();
	}

	boolean checkStock() {
		if (bVolumes > 0) {
			bVolumes--;
			loan++;
			return true;
		}
		return false;
	}
	
	void print() {
		Library lib = Library.getInstance();
		System.out.printf("[ %d] %s, %s (%d) %d by %s [%s] ���� : ", no, title, pub, year, bookNum, location, type);
		System.out.printf("%s (%d��)\n", lib.join(author, ", "), bVolumes);
	}
	
	@Override
	public String toString() {
		return title;
	}
}
