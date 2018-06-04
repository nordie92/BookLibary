package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UiBook extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel panel = new JPanel();
	private JLabel lbISBN = new JLabel("ISBN:");
	private JLabel lbTitle = new JLabel("Titel:");
	private JLabel lbAutor = new JLabel("Autor:");
	private JLabel lbGenre = new JLabel("Genre:");
	private JTextField tfISBN = new JTextField("", 20);
	private JTextField tfTitle = new JTextField("", 20);
	private JTextField tfAutor = new JTextField("", 20);
	private JTextField tfGenre = new JTextField("", 20); 
	private JButton btnSave = new JButton("Add");
	
	public UiBook() {
		super();
		setModal(true);
		this.setTitle("New book");
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
		
		lbISBN.setBounds(10, 8, 56, 13);
		panel.add(lbISBN);
		tfISBN.setBounds(76, 8, 166, 19);
		panel.add(tfISBN);
		lbTitle.setBounds(10, 32, 56, 13);
		panel.add(lbTitle);
		tfTitle.setBounds(76, 32, 166, 19);
		panel.add(tfTitle);
		lbAutor.setBounds(10, 61, 56, 13);
		panel.add(lbAutor);
		tfAutor.setBounds(76, 61, 166, 19);
		panel.add(tfAutor);
		lbGenre.setBounds(10, 94, 56, 13);
		panel.add(lbGenre);
		tfGenre.setBounds(76, 94, 166, 19);
		panel.add(tfGenre);
		panel.add(btnSave);
		getContentPane().add(panel);
	}
	
	public JTextField getTfISBN() {
		return tfISBN;
	}

	public void setTfISBN(JTextField tfISBN) {
		this.tfISBN = tfISBN;
	}

	public JTextField getTfTitle() {
		return tfTitle;
	}

	public void setTfTitle(JTextField tfTitle) {
		this.tfTitle = tfTitle;
	}

	public JTextField getTfAutor() {
		return tfAutor;
	}

	public void setTfAutor(JTextField tfAutor) {
		this.tfAutor = tfAutor;
	}

	public JTextField getTfGenre() {
		return tfGenre;
	}

	public void setTfGenre(JTextField tfGenere) {
		this.tfGenre = tfGenere;
	}
}
