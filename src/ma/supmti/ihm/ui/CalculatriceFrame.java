package ma.supmti.ihm.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ma.supmti.ihm.events.CalculListener;
import ma.supmti.ihm.events.EcritureListener;
import ma.supmti.ihm.utils.FrameUtils;

public class CalculatriceFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CalculatriceButton[] buttons = new CalculatriceButton[] {
			new CalculatriceButton("1",0,1),
			new CalculatriceButton("2",1,1),
			new CalculatriceButton("3",2,1),
			new CalculatriceButton("+",3,1,2,0),
			new CalculatriceButton("4",0,2),
			new CalculatriceButton("5",1,2),
			new CalculatriceButton("6",2,2),
			new CalculatriceButton("7",0,3),
			new CalculatriceButton("8",1,3),
			new CalculatriceButton("9",2,3),
			new CalculatriceButton("-",3,3,2,0),
			new CalculatriceButton("0",0,4),
			new CalculatriceButton("=",1,4,0,2)};
	
	public JTextField input = new JTextField();

	public CalculatriceFrame() {
		// Initialiser les properties de la fenetre
		this.initFrameProperties();
		
		// Initialiser les composants
		this.initComponents();
		
		// Initialiser les events
		this.initEvents();
	}
	
	private void initEvents() {
		for (CalculatriceButton button : buttons) {
			if("=".equals(button.button.getText())) {
				button.button.addActionListener(new CalculListener(this));
			} else {
				button.button.addActionListener(new EcritureListener(this));
			}
			
		}
	}

	private void initFrameProperties() {
		// Titre
		this.setTitle("Calculatrice");
		
		// Position et dimention
		this.setSize(250, 240);
		FrameUtils.centreWindow(this);
		
		// Terminer le programme en cas de fermeture de cette fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Rendre impossible de redimensionner la fenetre
		this.setResizable(false);
		
		// Rendre la fenetre visible
		this.setVisible(true);
	}

	
	private void initComponents() {
		GridBagLayout myLayout = new GridBagLayout();
		this.setLayout(myLayout);
		
		GridBagConstraints c = new GridBagConstraints(); 
		c.insets = new Insets(5,5,5,5); 
		
		/************* Champ input disabled ****************/
		c.gridy = 0;
		c.gridwidth = 5;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// Aligner le texte à droite
		input.setHorizontalAlignment(SwingConstants.RIGHT);
		input.setBackground(Color.white);
		// Rendre impossible l'ecriture dans le champ texte
		input.setEditable(false);
				
		this.add(input, c);
		/***************************************************/ 
		
		for(CalculatriceButton button : buttons) {
			c.gridy = button.y_pos;
			c.gridx = button.x_pos;
			if(button.height != 0) {
				c.gridheight = button.height;
				c.fill = GridBagConstraints.VERTICAL;
			} else {
				c.gridheight = 1;
				c.fill = GridBagConstraints.BOTH;
			}
			
			if(button.width != 0) {
				c.gridwidth = button.width;
				c.fill = GridBagConstraints.HORIZONTAL;
			} else {
				c.gridwidth = 1;
				c.fill = GridBagConstraints.BOTH;
			}
			
			this.add(button.button, c);
		}
	}
}
