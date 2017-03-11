package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Enrolment;

public class EnrolmentDAO implements EnrolmentInterface {

	/* READ all enrolments */
	@Override
	public ArrayList<Enrolment> getAllEnrolments() {
		ArrayList<Enrolment> enrolments = new ArrayList<>();
		try {
			String sql = "SELECT * FROM enrolment ORDER BY idEnrolment";
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// read student info from DB
				Enrolment enrolment = new Enrolment();
				enrolment.setId(rs.getInt("idEnrolment"));
				enrolment.setStudentId(rs.getInt("studentId"));
				enrolment.setCourseId(rs.getInt("courseId"));
				enrolment.setDate(rs.getDate("date"));
				enrolments.add(enrolment);
			}
			return enrolments;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/* INSERT operation */
	@Override
	public void addEnrolment(Enrolment enrolment) {
		try {
			String sql = "INSERT INTO enrolment(idEnrolment, studentId, courseId, date)" + "VALUES(?,?,?,?)";
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);

			ps.setInt(1, enrolment.getId());
			ps.setInt(2, enrolment.getStudentId());
			ps.setInt(3, enrolment.getCourseId());
			ps.setDate(4, enrolment.getDate());
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
	public void deleteEnrolment(int id) {
		String sql = "DELETE FROM enrolment WHERE idEnrolment=?";
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
	public void updateEnrolment(int id, Date date) {
		String sql = "UPDATE student set studentAddress=?  WHERE date=?";
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
			ps.setDate(1, date);
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
