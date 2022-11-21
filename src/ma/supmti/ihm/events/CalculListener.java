package ma.supmti.ihm.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ma.supmti.ihm.ui.CalculatriceFrame;

public class CalculListener implements ActionListener {
	
	private CalculatriceFrame calculatrice;

	public CalculListener(CalculatriceFrame calculatrice) {
		this.calculatrice = calculatrice;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = this.calculatrice.input.getText();
		if (!"".equals(text)) {
			String operators[]= text.split("[0-9]+");
		    String operands[]= text.split("[+-]");
		    int agregate = Integer.parseInt(operands[0]);
		    for(int i=1;i<operands.length;i++){
		        if(operators[i].equals("+"))
		            agregate += Integer.parseInt(operands[i]);
		        else 
		            agregate -= Integer.parseInt(operands[i]);
		    }
		    this.calculatrice.input.setText(agregate+"");
		}
		
	}
}
