package ui;

import javax.swing.*;
import models.*;

public class UiCustomers extends JList<Customer> {
	private static final long serialVersionUID = 1L;
	private DefaultListModel<Customer> model;

	public UiCustomers() {
		this.setLayout(null);

		model = new DefaultListModel<>();
		this.setModel(model);
	}
	
	public void add(Customer customer) {
		model.addElement(customer);
	}
}