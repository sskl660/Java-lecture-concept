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
			System.out.print("(1)전체학생 (2)전체과목 (3)시간표검색 (4)교수별수강생검색 (5)학생시간표출력 (0)종료 ");
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
		System.out.print("요일을 입력하세요(1 ~ 5) : ");
		int input = scan.nextInt() - 1;
		String days[] = { "월", "화", "수", "목", "금" };
		int cnt = 0;
		for (Lecture lc : lectureList)
			if (lc.compare(days[input] + "123")) {
				cnt++;
				if (cnt == 1)
					System.out.printf("<%s요일 오전>\n", days[input]);
				lc.print();
			}
		cnt = 0;
		for (Lecture lc : lectureList)
			if (lc.compare(days[input] + "678")) {
				cnt++;
				if (cnt == 1)
					System.out.printf("<%s요일 오후>\n", days[input]);
				lc.print();
			}
		System.out.println();
	}

	void searchParticipant() {
		System.out.print("수강생을 알고 싶은 교수님의 이름을 입력 하세요 : ");
		String professor = scan.next();
		for (Student st : studentList)
			if (st.checkProfessor(professor))
				System.out.printf("%s ", st);
		System.out.println();
	}

	void searchStudentSchedule() {
		System.out.print("학생 이름을 입력하세요 : ");
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
