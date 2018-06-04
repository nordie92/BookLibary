package ui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class UiBookAndExeplarContainer extends JPanel {
	private static final long serialVersionUID = 1L;

	public UiBookAndExeplarContainer(UiBookDetails bookDetails, UiExemplars exeplars) {
		this.setLayout(new GridLayout(2, 1));
		this.add(bookDetails);
		this.add(new JScrollPane(exeplars));
	}
}
