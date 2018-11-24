package database;

public class BorrowDatabaseObject {
	int borrowid;
	String bookid;
	String librarianid;
	String studentid;
	String issuedate;
	String returndate;
	
	public BorrowDatabaseObject(int borrowid, String bookid, String librarianid, String studentid, String issuedate,
			String returndate) {
		super();
		this.borrowid = borrowid;
		this.bookid = bookid;
		this.librarianid = librarianid;
		this.studentid = studentid;
		this.issuedate = issuedate;
		this.returndate = returndate;
	}

	public int getBorrowid() {
		return borrowid;
	}

	public void setBorrowid(int borrowid) {
		this.borrowid = borrowid;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getLibrarianid() {
		return librarianid;
	}

	public void setLibrarianid(String librarianid) {
		this.librarianid = librarianid;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	
	
	
	
}
