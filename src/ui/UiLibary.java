package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import models.*;

public class UiLibary extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabPanel;
	private JSplitPane bookSplitPanel;
	private UiBooks bookList;
	private UiBookDetails bookDetails;
	private JSplitPane customerSplitPanel;
	private UiCustomers customerList;
	private UiExemplars exemplarsList;
	private UiCustomerDetails customerDetails;
	private JButton btnAddBook;
	private JButton btnAddExemplar;
	private JButton btnAddCustomer;

	public UiLibary(Libary libary) {
		tabPanel = new JTabbedPane();
		bookSplitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		bookList = new UiBooks();
		bookDetails = new UiBookDetails();
		customerSplitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		customerList = new UiCustomers();
		customerDetails = new UiCustomerDetails();
		exemplarsList = new UiExemplars();

		this.getContentPane().setLayout(null);
		this.setBounds(100, 100, 525, 565);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ########## book ##########
		//set ui
		tabPanel.setBounds(0, 0, 500, 500);
		bookSplitPanel.setLeftComponent(new UiBookAndExeplarContainer(bookDetails, exemplarsList));
		bookSplitPanel.setRightComponent(new JScrollPane(bookList));
		bookSplitPanel.setDividerLocation(220);
		customerSplitPanel.setLeftComponent(customerDetails);
		customerSplitPanel.setRightComponent(customerList);
		customerSplitPanel.setDividerLocation(220);
		tabPanel.addTab("Books", null, bookSplitPanel, null);
		tabPanel.addTab("Customers", null, customerSplitPanel, null);
		this.getContentPane().add(tabPanel);
		

		//add add-book button
		btnAddBook = new JButton("New book");
		btnAddBook.setBounds(410, 505, 90, 20);
		btnAddBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UiBook newBook = new UiBook();
				Book b = new Book(libary.getHighestBookID() + 1,
						newBook.getTfTitle().getText(),
						newBook.getTfAutor().getText(),
						newBook.getTfGenre().getText(),
						newBook.getTfISBN().getText());
				if (b.isValid()) {
					libary.addBook(b);
					bookList.add(b);
					libary.serialize();
				} else {
					showDialog("Error", "Inputs not valid!");
				}
			}
		});
		this.add(btnAddBook);

		//mouseClickEvent at bookList
		bookList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				int index = bookList.locationToIndex(evt.getPoint());
				Book book = bookList.getModel().getElementAt(index);
				bookDetails.showBook(book);
				exemplarsList.setExemplars(book.getExemplars());
			}
		});

		//add books to bookList
		for (Book book : libary.getBooks()) {
			bookList.add(book);
		}

		// ########## customer ##########
		//add add-customer button
		btnAddCustomer = new JButton("New customer");
		btnAddCustomer.setBounds(380, 505, 120, 20);
		btnAddCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UiCustomer newCustomer = new UiCustomer();
				Customer c = new Customer(libary.getHighestCustomerID() + 1,
						newCustomer.getFirstName(),
						newCustomer.getLastName(),
						newCustomer.getMail(),
						newCustomer.getPhone());
				if (c.isValid()) {
					libary.addCustomer(c);
					customerList.add(c);
					libary.serialize();
				} else {
					showDialog("Error", "Inputs not valid!");
				}
			}
		});
		this.add(btnAddCustomer);
		btnAddCustomer.setVisible(false);

		//mouseClickEvent at customerist
		customerList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				int index = customerList.locationToIndex(evt.getPoint());
				Customer customer = customerList.getModel().getElementAt(index);
				customerDetails.setFirstName(customer.getFirstName());
				customerDetails.setLastName(customer.getLastName());
				customerDetails.setMail(customer.getMail());
				customerDetails.setPhone(customer.getPhone());
			}
		});
		
		//add customer to customerList
		for (Customer customer : libary.getCustomers()) {
			customerList.add(customer);
		}

		// ########## exemplar ##########
		//add add-exemplar button
		btnAddExemplar = new JButton("New exemplar");
		btnAddExemplar.setBounds(100, 505, 120, 20);
		btnAddExemplar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Book selectedBook = bookList.getSelectedValue();
				if (selectedBook != null) {
					Exemplar newExemplar = new Exemplar(selectedBook.getHighestExemplarID() + 1, selectedBook);
					selectedBook.getExemplars().add(newExemplar);
					exemplarsList.add(newExemplar);
					libary.serialize();
				}
			}
		});
		this.add(btnAddExemplar);

		//lend exemplar
		exemplarsList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				int index = exemplarsList.locationToIndex(evt.getPoint());
				Exemplar exemplar = exemplarsList.getModel().getElementAt(index);
				UiExemplar newExemplar = new UiExemplar(exemplar, exemplar, libary.getCustomers());
				exemplar.setBorrower(newExemplar.getBorrower());
				libary.serialize();
			}
		});

		// ########## other ui stuff ##########
		//set button visibility relative to tabWindow
		tabPanel.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
            	btnAddBook.setVisible(tabPanel.getSelectedIndex() == 0);
            	btnAddExemplar.setVisible(tabPanel.getSelectedIndex() == 0);
            	btnAddCustomer.setVisible(tabPanel.getSelectedIndex() == 1);
	        }
	    });
		
		this.setVisible(true);
	}
	
	public static void showDialog(String header, String text) {
	    JDialog errorDialog = new JDialog();
	    errorDialog.setTitle(header);
	    errorDialog.setSize(500,100);
	    errorDialog.setModal(true);
	    errorDialog.add(new JLabel(text));
	    errorDialog.setVisible(true);
	}
}
