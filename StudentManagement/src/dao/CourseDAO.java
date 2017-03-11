package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Course;

public class CourseDAO implements CourseInterface {

	/* READ all courses */
	@Override
	public ArrayList<Course> getAllCourses() {
		ArrayList<Course> courses = new ArrayList<>();
		try {
			String sql = "SELECT * FROM course ORDER BY idCourse";
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// read student info from DB
				Course course = new Course();
				course.setId(rs.getInt("idCourse"));
				course.setName(rs.getString("courseName"));
				course.setTeacher(rs.getString("courseTeacher"));
				course.setStudyYear(rs.getInt("courseStudyYear"));
				courses.add(course);
			}
			return courses;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/* INSERT operation */
	@Override
	public void addCourse(Course course) {
		try {
			String sql = "INSERT INTO course(idCourse, courseName, courseTeacher, courseStudyYear)" + "VALUES(?,?,?,?)";
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);

			ps.setInt(1, course.getId());
			ps.setString(2, course.getName());
			ps.setString(3, course.getTeacher());
			ps.setInt(4, course.getStudyYear());
			int status = ps.executeUpdate();
			if (status > 0)
				System.out.println("Insert successfully!");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insert failed!");
		}
	}

	/* DELETE operation */
	@Override
	public void deleteCourse(int id) {
		String sql = "DELETE FROM course WHERE idCourse=?";
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			int status = ps.executeUpdate();
			if (status > 0)
				System.out.println("Delete successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Delete failed!");
		}
	}

	/* UPDATE operation */
	@Override
	public void updateCourse(int id, String teacher) {
		String sql = "UPDATE course set courseTeacher=?  WHERE idCourse=?";
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
			ps.setString(1, teacher);
			ps.setInt(2, id);
			int status = ps.executeUpdate();
			if (status > 0)
				System.out.println("Update successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update failed!");

		}
	}
}
