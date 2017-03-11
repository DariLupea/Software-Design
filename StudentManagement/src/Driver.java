
import java.util.ArrayList;

import dao.StudentDAO;
import entities.Student;

public class Driver {

	public static void main(String[] args) {
		
		//To DO: -list the students enrolled on a given course
		//       -JUnit 
		StudentDAO studentDAO = new StudentDAO();
		ArrayList<Student> students;
		/*
		 * String url = "jdbc:mysql://localhost:3306/studentmanagement"; String
		 * user = "darilu44"; String password = "darilu44"; try { // get a
		 * connection to database Connection myConn =
		 * DriverManager.getConnection(url, user, password); // create a
		 * statement Statement myStat = myConn.createStatement(); ResultSet myRs
		 * = myStat.executeQuery("select * from student");
		 * 
		 * // execute sql query while (myRs.next()) {
		 * System.out.println(myRs.getString("studentName")); } // process the
		 * result set } catch (Exception e) { e.printStackTrace(); }
		 */
		
		
		/*Student student = new Student();
		student.setId(4);
		student.setName("dari");
		String date = "1995-08-25";
		java.sql.Date javaSqlDate = java.sql.Date.valueOf(date);
		student.setBirthDate(javaSqlDate);
		student.setAddress("Str. Florilor, nr. 40");
		try {
			status = studentDAO.addStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (status == true)
			System.out.println("Insert successfully!");
		else{
			System.out.println("Insert failed!");
		}
		
		try {
			students = studentDAO.getAllStudents();
			for (Student s: students){
				System.out.println(s.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*if (studentDAO.deleteStudent(2)) 
			System.out.println("success");
		else{
			System.out.println("failed");
		}
		try {
			students = studentDAO.getAllStudents();
			for (Student s: students){
				System.out.println(s.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
		studentDAO.updateStudent(4, "new address");
		try {
			students = studentDAO.getAllStudents();
			for (Student s: students){
				System.out.println(s.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
