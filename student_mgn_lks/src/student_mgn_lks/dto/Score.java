package student_mgn_lks.dto;

public class Score {
	int std_Id;
	int total_Score;
	float avg_Score;

	public Score(int std_Id, int total_Score, float avg_Score) {		
		this.std_Id = std_Id;
		this.total_Score = total_Score;
		this.avg_Score = avg_Score;
	}

	public Score() {
		// TODO Auto-generated constructor stub
	}

	public int getStd_Id() {
		return std_Id;
	}

	public void setStd_Id(int std_Id) {
		this.std_Id = std_Id;
	}

	public int getTotal_Score() {
		return total_Score;
	}

	public void setTotal_Score(int total_Score) {
		this.total_Score = total_Score;
	}

	public float getAvg_Score() {
		return avg_Score;
	}

	public void setAvg_Score(float avg_Score) {
		this.avg_Score = avg_Score;
	}

	@Override
	public String toString() {
		return "Score [std_Id=" + std_Id + ", total_Score=" + total_Score + ", avg_Score=" + avg_Score + "]";
	}

}
