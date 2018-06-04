package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String author;
	private String genre;
	private String isbn;
	private List<Exemplar> exemplars;
	
	public Book(int id, String title, String author, String genre, String isbn) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.isbn = isbn;
		exemplars = new ArrayList<Exemplar>();
	}
	
	public int getHighestExemplarID() {
		int highestID = -1;
		
		for (Exemplar exemplar : exemplars) {
			if (highestID < exemplar.getId()) {
				highestID = exemplar.getId();
			}
		}
		
		return highestID;
	}
	
	public String toString() {
		return title;
	}
	
	public boolean isValid() {
		return title.length() > 0 && author.length() > 0 && genre.length() > 0 && isbn.length() > 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<Exemplar> getExemplars() {
		return exemplars;
	}

	public void setExemplars(List<Exemplar> exemplars) {
		this.exemplars = exemplars;
	}
}