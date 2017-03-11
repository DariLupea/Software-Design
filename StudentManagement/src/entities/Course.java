package entities;

public class Course {
	private int id;
	private String name;
	private String teacher;
	private int studyYear;

	public Course() {
		super();
	}

	public Course(int id, String name, String teacher, int studyYear) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.studyYear = studyYear;
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

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getStudyYear() {
		return studyYear;
	}

	public void setStudyYear(int studyYear) {
		this.studyYear = studyYear;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", teacher=" + teacher + ", studyYear=" + studyYear + "]";
	}

}
