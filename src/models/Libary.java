package models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ui.UiLibary;

public class Libary implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Book> books;
	private List<Customer> customers;

	public Libary() {
		books = new ArrayList<Book>();
		customers = new ArrayList<Customer>();

		Libary l = deserialize();
		if (l != null) {
			books = l.books;
			customers = l.customers;
		}
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void editBook(Book oldBook, Book newBook) {
		//warning! exemplars not changed
		oldBook.setId(newBook.getId());
		oldBook.setTitle(newBook.getTitle());
		oldBook.setAuthor(newBook.getAuthor());
		oldBook.setGenre(newBook.getGenre());
		oldBook.setIsbn(newBook.getIsbn());
	}
	
	public void removeBook(Book book) {
		books.remove(book);
	}
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public void editCustomer(Customer oldCustomer, Customer newCustomer) {
		oldCustomer.setId(newCustomer.getId());
		oldCustomer.setFirstName(oldCustomer.getFirstName());
		oldCustomer.setLastName(newCustomer.getLastName());
		oldCustomer.setMail(newCustomer.getMail());
		oldCustomer.setPhone(newCustomer.getPhone());
	}
	
	public void removeCustomer(Customer customer) {
		customers.remove(customer);
	}
	
	public int getHighestBookID() {
		int highestID = -1;
		
		for (Book book : books) {
			if (highestID < book.getId()) {
				highestID = book.getId();
			}
		}
		
		return highestID;
	}
	
	public int getHighestCustomerID() {
		int highestID = -1;
		
		for (Customer customer : customers) {
			if (highestID < customer.getId()) {
				highestID = customer.getId();
			}
		}
		
		return highestID;
	}

	public void serialize() {
		try
		{
			FileOutputStream fos = new FileOutputStream ("data.ser");
			@SuppressWarnings("resource")
			ObjectOutputStream oos = new ObjectOutputStream (fos);
			oos.writeObject(this);
		} catch(Exception ex) {
			UiLibary.showDialog("Fehler!", "Fehler beim Laden der Datei!");
		}
	}
	
	public Libary deserialize() {
		Libary dc = null;
		
		try {
			if (new File("data.ser").exists()) {
				FileInputStream fis = new FileInputStream("data.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				dc = (Libary)ois.readObject();
				ois.close();
				fis.close();
				return dc;
			} else {
				return null;
			}
		}
		catch(Exception e) {
			UiLibary.showDialog("Error", e.getMessage());
			return null;
		}
	}

	public static String fuehrendeNullen(String s, int length)
	{
	    while (s.length() < length) s = "0"+s;
	    return s;
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}
