package yr2019jan02;

import java.util.*;//대출 정보를 생성, 출력.

public class Lend {
	Student st;
	ArrayList<Book> lend = new ArrayList<>();

	void read(Scanner scan) {
		Library lib = Library.getInstance();
		int stId = scan.nextInt();
		st = lib.findStudent(stId);
		if (st == null) {
			scan.nextLine();
			return;
		}
		Book bk = new Book();
		int lendNum = scan.nextInt();
		int bookNo;
		for (int i = 0; i < lendNum; i++) {
			bookNo = scan.nextInt();
			bk = lib.findBook(bookNo);
			if (bk.checkStock()) {
				lend.add(bk);
				st.ld = this;
			} else
				System.out.printf("%s - %s : 재고가 없습니다.\n", st.name, bk.title);
		}
	}

	boolean contains(Book bk) {
		for (Book b : lend)
			if (b == bk)
				return true;
		return false;
	}
}
