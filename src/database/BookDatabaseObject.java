package database;

public class BookDatabaseObject {
	long isbn;
	String title;
	String author;
	int quantity;
	
	public BookDatabaseObject(long isbn, String title, String author, int quantity) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.quantity = quantity;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
		
}
