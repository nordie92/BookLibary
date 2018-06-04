package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String firstName;
	private String lastName;
	private String mail;
	private String phone;
	
	public Customer(int id, String firstName, String lastName, String mail, String phone) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.phone = phone;
	}
	
	public String toString() {
		return this.firstName + " " + this.lastName;
	}
	
	public boolean isValid() {
		return firstName.length() > 0 && lastName.length() > 0 && mail.length() > 0 && phone.length() > 0;
	}
	
	public List<Exemplar> lentBooks(List<Book> books) {
		List<Exemplar> retExemplar = new ArrayList<Exemplar>();
		
		for (Exemplar exemplar : retExemplar) {
			if (exemplar.getBorrower().equals(this)) {
				retExemplar.add(exemplar);
			}
		}
		
		return retExemplar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
