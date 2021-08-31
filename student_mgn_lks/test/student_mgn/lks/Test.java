package student_mgn.lks;

import student_mgn_lks.dao.StudentDaoTest;
import student_mgn_lks.dao.impl.StudentDaoImpl;
import student_mgn_lks.dto.Student;
import student_mgn_lks.dto.StudentInfo;

public class Test {

	public static void main(String[] argrs) {
		StudentInfo info = new StudentInfo(2, "아리랑", 70, 40, 60);
		// info.insertData();
		// info.updateData(40,70,50);
		// info.deleteData();

		// StudentDaoImpl.getInstance().updateStudent(info.getStd());
	}
}
