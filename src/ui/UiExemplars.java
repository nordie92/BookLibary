package ui;

import java.awt.GridLayout;
import java.util.List;
import javax.swing.*;
import models.*;

public class UiExemplars extends JList<Exemplar> {
	private static final long serialVersionUID = 1L;
	private DefaultListModel<Exemplar> model;

	public UiExemplars() {

		this.setLayout(new GridLayout(0, 1));

		model = new DefaultListModel<>();
		this.setModel(model);
	}
	
	public void setExemplars(List<Exemplar> exemplars) {
		model = new DefaultListModel<>();
		this.setModel(model);
		for (Exemplar exemplar : exemplars) {
			model.addElement(exemplar);
		}
	}
	
	public void add(Exemplar exemplar) {
		model.addElement(exemplar);
	}
}
