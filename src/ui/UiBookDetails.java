package ui;

import java.awt.Color;
import javax.swing.*;
import models.*;

public class UiBookDetails extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextPane titlePane;
	private JTextPane authorPane;
	private JTextPane genrePane;
	private JTextPane isbnPane;
	private JTextField titleField;
	private JTextField authorField;
	private JTextField genreField;
	private JTextField isbnField;
	
	public UiBookDetails() {
		this.setLayout(null);
		this.setBounds(0, 0, 200, 200);
		
		titlePane = new JTextPane();
		authorPane = new JTextPane();
		genrePane = new JTextPane();
		isbnPane = new JTextPane();
		titleField = new JTextField();
		authorField = new JTextField();
		genreField = new JTextField();
		isbnField = new JTextField();

		titlePane.setBounds(10,  10, 200, 22);
		authorPane.setBounds(10,  60, 200, 22);
		genrePane.setBounds(10,  110, 200, 22);
		isbnPane.setBounds(10,  160, 200, 22);
		titleField.setBounds(10,  32, 200, 22);
		authorField.setBounds(10,  82, 200, 22);
		genreField.setBounds(10,  132, 200, 22);
		isbnField.setBounds(10,  182, 200, 22);

		titleField.setEditable(false);
		authorField.setEditable(false);
		genreField.setEditable(false);
		isbnField.setEditable(false);
		
		titlePane.setText("Title");
		authorPane.setText("Author");
		genrePane.setText("Genre");
		isbnPane.setText("ISBN");
		
		titlePane.setEditable(false);
		authorPane.setEditable(false);
		genrePane.setEditable(false);
		isbnPane.setEditable(false);
		
		titlePane.setBackground(Color.LIGHT_GRAY);
		authorPane.setBackground(Color.LIGHT_GRAY);
		genrePane.setBackground(Color.LIGHT_GRAY);
		isbnPane.setBackground(Color.LIGHT_GRAY);
		
		this.add(titlePane);
		this.add(authorPane);
		this.add(genrePane);
		this.add(isbnPane);
		
		this.add(titleField);
		this.add(authorField);
		this.add(genreField);
		this.add(isbnField);
	}
	
	public void showBook(Book book) {
		titleField.setText(book.getTitle());
		authorField.setText(book.getAuthor());
		genreField.setText(book.getGenre());
		isbnField.setText(book.getIsbn());
	}
}
