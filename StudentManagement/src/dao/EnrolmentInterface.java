package dao;

import java.sql.Date;
import java.util.ArrayList;

import entities.Enrolment;

public interface EnrolmentInterface {

	public ArrayList<Enrolment> getAllEnrolments();

	public void addEnrolment(Enrolment enrolment);

	public void deleteEnrolment(int id);

	public void updateEnrolment(int id, Date date);
}
