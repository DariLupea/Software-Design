package dao;

import java.util.ArrayList;

import entities.Student;

public interface StudentInterface {

	public ArrayList<Student> getAllStudents();
	public void addStudent(Student student);
	public void deleteStudent(int id);
	public void updateStudent(int id, String address);
	
	
}
