package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UiCustomer extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel panel = new JPanel();
	private JLabel firstNameLabel = new JLabel("First name:");
	private JLabel lastNameLabel = new JLabel("Last name:");
	private JLabel mailLabel = new JLabel("Mail:");
	private JLabel phoneLabel = new JLabel("Phone:");
	private JTextField firstNameField = new JTextField("", 20);
	private JTextField lastNameField = new JTextField("", 20);
	private JTextField mailField = new JTextField("", 20);
	private JTextField phoneField = new JTextField("", 20); 
	private JButton btnSave = new JButton("Add");
	
	public UiCustomer() {
		super();
		setModal(true);
		this.setTitle("New customer");
		this.setSize(270, 180);
		this.setResizable(false);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		InitComponents();
		
		this.setVisible(true);
		getRootPane().setDefaultButton(btnSave);
	}
	
	private void InitComponents() {
		btnSave.setBounds(138, 120, 103, 21);

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				dispose();
			}
		});
		
		panel.setLayout(null);
		
		firstNameLabel.setBounds(10, 8, 70, 13);
		panel.add(firstNameLabel);
		firstNameField.setBounds(76, 8, 166, 19);
		panel.add(firstNameField);
		lastNameLabel.setBounds(10, 32, 70, 13);
		panel.add(lastNameLabel);
		lastNameField.setBounds(76, 32, 166, 19);
		panel.add(lastNameField);
		mailLabel.setBounds(10, 61, 56, 13);
		panel.add(mailLabel);
		mailField.setBounds(76, 61, 166, 19);
		panel.add(mailField);
		phoneLabel.setBounds(10, 94, 56, 13);
		panel.add(phoneLabel);
		phoneField.setBounds(76, 94, 166, 19);
		panel.add(phoneField);
		panel.add(btnSave);
		getContentPane().add(panel);
	}

	public String getFirstName() {
		return firstNameField.getText();
	}

	public void setFirstName(String firstName) {
		this.firstNameField.setText(firstName);
	}

	public String getLastName() {
		return lastNameField.getText();
	}

	public void setLastName(String lastName) {
		this.lastNameField.setText(lastName);
	}

	public String getMail() {
		return mailField.getText();
	}

	public void setMail(String mail) {
		this.mailField.setText(mail);
	}

	public String getPhone() {
		return phoneField.getText();
	}

	public void setPhone(String phone) {
		this.phoneField.setText(phone);
	}
}
