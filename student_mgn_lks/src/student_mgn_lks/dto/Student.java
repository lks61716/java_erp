package student_mgn_lks.dto;

public class Student {
	private int std_Id;
	private String std_Name;
	private int kor;
	private int eng;
	private int math;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int std_Id, String std_Name, int kor, int eng, int math) {		
		this.std_Id = std_Id;
		this.std_Name = std_Name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public Student(String std_Name, int kor, int eng, int math) {		
		this.std_Name = std_Name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public Student(String std_Name) {		
		this.std_Name = std_Name;
	}
	public Student(int std_Id) {		
		this.std_Id = std_Id;
	}
	public int getStd_Id() {
		return std_Id;
	}
	public void setStd_Id(int std_Id) {
		this.std_Id = std_Id;
	}
	public String getStd_Name() {
		return std_Name;
	}
	public void setStd_Name(String std_Name) {
		this.std_Name = std_Name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	@Override
	public String toString() {
		return "Student [std_Id=" + std_Id + ", std_Name=" + std_Name + ", kor=" + kor + ", eng=" + eng + ", math="
				+ math + "]";
	}
	
}
