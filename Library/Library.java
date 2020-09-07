package yr2019jan02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Library {// 학생, 책의 정보를 저장, 관리. + 대출 기능 실행.
	ArrayList<Book> bList = new ArrayList<>();
	ArrayList<Student> stList = new ArrayList<>();
	ArrayList<Lend> lendList = new ArrayList<>();

	void doit() {
		readAllBook("book2.txt");
		printAllBooks();
		readAllStudents("students.txt");
		readlend("lend.txt");
		printAllStudents();
		printAllBooks();
		printLendBooks();
	}

	Scanner openFile(String filename) {
		Scanner scan = null;
		try {
			File file = new File(filename);
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return scan;
	}

	void readAllBook(String filename) {
		Scanner scan = openFile(filename);
		scan.nextLine();
		while (scan.hasNext()) {
			Book bk = new Book();
			bk.read(scan);
			bList.add(bk);
		}
		scan.close();
	}

	void readAllStudents(String filename) {
		Scanner scan = openFile(filename);
		scan.nextLine();
		while (scan.hasNext()) {
			Student st = new Student();
			st.read(scan);
			stList.add(st);
		}
		scan.close();
	}

	void readlend(String filename) {
		Scanner scan = openFile(filename);
		scan.nextLine();
		while (scan.hasNext()) {
			Lend ld = new Lend();
			ld.read(scan);
			lendList.add(ld);
		}
		System.out.println();
		scan.close();
	}

	Student findStudent(int id) {
		for (Student st : stList)
			if (id == st.id)
				return st;
		return null;
	}

	Book findBook(int no) {
		for (Book bk : bList)
			if (no == bk.no)
				return bk;
		return null;
	}

	void printAllBooks() {
		for (Book bk : bList)
			bk.print();
		System.out.println();
	}

	void printAllStudents() {
		for (Student st : stList)
			st.print();
		System.out.println();
	}

	void printLendBooks() {
		for (Book bk : bList) {
			if (bk.loan > 0) {
				System.out.printf("[ %d] %s -", bk.no, bk);
				ArrayList<Student> st = null;
				st = getLendStudents(bk);
				System.out.printf("%s", join(st, ", "));
				System.out.printf("(대출 %d, 재고 %d권)\n", bk.loan, bk.bVolumes);
			}
		}
	}

	String join(ArrayList<?> list, String sep) {
		String result = "";
		for (Object o : list) {
			if (result.length() > 0)
				result += sep + o;
			else
				result += o;
		}
		return result;
	}

	ArrayList<Student> getLendStudents(Book b) {
		ArrayList<Student> result = new ArrayList<>();
		for (Lend I : lendList)
			if (I.contains(b))
				result.add(I.st);
		return result;
	}

	public static Library getInstance() {
		if (lib == null)
			lib = new Library();
		return lib;
	}

	private static Library lib = null;

	public static void main(String[] args) {
		lib = getInstance();
		lib.doit();
	}
}
