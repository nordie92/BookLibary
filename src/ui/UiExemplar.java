package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import models.*;

public class UiExemplar extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel panel = new JPanel();
	private JLabel lbTitle = new JLabel("Title:");
	private JLabel lbLendCustomer = new JLabel("Borrower:");
	private JTextField tfTitle = new JTextField("", 20);
	private JButton btnSave = new JButton("Verleihen");
	private JComboBox<Customer> comboBox = new JComboBox<Customer>();
	private List<Customer> customers = new ArrayList<Customer>();
	private Customer borrower;
	
	public UiExemplar(Book book, Exemplar exemplar, List<Customer> costumers) {
		super();
		this.customers = costumers; 
		
		setModal(true);
		this.setTitle("Lend exemplar");
		this.setSize(300, 137);
		this.setResizable(false);
		
		InitComponents();
		
		tfTitle.setText(book.getTitle());
		
		//add customers
		for (Customer customer : customers) {
			comboBox.addItem(customer);
		}
		Customer noneCustomer = new Customer(1, "None", "", "", "");
		comboBox.addItem(noneCustomer);
		
		//set borrowed customer 
		if (exemplar != null) {
			if (exemplar.getBorrower() != null) {
				comboBox.setSelectedItem(exemplar.getBorrower());
			} else {
				comboBox.setSelectedItem(noneCustomer);
			}
		}
		
		this.setVisible(true);
		getRootPane().setDefaultButton(btnSave);
	}
	
	private void InitComponents() {
		panel.setLayout(null);
		getContentPane().add(panel);
		
		lbTitle.setBounds(15, 10, 34, 13);
		panel.add(lbTitle);
		
		tfTitle.setEditable(false);
		tfTitle.setBounds(92, 10, 156, 19);
		panel.add(tfTitle);
		
		lbLendCustomer.setBounds(15, 42, 75, 13);
		panel.add(lbLendCustomer);
		
		comboBox.setBounds(92, 42, 156, 21);
		panel.add(comboBox);
		
		btnSave.setBounds(191, 73, 83, 21);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {

				for (Customer c : customers) {
					if (c.equals(comboBox.getSelectedItem())) {
						if (c.getId() == -1) {
							borrower = null;
						} else {
							borrower = c;
						}
					}
				}
				dispose();
			}
		});
		panel.add(btnSave);
	}
	
	public JTextField getTfTitle() {
		return tfTitle;
	}

	public void setTfTitle(JTextField tfTitle) {
		this.tfTitle = tfTitle;
	}

	public Customer getBorrower() {
		return borrower;
	}

	public void setBorrower(Customer borrower) {
		this.borrower = borrower;
	}
}
