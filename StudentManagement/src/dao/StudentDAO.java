package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Student;

public class StudentDAO implements StudentInterface {

	/* READ all students */
	@Override
	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> students = new ArrayList<>();
		try {
			String sql = "SELECT * FROM student ORDER BY idStudent";
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// read student info from DB
				Student student = new Student();
				student.setId(rs.getInt("idStudent"));
				student.setName(rs.getString("studentName"));
				student.setAddress(rs.getString("studentAddress"));
				student.setBirthDate(rs.getDate("studentBirthDate"));
				students.add(student);
			}
			return students;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/* INSERT operation */
	@Override
	public void addStudent(Student student) {
		try {
			String sql = "INSERT INTO student(idStudent, studentName, studentBirthDate, studentAddress)"
					+ "VALUES(?,?,?,?)";
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);

			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setDate(3, student.getBirthDate());
			ps.setString(4, student.getAddress());
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
	public void deleteStudent(int id) {
		String sql = "DELETE FROM student WHERE idStudent=?";
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
	public void updateStudent(int id, String address) {
		String sql = "UPDATE student set studentAddress=?  WHERE idStudent=?";
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
			ps.setString(1, address);
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
