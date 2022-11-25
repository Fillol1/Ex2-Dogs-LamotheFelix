package dogs.model;

import java.awt.GridLayout;
import java.util.Collection;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DogConverter {
	
	Collection<Dog> dogs;
	public DogConverter(Collection<Dog> collections) {
		this.dogs = collections;
	}
	public int getSize() {
		// TODO Auto-generated method stub
		return dogs.size();
	}
	public void getDog(JPanel dogCreatePanel, GridLayout constraints) {
		// TODO Auto-generated method stub
		for(Dog dog: dogs) {
            dogCreatePanel.add(createNewJPanel(Integer.toString(dog.getId())), constraints);;
            dogCreatePanel.add(createNewJPanel(dog.getName()), constraints);
            dogCreatePanel.add(createNewJPanel(dog.getBreed()), constraints);
        }
	}
	
	private JLabel createNewJPanel(String text) {
		// TODO Auto-generated method stub
		JLabel label = new JLabel(text);
		return label;
	}
	
	
}
