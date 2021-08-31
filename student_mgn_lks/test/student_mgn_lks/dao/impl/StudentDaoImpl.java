package student_mgn_lks.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import student_mgn_lks.dao.StudentDao;
import student_mgn_lks.dto.Student;
import student_mgn_lks.util.JdbcUtill;

public class StudentDaoImpl implements StudentDao {

	private static final StudentDaoImpl instance = new StudentDaoImpl();

	public static StudentDaoImpl getInstance() {
		return instance;
	}

	public StudentDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Student> selectStudentByAll() {
		String sql = "select std_id, std_name, kor, eng, math from student";
		ArrayList<Student> stdList = null;
		try (Connection con = JdbcUtill.getConnection();
				PreparedStatement pre = con.prepareStatement(sql);
				ResultSet rs = pre.executeQuery()) {
			stdList = new ArrayList<Student>();
			while (rs.next()) {
				stdList.add(getStudent(rs));

			}
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return stdList;
	}

	@Override
	public Student selecStudentByName(Student std) {
		String sql = "select std_id, std_name, kor, eng, math from student where std_name = ?";

		try (Connection con = JdbcUtill.getConnection(); PreparedStatement pre = con.prepareStatement(sql);) {
			pre.setString(1, std.getStd_Name());
			try (ResultSet rs = pre.executeQuery()) {
				if (rs.next()) {
					return getStudent(rs);
				}
			}
		} catch (SQLException e) {
			System.err.println(e.toString());
		}

		return null;
	}

	@Override
	public int insertStudent(Student std) {
		String sql = "insert into student values(?,?,?,?,?)";

		try (Connection con = JdbcUtill.getConnection(); PreparedStatement pre = con.prepareStatement(sql);) {
			pre.setInt(1, std.getStd_Id());
			pre.setString(2, std.getStd_Name());
			pre.setInt(3, std.getKor());
			pre.setInt(4, std.getEng());
			pre.setInt(5, std.getMath());

			return pre.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.toString());
		}

		return 0;
	}

	@Override
	public int updateStudent(Student std) {
		String sql = "update student set kor = ?, eng = ?, math = ? where std_id = ?";

		try (Connection con = JdbcUtill.getConnection(); PreparedStatement pre = con.prepareStatement(sql);) {
			pre.setInt(1, std.getKor());
			pre.setInt(2, std.getEng());
			pre.setInt(3, std.getMath());
			pre.setInt(4, std.getStd_Id());

			return pre.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.toString());
		}

		return 0;
	}

	@Override
	public int deleteStudent(Student std) {
		String sql = "delete from student where std_id = ?";

		try (Connection con = JdbcUtill.getConnection(); PreparedStatement pre = con.prepareStatement(sql);) {
			pre.setInt(1, std.getStd_Id());			

			return pre.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.toString());
		}
		return 0;
	}

	private Student getStudent(ResultSet rs) throws SQLException {
		int std_Id = rs.getInt("std_id");
		String std_Name = rs.getString("std_name");
		int kor = rs.getInt("kor");
		int eng = rs.getInt("eng");
		int math = rs.getInt("math");

		return new Student(std_Id, std_Name, kor, eng, math);
	}
}
