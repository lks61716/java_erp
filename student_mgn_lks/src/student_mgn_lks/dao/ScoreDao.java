package student_mgn_lks.dao;

import java.util.ArrayList;

import student_mgn_lks.dto.Score;

public interface ScoreDao {
	ArrayList<Score> selectScoreByAll();
	
	Score selectScoreByNo(Score sc);
	
	int insertScore(Score sc);

	int updaeScore(Score sc);

	int deleteScore(Score sc);
}
