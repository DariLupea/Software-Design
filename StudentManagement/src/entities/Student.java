package entities;

import java.sql.Date;

public class Student {
	private int id;
	private String name;
	private Date birthDate;
	private String address;

	public Student() {
		super();
	}

	public Student(int id, String name, Date birthDate, String address) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", address=" + address + "]";
	}
	
}
