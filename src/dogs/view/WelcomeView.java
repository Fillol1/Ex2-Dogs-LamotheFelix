package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dogs.controller.IWelcomeController;
import util.image.ImageUtil;

public class WelcomeView extends JFrame implements IView, ActionListener {   // Configurer Eclipse pour ignorer les avertissements sur serial Id
	
	private static final String VIEW_TITLE = "Nos amis les chiens";
	private static final String ADD_DOG_BUTTON_LABEL = "Inscrire un chien";
	private static final String WELCOME_MESSAGE = "Bienvenue !";
	private static final String ADD_DOG_BUTTON_ACTION = "ADD_DOG";
	private static final String LIST_DOG_BUTTON_LABEL = "Liste des chiens...";
	private static final String LIST_DOG_BUTTON_ACTION = "LIST_DOG";
	
	private static final String WELCOME_PICTURE = "../resource/dog.jpg";

	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	
	private IWelcomeController controller;		// Pas encore utilis� dans cette version...
	
	public WelcomeView(IWelcomeController controller) {
		super(VIEW_TITLE);
		
		this.controller = controller;
		
		this.initialize();
		this.setUpComponents();
	}
	
	@Override
	public void display() {
		this.setVisible(true);
	}
	
	private void initialize() {
		// setSize(): uniquement car JFrame avec une image - Ne pas utiliser avec les gestionnaires de mise en forme-Utiliser la m�thode pack() � la place
		this.setSize(DEFAULT_SIZE);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// par d�faut: HIDE_ON_CLOSE
	}
	
	private void setUpComponents() {
		//this.setLayout(new BorderLayout());  					// Inutile car par d�faut...
		this.setUpWelcomePanel();
		this.setUpActionPanel();
	}

	private void setUpWelcomePanel() {
		JPanel welcomePanel = new JPanel();
		this.add(welcomePanel, BorderLayout.CENTER);  // CENTER -> par d�faut

		welcomePanel.setLayout(new BorderLayout());   // Strategy pattern: le gestionnaire de mise en forme		
		addWelcomePicture(welcomePanel);		
		addWelcomeMessage(welcomePanel);		
	}

	private void addWelcomeMessage(JPanel welcomePanel) {
		JLabel welcomeMessage = new JLabel(WELCOME_MESSAGE, SwingConstants.CENTER);
		welcomePanel.add(welcomeMessage, BorderLayout.NORTH);
	}

	private void addWelcomePicture(JPanel welcomePanel) {
		ImageIcon image = ImageUtil.getImageIcon(this, WELCOME_PICTURE);
		JLabel welcomePicture = new JLabel(image);		
		welcomePanel.add(welcomePicture, BorderLayout.CENTER);   // CENTER -> par d�faut
	}

	private void setUpActionPanel() {
		JPanel actionPanel = new JPanel();
		this.add(actionPanel, BorderLayout.SOUTH);
		
		JButton addDogButton = new JButton(ADD_DOG_BUTTON_LABEL);
		addDogButton.addActionListener(this);
		addDogButton.setActionCommand(ADD_DOG_BUTTON_ACTION);
		actionPanel.add(addDogButton);
		
		JButton ListDogButton = new JButton(LIST_DOG_BUTTON_LABEL);
		ListDogButton.addActionListener(this);
		ListDogButton.setActionCommand(LIST_DOG_BUTTON_ACTION);
		actionPanel.add(ListDogButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == ADD_DOG_BUTTON_ACTION) {
			this.controller.wantToCreateDog();
		}
		else if(e.getActionCommand() == LIST_DOG_BUTTON_ACTION) {
			this.controller.goToList();
		}
		
	}


}
