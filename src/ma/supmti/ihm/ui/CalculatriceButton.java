package ma.supmti.ihm.ui;

import javax.swing.JButton;

public class CalculatriceButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x_pos;
	int y_pos;
	int height;
	int width;
	
	public CalculatriceButton(String label, int x_pos, int y_pos, int height, int width) {
		super(label);
		this.x_pos = x_pos;
		this.y_pos = y_pos;
		this.height = height;
		this.width = width;
	}

	public CalculatriceButton(String label, int x_pos, int y_pos) {
		super(label);
		this.x_pos = x_pos;
		this.y_pos = y_pos;
	}
	
	
}
