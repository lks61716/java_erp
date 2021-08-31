package student_mgn_lks.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import student_mgn_lks.dao.impl.StudentDaoImpl;
import student_mgn_lks.dto.Student;

public class StudentDaoTest {

	private StudentDao dao;

	@BeforeEach
	public void setUp() throws Exception {
		dao = StudentDaoImpl.getInstance();
	}

	@AfterEach
	public void tearDown() throws Exception {
		System.out.println();
		dao = null;
	}

	@Test
	public void test01SelectStudentByAll() {
		System.out.println("test01SelectStudentByAll");
		ArrayList<Student> stdList = dao.selectStudentByAll();
		Assert.assertNotEquals(0, stdList.size());
		stdList.stream().forEach(System.out::println);
	}

	@Test
	public void test01SelectStudentByName() {
		System.out.println("test01SelectStudentByName");
		Student std = dao.selecStudentById(new Student(1));
		System.out.println(std);
	}

	@Test
	public void test02InsertStudent() {
		System.out.println("test02InsertStudent");
		int res = dao.insertStudent(new Student(1, "권지용", 70, 80, 60));
		Assert.assertEquals(0, res);
		System.out.println("res >> " + res);

	}

	@Test
	public void test03UpdateStudentByName() {
		System.out.println("test03UpdateStudent");
		int res = dao.updateStudent(new Student("권지용", 50, 60, 30));
		Assert.assertEquals(0, res);
		System.out.println("res >> " + res);
	}

	@Test
	public void test04DeleteStudentById() {
		System.out.println("test04DeleteStudent");
		int res = dao.deleteStudent(new Student(1));
		Assert.assertEquals(0, res);
		System.out.println("res >> " + res);
	}
}
