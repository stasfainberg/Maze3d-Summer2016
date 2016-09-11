package controller;

import model.Model;
import view.View;



/**
 * <h1>Controller</h1>
 * @author Stas Fainberg
 * @version 1.0
 */
public interface Controller {
	
	void setModel(Model model);
	void setView(View view);
	void displayMessage(String message);
	void generateCommands();
	
	
	
}

