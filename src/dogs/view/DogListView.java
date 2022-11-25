package dogs.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import dogs.model.DogConverter;

public class DogListView extends JDialog implements IView, ActionListener{

	private static final String RETURN_MENU_ACTION = "return to menu";
	private static final String VIEW_TITLE = "Show List of dog";
	private JLabel ID = new JLabel("ID");
    private JLabel NOM = new JLabel("NOM");
    private JLabel RACE = new JLabel("RACE");
    DogConverter converter;
	public DogListView(DogConverter converter) {
		// TODO Auto-generated constructor stub
		this.converter = converter;
		this.initialize();
		this.setUpComponents();
		this.pack();
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}
	
	private void initialize() {
		this.setTitle(VIEW_TITLE);		
		this.setModalityType(DEFAULT_MODALITY_TYPE);
	}
	
	private void setUpComponents() {
		this.setUpInputDataPanel();	
	}

	private void setUpInputDataPanel() { //converter, repository, controller, dog
		
		JPanel dogCreatePanel = new JPanel();
		this.add(dogCreatePanel, BorderLayout.CENTER);
		
		GridLayout constraints = new GridLayout(0, 3 , 100 , 0);
		dogCreatePanel.setLayout(constraints);
       
        dogCreatePanel.add(ID, constraints);
        dogCreatePanel.add(NOM, constraints);
        dogCreatePanel.add(RACE, constraints);
        
        converter.getDog(dogCreatePanel, constraints);
        
        dogCreatePanel.add(new JLabel(), constraints);
        dogCreatePanel.add(addButton(dogCreatePanel, "ok", RETURN_MENU_ACTION), constraints);
	}

	// même méthode que dans WelcomeView
	// DRY -> méthode utilitaire à extraire dans une classe utilitaire util.view.ViewUtil 
	private JButton addButton(JPanel actionPanel, String buttonText, String buttonAction) {   
		// Pour ajouter un bouton au panel	
		JButton okButton = new JButton(buttonText);
		okButton.addActionListener(this);
		okButton.setActionCommand(buttonAction);
		actionPanel.add(okButton);
		return okButton;
	}
	
	private void returnToMenu() {
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// intercepter l'événement sur le bouton Inscrire et appeler la méthode createDog
		if(e.getActionCommand() == RETURN_MENU_ACTION) {
			returnToMenu();
		}
	}
}
