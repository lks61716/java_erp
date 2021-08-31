package student_mgn_lks.dto;

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

}
