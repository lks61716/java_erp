package student_mgn_lks.dao;

import java.util.ArrayList;

import student_mgn_lks.dto.Student;

public interface StudentDao {
	ArrayList<Student> selectStudentByAll();

	Student selecStudentById(Student std);

	int insertStudent(Student std);

	int updateStudent(Student std);

	int deleteStudent(Student std);
}
