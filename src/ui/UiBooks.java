package ui;

import javax.swing.*;
import models.Book;

public class UiBooks extends JList<Book> {
	private static final long serialVersionUID = 1L;
	private DefaultListModel<Book> model;

	public UiBooks() {
		this.setLayout(null);

		model = new DefaultListModel<>();
		this.setModel(model);
	}
	
	public void add(Book book) {
		model.addElement(book);
	}
}
