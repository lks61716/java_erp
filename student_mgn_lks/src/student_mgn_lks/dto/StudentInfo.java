package student_mgn_lks.dto;

import java.util.ArrayList;

import student_mgn_lks.dao.StudentDao;
import student_mgn_lks.dao.impl.ScoreDaoImpl;
import student_mgn_lks.dao.impl.StudentDaoImpl;

public class StudentInfo {

	private Student std;
	private Score sc;

	public StudentInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentInfo(int std_id, String std_name, int kor, int eng, int math) {
		
		this.std = new Student(std_id,std_name,kor,eng,math);
		int total = kor+eng+math;
		float avg = (float)total/3f;
		this.sc = new Score(std_id,total,avg);
	}	
	public StudentInfo(int std_id) {
		this.std = new Student(std_id);
	}
	
	public Student getStd() {
		return std;
	}

	public void setStd(Student std) {
		this.std = std;
	}

	public Score getSc() {
		return sc;
	}

	public void setSc(Score sc) {
		this.sc = sc;
	}

	public void insertData() {
		StudentDaoImpl.getInstance().insertStudent(std);
		ScoreDaoImpl.getInstance().insertScore(sc);
	}
	public void updateData(int kor, int eng, int math) {		
		this.std.setKor(kor);
		this.std.setEng(eng);
		this.std.setMath(math);
		int total = kor+eng+math;
		float avg = (float)total/3f;
		this.sc = new Score(this.std.getStd_Id(),total,math);
		StudentDaoImpl.getInstance().updateStudent(std);
		ScoreDaoImpl.getInstance().updaeScore(sc);
	}
	public void deleteData() {
		StudentDaoImpl.getInstance().deleteStudent(std);
		ScoreDaoImpl.getInstance().deleteScore(sc);
	}
	public void printAllData() {
		ArrayList<Student> stdList = StudentDaoImpl.getInstance().selectStudentByAll();
		ArrayList<Score> scList = ScoreDaoImpl.getInstance().selectScoreByAll();
		int index = stdList.size();
		for(int i = 0; i<index; i++) {
			System.out.println(stdList.get(i)+", "+scList.get(i));
		}
	}
	public void printSelectedData() {
		Student s = StudentDaoImpl.getInstance().selecStudentById(std);
		Score c = ScoreDaoImpl.getInstance().selectScoreByNo(sc);
		System.out.println(s+", "+c);
	}

}
