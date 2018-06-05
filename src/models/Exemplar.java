package models;

import java.io.Serializable;

public class Exemplar extends Book implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Customer borrower;
	
	public Exemplar(int id, Book book) {
		super(book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getIsbn());
		
		this.id = id;
	}
	
	public String toString() {
		if (borrower != null) {
			return Libary.fuehrendeNullen(Integer.toString(id), 5) + " - " + borrower.toString();
		} else {
			return Libary.fuehrendeNullen(Integer.toString(id), 5);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getBorrower() {
		return borrower;
	}

	public void setBorrower(Customer borrower) {
		this.borrower = borrower;
	}
}
