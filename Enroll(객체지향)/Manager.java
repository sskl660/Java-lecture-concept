package task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Manager {
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> studentList = new ArrayList<>();
	ArrayList<Lecture> lectureList = new ArrayList<>();

	void doit() {
		readLectures("lecture-list.txt");
		readStudents("students2.txt");
		enrollStudents();
		menu();
	}

	Scanner openFile(String filename) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return sc;
	}

	void readStudents(String filename) {
		Scanner sc = openFile(filename);
		while (sc.hasNext()) {
			Student st = new Student();
			st.read(sc);
			studentList.add(st);
		}
		sc.close();
	}

	void readLectures(String filename) {
		Scanner sc = openFile(filename);
		while (sc.hasNext()) {
			Lecture lc = new Lecture();
			lc.read(sc);
			lectureList.add(lc);
		}
		sc.close();
	}

	void enrollStudents() {
		for (Student st : studentList) {
			Enroll en = new Enroll();
			en.enroll(st);
		}
	}

	void menu() {
		while (true) {
			System.out.print("(1)��ü�л� (2)��ü���� (3)�ð�ǥ�˻� (4)�������������˻� (5)�л��ð�ǥ��� (0)���� ");
			int menu = scan.nextInt();
			switch (menu) {
			case 1:
				printAllStudents();
				break;
			case 2:
				printAllLectures();
				break;
			case 3:
				searchTimetable();
				break;
			case 4:
				searchParticipant();
				break;
			case 5:
				searchStudentSchedule();
				break;
			default:
				return;
			}
		}
	}

	void printAllStudents() {
		int no = 1;
		for (Student st : studentList) {
			System.out.printf("(%2d) ", no);
			st.print();
			no++;
		}
		System.out.println();
	}

	void printAllLectures() {
		int no = 1;
		for (Lecture lc : lectureList) {
			System.out.printf("(%2d)", no);
			lc.print();
			no++;
		}
		System.out.println();
	}

	Lecture findLecture(String kwd) {
		for (Lecture lc : lectureList)
			if (lc.compare(kwd))
				return lc;
		return null;
	}

	void searchTimetable() {
		System.out.print("������ �Է��ϼ���(1 ~ 5) : ");
		int input = scan.nextInt() - 1;
		String days[] = { "��", "ȭ", "��", "��", "��" };
		int cnt = 0;
		for (Lecture lc : lectureList)
			if (lc.compare(days[input] + "123")) {
				cnt++;
				if (cnt == 1)
					System.out.printf("<%s���� ����>\n", days[input]);
				lc.print();
			}
		cnt = 0;
		for (Lecture lc : lectureList)
			if (lc.compare(days[input] + "678")) {
				cnt++;
				if (cnt == 1)
					System.out.printf("<%s���� ����>\n", days[input]);
				lc.print();
			}
		System.out.println();
	}

	void searchParticipant() {
		System.out.print("�������� �˰� ���� �������� �̸��� �Է� �ϼ��� : ");
		String professor = scan.next();
		for (Student st : studentList)
			if (st.checkProfessor(professor))
				System.out.printf("%s ", st);
		System.out.println();
	}

	void searchStudentSchedule() {
		System.out.print("�л� �̸��� �Է��ϼ��� : ");
		String stName = scan.next();
		for (Student st : studentList) {
			if (st.name.equals(stName))
				st.enroll.printTimetable();
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

	private static Manager mng;

	public static Manager getInstance() {
		if (mng == null)
			mng = new Manager();
		return mng;
	}

	public static void main(String[] args) {
		mng = getInstance();
		mng.doit();
	}
}
