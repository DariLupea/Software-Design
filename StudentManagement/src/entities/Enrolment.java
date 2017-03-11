package entities;

import java.sql.Date;

public class Enrolment {

	private int id;
	private int studentId;
	private int courseId;
	private Date date;

	public Enrolment() {
		super();
	}

	public Enrolment(int id, int studentId, int courseId, Date date) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.courseId = courseId;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Enrolment [id=" + id + ", studentId=" + studentId + ", courseId=" + courseId + ", date=" + date + "]";
	}

	
}
