package database;

public class LibrarianDatabaseObject {
	String firstname;
	String lastname;
	String username;
	String address;
	String city;
	String state;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public LibrarianDatabaseObject(String firstname, String lastname, String username, String address, String city,
			String state) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.address = address;
		this.city = city;
		this.state = state;
	}	
		
}
