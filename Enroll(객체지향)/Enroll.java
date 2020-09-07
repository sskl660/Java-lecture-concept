package task;

import java.util.*;

public class Enroll {
	Student user;
	ArrayList<Lecture> enrollList = new ArrayList<>();
	String days[] = { "��", "ȭ", "��", "��", "��" };
	String times[] = { "123", "678" };

	void enroll(Student st) {
		user = st;
		Manager mng = Manager.getInstance();
		Lecture lc = new Lecture();
		for (String cd : user.code) {
			lc = mng.findLecture(cd);
			if (lc == null)
				continue;
			else {
				enrollList.add(lc);
				user.setEnroll(this);
			}
		}
	}

	boolean compareProfessor(String professor) {
		for (Lecture enroll : enrollList)
			if (enroll.compare(professor))
				return true;
		return false;
	}

	void print() {
		Manager mng = Manager.getInstance();
		System.out.printf("��û���� :%s \n", mng.join(enrollList, ", "));
	}

	void printTimetable() {
		for (String d : days)
			for (String t : times) {
				int cnt = 0;
				for (Lecture l : enrollList)
					if (l.compare(d + t)) {
						cnt++;
						if (cnt == 1)
							System.out.printf("%s���� %s���� : ", d, t);
						System.out.printf("%s\n", l.title);
					}
			}
		System.out.println();
	}
}
