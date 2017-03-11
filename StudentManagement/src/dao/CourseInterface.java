package dao;

import java.util.ArrayList;

import entities.Course;

public interface CourseInterface {

	public ArrayList<Course> getAllCourses();

	public void addCourse(Course course);

	public void deleteCourse(int id);

	public void updateCourse(int id, String teacher);
}
