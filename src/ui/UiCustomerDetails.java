package ui;

import java.awt.Color;

import javax.swing.*;

public class UiCustomerDetails extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextPane firstNamePane;
	private JTextPane lastNamePane;
	private JTextPane mailPane;
	private JTextPane phonePane;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField mailField;
	private JTextField phoneField;
	
	public UiCustomerDetails() {
		this.setLayout(null);
		this.setBounds(0, 0, 200, 200);
		
		firstNamePane = new JTextPane();
		lastNamePane = new JTextPane();
		mailPane = new JTextPane();
		phonePane = new JTextPane();
		firstNameField = new JTextField();
		lastNameField = new JTextField();
		mailField = new JTextField();
		phoneField = new JTextField();

		firstNamePane.setBounds(10,  10, 200, 22);
		lastNamePane.setBounds(10,  60, 200, 22);
		mailPane.setBounds(10,  110, 200, 22);
		phonePane.setBounds(10,  160, 200, 22);
		firstNameField.setBounds(10,  32, 200, 22);
		lastNameField.setBounds(10,  82, 200, 22);
		mailField.setBounds(10,  132, 200, 22);
		phoneField.setBounds(10,  182, 200, 22);

		firstNameField.setEditable(false);
		lastNameField.setEditable(false);
		mailField.setEditable(false);
		phoneField.setEditable(false);

		firstNamePane.setText("First name");
		lastNamePane.setText("Last name");
		mailPane.setText("Mail");
		phonePane.setText("Phone");
		
		firstNamePane.setEditable(false);
		lastNamePane.setEditable(false);
		mailPane.setEditable(false);
		phonePane.setEditable(false);
		
		firstNamePane.setBackground(Color.LIGHT_GRAY);
		lastNamePane.setBackground(Color.LIGHT_GRAY);
		mailPane.setBackground(Color.LIGHT_GRAY);
		phonePane.setBackground(Color.LIGHT_GRAY);
		
		this.add(firstNamePane);
		this.add(lastNamePane);
		this.add(mailPane);
		this.add(phonePane);
		
		this.add(firstNameField);
		this.add(lastNameField);
		this.add(mailField);
		this.add(phoneField);
	}

	public String getFirstNameField() {
		return firstNameField.getText();
	}

	public void setFirstName(String firstName) {
		this.firstNameField.setText(firstName);
	}

	public String getLastNameField() {
		return lastNameField.getText();
	}

	public void setLastName(String lastName) {
		this.lastNameField.setText(lastName);
	}

	public String getMailField() {
		return mailField.getText();
	}

	public void setMail(String mail) {
		this.mailField.setText(mail);
	}

	public String getPhoneField() {
		return phoneField.getText();
	}

	public void setPhone(String phone) {
		this.phoneField.setText(phone);
	}
}
