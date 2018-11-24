package database;

public class StudentDatabaseObject {
	String studentid;
	String firstname;
	String lastname;
	int semester;
	String department;
	int booksborrowed;
	
	public StudentDatabaseObject(String studentid, String firstname, String lastname, int semester, String department,
			int booksborrowed) {
		super();
		this.studentid = studentid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.semester = semester;
		this.department = department;
		this.booksborrowed = booksborrowed;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getBooksborrowed() {
		return booksborrowed;
	}

	public void setBooksborrowed(int booksborrowed) {
		this.booksborrowed = booksborrowed;
	}
	
	
}
