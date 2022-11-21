package ma.supmti.ihm.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ma.supmti.ihm.ui.CalculatriceFrame;

public class EcritureListener implements ActionListener {

	private CalculatriceFrame calculatrice;

	public EcritureListener(CalculatriceFrame calculatrice) {
		this.calculatrice = calculatrice;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// La source de l'evenement
		JButton source = (JButton) e.getSource();
		// Copier le text du bouton source sur l'ecran de la calculatrice
		calculatrice.input.setText(calculatrice.input.getText() + source.getText());

	}

}
