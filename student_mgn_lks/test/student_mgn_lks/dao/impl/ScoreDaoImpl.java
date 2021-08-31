package student_mgn_lks.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import student_mgn_lks.dao.ScoreDao;
import student_mgn_lks.dto.Score;
import student_mgn_lks.util.JdbcUtilTest;
import student_mgn_lks.util.JdbcUtill;

public class ScoreDaoImpl implements ScoreDao {

	private static final ScoreDaoImpl instance = new ScoreDaoImpl();

	public static ScoreDaoImpl getInstance() {
		return instance;
	}

	public ScoreDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public ArrayList<Score> selectScoreByAll() {
		String sql = "select total_score, avg_score from score";
		ArrayList<Score> scList = new ArrayList<Score>();
		try(Connection con = JdbcUtill.getConnection();
				PreparedStatement pre = con.prepareStatement(sql);
				ResultSet rs = pre.executeQuery();){
			while (rs.next()) {
				scList.add(getScore(rs));
			}
		}
		catch (SQLException e) {
			System.err.println(e.toString());
		}
		return scList;
	}

	@Override
	public Score selectScoreByNo(Score sc) {
		String aql = "select total_score, avg_score from score where std_id = ?";
		try(Connection con = JdbcUtill.getConnection();
				PreparedStatement pre = con.prepareStatement(aql);){
			pre.setInt(1, sc.getStd_Id());
			try(ResultSet rs = pre.executeQuery()){
				if(rs.next()) {
					return getScore(rs);
				}
			}
			
		}catch (SQLException e) {
			System.err.println(e.toString());
		}
		return null;
	}

	@Override
	public int insertScore(Score sc) {
		String sql = "insert into score values(?,?,?)";
		try(Connection con = JdbcUtill.getConnection();
				PreparedStatement pre = con.prepareStatement(sql);){
			pre.setInt(1, sc.getTotal_Score());
			pre.setFloat(2, sc.getAvg_Score());
			pre.setInt(3, sc.getStd_Id());
			return pre.executeUpdate();
		}
		catch (SQLException e) {
			System.err.println(e.toString());
		}
		return 0;
	}

	@Override
	public int updaeScore(Score sc) {
		String sql = "update score set total_score = ?, avg_score = ? where std_id = ?";
		try(Connection con = JdbcUtill.getConnection();
				PreparedStatement pre = con.prepareStatement(sql);){
			pre.setInt(1, sc.getTotal_Score());
			pre.setFloat(2, sc.getAvg_Score());
			pre.setInt(3, sc.getStd_Id());
			return pre.executeUpdate();
		}
		catch (SQLException e) {
			System.err.println(e.toString());
		}
		return 0;
	}

	@Override
	public int deleteScore(Score sc) {
		String sql = "delete from score where std_id = ?";
		try(Connection con = JdbcUtill.getConnection();
				PreparedStatement pre = con.prepareStatement(sql);){
			pre.setInt(1, sc.getStd_Id());			
			return pre.executeUpdate();
		}
		catch (SQLException e) {
			System.err.println(e.toString());
		}
		return 0;
	}

	private Score getScore(ResultSet re) throws SQLException {
		int id = re.getInt("std_id");
		int total = re.getInt("total_score");
		float avg = re.getFloat("avg_score");
		Score sc = new Score(id, total, avg);
		return sc;
	}

}
